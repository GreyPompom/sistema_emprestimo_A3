package view;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Amigo;
import model.Ferramenta;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.Emprestimo;
import java.util.Date;

public class CadastrarEmprestimo extends javax.swing.JFrame {

    private ArrayList<Ferramenta> ferramentasSelecionadas;
    private Amigo objetoAmigo;
    private Ferramenta objetoFerramenta;
    private double totalEmprestimo = 0.0;
    private int quantidade = 0;
    Emprestimo objetoEmprestimo = new Emprestimo();
    ArrayList<Ferramenta> ferramentas = new ArrayList<>();

    public CadastrarEmprestimo() {
        initComponents();
        this.objetoAmigo = new Amigo();
        carregarAmigos();
        this.objetoFerramenta = new Ferramenta();
        carregarFerramentasDisponiveis();
        ferramentasSelecionadas = new ArrayList<>();
        calculaTotalEmprestimo();
         setLocationRelativeTo(null);

    }

    private void carregarAmigos() {
        ArrayList<Amigo> amigos = new ArrayList<>();
        amigos = objetoAmigo.pegarLista(); //metodo retorna um array/*List*/
        DefaultTableModel model = (DefaultTableModel) tbAmigos.getModel();
        model.setRowCount(0);
        for (Amigo amigo : amigos) {
            model.addRow(new Object[]{amigo.getId(), amigo.getNome(), amigo.getTelefone()});
        }
    }

    private void carregarFerramentasDisponiveis() {

        ferramentas = objetoFerramenta.pegarListaDisponiveis(); //metodo retorna um arraylist
        DefaultTableModel model = (DefaultTableModel) tbFerramentasDisp.getModel();
        model.setRowCount(0);
        for (Ferramenta ferramenta : ferramentas) {
            model.addRow(new Object[]{ferramenta.getId(), ferramenta.getNome(), ferramenta.getCusto(), ferramenta.getMarca()});
        }
    }

    private void atualizarTabelaFerramentasSelecionadas() {
        DefaultTableModel model = (DefaultTableModel) tbFerramentasSelecionadas.getModel();
        model.setRowCount(0);
        for (Ferramenta ferramenta : ferramentasSelecionadas) {
            model.addRow(new Object[]{ferramenta.getId(), ferramenta.getNome(), ferramenta.getCusto(), ferramenta.getMarca()});
        }
    }

    private void calculaTotalEmprestimo() {
        totalEmprestimo = 0.0;
        for (Ferramenta ferramenta : ferramentasSelecionadas) {
            totalEmprestimo += ferramenta.getCusto();
        }
        this.labelTotalCusto.setText("" + totalEmprestimo);
    }

    private void quantFerramentas() {
        quantidade = ferramentasSelecionadas.size();
        this.labelQuant.setText("" + quantidade);
    }

    private void atualizaInfos() {
        calculaTotalEmprestimo();
        atualizarTabelaFerramentasSelecionadas();
        quantFerramentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAmigos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inputNomeAmigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputTelAmigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputIdAmigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbFerramentasSelecionadas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelTotalCusto = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelQuant = new javax.swing.JLabel();
        jDateChooserDataDevolucao = new com.toedter.calendar.JDateChooser();
        jDateChooserDataInicial = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        SalvarEmprestimo = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbFerramentasDisp = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Novo Empréstimo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        tbAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Amigo", "Telefone"
            }
        ));
        tbAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAmigos);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecione um beneficiario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Amigo");

        inputNomeAmigo.setEditable(false);
        inputNomeAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNomeAmigoActionPerformed(evt);
            }
        });

        jLabel7.setText("Telefone");

        inputTelAmigo.setEditable(false);

        jLabel8.setText("ID");

        inputIdAmigo.setEditable(false);
        inputIdAmigo.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Beneficiario");

        tbFerramentasSelecionadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Ferramentas", "Custo", "Marca"
            }
        ));
        tbFerramentasSelecionadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFerramentasSelecionadasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbFerramentasSelecionadas);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Ferramentas Selecionadas");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Total de items: R$");

        labelTotalCusto.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        labelTotalCusto.setText("00,00");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("Data Inicial");

        labelQuant.setText("0");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel13.setText("Quantidade de itens:");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel14.setText("Data devolução");

        SalvarEmprestimo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        SalvarEmprestimo.setForeground(new java.awt.Color(0, 204, 0));
        SalvarEmprestimo.setText("Registrar");
        SalvarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarEmprestimoActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(5, 5, 5)
                        .addComponent(labelQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(labelTotalCusto)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputIdAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(inputNomeAmigo, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTelAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(SalvarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputIdAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTelAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNomeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jDateChooserDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(labelQuant)
                    .addComponent(jLabel6)
                    .addComponent(labelTotalCusto)
                    .addComponent(SalvarEmprestimo)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dados do Empréstimo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        tbFerramentasDisp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Ferramenta", "Custo", "marca"
            }
        ));
        tbFerramentasDisp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFerramentasDispMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbFerramentasDisp);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecione uma ferramenta");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbFerramentasDispMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFerramentasDispMouseClicked
        int selectedRow = tbFerramentasDisp.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tbFerramentasDisp.getModel();
            int id = (int) model.getValueAt(selectedRow, 0);

            boolean ferramentaJaSelecionada = false;
            for (Ferramenta ferramenta : ferramentasSelecionadas) {
                if (ferramenta.getId() == id) {
                    ferramentaJaSelecionada = true;
                    break;
                }
            }

            if (ferramentaJaSelecionada) {
                JOptionPane.showMessageDialog(this, "Ferramenta já selecionada", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(this, "Adicionar ferramenta ao empréstimo?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    Ferramenta ferramenta = new Ferramenta();
                    ferramenta.setId((int) model.getValueAt(selectedRow, 0));
                    ferramenta.setNome((String) model.getValueAt(selectedRow, 1));
                    ferramenta.setCusto((double) model.getValueAt(selectedRow, 2));
                    ferramenta.setMarca((String) model.getValueAt(selectedRow, 3));
                    ferramentasSelecionadas.add(ferramenta);
                    atualizarTabelaFerramentasSelecionadas();
                }
            }
        }
        atualizaInfos();
    }//GEN-LAST:event_tbFerramentasDispMouseClicked

    private void inputNomeAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomeAmigoActionPerformed

    }//GEN-LAST:event_inputNomeAmigoActionPerformed

    private void tbAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAmigosMouseClicked
        if (this.tbAmigos.getSelectedRow() != -1) {

            String id = "" + this.tbAmigos.getValueAt(this.tbAmigos.getSelectedRow(), 0).toString();
            String nome = this.tbAmigos.getValueAt(this.tbAmigos.getSelectedRow(), 1).toString();
            String telefone = this.tbAmigos.getValueAt(this.tbAmigos.getSelectedRow(), 2).toString();

            this.inputIdAmigo.setText(id);
            this.inputNomeAmigo.setText(nome);
            this.inputTelAmigo.setText(telefone);

            this.inputIdAmigo.setEnabled(false);
            this.inputNomeAmigo.setEnabled(false);
            this.inputTelAmigo.setEnabled(false);
        }
    }//GEN-LAST:event_tbAmigosMouseClicked

    private void tbFerramentasSelecionadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFerramentasSelecionadasMouseClicked
        int selectedRow = tbFerramentasSelecionadas.getSelectedRow();
        if (selectedRow != -1) {
            int option = JOptionPane.showConfirmDialog(this, "Tirar ferramenta da lista de selecionadas?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) tbFerramentasSelecionadas.getModel();
                int id = (int) model.getValueAt(selectedRow, 0);

                ferramentasSelecionadas.removeIf(ferramenta -> ferramenta.getId() == id);

                model.removeRow(selectedRow);
            }
        }
        atualizaInfos();
    }//GEN-LAST:event_tbFerramentasSelecionadasMouseClicked

    private void SalvarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarEmprestimoActionPerformed
        Date dataInicial = jDateChooserDataInicial.getDate();
        Date dataDevolucao = jDateChooserDataDevolucao.getDate();

        if (dataInicial == null || dataDevolucao == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione as datas.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date hoje = cal.getTime();

        Date dataInicialSemHora = resetTime(dataInicial);
        Date dataFinalSemHora = resetTime(dataDevolucao);

        if (dataInicialSemHora.before(hoje)) {
            JOptionPane.showMessageDialog(this, "A data inicial não pode ser inferior à data de hoje.","Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(dataFinalSemHora.before(dataInicialSemHora)){
            JOptionPane.showMessageDialog(this, "A data de devolução não pode ser inferior à data inicial.","Erro", JOptionPane.ERROR_MESSAGE);
            return;
            
        }
        
        java.sql.Date sqlDataInicial = new java.sql.Date(dataInicial.getTime());
        java.sql.Date sqlDataDevolucao = new java.sql.Date(dataDevolucao.getTime());

        /*Sala ai meu fi*/
        if (this.inputIdAmigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um amigo!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idAmigo;
        try {
            idAmigo = Integer.parseInt(this.inputIdAmigo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID do amigo inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar se a lista de ferramentas selecionadas está vazia
        if (ferramentasSelecionadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos uma ferramenta!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        objetoEmprestimo.setIdAmigo(idAmigo);
        objetoEmprestimo.setDataInicial(sqlDataInicial);
        objetoEmprestimo.setDataDevolucao(sqlDataDevolucao);
        objetoEmprestimo.setFerramentasSelecionadas(ferramentasSelecionadas);

        if (this.objetoEmprestimo.inserirEmprestimo(idAmigo, ferramentasSelecionadas, sqlDataInicial, sqlDataDevolucao)) {
            JOptionPane.showMessageDialog(this, "Empréstimo registrado com sucesso!");
            RecarregaTela();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao registrar o empréstimo!", "Erro", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_SalvarEmprestimoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void RecarregaTela() {
        ferramentas.clear();
        ferramentasSelecionadas.clear();
        carregarFerramentasDisponiveis();
        atualizarTabelaFerramentasSelecionadas();
        quantFerramentas();
        this.inputIdAmigo.setText("");
        this.inputNomeAmigo.setText("");
        this.inputTelAmigo.setText("");
        this.setVisible(false);
        VerEmprestimos objeto = new VerEmprestimos();
        objeto.carregaTabela();
    }

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
            java.util.logging.Logger.getLogger(CadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarEmprestimo().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton SalvarEmprestimo;
    private javax.swing.JTextField inputIdAmigo;
    private javax.swing.JTextField inputNomeAmigo;
    private javax.swing.JTextField inputTelAmigo;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooserDataDevolucao;
    private com.toedter.calendar.JDateChooser jDateChooserDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel labelQuant;
    private javax.swing.JLabel labelTotalCusto;
    private javax.swing.JTable tbAmigos;
    private javax.swing.JTable tbFerramentasDisp;
    private javax.swing.JTable tbFerramentasSelecionadas;
    // End of variables declaration//GEN-END:variables

    private Date resetTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
