/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nepo
 */


import java.sql.*;   
import java.util.*;
import org.codehaus.jackson.map.ObjectMapper;
public class PersistenciaBuscar {

    public static String buscarTodos() throws Exception{    
        
        Connection con=Conexion.conectarse("system","system");
        
             Statement st=con.createStatement();
             
             ResultSet res=st.executeQuery("select * from persona");  
             System.out.println("depues del select");
             int indice=0;
             ArrayList<Persona> personas=new ArrayList<Persona>();
             while(res.next()){   
                                   Integer id=  res.getInt(1);     
                                   String nombre=res.getString(2);
                                   String empresa=res.getString(3);
                                   Integer edad=res.getInt(4);
                                   String telefono=res.getString(5);
                                  
                      personas.add(new Persona(id,nombre,empresa,edad,telefono));
                      
                      System.out.println("estoy en el array list despues del select");
             }
             
             
             ObjectMapper maper=new ObjectMapper();   
             st.close();
             con.close();
             System.out.println("convirtiendo el json");
             return maper.writeValueAsString(personas);
             
    }

    public static boolean buscarporId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}

