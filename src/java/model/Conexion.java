/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
public class Conexion {
    
    public static Connection conectarse(String login, String password) throws Exception{
        String url="jdbc:oracle:thin:@localhost:1521/xe";
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con=DriverManager.getConnection(url,"system","system");
        return con;
    }
    

    
}