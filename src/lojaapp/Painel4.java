package lojaapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

public class Painel4 extends javax.swing.JPanel {

    SpinnerNumberModel modelSpinner = new SpinnerNumberModel(1,1, 100, 1);
    
    JLabel itens = new JLabel("Itens!");
    JPanel paneAdicionarItem = new JPanel();
    JLabel botaoAdicionarItem = new JLabel("Adicionar Item");
    JPanel paneVoltar = new JPanel();
    JLabel botaoVoltar = new JLabel("Voltar");
    
    public Painel4() {
        initComponents();
        jSpinner1.setModel(modelSpinner);
        adicionarLabelsEPanels();
        config();
    }
    
    public void adicionarLabelsEPanels() {
        // adiciona a segunda palavra do titulo
        itens.setBounds(60, 70, 200, 40);
        itens.setFont(new Font("Segoe Script", Font.BOLD, 36));
        itens.setForeground(new Color(217, 50, 128));
        jPanel1.add(itens);
        
        // cobertura dos botoes abaixo
        JPanel horizontal1 = new JPanel();
        horizontal1.setBounds(28, 301, 179, 8);
        horizontal1.setBackground(Color.WHITE);
        jPanel1.add(horizontal1);
        
        JPanel horizontal2 = new JPanel();
        horizontal2.setBounds(28, 342, 179, 17);
        horizontal2.setBackground(Color.WHITE);
        jPanel1.add(horizontal2);
        
        JPanel horizontal3 = new JPanel();
        horizontal3.setBounds(55, 385, 120, 8);
        horizontal3.setBackground(Color.WHITE);
        jPanel1.add(horizontal3);
        
        JPanel vertical1 = new JPanel();
        vertical1.setBounds(200, 305, 8, 40);
        vertical1.setBackground(Color.WHITE);
        jPanel1.add(vertical1);
        
        JPanel vertical2 = new JPanel();
        vertical2.setBounds(28, 305, 8, 40);
        vertical2.setBackground(Color.WHITE);
        jPanel1.add(vertical2);
        
        // adiciona o botão 'adicionar item'
        botaoAdicionarItem.setBounds(62, 311, 170, 34);
        botaoAdicionarItem.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoAdicionarItem.setForeground(Color.WHITE);
        jPanel1.add(botaoAdicionarItem);
        
        paneAdicionarItem.setBackground(new Color(217, 50, 128));
        paneAdicionarItem.setBorder(new RoundBorder(Color.WHITE, 50, 10));
        paneAdicionarItem.setBounds(33, 305, 170, 42);
        jPanel1.add(paneAdicionarItem);
        
        // adiciona o botao voltar
        botaoVoltar.setBounds(93, 359, 120, 30);
        botaoVoltar.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoVoltar.setForeground(Color.WHITE);
        jPanel1.add(botaoVoltar);
        
        paneVoltar.setBackground(new Color(217, 50, 128));
        paneVoltar.setBorder(new RoundBorder(Color.WHITE, 50, 11));
        paneVoltar.setBounds(55, 355, 120, 36);
        jPanel1.add(paneVoltar);
        
        jPanel3.setBorder(new BordaTracejada(Color.WHITE, 3, 5));
        jPanel2.setBorder(new BordaTracejada(Color.WHITE, 3, 5));
        
    }
    
    public void config() {
        
        paneAdicionarItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                String categoria = "";
                String genero = "";
                float precoCompra;
                float precoVenda;
                
                String nomeProduto = jTextField1.getText();
                int quantidade = (int) jSpinner1.getValue();

                // pega o genero do produto
                if (jRadioButton3.isSelected()) {
                    genero = "masculino";
                }
                else {
                    if (jRadioButton4.isSelected()) {
                        genero = "feminino";
                    }
                }

                // pega a categoria do produto
                if (jRadioButton5.isSelected()) {
                    categoria = "calça";
                }
                else {
                    if (jRadioButton6.isSelected()) {
                        categoria = "camiseta";
                    }
                    else {
                        if (jRadioButton7.isSelected()) {
                            categoria = "tênis";
                        }
                        else {
                            if (jRadioButton8.isSelected()) {
                                categoria = "casaco";
                            }
                            else {
                                if (jRadioButton9.isSelected()) {
                                    categoria = "meia";
                                }
                                else {
                                    if (jRadioButton10.isSelected()) {
                                        categoria = "acessório";
                                    }
                                    else {
                                        if (jRadioButton11.isSelected()) {
                                            categoria = "roupaIntima";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                
                // Verificar se todos os campos estão preenchidos
                if (nomeProduto.trim().isEmpty() || categoria.trim().isEmpty() || genero.trim().isEmpty() || String.valueOf(jTextField2.getText()).trim().isEmpty() || String.valueOf(jTextField3.getText()).trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser prenchidos!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        precoCompra = Float.parseFloat(jTextField2.getText());
                        precoVenda = Float.parseFloat(jTextField3.getText());
                    } catch (NumberFormatException evt) {
                        JOptionPane.showMessageDialog(null, "O valor inserido para o preço de compra ou venda não é um número válido", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (precoCompra <= 0 || precoVenda <= 0) {
                         JOptionPane.showMessageDialog(null, "O preço de compra e venda não podem ser menores que zero!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        // instancia um objeto produto
                        Produto p1 = new Produto(nomeProduto, precoCompra, precoVenda, categoria, genero);

                        for (int i=0;i<quantidade;i++) {
                            // adiciona o produto ao array
                            Janela.produtosListados.add(p1);
                            // atualiza o Jlist do painel3
                            Janela.p3.adicionarElementoLista(p1);
                            // atualiza os valores do painel de controle (p2)
                            Janela.p2.novoProdutoAdicionado();
                            // atualiza os valores monetarios da janela
                            Janela.investimento = Janela.investimento + precoCompra;
                            Janela.faturamentoEsperado = Janela.faturamentoEsperado + precoVenda;
                            Janela.lucroEsperado = Janela.lucroEsperado + (precoVenda - precoCompra);
                        }

                        // atualiza o painel detalhamento e de controle
                        Janela.p6.produtoAdicionado();
                        Janela.p2.novoProdutoAdicionado();

                        // chama o metodo que faz a serialização
                        Janela.serializar();

                        // exibe mensagem de produto adicionado
                        JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!", "Angel Modas", JOptionPane.INFORMATION_MESSAGE);

                        // atualiza os percentuais do painel6
                        Janela.p6.atualizarPercentuais();
                        
                        // limpa os textFields
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                        jSpinner1.setValue(1);
                        buttonGroup2.clearSelection();
                        buttonGroup3.clearSelection();
                        
                    }
                }
                
                
                
                
                
            }
        });
        
        paneVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // passa para o painel de adicionar items
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                janela.getContentPane().remove(Janela.p4);
                janela.add(Janela.p2, BorderLayout.CENTER);
                janela.pack();
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jSlider1 = new javax.swing.JSlider();
        jSpinner2 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(217, 50, 128));
        jLabel1.setText("Adicionar");

        jPanel4.setBackground(new java.awt.Color(217, 50, 128));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Preço de venda: ");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantidade: ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome do produto: ");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Preço de compra: ");

        jPanel3.setBackground(new java.awt.Color(217, 50, 128));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.setForeground(new java.awt.Color(217, 50, 128));

        jRadioButton5.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup3.add(jRadioButton5);
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Calça");

        jRadioButton6.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("Camiseta");

        jRadioButton7.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton7.setText("Tênis");

        jRadioButton8.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setText("Casaco");

        jRadioButton9.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText("Meia");

        jRadioButton10.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton10.setText("Acessórios");

        jRadioButton11.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup3.add(jRadioButton11);
        jRadioButton11.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton11.setText("Roupa Intima");

        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Categoria");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton5)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton9))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(72, 72, 72))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton11)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(217, 50, 128));

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gênero");

        jRadioButton3.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Masculino");

        jRadioButton4.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Feminino");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField3))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
