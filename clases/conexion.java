package clases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josegonzalez
 */
public class conexion {
    Connection conn = null;
 
    public conexion(){
    
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mudandote","root","");
             if(conn!=null){
                 System.out.println("Conecto a base de datos matrix");
                 //   variables.setUser(true);
                  //  variables.setPas(true);
             }
        }catch(SQLException | ClassNotFoundException e){
        System.out.println(e);
        System.out.println("No conecto la base de datos");
        // variables.setUser(false);
       // variables.setPas(false);
     
        }
    
    }
    public Connection getConnection()
    {
    return conn;
    }
    public void desconectar(){
        conn=null;
    }
    
}
