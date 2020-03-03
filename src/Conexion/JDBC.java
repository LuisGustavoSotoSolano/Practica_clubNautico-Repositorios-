/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lv1013
 */
public class JDBC {
       String cadenaConexion = "jdbc:mysql://localhost/club_nautico";
       Connection conexion;
    
    public JDBC(){
        try {
            conexion = DriverManager.getConnection(cadenaConexion, "root", "1234");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    
    
}
