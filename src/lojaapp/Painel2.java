package lojaapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Painel2 extends javax.swing.JPanel {

    // labels e paineis globais
    JLabel botaoNovaLevaProdutos = new JLabel("Nova leva");
    JPanel paneNovaLevaProdutos = new JPanel();
    JLabel botaoAdicionarItem = new JLabel("Adicionar Item");
    JPanel paneAdicionarItem = new JPanel();
    JLabel botaoVenderItem = new JLabel("Vender Item");
    JPanel paneVenderItem = new JPanel();
    JLabel botaoDetalhamento = new JLabel("Detalhamento");
    JPanel paneDetalhamento = new JPanel();
    
    public Painel2() {
        initComponents();
        dadosFinanceirosIniciais();
        definirData();
        botarLabels();
        config();
        iniciarRelogio();
    }
    
    public void dadosFinanceirosIniciais() {
        jLabel4.setText(String.valueOf(String.valueOf(Janela.investimento)));
        jLabel5.setText(String.valueOf(String.valueOf(Janela.faturamentoReal)));
        jLabel6.setText(String.valueOf(String.valueOf(Janela.lucroReal)));
    }
    
    public void atualizarLucroFaturamentoReal() {
        jLabel5.setText(String.valueOf(Janela.faturamentoReal));
        jLabel6.setText(String.valueOf(Janela.lucroReal));
    }
    
    public void botarLabels() {
        JLabel modas = new JLabel("Modas");
        modas.setBounds(65, 85, 180, 81);
        modas.setFont(new Font("Segoe Script", Font.BOLD, 50));
        modas.setForeground(new Color(217, 50, 128));
        jPanel1.add(modas);
        
        JLabel iconInvestimento = new JLabel("");
        iconInvestimento.setBounds(58, -14, 180, 81);
        iconInvestimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojaapp/imagens/seta-cima.png")));
        iconInvestimento.setForeground(Color.WHITE);
        jPanel3.add(iconInvestimento);
        
        JLabel iconFaturamento = new JLabel("");
        iconFaturamento.setBounds(58, 16, 180, 81);
        iconFaturamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojaapp/imagens/seta-baixo.png")));
        iconFaturamento.setForeground(Color.WHITE);
        jPanel3.add(iconFaturamento);
        
        JLabel iconLucro = new JLabel("$");
        iconLucro.setBounds(66, 48, 180, 81);
        iconLucro.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        iconLucro.setForeground(Color.WHITE);
        jPanel3.add(iconLucro);
        
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        // Adição das coberturas
        
        JPanel vertical1 = new JPanel();
        vertical1.setBounds(25, 121, 13, 249);
        vertical1.setBackground(new Color(217, 50, 128));
        jPanel3.add(vertical1);
        
        JPanel vertical2 = new JPanel();
        vertical2.setBounds(228, 121, 13, 249);
        vertical2.setBackground(new Color(217, 50, 128));
        jPanel3.add(vertical2);
        
        JPanel horizontal1 = new JPanel();
        horizontal1.setBounds(38, 122, 200, 7);
        horizontal1.setBackground(new Color(217, 50, 128));
        jPanel3.add(horizontal1);
        
        JPanel horizontal2 = new JPanel();
        horizontal2.setBounds(38, 172, 200, 7);
        horizontal2.setBackground(new Color(217, 50, 128));
        jPanel3.add(horizontal2);
        
        JPanel horizontal3 = new JPanel();
        horizontal3.setBounds(38, 212, 200, 7);
        horizontal3.setBackground(new Color(217, 50, 128));
        jPanel3.add(horizontal3);
        
        JPanel horizontal4 = new JPanel();
        horizontal4.setBounds(38, 261, 200, 7);
        horizontal4.setBackground(new Color(217, 50, 128));
        jPanel3.add(horizontal4);
        
        JPanel horizontal5 = new JPanel();
        horizontal5.setBounds(38, 311, 200, 7);
        horizontal5.setBackground(new Color(217, 50, 128));
        jPanel3.add(horizontal5);
        
        JPanel horizontal6 = new JPanel();
        horizontal6.setBounds(38, 361, 200, 7);
        horizontal6.setBackground(new Color(217, 50, 128));
        jPanel3.add(horizontal6);
        
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        // Botão nova leva de produtos 
        botaoNovaLevaProdutos.setBounds(88, 222, 200, 40);
        botaoNovaLevaProdutos.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        botaoNovaLevaProdutos.setForeground(new Color(217, 50, 128));
        jPanel3.add(botaoNovaLevaProdutos);
        
        paneNovaLevaProdutos.setBackground(Color.WHITE);
        paneNovaLevaProdutos.setBorder(new RoundBorder(new Color(217, 50, 128), 50, 10));
        paneNovaLevaProdutos.setBounds(33, 215, 200, 50);
        jPanel3.add(paneNovaLevaProdutos);
        
        // Botão adicionar item
        botaoAdicionarItem.setBounds(70, 272, 200, 40);
        botaoAdicionarItem.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        botaoAdicionarItem.setForeground(new Color(217, 50, 128));
        jPanel3.add(botaoAdicionarItem);
        
        paneAdicionarItem.setBackground(Color.WHITE);
        paneAdicionarItem.setBorder(new RoundBorder(new Color(217, 50, 128), 50, 10));
        paneAdicionarItem.setBounds(33, 265, 200, 50);
        jPanel3.add(paneAdicionarItem);
        
        // Botão Vender item
        botaoVenderItem.setBounds(77, 322, 200, 40);
        botaoVenderItem.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        botaoVenderItem.setForeground(new Color(217, 50, 128));
        jPanel3.add(botaoVenderItem);
        
        paneVenderItem.setBackground(Color.WHITE);
        paneVenderItem.setBorder(new RoundBorder(new Color(217, 50, 128), 50, 10));
        paneVenderItem.setBounds(33, 315, 200, 50);
        jPanel3.add(paneVenderItem);
        
        // Botão Detalhamento
        botaoDetalhamento.setBounds(70, 132, 200, 40);
        botaoDetalhamento.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        botaoDetalhamento.setForeground(new Color(217, 40, 128));
        jPanel3.add(botaoDetalhamento);
        
        paneDetalhamento.setBackground(Color.WHITE);
        paneDetalhamento.setBorder(new RoundBorder(new Color(217, 50, 128), 50, 10));
        paneDetalhamento.setBounds(33, 125, 200, 50);
        jPanel3.add(paneDetalhamento);
        
        
    }
    
    public void config() {
        
        // Quando o painel LOGIN é clicado
        paneNovaLevaProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int resposta = JOptionPane.showOptionDialog(null,"Deseja continuar?\nTodos os dados serão apagados","Confirmação",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Sim", "Não", "Cancelar"},"Sim");
        
                if (resposta == JOptionPane.YES_OPTION) {
                    // remove todos os dados que são serializados
                    
                    // pega o arquivo serializado
                    File arquivo = new File("dados.ser");
                    arquivo.delete();
                    System.exit(0);
                    
                } else {
                    
                }

                // cria um arquivo txt com os seguintes dados:
                // lucro, investimento, faturamento, tempo para vender toda a leva, media de vendas por dia, 
                // media de ganho por dia

                // serializa o arquivo
            }
        });
        
        paneAdicionarItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // passa para o painel de adicionar items
                Janela.p4 = new Painel4();
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                janela.getContentPane().remove(Janela.p2);
                janela.add(Janela.p4, BorderLayout.CENTER);
                janela.pack();
            }
        });
        
        paneVenderItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // passa para o painel de vender items
                Janela.p3.limparSelecaoListas();
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                janela.getContentPane().remove(Janela.p2);
                janela.add(Janela.p3, BorderLayout.CENTER);
                janela.pack();
            }
        });
        
        paneDetalhamento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // passa para o painel de detalhamento
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                janela.getContentPane().remove(Janela.p2);
                janela.add(Janela.p6, BorderLayout.CENTER);
                janela.pack();
            }
        });
        
    }
    
    public void definirData() {
        // Obter a data atual
        LocalDate dataAtual = LocalDate.now();
        
        // Formatar a data atual
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formato);
        
        jLabel7.setText(dataFormatada);
    }
    
    public void iniciarRelogio() {
        AtualizarRelogio att = new AtualizarRelogio();
        Thread t1 = new Thread(att);
        t1.start();
    }
    
    public void atualizarRelogio(int hora, int minuto, int segundo) {
        String time = "";
        if (hora < 10) {
            time = time.concat("0");
        }
        time = time.concat(String.valueOf(hora));
        time = time.concat(":");
        if (minuto < 10) {
            time = time.concat("0");
        }
        time = time.concat(String.valueOf(minuto));
        time = time.concat(":");
        if (segundo < 10) {
            time = time.concat("0");
        }
        time = time.concat(String.valueOf(segundo));
        
        jLabel8.setText(time);
        
    }
    
    public void novoProdutoAdicionado() {
        jLabel4.setText(String.valueOf(String.valueOf(Janela.investimento)));
    }
    
    public void produtoVendido(float precoCompra, float precoVenda) {
        jLabel5.setText(String.valueOf(Janela.faturamentoReal));
        jLabel6.setText(String.valueOf(Janela.lucroReal));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe Script", 1, 50)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(217, 50, 128));
        jLabel9.setText("Angel");

        jPanel3.setBackground(new java.awt.Color(217, 50, 128));

        jLabel1.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Investimento: ");

        jLabel2.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Faturamento: ");

        jLabel3.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lucro: ");

        jLabel4.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("<investimento>");

        jLabel5.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("<faturamento>");

        jLabel6.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("<lucro>");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("<data>");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("<hora>");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(62, 62, 62))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
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
    // End of variables declaration//GEN-END:variables
}
