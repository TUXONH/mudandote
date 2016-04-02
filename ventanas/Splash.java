
package ventanas;

import clases.cargar;
import com.sun.awt.AWTUtilities;

public final class Splash extends javax.swing.JFrame {
    double i=50, j=1;
    cargar hilo;
    public Splash() 
    {
        initComponents();
        iniciar();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progreso = new javax.swing.JProgressBar();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progreso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                progresoStateChanged(evt);
            }
        });
        getContentPane().add(progreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void iniciar()
    {
         setLocationRelativeTo(null);
        progreso.setVisible(false);
        hilo=new cargar(getProgreso());
        hilo.start();
        hilo=null;
    }
    private void progresoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_progresoStateChanged

        if(progreso.getValue()==i)
        {
            if(j!=101){
                AWTUtilities.setWindowOpacity(this, Float.valueOf((100-j)/100+"f"));
                i++;
                j+=2;
            }
         }
        if(progreso.getValue()==100){
            Main2 v = new Main2();
            v.setVisible(true);
            this.dispose();
        }
<<<<<<< HEAD
    }
    if(progreso.getValue() == 100){
        Login v=new Login();
        v.setVisible(true);
        this.dispose();
    }
=======
>>>>>>> ba72ae11b180e07aa7cefa1eca6a2e5818af395a
    }//GEN-LAST:event_progresoStateChanged

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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Splash().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the progreso
     */
    public javax.swing.JProgressBar getProgreso() {
        return progreso;
    }

    /**
     * @param progreso the progreso to set
     */
    public void setProgreso(javax.swing.JProgressBar progreso) {
        this.progreso = progreso;
    }
}
