/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.utils;

import br.com.backupsystem.view.Teste;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
     
    public void executaModuloBackup(){
        try {
           Runtime.getRuntime().exec("cmd /c start C:/SysBar/BackupSystem.jar");
           
        } catch (IOException e) {
            System.out.println("br.com.backupsystem.view.Teste.jButton1ActionPerformed()"+e);
        }
    }
    
    public void criaArquivoFlag(String path){
        
        File f = new File(path);         
        try {
            if (f.exists()){
                 System.out.println("O arquivo Existe");                 
            }else {
                f.createNewFile();     
                System.out.println("Arquivo Criado com sucesso!");               
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean estaExecutando(String path){
    
            File f = new File(path);
            boolean resp=false;
            if (f.exists()){
                resp=true;
            }
            return resp;
    }
    
    public void deletaArquivo(String path){
        File f = new File(path);
        if (f.delete()){
            System.out.println("Flag deletada!");
        }
              
    }
    
}
