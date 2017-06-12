package model;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author IVAN NEPOMUCENO LEON
 */
public class TestProcedimiento {
    public static void main(String args[])throws Exception{
        Conexion c=new Conexion();
        Connection con=c.conectarse("system","system");
        CallableStatement ingresar=con.prepareCall("{call guardar_persona(?,?,?,?,?)}");
        ingresar.registerOutParameter(1,java.sql.Types.INTEGER);
        ingresar.setString(2,"Ivan ");
        ingresar.setString(3,"infosist");
        ingresar.setInt(4,21);
        ingresar.setString(5,"55-25-77-46-59");
      
        ingresar.execute();
        int pk=ingresar.getInt(1);
        System.out.println("El id ingresado es:"+pk);
    }
    
}
