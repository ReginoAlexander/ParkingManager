
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

/**
 *
 * @author regin
 */
public class bdConn {
    
    public static Connection conn;
    
    public bdConn(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","rubick2006");
        } catch (Exception e){
            System.err.println("No se pudo establecer la conexion con la base de datos parking. Error: "+e);
        }
    }
    
    public  static Connection getConnection(){
        return conn;
    }
    

}
