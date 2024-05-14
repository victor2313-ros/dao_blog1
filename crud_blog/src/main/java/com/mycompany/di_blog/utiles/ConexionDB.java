
package com.mycompany.di_blog.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static public String url = "jdbc:mysql://localhost:3306/bd_blog";
    static public String usuario = "root";
    static public String password = "";
    
    protected Connection conn=null;

    public ConexionDB() {
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
            
            conn = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("conexion exitosa: "+conn);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection Conectar(){
        return conn;
    }
    
    public void Desconectar(){
        System.out.println("Desconectando... "+conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
