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
import model.Funcionario;

/**
 *
 * @author Windows
 */
public class FuncionarioController {
    Funcionario objFuncionario = null;
    JTable jtbFuncionario = null;
    
    public FuncionarioController(Funcionario objFuncionario, JTable jtbFuncionario) {
        this.objFuncionario = objFuncionario;
        this.jtbFuncionario = jtbFuncionario;

    }
    
     public void preencheFuncionario() {
        try{
            
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("CPF");
        cabecalhos.add("Telefone");
        cabecalhos.add("Cargo");
        cabecalhos.add("Cidade");

        ResultSet result = null;
        
       try {

            String SQL = "";
            SQL = " SELECT f.codfuncionario, f.nome, f.cpf, f.telefone, f.cargo, ci.nome";
            SQL += " FROM funcionario f, cidade ci";
            SQL += " WHERE f.codcidade = ci.codcidade";
            
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
            System.out.println("Erro no FuncionarioController para preencher a tabela Cidade!");
            System.out.println(e);
        }

        jtbFuncionario.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            //Não deixa editar as linhas da tabela
            public boolean isCellEditable(int row, int column) {
              return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        jtbFuncionario.setSelectionMode(0);
        
        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <=5; i++) {
            column = jtbFuncionario.getColumnModel().getColumn(i);
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
        
        jtbFuncionario.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
     
     public Funcionario buscar(String id)
    {
         try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT f.codfuncionario, f.nome, f.cpf, f.telefone, f.cargo, f.codcidade";
            SQL += " FROM funcionario f, cidade ci";
            SQL += " WHERE f.codcidade = ci.codcidade";
            SQL += " AND codfuncionario= '" + id + "'";

            try{
                System.out.println("Vai Executar Conexão em buscar Cidade");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar Cidade");

                objFuncionario = new Funcionario();
                
                if(rs.next() == true)
                {
                    objFuncionario.setCodFuncionario(rs.getInt(1));
                    objFuncionario.setNome(rs.getString(2));
                    objFuncionario.setCpf(rs.getString(3));
                    objFuncionario.setTelefone(rs.getString(4));
                    objFuncionario.setCargo(rs.getString(5));
                    objFuncionario.setCodcidade(rs.getInt(6));
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
        return objFuncionario;
    }
      
     public boolean incluir(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario (nome, cpf, telefone, cargo, codcidade) VALUES (?,?,?,?,?)");
            stmt.setString(1, objFuncionario.getNome());
            stmt.setString(2, objFuncionario.getCpf());
            stmt.setString(3, objFuncionario.getTelefone());
            stmt.setString(4, objFuncionario.getCargo());
            stmt.setInt(5, objFuncionario.getCodcidade());
            
            
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
            stmt = con.prepareStatement("UPDATE funcionario SET nome=?, cpf=?, telefone=?, cargo=?, codcidade=? WHERE codfuncionario=?");
            stmt.setString(1, objFuncionario.getNome());
            stmt.setString(2, objFuncionario.getCpf());
            stmt.setString(3, objFuncionario.getTelefone());
            stmt.setString(4, objFuncionario.getCargo());
            stmt.setInt(5, objFuncionario.getCodcidade());;

            stmt.setInt(6, objFuncionario.getCodFuncionario());
            
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
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE codfuncionario ='"+codigo+"'");   
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
