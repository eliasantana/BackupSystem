/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.view;

import br.com.backupsystem.controler.ControlerAgenda;
import br.com.backupsystem.model.Agendamento;
import br.com.backupsystem.utils.Utils;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Elias Santana
 */
public class TelaAlterarAgendamento extends javax.swing.JFrame {

    Agendamento ag = new Agendamento();
    TelaConsulta tc = new TelaConsulta();
    ControlerAgenda ca = new ControlerAgenda();
    TelaBackupTray bkpTray;
    Utils u = new Utils();
    
    public TelaAlterarAgendamento() {
        initComponents();
        u.setIcon(this);
    }
    
    public void recebeAgendamento(TelaConsulta tela, Agendamento a){
        lblHorario.setText(a.getHora());
        comboDom.setSelectedIndex(a.getDom());
        comboSeg.setSelectedIndex(a.getSeg());
        comboTer.setSelectedIndex(a.getTer());
        comboQua.setSelectedIndex(a.getQua());
        comboQui.setSelectedIndex(a.getQui());
        comboSex.setSelectedIndex(a.getSex());
        comboSab.setSelectedIndex(a.getSab());
        this.ag=a;
        this.tc=tela;
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
        jLabel2 = new javax.swing.JLabel();
        lbldom = new javax.swing.JLabel();
        comboDom = new javax.swing.JComboBox<>();
        lblHorario = new javax.swing.JLabel();
        lblSeg = new javax.swing.JLabel();
        comboSeg = new javax.swing.JComboBox<>();
        lblTer = new javax.swing.JLabel();
        comboTer = new javax.swing.JComboBox<>();
        lblQua = new javax.swing.JLabel();
        comboQua = new javax.swing.JComboBox<>();
        lblQui = new javax.swing.JLabel();
        comboQui = new javax.swing.JComboBox<>();
        comboSex = new javax.swing.JComboBox<>();
        lblSex = new javax.swing.JLabel();
        comboSab = new javax.swing.JComboBox<>();
        lblSab = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        lblSalvar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagem/clock.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jLabel2.setText("Alteração de Agendamento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 15, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 70));

        lbldom.setText("Domingo");
        getContentPane().add(lbldom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, -1, 23));

        comboDom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        comboDom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDomActionPerformed(evt);
            }
        });
        getContentPane().add(comboDom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 168, 58, -1));

        lblHorario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHorario.setText("jLabel4");
        getContentPane().add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 70, 470, -1));

        lblSeg.setText("Segunda");
        getContentPane().add(lblSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 23));

        comboSeg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        comboSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSegActionPerformed(evt);
            }
        });
        getContentPane().add(comboSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 168, 58, -1));

        lblTer.setText("Terça");
        getContentPane().add(lblTer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 47, 23));

        comboTer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        comboTer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTerActionPerformed(evt);
            }
        });
        getContentPane().add(comboTer, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 168, 58, -1));

        lblQua.setText("Quarta");
        getContentPane().add(lblQua, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, 23));

        comboQua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        comboQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboQuaActionPerformed(evt);
            }
        });
        getContentPane().add(comboQua, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 168, 58, -1));

        lblQui.setText("Quinta");
        getContentPane().add(lblQui, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, 23));

        comboQui.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        comboQui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboQuiActionPerformed(evt);
            }
        });
        getContentPane().add(comboQui, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 168, 58, -1));

        comboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        comboSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSexActionPerformed(evt);
            }
        });
        getContentPane().add(comboSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 168, 58, -1));

        lblSex.setText("Sexta");
        getContentPane().add(lblSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 23));

        comboSab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        comboSab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSabActionPerformed(evt);
            }
        });
        getContentPane().add(comboSab, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 168, 58, -1));

        lblSab.setText("Sábados");
        getContentPane().add(lblSab, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, 23));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 20, 70));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 10, 70));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 140, 13, 70));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 140, 10, 70));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 20, 70));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 20, 70));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 480, -1));

        lblSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagem/salvar32x32.png"))); // NOI18N
        lblSalvar.setText("Salvar");
        lblSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalvarMouseClicked(evt);
            }
        });
        getContentPane().add(lblSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 100, -1));

        setSize(new java.awt.Dimension(520, 314));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalvarMouseClicked
        
        if (ca.alteraAgendamento(ag)){
            JOptionPane.showMessageDialog(this, "Alteração realizada com sucesso!");
        }
        tc.atualizaTabela();
        bkpTray.atualizaHorario();
        dispose();
    }//GEN-LAST:event_lblSalvarMouseClicked

    private void comboDomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDomActionPerformed
        ag.setDom(comboDom.getSelectedIndex());
        if ("Sim".equals(comboDom.getSelectedItem().toString())){
            lbldom.setForeground(Color.blue);
        }else {
            lbldom.setForeground(Color.red);
        }
        
    }//GEN-LAST:event_comboDomActionPerformed

    private void comboSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSegActionPerformed
        ag.setSeg(comboSeg.getSelectedIndex());
         if ("Sim".equals(comboSeg.getSelectedItem().toString())){
            lblSeg.setForeground(Color.blue);
        }else {
            lblSeg.setForeground(Color.red);
        }
    }//GEN-LAST:event_comboSegActionPerformed

    private void comboTerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTerActionPerformed
         ag.setTer(comboTer.getSelectedIndex());
          if ("Sim".equals(comboTer.getSelectedItem().toString())){
            lblTer.setForeground(Color.blue);
        }else {
            lblTer.setForeground(Color.red);
        }
    }//GEN-LAST:event_comboTerActionPerformed

    private void comboQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboQuaActionPerformed
         ag.setQua(comboQua.getSelectedIndex());
          if ("Sim".equals(comboQua.getSelectedItem().toString())){
            lblQua.setForeground(Color.blue);
        }else {
            lblQua.setForeground(Color.red);
        }
    }//GEN-LAST:event_comboQuaActionPerformed

    private void comboQuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboQuiActionPerformed
        ag.setQui(comboQui.getSelectedIndex());
         if ("Sim".equals(comboQui.getSelectedItem().toString())){
            lblQui.setForeground(Color.blue);
        }else {
            lblQui.setForeground(Color.red);
        }
    }//GEN-LAST:event_comboQuiActionPerformed

    private void comboSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSexActionPerformed
         ag.setSex(comboSex.getSelectedIndex());
          if ("Sim".equals(comboSex.getSelectedItem().toString())){
            lblSex.setForeground(Color.blue);
        }else {
            lblSex.setForeground(Color.red);
        }
    }//GEN-LAST:event_comboSexActionPerformed

    private void comboSabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSabActionPerformed
        ag.setSab(comboSab.getSelectedIndex());
         if ("Sim".equals(comboSab.getSelectedItem().toString())){
            lblSab.setForeground(Color.blue);
        }else {
            lblSab.setForeground(Color.red);
        }
    }//GEN-LAST:event_comboSabActionPerformed
    
   public void recebeTela(TelaBackupTray tela){
       this.bkpTray = tela;
   }
   
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
            java.util.logging.Logger.getLogger(TelaAlterarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlterarAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDom;
    private javax.swing.JComboBox<String> comboQua;
    private javax.swing.JComboBox<String> comboQui;
    private javax.swing.JComboBox<String> comboSab;
    private javax.swing.JComboBox<String> comboSeg;
    private javax.swing.JComboBox<String> comboSex;
    private javax.swing.JComboBox<String> comboTer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblQua;
    private javax.swing.JLabel lblQui;
    private javax.swing.JLabel lblSab;
    private javax.swing.JLabel lblSalvar;
    private javax.swing.JLabel lblSeg;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblTer;
    private javax.swing.JLabel lbldom;
    // End of variables declaration//GEN-END:variables
}
