package ventanas;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.InputMap;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import clases.conexion;
import clases.Estado_Municipio;
import clases.Encapsuladas;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.GregorianCalendar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import maps.java.Geocoding;
import maps.java.Route;
import maps.java.ShowMaps;
//import org.jsoup.Jsoup;

import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;




public class Cotizaciones extends javax.swing.JFrame {
   
   public double Servicios=0;
   public double Transporte=0;
   public double Almacenaje=0;
   public double Empaque=0;
   public double Rentas=0;
   public double Ventas=0;
   public double Seguro=0;
   public double Maniobras=0;
   public double SubTotal=0;
   public double IVA=0;
   public double Total=0;
   public double Retencion=0;
   public double TotalFinal=0;
   public double Anticipo=0;
   public double Saldo=0;
   public double  SinPorcentaje=0;
   String time,distance;
   private ShowMaps ObjShowMaps=new ShowMaps();
   clases.Geocoding ObjGeocoding=new clases.Geocoding();
   clases.Route route = new clases.Route();  
   private Route ObjRoute=new Route();
   String lat,lon,lat2,lon2; 
    Estado_Municipio estado_municipio = new Estado_Municipio();
    
   String Titulos[] = {"#","Descripcion","Vol","PrecioTotal","GrupoCosto","Comision"};
      
      String datos[][]={};
       DefaultTableModel m= new DefaultTableModel(datos, Titulos);
    String TitulosCita[] = {"Hora","Numero Visita","Selec","Vendedor","Resultado Visita"};
 
       
     public String Tipo=Encapsuladas.getAuxVentas();

       
       
       
       
    public Cotizaciones() {
        
        
       
        initComponents();
        this.setLocationRelativeTo(null);
           if(Tipo=="true")
        {
        

        }
        
        estado_municipio.items(txtArticulos);
        estado_municipio.itemsCombo(ComboEstado);
         estado_municipio.itemsCombo(ComboEstado2);
         estado_municipio.ComboViviendas(ComboViviendas);
         estado_municipio.ComboViviendas(ComboVivienda2);
       TablaArticulos.setModel(m);
       txtAlmacenaje.setEditable(false);
       txtEmpaque.setEditable(false);
       txtRentas.setEditable(false);
       txtVentas.setEditable(false);
       txtSeguro.setEditable(false);
       txtSubtotal.setEditable(false);
       txtIVA.setEditable(false);
       txtTotal.setEditable(false);
       txtRetencion.setEditable(false);
       txtTotalFinal.setEditable(false);
       txtSalto.setEditable(false);
      
       //Calendar fecha = Calendar.getInstance();
       Calendar fecha = new GregorianCalendar();
      Date date ;
       
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        String  Hoy= "";
        date = Date.valueOf(LocalDate.now());
        txtFechaActual.setDate(date);
        FechaProbable.setDate(date);
        FechaVisita.setDate(date);
        //FechaActual1.setDate(date);
       /* System.out.println("Fecha Actual: "
                           + dia + "/" + (mes+1) + "/" + año);
        System.out.printf("Hora Actual: %02d:%02d:%02d %n",
                                              hora, minuto, segundo);*/
       
       
       /* ImageIcon fot = new ImageIcon("C:\\Users\\Pablo Delfin\\Documents\\GitHub\\PPM\\Save.png");
                 Icon icono = new ImageIcon(fot.getImage().getScaledInstance(btnGuardar.getWidth(),btnGuardar.getHeight(), Image.SCALE_DEFAULT));
                 btnGuardar.setIcon(icono);*/
       
         
    }
    
     

    
      public void Articulos()
        {
            conexion con = new conexion();
       
          
      
        
             
       int registro = 0;
       
       //obtener la cantidad de registro de una tabla
       
       try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM aticulos where Descripcion = '"+ txtArticulos.getText() +"'");
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
       //Object[][] datos = new String[registro][4];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT Descripcion,m3,GrupoCosteo,GrupoComision FROM aticulos where Descripcion = '"+txtArticulos.getText() +"'");
         ResultSet res = pstm.executeQuery();
         
         int i=0;
         
         String Descripcion="";
         String m3="";
          String GrupCo="";
          String GrupComi="";
          
         while(res.next())
         {
             //Numero.add(this.txtNumeros.getText());
              Descripcion = res.getString("Descripcion");
            m3 =res.getString("m3");
            volumenArticulos = volumenArticulos + Double.parseDouble(m3);
             //this.PrecioTotal.add("$0.00");
             GrupCo =res.getString("GrupoCosteo");
            GrupComi=res.getString("GrupoComision");
    
        
         }
         Object dato[] = {txtNumeros.getText(),Descripcion,m3,"$0.00",GrupCo,GrupComi};
         m.addRow(dato);
         txtVolumenTotal.setText("" + volumenArticulos);

        
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelCasa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMovil = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        ComboMunicipio = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtCveEstado = new javax.swing.JTextField();
        txtCveMunicipio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ComboViviendas = new javax.swing.JComboBox<>();
        txtCveVivienda = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtPisosOrigen = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        FechaProbable = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        txtNombreDestino = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtDireccionDestino = new javax.swing.JTextField();
        ComboEstado2 = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        ComboMunicipio2 = new javax.swing.JComboBox<>();
        txtCVeEstado = new javax.swing.JTextField();
        txtCveMunicipioDestino = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtTelCasaDestino = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtTelCelDestino = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        ComboVivienda2 = new javax.swing.JComboBox<>();
        txtViviendaDestino = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        txtPisosDestino = new javax.swing.JTextField();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        ChkRequiereVisita = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        FechaVisita = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtTransporte = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtAlmacenaje = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEmpaque = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtRentas = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtVentas = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtSeguro = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtManiobras = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtRetencion = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtTotalFinal = new javax.swing.JTextField();
        txtAnticipo = new javax.swing.JTextField();
        txtSalto = new javax.swing.JTextField();
        SpnIVA = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        ChkIVA = new javax.swing.JCheckBox();
        ChkSeguro = new javax.swing.JCheckBox();
        ComboSeguro = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        txtSumaAsegurada = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNumeros = new javax.swing.JTextField();
        txtArticulos = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        txtPropietario = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtVolumenTotal = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaArticulos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtFechaActual = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        txtIdentificacionCliente = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cotizaciones");
        setBackground(new java.awt.Color(51, 255, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel1.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel2.setText("Apellidos");

        txtApellidos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("->");

        jLabel5.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel5.setText("*Correo Electronico:");

        txtCorreoElectronico.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronicoActionPerformed(evt);
            }
        });
        txtCorreoElectronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoElectronicoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel9.setText("Tel.Casa");

        txtTelCasa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtTelCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelCasaActionPerformed(evt);
            }
        });
        txtTelCasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelCasaKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel10.setText("Tel. Cel:");

        txtMovil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMovilKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel11.setText("Direccion");

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel12.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel12.setText("Estado");

        ComboEstado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ComboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEstadoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel13.setText("Municipio");

        ComboMunicipio.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ComboMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMunicipioActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 0));
        jLabel14.setText("Fecha probable del servicio");

        txtCveEstado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtCveMunicipio.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel15.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel15.setText("Vivienda");

        ComboViviendas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ComboViviendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboViviendasActionPerformed(evt);
            }
        });

        txtCveVivienda.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCveVivienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCveViviendaKeyTyped(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("(Piso 0 -cero-para Planta baja)");

        txtPisosOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisosOrigenKeyTyped(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jCheckBox1.setText("Escaleras");

        jCheckBox2.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jCheckBox2.setText("Elevador");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPisosOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtPisosOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1))
                    .addComponent(jCheckBox2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FechaProbable.setMinSelectableDate(new java.util.Date(-62135744296000L));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addComponent(jLabel4)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel5)
                                        .addContainerGap(325, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtCorreoElectronico))
                                        .addContainerGap())))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addContainerGap(780, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(351, 351, 351)
                                .addComponent(txtDireccion))))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(ComboViviendas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCveVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(431, 431, 431))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel14)
                            .addGap(463, 463, 463)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(ComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCveEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCveMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FechaProbable, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ComboMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCveEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCveMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FechaProbable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboViviendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCveVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Origen", jPanel5);

        jLabel45.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel45.setText("*Nombre");

        txtNombreDestino.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNombreDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreDestinoKeyTyped(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel46.setText("*Direccion");

        txtDireccionDestino.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtDireccionDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionDestinoActionPerformed(evt);
            }
        });

        ComboEstado2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ComboEstado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEstado2ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel47.setText("Estado");

        jLabel48.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel48.setText("Municipio");

        ComboMunicipio2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ComboMunicipio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMunicipio2ActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel50.setText("Tel Casa.");

        txtTelCasaDestino.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtTelCasaDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelCasaDestinoKeyTyped(evt);
            }
        });

        jLabel51.setText("Tel Cel.");

        txtTelCelDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelCelDestinoKeyTyped(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel52.setText("Vivienda");

        ComboVivienda2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ComboVivienda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboVivienda2ActionPerformed(evt);
            }
        });

        txtViviendaDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtViviendaDestinoKeyTyped(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel53.setText("(Piso 0 -cero-para Planta baja)");

        txtPisosDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisosDestinoKeyTyped(evt);
            }
        });

        jCheckBox7.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jCheckBox7.setText("Escaleras");

        jCheckBox8.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jCheckBox8.setText("Elevador");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPisosDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jCheckBox7)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(txtPisosDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox7))
                    .addComponent(jCheckBox8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtDireccionDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addGap(180, 180, 180))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel48))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50)
                                    .addComponent(txtTelCasaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel51)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTelCelDestino, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComboMunicipio2, javax.swing.GroupLayout.Alignment.LEADING, 0, 127, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCVeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCveMunicipioDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel52)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ComboVivienda2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtViviendaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboMunicipio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCVeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCveMunicipioDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelCasaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelCelDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboVivienda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtViviendaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Destino", jPanel4);

        ChkRequiereVisita.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        ChkRequiereVisita.setText("Requiere visita");

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Dia:");

        jLabel17.setText("Hora:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FechaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FechaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(ChkRequiereVisita)
                        .addGap(356, 356, 356))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChkRequiereVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Citas", jPanel6);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Costos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 3, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        jLabel18.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 0, 0));
        jLabel18.setText("Transporte");

        txtTransporte.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTransporteActionPerformed(evt);
            }
        });
        txtTransporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTransporteKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel19.setText("Almacenaje");

        txtAlmacenaje.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtAlmacenaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionDestinoActionPerformed(evt);
            }
        });
        txtAlmacenaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionDestinoKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel20.setText("(Des)Empaqu");

        txtEmpaque.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel21.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel21.setText("Rentas");

        txtRentas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel22.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel22.setText("Ventas");

        txtVentas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel23.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel23.setText("Seguro");

        txtSeguro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel24.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 0, 0));
        jLabel24.setText("*Maniobras");

        txtManiobras.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtManiobras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtManiobrasKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel25.setText("Sub Total");

        txtSubtotal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel26.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel26.setText("I.V.A");

        txtIVA.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel27.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel27.setText("Total");

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel28.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel28.setText("-Retencion");

        txtRetencion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel29.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel29.setText("Total final");

        jLabel30.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 0, 0));
        jLabel30.setText("*Anticipo");

        jLabel31.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel31.setText("Saldo");

        txtTotalFinal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtAnticipo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtAnticipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnticipoKeyTyped(evt);
            }
        });

        txtSalto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        SpnIVA.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        SpnIVA.setModel(new javax.swing.SpinnerNumberModel(16, 1, null, 1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlmacenaje, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmpaque)
                            .addComponent(txtTransporte)
                            .addComponent(txtRentas)
                            .addComponent(txtVentas)
                            .addComponent(txtSeguro)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpnIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIVA)
                            .addComponent(txtSubtotal)
                            .addComponent(txtTotal)
                            .addComponent(txtTotalFinal)
                            .addComponent(txtAnticipo)
                            .addComponent(txtSalto)
                            .addComponent(txtRetencion)
                            .addComponent(txtManiobras))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlmacenaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtRentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtManiobras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpnIVA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtRetencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtTotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtAnticipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtSalto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 3, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        ChkIVA.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N
        ChkIVA.setForeground(new java.awt.Color(102, 0, 0));
        ChkIVA.setText("*Calcular I.V.A");
        ChkIVA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChkIVAMouseClicked(evt);
            }
        });
        ChkIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkIVAActionPerformed(evt);
            }
        });

        ChkSeguro.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N
        ChkSeguro.setForeground(new java.awt.Color(102, 0, 0));
        ChkSeguro.setText("Seguro");
        ChkSeguro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChkSeguroMouseClicked(evt);
            }
        });
        ChkSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkSeguroActionPerformed(evt);
            }
        });

        ComboSeguro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1.5", "2", "2.5", "3", "3.5", "4" }));
        ComboSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboSeguroActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("SansSerif", 3, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 0, 0));
        jLabel33.setText("*Suma asegurada");

        txtSumaAsegurada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSumaAseguradaActionPerformed(evt);
            }
        });
        txtSumaAsegurada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSumaAseguradaKeyTyped(evt);
            }
        });

        jLabel34.setBackground(new java.awt.Color(153, 153, 0));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 51, 51));
        jLabel34.setText("Datos que se pueden modificar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ChkSeguro)
                        .addGap(18, 18, 18)
                        .addComponent(ComboSeguro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ChkIVA)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSumaAsegurada, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChkIVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChkSeguro)
                    .addComponent(ComboSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtSumaAsegurada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel34))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNumeros.setText("1");
        txtNumeros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumerosKeyTyped(evt);
            }
        });

        txtArticulos.setText("Articulo/Servicio");
        txtArticulos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtArticulosKeyTyped(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane6.setViewportView(jTextArea3);

        jCheckBox3.setText("Venta X visita");

        jCheckBox4.setText("Venta X correo electronico");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel54.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel54.setText("Propietario");

        txtPropietario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addGap(21, 21, 21)
                .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel35.setFont(new java.awt.Font("SansSerif", 2, 11)); // NOI18N
        jLabel35.setText("Volumen total");

        txtVolumenTotal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVolumenTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtVolumenTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArticulos))
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Descripcion", "Vol.", "Precio total", "Grupo costo", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaArticulosMouseClicked(evt);
            }
        });
        TablaArticulos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TablaArticulosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TablaArticulosKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(TablaArticulos);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 0, 0));
        jLabel37.setText("Fecha");

        txtFechaActual.setDateFormatString("yyyy-MMM-dd");
        txtFechaActual.setMaxSelectableDate(new java.util.Date(253370790096000L));
        txtFechaActual.setMinSelectableDate(new java.util.Date(-62135744304000L));

        jLabel38.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 0, 0));
        jLabel38.setText("No. Identificacion del cliente");

        txtIdentificacionCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionClienteKeyTyped(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 0, 0));
        jLabel39.setText("Folio");

        txtFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFolioKeyTyped(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 0, 0));
        jLabel40.setText("Serie");

        txtSerie.setText("C");
        txtSerie.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(txtIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39)
                        .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addContainerGap())
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    
    
    public double volumenArticulos=0;
    
    private void txtArticulosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArticulosKeyTyped
        
        char CteclaPresionada=evt.getKeyChar();
        
        if(CteclaPresionada==KeyEvent.VK_ENTER)
        {
            String Descripcion = txtArticulos.getText();
            String Numeros = txtNumeros.getText();
            Articulos();
            txtArticulos.setText("");
            txtNumeros.setText("1");
        }
        
        
        
    }//GEN-LAST:event_txtArticulosKeyTyped

    private void TablaArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaArticulosMouseClicked
 
        Encapsuladas.setPosicionTabla(TablaArticulos.getSelectedRow());
        Encapsuladas.setColumna(TablaArticulos.getSelectedColumn());
    }//GEN-LAST:event_TablaArticulosMouseClicked
  
    public void Salto()
    {
        if(!txtAnticipo.getText().equals(""))
            {
                Saldo = Double.parseDouble(txtAnticipo.getText());
            Saldo =  Double.parseDouble(txtTotalFinal.getText())-Saldo;
            txtSalto.setText(""+Saldo);
            }
    }
   public String Costo="";
    
    public void Calculos(double Variable, JTextField caja,boolean comienza,String letra)
   {
       
       SubTotal = 0;
       
            Total=0;
            TotalFinal = 0;
            Saldo = 0;
            
            Variable = 0;
              comienza=false;

            
       for(int i=0;i<TablaArticulos.getRowCount();i++)
       {
           
           Costo =TablaArticulos.getValueAt(i, 3).toString();
         
         Costo=Costo.substring(1);
           String M = TablaArticulos.getValueAt(i, 4).toString();
           comienza = M.substring(0).startsWith(letra);
           
           SubTotal = SubTotal + Double.parseDouble(Costo);
       
            Total=Total+Double.parseDouble(Costo);
            TotalFinal = TotalFinal +Double.parseDouble(Costo);
            Saldo = Saldo + Double.parseDouble(Costo);
            SinPorcentaje= Total;
            

           
         if(comienza)
        {
            Variable =Variable + Double.parseDouble(Costo);
             

        }
         
         
  
       }
       
       if(txtTransporte.getText().equals(""))
       {
           txtSalto.setText(""+Saldo);
            txtTotalFinal.setText(""+TotalFinal);
            txtTotal.setText(""+Total);
            caja.setText(""+Variable);
            txtSubtotal.setText(""+SubTotal);
       }
       
       else
       {
          
       }

       if(txtSeguro.getText().equals(""))
       {
           txtSalto.setText(""+Saldo);
            txtTotalFinal.setText(""+TotalFinal);
            txtTotal.setText(""+Total);
            caja.setText(""+Variable);
            txtSubtotal.setText(""+SubTotal);
       }
       else
       {
           
            double numero = Integer.parseInt(txtSumaAsegurada.getText());
                Porcentaje(numero);
        
       }
       
            
            Salto();
   }
    private void TablaArticulosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaArticulosKeyTyped
       
         char CteclaPresionada=evt.getKeyChar();
          
          String cantid="";
          int Cantidad=0;
        if(CteclaPresionada==KeyEvent.VK_ENTER)
        {
            ///////////////////////////////////////////////////
         Costo =TablaArticulos.getValueAt(Encapsuladas.getPosicionTabla(), 3).toString();
         String M = TablaArticulos.getValueAt(Encapsuladas.getPosicionTabla(), 4).toString();
         Costo=Costo.substring(1);
        TablaArticulos.setValueAt("", Encapsuladas.getPosicionTabla(), 3);
        TablaArticulos.setValueAt("$"+Costo, Encapsuladas.getPosicionTabla(), 3);
        
       
        int longi=M.length();
       
        boolean comienzaV = M.substring(0).startsWith("V");
        boolean comienzaS = M.substring(0).startsWith("S");
        boolean comienzaE = M.substring(0).startsWith("E");
         boolean comienzaR = M.substring(0).startsWith("R");
         boolean comienzaA = M.substring(0).startsWith("A");
          boolean comienzaM = M.substring(0).startsWith("M");
      
        if(comienzaV)
        {
            Calculos(Ventas,txtVentas,comienzaV,"V");
        }
        
       else if(comienzaS)
        {
           Calculos(Servicios,txtRentas,comienzaS,"S");
        }
        
       else if(comienzaE)
        {
           Calculos(Empaque,txtEmpaque,comienzaE,"E");
        }
       else if(comienzaR)
        {
             Calculos(Rentas,txtRentas,comienzaR,"R");
        }
           
       else if(comienzaA)
        {
             Calculos(Almacenaje,txtAlmacenaje,comienzaA,"A");
        }
       
        }
        
        if(!txtSeguro.getText().equals(""))
            {
                 Transporte = SinPorcentaje +Seg;
                txtSubtotal.setText(""+Transporte);
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                
                AnticipoVacio();
            }
        
        if(!txtManiobras.getText().equals(""))
            {
                 Transporte = SinPorcentaje +Double.parseDouble(txtManiobras.getText());
                txtSubtotal.setText(""+Transporte);
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                
                AnticipoVacio();
            }
        
        if(!txtTransporte.getText().equals(""))
            {
                 Transporte = SinPorcentaje + Double.parseDouble(txtTransporte.getText());
                txtSubtotal.setText(""+Transporte);
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                
                AnticipoVacio();
            }

        
        if(!txtIVA.getText().equals(""))
            {
                 Transporte = SinPorcentaje + Double.parseDouble(txtIVA.getText());
              
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                
                AnticipoVacio();
            }
        
          int mas=(int)CteclaPresionada;

        if(mas==43)
        {
           cantid = TablaArticulos.getValueAt(Encapsuladas.getPosicionTabla(), 0).toString();
            Cantidad = 1+ Integer.parseInt(cantid);
             TablaArticulos.setValueAt(Cantidad, Encapsuladas.getPosicionTabla(), 0);
        }
        
         if(mas==45)
        {

            
             cantid = TablaArticulos.getValueAt(Encapsuladas.getPosicionTabla(), 0).toString();
            Cantidad = Integer.parseInt(cantid)-1;
            if(Cantidad==0)
            {
                Cantidad=1;
            }
             TablaArticulos.setValueAt(Cantidad, Encapsuladas.getPosicionTabla(), 0);
            
        }
        
        
        
        
    }//GEN-LAST:event_TablaArticulosKeyTyped

    private void ChkSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkSeguroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkSeguroActionPerformed

    private void ChkSeguroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChkSeguroMouseClicked
        if(ChkSeguro.isSelected())
            {
                if(txtSumaAsegurada.getText().equals(""))
                {
                 txtSeguro.setText("");
                }
                    else
                {
                    double numero = Integer.parseInt(txtSumaAsegurada.getText());
                Porcentaje(numero);
                double Porcentaje=0;
                
                Porcentaje = SinPorcentaje +Seg;
                txtSubtotal.setText(""+Porcentaje);
                
          double suma =0;
         if(!txtTransporte.getText().equals(""))
            {
                 suma = suma +  Porcentaje + Double.parseDouble(txtTransporte.getText());
                txtSubtotal.setText(""+suma);
                AnticipoVacio();
            }
         
        if(!txtManiobras.getText().equals(""))
            {
                if(suma==0)
                {
                    suma = suma + Porcentaje +Double.parseDouble(txtManiobras.getText());
                }
                
                else
                {
                    suma =  suma +Double.parseDouble(txtManiobras.getText());
                }

                txtSubtotal.setText(""+suma);
                AnticipoVacio();
            }
        
       
                }
                    

            }
        else
        {
            
             double suma =SinPorcentaje;
         if(!txtTransporte.getText().equals(""))
            {
                 suma = suma + Double.parseDouble(txtTransporte.getText());
                
            }
         
        if(!txtManiobras.getText().equals(""))
            {
                
                    suma = suma +Double.parseDouble(txtManiobras.getText());

            }
        txtSubtotal.setText(""+suma);
        if(!txtIVA.getText().equals(""))
        {
             suma = suma +Double.parseDouble(txtIVA.getText());
        }
          txtTotal.setText(""+suma);
        if(!txtRetencion.getText().equals(""))
        {
            suma = suma +Double.parseDouble(txtRetencion.getText());
        }
            txtSeguro.setText("");
            txtSalto.setText(""+suma);
            txtTotalFinal.setText(""+suma);
          
           // caja.setText(""+Variable);
            
             AnticipoVacio();
        }
    }//GEN-LAST:event_ChkSeguroMouseClicked
    public double Seg=0;
      public double Seguros=0;
    public  void Porcentaje(double numero)
    {
       
         
        String Porcentaje = (String) ComboSeguro.getSelectedItem(); 
        Seg = Double.parseDouble(Porcentaje);
        Seg = ((Seg * numero) / 100);
        
          Seguros=0;
        
        if(txtSeguro.getText().equals(""))
        {
            txtSeguro.setText(""+Seg);
            Seguro = Double.parseDouble(txtSeguro.getText()) + Double.parseDouble(txtSubtotal.getText());
            
        }
        else
        {
            Seguro=0;
           
            Seguro = Seg+SinPorcentaje;
            
        }
        
        txtSalto.setText(""+Seguro);
            txtTotalFinal.setText(""+Seguro);
            txtTotal.setText(""+Seguro);
           // caja.setText(""+Variable);
            txtSubtotal.setText(""+Seguro);
        
        
        txtSeguro.setText(""+Seg);
        
            if(!txtSeguro.getText().equals(""))
            {
                 Transporte = SinPorcentaje +Seg;
                txtSubtotal.setText(""+Transporte);
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                
                AnticipoVacio();
            }
        
        if(!txtManiobras.getText().equals("")&&!txtSeguro.getText().equals(""))
            {
                 Transporte = Transporte+Double.parseDouble(txtManiobras.getText());
                txtSubtotal.setText(""+Transporte);
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                
                AnticipoVacio();
            }
        
        if(!txtTransporte.getText().equals("")&&!txtSeguro.getText().equals(""))
            {
                 Transporte = Transporte + Double.parseDouble(txtTransporte.getText());
                txtSubtotal.setText(""+Transporte);
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                
                AnticipoVacio();
            }

        
        if(!txtIVA.getText().equals("")&&!txtSeguro.getText().equals(""))
            {
                 Transporte = Transporte + Double.parseDouble(txtIVA.getText());
                txtSubtotal.setText(""+Transporte);
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                
                AnticipoVacio();
            }
        
    }
    private void txtSumaAseguradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSumaAseguradaKeyTyped
        
        char CteclaPresionada=evt.getKeyChar();
        
        if(CteclaPresionada==KeyEvent.VK_ENTER)
        {
        
        if(ChkSeguro.isSelected())
            {
                if(txtSumaAsegurada.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Favor de ingresar el monto del seguro");
                }
                    else
                {
                    double numero = Integer.parseInt(txtSumaAsegurada.getText());
                Porcentaje(numero);

              
                }
                
                 double suma =SinPorcentaje;
                if(!txtSeguro.getText().equals(""))
            {
                 suma = suma+Seg;
            }
        
         
         if(!txtTransporte.getText().equals(""))
            {
                 suma = suma + Double.parseDouble(txtTransporte.getText());
            }
         
        if(!txtManiobras.getText().equals(""))
            {
                
                    suma = suma +Double.parseDouble(txtManiobras.getText());
 

            }
         txtSubtotal.setText(""+suma);
        if(!txtIVA.getText().equals(""))
            {
                
                    suma = suma +Double.parseDouble(txtIVA.getText());
        }
           // txtSeguro.setText("");
            txtSalto.setText(""+suma);
            txtTotalFinal.setText(""+suma);
            txtTotal.setText(""+suma);
           // caja.setText(""+Variable);
           

         AnticipoVacio();
        
                    

            }
        else
        {
            JOptionPane.showMessageDialog(null,"Aun no permite aceptar el seguro");
        }
       
        Salto();
        }
    }//GEN-LAST:event_txtSumaAseguradaKeyTyped

    private void ComboSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboSeguroActionPerformed
        if(!txtSumaAsegurada.getText().equals(""))
        {
            if(ChkSeguro.isSelected())
            {
                double numero = Integer.parseInt(txtSumaAsegurada.getText());
                Porcentaje(numero);
            }
        else
        {
            txtSeguro.setText("");
        }
        }
    }//GEN-LAST:event_ComboSeguroActionPerformed

    private void txtSumaAseguradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumaAseguradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumaAseguradaActionPerformed

    private void txtAnticipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnticipoKeyTyped
        char c = evt.getKeyChar();
        char CteclaPresionada=evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Aqui solo van numeros tonto!");            
            evt.consume();
        }
        else{       
           // String colum = TablaArticulos.getValueAt(TablaArticulos.getSelectedRow(),TablaArticulos.getSelectedColumn());
            if(CteclaPresionada==KeyEvent.VK_ENTER)
            {
                Saldo = Double.parseDouble(txtAnticipo.getText());
                Saldo =  Double.parseDouble(txtTotalFinal.getText())-Saldo;
                txtSalto.setText(""+Saldo);
            }
        }
    }//GEN-LAST:event_txtAnticipoKeyTyped

    public void AnticipoVacio()
    {
        if(!txtAnticipo.getText().equals(""))
                {
                    Saldo = Double.parseDouble(txtAnticipo.getText());
            Saldo =  Double.parseDouble(txtTotalFinal.getText())-Saldo;
            txtSalto.setText(""+Saldo);
                }
                
                else
                {
                    txtSalto.setText(""+Transporte);
                }
    }
    private void txtTransporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTransporteKeyTyped
        char c = evt.getKeyChar();
        char CteclaPresionada=evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Aqui solo van numeros tonto!");            
            evt.consume();
        }
        else{
            
        if(CteclaPresionada==KeyEvent.VK_ENTER)
        {
            
        
             Transporte =0;
            if(txtSeguro.getText().equals(""))
            {
                Transporte = SinPorcentaje  + Double.parseDouble(txtTransporte.getText());
                txtSubtotal.setText(""+Transporte);
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
               AnticipoVacio();
                
                
            }
            else
            {
                Transporte = SinPorcentaje + Double.parseDouble(txtTransporte.getText())+Seg;
                txtSubtotal.setText(""+Transporte);
            }
            
             if(!txtSeguro.getText().equals("")&&!txtManiobras.getText().equals(""))
            {
                 Transporte = SinPorcentaje + Double.parseDouble(txtTransporte.getText())+Double.parseDouble(txtManiobras.getText())+Seg;
                txtSubtotal.setText(""+Transporte);
            }
             
             else  if(txtSeguro.getText().equals("") &&!txtManiobras.getText().equals(""))
            {
                 Transporte = SinPorcentaje + Double.parseDouble(txtTransporte.getText())+Double.parseDouble(txtManiobras.getText());
                txtSubtotal.setText(""+Transporte);
 
            
            }
             
             if(!txtIVA.getText().equals(""))
             {
                  Transporte = Transporte+ Double.parseDouble(txtIVA.getText());
                  
                
             }
             
             
                txtTotalFinal.setText(""+Transporte);
                txtTotal.setText(""+Transporte);
                txtSalto.setText(""+Transporte);
                AnticipoVacio();
             

        }
        }
        
    }//GEN-LAST:event_txtTransporteKeyTyped

    
    private void txtManiobrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtManiobrasKeyTyped
char c = evt.getKeyChar();
        char CteclaPresionada=evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Aqui solo van numeros tonto!");            
            evt.consume();
        }
        else{                            
            Maniobras=0;
            if(CteclaPresionada==KeyEvent.VK_ENTER)
            {
                Transporte=Double.parseDouble(txtManiobras.getText());
                boolean bandera=false;

                if(!txtTransporte.getText().equals("") )
                {

                     Transporte = Transporte  +SinPorcentaje  + Double.parseDouble(txtTransporte.getText());
                     bandera=true;

                }


                 if(!txtSeguro.getText().equals("") )
                {

                    if(bandera)
                    {
                         Transporte = Transporte  +Double.parseDouble(txtSeguro.getText());
                    }
                    else
                    {
                         Transporte = Transporte +SinPorcentaje +Double.parseDouble(txtSeguro.getText());
                         bandera = true;
                    }

                }

                if(bandera)
                {

                     txtSubtotal.setText(""+Transporte);
                }

                else
                {
                      Transporte = Transporte + SinPorcentaje;
                    txtSubtotal.setText(""+Transporte);
                    bandera=true;

                }

                 if(!txtIVA.getText().equals(""))
                 {
                    if(bandera)
                    {
                        Transporte = Double.parseDouble(txtIVA.getText())+ Transporte;


                    }
                    else
                    {
                          Transporte = Double.parseDouble(txtIVA.getText())+ Transporte + SinPorcentaje;

                    }


                 }





                    txtTotalFinal.setText(""+Transporte);
                    txtTotal.setText(""+Transporte);
                    txtSalto.setText(""+Transporte);
                    AnticipoVacio();
            }
        
        }
        
    }//GEN-LAST:event_txtManiobrasKeyTyped

    private void ChkIVAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChkIVAMouseClicked

    }//GEN-LAST:event_ChkIVAMouseClicked
 public double b1=0;
    private void ChkIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkIVAActionPerformed
       
         if(ChkIVA.isSelected())
         {
               if(!txtSubtotal.getText().equals(""))
        {
            String B1;
         double Promedio=0;
        B1 = this.SpnIVA.getValue().toString(); 
        b1=Double.parseDouble(B1);
        
        b1 = (b1*Double.parseDouble(txtSubtotal.getText()))/100;
        txtIVA.setText(""+b1);
        double TTal= SinPorcentaje+b1;
        
     
        
       
        
        if(!txtSeguro.getText().equals(""))
            {
                 TTal = TTal +Seg;
             
                JOptionPane.showMessageDialog(null, TTal);
               
                
                
            }
        
        if(!txtManiobras.getText().equals(""))
            {
                 TTal = TTal +Double.parseDouble(txtManiobras.getText());
               
                
                
                
            }
        
        if(!txtTransporte.getText().equals(""))
            {
                TTal = TTal + Double.parseDouble(txtTransporte.getText());
              
                
               
            }
        
         txtTotal.setText(""+TTal);
         double sub = TTal;
         sub = sub -b1;
           txtSubtotal.setText(""+sub);
        
         
         
         if(!txtRetencion.getText().equals(""))
        {
            TTal=TTal+ Double.parseDouble(txtRetencion.getText());
            
        }
         txtTotalFinal.setText(""+TTal);
         if(!txtAnticipo.getText().equals(""))
        {
            TTal=TTal - Double.parseDouble(txtAnticipo.getText());
            
           
        }
         
        
       
        txtSalto.setText(""+TTal);
        
            
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,"No hay un subtotal aun.");
            ChkIVA.setSelected(false);
        }
         }
         else
         {
             double TTal= SinPorcentaje;
             txtIVA.setText("");
             
             
             if(!txtSeguro.getText().equals(""))
            {
                 TTal = TTal +Seg;
            }
        
        if(!txtManiobras.getText().equals(""))
            {
                 TTal = TTal +Double.parseDouble(txtManiobras.getText());
            }
        
        if(!txtTransporte.getText().equals(""))
            {
                TTal = TTal + Double.parseDouble(txtTransporte.getText());
            }
             txtSubtotal.setText(""+TTal);
             txtTotal.setText(txtSubtotal.getText());
             
              if(!txtRetencion.getText().equals(""))
                {
                    TTal = Double.parseDouble(txtRetencion.getText()) + TTal;
                    
                 }
              txtTotalFinal.setText(""+TTal);
              if(!txtAnticipo.getText().equals(""))
                {
                     TTal=TTal-Double.parseDouble(txtAnticipo.getText());
            
                    
                }
              
              
             
             txtSalto.setText(""+TTal);
             
         
         }
        
        
       
    }//GEN-LAST:event_ChkIVAActionPerformed

    private void txtTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTransporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTransporteActionPerformed

    
    
    
    
    
    
    
    int esta=0;
    int muni=0;
   
      public void buscar()
        {
             boolean existe= false;
           conexion con = new conexion();
        //jTable1.setModel(m);
       //obtener la cantidad de registro de una tabla
       int registro =0;
       
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
       Object[][] datos = new String[registro][9];
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT FolioCliente,CorreoElectronico,NombreContacto,NombreComercial,Direccion,Estado,Municipio,TelCasa,Telmovil FROM catclientes where CorreoElectronico='"+txtCorreoElectronico.getText()+"'");
         ResultSet res = pstm.executeQuery();
         
         int i =0;
         
        /*  ComboMunicipio.removeAllItems();
        String Estado = (String) ComboEstado.getSelectedItem();
       
        estado_municipio.itemsCombo2(Estado,ComboMunicipio,txtCveEstado,txtCveMunicipio);*/
         
         while(res.next())
         {
             /*String estCodigo = res.getString("Codigo");
             String estDescripcion = res.getString("Codigo");
             String estCodigo = res.getString("Codigo");
             String estCodigo = res.getString("Codigo");*/
             
            txtIdentificacionCliente.setText(res.getString("FolioCliente"));
             //datos[i][1] = res.getString("CorreoElectronico");
            txtNombre.setText(res.getString("NombreContacto"));
            txtPropietario.setText(res.getString("NombreContacto") + " "+ res.getString("NombreComercial") );
             txtApellidos.setText(res.getString("NombreComercial"));
             txtDireccion.setText(res.getString("Direccion"));
            esta =Integer.parseInt(res.getString("Estado"));
            muni = Integer.parseInt(res.getString("Municipio"));
            txtTelCasa.setText(res.getString("TelCasa"));
         
             txtMovil.setText(res.getString("Telmovil"));
          existe=true;
             /*m.addRow(datos[i]);
             i++;*/
             
         }
         
         if(!existe)
         {
              JOptionPane.showMessageDialog(null,"El usuario ingreado no existe");
               txtNombre.setText("");
            txtPropietario.setText("");
             txtApellidos.setText("");
             txtDireccion.setText("");
            esta =Integer.parseInt(res.getString("Estado"));
            muni = Integer.parseInt(res.getString("Municipio"));
            txtTelCasa.setText(res.getString("TelCasa"));
         
             txtMovil.setText(res.getString("Telmovil"));
         }
        
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
       
       
       
       
       
       
        }
    
//public void guardarDatos()
//{}
  
    

        



    public void guardarDatos()      
{
     int año = FechaProbable.getCalendar().get(Calendar.YEAR);

   
       int mes = 1+ FechaProbable.getCalendar().get(Calendar.MONTH);
        int dia = FechaProbable.getCalendar().get(Calendar.DAY_OF_MONTH);
        String FechaServicio = año+"-"+mes+"-"+dia;
        
          año = txtFechaActual.getCalendar().get(Calendar.YEAR);
   
        mes = 1+ txtFechaActual.getCalendar().get(Calendar.MONTH);
         dia = txtFechaActual.getCalendar().get(Calendar.DAY_OF_MONTH);
        String FechaActual = año+"-"+mes+"-"+dia;
    conexion con = new conexion();
             try{
        PreparedStatement pstmc=(PreparedStatement)
                //con.getConnection().prepareStatement("INSERT INTO cotizaciones (CvePlaza, Serie, FolioCliente, NombreQuienCotiza, FechaCotizacion, FechaProbServ, Usuario, CveTipoViviendaOrigen, EstadoOrigen, MunicipioOrigen, DirOrigen, PlantaBajaOrigen, NoPisosOrigen, ElevadorOrigen, EscaleraOrigen, TelOrigen, TelCelOrigen, RefOrigen, CveTipoViviendaDestino, NombreRecibe, EstadoDestino, MunicipioDestino, DirDestino, PlantaBajaDestino, NoPisosDestino, ElevadorDestino, EscaleraDestino, TelDestino, TelCelDestino, RefDestino, Maniobras, Menaje, Almacenaje, ServAgreg, Rentas, VentasArt, Seguro, PorcSeguro, SumaAseg, Anticipo, Saldo, Subtotal, IVA, Total, Retencion, VolTotal, CostoCriterioXUser, TipoPresup, Observaciones, Nota1, Nota2, Generada, Baja, IdVisita, TipoOrdenNoR, NumOrdenNoR, TipoMud, Cancelada, VtaXVisita, UltimoUsuario, CorreoElectronico) VALUES ('Casa','C','1','Jose','2016-04-06','2016-05-06','Admin','Casa','1','1','Reg.228 M.20 L.20','0','1','0','0','132-51-29','9981018163','Frente a casa blanca','Casa','Juan escutia','1','1','Direccion del destino','0','1','0','0','132-23-33','9981223344','Frente a casa destino','100','200','300','400','500','600','700','7.0','800','900','1000','1100','1200','1300','1400','1500','1700','1','Se va a llevar a una que es prueba','nota1','nota2','0','0','1','R','1','M','0','0','UltimoUs','pablodelhip@gmail.com')");
        con.getConnection().prepareStatement("INSERT INTO cotizaciones (CvePlaza, Serie, FolioCliente, "//3
                + "NombreQuienCotiza, FechaCotizacion, FechaProbServ, Usuario, CveTipoViviendaOrigen,"//8
                + " EstadoOrigen, MunicipioOrigen, DirOrigen, PlantaBajaOrigen, NoPisosOrigen,"//13
                + " ElevadorOrigen, EscaleraOrigen, TelOrigen, TelCelOrigen, RefOrigen, CveTipoViviendaDestino,"//19
                + " NombreRecibe, EstadoDestino, MunicipioDestino, DirDestino, PlantaBajaDestino, NoPisosDestino,"//25
                + "ElevadorDestino, EscaleraDestino, TelDestino, TelCelDestino, RefDestino, Maniobras, Menaje,"//32
                + "Almacenaje, ServAgreg, Rentas, VentasArt, Seguro, PorcSeguro, SumaAseg, Anticipo, Saldo,"//41
                + " Subtotal, IVA, Total, Retencion, VolTotal, CostoCriterioXUser, TipoPresup, Observaciones,"//49
                + "Nota1, Nota2, Generada, Baja, IdVisita, TipoOrdenNoR, NumOrdenNoR, TipoMud, Cancelada,"//58
                + "VtaXVisita, UltimoUsuario)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      
       pstmc.setString(1,"CASA");//claveplaza
        pstmc.setString(2, "C");//Serie
        pstmc.setString(3, "2");//folioCliente
        pstmc.setString(4, txtNombre.getText() + txtApellidos.getText());//Nombre de quien cotiza
        pstmc.setString(5,FechaActual);
        pstmc.setString(6, FechaServicio);
        pstmc.setString(7, "Admin");//Usuario
        pstmc.setString(8, txtCveVivienda.getText());//ClavetipoViviendaOrigen
        pstmc.setString(9, txtCveEstado.getText());//EstadoOrigen
        pstmc.setString(10, txtCveMunicipio.getText());//EstadoOrigen
        pstmc.setString(11, txtDireccion.getText());//DireccionOrigen
        pstmc.setString(12, "0");//PlantaBajaOrigen
        if(txtPisosOrigen.getText().equals(""))    
        {
         pstmc.setString(13, "0");//NuymeroDePisosOrigen
        
        }
       else
        {
            pstmc.setString(13, txtPisosOrigen.getText());//NuymeroDePisosOrigen
        }
        pstmc.setString(14, "0");//ElevadorOrigen
        pstmc.setString(15, "0");//EscaleraOrigen
        pstmc.setString(16, txtTelCasa.getText());//TelOrigen
        pstmc.setString(17, txtMovil.getText());//TelCelOrigen
        pstmc.setString(18, "Referencia");//RefOrigen
        pstmc.setString(19, txtCveVivienda.getText());//CveTipoViviendaDestino
        pstmc.setString(20, txtNombreDestino.getText());//NombreRecibe
        pstmc.setString(21, txtCVeEstado.getText());//EstadoDestino
        pstmc.setString(22, txtCveMunicipioDestino.getText());//MunicipioDestino
        pstmc.setString(23, txtDireccionDestino.getText());//DirDestino
        pstmc.setString(24, "0");//PlantaBajaDestino
        if(txtPisosOrigen.getText().equals(""))    
        {
         pstmc.setString(25, "0");//NuymeroDePisosOrigen
        
        }
       else
        {
            pstmc.setString(25, txtPisosDestino.getText());//NuymeroDePisosOrigen
        }
      
        pstmc.setString(26, "0");//ElevadorDestino
        pstmc.setString(27, "0");//EscaleraDestino
        pstmc.setString(28, txtTelCasaDestino.getText());//TelDestino
        pstmc.setString(29, txtTelCelDestino.getText());//TelCelDestino
        pstmc.setString(30, "ReferenciaDestino");//RefDestino
        
        
        if(txtManiobras.getText().equals(""))
        {
            pstmc.setString(31, "0");//Maniobras
        }
        
        else
        {
            pstmc.setString(31, txtManiobras.getText());//Maniobras
        }
        
        
        
        pstmc.setString(32, "0");//Menaje
        
        if(txtAlmacenaje.getText().equals(""))
        {
            pstmc.setString(33, "0");//Maniobras
        }
        
        else
        {
             pstmc.setString(33, txtAlmacenaje.getText());//Alamacenaje
        }
        
       
        pstmc.setString(34, "0");//ServAgreg
        
        
         if(txtRentas.getText().equals(""))
        {
            pstmc.setString(35, "0");//Maniobras
        }
        
        else
        {
              pstmc.setString(35, txtRentas.getText());//Rentas
        }
        
       
         
       
        pstmc.setString(36, "0");//VentasArt
        
        
        
           if(txtSumaAsegurada.getText().equals(""))
        {
            pstmc.setString(37, "0");//Maniobras
        }
        
        else
        {
            pstmc.setString(37, txtSumaAsegurada.getText());//Seguro
        }
        
           
           if(txtSeguro.getText().equals(""))
        {
            pstmc.setString(38, "0");//Maniobras
        }
        
        else
        {
            pstmc.setString(38, txtSeguro.getText());//PorcSeguro
        }
           
           
        
        pstmc.setString(39,"10" );//SumaAseg
        
        
           if(txtAnticipo.getText().equals(""))
        {
            pstmc.setString(40, "0");//Maniobras
        }
        
        else
        {
            pstmc.setString(40, txtAnticipo.getText());//Anticipo
        }
        
           
              if(txtSalto.getText().equals(""))
        {
            pstmc.setString(41, "0");//Maniobras
        }
        
        else
        {
             pstmc.setString(41, txtSalto.getText());//Saldo
        }
        
              
                    if(txtSubtotal.getText().equals(""))
        {
            pstmc.setString(42, "0");//Maniobras
        }
        
        else
        {
            pstmc.setString(42, txtSubtotal.getText());//Subtotal
        }
        
                    
          if(txtIVA.getText().equals(""))
        {
            pstmc.setString(43, "0");//Maniobras
        }
        
        else
        {
           pstmc.setString(43, txtIVA.getText());//IVA
        }
       
           if(txtTotal.getText().equals(""))
        {
            pstmc.setString(44, "0");//Maniobras
        }
        
        else
        {
           pstmc.setString(44, txtTotal.getText());//Total
        }
        
          
          
        
        pstmc.setString(45, "0");//Retencion
            if(txtVolumenTotal.getText().equals(""))
        {
            pstmc.setString(46, "0");//Maniobras
        }
        
        else
        {
           pstmc.setString(46, txtVolumenTotal.getText());//VolTotal
        }
        
        pstmc.setString(47, "0");//CostoCriterio
        pstmc.setString(48, "1");//TipoPresupuesto
        pstmc.setString(49, "observa");//Observacion
        pstmc.setString(50, "nota1");//Nota1
        pstmc.setString(51, "nota2");//Nota2
        pstmc.setString(52, "0");//Generada
        pstmc.setString(53, "0");//BAja
        pstmc.setString(54, "1");//idVisita
        pstmc.setString(55, "R");//TipoOrdenNoR
        pstmc.setString(56, "2");//NumOrdenNoR
        pstmc.setString(57, "M");//TipoMud
        pstmc.setString(58, "0");//Cancela
        pstmc.setString(59, "0");//VtaXVisita
        pstmc.setString(60, "User");//UltimoUsuario
      // pstmc.setString(61, "unoooo");//txtCorreoElectronico.getText());//CorreoElectronico
       
        
        pstmc.execute();
        pstmc.close();
         JOptionPane.showMessageDialog(null, "La cotizacion a sido guardada correctamente");
        }
        
        
        catch(SQLException e)
        {
              System.out.println(e);
        }
}
     public void GuardarArticulos()
     {
         int reg=0;
            conexion con = new conexion();
            try{
           PreparedStatement pstm = (PreparedStatement)
           con.getConnection().prepareStatement("SELECT count(1) as total FROM cotizaciones");
           ResultSet res = pstm.executeQuery();
           res.next();
           registro = res.getInt("total");
           System.out.println(registro);
           res.close();
           reg = registro;
                   
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
       }
            
             for(int i=0;i<TablaArticulos.getRowCount();i++)
       {
         
             try{
        PreparedStatement pstmc=(PreparedStatement)
                //con.getConnection().prepareStatement("INSERT INTO cotizaciones (CvePlaza, Serie, FolioCliente, NombreQuienCotiza, FechaCotizacion, FechaProbServ, Usuario, CveTipoViviendaOrigen, EstadoOrigen, MunicipioOrigen, DirOrigen, PlantaBajaOrigen, NoPisosOrigen, ElevadorOrigen, EscaleraOrigen, TelOrigen, TelCelOrigen, RefOrigen, CveTipoViviendaDestino, NombreRecibe, EstadoDestino, MunicipioDestino, DirDestino, PlantaBajaDestino, NoPisosDestino, ElevadorDestino, EscaleraDestino, TelDestino, TelCelDestino, RefDestino, Maniobras, Menaje, Almacenaje, ServAgreg, Rentas, VentasArt, Seguro, PorcSeguro, SumaAseg, Anticipo, Saldo, Subtotal, IVA, Total, Retencion, VolTotal, CostoCriterioXUser, TipoPresup, Observaciones, Nota1, Nota2, Generada, Baja, IdVisita, TipoOrdenNoR, NumOrdenNoR, TipoMud, Cancelada, VtaXVisita, UltimoUsuario, CorreoElectronico) VALUES ('Casa','C','1','Jose','2016-04-06','2016-05-06','Admin','Casa','1','1','Reg.228 M.20 L.20','0','1','0','0','132-51-29','9981018163','Frente a casa blanca','Casa','Juan escutia','1','1','Direccion del destino','0','1','0','0','132-23-33','9981223344','Frente a casa destino','100','200','300','400','500','600','700','7.0','800','900','1000','1100','1200','1300','1400','1500','1700','1','Se va a llevar a una que es prueba','nota1','nota2','0','0','1','R','1','M','0','0','UltimoUs','pablodelhip@gmail.com')");
        con.getConnection().prepareStatement("INSERT INTO tablaarticulos VALUES (?,?,?,?,?,?)");
      
       pstmc.setString(1,""+reg);//claveplaza
        pstmc.setString(2,TablaArticulos.getValueAt(i, 1).toString());//Serie
        pstmc.setString(3, TablaArticulos.getValueAt(i, 2).toString());//folioCliente
        pstmc.setString(4, TablaArticulos.getValueAt(i, 3).toString());//Nombre de quien cotiza
        pstmc.setString(5,TablaArticulos.getValueAt(i, 4).toString());//Serie
        pstmc.setString(6, TablaArticulos.getValueAt(i, 5).toString());//folioCliente
    
     
       
        
        pstmc.execute();
        pstmc.close();
         //JOptionPane.showMessageDialog(null, "La cotizacion a sido guardada correctamente");
        }
        
        
        catch(SQLException e)
        {
              System.out.println(e);
        }
       
       }
     }

    
   public void GuardarCliente()
     {
         
         
         int reg=0;
            conexion con = new conexion();
       
       
            boolean bandera = false;
             try
       {
      
         PreparedStatement pstm = (PreparedStatement)
            con.getConnection().prepareStatement("SELECT * FROM catclientes where CorreoElectronico='"+txtCorreoElectronico.getText()+"'");
         ResultSet res = pstm.executeQuery();
         
         int i =0;
         
         while(res.next())
         {   
             bandera = true;
 
         }
         
        
       
       }
       
       catch(SQLException e)
       {
           System.out.println(e);
          
       
       }
            
          ///////////////  
         if(!bandera)
         {
             try{
        PreparedStatement pstmc=(PreparedStatement)
                //con.getConnection().prepareStatement("INSERT INTO cotizaciones (CvePlaza, Serie, FolioCliente, NombreQuienCotiza, FechaCotizacion, FechaProbServ, Usuario, CveTipoViviendaOrigen, EstadoOrigen, MunicipioOrigen, DirOrigen, PlantaBajaOrigen, NoPisosOrigen, ElevadorOrigen, EscaleraOrigen, TelOrigen, TelCelOrigen, RefOrigen, CveTipoViviendaDestino, NombreRecibe, EstadoDestino, MunicipioDestino, DirDestino, PlantaBajaDestino, NoPisosDestino, ElevadorDestino, EscaleraDestino, TelDestino, TelCelDestino, RefDestino, Maniobras, Menaje, Almacenaje, ServAgreg, Rentas, VentasArt, Seguro, PorcSeguro, SumaAseg, Anticipo, Saldo, Subtotal, IVA, Total, Retencion, VolTotal, CostoCriterioXUser, TipoPresup, Observaciones, Nota1, Nota2, Generada, Baja, IdVisita, TipoOrdenNoR, NumOrdenNoR, TipoMud, Cancelada, VtaXVisita, UltimoUsuario, CorreoElectronico) VALUES ('Casa','C','1','Jose','2016-04-06','2016-05-06','Admin','Casa','1','1','Reg.228 M.20 L.20','0','1','0','0','132-51-29','9981018163','Frente a casa blanca','Casa','Juan escutia','1','1','Direccion del destino','0','1','0','0','132-23-33','9981223344','Frente a casa destino','100','200','300','400','500','600','700','7.0','800','900','1000','1100','1200','1300','1400','1500','1700','1','Se va a llevar a una que es prueba','nota1','nota2','0','0','1','R','1','M','0','0','UltimoUs','pablodelhip@gmail.com')");
        con.getConnection().prepareStatement("INSERT INTO catclientes(CorreoElectronico, NombreContacto, NombreComercial, Direccion, Estado, Municipio, TelCasa, TelMovil, Activo) VALUES (?,?,?,?,?,?,?,?,?)");
      
       pstmc.setString(1,txtCorreoElectronico.getText());//Activo
        pstmc.setString(2,txtNombre.getText());//CorreoElectronico
        //pstmc.setString(3, TablaArticulos.getValueAt(i, 2).toString());//Rfc
        pstmc.setString(3, txtApellidos.getText());//Nombre 
        pstmc.setString(4,this.txtDireccion.getText());//Apellido
       // pstmc.setString(6, TablaArticulos.getValueAt(i, 5).toString());//RazonSocial
         pstmc.setString(5,txtCveEstado.getText());//Direccion
        pstmc.setString(6, txtCveMunicipio.getText());//Estado
         pstmc.setString(7,txtTelCasa.getText());//Municipio
        pstmc.setString(8, txtMovil.getText());//Telmovil
        pstmc.setString(9, "0");//Telmovil
  
        
        pstmc.execute();
        pstmc.close();
         //JOptionPane.showMessageDialog(null, "La cotizacion a sido guardada correctamente");
        }
        
        
        catch(SQLException e)
        {
              System.out.println(e);
        }
       
         }
     }

    int registro;
    public boolean email(String Email) 
{
     
    Email=Email.trim();
    boolean sw = false;
    int a = Email.length() - 1;
    String letra, letra1 = "";
            try 
            {
                for (int i = 0; 1 < a; i++) 
                {
                    letra = "" + Email.charAt(i);
                    if (letra.equals("@")) 
                    {
                        a++;
                        letra1 = Email.substring(i, a);
                        letra1=letra1.toLowerCase();
                        if ((letra1.equals("@hotmail.com")) || (letra1.equals("@gmail.com"))) 
                        {

                            sw = true;
                            break;
                        }
                    }
                }
            } catch (Exception e)
                {
                }       
    return sw;
}
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(ChkRequiereVisita.isSelected()==true)
        {
              int registro;
                                             
        
        int año = FechaVisita.getCalendar().get(Calendar.YEAR);
           int año2= txtFechaActual.getCalendar().get(Calendar.YEAR);
          
           if(año<año2)
           {
               JOptionPane.showConfirmDialog(null, "La fecha provable de servicio no puede ser menor a la fecha actual");
           }
           else
           {
                int mes = 1+ FechaVisita.getCalendar().get(Calendar.MONTH);
                int mes2 = 1+ txtFechaActual.getCalendar().get(Calendar.MONTH);
               
                if(mes<mes2)
                {
                    JOptionPane.showMessageDialog(null, "La fecha provable de servicio no puede ser menor a la fecha actual");
                }
                else
                {
                   
              
       int response = JOptionPane.showConfirmDialog(null, "¿Realizar cotizacion?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION)
    {
        
   
    } 
    else if (response == JOptionPane.YES_OPTION) {
         if(txtTotal.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar las cantidades");
        //////////////////////
        else if(txtNombre.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar el nombre del cliente");
        //////////////////////
        else if(txtApellidos.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar los apellidos del cliente");
        //////////////////////
        else if(txtDireccion.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar la direccion del cliente");
        //////////////////////
        else if(txtApellidos.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar los apellidos del cliente");
         else if(!email(txtCorreoElectronico.getText()))
            JOptionPane.showMessageDialog(null,"Favor de ingresar correos con extenciones gmail o hotmail");
       
         else
        {
        
                                             
        
         año = FechaProbable.getCalendar().get(Calendar.YEAR);
            año2= txtFechaActual.getCalendar().get(Calendar.YEAR);
          
           if(año<año2)
           {
               JOptionPane.showConfirmDialog(null, "La fecha provable de servicio no puede ser menor a la fecha actual");
           }
           else
           {
                 mes = 1+ FechaProbable.getCalendar().get(Calendar.MONTH);
                 mes2 = 1+ txtFechaActual.getCalendar().get(Calendar.MONTH);
               
                if(mes<mes2)
                {
                    JOptionPane.showMessageDialog(null, "La fecha provable de servicio no puede ser menor a la fecha actual");
                }
                else
                {
                    int dia = FechaProbable.getCalendar().get(Calendar.DAY_OF_MONTH);
                    int dia2 = txtFechaActual.getCalendar().get(Calendar.DAY_OF_MONTH);
                     
                    if(dia<dia2)
                    {
                        JOptionPane.showMessageDialog(null, "La fecha provable de servicio no puede ser menor a la fecha actual");
                    }
                    else
                    {
                                       String FechaServicio = año2+"-"+mes2+"-"+dia2;         
                    String FechaActual = año+"-"+mes+"-"+dia;
        
        
            guardarDatos();
            GuardarArticulos();  
            GuardarCliente();
            Limpiar();
              int respons = JOptionPane.showConfirmDialog(null, "¿Realizar Reservacion?", "Confirm",
             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if (respons == JOptionPane.YES_OPTION)
             {
            Reservacion abrir = new Reservacion();
            abrir.setVisible(true);
            this.dispose();
   
            } 
                
                    }
      
        
           }
   
      
            
        }
        }
      
    } 
        
           }
   
      
            
        }
        }
      else
        {
            ////////////////////
                       
       int response = JOptionPane.showConfirmDialog(null, "¿Realizar cotizacion?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION)
    {
        
   
    } 
    else if (response == JOptionPane.YES_OPTION) {
         if(txtTotal.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar las cantidades");
        //////////////////////
        else if(txtNombre.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar el nombre del cliente");
        //////////////////////
        else if(txtApellidos.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar los apellidos del cliente");
        //////////////////////
        else if(txtDireccion.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar la direccion del cliente");
        //////////////////////
        else if(txtApellidos.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Favor de ingresar los apellidos del cliente");
         else
        {
        
                                             
        
        int  año = FechaProbable.getCalendar().get(Calendar.YEAR);
           int año2= txtFechaActual.getCalendar().get(Calendar.YEAR);
          
           if(año<año2)
           {
               JOptionPane.showConfirmDialog(null, "La fecha provable de servicio no puede ser menor a la fecha actual");
           }
           else
           {
                 int mes = 1+ FechaProbable.getCalendar().get(Calendar.MONTH);
                int mes2 = 1+ txtFechaActual.getCalendar().get(Calendar.MONTH);
               
                if(mes<mes2)
                {
                    JOptionPane.showMessageDialog(null, "La fecha provable de servicio no puede ser menor a la fecha actual");
                }
                else
                {
                    int dia = FechaProbable.getCalendar().get(Calendar.DAY_OF_MONTH);
                    int dia2 = txtFechaActual.getCalendar().get(Calendar.DAY_OF_MONTH);
                     
                    if(dia<dia2)
                    {
                        JOptionPane.showMessageDialog(null, "La fecha provable de servicio no puede ser menor a la fecha actual");
                    }
                    else
                    {
                                       String FechaServicio = año2+"-"+mes2+"-"+dia2;         
                    String FechaActual = año+"-"+mes+"-"+dia;
        
        
            guardarDatos();
            GuardarArticulos();  
            GuardarCliente();
            Limpiar();
              int respons = JOptionPane.showConfirmDialog(null, "¿Realizar Reservacion?", "Confirm",
             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if (respons == JOptionPane.YES_OPTION)
             {
            Reservacion abrir = new Reservacion();
            abrir.setVisible(true);
            this.dispose();
   
            } 
                
                    }
      
        
           }
   
      
            
        }
        }
      
    } 
        }
        
        
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void ComboVivienda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboVivienda2ActionPerformed

        String Vivienda = (String) ComboVivienda2.getSelectedItem();

        estado_municipio.CveVivienda(Vivienda,txtViviendaDestino);
    }//GEN-LAST:event_ComboVivienda2ActionPerformed

    private void ComboMunicipio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMunicipio2ActionPerformed
        String Municipio = (String) ComboMunicipio2.getSelectedItem();

        estado_municipio.itemsCombo3(Municipio,ComboMunicipio2,txtCveMunicipioDestino);

    }//GEN-LAST:event_ComboMunicipio2ActionPerformed

    private void ComboEstado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEstado2ActionPerformed

        ComboMunicipio2.removeAllItems();
        String Estado = (String) ComboEstado2.getSelectedItem();

        estado_municipio.itemsCombo2(Estado,ComboMunicipio2,txtCVeEstado,txtCveMunicipioDestino);

    }//GEN-LAST:event_ComboEstado2ActionPerformed

    private void ComboViviendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboViviendasActionPerformed

        String Vivienda = (String) ComboViviendas.getSelectedItem();

        estado_municipio.CveVivienda(Vivienda,txtCveVivienda);
    }//GEN-LAST:event_ComboViviendasActionPerformed

    private void ComboMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMunicipioActionPerformed

        String Municipio = (String) ComboMunicipio.getSelectedItem();

        estado_municipio.itemsCombo3(Municipio,ComboMunicipio,txtCveMunicipio);

    }//GEN-LAST:event_ComboMunicipioActionPerformed

    private void ComboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEstadoActionPerformed

        ComboMunicipio.removeAllItems();
        String Estado = (String) ComboEstado.getSelectedItem();

        estado_municipio.itemsCombo2(Estado,ComboMunicipio,txtCveEstado,txtCveMunicipio);

    }//GEN-LAST:event_ComboEstadoActionPerformed

    private void txtTelCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelCasaActionPerformed
public void Limpiar()
{
    txtTransporte.setText("");
            txtAlmacenaje.setText("");
            txtEmpaque.setText("");
            txtRentas.setText("");
            txtVentas.setText("");
            txtSeguro.setText("");
            txtManiobras.setText("");
            txtManiobras.setText("");
            txtSubtotal.setText("");
            txtIVA.setText("");
            txtTotal.setText("");
            txtAnticipo.setText("");
            txtAnticipo.setText("");
            ChkIVA.setSelected(false);
            ChkSeguro.setSelected(false);
            txtSumaAsegurada.setText("");
            jTextArea3.setText("");
            txtTotalFinal.setText("");
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
           txtSalto.setText("");
}
    private void txtCorreoElectronicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoKeyTyped

        char CteclaPresionada=evt.getKeyChar();

        if(CteclaPresionada==KeyEvent.VK_ENTER)
        {
            
            Limpiar();
            
            for(int i=0;i<TablaArticulos.getRowCount();i++)
            {
                ((DefaultTableModel)TablaArticulos.getModel()).setRowCount(i);
            }
            
            
            buscar();
            ComboMunicipio.removeAllItems();
            String Estado = (String) ComboEstado.getSelectedItem();

            estado_municipio.itemsCombo2(String.valueOf(esta),ComboMunicipio,txtCveEstado,txtCveMunicipio);

        }
    }//GEN-LAST:event_txtCorreoElectronicoKeyTyped

    private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoElectronicoActionPerformed

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
           getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtDireccionDestinoActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void txtDireccionDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionDestinoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionDestinoKeyTyped
/*
    private void txtDireccionDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionDestinoActionPerformed
       
        
        
        
        
    }//GEN-LAST:event_txtDireccionDestinoActionPerformed
*/
    private void TablaArticulosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaArticulosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaArticulosKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCveViviendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCveViviendaKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtCveViviendaKeyTyped

    private void txtTelCasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelCasaKeyTyped
         char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui solo van numeros tonto!");            
            evt.consume();
        }
    }//GEN-LAST:event_txtTelCasaKeyTyped

    private void txtMovilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovilKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui solo van numeros tonto!");            
            evt.consume();
        }
    }//GEN-LAST:event_txtMovilKeyTyped

    private void txtPisosOrigenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisosOrigenKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui solo van numeros tonto!");            
            evt.consume();
        }
    }//GEN-LAST:event_txtPisosOrigenKeyTyped

    private void txtIdentificacionClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionClienteKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui solo van numeros tonto!");            
            evt.consume();
        }
    }//GEN-LAST:event_txtIdentificacionClienteKeyTyped

    private void txtFolioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c))
        {
            getToolkit().beep();
           // JOptionPane.showMessageDialog(null,"Aqui solo van numeros tonto!");            
            evt.consume();
        }
    }//GEN-LAST:event_txtFolioKeyTyped

    private void txtNombreDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDestinoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreDestinoKeyTyped

    private void txtViviendaDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtViviendaDestinoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtViviendaDestinoKeyTyped

    private void txtTelCasaDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelCasaDestinoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtTelCasaDestinoKeyTyped

    private void txtTelCelDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelCelDestinoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtTelCelDestinoKeyTyped

    private void txtPisosDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisosDestinoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtPisosDestinoKeyTyped

    private void txtNumerosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumerosKeyTyped
       char c = evt.getKeyChar();
        if (!Character.isDigit(c))
        {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null,"Aqui no van numeros tonto!");
            evt.consume();
        }
    }//GEN-LAST:event_txtNumerosKeyTyped

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
            java.util.logging.Logger.getLogger(Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>



                  try 
    {
     UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
    } 
    catch (Exception e) 
      {
      e.printStackTrace();
    }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cotizaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChkIVA;
    private javax.swing.JCheckBox ChkRequiereVisita;
    private javax.swing.JCheckBox ChkSeguro;
    private javax.swing.JComboBox<String> ComboEstado;
    private javax.swing.JComboBox<String> ComboEstado2;
    private javax.swing.JComboBox<String> ComboMunicipio;
    private javax.swing.JComboBox<String> ComboMunicipio2;
    private javax.swing.JComboBox<String> ComboSeguro;
    private javax.swing.JComboBox<String> ComboVivienda2;
    private javax.swing.JComboBox<String> ComboViviendas;
    private com.toedter.calendar.JDateChooser FechaProbable;
    private com.toedter.calendar.JDateChooser FechaVisita;
    private javax.swing.JSpinner SpnIVA;
    private javax.swing.JTable TablaArticulos;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField txtAlmacenaje;
    private javax.swing.JTextField txtAnticipo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtArticulos;
    private javax.swing.JTextField txtCVeEstado;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtCveEstado;
    private javax.swing.JTextField txtCveMunicipio;
    private javax.swing.JTextField txtCveMunicipioDestino;
    private javax.swing.JTextField txtCveVivienda;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionDestino;
    private javax.swing.JTextField txtEmpaque;
    private com.toedter.calendar.JDateChooser txtFechaActual;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtIdentificacionCliente;
    private javax.swing.JTextField txtManiobras;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreDestino;
    private javax.swing.JTextField txtNumeros;
    private javax.swing.JTextField txtPisosDestino;
    private javax.swing.JTextField txtPisosOrigen;
    private javax.swing.JTextField txtPropietario;
    private javax.swing.JTextField txtRentas;
    private javax.swing.JTextField txtRetencion;
    private javax.swing.JTextField txtSalto;
    private javax.swing.JTextField txtSeguro;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtSumaAsegurada;
    private javax.swing.JTextField txtTelCasa;
    private javax.swing.JTextField txtTelCasaDestino;
    private javax.swing.JTextField txtTelCelDestino;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalFinal;
    private javax.swing.JTextField txtTransporte;
    private javax.swing.JTextField txtVentas;
    private javax.swing.JTextField txtViviendaDestino;
    private javax.swing.JTextField txtVolumenTotal;
    // End of variables declaration//GEN-END:variables
}
