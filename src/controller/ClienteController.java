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
import model.Cliente;

/**
 *
 * @author Windows
 */
public class ClienteController {
    Cliente objCliente = null;
    JTable jtbClientes = null;
    
    public ClienteController(Cliente objCliente, JTable jtbClientes) {
        this.objCliente = objCliente;
        this.jtbClientes = jtbClientes;

    }
    
     public void preencheClientes() {
        try{
            
        ConnectionFactory.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("CNPJ/CPF");
        cabecalhos.add("Telefone");
        cabecalhos.add("Descrição");
        cabecalhos.add("Cidade");

        ResultSet result = null;
        
       try {

            String SQL = "";
            SQL = " SELECT c.codcliente, c.nome, c.cnpj_cpf, c.telefone, c.descricao, ci.nome";
            SQL += " FROM clientes c, cidade ci";
            SQL += " WHERE c.codcidade = ci.codcidade";
            
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
            System.out.println("Erro no ClienteController para preencher a tabela Cidade!");
            System.out.println(e);
        }

        jtbClientes.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            //Não deixa editar as linhas da tabela
            public boolean isCellEditable(int row, int column) {
              return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        jtbClientes.setSelectionMode(0);
        
        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <=5; i++) {
            column = jtbClientes.getColumnModel().getColumn(i);
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
        
        jtbClientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
     
     public Cliente buscar(String id)
    {
         try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT c.codcliente, c.nome, c.cnpj_cpf, c.telefone, c.descricao, c.codcidade";
            SQL += " FROM clientes c, cidade ci";
            SQL += " WHERE c.codcidade = ci.codcidade";
            SQL += " AND codcliente= '" + id + "'";

            try{
                System.out.println("Vai Executar Conexão em buscar Cidade");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar Cidade");

                objCliente = new Cliente();
                
                if(rs.next() == true)
                {
                    objCliente.setCodcliente(rs.getInt(1));
                    objCliente.setNome(rs.getString(2));
                    objCliente.setCnpj_cpf(rs.getString(3));
                    objCliente.setTelefone(rs.getString(4));
                    objCliente.setDescricao(rs.getString(5));
                    objCliente.setCodcidade(rs.getInt(6));
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
        return objCliente;
    }
      
     public boolean incluir(){
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO clientes (nome, cnpj_cpf, telefone, descricao, codcidade) VALUES (?,?,?,?,?)");
            stmt.setString(1, objCliente.getNome());
            stmt.setString(2, objCliente.getCnpj_cpf());
            stmt.setString(3, objCliente.getTelefone());
            stmt.setString(4, objCliente.getDescricao());
            stmt.setInt(5, objCliente.getCodcidade());
            
            
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
            stmt = con.prepareStatement("UPDATE clientes SET nome=?, cnpj_cpf=?, telefone=?, descricao=?, codcidade=? WHERE codcliente=?");
            stmt.setString(1, objCliente.getNome());
            stmt.setString(2, objCliente.getCnpj_cpf());
            stmt.setString(3, objCliente.getTelefone());
            stmt.setString(4, objCliente.getDescricao());
            stmt.setInt(5, objCliente.getCodcidade());;

            stmt.setInt(6, objCliente.getCodcliente());
            
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
            stmt = con.prepareStatement("DELETE FROM clientes WHERE codcliente ='"+codigo+"'");   
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
