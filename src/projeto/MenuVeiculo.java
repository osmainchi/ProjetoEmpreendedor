/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class MenuVeiculo extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuVeiculo() {
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

        jLabelLogo = new javax.swing.JLabel();
        jButtonCadastrarMotorista = new javax.swing.JButton();
        jButtonBuscarDemandas = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonAlterarCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Gestão de Rotas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/74ec9ee6-a826-4d38-ba41-d7db8d8fed22_200x200.png"))); // NOI18N

        jButtonCadastrarMotorista.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonCadastrarMotorista.setText("Cadastrar Veiculo");
        jButtonCadastrarMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarMotoristaActionPerformed(evt);
            }
        });

        jButtonBuscarDemandas.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonBuscarDemandas.setText("Buscar Veiculo");
        jButtonBuscarDemandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarDemandasActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonAlterarCadastro.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonAlterarCadastro.setText("Alterar Cadastro Veiculo");
        jButtonAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 290, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAlterarCadastro)
                    .addComponent(jButtonBuscarDemandas)
                    .addComponent(jButtonCadastrarMotorista))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButtonCadastrarMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButtonAlterarCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButtonBuscarDemandas)
                .addGap(63, 63, 63)
                .addComponent(jButtonVoltar)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarMotoristaActionPerformed
                    MenuVeiculoCadastrar veiculocadastrar = new MenuVeiculoCadastrar();
                    veiculocadastrar.setVisible(true);
                    dispose();
    }//GEN-LAST:event_jButtonCadastrarMotoristaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
                    MenuPrincipal menu = new MenuPrincipal();
                    menu.setVisible(true);
                    dispose();                
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonBuscarDemandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarDemandasActionPerformed
                    MenuBuscar buscar = new MenuBuscar();
                    buscar.setVisible(true);
                    dispose();    
    }//GEN-LAST:event_jButtonBuscarDemandasActionPerformed

    private void jButtonAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarCadastroActionPerformed
                    MenuVeiculoAlterar veiculoalterar = new MenuVeiculoAlterar();
                    veiculoalterar.setVisible(true);
                    dispose();
    }//GEN-LAST:event_jButtonAlterarCadastroActionPerformed

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
            java.util.logging.Logger.getLogger(MenuVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarCadastro;
    private javax.swing.JButton jButtonBuscarDemandas;
    private javax.swing.JButton jButtonCadastrarMotorista;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelLogo;
    // End of variables declaration//GEN-END:variables
}
