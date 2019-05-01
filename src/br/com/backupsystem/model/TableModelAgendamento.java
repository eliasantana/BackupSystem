/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backupsystem.model;

import br.com.backupsystem.utils.Utils;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Elias Santana
 */
public class TableModelAgendamento extends AbstractTableModel {
    Utils u = new Utils();
    
    private final ArrayList<Agendamento> listaProduto = new ArrayList<>();
    String colunas[] = {"", "HORÁRIO", "DOMINGO", "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SÁBADO", "BACKUP"};
    String formatoHora;

    @Override
    public int getRowCount() {
        return listaProduto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return listaProduto.get(row).getId();
            case 1:
                return listaProduto.get(row).getDom();
            case 2:
                return listaProduto.get(row).getSeg();
            case 3:
                return listaProduto.get(row).getTer();
            case 4:
                return listaProduto.get(row).getQua();
            case 5:
                return listaProduto.get(row).getQui();
            case 6:
                return listaProduto.get(row).getSex();
            case 7:
                return listaProduto.get(row).getSab();
            case 8:
                return listaProduto.get(row).getHora();
            case 9:
                return listaProduto.get(row).getTipo();
            default:
                return listaProduto.get(row);
        }

    }

    @Override
    public String getColumnName(int row) {
        return this.colunas[row];
    }

    public void redimensionaColunas(JTable tabela) {
        //{"CÓDIGO",  "HORÁRIO", "DOMINGO", "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SÁBADO","BACKUP"}
        DefaultTableCellRenderer cor = new DefaultTableCellRenderer();
       
        
        cor.setBackground(Color.yellow);
        cor.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumn(tabela.getColumnName(0)).setPreferredWidth(70);
        tabela.getColumn(tabela.getColumnName(1)).setPreferredWidth(70);
        tabela.getColumn(tabela.getColumnName(2)).setPreferredWidth(70);
        tabela.getColumn(tabela.getColumnName(3)).setPreferredWidth(70);
        tabela.getColumn(tabela.getColumnName(4)).setPreferredWidth(70);
        tabela.getColumn(tabela.getColumnName(5)).setPreferredWidth(70);
        tabela.getColumn(tabela.getColumnName(6)).setPreferredWidth(70);
        tabela.getColumn(tabela.getColumnName(7)).setPreferredWidth(60);
        tabela.getColumn(tabela.getColumnName(8)).setPreferredWidth(60);
        tabela.getColumn(tabela.getColumnName(9)).setPreferredWidth(110);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabela.getColumnModel().getColumn(0).setMaxWidth(0);
        tabela.getColumnModel().getColumn(0).setMinWidth(0);
        
        
        int coluna = 0;
        // Recebe o dia da semana.
        String diaDaSemana = u.retornaDiaDaSemana();
        // Verifica o dia e atribui o valor da coluna correspondente no TableModel.
        switch (diaDaSemana){
            case "dom":
            coluna = 2;
            break;
            case "seg":
            coluna = 3;
            break;
            case "ter":
            coluna = 4;
            break;
            case "qua":
            coluna = 5;
            break;
            case "qui":
            coluna = 6;
            break;
            case "sex":
            coluna = 7;
            break;
            case "sab":
            coluna = 8;
            break;
        }
        // Adiciona cor a coluna
        tabela.getColumnModel().getColumn(coluna).setCellRenderer(cor);
       
        
        
        System.out.println("Hoje: "+ u.retornaDiaDaSemana());
        adicionaCoresTabela(tabela);
    }

    public void adicionaCoresTabela(JTable tabela) {
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        if ("0".equals(hora) || hora <= 9) {
            formatoHora = "0" + String.valueOf(hora) + ":00:00";
        } else {
            formatoHora = String.valueOf(hora) + ":00:00";
        }
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //A coluna do status é 8
                Object ref = table.getValueAt(row, 1);//Coluna qtd

                if (ref.equals(formatoHora)) {
                    setBackground(Color.YELLOW);//Preenche a linha de vermelho
                    setForeground(Color.BLACK);//E a fonte de branco

                } else {
                    boolean sel = isSelected;
                    if (sel == true) {
                        setBackground(getBackground());
                        setForeground(getForeground());
                    } else {//Se Status não for "Pendente" 
                        setBackground(Color.WHITE);//Preenche a linha de branco
                        setForeground(new Color(51, 51, 51));//E a fonte de preto
                    }
                }
                return this;
            }
        });

    }

}
