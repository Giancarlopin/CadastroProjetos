/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Cidade;

/**
 *
 * @author Windows
 */
public class CidadeController {
    
    Cidade objCidade;
    JTable jtbPessoas = null;
    
    public CidadeController(Cidade objCidade, JTable jtbCidades) {
        this.objCidade = objCidade;
        this.jtbPessoas = jtbCidades;
    }
    
    
     public void preencheCidades() {
        try{
            
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("UF");
        cabecalhos.add("CEP");

        ResultSet result = null;
        
       try {

            String SQL = "";
            SQL = " SELECT codcidade, nome, uf, cep";
            SQL += " FROM cidade ";
            SQL += " ORDER BY codcidade ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
                dadosTabela.add(linha);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro na CidadeController para preencher a tabela Cidade!");
            System.out.println(e);
        }

        jtbPessoas.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            //Não deixa editar as linhas da tabela
            public boolean isCellEditable(int row, int column) {
              return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        jtbPessoas.setSelectionMode(0);
        
        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <4; i++) {
            column = jtbPessoas.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(100);
                    break;
                case 1:
                    column.setPreferredWidth(250);
                    break;
                case 2:
                    column.setPreferredWidth(100);
                    break;
                case 3:
                    column.setPreferredWidth(150);
                    break;
      
            }
        }
        
        jtbPessoas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
     
     public Cidade buscar(String id)
    {
         try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT codcidade, nome, uf, cep";
            SQL += " FROM cidade";
            SQL += " WHERE codcidade= '" + id + "'";

            try{
                System.out.println("Vai Executar Conexão em buscar Cidade");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar Cidade");

                objCidade = new Cidade();
                
                if(rs.next() == true)
                {
                    objCidade.setCodcidade(rs.getInt(1));
                    objCidade.setNome(rs.getString(2));
                    objCidade.setUf(rs.getString(3));
                    objCidade.setCep(rs.getString(4));
                    
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
        return objCidade;
    }
      
     public boolean incluir(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cidade (nome, uf, cep) VALUES (?,?,?)");
            stmt.setString(1, objCidade.getNome());
            stmt.setString(2, String.valueOf(objCidade.getUf()));
            stmt.setString(3, objCidade.getCep());
            
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
            stmt = con.prepareStatement("UPDATE cidade SET nome=?, cep=?, uf=? WHERE codcidade=?");
            stmt.setString(1, objCidade.getNome());
            stmt.setString(2, objCidade.getCep());
            stmt.setString(3, String.valueOf(objCidade.getUf()));

            //SETANDO O CÓDIGO DA PESSOA PARA ALTERAR
            stmt.setInt(4, objCidade.getCodcidade());
            
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
            stmt = con.prepareStatement("DELETE FROM cidade WHERE codcidade ='"+codigo+"'");   
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
