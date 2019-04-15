/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author elias
 */
public class ConexaoBd {

    public static Connection conector() {
        

        //Instancia o controler parâmetro e carrega os dados do arquivo param.txt  
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbbar?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "202649";
        //String password = "123456";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);           
            return conexao;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("br.com.bar.dao.ConexaoBd.conector()" + e);
            
            
        }
        return conexao;
            }
    
 

    public void desconectaBd() {
        try {
            ConexaoBd.conector().close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

                                   }
