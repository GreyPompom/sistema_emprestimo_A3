package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Emprestimo;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Ferramenta;

public class VerEmprestimos extends javax.swing.JFrame {

    Emprestimo objeto;
    double totalEmprestimo;

    public VerEmprestimos() {
        initComponents();
        objeto = new Emprestimo();
        carregaTabela();
         setLocationRelativeTo(null);
    }

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.TabelaEmprestimos.getModel();
        modelo.setNumRows(0);

        ArrayList<Emprestimo> minhalista = new ArrayList<>();
        minhalista = objeto.pegarLista();

        for (Emprestimo a : minhalista) {
            double valorTotal = a.calcularValorTotal();
            String status = "x";
            switch (a.getStatus().getCodigo()) {
                            case 1:
                                status = "Aberto";
                                break;
                            case 2:
                                status ="Fechado";
                                break;
                            case 3:
                                status ="Em Atraso";
                                break;
                            default:
                                 JOptionPane.showConfirmDialog(null, "Erro ao informar o status");
                                break;
                        }
            modelo.addRow(new Object[]{
                a.getIdEmprestimo(),
                a.getIdAmigo(),
                a.getDataInicial(),
                a.tempoRestante(a.getDataInicial(), a.getDataDevolucao()),
                a.getDataDevolucao(),
                a.qtdFerramentasEmprestimo(a.getIdEmprestimo()),
                valorTotal,
                status
            });
        }
        configurarRenderizadorTabela();
    }

    private void configurarRenderizadorTabela() {
        TabelaEmprestimos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String status = (String) table.getValueAt(row, 7); // Coluna do status
                switch (status) {
                    case "Aberto":
                        c.setBackground(Color.GREEN);
                        break;
                    case "Fechado":
                        c.setBackground(Color.GRAY);
                        break;
                    case "Em Atraso":
                        c.setBackground(Color.RED);
                        break;
                    default:
                        c.setBackground(Color.WHITE);
                        break;
                }
                return c;
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        RegistrarEmprestimo = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btRelatorios = new javax.swing.JButton();
        PainelExibicao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaEmprestimos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Empréstimos");

        jToggleButton1.setText("X");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jToggleButton1))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        RegistrarEmprestimo.setText("Registrar");
        RegistrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarEmprestimoActionPerformed(evt);
            }
        });

        jButton3.setText("Recarregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btRelatorios.setText("Relátorios");
        btRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatoriosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegistrarEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRelatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegistrarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PainelExibicao.setBackground(new java.awt.Color(0, 102, 102));

        TabelaEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Amigo", "Data_inicio", "Dias restantes", "Data_devolução", "Qtd. Ferramentas", "Valor R$", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaEmprestimos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TabelaEmprestimos.setRowHeight(30);
        TabelaEmprestimos.setRowSelectionAllowed(false);
        TabelaEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaEmprestimosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaEmprestimos);
        if (TabelaEmprestimos.getColumnModel().getColumnCount() > 0) {
            TabelaEmprestimos.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaEmprestimos.getColumnModel().getColumn(1).setPreferredWidth(30);
            TabelaEmprestimos.getColumnModel().getColumn(5).setResizable(false);
            TabelaEmprestimos.getColumnModel().getColumn(5).setPreferredWidth(15);
            TabelaEmprestimos.getColumnModel().getColumn(6).setResizable(false);
            TabelaEmprestimos.getColumnModel().getColumn(6).setPreferredWidth(20);
            TabelaEmprestimos.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        javax.swing.GroupLayout PainelExibicaoLayout = new javax.swing.GroupLayout(PainelExibicao);
        PainelExibicao.setLayout(PainelExibicaoLayout);
        PainelExibicaoLayout.setHorizontalGroup(
            PainelExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelExibicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelExibicaoLayout.setVerticalGroup(
            PainelExibicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelExibicaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PainelExibicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PainelExibicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        carregaTabela();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RegistrarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarEmprestimoActionPerformed
        CadastrarEmprestimo objeto = new CadastrarEmprestimo();
        objeto.setVisible(true);
    }//GEN-LAST:event_RegistrarEmprestimoActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void TabelaEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEmprestimosMouseClicked
        int selectedRow = TabelaEmprestimos.getSelectedRow();
        if (selectedRow != -1) {
            // Captura o ID do empréstimo da linha selecionada
            int idEmprestimo = (int) TabelaEmprestimos.getValueAt(selectedRow, 0);
            System.out.print(idEmprestimo);
            // Abre a tela de detalhes do empréstimo passando o ID
            DetalhesEmprestimo detalhes = new DetalhesEmprestimo(idEmprestimo);
            detalhes.setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_TabelaEmprestimosMouseClicked

    private void btRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRelatoriosActionPerformed

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
            java.util.logging.Logger.getLogger(VerEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerEmprestimos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelExibicao;
    private javax.swing.JButton RegistrarEmprestimo;
    private javax.swing.JTable TabelaEmprestimos;
    private javax.swing.JButton btRelatorios;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
