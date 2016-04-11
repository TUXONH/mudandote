package ventanas;


import clases.Encapsuladas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import clases.conexion;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import java.text.ParseException;
import java.util.Arrays;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class Login extends javax.swing.JFrame 
{
   String aux_maestra;
   String aux_ventas;
   conexion con;
    public Login() {
        setLocationRelativeTo(null);
        initComponents();
         con= new conexion();
        con.getConnection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jXLoginPane1 = new org.jdesktop.swingx.JXLoginPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 204));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 170, 82, 26);

        jXLoginPane1.setBackground(new java.awt.Color(255, 102, 0));
        getContentPane().add(jXLoginPane1);
        jXLoginPane1.setBounds(0, 0, 400, 164);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
 
       char [] pass = jXLoginPane1.getPassword();
       String a = String.valueOf(pass);
       
        String value1=jXLoginPane1.getUserName();
       String value2=a;
       
       String user1="";
       String pass1="";
        try {
            
              PreparedStatement   pstm = (PreparedStatement)
              con.getConnection().prepareStatement("SELECT maestra,ventas,nombre_usuario,password from catusuarios WHERE nombre_usuario='"+value1+"' && password='"+value2+"'");
              ResultSet res = pstm.executeQuery();
             
//                  Encapsuladas.setAuxMaestra(aux_maestra.toString());
//                  Encapsuladas.setAuxVentas(aux_ventas.toString());
             while (res.next()) {
                user1 = res.getString("nombre_usuario");
                pass1 = res.getString("password");
                aux_maestra = res.getObject("maestra").toString();
                aux_ventas = res.getObject("ventas").toString();
            }
            if (value1.equals(user1) && value2.equals(pass1)) {
            JOptionPane.showMessageDialog(this,"correct");
             
               
                Encapsuladas.setAuxVentas(aux_ventas.toString());
                Main2 m = new Main2();
                m.setVisible(true);
               //form.setVisible(true);
                this.hide();
            }
            else{
            JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
            jXLoginPane1.setUserName("");
             jXLoginPane1.setPassword(null);
            }
            JOptionPane.showMessageDialog(null, "COMMITED SUCCESSFULLY!");
                     try 
    {
      UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
    } 
    catch (   ParseException | UnsupportedLookAndFeelException e) 
    {
    }
//              if(res.next()){ 
//                aux_maestra = res.getObject("maestra").toString();
//                aux_ventas = res.getObject("ventas").toString();
//               
//                Encapsuladas.setAuxVentas(aux_ventas.toString());
//                Main2 m = new Main2();
//                m.setVisible(true);
//                //form.setVisible(true);
//                this.hide();
//                 
//              }
//              else
//              {
//                JOptionPane.showMessageDialog(null,"Error de contraseña o usuario");
//                jXLoginPane1.setUserName("");
//                jXLoginPane1.setPassword(null);
//              }
//             
//       
            
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
      /*   try 
    {
      UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
    } 
    catch (Exception e) 
          {
      e.printStackTrace();
    }*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
  
                new Login().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private org.jdesktop.swingx.JXLoginPane jXLoginPane1;
    // End of variables declaration//GEN-END:variables
}
