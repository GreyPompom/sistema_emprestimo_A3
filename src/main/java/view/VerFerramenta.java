
package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Ferramenta;
 
public class VerFerramenta extends javax.swing.JFrame {
 private Ferramenta objetoFerramenta;
   
    public VerFerramenta() {
        initComponents();
        this.objetoFerramenta = new Ferramenta(); 
        this.carregaTabela();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFerramentas = new javax.swing.JTable();
        inputID = new javax.swing.JTextField();
        inputNome = new javax.swing.JTextField();
        inputMarca = new javax.swing.JTextField();
        inputPreco = new javax.swing.JTextField();
        inputStatus = new javax.swing.JTextField();
        deletar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Fechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        tabelaFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço", "Marca", "Status"
            }
        ));
        tabelaFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFerramentas);

        inputStatus.setDragEnabled(true);

        deletar.setBackground(new java.awt.Color(255, 51, 51));
        deletar.setText("Deletar");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });

        atualizar.setBackground(new java.awt.Color(102, 255, 102));
        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Preço");

        jLabel4.setText("Marca");

        jLabel5.setText("Status");

        jLabel6.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ferramentas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(inputPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(inputStatus))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletar)
                    .addComponent(atualizar))
                .addContainerGap())
        );

        Fechar.setText("X");
        Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Fechar)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(Fechar)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFerramentasMouseClicked
        
        if (this.tabelaFerramentas.getSelectedRow() != -1) {

                    String id = ""+ this.tabelaFerramentas.getValueAt(this.tabelaFerramentas.getSelectedRow(), 0).toString();
                    String nome = this.tabelaFerramentas.getValueAt(this.tabelaFerramentas.getSelectedRow(), 1).toString();
                    String preco = this.tabelaFerramentas.getValueAt(this.tabelaFerramentas.getSelectedRow(), 2).toString();
                    String marca = this.tabelaFerramentas.getValueAt(this.tabelaFerramentas.getSelectedRow(), 3).toString();
                    String status = this.tabelaFerramentas.getValueAt(this.tabelaFerramentas.getSelectedRow(), 4).toString();
                    
                    
                    
                    this.inputNome.setText(nome);
                    this.inputMarca.setText(marca);
                    this.inputPreco.setText(preco);
                    this.inputStatus.setText(status);
                    this.inputID.setText(id);
                    
                    this.inputID.setEnabled(false);
                    this.inputStatus.setEnabled(false);
                }
    }//GEN-LAST:event_tabelaFerramentasMouseClicked

    private void FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_FecharActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
      try {
            // recebendo e validando dados da interface gráfica.
            int id = 0;
            String nome = "";
            String marca="";
            double preco =0.0;
            boolean status = false;            

            if (this.inputNome.getText().length() <= 2) {
                throw new Mensagem("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.inputNome.getText();
            }
            
            if (this.inputMarca.getText().length() <= 2) {
                throw new Mensagem("Marca deve conter ao menos 2 caracteres.");
            } else {
                marca = this.inputMarca.getText();
            }

            if (this.inputPreco.getText().length() <= 2) {
                throw new Mensagem("Preço deve conter ao menos 2 caracteres.");
            } else {
                preco = Double.parseDouble(this.inputPreco.getText());
            }

            if (this.tabelaFerramentas.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione uma Ferramenta para Alterar");
            } else {
                id = Integer.parseInt(this.tabelaFerramentas.getValueAt(this.tabelaFerramentas.getSelectedRow(), 0).toString());
            }
            
            if(this.inputStatus.getText().equals("Disponível")){
                status = false;
            }else{
                status= true;
            }
            // envia os dados para o Aluno processar
            if (this.objetoFerramenta.updateFerramentaBD(nome,id,marca,status,preco  )) {
                // limpa os campos
                this.inputNome.setText("");
                    this.inputMarca.setText("");
                    this.inputPreco.setText("");
                    this.inputStatus.setText("");
                    this.inputID.setText("");
                JOptionPane.showMessageDialog(rootPane, "Ferramenta alterada!");

            }
            System.out.println(this.objetoFerramenta.pegarLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número.");
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_atualizarActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        try {
            // validando dados da interface gráfica.
            int id = 0;
            if (this.tabelaFerramentas.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione uma Ferramenta para APAGAR");
            } else {
                id = Integer.parseInt(this.tabelaFerramentas.getValueAt(this.tabelaFerramentas.getSelectedRow(), 0).toString());
            }
            
            // Define os textos dos botões
            Object[] options = {"Sim", "Não"};
            int resposta_usuario = JOptionPane.showOptionDialog(
                    null, 
                "Tem certeza que deseja APAGAR essa ferramenta ?", 
                "Confirmação", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0] );          
            
            if (resposta_usuario == 0) {// clicou em SIM

                // envia os dados para o Aluno processar
                if (this.objetoFerramenta.deleteFerramentaBD(id)) {

                    // limpa os campos
                    this.inputNome.setText("");
                    this.inputMarca.setText("");
                    this.inputPreco.setText("");
                    this.inputStatus.setText("");
                    this.inputID.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Ferramenta apagada!");
                }
            }
            System.out.println(this.objetoFerramenta.pegarLista().toString());

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_deletarActionPerformed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ferramenta().setVisible(true);
            }
        });
    }
    @SuppressWarnings("unchecked")
    
    public void carregaTabela() {
    DefaultTableModel modelo = (DefaultTableModel) this.tabelaFerramentas.getModel();
    modelo.setNumRows(0);
    ArrayList<Ferramenta> minhalista = objetoFerramenta.pegarLista();
    for (Ferramenta a : minhalista) {
         System.out.println("a: "+a.getId());
        String x="";
        if (a.isStatus() == false) {
            x = "Disponível";
        } else {
            x = "Indisponível";
        }
        modelo.addRow(new Object[]{
            a.getId(),
            a.getNome(),
            a.getCusto(),
            a.getMarca(),
            x
        });
    }    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Fechar;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton deletar;
    private javax.swing.JTextField inputID;
    private javax.swing.JTextField inputMarca;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputPreco;
    private javax.swing.JTextField inputStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaFerramentas;
    // End of variables declaration//GEN-END:variables
}
