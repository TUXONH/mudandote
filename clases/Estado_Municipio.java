package clases;


import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo Delfin
 */
import clases.conexion;
public class Estado_Municipio {
    
  
    public static void items(JTextField txtArticulos)
    {
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(txtArticulos);
        
        conexion con = new conexion();
        int registro = 0;
        
         try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM aticulos");
           ResultSet res = pstm.executeQuery();
           res.next();
           registro = res.getInt("total");
           System.out.println(registro);
           res.close();
                   
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
       }
         
          try
       {
       Object[][] datos = new String[registro][4];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT Descripcion FROM aticulos");
         ResultSet res = pstm.executeQuery();
         int i =0;
         
         while(res.next())
         {
           
             textAutoCompleter.addItem(res.getString("Descripcion"));
             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
        
    }
    
     public static void itemsCombo(JComboBox ComboEstado)
    {
        conexion con = new conexion();
        int registro = 0;
        
         try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM estados");
           ResultSet res = pstm.executeQuery();
           res.next();
           registro = res.getInt("total");
           System.out.println(registro);
           res.close();
                   
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
       }
         
          try
       {
       Object[][] datos = new String[registro][4];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT Nombre FROM estados");
         ResultSet res = pstm.executeQuery();
         int i =0;
         
         while(res.next())
         {
            
             ComboEstado.addItem(res.getString("Nombre"));

             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
    }
     
    public static void itemsCombo3(String condi,JComboBox ComboMunicipio,JTextField txtCveMunicipio)
    {
     
        conexion con = new conexion();
        int registro = 0;
        
         try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM municipios where Poblacion='"+condi+"'");
           ResultSet res = pstm.executeQuery();
           res.next();
           registro = res.getInt("total");
           System.out.println(registro);
           res.close();
                   
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
       }
         
         
          try
       {
       Object[][] datos = new String[registro][4];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT id_Municipio FROM municipios where Poblacion='"+condi+"'");
         ResultSet res = pstm.executeQuery();
         int i =0;
         
         while(res.next())
         {
            
            
            txtCveMunicipio.setText(res.getString("id_Municipio"));
            //JOptionPane.showMessageDialog(null, res.getString("id_Municipio"));
             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
    }
     
     
      public static void itemsCombo2(String condi,JComboBox ComboMunicipio, JTextField txtCveEstado,JTextField txtCveMunicipio)
    {
     
        conexion con = new conexion();
        int registro = 0;
        
         try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM estados where Nombre='"+condi+"'");
           ResultSet res = pstm.executeQuery();
           res.next();
           registro = res.getInt("total");
           System.out.println(registro);
           res.close();
                   
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
       }
         
         
          try
       {
       Object[][] datos = new String[registro][4];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT id_estado FROM estados where Nombre='"+condi+"'");
         ResultSet res = pstm.executeQuery();
         int i =0;
         
         while(res.next())
         {
            
             Encapsuladas.setMunicipio(res.getString("id_estado"));
            txtCveEstado.setText(res.getString("id_estado"));

             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
        
           registro = 0;
        
         try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM municipios where id_estado='"+Encapsuladas.getMunicipio()+"'");
           ResultSet res = pstm.executeQuery();
           res.next();
           registro = res.getInt("total");
           System.out.println(registro);
           res.close();
                   
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
       }
         
            try
       {
       Object[][] datos = new String[registro][4];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT Poblacion FROM municipios where id_estado='"+Encapsuladas.getMunicipio()+"'");
         ResultSet res = pstm.executeQuery();
         int i =0;
         
         while(res.next())
         {
            
             //Encapsuladas.setMunicipio(res.getString("Nombre"));
             ComboMunicipio.addItem(res.getString("Poblacion"));
             

             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
    }
      
      
     
      
      
     public static void ComboViviendas(JComboBox ComboViviendas)
     {
          conexion con = new conexion();
        int registro = 0;
        
         try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM cattipovivienda");
           ResultSet res = pstm.executeQuery();
           res.next();
           registro = res.getInt("total");
           System.out.println(registro);
           res.close();
                   
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
       }
         
          try
       {
       Object[][] datos = new String[registro][4];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT Descripcion FROM cattipovivienda");
         ResultSet res = pstm.executeQuery();
         int i =0;
         
         while(res.next())
         {
            
             ComboViviendas.addItem(res.getString("Descripcion"));

             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
     }
     
     public static void CveVivienda(String condi,JTextField txtCveVivienda)
     {
         
         conexion con = new conexion();
        int registro = 0;
        
         try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM cattipovivienda where Descripcion='"+condi+"'");
           ResultSet res = pstm.executeQuery();
           res.next();
           registro = res.getInt("total");
           System.out.println(registro);
           res.close();
                   
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
       }
         
         
          try
       {
       Object[][] datos = new String[registro][4];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT CveTipoVivienda FROM cattipovivienda where Descripcion='"+condi+"'");
         ResultSet res = pstm.executeQuery();
         int i =0;
         
         while(res.next())
         {
            
           
             txtCveVivienda.setText(res.getString("CveTipoVivienda"));
            

             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
        
           
         
         
     }
    
}
