/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.utils;

import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Elias Santana
 */
public class Utils {
    
    public String retornaDiaDaSemana(){
        Calendar c = Calendar.getInstance();      
        String [] dia_da_semana  ={"dom","seg","ter","qua","qui","sex","sab"};
        //System.out.println(c.get(Calendar.DAY_OF_WEEK)-1);
        //System.out.println("Dia da Semana: "+dia_da_semana[c.get(Calendar.DAY_OF_WEEK)-1]);
        return dia_da_semana[c.get(Calendar.DAY_OF_WEEK)-1];
    }
    
     public void setIcon(JFrame frame) {
        String caminho="C:\\SysBar\\masterfood6.png";
        //ImageIcon imageIcon = new ImageIcon("C:\\Users\\Elias Santana\\Documents\\NetBeansProjects\\BackupSystem\\src\\br\\com\\imagem\\backup.png");
        ImageIcon imageIcon = new ImageIcon(caminho);
        Icon i = new ImageIcon(imageIcon.getImage());
        

        frame.setIconImage(imageIcon.getImage());
    }
    
}
