package lojaapp.Controller;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lojaapp.AtualizarRelogio;
import lojaapp.Dados;
import lojaapp.Janela;
import static lojaapp.LojaApp.controller;
import lojaapp.Painel1;
import lojaapp.View.Painel2;
import lojaapp.View.Painel3;
import lojaapp.View.Painel4;
import lojaapp.View.Painel5;
import lojaapp.Painel6;
import lojaapp.View.Painel7;
import lojaapp.Produto;
import lojaapp.Transicao;
import lojaapp.Usuario;
import lojaapp.Usuarios;
import static lojaapp.View.Janela.faturamentoEsperado;
import static lojaapp.View.Janela.faturamentoReal;
import static lojaapp.View.Janela.investimento;
import static lojaapp.View.Janela.lucroEsperado;
import static lojaapp.View.Janela.lucroReal;
import static lojaapp.View.Janela.produtosListados;
import static lojaapp.View.Janela.produtosVendidos;
import static lojaapp.View.Janela.usuarios;
import static lojaapp.View.Painel3.listaProdutosListados;
import static lojaapp.View.Painel3.listaProdutosListadosVazia;
import static lojaapp.View.Painel3.listaProdutosVendidos;
import static lojaapp.View.Painel3.listaProdutosVendidosVazia;

public class Controller {
    
    // Objetos das views
    private Janela janela;
    private Transicao t1;
    private Painel1 p1;
    private Painel2 p2;
    private Painel3 p3 = new Painel3();
    private Painel4 p4;
    private Painel5 p5;
    private Painel6 p6 = new Painel6();
    private Painel7 p7 = new Painel7();
    
    // objetos dos models
    private ArrayList<Produto> produtosListados = new ArrayList<>();
    private ArrayList<Produto> produtosVendidos = new ArrayList<>();
    private ArrayList<Integer> temposDeSessao = new ArrayList<>();
    private LocalTime horaInicio;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private DefaultListModel<String> listaProdutosListados, listaProdutosListadosVazia, listaProdutosListadosTemp, 
            listaProdutosVendidos, listaProdutosVendidosVazia, listaProdutosVendidosTemp, listaUsuarios; 
    
    // variaveis padrão
    private float investimento, faturamentoReal, lucroReal, faturamentoEsperado, lucroEsperado;
    
    // variaveis do p6
    private int quantidadeExtraviados, porcentagemFaturamento, porcentagemLucro;
    private float somatorioPVExtraviados, somatorioPCExtraviados;
    
    //Construtor.
    public Controller() {
        this.janela = new Janela();                //Inicializa o frame.
        this.janela.setLocationRelativeTo(null);   //Posiciona no meio da tela.
    }
    
    public void start() {
        this.startModel();
        
        this.p1 = new Painel1();
        this.mostrarTela(this.p1);
        
        this.janela.setVisible(true);
        
        desserializar();
        desserialziarUsuarios();
    }
    
    public void startModel() {
        this.produtosListados = new ArrayList<>();
        this.produtosVendidos = new ArrayList<>();
        this.temposDeSessao = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        
        this.listaProdutosListados = new DefaultListModel();
        this.listaProdutosListadosVazia = new DefaultListModel();
        this.listaProdutosListadosTemp = new DefaultListModel();
        this.listaProdutosVendidos = new DefaultListModel();
        this.listaProdutosVendidosVazia = new DefaultListModel();
        this.listaProdutosVendidosTemp = new DefaultListModel();
        this.listaUsuarios = new DefaultListModel(); 
    }
    
    public void mostrarTela(JPanel newPanel) {
        this.janela.getContentPane().removeAll();
        this.janela.add(newPanel, BorderLayout.CENTER);
        this.janela.pack();
    }
    
    public void serializar() {
        // instancia a classe de serialização
        Dados dado = new Dados();
        // cria o nome do arquivo de serialização
        String nomeDoArquivo = "dados.ser";
        
        // pega os dados e bota no objeto
        dado.setProdutosListados(lojaapp.View.Janela.produtosListados);
        dado.setProdutosVendidos(lojaapp.View.Janela.produtosVendidos);
        
        dado.setInvestimento(this.investimento);
        dado.setFaturamentoReal(this.faturamentoReal);
        dado.setLucroReal(this.lucroReal);
        dado.setFaturamentoEsperado(this.faturamentoEsperado);
        dado.setLucroEsperado(this.lucroEsperado);
        
        dado.setQuantidadeExtraviados(this.quantidadeExtraviados);
        dado.setSomatorioPCExtraviados(this.somatorioPCExtraviados);
        dado.setSomatorioPVExtraviados(this.somatorioPVExtraviados);
        
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

                // atribui as vaiaveis o que estava no arquivo serializado
                investimento = dadosSerializados.getInvestimento();;
                faturamentoReal = dadosSerializados.getFaturamentoReal();;
                lucroReal = dadosSerializados.getLucroReal();;
                faturamentoEsperado = dadosSerializados.getFaturamentoEsperado();
                lucroEsperado = dadosSerializados.getLucroEsperado();
                
                this.quantidadeExtraviados = dadosSerializados.getQuantidadeExtraviados();
                this.somatorioPCExtraviados = dadosSerializados.getSomatorioPCExtraviados();
                this.somatorioPVExtraviados = dadosSerializados.getSomatorioPVExtraviados();

                // metodo para atualizar as listas e carregar os itens serialziados
                this.p6.atualizarValores(quantidadeExtraviados, somatorioPVExtraviados, somatorioPCExtraviados, investimento, faturamentoEsperado, lucroEsperado, faturamentoReal, lucroReal, porcentagemFaturamento, porcentagemLucro);
                this.p2.atualizarValores(investimento, faturamentoReal, lucroReal);
                
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(lojaapp.View.Janela.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
    }
    
    public static void serializarUsuarios() {
        
        // instancia a classe de serialização
        Usuarios usuarios = new Usuarios();
        // cria o nome do arquivo de serialização
        String nomeDoArquivo = "usuarios.ser";
        
        // pega os dados e bota no objeto
        usuarios.setUsuarios(lojaapp.View.Janela.usuarios);
        
        try {
            FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(usuarios);
            out.close();
            arquivo.close();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void desserialziarUsuarios() {
        
        String caminhoArquivo = "usuarios.ser";
        File arquivoTeste = new File(caminhoArquivo);
        
        if (arquivoTeste.exists() == true) {
            
            Usuarios usuariosSerializados = null;
            String nomeDoArquivo = "usuarios.ser";

            try {
                FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
                ObjectInputStream in = new ObjectInputStream(arquivo);

                usuariosSerializados = (Usuarios)in.readObject();
                in.close();
                arquivo.close();

                // atribui aos arrayList o que esta no arquivo serializado
                usuarios = usuariosSerializados.getUsuarios();
                
                this.p7.carregarUsuariosSerializados(usuarios);

            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(lojaapp.View.Janela.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            
        }
        
    }
    
    // =============================================== metodos p1 =====================================================
    
    public void logar(String user, String senha) {
        
        if (user.equals("admin") && senha.equals("admin")) {
            this.mostrarTela(this.p7);
        }
        else {
            if (validarDados(user, senha) == false) {
                JOptionPane.showMessageDialog(null, "Usuário inválido!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
            }
            else {

                // Transição
                this.mostrarTela(this.t1);

                Thread thread = new Thread(this.t1);
                thread.start();

            }
        }
    }
    
    public void criarConta() {
        this.p5 = new Painel5();
        this.mostrarTela(this.p5);
    }
    
    public boolean validarDados(String user, String senha) {
        if (Janela.usuarios.isEmpty()) {
            return false;
        }
        else {
            for (int i=0;i<Janela.usuarios.size();i++) {
                if ((user.equals(Janela.usuarios.get(i).getUsuario()) || user.equals(Janela.usuarios.get(i).getEmail())) && senha.equals(Janela.usuarios.get(i).getSenha())) {
                    return true;
                }
            }
            return false;
        }
    }
    
    // =============================================== metodos p2 =====================================================
    
    public void definirData() {
        // Obter a data atual
        LocalDate dataAtual = LocalDate.now();
        
        // Formatar a data atual
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formato);
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
        
        this.p2.atualizarHoraAtual(time);
    }
    
    public void novaLevaProdutos(int resposta) {
        if (resposta == JOptionPane.YES_OPTION) {
            // remove todos os dados que são serializados

            // pega o arquivo serializado
            File arquivo = new File("dados.ser");
            arquivo.delete();
            System.exit(0);
        }
    }
    
    public void adicionarItem() {
        this.p4 = new Painel4();
        this.mostrarTela(this.p4);
    }
    
    public void venderItem() {
        this.mostrarTela(this.p3);
    }
    
    public void detalhamento() {
        this.mostrarTela(this.p6);
    }
    
    // =============================================== metodos p3 =====================================================
    
    private boolean iniciou = false;
    private boolean iniciou2 = false;
    
    public void voltarP3() {
        this.mostrarTela(this.p2);
    }
    
    public void extraviar(int index1, int index2) {
        // botão extraviar
                
        if (index2 >= 0) {
            JOptionPane.showMessageDialog(null, "Não é possível extraviar itens vendidos!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
        }
        else {
            if (index1 < 0) {
                JOptionPane.showMessageDialog(null, "Algum produto da listado deve ser selecionado!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
            }
            else {
                int index = index1;

                if (iniciou == true) {
                    // pega do listaProdutosListadosVazia
                    String produtoFiltrado = listaProdutosListadosVazia.get(index);
                    // acha o indice no listaProdutosListados
                    int oldIndex = index;
                    for (int i=0;i<listaProdutosListados.size();i++) {
                        if (listaProdutosListados.get(i).equals(produtoFiltrado)) {
                            index = i;
                        }
                    }
                    // remove do filtro atual e atualiza o jlist
                    listaProdutosListadosVazia.remove(oldIndex);
                    this.p3.atualizarJlist1(listaProdutosListadosVazia);

                    // se tiver dois produtos com o mesmo nome, vai mexer no ultimo
                }
                // pega do listaProdutosListados
                String produto = listaProdutosListados.get(index);

                // remove o produto de lista com o defaultListModel
                listaProdutosListados.remove(index);

                // atualiza os models
                if (iniciou == false) {
                    this.p3.atualizarJlist1(listaProdutosListados);
                }
                this.p3.atualizarJlist2(listaProdutosVendidos);

                // atualiza o painel detalhamento
                this.p6.atualizarValores(quantidadeExtraviados, somatorioPVExtraviados, somatorioPCExtraviados, investimento, faturamentoEsperado, lucroEsperado, faturamentoReal, lucroReal, porcentagemFaturamento, porcentagemLucro);
                
                // atualiza os arrayLists (deixa no mesmo estado que o defaultListModel)
                this.produtosListados.remove(index);

                // deixa selecionado o primeiro produto da lista
                this.p3.deixarUltimoIndexSelecionado1();

                // faz a serialização
                lojaapp.View.Janela.serializar();
            }
        }
    }
    
    public void devolucao(int index1, int index2) {
        // botão devolução
        if (index1 >= 0) {
            JOptionPane.showMessageDialog(null, "não é possivel devolver itens listados!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
        }
        else { 
            if (index2 < 0) {
                JOptionPane.showMessageDialog(null, "Algum produto deve ser selecionado!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
            }
            else {

                int index = index2;

                if (iniciou2 == true) {
                    // pega do listaProdutosListadosVazia
                    String produtoFiltrado = listaProdutosVendidosVazia.get(index);
                    // acha o indice no listaProdutosListados
                    int oldIndex = index;
                    for (int i=0;i<listaProdutosVendidos.size();i++) {
                        if (listaProdutosVendidos.get(i).equals(produtoFiltrado)) {
                            index = i;
                        }
                    }
                    // remove do filtro atual e atualiza o jlist
                    listaProdutosVendidosVazia.remove(oldIndex);
                    this.p3.atualizarJlist2(listaProdutosVendidosVazia);
                }
                
                // pega do listaProdutosVendidos
                String produto = listaProdutosVendidos.get(index);

                // muda o produto de lista com o defaultListModel
                listaProdutosListados.addElement(listaProdutosVendidos.get(index));

                // remove o produto de lista com o defaultListModel
                listaProdutosVendidos.remove(index);

                // atualiza os models
                if (iniciou2 == false) {
                    this.p3.atualizarJlist2(listaProdutosVendidos);
                }
                this.p3.atualizarJlist1(listaProdutosListados);

                // atualiza os arrayLists (deixa no mesmo estado que o defaultListModel)
                Produto p1 = this.produtosVendidos.get(index);
                this.produtosListados.add(p1);
                this.produtosVendidos.remove(p1);

                // altera os valores de lucro e faturamento real e esperado
                this.lucroReal = lojaapp.View.Janela.lucroReal - (p1.getPrecoVenda() - p1.getPrecoCompra());
                this.faturamentoReal = lojaapp.View.Janela.faturamentoReal - p1.getPrecoVenda();

                // deixa selecionado o primeiro produto da lista
                this.p3.deixarUltimoIndexSelecionado2();

                // faz a serialização
                this.serializar();

                // atualiza o painel de controle (p2)
                this.p2.atualizarValores(investimento, faturamentoReal, lucroReal);

                // atualiza o painel detalhamento (p6)
                this.p6.atualizarValores(quantidadeExtraviados, somatorioPVExtraviados, somatorioPCExtraviados, investimento, faturamentoEsperado, lucroEsperado, faturamentoReal, lucroReal, porcentagemFaturamento, porcentagemLucro);
                
            }
        }
        iniciou = false;
    }
    
    public void vendido(int index1, int index2) {
        
        // botão vendido
        // verifica se tem algum item selecionado na lista

        if (index2 >= 0) {
            JOptionPane.showMessageDialog(null, "Não é possível vender itens vendidos!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else {
             if (index1 < 0) {
                 JOptionPane.showMessageDialog(null, "Selecione algum item para vender!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                 return;
             }
             else {

                int index = index1;

                if (iniciou == true) {
                    // pega do listaProdutosListadosVazia
                    String produtoFiltrado = listaProdutosListadosVazia.get(index);
                    // acha o indice no listaProdutosListados
                    int oldIndex = index;
                    for (int i=0;i<listaProdutosListados.size();i++) {
                        if (listaProdutosListados.get(i).equals(produtoFiltrado)) {
                            index = i;
                        }
                    }
                    // remove do filtro atual e atualiza o jlist
                    listaProdutosListadosVazia.remove(oldIndex);
                    this.p3.atualizarJlist1(listaProdutosListadosVazia);
                    // se tiver dois produtos com o mesmo nome, vai mexer no ultimo
                }
                else {

                }
                // pega do listaProdutosListados
                String produto = listaProdutosListados.get(index);

                // muda o produto de lista com o defaultListModel
                listaProdutosVendidos.addElement(listaProdutosListados.get(index));

                // remove o produto de lista com o defaultListModel
                listaProdutosListados.remove(index);

                // atualiza os models
                if (iniciou == false) {
                    jList1.setModel(listaProdutosListados);
                }
                jList2.setModel(listaProdutosVendidos);

                // atualiza os arrayLists (deixa no mesmo estado que o defaultListModel)
                Produto p1 = lojaapp.View.Janela.produtosListados.get(index);
                lojaapp.View.Janela.produtosVendidos.add(p1);
                lojaapp.View.Janela.produtosListados.remove(p1);

                // deixa selecionado o primeiro produto da lista
                jList1.setSelectedIndex(0);

                // atualiza os valores monetarios da janela
                lojaapp.View.Janela.faturamentoReal = lojaapp.View.Janela.faturamentoReal + p1.getPrecoVenda();
                lojaapp.View.Janela.lucroReal = lojaapp.View.Janela.lucroReal + (p1.getPrecoVenda() - p1.getPrecoCompra());

                // atualiza o painel de detalhamento (6) e de controle (2)
                lojaapp.View.Janela.p6.produtoVendido(p1.getPrecoCompra(), p1.getPrecoVenda());
                lojaapp.View.Janela.p2.produtoVendido(p1.getPrecoCompra(), p1.getPrecoVenda());

                // faz a serialização
                lojaapp.View.Janela.serializar();

             }
        }
        
    }
    
    
    
    // =============================================== metodos p6 =====================================================
    
    public void produtoExtraviado(float pc, float pv) {
        quantidadeExtraviados++;
        somatorioPCExtraviados = somatorioPCExtraviados + pc;
        somatorioPVExtraviados = somatorioPVExtraviados + pv;
    }
    
    public void atualizarPercentuais() {
        porcentagemFaturamento = Math.round((Janela.faturamentoReal * 100) / Janela.faturamentoEsperado);
        porcentagemLucro = Math.round((Janela.lucroReal * 100) / Janela.lucroEsperado);
    }
    
    public void voltarP6() {
        this.mostrarTela(this.p6);
    }
    
}
