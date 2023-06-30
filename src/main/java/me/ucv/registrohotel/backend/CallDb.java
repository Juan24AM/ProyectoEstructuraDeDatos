/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ucv.registrohotel.backend;

import java.sql.Connection;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Daysuke
 */
public class CallDb {
    
    Connection conector;
    final String url = "jdbc:mysql://192.168.1.1:3306/hotelregistro";
    final String driver = "com.mysql.cj.jdbc.Driver";
    Dotenv dotenv = null;
    String DB_USER;
    String DB_PASSWD;
    
    public void cargarVariables(){
        try{
            dotenv = Dotenv.configure().load();
            DB_USER = dotenv.get("MYSQL_USER");
            DB_PASSWD = dotenv.get("MYSQL_PASSWORD");
        }catch (DotenvException e) {
            System.out.println("Error de paquete DOT ENV"+e);
        }
    }
     public Connection getConnection() throws SQLException, ClassNotFoundException{
        cargarVariables();
        if (conector == null){
            try {
                Class.forName(driver);
                conector = DriverManager.getConnection(url,DB_USER,DB_PASSWD);                
         } catch (SQLException ex) {
                System.out.println("Ocurrió un error al conectar la base de datos. ");
                System.out.println(ex);
         }
        }
        return conector;
    }
}
