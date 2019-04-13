/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.view;

import java.awt.TrayIcon;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Elias Santana
 */
class trayIcon {

    public void mensagem(String mensagem) {
        String caminho = "C:\\SysBar\\masterfood6.png";
        ImageIcon imageIcon = new ImageIcon(caminho);
        //ImageIcon imageIcon = new ImageIcon("C:\\Users\\Elias Santana\\Documents\\NetBeansProjects\\BackupSystem\\src\\br\\com\\imagem\\masterfood6.png");
        Icon i = new ImageIcon(imageIcon.getImage());
        final TrayIcon trayIcon = new TrayIcon(new ImageIcon(imageIcon.toString(), "omt").getImage(), "BKP MasterFood");
        trayIcon.setImageAutoSize(true);// Autosize icon base on space
        try {
            trayIcon.displayMessage("Aviso", "Realizando backup agora!", TrayIcon.MessageType.INFO);
        } catch (Exception e) {
        }
    }

}
