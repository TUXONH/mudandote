/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import UpperEssential.UpperEssentialLookAndFeel;
import clases.Encapsuladas;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableColumnModel;

/**
 *
 * @author danielandrademaglioni
 */
public class Main2 extends javax.swing.JFrame {
    String select=null;
    
    /**
     * Creates new form Main
     */
    
    public int tipo_maestra;
    public int tipo_Ventas;
    public String Ventas=Encapsuladas.getAuxVentas();
    String Maestra;
    String select1=null;  
    public Main2() 
    {
        initComponents();
        setLocationRelativeTo(null);
         //      Maestra=Encapsuladas.getAuxMaestra().toString();
          //Ventas =Encapsuladas.getAuxVentas();
          System.out.println(Ventas+"estas main");
         //        tipo_maestra=Integer.parseInt(Maestra);
         //        tipo_Ventas=Integer.parseInt(Ventas);
          String[] items={"Clientes", "Cotización", "Reservacion", "Unidades", "Choferes", "Articulos"};
          if(Ventas=="true")
        {
            cotizacion.setVisible(false);
            cotizacion.setVisible(false);
            jMenu2.setVisible(false);
            combo3.removeAllItems();
            for (int i =0; i<items.length; i++)
            combo3.addItem(items[i]);
        
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cotizacion = new org.edisoncor.gui.button.ButtonColoredAction();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        combo3 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        combo1 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        combo2 = new org.edisoncor.gui.comboBox.ComboBoxRound();
        reservacion1 = new org.edisoncor.gui.button.ButtonColoredAction();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Empresa = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Usuarios = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Clientes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Cotizaciones = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Reservaciones = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        Unidades = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1211, 458));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1211, 458));
        getContentPane().setLayout(null);

        cotizacion.setBackground(new java.awt.Color(51, 51, 51));
        cotizacion.setText("Reservacion");
        cotizacion.setActionCommand("");
        cotizacion.setColorDeSombra(new java.awt.Color(51, 51, 51));
        getContentPane().add(cotizacion);
        cotizacion.setBounds(10, 190, 116, 35);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 130, 1062, 254);

        jTextField1.setToolTipText("Buscar segun el nombre de columna");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(450, 100, 103, 20);

        combo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*", " " }));
        combo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo3ActionPerformed(evt);
            }
        });
        getContentPane().add(combo3);
        combo3.setBounds(340, 100, 80, 20);

        combo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Clientes", "Cotización", "Reservacion", "Unidades", "Choferes", "Articulos", "Usuarios" }));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });
        getContentPane().add(combo1);
        combo1.setBounds(140, 100, 100, 20);

        combo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "*", " " }));
        combo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo2ActionPerformed(evt);
            }
        });
        getContentPane().add(combo2);
        combo2.setBounds(250, 100, 80, 20);

        reservacion1.setBackground(new java.awt.Color(51, 51, 51));
        reservacion1.setText("Reservacion");
        reservacion1.setActionCommand("");
        reservacion1.setColorDeSombra(new java.awt.Color(51, 51, 51));
        getContentPane().add(reservacion1);
        reservacion1.setBounds(10, 130, 116, 35);

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorderPainted(false);

        jMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Seleccionar Empresa");
        jMenu1.setOpaque(true);

        Empresa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Empresa.setBackground(new java.awt.Color(51, 51, 51));
        Empresa.setForeground(new java.awt.Color(255, 255, 255));
        Empresa.setText("Agregar");
        Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpresaActionPerformed(evt);
            }
        });
        jMenu1.add(Empresa);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(51, 51, 51));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Usuarios");
        jMenu2.setOpaque(true);

        Usuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        Usuarios.setBackground(new java.awt.Color(51, 51, 51));
        Usuarios.setForeground(new java.awt.Color(255, 255, 255));
        Usuarios.setText("Agregar");
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });
        jMenu2.add(Usuarios);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(51, 51, 51));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Clientes");
        jMenu3.setOpaque(true);

        Clientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Clientes.setBackground(new java.awt.Color(51, 51, 51));
        Clientes.setForeground(new java.awt.Color(255, 255, 255));
        Clientes.setText("Agregar");
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });
        jMenu3.add(Clientes);

        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(51, 51, 51));
        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Cotizaciones");
        jMenu4.setOpaque(true);

        Cotizaciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Cotizaciones.setBackground(new java.awt.Color(51, 51, 51));
        Cotizaciones.setForeground(new java.awt.Color(255, 255, 255));
        Cotizaciones.setText("Agregar");
        Cotizaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CotizacionesActionPerformed(evt);
            }
        });
        jMenu4.add(Cotizaciones);

        jMenuBar1.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(51, 51, 51));
        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setText("Reservaciones");
        jMenu5.setOpaque(true);

        Reservaciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Reservaciones.setBackground(new java.awt.Color(51, 51, 51));
        Reservaciones.setForeground(new java.awt.Color(255, 255, 255));
        Reservaciones.setText("Agregar");
        Reservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservacionesActionPerformed(evt);
            }
        });
        jMenu5.add(Reservaciones);

        jMenuBar1.add(jMenu5);

        jMenu6.setBackground(new java.awt.Color(51, 51, 51));
        jMenu6.setForeground(new java.awt.Color(255, 255, 255));
        jMenu6.setText("Unidades");
        jMenu6.setOpaque(true);

        Unidades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Unidades.setBackground(new java.awt.Color(51, 51, 51));
        Unidades.setForeground(new java.awt.Color(255, 255, 255));
        Unidades.setText("Agregar");
        Unidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnidadesActionPerformed(evt);
            }
        });
        jMenu6.add(Unidades);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnidadesActionPerformed
        try {
            // Unidades unidad = new Unidades();
            Unidades unidad = new Unidades();
            unidad.show(true);
        } catch (SQLException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UnidadesActionPerformed

    private void EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpresaActionPerformed
        SeleccionarEmpresa empresa = new SeleccionarEmpresa();
        empresa.setVisible(true);
        
        
    }//GEN-LAST:event_EmpresaActionPerformed

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
       Altas usuario = new Altas(); 
       usuario.setVisible(true);
    }//GEN-LAST:event_UsuariosActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        Clientes cliente = new Clientes();
        cliente.setVisible(true);
    }//GEN-LAST:event_ClientesActionPerformed

    private void CotizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CotizacionesActionPerformed
        Cotizaciones c = new Cotizaciones();
        c.setVisible(true);
    }//GEN-LAST:event_CotizacionesActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER && combo3.getSelectedItem()!="*")
        {            
            String select2 = "SELECT *"+" FROM "+select1+" WHERE "+combo3.getSelectedItem()+" = \""+jTextField1.getText()+"\"";
            try {
                JTable JTable1;
                pasar_valores(tabla,select2);
            } catch (SQLException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (evt.getKeyCode()==KeyEvent.VK_ENTER && combo3.getSelectedItem()=="*")
        {
            JOptionPane.showMessageDialog(null, "Antes debes seleccionar la columna donde buscar");
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void ReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservacionesActionPerformed

    }//GEN-LAST:event_ReservacionesActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void combo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo3ActionPerformed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo1ActionPerformed

    private void combo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo2ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void pasar_valores(JTable ta, String sql)
    throws SQLException
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mudandote", "root", "");
      Statement stm = con.createStatement();
      ResultSet rst = stm.executeQuery(sql);
      ResultSetMetaData rsMd = rst.getMetaData();
      
      int NumeroColumnas = rsMd.getColumnCount();
      DefaultTableModel modelo = new DefaultTableModel();
      ta.setModel(modelo);
      for (int i = 1; i <= NumeroColumnas; i++) {
        modelo.addColumn(rsMd.getColumnLabel(i));
      }
      while (rst.next())
      {
        Object[] fila = new Object[NumeroColumnas];
        for (int j = 0; j < NumeroColumnas; j++) {
          fila[j] = rst.getObject(j + 1);
        }
        modelo.addRow(fila);
      }
    }
    catch (ClassNotFoundException|SQLException ce) {}
    
  }
    
    public void pasar_valores_combo(JComboBox combo1, String sql)
    throws SQLException
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mudandote", "root", "");
      Statement stm = con.createStatement();
      ResultSet rst = stm.executeQuery(sql);
      ResultSetMetaData rsMd = rst.getMetaData();
      
      int NumeroColumnas = rsMd.getColumnCount();
      
      for (int i = 1; i <= NumeroColumnas; i++) {
        combo1.addItem(rsMd.getColumnLabel(i));
        //System.out.println("Nombre de columnas "+rsMd.getColumnLabel(i));      
      }            
    }
    catch (ClassNotFoundException|SQLException ce) {}
  }
     public void pasar_filas_combo(JComboBox combo1, String sql)
    throws SQLException
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mudandote", "root", "");
      Statement stm = con.createStatement();
      ResultSet rst = stm.executeQuery(sql);
      ResultSetMetaData rsMd = rst.getMetaData();
      
      int NumeroColumnas = rsMd.getColumnCount();
      
      while (rst.next())
      {
        Object[] fila = new Object[NumeroColumnas];
        for (int j = 0; j < NumeroColumnas; j++) {
          fila[j] = rst.getObject(j + 1);
          //System.out.println("Filas "+fila[j]);
          combo1.addItem(fila[j]);
        }
        
      }
    }
    catch (ClassNotFoundException|SQLException ce) {}
  }
    
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("src//jars//gris.theme"));
        java.awt.EventQueue.invokeLater(() -> {
            new Main2().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Clientes;
    private javax.swing.JMenuItem Cotizaciones;
    private javax.swing.JMenuItem Empresa;
    private javax.swing.JMenuItem Reservaciones;
    private javax.swing.JMenuItem Unidades;
    private javax.swing.JMenuItem Usuarios;
    private org.edisoncor.gui.comboBox.ComboBoxRound combo1;
    private org.edisoncor.gui.comboBox.ComboBoxRound combo2;
    private org.edisoncor.gui.comboBox.ComboBoxRound combo3;
    private org.edisoncor.gui.button.ButtonColoredAction cotizacion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private org.edisoncor.gui.button.ButtonColoredAction reservacion1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
