/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Encapsuladas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import clases.conexion;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Pablo Delfin
 */
public class CotiClientes extends javax.swing.JFrame {

    /**
     * Creates new form CotiClientes
     */
    
       int id_Estado=0;
   
   conexion con = new conexion();
     String Titulos[] = {"Folio","Correo electronico","Nombre","Apellidos","Estado","Municipio","Telmovil"};
       DefaultTableModel m = new DefaultTableModel(null, Titulos);
      
       int registro = 0;
       
    
    public void buscar()
        {
           
        jTable1.setModel(m);
       //obtener la cantidad de registro de una tabla
       
       try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM catclientes");
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
       Object[][] datos = new String[registro][7];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT FolioCliente,CorreoElectronico,NombreContacto,NombreComercial,Estado,Municipio,Telmovil FROM catclientes where CorreoElectronico='"+Encapsuladas.getCorreoElectronico()+"'");
         ResultSet res = pstm.executeQuery();
         
         int i =0;
         
         while(res.next())
         {
             /*String estCodigo = res.getString("Codigo");
             String estDescripcion = res.getString("Codigo");
             String estCodigo = res.getString("Codigo");
             String estCodigo = res.getString("Codigo");*/
             
             datos[i][0] = res.getString("FolioCliente");
             datos[i][1] = res.getString("CorreoElectronico");
             datos[i][2] = res.getString("NombreContacto");
             datos[i][3] = res.getString("NombreComercial");
            id_Estado =Integer.parseInt(res.getString("Estado"));
             datos[i][6] = res.getString("Telmovil");
          
             m.addRow(datos[i]);
             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
        }
    
     public void buscar1()
        {
          
        jTable1.setModel(m);
       //obtener la cantidad de registro de una tabla
       
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
       Object[][] datos = new String[registro][7];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT Nombre FROM estados where id_estado='"+id_Estado+"'");
         ResultSet res = pstm.executeQuery();
         
         int i =0;
         
         while(res.next())
         {
             /*String estCodigo = res.getString("Codigo");
             String estDescripcion = res.getString("Codigo");
             String estCodigo = res.getString("Codigo");
             String estCodigo = res.getString("Codigo");*/
             
             
            datos[i][4] = res.getString("Nombre");
            JOptionPane.showMessageDialog(null,res.getString("Nombre"));
            
            
          
             m.addRow(datos[i]);
             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
        }
    
    public CotiClientes() {
        initComponents();
        buscar();   
        buscar1();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        Clientes1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Clientes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Cotizaciones = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cotizacion de Clientes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jMenuBar1.setBackground(new java.awt.Color(255, 102, 0));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorderPainted(false);

        jMenu8.setBackground(new java.awt.Color(255, 102, 0));
        jMenu8.setForeground(new java.awt.Color(255, 255, 255));
        jMenu8.setText("Inicio");

        Clientes1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Clientes1.setBackground(new java.awt.Color(51, 51, 51));
        Clientes1.setForeground(new java.awt.Color(255, 255, 255));
        Clientes1.setText("Ir");
        Clientes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clientes1ActionPerformed(evt);
            }
        });
        jMenu8.add(Clientes1);

        jMenuBar1.add(jMenu8);

        jMenu2.setBackground(new java.awt.Color(255, 102, 0));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Catalogo");

        jMenuItem3.setText("Articulos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem2.setText("Vivienda");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem1.setText("Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem4.setText("Plazas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Unidades");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(255, 102, 0));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Rutas");

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

        jMenu4.setBackground(new java.awt.Color(255, 102, 0));
        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Reservaciones");

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

        jMenu13.setText("Cotizacion de clientes");

        jMenuItem6.setText("Ver");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem6);

        jMenuBar1.add(jMenu13);

        jMenu6.setText("Asignacion de unidades");

        jMenuItem8.setText("Ver");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Status");

        jMenuItem9.setText("Ver Status de unidades");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuBar1.add(jMenu7);

        jMenu1.setText("Cerrar sesion");

        jMenuItem7.setText("Salir");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Clientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clientes1ActionPerformed
        Filtrados main = null;
           try {
               main = new Filtrados();
           } catch (SQLException ex) {
               Logger.getLogger(CotiClientes.class.getName()).log(Level.SEVERE, null, ex);
           }
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Clientes1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            // TODO add your handling code here:
            Articulos art = new Articulos();
            art.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
           // Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        CatVivienda vivi = new CatVivienda();
        vivi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Altas a = new Altas();
        a.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Plazas plaz = new Plazas();
        plaz.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Unidades uni;
        try {
            uni = new Unidades();
            uni.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
//            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        Rutas rutas = null;
        try {
            rutas = new Rutas();
            rutas.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
//            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClientesActionPerformed

    private void CotizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CotizacionesActionPerformed
        Reservacion c = new Reservacion();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CotizacionesActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        CotiClientes cot = new CotiClientes();
        cot.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        AsignacionUnidades uni = new AsignacionUnidades();
        uni.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {
            // TODO add your handling code here:
            Status sta = new Status();
            sta.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
//            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CotiClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CotiClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CotiClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CotiClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
                  try 
    {
      UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
    } 
    catch (Exception e) 
      {
      e.printStackTrace();
    }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CotiClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Clientes;
    private javax.swing.JMenuItem Clientes1;
    private javax.swing.JMenuItem Cotizaciones;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
