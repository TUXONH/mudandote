package ventanas;


import clases.Encapsuladas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author deam
 */
import clases.conexion;
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
   String aux_maestra;
   String aux_ventas;
    conexion con;
    //Main2 form ;
    public Login() {
        setLocationRelativeTo(null);
        initComponents();
         con= new conexion();
        con.getConnection();
        
        //form = new Main2();
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jXLoginPane1 = new org.jdesktop.swingx.JXLoginPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(113, 405, 82, 26);

        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(136, 0, 44, 16);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(390, 50, 149, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(390, 100, 149, 20);

        jLabel2.setText("Contrasena");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(126, 54, 66, 16);
        getContentPane().add(jXLoginPane1);
        jXLoginPane1.setBounds(330, 170, 400, 169);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        try {
              PreparedStatement   pstm = (PreparedStatement)
              con.getConnection().prepareStatement("SELECT maestra,ventas,nombre_usuario,password from catusuarios WHERE nombre_usuario='"+jXLoginPane1.getUserName()+"'and password='"+jXLoginPane1.getPassword()+"'");
              ResultSet res = pstm.executeQuery();
             
//                  Encapsuladas.setAuxMaestra(aux_maestra.toString());
//                  Encapsuladas.setAuxVentas(aux_ventas.toString());
      
              
              if(res.next()){ 
                aux_maestra = res.getObject("maestra").toString();
                aux_ventas = res.getObject("ventas").toString();
                System.out.println(aux_ventas+" "+aux_maestra);
                Encapsuladas.setAuxVentas(aux_ventas.toString());
                Main2 m = new Main2();
                m.setVisible(true);
                //form.setVisible(true);
                this.hide();
                 
              }
              else
              {
                JOptionPane.showMessageDialog(null,"Error de contraseña o usuario");
                jTextField1.setText("");
                jTextField2.setText("");
              }
             
       
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("No hay ese usuario");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXLoginPane jXLoginPane1;
    // End of variables declaration//GEN-END:variables
}
