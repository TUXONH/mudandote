package ventanas;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import maps.java.*;
import static sun.management.Agent.error;
/**
 *
 * @author danielandrademaglioni
 */
public class Rutas extends javax.swing.JFrame {
    Main2 main = new Main2();
    String x,y,x2,y2;        
    String sql="Select * from catcotizacion";
    String sqlOrigen="Select FolioOrdenServicio,Serie,Usuario,CveTipoViviendaOrigen,EstadoOrigen,MunicipioOrigen,FechaOrdServ,FechaServicio,FolioCliente,NombreCteOrigen,Ape_PatOrigen,Ape_MatOrigen,DirOrigen,ColPoblOrigen,RefOrigen,TelOrigen,TelCelOrigen,NumPisosOrigen,NombreRecibe,FechaCotizacion,HoraServicio,ComentariosCte,Maniobras,Menaje,Almacenaje,ServAgreg,VentasArt,Anticipo,Saldo,SubTotal,IVA,Total,VolTotal,Observaciones,Facturado,Pagado,NoFactura,CoordenadaXOrigen,CoordenadaYOrigen,CoordenadaXDestino,CoordenadaYDestino";
    String sqlDestino="Select FolioOrdenServicio,Serie,Usuario,EstadoDestino,MunicipioDestino,FechaOrdServ,FechaServicio,FolioCliente,NombreRecibe,DirDestino,ColPoblDest,RefDest,TelDest,TelCelDestino,NumPisosDest,FechaCotizacion,HoraServicio,ComentariosCte,Maniobras,Menaje,Almacenaje,ServAgreg,VentasArt,Anticipo,Saldo,SubTotal,IVA,Total,VolTotal,Observaciones,Facturado,Pagado,NoFactura,CoordenadaXDestino,CoordenadaYDestino";
    /**
     * Creates new form Rutas
     */
    public Rutas() throws SQLException {
        initComponents();        
        main.pasar_valores(tabla, sqlOrigen);                        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        streetview = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recorrido = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        combo1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(recorrido);

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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ver Origen", "Ver Destino" }));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(streetview, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(streetview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        if (combo1.getSelectedItem()=="Ver Origen")
        {
            try {
                main.pasar_valores(tabla, sqlOrigen);
                //37,38
                
            } catch (SQLException ex) {
                Logger.getLogger(Rutas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                main.pasar_valores(tabla, sqlDestino);
            } catch (SQLException ex) {
                Logger.getLogger(Rutas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_combo1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        x=(String) tabla.getValueAt(tabla.getSelectedRow(),37);
        y=(String) tabla.getValueAt(tabla.getSelectedRow(),38);
        x2=(String) tabla.getValueAt(tabla.getSelectedRow(),39);
        y2=(String) tabla.getValueAt(tabla.getSelectedRow(),40);
        if (combo1.getSelectedItem()=="Ver Origen")
        {
            x=(String) tabla.getValueAt(tabla.getSelectedRow(),37);
            y=(String) tabla.getValueAt(tabla.getSelectedRow(),38);            
            x2=(String) tabla.getValueAt(tabla.getSelectedRow(),39);
            y2=(String) tabla.getValueAt(tabla.getSelectedRow(),40);
        }
        if (combo1.getSelectedItem()=="Ver Destino")
        {
            x=(String) tabla.getValueAt(tabla.getSelectedRow(),34);
            y=(String) tabla.getValueAt(tabla.getSelectedRow(),35);            
        }
        
        //System.out.println("Buscaremos la ruta que hay que recorrer a coche entre Madrid y Barcelona (en coche)");
        Route ObjRout=new Route();
        DefaultListModel model = new DefaultListModel();
        try {
            //String[][] resultado=ObjRout.getRoute("Madrid", "Barcelona", null, Boolean.TRUE, Route.mode.driving, Route.avoids.nothing);
            String[][] resultado=ObjRout.getRoute(x+y,x2+y2, null, Boolean.TRUE, Route.mode.driving, Route.avoids.nothing);
            for(int i=0;i<resultado.length;i++){
                //System.out.println("Tramo " + i + ":");
                model.addElement("Tramo "+i+":");
                for(int j=0;j<resultado[0].length;j++){
                    //System.out.print(resultado[i][j] + "\t");                    
                    model.addElement(resultado[i][j] + "\t");
                }
                //System.out.println("");
            }
            recorrido.setModel(model);
        } catch (Exception e) {
            error("Ruta");
        }
        ///
        StreetView ObjStreet=new StreetView();
        try {
            //Image imgResultado=ObjStreet.getStreetView("Madrid, Puerta del Sol", new Dimension(300,300),            
                    //90, 100, -100);
            Image imgResultado=ObjStreet.getStreetView(x+","+y, new Dimension(300,300),            
                    90, 100, -100);            
            ImageIcon icon = new ImageIcon(imgResultado);
            streetview.setIcon(icon);
            //System.out.println("La URL asociada a la imagen es: " + MapsJava.getLastRequestURL());
        } catch (Exception e) {
            error("Street View");
        }
        
    }//GEN-LAST:event_tablaMouseClicked

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
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Rutas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Rutas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> recorrido;
    private javax.swing.JLabel streetview;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
