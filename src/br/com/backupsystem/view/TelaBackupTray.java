/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.view;

import br.com.backupsystem.controler.ControlerAgenda;
import br.com.backupsystem.dao.AutenticaUsuario;
import br.com.backupsystem.dao.Backup;
import java.awt.AWTException;
import java.awt.Frame;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Elias Santana
 */
public class TelaBackupTray extends javax.swing.JFrame {

    /**
     * Creates new form BackupTray
     */
    ControlerAgenda ca = new ControlerAgenda();

    final SystemTray systemTray = SystemTray.getSystemTray();
    ArrayList<String> agendamento = ca.lerAgendamento();///Excluir 
    ArrayList<String> horarios = ca.lerAgendamento();
   
    int proxBackup;
    String hora = null;

    public TelaBackupTray() {
        initComponents();
        
        moveToTray();
        long minutos = (60000);//Uma chacagem a cada 1Min
        Timer timer = new Timer();
        //horarios = ca.lerAgendamento();
        Calendar horaInicial = Calendar.getInstance();

        proxBackup = horaInicial.get(Calendar.HOUR_OF_DAY);
        System.out.println("Próximo backup agendado para->: " + proxBackup);

        TimerTask verificaAgenda = new TimerTask() {

            @Override
            public void run() {

                Calendar c = Calendar.getInstance();
                if (c.get(Calendar.HOUR_OF_DAY) <= 9 || c.get(Calendar.HOUR_OF_DAY) == 0) {

                    hora = "0" + String.valueOf(c.get(Calendar.HOUR_OF_DAY) + ":00:00");

                } else {
                    hora = String.valueOf(c.get(Calendar.HOUR_OF_DAY) + ":00:00");
                }

                if (proxBackup == c.get(Calendar.HOUR_OF_DAY)) {

                    for (int i = 0; i < horarios.size(); i++) {

                        if (hora.equals(horarios.get(i))) {

                            proxBackup = proxBackup + 1;
                            System.out.println("Removendo Horário: " + horarios.get(i));
                            System.out.println("O Próximo backup será as ->: " + proxBackup + ":00:00");
                            horarios.remove(i);
                            System.out.println("Realizando Backup agrora->" + c.getTime());
                            //mensagem("Realizando Backup agora!...");
                            Backup bkp = new Backup();
                            
                            try {
                                bkp.realizaBackup();
                            } catch (IOException e) {
                                System.out.println(".run()"+" Erro ao realizar o Backup!");
                                JOptionPane.showMessageDialog(null, ".run()"+" Erro ao realizar o Backup!");
                            }
                        }

                    }
                }
                System.out.println("-----------------------------Verificando------------------------------------");
                System.out.println(horarios.toString());

            }
        };

        timer.scheduleAtFixedRate(verificaAgenda, 0, minutos);
        //Recarregar lista as 00:00h
        
         
         
    }

    private void moveToTray() {
        String caminho="C:\\SysBar\\masterfood6.png";
        ImageIcon imageIcon = new ImageIcon(caminho);
        //ImageIcon imageIcon = new ImageIcon("C:\\Users\\Elias Santana\\Documents\\NetBeansProjects\\BackupSystem\\src\\br\\com\\imagem\\masterfood6.png");
        Icon i = new ImageIcon(imageIcon.getImage());   
        

        if (!SystemTray.isSupported()) {            
            JOptionPane.showMessageDialog(this, "O seu sistema operacional não suporta a execução!");
            return;
        }

        //final SystemTray systemTray = SystemTray.getSystemTray();
        //final TrayIcon trayIcon = new TrayIcon(new ImageIcon(icoPath, "omt").getImage(), "QuickStage");
        final TrayIcon trayIcon = new TrayIcon(new ImageIcon(imageIcon.toString(), "omt").getImage(), "BKP MasterFood");

        trayIcon.setImageAutoSize(true);// Autosize icon base on space

        // Mouse
        MouseAdapter mouseAdapter = new MouseAdapter() {

            // Exibir
            @Override
            public void mouseClicked(MouseEvent e) {
                systemTray.remove(trayIcon);
                setState(Frame.NORMAL);
                setVisible(true);
            }
        };

        // Ocultar
        trayIcon.addMouseListener(mouseAdapter);
        try {
            systemTray.add(trayIcon);
            setVisible(false);
            trayIcon.displayMessage("Aviso!", "Backup MasterFood sendo executado em segundo plano!", TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
            System.out.println("br.com.backupsystem.view.TelaBackupTray.moveToTray()");
            JOptionPane.showMessageDialog(null, "br.com.backupsystem.view.TelaBackupTray.moveToTray()"+e);
        }

    }
    
    public void atualizaHorario(){
        horarios = ca.lerAgendamento();        
    }
    
    public void mensagem(String mensagem){
       
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
        txtSenha = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Senha");

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/imagem/cadeado2.png"))); // NOI18N
        lblTitulo.setText("IDENTIFIQUE-SE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(174, 104));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iniciaAutenticacao();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciaAutenticacao();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

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
            java.util.logging.Logger.getLogger(TelaBackupTray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBackupTray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBackupTray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBackupTray.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBackupTray().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    private void iniciaAutenticacao() {
        AutenticaUsuario auth = new AutenticaUsuario();
        if (auth.autentica("Admin".toLowerCase(), txtSenha.getText().toLowerCase())) {
            moveToTray();
            txtSenha.setText(null);
            
            TelaConsulta c = new TelaConsulta();
            c.setTitle("BackupSystem - Agendamento.");
            c.recebeTela(this);
            c.setVisible(true);

        } else {
            moveToTray();
        }
    }
}
