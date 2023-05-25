package lojaapp;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Janela extends javax.swing.JFrame {

    static Transicao t1;
    
    static Painel1 p1;
    static Painel2 p2;
    static Painel3 p3 = new Painel3();
    static Painel4 p4;
    static Painel5 p5;
    static Painel6 p6;
    static Painel7 p7 = new Painel7();
    
    public static ArrayList<Produto> produtosListados = new ArrayList<>();
    public static ArrayList<Produto> produtosVendidos = new ArrayList<>();
    
    public static ArrayList<Integer> temposDeSessao = new ArrayList<>();
    
    static LocalTime horaInicio;
    
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public Janela() {
        initComponents();
        this.setLayout(new BorderLayout());
        p1 = new Painel1();
        
        this.add(p1, BorderLayout.CENTER);
        this.pack();
        pegarTempoInicioSessao();
        desserializar();
    }
    
    public static void serializar() {
        // instancia a classe de serialização
        Dados dado = new Dados();
        // cria o nome do arquivo de serialização
        String nomeDoArquivo = "dados.ser";
        
        // pega os dados e bota no objeto
        dado.setProdutosListados(Janela.produtosListados);
        dado.setProdutosVendidos(Janela.produtosVendidos);
        dado.setUsuarios(Janela.usuarios);
        
        dado.setInvestimento(Janela.p2.investimento);
        dado.setFaturamento(Janela.p2.faturamento);
        dado.setLucro(Janela.p2.lucro);
        // ! faltou o tempo de seção !
        
        try {
            FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(dado);
            out.close();
            arquivo.close();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void desserializar() {
        
        // verifica se o arquivo serializado existe. Se existir desserializa
        String caminhoArquivo = "dados.ser";
        File arquivoTeste = new File(caminhoArquivo);
        
        if (arquivoTeste.exists() == true) {
            // pega o arquivo e atribui os arrayList deles nos dessa classe
        
            Dados dadosSerializados = null;
            String nomeDoArquivo = "dados.ser";

            try {
                FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
                ObjectInputStream in = new ObjectInputStream(arquivo);

                dadosSerializados = (Dados)in.readObject();
                in.close();
                arquivo.close();

                // atribui aos arrayList o que esta no arquivo serializado
                produtosListados = dadosSerializados.getProdutosListados();
                produtosVendidos = dadosSerializados.getProdutosVendidos();
                usuarios = dadosSerializados.getUsuarios();

                // atribui as vaiaveis o que estava no arquivo serializado
                Janela.p2.investimento = dadosSerializados.getInvestimento();;
                Janela.p2.faturamento= dadosSerializados.getFaturamento();;
                Janela.p2.lucro = dadosSerializados.getLucro();;
                Janela.p7.carregarUsuariosSerializados(usuarios);

                // metodo para atualizar as listas e carregar os itens serialziados
                atualizarListas();

            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
    }
    
    public void atualizarListas() {
        p3.adicionarItensSerializados();
    }
    
    public void pegarTempoInicioSessao() {
        horaInicio = LocalTime.now();
    }
    
    public static void criarRelatorioDaLeva() {
        
        RelatorioDaLeva relatorio = new RelatorioDaLeva();
        
    }
    
    public static void pegarTempoFimSessao() {
        while (true) {
            try {
                Thread.sleep(1000);
                LocalTime horaFim = LocalTime.now();
        
                Duration duracao = Duration.between(horaInicio, horaFim);
        
                long duracaoHoras = duracao.toHours();
                long duracaoMinutos = duracao.toMinutesPart();
                long duracaoSegundos = duracao.toSecondsPart();
        
                System.out.println("hora: "+duracaoHoras+", minuto: "+duracaoMinutos+", segundo: "+duracaoSegundos);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
