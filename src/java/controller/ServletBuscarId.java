/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conexion;
import model.PersistenciaBuscar;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Nepo
 */
public class ServletBuscarId extends HttpServlet {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miriam
 */
public class ServletBuscaID extends HttpServlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int id= Integer.parseInt(request.getParameter("id"));
      
        try{
   
      System.out.println(PersistenciaBuscar.buscarporId(id));
        out.println(PersistenciaBuscar.buscarporId(id));
        }catch(Exception e){
        System.out.println("este se tiene que ver"+e.getMessage());  //invocaremos la exception
    }
}

}


}
