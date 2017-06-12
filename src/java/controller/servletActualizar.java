/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nepo
 */
public class servletActualizar extends HttpServlet {
/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        int id= Integer.parseInt(request.getParameter("id"));
       String nombre= request.getParameter("nombre");
       String empresa= request.getParameter("empresa");
       int edad= Integer.parseInt(request.getParameter("edad"));
       String telefono= request.getParameter("telefono");
       
        try{
        Conexion c=new Conexion();
        Connection con=c.conectarse("system","system");
     CallableStatement actu=con.prepareCall("{call ACTUALIZAR_PERSONA(?,?)}");  /// call y el nombre de tu procedimiento Y EL NUMERO DE PROCEDIMIENTOS QUE TENGAMOS
        
        actu.setInt(1,id);
        actu.setString(2,nombre);
        actu.setString(3, empresa);///tantos campos como se necesiten de nuestro proyecto de los my_ y respetrando su tipo de dato
        actu.setInt(4,edad);
        actu.setString(5,telefono);
        actu.execute();
       
        out.println("Se actualizo el precio  del libro");
        }catch(Exception e){
        out.println(e.getMessage());  //invocaremos la exception
    }
}

 
}
