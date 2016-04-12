package ventanas;


import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import clases.conexion;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
public class CatVivienda extends javax.swing.JFrame {

    public conexion con = new conexion();
    public void llenar()
    {
              String Titulos[] = {"Clave","Vivienda"};
       DefaultTableModel m = new DefaultTableModel(null, Titulos);
       jTable1.setModel(m);
       int registro = 0;
       
       //obtener la cantidad de registro de una tabla
       
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
       Object[][] datos = new String[registro][3];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT CveTipoVivienda,Descripcion FROM cattipovivienda");
         ResultSet res = pstm.executeQuery();
         int i =0;
         
         while(res.next())
         {
             
             
             datos[i][0] = res.getString("CveTipoVivienda");
             datos[i][1] = res.getString("Descripcion");

             m.addRow(datos[i]);
             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
    }
    
    public void Agregar(String CveVivienda,String Descripcion, String AyudaVenta)
    {
        
        try{
        PreparedStatement pstmc=(PreparedStatement)
        con.getConnection().prepareStatement("INSERT INTO cattipovivienda VALUES (?,?,?,?)");
        pstmc.setString(1, CveVivienda);
        pstmc.setString(2, Descripcion);
        pstmc.setString(3, AyudaVenta);
        pstmc.setString(4, "0");
        pstmc.execute();
        pstmc.close();
         System.out.println("Datos Agregados");
        }
        
        
        catch(SQLException e)
        {
              System.out.println(e);
        }
                
    }
    
    public void llenarCondi(String Condi)
    {
              String Titulos[] = {"Clave","Descripcion"};
       DefaultTableModel m = new DefaultTableModel(null, Titulos);
       jTable1.setModel(m);
       int registro = 0;
       
       //obtener la cantidad de registro de una tabla
       
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
       Object[][] datos = new String[registro][3];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT CveTipoVivienda,Descripcion FROM cattipovivienda Where Descripcion LIKE '" + Condi+"%'");
         ResultSet res = pstm.executeQuery();
         
         int i =0; 
         
         while(res.next())
         {

             datos[i][0] = res.getString("CveTipoVivienda");
             datos[i][1] = res.getString("Descripcion");

             m.addRow(datos[i]);
             i++;
         }
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
    }
    public CatVivienda() {
        initComponents();
        llenar();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCveVivienda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAyudaVenta = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        Clientes1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Clientes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Cotizaciones = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Reservaciones = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Viviendas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave", "Vivienda"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12))); // NOI18N

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel1.setText("Clave Vivienda");

        txtCveVivienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCveViviendaKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel2.setText("Descripcion");

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        jLabel3.setText("Ayuda de venta");

        txtAyudaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAyudaVentaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtCveVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtAyudaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCveVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAyudaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jMenuItem1.setText("Choferes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

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
        jMenu4.setText("Cotizaciones");

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

        jMenu5.setBackground(new java.awt.Color(255, 102, 0));
        jMenu5.setForeground(new java.awt.Color(255, 255, 255));
        jMenu5.setText("Reservaciones");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String Muestra="";
    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char CteclaPresionada=evt.getKeyChar();

         
         if(this.txtBuscar.getText().equals(""))
        {
             llenar();
         }
         
         else
         {
             Muestra = String.valueOf(txtBuscar.getText()+evt.getKeyChar());        
         llenarCondi(Muestra);
         }
        
        
        
    }//GEN-LAST:event_txtBuscarKeyTyped

    
        public void TeclaEnter( char CteclaPresionada)
        {
            
        
        if(CteclaPresionada==KeyEvent.VK_ENTER)
        {
            if(this.txtCveVivienda.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Favor de llenar el campo clave vivienda");
            }
            
            else if(this.txtDescripcion.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Favor de llenar el campo Descripcio");
            }
            else
            {
                Agregar(txtCveVivienda.getText(),txtDescripcion.getText(),txtAyudaVenta.getText());
                llenar();
            }
        }
        }
    private void txtCveViviendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCveViviendaKeyTyped
        char CteclaPresionada=evt.getKeyChar();

        TeclaEnter(CteclaPresionada);
    }//GEN-LAST:event_txtCveViviendaKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        char CteclaPresionada=evt.getKeyChar();

        TeclaEnter(CteclaPresionada);
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtAyudaVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAyudaVentaKeyTyped
      char CteclaPresionada=evt.getKeyChar();

        TeclaEnter(CteclaPresionada);
    }//GEN-LAST:event_txtAyudaVentaKeyTyped

    private void Clientes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clientes1ActionPerformed
        Main2 main = new Main2();
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
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            // TODO add your handling code here:
            Choferes chof = new Choferes();
            chof.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        Rutas rutas = null;
        try {
            rutas = new Rutas();
            rutas.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClientesActionPerformed

    private void CotizacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CotizacionesActionPerformed
        Cotizaciones c = new Cotizaciones();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CotizacionesActionPerformed

    private void ReservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservacionesActionPerformed
        Reservacion res = new Reservacion();
        res.setVisible(true);
    }//GEN-LAST:event_ReservacionesActionPerformed

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
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(CatVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatVivienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CatVivienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Clientes;
    private javax.swing.JMenuItem Clientes1;
    private javax.swing.JMenuItem Cotizaciones;
    private javax.swing.JMenuItem Reservaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAyudaVenta;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCveVivienda;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
