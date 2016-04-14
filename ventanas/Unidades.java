package ventanas;

import clases.conexion;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import java.security.Principal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo Delfin
 */
public class Unidades extends javax.swing.JFrame {
    String sql="Select * From catunidades";
    Filtrados main = new Filtrados();
    boolean valor;
    String description;
    String capacity;
    String kilometer;
    boolean enservicio;
    /**
     * Creates new form Unidades
     */
    conexion con;
    public Unidades() throws SQLException {
        initComponents();  
        con = new conexion();
        this.setLocationRelativeTo(null);
        aceptar.setVisible(false);
        cancelar.setVisible(false);        
        main.pasar_valores(tabla, sql);
        

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        km = new javax.swing.JTextField();
        servicio = new javax.swing.JCheckBox();
        capacidad = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unidades");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel1.setText("Descripcion");

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane2.setViewportView(descripcion);

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel2.setText("Capacidad");

        jLabel3.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel3.setText("Kilometraje");

        km.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        km.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kmKeyTyped(evt);
            }
        });

        servicio.setText("En servicio");

        capacidad.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        capacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capacidadKeyTyped(evt);
            }
        });

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list.png"))); // NOI18N
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/acep.png"))); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imp.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(servicio))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(capacidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(km, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(agregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addComponent(editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(23, 23, 23)))
                                .addComponent(servicio))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(agregar)
                        .addGap(18, 18, 18)
                        .addComponent(editar)
                        .addGap(18, 18, 18)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelar)
                            .addComponent(aceptar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Clave", "Descripcion", "Capacidad", "Kilometraje", "EnServicio"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
    if ("".equals(descripcion.getText()) || "".equals(km.getText()) || "".equals(capacidad.getText())) 
        {
            JOptionPane.showMessageDialog(null,"Primero debes seleccionar un campo de la tabla!");
        }
        else
        {
        if (tabla.getValueAt(tabla.getSelectedRow(),4)=="1")
        {
            valor=true;
        }
        else{
            valor=false;
        }
        if (tabla.getSelectedRow()!=-1)
        {
            //flag=true;   
            description = (String) tabla.getValueAt(tabla.getSelectedRow(),1);
            capacity = (String) tabla.getValueAt(tabla.getSelectedRow(),2);
            kilometer = (String) tabla.getValueAt(tabla.getSelectedRow(),3);
            enservicio =  valor;
            eliminar.setVisible(false);
            agregar.setVisible(false);
            editar.setVisible(false);
            aceptar.setVisible(true);
            cancelar.setVisible(true);
            jButton1.setVisible(false);
            descripcion.setText(description);    
            capacidad.setText(capacity);
            km.setText(kilometer);
            servicio.setSelected(enservicio);                        
        }
        else {
            JOptionPane.showMessageDialog(null,"Para Editar primero debes seleccionar en la tabla que registro quieres cambiar");
        }
        }
    }//GEN-LAST:event_editarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if ("".equals(descripcion.getText()) || "".equals(km.getText()) || "".equals(capacidad.getText())) 
        {
            JOptionPane.showMessageDialog(null,"Te falta agregar una descripción, un kilometraje o una capacidad!");
        }
        else
        {
            clases.conexion con = new clases.conexion();
            try {

                PreparedStatement pstm =(PreparedStatement)        

                con.getConnection().prepareStatement("INSERT INTO catunidades (Descripcion,Capacidad,Kilometraje,EnServicio) VALUES (?,?,?,?)");                                            
                pstm.setString(1,descripcion.getText());
                pstm.setString(2,capacidad.getText());
                pstm.setString(3,km.getText());
                pstm.setBoolean(4,valor);
                pstm.execute();
                pstm.close();                                        
                main.pasar_valores(tabla, sql);
            } catch (SQLException ex) {
                Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        int idx = (int) tabla.getValueAt(tabla.getSelectedRow(),0);
        clases.conexion con = new clases.conexion();
        try {            
            PreparedStatement pstm =(PreparedStatement)                    
            con.getConnection().prepareStatement("UPDATE catunidades SET Descripcion='"+descripcion.getText()+"',Capacidad='"+capacidad.getText()+"',Kilometraje='"+km.getText()+"',EnServicio="+valor+" WHERE Clave="+idx);                                                        
            pstm.executeUpdate();
            pstm.close();                        
            Filtrados main = new Filtrados();
            main.pasar_valores(tabla, sql);
            JOptionPane.showMessageDialog(null,"Se modifico el registro con exito!");            
            aceptar.setVisible(false);
            cancelar.setVisible(false); 
            jButton1.setVisible(true);
            eliminar.setVisible(true);
            agregar.setVisible(true);
            editar.setVisible(true);
            descripcion.setText("");
        capacidad.setText("");
        km.setText("");
        servicio.setSelected(false);
        } catch (SQLException ex) {
            Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        eliminar.setVisible(true);
        agregar.setVisible(true);
        editar.setVisible(true);
        aceptar.setVisible(false);
        cancelar.setVisible(false);
        descripcion.setText("");
        capacidad.setText("");
        km.setText("");
        servicio.setSelected(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (tabla.getSelectedRow()!=-1)
        {
            int idx = (int) tabla.getValueAt(tabla.getSelectedRow(),0);
            clases.conexion con = new clases.conexion();
            try {
                PreparedStatement pst =(PreparedStatement)            
                con.getConnection().prepareStatement("DELETE FROM catunidades WHERE Clave ="+idx);                    
                int variable = pst.executeUpdate();
                if (variable>0)
                {
                    System.out.println("Se elimino");
                    Filtrados main = new Filtrados();
                    main.pasar_valores(tabla, sql);
                }
                pst.close(); 
                }catch(SQLException ex){
                    Logger.getLogger(Articulos.class.getName()).log(Level.SEVERE, null, ex);
                
                }
        }
        else {
            JOptionPane.showMessageDialog(null,"Para Eliminar primero debes seleccionar en la tabla que registro quieres Eliminar");
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
        description = (String) tabla.getValueAt(tabla.getSelectedRow(),1);
        capacity = (String) tabla.getValueAt(tabla.getSelectedRow(),2);
        kilometer = (String) tabla.getValueAt(tabla.getSelectedRow(),3);
        enservicio = valor;    
        descripcion.setText(description);    
        capacidad.setText(capacity);
        km.setText(kilometer);
        servicio.setSelected(enservicio); 
    }//GEN-LAST:event_tablaKeyPressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        description = (String) tabla.getValueAt(tabla.getSelectedRow(),1);
        capacity = (String) tabla.getValueAt(tabla.getSelectedRow(),2);
        kilometer = (String) tabla.getValueAt(tabla.getSelectedRow(),3);
        enservicio = valor;
        descripcion.setText(description);    
        capacidad.setText(capacity);
        km.setText(kilometer);
        servicio.setSelected(enservicio); 
    }//GEN-LAST:event_tablaMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        descripcion.setText("");
        capacidad.setText("");
        km.setText("");
        servicio.setSelected(false);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            String REPORTE = System.getProperty("user.dir") + "\\src\\ventanas\\unidades.jrxml";
        JasperReport reporteJasper = null;
        try
        {
            reporteJasper = JasperCompileManager.compileReport(REPORTE);
        }
        catch(JRException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperPrint informe = null;
        try
        {
            informe = JasperFillManager.fillReport(reporteJasper, null, con.getConnection());
        }
        catch(JRException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer.viewReport(informe, false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void capacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capacidadKeyTyped
         char c = evt.getKeyChar();
        char CteclaPresionada=evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Aqui solo van numeros!");            
            evt.consume();
        }
    }//GEN-LAST:event_capacidadKeyTyped

    private void kmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kmKeyTyped
        char c = evt.getKeyChar();
        char CteclaPresionada=evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Aqui solo van numeros!");            
            evt.consume();
        }
    }//GEN-LAST:event_kmKeyTyped

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
            java.util.logging.Logger.getLogger(Unidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Unidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Unidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Unidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new Unidades().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Unidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField capacidad;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField km;
    private javax.swing.JCheckBox servicio;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
