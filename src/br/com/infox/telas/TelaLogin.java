package br.com.infox.telas;

import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * 
 * @author Edivan Cardoso
 */
public class TelaLogin extends javax.swing.JFrame {

    // variáveis para conexão com o DB - dal
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void logar() {
        String sql = "select * from tb_usuarios where login=? and senha=?";
        try {
            // Consulta ao DB informando o usuário e a senha
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUser.getText());
            String captura = new String(txtPass.getPassword());
            pst.setString(2, captura);
            // Execua a query
            rs = pst.executeQuery();
            if (rs.next()) {
                // obter o conteúdo do campo perfil do DB.
                String perfil = rs.getString(6);
                //System.out.println(perfil);
                if (perfil.equals("admin")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.menRel.setEnabled(true);
                    TelaPrincipal.menCadUser.setEnabled(true);
                    TelaPrincipal.lblUser.setText(rs.getString(2));
                    TelaPrincipal.lblUser.setForeground(Color.red);
                    this.dispose();
                } else {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.lblUser.setText(rs.getString(2));
                    this.dispose();
                }
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public TelaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        //System.out.println(conexao);
        if (conexao != null) {
            lblConect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/dbOk-50x50.png")));
        } else {
            lblConect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/dbFail-50x50.png")));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lblConect = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X System - Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuário");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 175, 60, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Senha");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 60, -1));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 200, -1));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 80, -1));
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 255, 200, -1));

        lblConect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/dbOk-50x50.png"))); // NOI18N
        getContentPane().add(lblConect, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 50, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/users_156x156.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 160, 160));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/background/back01_420x340.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        logar();
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblConect;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
