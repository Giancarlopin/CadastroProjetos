/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Cidade;
import model.Projeto;

/**
 *
 * @author Windows
 */
public class ProjetoController {
    Projeto objProjeto = null;
    JTable jtbProjeto = null;
    
    public ProjetoController(Projeto objProjeto, JTable jtbProjeto) {
        this.objProjeto = objProjeto;
        this.jtbProjeto = jtbProjeto;

    }
    
     public void preencheProjeto() {
        try{
            
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("Descrição");
        cabecalhos.add("Data Inicio");
        cabecalhos.add("Data Fim");
        cabecalhos.add("Situação");

        ResultSet result = null;
        
       try {

            String SQL = "";
            SQL = " SELECT p.codprojeto, p.nmprojeto, p.dsprojeto, p.dtinicio, p.dtfim, p.situacao";
            SQL += " FROM projeto p";
    
            
            result = ConnectionFactory.stmt.executeQuery(SQL);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
                linha.add(result.getString(5));
                linha.add(result.getString(6));
                dadosTabela.add(linha);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro no ProjetoController para preencher a tabela Equipe!");
            System.out.println(e);
        }

        jtbProjeto.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            //Não deixa editar as linhas da tabela
            public boolean isCellEditable(int row, int column) {
              return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        jtbProjeto.setSelectionMode(0);
        
        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <=5; i++) {
            column = jtbProjeto.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(100);
                    break;
                case 1:
                    column.setPreferredWidth(200);
                    break;
                case 2:
                    column.setPreferredWidth(150);
                    break;
                case 3:
                    column.setPreferredWidth(150);
                    break;
                case 4:
                    column.setPreferredWidth(500);
                    break;
                case 5:
                    column.setPreferredWidth(150);
                    break;
      
      
            }
        }
        
        jtbProjeto.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                 if (isSelected) {
                    setBackground(new Color(85, 172, 239));
                } else if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
        
        }catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage().toString());
        }
    }
     
     public Projeto buscar(String id)
    {
         try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT p.codprojeto, p.nmprojeto, p.dsprojeto, p.dtinicio, p.dtfim, p.situacao";
            SQL += " FROM projeto p";
            SQL += " WHERE codprojeto= '" + id + "'";

            try{
                System.out.println("Vai Executar Conexão em buscar Equipe");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar Equipe");

                objProjeto = new Projeto();
                
                if(rs.next() == true)
                {
                    objProjeto.setCodProjeto(rs.getInt(1));
                    objProjeto.setNmProjeto(rs.getString(2));
                    objProjeto.setDsProjeto(rs.getString(3));
                    objProjeto.setDtIncio(rs.getString(4));
                    objProjeto.setDtFim(rs.getString(5));
                    objProjeto.setSituacao(rs.getString(6));
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar Cidade com sucesso");
        return objProjeto;
    }
      
     public boolean incluir(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            /*stmt = con.prepareStatement("INSERT INTO projeto (nmprojeto, dsprojeto, dtinicio, dtfim, situacao) VALUES (?,?,?,?,?)");
            stmt.setString(1, objProjeto.getNmProjeto());
            stmt.setString(2, objProjeto.getDsProjeto());
            stmt.setString(3, objProjeto.getDtIncio());
            stmt.setString(4, objProjeto.getDtFim());
            stmt.setString(5,String.valueOf(objProjeto.getSituacao()) );*/
            
            stmt = con.prepareStatement("INSERT INTO projeto (nmprojeto, dsprojeto) VALUES (?,?)");
            stmt.setString(1, objProjeto.getNmProjeto());
            stmt.setString(2, objProjeto.getDsProjeto());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
     public boolean alterar(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {        
          /* stmt = con.prepareStatement("UPDATE projeto SET nmprojeto=?, dsprojeto=?,dtfim=?, situacao=? WHERE codprojeto=?");
            stmt.setString(1, objProjeto.getNmProjeto());
            stmt.setString(2, objProjeto.getDsProjeto());
            stmt.setString(3, objProjeto.getDtFim());
            stmt.setString(4, objProjeto.getSituacao());

            stmt.setInt(5, objProjeto.getCodProjeto());*/
            stmt = con.prepareStatement("UPDATE projeto SET nmprojeto=?, dsprojeto=? WHERE codprojeto=?");
            stmt.setString(1, objProjeto.getNmProjeto());
            stmt.setString(2, objProjeto.getDsProjeto());
            stmt.setInt(3, objProjeto.getCodProjeto());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
     
        public boolean excluir(String codigo){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM projeto WHERE codprojeto ='"+codigo+"'");   
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
