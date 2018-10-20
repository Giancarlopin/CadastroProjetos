/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CidadeController;
import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import model.Cidade;
import tools.Combos;
import tools.*;

/**
 *
 * @author jonasdhein
 */
public class CidadeView extends javax.swing.JFrame {

    /**
     * Creates new form ViewAlunos
     */
    Cidade objCidade;
    
    public CidadeView() {
        initComponents();
        
        try{
            
           //CARREGAR CIDADES EXISTENTES
            atualizarTabela();
             
            limparTela();
           
            this.getContentPane().setBackground(Color.WHITE);
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
        lblCep = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblUf = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JFormattedTextField();
        jcbUf = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCidades = new javax.swing.JTable();
        btnIncluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JTextField();

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
        setTitle("Tela Cidades");
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblCep.setText("CEP:");

        lblNome.setText("Nome:");

        lblUf.setText("UF:");

        lblCodigo.setText("Código");

        jcbUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     ", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jtbCidades.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbCidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCidadesMouseClicked(evt);
            }
        });
        jtbCidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbCidadesKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbCidades);

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-add.png"))); // NOI18N
        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-right.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cidades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo)
                    .addComponent(lblCep)
                    .addComponent(txtCep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbUf, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUf))
                .addGap(260, 260, 260))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCep)
                    .addComponent(lblUf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbUf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jtbCidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCidadesMouseClicked
        // TODO add your handling code here:
        //pega a linha selecionada
         int linhaSelecionada = jtbCidades.getSelectedRow();
         // Primeira coluna da linha que é o código
         String coluna1 = jtbCidades.getModel().getValueAt(linhaSelecionada, 0).toString();
         //System.out.println(coluna1);
         objCidade = new Cidade();
         CidadeController objCidadeCon = new CidadeController(objCidade, null);
         objCidade = objCidadeCon.buscar(coluna1);
         
         preencheCampos();
    }//GEN-LAST:event_jtbCidadesMouseClicked

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
     
        
        if (validarDados() == true) {
            //PREENCHE O OBJETO ALUNO
            guardarDados();

             CidadeController objCidadeCon = new CidadeController(objCidade, null);
            try {
                if (objCidadeCon.incluir() == true) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Cidade incluida com sucesso!");
                    atualizarTabela();
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir cidade!");
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

                CidadeController objCidadeCon = new CidadeController(objCidade, null);
                if (objCidadeCon.alterar() == true) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Cidade alterada com Sucesso!");
                    atualizarTabela();
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar cidade");
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
        boolean pergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Você realmente deseja remover este registro?", "Atenção", 'p');
       if (pergunta == true) {
           
           if (validarLinha() == true) {
          String codcidade = txtCodigo.getText();
          CidadeController objCidadeCon = new CidadeController(null, null);
        try {
            if (objCidadeCon.excluir(codcidade) == true) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Cidade removida com Sucesso!");
                atualizarTabela();
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao remover cidade!");
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

    private void jtbCidadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbCidadesKeyPressed
        // TODO add your handling code here:
        jtbCidadesMouseClicked(null);     
    }//GEN-LAST:event_jtbCidadesKeyPressed

     private void limparTela() {
        try {
            
            //BLOQUEIA A ALTERAÇÃO DO CAMPO CÓDIGO
            txtCodigo.setEditable(false);

            //LIMPAR OS CAMPOS DA TELA
            //LIBERAR O CAMPO MATRICULA
            txtCodigo.setText("");
            txtNome.setText("");
            txtCep.setText("");
            jcbUf.setSelectedIndex(0);
            
           //FORMATAR CEP
           Formatacao.reformatarCEP(txtCep);
             
           jtbCidades.getSelectionModel().clearSelection();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }

     private void atualizarTabela() {
           try{
            
            CidadeController objCidadeCon = new CidadeController(null, jtbCidades);
            objCidadeCon.preencheCidades();
            
        }catch(Exception ex){
            System.out.println("Erro ao atualizar os dados inicias da tela");
        }
     }
     
      private boolean validarLinha () {
      int linha = jtbCidades.getSelectedRow();
      
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
            if (objCidade == null) {
            objCidade = new Cidade();
            }
            
            objCidade.setNome(txtNome.getText().toUpperCase());
            objCidade.setCep(txtCep.getText());
            
            //VENDO QUAL ITEM FOI SELECIONADO DA COMBOBOX
            int valor = jcbUf.getSelectedIndex();
            String uf = jcbUf.getItemAt(valor);
            objCidade.setUf(uf);
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
    }
        
         private void preencheCampos() {
        try {

            txtCodigo.setText(String.valueOf(objCidade.getCodcidade()));
            txtNome.setText(objCidade.getNome());
            txtCep.setText(objCidade.getCep());
            jcbUf.setSelectedItem(objCidade.getUf());
            
            //VENDO QUAL ITEM FOI SELECIONADO DA COMBOBOX
            jcbUf.setSelectedItem(objCidade.getUf());
 
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro no prencheCampos " + ex.getMessage());
        }
    }
         
     private boolean validarDados() {
        try {   
          if(   
             //VALIDA OS CAMPOS DA TELA     
             txtNome.getText().trim().equals("") ||
             txtCep.getText().trim().equals("") ||
             Validacao.validarCEP(txtCep) == false ||
                  
             //VALIDA SE A COMBOBOX ESTÁ SELECIONADA CORRETAMENTE   
             jcbUf.getSelectedIndex() == 0)  {        
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbUf;
    private javax.swing.JTable jtbCidades;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblUf;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
