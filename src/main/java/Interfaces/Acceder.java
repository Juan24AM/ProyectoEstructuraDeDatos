/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.awt.Color;

/**
 *
 * @author Daysuke
 */
public class Acceder extends javax.swing.JFrame {

    /**
     * Creates new form Acceder
     */
    public Acceder() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanelPrincipal = new javax.swing.JPanel();
        jLabelMensajeBienvenida = new javax.swing.JLabel();
        jLabelTextUsuario = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabelTextContraseña = new javax.swing.JLabel();
        JContraseña = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jContainerLogin = new javax.swing.JPanel();
        jTextLogin = new javax.swing.JLabel();
        jLabelInvitado = new javax.swing.JLabel();
        jPanelFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensajeBienvenida.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabelMensajeBienvenida.setText("BIENVENIDO, INICIA SESIÓN PARA CONTINUAR");
        jPanelPrincipal.add(jLabelMensajeBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabelTextUsuario.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabelTextUsuario.setText("USUARIO");
        jPanelPrincipal.add(jLabelTextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        jTextUsuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jTextUsuario.setText("Ingresa tu usuario");
        jTextUsuario.setBorder(null);
        jTextUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextUsuarioMousePressed(evt);
            }
        });
        jTextUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUsuarioActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jTextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 310, 40));

        jLabelTextContraseña.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabelTextContraseña.setText("CONTRASEÑA");
        jPanelPrincipal.add(jLabelTextContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        JContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JContraseña.setForeground(new java.awt.Color(153, 153, 153));
        JContraseña.setText("...............");
        JContraseña.setBorder(null);
        JContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JContraseñaMousePressed(evt);
            }
        });
        JContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JContraseñaActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(JContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 310, 40));
        jPanelPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 310, 20));
        jPanelPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 310, 20));

        jContainerLogin.setBackground(new java.awt.Color(142, 16, 85));
        jContainerLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextLogin.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextLogin.setForeground(new java.awt.Color(255, 255, 255));
        jTextLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextLogin.setText("LOGIN");
        jTextLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextLoginMouseExited(evt);
            }
        });
        jContainerLogin.add(jTextLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanelPrincipal.add(jContainerLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 150, 40));

        jLabelInvitado.setBackground(new java.awt.Color(255, 255, 255));
        jLabelInvitado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabelInvitado.setText("¿No tienes cuenta?, Continuar como invitado");
        jLabelInvitado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInvitado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInvitadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelInvitadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelInvitadoMouseExited(evt);
            }
        });
        jPanelPrincipal.add(jLabelInvitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 290, 40));

        jPanel2.add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 540, 500));

        jPanelFondo.setBackground(new java.awt.Color(196, 68, 140));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HOTEL LA VENIDA");
        jPanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, 80));

        jPanel2.add(jPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 500));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUsuarioActionPerformed

    private void JContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JContraseñaActionPerformed

    private void jTextLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextLoginMouseEntered
        jContainerLogin.setBackground(new Color(228, 156, 196));
    }//GEN-LAST:event_jTextLoginMouseEntered

    private void jTextLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextLoginMouseExited
        jContainerLogin.setBackground(new Color(142, 16, 85));
    }//GEN-LAST:event_jTextLoginMouseExited

    private void jTextUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextUsuarioMousePressed
        if (jTextUsuario.getText().equals("Ingresa tu usuario")){
            jTextUsuario.setText("");
            jTextUsuario.setForeground(Color.BLACK);
        }
        if (String.valueOf(JContraseña.getPassword()).isEmpty()){
            JContraseña.setText("...............");
            JContraseña.setForeground(Color.GRAY);
        }
        
    }//GEN-LAST:event_jTextUsuarioMousePressed

    private void JContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JContraseñaMousePressed

        if (String.valueOf(JContraseña.getPassword()).equals("...............")) {
            JContraseña.setText("");
            JContraseña.setForeground(Color.BLACK);
        }
         if (jTextUsuario.getText().isEmpty()){
            jTextUsuario.setText("Ingresa tu usuario");
            jTextUsuario.setForeground(Color.GRAY);
         }
        
    }//GEN-LAST:event_JContraseñaMousePressed

    private void jTextLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextLoginMouseClicked
        String contraseña = String.valueOf(JContraseña.getPassword());
        String usuario = jTextUsuario.getText();
        
        System.out.println(usuario + " " + contraseña);
        
        Admin admin = new Admin();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
        dispose(); // Cerramos la ventana actual
    }//GEN-LAST:event_jTextLoginMouseClicked

    private void jLabelInvitadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInvitadoMouseClicked
        Invitado invitado = new Invitado();
        invitado.setVisible(true);
        invitado.setLocationRelativeTo(null);
        dispose(); // Cerramos la ventana actual
    }//GEN-LAST:event_jLabelInvitadoMouseClicked

    private void jLabelInvitadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInvitadoMouseEntered
        jLabelInvitado.setForeground(new Color(142, 16, 85));
    }//GEN-LAST:event_jLabelInvitadoMouseEntered

    private void jLabelInvitadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInvitadoMouseExited
        jLabelInvitado.setForeground(Color.black);
    }//GEN-LAST:event_jLabelInvitadoMouseExited

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
            java.util.logging.Logger.getLogger(Acceder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acceder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JContraseña;
    private javax.swing.JPanel jContainerLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelInvitado;
    private javax.swing.JLabel jLabelMensajeBienvenida;
    private javax.swing.JLabel jLabelTextContraseña;
    private javax.swing.JLabel jLabelTextUsuario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jTextLogin;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
