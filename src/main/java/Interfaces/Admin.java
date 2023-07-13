/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import backend.CallSQL;
import backend.ApiClienteV2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daysuke
 */
public class Admin extends javax.swing.JFrame {
    CallSQL registroHotel;
    String habitacionSeleccionada;
    
    //Declaración del formato de la tabla
    DefaultTableModel miModelo;
    String[] cabecera={"ID", "NOMBRE", "APELLIDOS", "DNI", "INGRESO", "SALIDA", "PAGO", "DESCRIPCIÓN", "Nº HABTACIÓN"};
    String[][] data={};
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    
    /**
     * Creates new form Admin
     */
    public Admin() {
        registroHotel= new CallSQL();
        initComponents();
        //Iniciando tabla
        miModelo = new DefaultTableModel(data, cabecera);
        jtaSalida.setModel(miModelo);
        cargarRegistros();
        agregarBotones();
}
    void vaciar_tabla(){
        int filas=jtaSalida.getRowCount();
        for(int i=0;i<filas;i++){
            miModelo.removeRow(0);
            
        } 
    }
    void agregarRegistro() {
        String nombre = jtxtnom.getText().toUpperCase();
        String apellidos = jtxtape.getText().toUpperCase();
        String dni = jtDni.getText();
        String ingreso = formato.format(jDateFechaIngreso.getDate());
        String salida = formato.format(jDateFechaSalida.getDate());
        String pagoText = jtPago.getText();
        pagoText = pagoText.replace("S/. ", "");
        String tipo_cuarto = jttipo_cuarto.getText();
        double pago;
        String habitacion = jtHabitacion.getText();

        if (!pagoText.isEmpty()) {
            pago = Double.parseDouble(pagoText);
            } else {
                // Manejo del caso cuando el campo está vacío, por ejemplo, asignar un valor predeterminado
                 pago = 0.0;
}
        String descripcion = jtDes.getText().toUpperCase();

        registroHotel.agregarRegistro(nombre, apellidos, dni, ingreso, salida, pago, descripcion, habitacion, tipo_cuarto);
        // Recargar registros
        cargarRegistros();
    }
    
    void eliminarRegistro() {
        String dni = JOptionPane.showInputDialog(this, "Ingrese el DNI del registro a eliminar:");
        if (dni != null && !dni.isEmpty()) {
            registroHotel.eliminarRegistroPorDNI(dni);
            cargarRegistros();
        }
    }

    private void cargarRegistros() {
        vaciar_tabla();

        List<CallSQL.Registro> registros = registroHotel.obtenerRegistros();
        for (CallSQL.Registro registro : registros) {
            miModelo.addRow(new Object[]{
                    registro.getId(),
                    registro.getNombre(),
                    registro.getApellidos(),
                    registro.getDni(),
                    registro.getIngreso(),
                    registro.getSalida(),
                    registro.getPago(),
                    registro.getDescripcion(),
                    registro.getHabitacion()
            });
        }
    }
    
    void agregarBotones() {
        buttonTipoCuarto.add(jttipo_cuarto);
        buttonTipoCuarto.add(jRadioDoble);
        buttonTipoCuarto.add(jRadioSuite);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        buttonTipoCuarto = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtxtape = new javax.swing.JTextField();
        jtHabitacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtnom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbl = new javax.swing.JButton();
        jbr = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtPago = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDateFechaSalida = new com.toedter.calendar.JDateChooser();
        jDateFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jtDes = new javax.swing.JTextField();
        jttipo_cuarto = new javax.swing.JRadioButton();
        jRadioDoble = new javax.swing.JRadioButton();
        jRadioSuite = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaSalida = new javax.swing.JTable();
        jbBuscar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtFiltrarNombre = new javax.swing.JTextField();
        jtFiltrarApellido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(690, 590));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 190, 190));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("UCV");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("HOTELES");
        jLabel6.setFocusable(false);
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ah.jpeg"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, 600));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, -10, 290, 646));

        jPanel5.setBackground(new java.awt.Color(204, 153, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtape.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtxtape.setForeground(new java.awt.Color(102, 102, 102));
        jtxtape.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtape.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtxtape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtapeActionPerformed(evt);
            }
        });
        jPanel5.add(jtxtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 250, 20));

        jtHabitacion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtHabitacion.setForeground(new java.awt.Color(102, 102, 102));
        jtHabitacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtHabitacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtHabitacionActionPerformed(evt);
            }
        });
        jPanel5.add(jtHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 160, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("DNI:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Apellidos:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jtxtnom.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtxtnom.setForeground(new java.awt.Color(102, 102, 102));
        jtxtnom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtnom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtxtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtnomActionPerformed(evt);
            }
        });
        jPanel5.add(jtxtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 250, 20));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Nombres:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Salida AAAA-MM-DD");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("REGISTRAR CLIENTE");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 34, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrar1.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 19, -1, -1));

        jbl.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga.png"))); // NOI18N
        jbl.setText("LIMPIAR");
        jbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblActionPerformed(evt);
            }
        });
        jPanel5.add(jbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 133, -1));

        jbr.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jbr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarusu.png"))); // NOI18N
        jbr.setText("REGISTRAR");
        jbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbrActionPerformed(evt);
            }
        });
        jPanel5.add(jbr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Ingreso AAAA-MM-DD");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jtDni.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtDni.setForeground(new java.awt.Color(102, 102, 102));
        jtDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtDni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDniActionPerformed(evt);
            }
        });
        jPanel5.add(jtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Ingresar S/.");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Descripción");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));

        jtPago.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtPago.setForeground(new java.awt.Color(102, 102, 102));
        jtPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtPago.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPagoActionPerformed(evt);
            }
        });
        jPanel5.add(jtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 250, 20));

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jDateFechaSalida.setBackground(new java.awt.Color(255, 255, 255));
        jDateFechaSalida.setForeground(new java.awt.Color(0, 153, 153));
        jDateFechaSalida.setDateFormatString("dd/MM/yyyy");
        jPanel5.add(jDateFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 150, 30));

        jDateFechaIngreso.setBackground(new java.awt.Color(255, 255, 255));
        jDateFechaIngreso.setForeground(new java.awt.Color(0, 153, 153));
        jDateFechaIngreso.setDateFormatString("dd/MM/yyyy");
        jPanel5.add(jDateFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 150, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Nº Habitación");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, -1, -1));

        jtDes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtDes.setForeground(new java.awt.Color(102, 102, 102));
        jtDes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtDes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtDes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtDesFocusGained(evt);
            }
        });
        jtDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDesActionPerformed(evt);
            }
        });
        jPanel5.add(jtDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 250, 20));

        jttipo_cuarto.setText("Sencilla");
        jPanel5.add(jttipo_cuarto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        jRadioDoble.setText("Doble");
        jPanel5.add(jRadioDoble, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        jRadioSuite.setText("Suite");
        jPanel5.add(jRadioSuite, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 70, -1));

        jLabel18.setText("Tipo Cuarto:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jLabel19.setText("Precio (S/. )");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel20.setText("199");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

        jLabel21.setText("80");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        jLabel22.setText("120");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jButton2.setText("VALIDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 600));

        jTabbedPane1.addTab("Registro", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(690, 590));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtaSalida.setBackground(new java.awt.Color(204, 153, 255));
        jtaSalida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtaSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "APELLIDOS", "DNI", "INGRESO", "SALIDA", "METODO", "PAGO", "DESCRIPCIÓN", "Nº HABTACIÓN"
            }
        ));
        jScrollPane1.setViewportView(jtaSalida);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 840, 410));

        jbBuscar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ojo.png"))); // NOI18N
        jbBuscar.setText("BUSCAR");
        jPanel2.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 180, 50));

        jbEliminar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        jbEliminar.setText("ELIMINAR");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 180, 50));

        jbActualizar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        jbActualizar.setText("ACTUALIZAR");
        jPanel2.add(jbActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 180, 50));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Filtar por nombre:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        jtFiltrarNombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtFiltrarNombre.setForeground(new java.awt.Color(102, 102, 102));
        jtFiltrarNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtFiltrarNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtFiltrarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFiltrarNombreActionPerformed(evt);
            }
        });
        jPanel2.add(jtFiltrarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 150, 20));

        jtFiltrarApellido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtFiltrarApellido.setForeground(new java.awt.Color(102, 102, 102));
        jtFiltrarApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtFiltrarApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtFiltrarApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtFiltrarApellidoActionPerformed(evt);
            }
        });
        jPanel2.add(jtFiltrarApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 150, 20));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Filtrar por apellido:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, -1, -1));

        jTabbedPane1.addTab("Datos", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbrActionPerformed

        agregarRegistro();
        JOptionPane.showMessageDialog(this, "Registro hecho exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarEntrada();
    }//GEN-LAST:event_jbrActionPerformed
    
    public void limpiarEntrada(){
        // Limpiar campos de texto
        jtxtnom.setText("");
        jtxtape.setText("");
        jtDni.setText("");
        jDateFechaSalida.setDate(null);
        jDateFechaIngreso.setDate(null);
        jtPago.setText("");
        jtDes.setText("");
        jtHabitacion.setText("");
        jtxtnom.setEnabled(true);
        jtxtape.setEnabled(true);
        buttonTipoCuarto.clearSelection();
    }
    
    private void jblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblActionPerformed
        limpiarEntrada();
    }//GEN-LAST:event_jblActionPerformed

    private void jtxtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtnomActionPerformed

    private void jtHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtHabitacionActionPerformed

    private void jtxtapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtapeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtapeActionPerformed

    private void jtFiltrarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFiltrarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFiltrarNombreActionPerformed

    private void jtFiltrarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtFiltrarApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtFiltrarApellidoActionPerformed

    private void jtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDniActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:

        eliminarRegistro();

    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dni = jtDni.getText();
        if (dni.length() >= 8 && dni.length() <= 11 && dni != ""){
            ApiClienteV2 apiClient = new ApiClienteV2(dni);
            String coRespuesta = apiClient.getRespuesta();
            if (coRespuesta.equals("0000")) {
                String nombre = apiClient.getNombre();
                String paterno = apiClient.getPaterno();
                String materno = apiClient.getMaterno();

                jtxtnom.setText(nombre);
                jtxtape.setText(paterno + " " + materno);
                jtxtnom.setEnabled(false);
                jtxtape.setEnabled(false);
                
            } else {
                JOptionPane.showMessageDialog(this, "Porfavor verifica el DNI, si el problema persiste, ingresa tus datos de forma manual.");
                jtxtnom.setText("");
                jtxtape.setText("");
                jtxtnom.setEnabled(true);
                jtxtape.setEnabled(true);
            }
                
        } else {
            JOptionPane.showMessageDialog(this, "Porfavor verifica que el dato este ingresado correctamente.");
            jtxtnom.setText("");
            jtxtape.setText("");
            jtxtnom.setEnabled(true);
            jtxtape.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDesActionPerformed
    
    public void calcularPago() {
        int preciiHab = 0;
        String tipHab = "";
        boolean tipSelecionado = false;
        Date fechaActual = new Date();

        
        if (jttipo_cuarto.isSelected()) {
            preciiHab = 80;
            tipHab = "Sencilla";
            tipSelecionado = true; 
        } else if (jRadioDoble.isSelected()){
            preciiHab = 120;
            tipHab = "Doble";
            tipSelecionado = true; 
        } else if (jRadioSuite.isSelected()) {
            preciiHab = 199;
            tipHab = "Suite";
            tipSelecionado = true; 
        }
        
        if (tipSelecionado && jDateFechaIngreso.getDate() != null && jDateFechaSalida.getDate() != null) {
            // Se calculan los dias que sera alquildo el cuarto.
            if (jDateFechaIngreso.getDate().before(fechaActual)){
                JOptionPane.showMessageDialog(this, "La fecha de ingreso no puede ser anterior a la actual.");
            } else if (jDateFechaSalida.getDate().before(jDateFechaIngreso.getDate())){
                JOptionPane.showMessageDialog(this, "La fecha de salida no puede ser anterior a la fecha de ingreso.");
            } else {
                String fechaIngreso = formato.format(jDateFechaIngreso.getDate());
                String fechaSalida = formato.format(jDateFechaSalida.getDate());
                LocalDate ingreso = LocalDate.parse(fechaIngreso);
                LocalDate salida = LocalDate.parse(fechaSalida);
                long diasTranscurridos = ChronoUnit.DAYS.between(ingreso, salida);

                double pagoTotal = diasTranscurridos * preciiHab;
                
                String dias = "";
                
                if (diasTranscurridos == 1)
                    dias = " DIA";
                else
                    dias = " DIAS";
                
                jtPago.setText (String.valueOf("S/. " + pagoTotal));
                jtDes.setText("TIPO: " + tipHab + ", " + diasTranscurridos + dias + ", TOTAL = S/. " +  pagoTotal);
            }
        } else if (!tipSelecionado)
            JOptionPane.showMessageDialog(this, "Seleciona el tipo de habitacion.");
        else
            JOptionPane.showMessageDialog(this, "Completa las fechas de ingreso y salida.");
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        calcularPago();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtDesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtDesFocusGained
        
    }//GEN-LAST:event_jtDesFocusGained

    private void jtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPagoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Admin();
            }
        });
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonTipoCuarto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateFechaIngreso;
    private com.toedter.calendar.JDateChooser jDateFechaSalida;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioDoble;
    private javax.swing.JRadioButton jRadioSuite;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbl;
    private javax.swing.JButton jbr;
    private javax.swing.JTextField jtDes;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtFiltrarApellido;
    private javax.swing.JTextField jtFiltrarNombre;
    private javax.swing.JTextField jtHabitacion;
    private javax.swing.JTextField jtPago;
    private javax.swing.JTable jtaSalida;
    private javax.swing.JRadioButton jttipo_cuarto;
    private javax.swing.JTextField jtxtape;
    private javax.swing.JTextField jtxtnom;
    // End of variables declaration//GEN-END:variables
}
