/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import backend.CallSQL;
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
    
    //Declaración del formato de la tabla
    DefaultTableModel miModelo;
    String[] cabecera={"ID", "NOMBRE", "APELLIDOS", "DNI", "INGRESO", "SALIDA", "PAGO", "DESCRIPCIÓN"};
    String[][] data={};

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
        String ingreso = jtIngreso.getText();
        String salida = jtSalida.getText();
        String pagoText = jtPago.getText();
        double pago;

        if (!pagoText.isEmpty()) {
            pago = Double.parseDouble(pagoText);
            } else {
                // Manejo del caso cuando el campo está vacío, por ejemplo, asignar un valor predeterminado
                 pago = 0.0;
}
        String descripcion = jtDes.getText().toUpperCase();

        registroHotel.agregarRegistro(nombre, apellidos, dni, ingreso, salida, pago, descripcion);
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
                    registro.getDescripcion()
            });
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtxtape = new javax.swing.JTextField();
        jtDes = new javax.swing.JTextField();
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
        jtIngreso = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtSalida = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtPago = new javax.swing.JTextField();
        jbRellenar = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(690, 590));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo-universidad-cesar-vallejo.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 190, 190));

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
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 600));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 290, 646));

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
        jPanel5.add(jtxtape, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 127, 250, 20));

        jtDes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtDes.setForeground(new java.awt.Color(102, 102, 102));
        jtDes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtDes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDesActionPerformed(evt);
            }
        });
        jPanel5.add(jtDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 250, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("DNI o CE:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 165, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Apellidos:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 127, -1, -1));

        jtxtnom.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtxtnom.setForeground(new java.awt.Color(102, 102, 102));
        jtxtnom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtnom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtxtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtnomActionPerformed(evt);
            }
        });
        jPanel5.add(jtxtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 87, 250, 20));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Nombres:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 87, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Salida AAAA-MM-DD");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

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
        jPanel5.add(jbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 133, -1));

        jbr.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jbr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarusu.png"))); // NOI18N
        jbr.setText("REGISTRAR");
        jbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbrActionPerformed(evt);
            }
        });
        jPanel5.add(jbr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Ingreso AAAA-MM-DD");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jtDni.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtDni.setForeground(new java.awt.Color(102, 102, 102));
        jtDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtDni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDniActionPerformed(evt);
            }
        });
        jPanel5.add(jtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 165, 250, 20));

        jtIngreso.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtIngreso.setForeground(new java.awt.Color(102, 102, 102));
        jtIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtIngreso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtIngresoActionPerformed(evt);
            }
        });
        jPanel5.add(jtIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 180, 20));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("T. Pago");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jtSalida.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtSalida.setForeground(new java.awt.Color(102, 102, 102));
        jtSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtSalida.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtSalidaActionPerformed(evt);
            }
        });
        jPanel5.add(jtSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 180, 20));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Descripción");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jtPago.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtPago.setForeground(new java.awt.Color(102, 102, 102));
        jtPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtPago.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPagoActionPerformed(evt);
            }
        });
        jPanel5.add(jtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 250, 20));

        jbRellenar.setText("RELLENAR");
        jbRellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRellenarActionPerformed(evt);
            }
        });
        jPanel5.add(jbRellenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 600));

        jTabbedPane1.addTab("Registro", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(690, 590));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtaSalida.setBackground(new java.awt.Color(204, 153, 255));
        jtaSalida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtaSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "APELLIDOS", "DNI", "INGRESO", "SALIDA", "METODO", "PAGO", "DESCRIPCIÓN"
            }
        ));
        jScrollPane1.setViewportView(jtaSalida);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 670, 410));

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

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 627));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbrActionPerformed
        // TODO add your handling code here:
        
        agregarRegistro();
    }//GEN-LAST:event_jbrActionPerformed

    private void jblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblActionPerformed
        // TODO add your handling code here:
        // Limpiar campos de texto
        jtxtnom.setText("");
        jtxtape.setText("");
        jtDni.setText("");
        jtIngreso.setText("");
        jtSalida.setText("");
        jtPago.setText("");
        jtDes.setText("");

    }//GEN-LAST:event_jblActionPerformed

    private void jtxtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtnomActionPerformed

    private void jtDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtDesActionPerformed

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

    private void jtIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtIngresoActionPerformed

    private void jtSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtSalidaActionPerformed

    private void jtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPagoActionPerformed

    private void jbRellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRellenarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbRellenarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:

        eliminarRegistro();

    }//GEN-LAST:event_jbEliminarActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbRellenar;
    private javax.swing.JButton jbl;
    private javax.swing.JButton jbr;
    private javax.swing.JTextField jtDes;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtFiltrarApellido;
    private javax.swing.JTextField jtFiltrarNombre;
    private javax.swing.JTextField jtIngreso;
    private javax.swing.JTextField jtPago;
    private javax.swing.JTextField jtSalida;
    private javax.swing.JTable jtaSalida;
    private javax.swing.JTextField jtxtape;
    private javax.swing.JTextField jtxtnom;
    // End of variables declaration//GEN-END:variables
}
