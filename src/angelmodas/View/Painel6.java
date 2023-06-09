package angelmodas.View;

import static angelmodas.AngelModas.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import angelmodas.Model.BordaTracejada;
import angelmodas.Model.RoundBorder;

public class Painel6 extends javax.swing.JPanel {
    
    JPanel paneVoltar = new JPanel();
    JLabel botaoVoltar = new JLabel("Voltar");
    JLabel numeroInvestimento = new JLabel("R$ 0.0");
    JLabel investimento = new JLabel("Investimento");
    JLabel numeroFaturamento = new JLabel("R$ 0.0");
    JLabel faturamento = new JLabel("Faturamento");
    JLabel numeroFaturamentoEsperado = new JLabel("0");
    JLabel percentualFaturamento= new JLabel("0%");
    JLabel lucro = new JLabel("Lucro");
    JLabel numeroLucro = new JLabel("R$ 0.0");
    JLabel numeroLucroEsperado = new JLabel("0");
    JLabel percentualLucro = new JLabel("0%");
    JLabel extravio = new JLabel("Extravio");
    JLabel numeroExtravio = new JLabel("R$ 0.0");
    JLabel precoCompraExtravio = new JLabel("R$ 0.0");
    JLabel precoVendaExtravio = new JLabel("R$ 0.0");
    
    public Painel6() {
        initComponents();
        adicionarBotoes();
        config();
    }
    
    public void adicionarBotoes() {
        // cobertura
        JPanel horizontal1 = new JPanel();
        horizontal1.setBounds(580, 20, 129, 10);
        horizontal1.setBackground(Color.WHITE);
        jPanel1.add(horizontal1);
        
        JPanel horizontal2 = new JPanel();
        horizontal2.setBounds(580, 55, 129, 9);
        horizontal2.setBackground(Color.WHITE);
        jPanel1.add(horizontal2);
        
        botaoVoltar.setBounds(623, 29, 120, 30);
        botaoVoltar.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoVoltar.setForeground(Color.WHITE);
        jPanel1.add(botaoVoltar);
        
        paneVoltar.setBackground(new Color(217, 50, 128));
        paneVoltar.setBorder(new RoundBorder(Color.WHITE, 50, 11));
        paneVoltar.setBounds(585, 25, 120, 36);
        jPanel1.add(paneVoltar);
        
        jPanel2.setBorder(new BordaTracejada(Color.WHITE, 3, 5));
        jPanel3.setBorder(new BordaTracejada(Color.WHITE, 3, 5));
        jPanel4.setBorder(new BordaTracejada(Color.WHITE, 3, 5));
        jPanel6.setBorder(new BordaTracejada(Color.WHITE, 3, 5));
        
        // Labels de titulos e monetarios dos paineis
        investimento.setBounds(35, 25, 140, 31);
        investimento.setFont(new Font("Dialog", Font.BOLD, 20));
        investimento.setForeground(Color.WHITE);
        jPanel2.add(investimento);
        
        numeroInvestimento.setBounds(33, 80, 140, 31);
        numeroInvestimento.setFont(new Font("Dialog", Font.BOLD, 26));
        numeroInvestimento.setForeground(Color.WHITE);
        jPanel2.add(numeroInvestimento);
        
        faturamento.setBounds(32, 25, 140, 31);
        faturamento.setFont(new Font("Dialog", Font.BOLD, 20));
        faturamento.setForeground(Color.WHITE);
        jPanel3.add(faturamento);
        
        numeroFaturamento.setBounds(45, 80, 140, 31);
        numeroFaturamento.setFont(new Font("Dialog", Font.BOLD, 26));
        numeroFaturamento.setForeground(Color.WHITE);
        jPanel3.add(numeroFaturamento);
        
        numeroFaturamentoEsperado.setBounds(25, 130, 140, 31);
        numeroFaturamentoEsperado.setFont(new Font("Dialog", Font.PLAIN, 14));
        numeroFaturamentoEsperado.setForeground(Color.WHITE);
        jPanel3.add(numeroFaturamentoEsperado);
        
        percentualFaturamento.setBounds(148, 130, 140, 31);
        percentualFaturamento.setFont(new Font("Dialog", Font.PLAIN, 14));
        percentualFaturamento.setForeground(Color.WHITE);
        jPanel3.add(percentualFaturamento);
        
        numeroLucro.setBounds(34, 78, 140, 31);
        numeroLucro.setFont(new Font("Dialog", Font.BOLD, 26));
        numeroLucro.setForeground(Color.WHITE);
        jPanel4.add(numeroLucro);
        
        lucro.setBounds(54, 25, 140, 31);
        lucro.setFont(new Font("Dialog", Font.BOLD, 20));
        lucro.setForeground(Color.WHITE);
        jPanel4.add(lucro);
        
        numeroLucroEsperado.setBounds(25, 130, 140, 31);
        numeroLucroEsperado.setFont(new Font("Dialog", Font.PLAIN, 14));
        numeroLucroEsperado.setForeground(Color.WHITE);
        jPanel4.add(numeroLucroEsperado);
        
        percentualLucro.setBounds(122, 130, 140, 31);
        percentualLucro.setFont(new Font("Dialog", Font.PLAIN, 14));
        percentualLucro.setForeground(Color.WHITE);
        jPanel4.add(percentualLucro);
        
        extravio.setBounds(37, 25, 140, 31);
        extravio.setFont(new Font("Dialog", Font.BOLD, 20));
        extravio.setForeground(Color.WHITE);
        jPanel6.add(extravio);
        
        numeroExtravio.setBounds(64, 78, 140, 31);
        numeroExtravio.setFont(new Font("Dialog", Font.BOLD, 26));
        numeroExtravio.setForeground(Color.WHITE);
        jPanel6.add(numeroExtravio);
        
        precoCompraExtravio.setBounds(40, 135, 140, 31);
        precoCompraExtravio.setFont(new Font("Dialog", Font.PLAIN, 14));
        precoCompraExtravio.setForeground(Color.WHITE);
        jPanel6.add(precoCompraExtravio);
        
        precoVendaExtravio.setBounds(40, 110, 140, 31);
        precoVendaExtravio.setFont(new Font("Dialog", Font.BOLD, 16));
        precoVendaExtravio.setForeground(Color.WHITE);
        jPanel6.add(precoVendaExtravio);
    }
    
    public void atualizarValores(int quantidadeExtraviados, float somatorioPVExtraviados, float somatorioPCExtraviados, float investimento, float faturamentoEsperado, float lucroEsperado, float faturamentoReal, float lucroReal, int porcentagemFaturamento, int porcentagemLucro) {
        numeroExtravio.setText(String.valueOf(quantidadeExtraviados));
        precoVendaExtravio.setText("R$ ".concat(String.valueOf(somatorioPVExtraviados)));
        precoCompraExtravio.setText("R$ ".concat(String.valueOf(somatorioPCExtraviados)));
        numeroInvestimento.setText("R$ ".concat(String.valueOf(investimento)));
        numeroFaturamentoEsperado.setText("R$ ".concat(String.valueOf(faturamentoEsperado)));
        numeroLucroEsperado.setText("R$ ".concat(String.valueOf(lucroEsperado)));
        numeroFaturamento.setText(String.valueOf(faturamentoReal));
        numeroLucro.setText("R$ ".concat(String.valueOf(lucroReal)));
        percentualFaturamento.setText(String.valueOf(porcentagemFaturamento)+"%");
        percentualLucro.setText(String.valueOf(porcentagemLucro)+"%");
    }
    
    public void config() {
        
        paneVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // passa para o painel de adicionar items
                controller.voltarP6();
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(217, 50, 128));
        jLabel7.setText("Detalhamento");

        jPanel5.setBackground(new java.awt.Color(217, 50, 128));

        jPanel2.setBackground(new java.awt.Color(217, 50, 128));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(217, 50, 128));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(217, 50, 128));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(217, 50, 128));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(507, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
