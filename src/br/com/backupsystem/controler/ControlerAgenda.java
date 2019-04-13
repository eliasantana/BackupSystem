/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.controler;

import br.com.backupsystem.dao.ConexaoBd;
import br.com.backupsystem.model.Agendamento;
import br.com.backupsystem.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Elias Santana
 */
public class ControlerAgenda {

    Utils u = new Utils();

    Connection conexao = ConexaoBd.conector();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ArrayList<String> lerAgendamento() {
        String colunaDia = u.retornaDiaDaSemana();
       
        ArrayList<String> listaAgendamento = new ArrayList<>();
        String sql = "SELECT " + colunaDia + ", hora, tipo FROM dbbar.tbagenda\n"
                + "WHERE " + colunaDia + "=1 ORDER BY hora asc;";

        try {

            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            while (rs.next()) {
                //listaAgendamento.add(rs.getString(colunaDia));
                listaAgendamento.add(rs.getString("hora"));
                // listaAgendamento.add(rs.getString("tipo"));
            }
        } catch (SQLException e) {
        }

        return listaAgendamento;
    }

    public void imprimeAgendamento(ArrayList<String> agendas) {

        for (int i = 0; i < agendas.size(); i++) {
            System.out.println(agendas.get(i));

        }

    }

    // Registra um agendamento
    public boolean adicionaAgendamento(Agendamento a) {
        boolean resp = false;
        String sql = "INSERT INTO tbagenda (dom, seg, ter, qua, qui, sex, sab, hora, tipo) VALUES (?,?,?,?,?,?,?,?,?)";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setInt(1, a.getDom());
            pst.setInt(2, a.getSeg());
            pst.setInt(3, a.getTer());
            pst.setInt(4, a.getQua());
            pst.setInt(5, a.getQui());
            pst.setInt(6, a.getSex());
            pst.setInt(7, a.getSab());
            pst.setString(8, a.getHora());
            pst.setString(9, a.getTipo().toString());

            pst.executeUpdate();
            resp = true;
        } catch (SQLException e) {
            System.out.println("br.com.backupsystem.controler.ControlerAgenda.adicionaAgendamento()" + e);
        }

        return resp;
    }

    public ResultSet listaAgendamento() {
        //String sql="SELECT * FROM tbagenda ORDER BY hora asc";
        String sql = "SELECT \n"
                + "    id as 'CÓDIGO', \n"
                + "     time_format(hora,'%H:%i:%s')  as 'HORÁRIO' , \n"
                + "    \n"
                + "    CASE \n"
                + "		WHEN dom=0 THEN '-'\n"
                + "		WHEN dom=1 THEN 'OK'\n"
                + "    ELSE dom END AS 'DOMINGO',\n"
                + "    \n"
                + "    CASE\n"
                + "		WHEN seg=1  THEN 'OK'\n"
                + "		WHEN seg=0  THEN '-'\n"
                + "    ELSE seg END as 'SEGUNDA',\n"
                + "    \n"
                + "    CASE \n"
                + "		WHEN ter=1 THEN 'OK'\n"
                + "        WHEN ter=0 THEN '-'\n"
                + "    ELSE ter END AS 'TERÇA', \n"
                + "    \n"
                + "    \n"
                + "    CASE \n"
                + "		WHEN qua=0 THEN '-'\n"
                + "        WHEN qua=1 THEN 'OK'\n"
                + "    else qua END AS 'QUARTA',\n"
                + "    \n"
                + "    CASE \n"
                + "		WHEN qui=0 THEN '-'\n"
                + "        WHEN qui=1 THEN 'OK'\n"
                + "    ELSE qui END as 'QUINTA',\n"
                + "    \n"
                + "    CASE \n"
                + "		WHEN sex=0 THEN '-'\n"
                + "        WHEN sex=1 THEN 'OK'\n"
                + "    ELSE sex END as 'SEXTA', \n"
                + "    \n"
                + "    CASE \n"
                + "		WHEN sab=0 THEN '-'\n"
                + "        WHEN sab=1 THEN 'OK'\n"
                + "        \n"
                + "    ELSE sab END as 'SÁBADO',\n"
                + "    tipo  as 'BACKUP'   \n"
                + "    \n"
                + "   \n"
                + "    \n"
                + "FROM\n"
                + "    dbbar.tbagenda ORDER BY hora asc;";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println("br.com.backupsystem.controler.ControlerAgenda.listaAgendamento()" + e);
        }

        return rs;
    }

    /**
     * Verifica o agendamento já existe
     *
     * @return
     * @param agenda
     *
     */
    public boolean temAgendamento(Agendamento agenda) {
        boolean resp = false;
        String horario;
        String sql = "SELECT * FROM tbagenda";
        ArrayList<Agendamento> listaDeAgendamento = new ArrayList<>();
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                Agendamento a = new Agendamento();
                a.setDom(rs.getInt("dom"));
                a.setSeg(rs.getInt("seg"));
                a.setTer(rs.getInt("ter"));
                a.setQua(rs.getInt("qua"));
                a.setQui(rs.getInt("qui"));
                a.setSex(rs.getInt("sex"));
                a.setSab(rs.getInt("sab"));
                a.setHora(rs.getString("hora"));

                String tipo = rs.getString("tipo");
                switch (tipo) {
                    case "Total":
                        a.setTipo(Agendamento.Tipo.TOTAL);
                        break;
                    case "Diferencial":
                        a.setTipo(Agendamento.Tipo.DIFERENCIAL);
                        break;
                    case "Incremental":
                        a.setTipo(Agendamento.Tipo.INCREMENTAL);
                        break;
                }

                listaDeAgendamento.add(a);

            }

            for (int i = 0; i < listaDeAgendamento.size(); i++) {
                if (listaDeAgendamento.get(i).equals(agenda)) {
                    JOptionPane.showMessageDialog(null, "Objeto Existe");
                    resp = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("br.com.backupsystem.controler.ControlerAgenda.temAgendamento()" + e);
        }

        return resp;
    }

    public boolean temAgendamento(String diaDaSemana, String hora) {
        boolean resp = false;
        String sql = "SELECT  hora FROM dbbar.tbagenda where " + diaDaSemana + " AND hora =? order by hora asc;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, hora);
            rs = pst.executeQuery();

            while (rs.next()) {
                resp = true;
            }

        } catch (SQLException e) {
        }

        return resp;
    }

    /**
     * Retorna o id do Horário Informado.
     *
     * @param horario Horário a ser localizado.
     * @return id Id do horário Informado.
     */
    public int retornaIdHorario(String horario) {
        String sql = "SELECT id FROM dbbar.tbagenda\n"
                + "WHERE hora=?";
        int id = 0;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, horario);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("br.com.backupsystem.controler.ControlerAgenda.retornaIdHorario()" + e);
        }

        return id;
    }

    public boolean alteraAgendamento(String colunaDia, String idHorario) {

        String sql = "UPDATE tbagenda SET " + colunaDia + "=1 WHERE id=?";
        boolean resp = false;

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, idHorario);
            pst.executeUpdate();

            resp = true;
        } catch (SQLException e) {
            System.out.println("br.com.backupsystem.controler.ControlerAgenda.atualizaAgendamento()" + e);
        }

        return resp;
    }
    public boolean alteraAgendamento(Agendamento a) {

        String sql = "UPDATE tbagenda SET dom=?, seg=?, ter=?, qua=?, qui=?, sex=?, sab=? WHERE id=?";
        boolean resp = false;

        try {
            pst = conexao.prepareStatement(sql);
           
            pst.setInt(1, a.getDom());
            pst.setInt(2, a.getSeg());
            pst.setInt(3, a.getTer());
            pst.setInt(4, a.getQua());
            pst.setInt(5, a.getQui());
            pst.setInt(6, a.getSex());
            pst.setInt(7, a.getSab());
            pst.setInt(8, a.getId());
            
            pst.executeUpdate();

            resp = true;
        } catch (SQLException e) {
            System.out.println("br.com.backupsystem.controler.ControlerAgenda.atualizaAgendamento()" + e);
        }

        return resp;
    }

}
