/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FuncionarioController;
import controller.ClienteController;
import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.Cidade;
import model.Funcionario;
import tools.Combos;
import tools.*;

/**
 *
 * @author jonasdhein
 */
public class FuncionarioView extends javax.swing.JFrame {

    /**
     * Creates new form ViewAlunos
     */
    Funcionario objFuncionario;
    Combos cbCidade;
    
    public FuncionarioView() {
        initComponents();
        
        try{
            
           //CARREGAR CIDADES EXISTENTES
            atualizarTabela();
            
            limparTela();
            
            this.getContentPane().setBackground(Color.WHITE);
            
            //SETA A BARRA LATERAL DA JTABLE
            jScrollPane2.setViewportView(jtbFuncionario);

            //carregar as cidades
            cbCidade= new Combos(jcbCidades);
            cbCidade.PreencheCombo("SELECT codcidade, nome FROM cidade ORDER BY nome");
            
        }catch(Exception ex){
            System.out.println("Erro ao atualizar os dados inicias da tela");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tppessoagroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lblCpfCpnj = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbFuncionario = new javax.swing.JTable();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtNome = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDescricao = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jcbCidades = new javax.swing.JComboBox<>();
        txtCpf = new javax.swing.JFormattedTextField();
        lblNome = new javax.swing.JLabel();
        txtCargo = new javax.swing.JFormattedTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblCpfCpnj.setText("CPF");

        lblCidade.setText("Cidade:");

        lblCodigo.setText("Código");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jtbFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbFuncionario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbFuncionarioMouseClicked(evt);
            }
        });
        jtbFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbFuncionarioKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbFuncionario);

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-add.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/device-computer.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Clientes");

        lblDescricao.setText("Cargo: ");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        lblTelefone.setText("Telefone:");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-right.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jcbCidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCpfMouseClicked(evt);
            }
        });
        txtCpf.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCpfInputMethodTextChanged(evt);
            }
        });
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        lblNome.setText("Nome:");

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefone))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCpfCpnj)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCidade)
                                    .addComponent(jcbCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNome))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(lblDescricao))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblNome)
                    .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCidade)
                            .addComponent(lblCpfCpnj)
                            .addComponent(lblTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jtbFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFuncionarioMouseClicked
        // TODO add your handling code here:
        //pega a linha selecionada
         int linhaSelecionada = jtbFuncionario.getSelectedRow();
         // Primeira coluna da linha que é o código
         String coluna1 = jtbFuncionario.getModel().getValueAt(linhaSelecionada, 0).toString();
         //System.out.println(coluna1);
         objFuncionario = new Funcionario();
         FuncionarioController objFuncionarioCon = new FuncionarioController(objFuncionario, null);
         objFuncionario = objFuncionarioCon.buscar(coluna1);
         
         preencheCampos(); 
    }//GEN-LAST:event_jtbFuncionarioMouseClicked

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
     
        
        if (validarDados() == true) {
        
            guardarDados();

             FuncionarioController objFuncionarioCon = new FuncionarioController(objFuncionario, null);
            try {
                if (objFuncionarioCon.incluir() == true) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Funcionario incluido com sucesso!");
                    atualizarTabela();
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir Funcionario!");
                }
            } catch (Exception ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
            }

            limparTela();
        } else {
              CaixaDeDialogo.obterinstancia().exibirMensagem("Preencha os dados corretamente!");
              return;
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            
        if (validarLinha() == true) {
        
            if(validarDados() == true){

                guardarDados();

                FuncionarioController objFuncionarioCon = new FuncionarioController(objFuncionario, null);
                if (objFuncionarioCon.alterar() == true) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Funcionario alterado com Sucesso!");
                    atualizarTabela();
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar Funcionario");
                }

                limparTela();
                } else {
              CaixaDeDialogo.obterinstancia().exibirMensagem("Preencha os dados corretamente!");
              return;
                  }
                }

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       if (validarLinha() == true) {
         boolean pergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Você realmente deseja remover este registro?", "Atenção", 'p');
         if (pergunta == true) {
       String codfuncionario = txtCodigo.getText();
       FuncionarioController objFuncionarioCon = new FuncionarioController(null, null);
        try {
            if (objFuncionarioCon.excluir(codfuncionario) == true) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Funcionario removido com Sucesso!");
                atualizarTabela();
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao remover Funcionario!");
            }
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
       }
        limparTela();
         } else {
           return;
       }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void jtbFuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbFuncionarioKeyPressed
        // TODO add your handling code here:
         jtbFuncionarioMouseClicked(null);
    }//GEN-LAST:event_jtbFuncionarioKeyPressed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
                
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:        
        
    }//GEN-LAST:event_txtCargoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCpfMouseClicked
        // TODO add your handling code here:
                 MaskFormatter CPFMask;
        
        try { 
        CPFMask = new MaskFormatter("###.###.###-##");
        txtCpf.setValue(null); 
        txtCpf.setFormatterFactory(new DefaultFormatterFactory(CPFMask));
        
         } catch (ParseException ex) {
           System.out.println("Erro ao formatar CPF!");
        }
    }//GEN-LAST:event_txtCpfMouseClicked

    private void txtCpfInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCpfInputMethodTextChanged
        // TODO add your handling code here:
        
                 MaskFormatter CPFMask;
        
        try { 
        CPFMask = new MaskFormatter("###.###.###-##");
        txtCpf.setValue(null); 
        txtCpf.setFormatterFactory(new DefaultFormatterFactory(CPFMask));
        
         } catch (ParseException ex) {
           System.out.println("Erro ao formatar CPF!");
        }
    }//GEN-LAST:event_txtCpfInputMethodTextChanged

     private void limparTela() {
        try {
            //BLOQUEIA A ALTERAÇÃO DO CAMPO CÓDIGO
            txtCodigo.setEditable(false);
            
            //LIMPAR OS CAMPOS DA TELA

            txtCpf.setFormatterFactory(null);
            
            txtCodigo.setText("");
            txtCpf.setText("");
            txtNome.setText("");
            txtCargo.setText("");
            txtTelefone.setText("");
            jcbCidades.setSelectedIndex(0);
            
            Formatacao.reformatarTelefone(txtTelefone);
            tppessoagroup.clearSelection();
            
            
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }

     private void atualizarTabela() {
           try{
            
            FuncionarioController objFuncionarioCon = new FuncionarioController(null, jtbFuncionario);
            objFuncionarioCon.preencheFuncionario();
            
        }catch(Exception ex){
            System.out.println("Erro ao atualizar os dados inicias da tela");
        }
     }
     
      private boolean validarLinha () {
      int linha = jtbFuncionario.getSelectedRow();
      
      try {
        if (linha<0) {
           CaixaDeDialogo.obterinstancia().exibirMensagem("Selecione uma linha!");
           return false;
            }    
      } catch (Exception ex) {
          CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
      }
      
      return true;
  }
      
        private void guardarDados() {
        try {           
            if (objFuncionario == null) {
                objFuncionario = new Funcionario();
            }
            
            objFuncionario.setNome(txtNome.getText().toUpperCase());
            objFuncionario.setCargo(txtCargo.getText());
            objFuncionario.setTelefone(txtTelefone.getText());
            objFuncionario.setCpf(txtCpf.getText());

            //RECUPERANDO O CODIGO DO CURSO DO JCOMBOBOX
            Combos c = (Combos) jcbCidades.getSelectedItem();
            String codigoCidade = c.getCodigo();
            objFuncionario.setCodcidade(Integer.parseInt(codigoCidade));

            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
    }
        
         private void preencheCampos() {
        try {
            if (objFuncionario.getCpf().length() == 14) {
            } 
            txtCodigo.setText(String.valueOf(objFuncionario.getCodFuncionario()));
            txtCpf.setText(objFuncionario.getCpf());
            txtNome.setText(objFuncionario.getNome());
            txtTelefone.setText(objFuncionario.getTelefone());
            txtCargo.setText(objFuncionario.getCargo());
            
            //VENDO QUAL ITEM FOI SELECIONADO DA COMBOBOX
            cbCidade.SetaComboBox(String.valueOf(objFuncionario.getCodcidade()));
 
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro no prencheCampos " + ex.getMessage());
        }
    }
         
     private boolean validarDados() {
        try {   
          if(    
             //VALIDA OS CAMPOS DA TELA     
             txtCpf.getText().trim().equals("") ||
             txtNome.getText().trim().equals("") ||
             txtTelefone.getText().trim().equals("") ||
             txtCargo.getText().trim().equals("") ||
             ((txtCpf.getText().trim().length() <14) ) ||
             Validacao.validarTelefone(txtTelefone) == false ||
                  
                  
             //VALIDA SE A COMBOBOX ESTÁ SELECIONADA CORRETAMENTE   
             jcbCidades.getSelectedIndex() == 0)  {        
             return false;
           }
           
            return true;
        } catch (Exception ex) {
            //RETURN FALSE SE ALGUM CAMPO NAO ESTA PREENCHIDO CORRETAMENTE
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
            return false;
        }
    }
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CidadeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CidadeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CidadeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CidadeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CidadeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbCidades;
    private javax.swing.JTable jtbFuncionario;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCpfCpnj;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.ButtonGroup tppessoagroup;
    private javax.swing.JFormattedTextField txtCargo;
    private javax.swing.JFormattedTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}