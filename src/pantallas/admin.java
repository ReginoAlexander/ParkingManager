/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pantallas;

import config.bdConn;
import static config.bdConn.conn;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class admin extends javax.swing.JPanel {

    Connection connect;
    Statement st;
    ResultSet rs;
    PreparedStatement pstmt;
    public static Double nuevoPrecio;
    public static String[] dias = new String[7];
    public static int[] count = new int[7];
    public static double[] ganancias = new double[7];
    public static double pago=0;
    public static boolean obtenerVehiculos;
    public static boolean obtenerGanancias;
    
    public String titulo=null;
    public double data[];
    public String tipo=null;
    
    public admin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgAdmin = new javax.swing.JPanel();
        selector = new javax.swing.JComboBox<>();
        calendario = new com.toedter.calendar.JDateChooser();
        btnReporte = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtCosto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        bgAdmin.setBackground(new java.awt.Color(244, 244, 244));

        selector.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        selector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reporte de vehiculos", "Reporte de ingresos", " " }));

        calendario.setDateFormatString("d MMM yyyy");

        btnReporte.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnReporte.setText("Ver reporte");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtCosto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Pago por hora");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reporte semanal de ingresos/vehiculos");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Panel del administrador");

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgAdminLayout = new javax.swing.GroupLayout(bgAdmin);
        bgAdmin.setLayout(bgAdminLayout);
        bgAdminLayout.setHorizontalGroup(
            bgAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgAdminLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel2)
                .addGap(63, 63, 63)
                .addComponent(txtCosto)
                .addGap(63, 63, 63)
                .addComponent(jButton2)
                .addGap(122, 122, 122))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgAdminLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgAdminLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReporte)
                .addGap(64, 64, 64))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgAdminLayout.setVerticalGroup(
            bgAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgAdminLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addGroup(bgAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(77, 77, 77)
                .addGroup(bgAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgAdminLayout.createSequentialGroup()
                        .addGroup(bgAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReporte))
                        .addGap(57, 57, 57)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        for(int i =0;i<7;i++){
            ganancias[i]=0;
            count[i]=0;
        }

        jPanel1.revalidate();
        jPanel1.repaint();
        obtenerVehiculos=false;
        obtenerGanancias=false;
        obtenerSemana();
        String itemSeleccionado = (String)selector.getSelectedItem();
        System.out.println("\nCREANDO GRAFICA PARA :"+itemSeleccionado);
        if(itemSeleccionado.equals("Reporte de vehiculos")){
            obtenerVehiculos=true;
            obtenerGanancias=false;
            obtenerVehiculos();
        }else{
            if(itemSeleccionado.equals("Reporte de ingresos")){
                obtenerVehiculos=false;
                obtenerGanancias=true;
                obtenerGanancias();
                System.out.println("/////////////REPORTE DE INGRESOS");
            }

        }

        crearGrafica();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nuevoPreciotxt= txtCosto.getText();

        nuevoPrecio= Double.parseDouble(nuevoPreciotxt);
        nuevoPrecio=nuevoPrecio/60;
        metodos.actualizarPrecio();
        JOptionPane.showMessageDialog(null, "Nuevo precio fijado");
        txtCosto.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed
        void obtenerSemana(){
            Date fecha = calendario.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dia = sdf.format(fecha); 
            System.out.print("\nDIA SELECCIONADO: "+dia+"\n");     

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);

            int diaSemana = calendar.get(calendar.DAY_OF_WEEK);
            calendar.add(Calendar.DAY_OF_MONTH, Calendar.MONDAY - diaSemana);

            for(int i=0;i<7;i++){
                dias[i]=sdf.format(calendar.getTime());
                System.out.println("DIA "+(i)+" "+dias[i]);
                calendar.add(Calendar.DAY_OF_MONTH, 1);
               
            }
        }
     
    public int obtenerVehiculos(){
        //StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM parkingappdb WHERE horaEntrada ");
        for(int i=0;i<7;i++){
            String sql = "SELECT COUNT(*) FROM parkingappdb WHERE horaEntrada LIKE '%"+dias[i]+"%'";

            System.out.println(sql);
            try{
                connect= bdConn.getConnection();
                pstmt = connect.prepareStatement(sql);
                rs= pstmt.executeQuery();
                System.out.println("----------------");
                
                if(rs.next()){
                    System.out.println("------oooo----------");
                    count[i] = rs.getInt(1);
                    System.out.println("Conteo para el dia "+dias[i]+" :"+count[i]);
                }
            }catch(SQLException e){e.printStackTrace();}
        }
        
    return 0;
    }
    
    public float obtenerGanancias(){
        
        for(int i=0;i<7;i++){
            String sql = "SELECT pago FROM parkingappdb WHERE horaSalida LIKE '%"+dias[i]+"%'";
            System.out.println(sql);
            
            try{
                connect=bdConn.getConnection();
                pstmt=connect.prepareStatement(sql);
                rs=pstmt.executeQuery();
                
                while(rs.next()){
                    ganancias[i]+=rs.getDouble(1);
                    System.out.println("GANANCIAS DEL DIA "+i+" "+ganancias[i]);
                }
                System.out.println("----------------");
                
            }catch(SQLException e){e.printStackTrace();}            
        }
        return 0;
    }
    
    public void crearGrafica(){
        
        jPanel1.removeAll();
        String[] diasSemana = new String[] {
            "LUNES",
            "MARTES",
            "MIERCOLES",
            "JUEVES",
            "VIERNES",
            "SABADO",
            "DOMINGO"
        };
        
        if(obtenerVehiculos){
            titulo="VEHICULOS INGRESADOS EN LA SEMANA";
            data= new double[7];
            for(int i=0;i<7;i++){
                data[i]=count[i];
            }
            tipo="VEHICULOS";
            
        }else{
            if(obtenerGanancias){
                titulo="INGRESOS DE LA SEMANA";
                data=ganancias;
                tipo="GANANCIAS";
            }
        }
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for(int i=0;i<7;i++){
            datos.setValue(data[i],tipo,diasSemana[i]);
        }        
        
        JFreeChart grafica = ChartFactory.createBarChart(
        titulo,
        "DIAS",
        tipo,
        datos,
        PlotOrientation.VERTICAL,
        true,
        true,
        false
        );
        
        ChartPanel panel = new ChartPanel(grafica);
        
        panel.setPreferredSize(new Dimension(600,269));
        
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(panel,BorderLayout.NORTH);
        
        revalidate();
        repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgAdmin;
    private javax.swing.JButton btnReporte;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> selector;
    private javax.swing.JTextField txtCosto;
    // End of variables declaration//GEN-END:variables
}
