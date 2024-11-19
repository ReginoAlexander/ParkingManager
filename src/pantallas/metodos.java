/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import config.bdConn;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class metodos {
    
    static bdConn conn= new bdConn();
    static Connection connect;
    static ResultSet rs;
    static PreparedStatement st;
    
    
    public static Double precio;
    
    public static String obtenerFecha(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = fechaHoraActual.format(formatter);
        return fecha;        
    }
    
    public static void obtenerPrecio(){
        try{
            connect = conn.getConnection();
            String sql = "SELECT costo FROM costominuto WHERE id=1";
            st=connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                precio= rs.getDouble("costo");
                double precioPantalla= precio*60;
                ingresosalida.txtCosto.setText("COSTO POR HORA: $"+precioPantalla);
                System.out.print("Costo por minuto = "+precio);
           }
        }catch (Exception e){e.printStackTrace();}

    }
    
    public static void actualizarPrecio(){                //metodo que actualiza el precio en la base d datos
        try{
            connect = conn.getConnection();
            String sql = "UPDATE costominuto SET costo = ?";
            st=connect.prepareStatement(sql);
            st.setDouble(1, admin.nuevoPrecio);
            st.executeUpdate();

        }catch(Exception e){e.printStackTrace();}
        
    }
        
    public static void subirPago(){
        try{
            connect = conn.getConnection();
            String sql = "update parkingappdb set pago=? WHERE placa=?";
            st=connect.prepareStatement(sql);
            st.setDouble(1,ingresosalida.costoFinal);
            st.setString(2,ingresosalida.placa);
            st.executeUpdate();
                    
        }catch(Exception e){e.printStackTrace();}
    }
    
    public static void carpetaRecibos(){
        Path ruta = Paths.get("C:\\recibos");
        if(Files.notExists(ruta)){                                                      //METODO QUE VERIFICA SI EXISTE LA CARPETA RECIBOS, SI NO, LA CREA
            System.out.print("\nCARPETA DE RECIBOS NO EXISTE... CREANDO");
            try{
                Files.createDirectories(ruta);
            }catch (Exception e){}
        }
        else{
            System.out.print("\nCARPETA DE RECIBOS EXISTE");
        }
    }

    
}

