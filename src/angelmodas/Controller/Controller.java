package angelmodas.Controller;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import angelmodas.Model.AtualizarRelogio;
import angelmodas.Model.Dados;
import angelmodas.Model.Produto;
import angelmodas.Model.Usuario;
import angelmodas.Model.Usuarios;
import angelmodas.View.Janela;
import angelmodas.View.Painel1;
import angelmodas.View.Painel2;
import angelmodas.View.Painel3;
import angelmodas.View.Painel4;
import angelmodas.View.Painel5;
import angelmodas.View.Painel6;
import angelmodas.View.Painel7;
import angelmodas.View.Transicao;

public class Controller {
    
    // Objetos das views
    private Janela janela;
    private Transicao t1;
    private Painel1 p1;
    private Painel2 p2 = new Painel2();
    private Painel3 p3 = new Painel3();
    private Painel4 p4;
    private Painel5 p5;
    private Painel6 p6 = new Painel6();
    private Painel7 p7 = new Painel7();
    
    // objetos dos models
    private ArrayList<Produto> produtosListados;
    private ArrayList<Produto> produtosVendidos;
    private ArrayList<Usuario> usuarios;
    
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
        
        definirData();
        iniciarRelogio();
    }
    
    public void startModel() {
        this.produtosListados = new ArrayList<>();
        this.produtosVendidos = new ArrayList<>();
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
        
        dado.setProdutosListados(this.produtosListados);
        dado.setProdutosVendidos(this.produtosVendidos);
        
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

                dadosSerializados = (Dados) in.readObject();
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
                
                // atualiza os DefaultListModel
                for (int i=0;i<produtosListados.size();i++) {
                    listaProdutosListados.addElement(produtosListados.get(i).getNome());
                }
                for (int i=0;i<produtosVendidos.size();i++) {
                    listaProdutosVendidos.addElement(produtosListados.get(i).getNome());
                }
                this.p3.atualizarJlist1(listaProdutosListados);
                this.p3.atualizarJlist2(listaProdutosVendidos);
                
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(angelmodas.View.Janela.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void serializarUsuarios() {
        
        // instancia a classe de serialização
        Usuarios usuariosSerializados = new Usuarios();
        // cria o nome do arquivo de serialização
        String nomeDoArquivo = "usuarios.ser";
        
        // pega os dados e bota no objeto
        usuariosSerializados.setUsuarios(this.usuarios);
        
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
    
    public void prencherListaUsuarios() {
        for (int i=0;i<usuarios.size();i++) {
            listaUsuarios.addElement(usuarios.get(i).getUsuario());
        }
    }
    
    public void desserialziarUsuarios() {
        
        String caminhoArquivo = "usuarios.ser";
        File arquivoTeste = new File(caminhoArquivo);
        
        if (arquivoTeste.exists() == true) {
            
            //Usuarios usuariosSerializados = null;
            ArrayList<Usuario> usuariosSerializados = null;
            String nomeDoArquivo = "usuarios.ser";

            try {
                FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
                ObjectInputStream in = new ObjectInputStream(arquivo);

                usuariosSerializados = (ArrayList<Usuario>) in.readObject();
                in.close();
                arquivo.close();

                // atribui aos arrayList o que esta no arquivo serializado
                usuarios = usuariosSerializados;
                
                prencherListaUsuarios();
                
                this.p7.setarModeloJlist2(listaUsuarios);

            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(angelmodas.View.Janela.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            
        }
        
    }
    
    // ================================================ transição =====================================================
    
    public void rodarTransicao() {
        this.mostrarTela(this.p2);
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
                t1 = new Transicao();
                
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
        if (this.usuarios.isEmpty()) {
            return false;
        }
        else {
            for (int i=0;i<this.usuarios.size();i++) {
                if ((user.equals(this.usuarios.get(i).getUsuario()) || user.equals(this.usuarios.get(i).getEmail())) && senha.equals(this.usuarios.get(i).getSenha())) {
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
        
        this.p2.atualizarData(dataFormatada);
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
    
    public void botaoNovaLevaProdutos(int resposta) {
        if (resposta == JOptionPane.YES_OPTION) {
            // remove todos os dados que são serializados

            // pega o arquivo serializado
            File arquivo = new File("dados.ser");
            arquivo.delete();
            System.exit(0);
        }
    }
    
    public void botaoAdicionarItem() {
        this.p4 = new Painel4();
        this.mostrarTela(this.p4);
    }
    
    public void botaoVenderItem() {
        this.mostrarTela(this.p3);
    }
    
    public void botaoDetalhamento() {
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
                
                // soma os valores
                quantidadeExtraviados++;
                somatorioPCExtraviados = somatorioPCExtraviados + this.produtosListados.get(index).getPrecoCompra();
                somatorioPVExtraviados = somatorioPVExtraviados + this.produtosListados.get(index).getPrecoVenda();
                
                // atualiza o painel detalhamento
                this.p6.atualizarValores(quantidadeExtraviados, somatorioPVExtraviados, somatorioPCExtraviados, investimento, faturamentoEsperado, lucroEsperado, faturamentoReal, lucroReal, porcentagemFaturamento, porcentagemLucro);
                
                // atualiza os arrayLists (deixa no mesmo estado que o defaultListModel)
                this.produtosListados.remove(index);

                // deixa selecionado o primeiro produto da lista
                this.p3.deixarPrimeiroIndexSelecionado1();

                // faz a serialização
                this.serializar();
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
                this.lucroReal = this.lucroReal - (p1.getPrecoVenda() - p1.getPrecoCompra());
                this.faturamentoReal = this.faturamentoReal - p1.getPrecoVenda();

                // deixa selecionado o primeiro produto da lista
                this.p3.deixarPrimeiroIndexSelecionado2();

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
                    this.p3.atualizarJlist1(listaProdutosListados);
                }
                this.p3.atualizarJlist2(listaProdutosVendidos);

                // atualiza os arrayLists (deixa no mesmo estado que o defaultListModel)
                Produto p1 = this.produtosListados.get(index);
                this.produtosVendidos.add(p1);
                this.produtosListados.remove(p1);

                // deixa selecionado o primeiro produto da lista
                this.p3.deixarPrimeiroIndexSelecionado1();

                // atualiza os valores monetarios da janela
                this.faturamentoReal =this.faturamentoReal + p1.getPrecoVenda();
                this.lucroReal = this.lucroReal + (p1.getPrecoVenda() - p1.getPrecoCompra());
                
                // atualiza os percentuais
                porcentagemFaturamento = Math.round((faturamentoReal * 100) / faturamentoEsperado);
                porcentagemLucro = Math.round((lucroReal * 100) / lucroEsperado);;

                // atualiza o painel de detalhamento (6) e de controle (2)
                this.p6.atualizarValores(quantidadeExtraviados, somatorioPVExtraviados, somatorioPCExtraviados, investimento, faturamentoEsperado, lucroEsperado, faturamentoReal, lucroReal, porcentagemFaturamento, porcentagemLucro);
                this.p2.atualizarValores(investimento, faturamentoReal, lucroReal);

                // faz a serialização
                this.serializar();

             }
        }
        
    }
    
    JRadioButton buttonTemp, buttonTemp2;
    
    public void filtrar(JRadioButton jRadioButton1, JRadioButton jRadioButton2, JRadioButton jRadioButton3, JRadioButton jRadioButton4, JRadioButton jRadioButton5, JRadioButton jRadioButton6, JRadioButton jRadioButton7, JRadioButton jRadioButton8, JRadioButton jRadioButton9) {
        
        String genero = "";
        String categoria = "";

        // deixa a lista temporaria de filtragem vazia
        listaProdutosListadosVazia.removeAllElements();
        listaProdutosVendidosVazia.removeAllElements();

        // coloca a lista padrao inicialmente
        this.p3.atualizarJlist1(listaProdutosListados);
        this.p3.atualizarJlist2(listaProdutosVendidos);

        // pega os dados do filtro
        // GENERO
        if (jRadioButton1.isSelected()) {
            genero = "masculino";
            buttonTemp = jRadioButton1;
        }
        else {
            if (jRadioButton2.isSelected()) {
                genero = "feminino";
                buttonTemp = jRadioButton2;
            }
        }

        // CATEGORIA
        if (jRadioButton3.isSelected()) {
            categoria = "calça";
            buttonTemp2 = jRadioButton3;
        }
        else {
            if (jRadioButton4.isSelected()) {
                categoria = "camiseta";
                buttonTemp2 = jRadioButton4;
            }
            else {
                if (jRadioButton5.isSelected()) {
                    categoria = "tenis";
                    buttonTemp2 = jRadioButton5;
                }
                else {
                    if (jRadioButton6.isSelected()) {
                        categoria = "casaco";
                        buttonTemp2 = jRadioButton6;
                    }
                    else {
                        if (jRadioButton7.isSelected()) {
                            categoria = "acessorios";
                            buttonTemp2 = jRadioButton7;
                        }
                        else {
                            if (jRadioButton8.isSelected()) {
                                categoria = "meia";
                                buttonTemp2 = jRadioButton8;
                            }
                            else {
                                if (jRadioButton9.isSelected()) {
                                    categoria = "roupaIntima";
                                    buttonTemp2 = jRadioButton9;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (genero.equals("") && categoria.equals("")) {
            // se os filtros forem vazios mostra tudo
            this.p3.atualizarJlist1(listaProdutosListados);
            this.p3.atualizarJlist2(listaProdutosVendidos);
            iniciou = false;
        }
        else {
            if (!genero.equals("") && !categoria.equals("")) {
                // faz a pesquisa com dois filtros

                for (int i=0;i<listaProdutosListados.size();i++) {
                    // vai ter que mexer no arrayList, pra pegar os atributos
                    // se os filtros aplicarem certo (pelo array) ele joga na lista vazia (temporaria)
                    if (this.produtosListados.get(i).getCategoria().equals(categoria) && this.produtosListados.get(i).getGenero().equals(genero)) {
                        listaProdutosListadosVazia.addElement(listaProdutosListados.get(i));
                    }
                }

                for (int i=0;i<listaProdutosVendidos.size();i++) {
                    if (this.produtosVendidos.get(i).getCategoria().equals(categoria) && this.produtosVendidos.get(i).getGenero().equals(genero)) {
                        listaProdutosVendidosVazia.addElement(listaProdutosVendidos.get(i));
                    }
                }

            }
            else {
                if (genero.equals("")) {
                    // faz busca só pela categoria

                    for (int i=0;i<listaProdutosListados.size();i++) {

                        if (this.produtosListados.get(i).getCategoria().equals(categoria)) {
                            listaProdutosListadosVazia.addElement(listaProdutosListados.get(i));
                        }

                    }

                    for (int i=0;i<listaProdutosVendidos.size();i++) {
                        if (this.produtosVendidos.get(i).getCategoria().equals(categoria)) {
                            listaProdutosVendidosVazia.addElement(listaProdutosVendidos.get(i));
                        }
                    }
                }
                else {
                    if (categoria.equals("")) {
                        // faz a busca só pelo genero

                        for (int i=0;i<listaProdutosListados.size();i++) {

                            if (this.produtosListados.get(i).getGenero().equals(genero)) {
                                listaProdutosListadosVazia.addElement(listaProdutosListados.get(i));
                            }

                        }
                        for (int i=0;i<listaProdutosVendidos.size();i++) {
                            if (this.produtosVendidos.get(i).getGenero().equals(genero)) {
                                listaProdutosVendidosVazia.addElement(listaProdutosVendidos.get(i));
                            }
                        }
                    }
                }
            }
            iniciou = true;
            // atualiza o jlist
            this.p3.atualizarJlist1(listaProdutosListadosVazia);
            this.p3.atualizarJlist2(listaProdutosVendidosVazia);
        }
        
    }
    
    public void alterarPrecoVenda(int index1, int index2) {
        
        float lastPreco = -1;
        float novoPV = -1;
        int index = -1;

        if (index2 >= 0) {
            JOptionPane.showMessageDialog(null, "O produto deve estar listado para ter o preço alterado!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
        }
        else {
            if (index1 < 0) {
                JOptionPane.showMessageDialog(null, "Algum produto listado deve ser selecionado!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
            }
            else {
                index = index1;

                // verifica se esta com a lista filtrada ou na padrao
                if (iniciou == true) {
                    // encontra o index equivalente na lista padrao
                    // pega do listaProdutosListadosVazia
                    String produtoFiltrado = listaProdutosListadosVazia.get(index);
                    // acha o indice no listaProdutosListados
                    for (int i=0;i<listaProdutosListados.size();i++) {
                        if (listaProdutosListados.get(i).equals(produtoFiltrado)) {
                            index = i;
                        }
                    }
                }

                lastPreco = this.produtosListados.get(index).getPrecoVenda();

                // Cria uma nova instância do objeto Produto para a célula específica
                Produto p1 = null;
                novoPV = Float.parseFloat(JOptionPane.showInputDialog("Digite o novo preço de compra:"));
                p1 = new Produto(this.produtosListados.get(index).getNome(), this.produtosListados.get(index).getPrecoCompra(), novoPV, this.produtosListados.get(index).getCategoria(), this.produtosListados.get(index).getGenero());

                // Atualiza a célula específica com o novo objeto Produto
                this.produtosListados.set(index, p1);

                if (lastPreco < novoPV) {
                    this.lucroEsperado = this.lucroEsperado + (novoPV - lastPreco);
                    this.faturamentoEsperado = this.faturamentoEsperado + (novoPV - lastPreco);
                }
                else {
                    this.lucroEsperado = this.lucroEsperado - (lastPreco - novoPV);
                    this.faturamentoEsperado = this.faturamentoEsperado - (lastPreco - novoPV);
                }

                this.serializar();

                this.p2.atualizarValores(investimento, faturamentoReal, lucroReal);
                this.p6.atualizarValores(quantidadeExtraviados, somatorioPVExtraviados, somatorioPCExtraviados, investimento, faturamentoEsperado, lucroEsperado, faturamentoReal, lucroReal, porcentagemFaturamento, porcentagemLucro);

                // atualiza o card de informações a direita
                this.p3.mostrarDetalhesProdutos(produtosListados, index);
                
            }
        }
        
    }
    
    public void cliqueJlist1(int index) {
        if (iniciou == true) {
           // encontra o index equivalente na lista padrao
           // pega do listaProdutosListadosVazia
           String produtoFiltrado = listaProdutosListadosVazia.get(index);
           // acha o indice no listaProdutosListados
           for (int i=0;i<listaProdutosListados.size();i++) {
               if (listaProdutosListados.get(i).equals(produtoFiltrado)) {
                   index = i;
               }
           }
       }
        
        this.p3.mostrarDetalhesProdutos(produtosListados, index);
    }
    
    public void cliqueJlist2(String selecionado) {
        // acha onde esta o item selecionado
        for (int i=0;i<this.produtosVendidos.size();i++) {
            if (selecionado.equals(this.produtosVendidos.get(i).getNome())) {
                this.p3.mostrarDetalhesProdutos(produtosVendidos, i);
            }
        }
    }
    
    public void substituirModelo() {
        this.p3.atualizarJlist1(listaProdutosListados);
    }
    
    public void substituirModelo2() {
        this.p3.atualizarJlist2(listaProdutosVendidos);
    }
    
    public void filtrarBarraDeBuscaKeyReleaseListados (String busca, java.awt.event.KeyEvent evt) {
        
        if (busca.equals("")) {
            this.p3.atualizarJlist1(listaProdutosListados);
            this.listaProdutosListadosVazia.removeAllElements();
            this.listaProdutosListadosTemp.removeAllElements();
            this.iniciou = false;
        }
        else {
            if (iniciou == true) {
                // executa pra somente um caracter
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    for (int i=0;i<listaProdutosListadosTemp.size();i++) {
                        
                        if (String.valueOf(listaProdutosListadosTemp.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                            listaProdutosListadosVazia.addElement(listaProdutosListadosTemp.get(i));
                            listaProdutosListadosTemp.remove(i);
                            this.p3.atualizarJlist1(listaProdutosListadosVazia);
                            i--;
                        }
                    }
                }
                else {
                    
                    int tamanhoLista = listaProdutosListadosVazia.size();
                    for (int i = tamanhoLista - 1; i >= 0; i--) {
                        if (!String.valueOf(listaProdutosListadosVazia.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                            
                            listaProdutosListadosTemp.addElement(listaProdutosListadosVazia.get(i));
                            //listaProdutosVazia.remove(i);
                        }
                    }
                    
                    for (int i=0;i<listaProdutosListadosTemp.size();i++) {
                        String item = listaProdutosListadosTemp.get(i);
                        listaProdutosListadosVazia.removeElement(item);
                    }
                    this.p3.atualizarJlist1(listaProdutosListadosVazia);
                }
                
            }
            else {
                for (int i=0;i<listaProdutosListados.size();i++) {
                    if (String.valueOf(listaProdutosListados.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                        listaProdutosListadosVazia.addElement(listaProdutosListados.get(i));
                        iniciou = true;
                        this.p3.atualizarJlist1(listaProdutosListadosVazia);
                    }
                }
            }
        }
        
    }
    
    public void filtrarBarraDeBuscaKeyReleaseVendidos(String busca, java.awt.event.KeyEvent evt) {
        
        if (busca.equals("")) {
            this.p3.atualizarJlist2(listaProdutosVendidos);
            listaProdutosVendidosVazia.removeAllElements();
            listaProdutosVendidosTemp.removeAllElements();
            iniciou2 = false;
        }
        else {
            if (iniciou2 == true) {
                // executa pra somente um caracter
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    for (int i=0;i<listaProdutosVendidosTemp.size();i++) {
                        
                        if (String.valueOf(listaProdutosVendidosTemp.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                            listaProdutosVendidosVazia.addElement(listaProdutosVendidosTemp.get(i));
                            listaProdutosVendidosTemp.remove(i);
                            this.p3.atualizarJlist2(listaProdutosVendidosVazia);
                            i--;
                        }
                    }
                }
                else {
                    
                    int tamanhoLista = listaProdutosVendidosVazia.size();
                    for (int i = tamanhoLista - 1; i >= 0; i--) {
                        if (!String.valueOf(listaProdutosVendidosVazia.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                            
                            listaProdutosVendidosTemp.addElement(listaProdutosVendidosVazia.get(i));
                            //listaProdutosVazia.remove(i);
                        }
                    }
                    
                    for (int i=0;i<listaProdutosVendidosTemp.size();i++) {
                        String item = listaProdutosVendidosTemp.get(i);
                        listaProdutosVendidosVazia.removeElement(item);
                    }
                    this.p3.atualizarJlist2(listaProdutosVendidosVazia);
                }
                
            }
            else {
                for (int i=0;i<listaProdutosVendidos.size();i++) {
                    if (String.valueOf(listaProdutosVendidos.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                        listaProdutosVendidosVazia.addElement(listaProdutosVendidos.get(i));
                        iniciou2 = true;
                        this.p3.atualizarJlist2(listaProdutosVendidosVazia);
                    }
                }
            }
        }
        
    }
    
    public void adicionarItensSerializados() {
        if (this.produtosListados != null) {
            for (int i=0;i<this.produtosListados.size();i++) {
                listaProdutosListados.addElement(this.produtosListados.get(i).getNome());
            }
        }
        
        if (this.produtosVendidos != null) {
            for (int i=0;i<this.produtosVendidos.size();i++) {
                listaProdutosVendidos.addElement(this.produtosVendidos.get(i).getNome());
            }
        }
    }
    
    public void adicionarElementoLista(Produto p1) {
        String nomeProduto = p1.getNome();
        listaProdutosListados.addElement(nomeProduto);
        this.p3.atualizarJlist1(listaProdutosListados);
    }
    
    // =============================================== metodos p4 =====================================================
    
    public void adicionarItem(String nomeProduto, String pcstring, String pvstring, int quantidade, JRadioButton jRadioButton3, JRadioButton jRadioButton4, JRadioButton jRadioButton5, JRadioButton jRadioButton6, JRadioButton jRadioButton7, JRadioButton jRadioButton8, JRadioButton jRadioButton9, JRadioButton jRadioButton10, JRadioButton jRadioButton11) {
        
        String categoria = "";
        String genero = "";
        float precoCompra;
        float precoVenda;

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
                    categoria = "tenis";
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
                                categoria = "acessorios";
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
        if (nomeProduto.trim().isEmpty() || categoria.trim().isEmpty() || genero.trim().isEmpty() || pcstring.trim().isEmpty() || pvstring.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser prenchidos!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                precoCompra = Float.parseFloat(pcstring);
                precoVenda = Float.parseFloat(pvstring);
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
                    this.produtosListados.add(p1);
                    // atualiza o Jlist do painel3
                    this.p3.adicionarElementoLista(p1);
                    // atualiza os valores monetarios da janela
                    this.investimento = this.investimento + precoCompra;
                    this.faturamentoEsperado = this.faturamentoEsperado + precoVenda;
                    this.lucroEsperado = this.lucroEsperado + (precoVenda - precoCompra);
                }

                // atualiza o painel detalhamento e de controle
                this.p6.atualizarValores(quantidadeExtraviados, somatorioPVExtraviados, somatorioPCExtraviados, investimento, faturamentoEsperado, lucroEsperado, faturamentoReal, lucroReal, porcentagemFaturamento, porcentagemLucro);
                this.p2.atualizarValores(investimento, faturamentoReal, lucroReal);

                // chama o metodo que faz a serialização
                this.serializar();

                // exibe mensagem de produto adicionado
                JOptionPane.showMessageDialog(null, "Item adicionado com sucesso!", "Angel Modas", JOptionPane.INFORMATION_MESSAGE);

                // limpa os textFields
                this.p4.limparCampos();

            }
        }
        
    }
    
    public void botaoVoltarP4() {
        this.mostrarTela(this.p2);
    }
    
    // =============================================== metodos p5 =====================================================
    
    public void botaoVoltarP5() {
        this.mostrarTela(this.p1);
    }
    
    public void cadastrarUsuario(String usuario, String email, String senha) {
        
        // verifica se os campos foram preenchidos corertamente
        if (usuario.trim().isEmpty() || email.trim().isEmpty() || senha.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser prenchidos!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
        }
        else {
            if (!email.contains("@")) {
                JOptionPane.showMessageDialog(null, "Email inválido!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // cria o objeto e armazena os valores
            Usuario u1 = new Usuario(usuario, senha, email);

            // adiciona ao arrayList
            this.usuarios.add(u1);

            // mensagem que deu certo
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!", "Angel Modas", JOptionPane.INFORMATION_MESSAGE);

            // limpar campos
            this.p5.limparCampos();

            // faz a serialização
            this.serializarUsuarios();

            // atualiza o painel de usuarios cadastrados (p7)
            this.p7.setarModeloJlist2(this.listaUsuarios);
        }
        
    }
    
    
    
    // =============================================== metodos p6 =====================================================
    
    public void produtoExtraviado(float pc, float pv) {
        quantidadeExtraviados++;
        somatorioPCExtraviados = somatorioPCExtraviados + pc;
        somatorioPVExtraviados = somatorioPVExtraviados + pv;
    }
    
    public void atualizarPercentuais() {
        porcentagemFaturamento = Math.round((this.faturamentoReal * 100) / this.faturamentoEsperado);
        porcentagemLucro = Math.round((this.lucroReal * 100) / this.lucroEsperado);
    }
    
    public void voltarP6() {
        this.mostrarTela(this.p2);
    }
    
    // =============================================== metodos p7 =====================================================
    
    int lastIndex = -1;
    
    public DefaultListModel<String> carregarUsuarios() {
        if (usuarios.isEmpty() == false) {
            for (int i=0;i<usuarios.size();i++) {
                listaUsuarios.addElement(usuarios.get(i).getUsuario());
            }
            
            this.p7.setarModeloJlist2(listaUsuarios);
            
            this.p7.deixarUsuarioClicado(usuarios);
            
        }
        return listaUsuarios;
    }
    
    public void carregarUsuarioAlterado(int index) {
        
        listaUsuarios.removeAllElements();
        for (int i=0;i<this.usuarios.size();i++) {
            listaUsuarios.addElement(this.usuarios.get(i).getUsuario());
        }
        this.p7.setarModeloJlist2(listaUsuarios);
        if (index >= 0) {
            this.p7.mostrarDadosUsuario(usuarios, index);
        }
        
    }
    
    public void botaoDeletarUsuario(int index) {
        
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Algum item da lista deve ser selecionado!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
        }
        else {
            int resposta = JOptionPane.showOptionDialog(null,"Tem certeza que deseja deletar usuario?","Confirmação",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Sim", "Não", "Cancelar"},"Sim");
            if (resposta == JOptionPane.YES_OPTION) {

                this.usuarios.remove(index);
                this.serializarUsuarios();
                listaUsuarios.remove(index);
                this.p7.setarModeloJlist2(listaUsuarios);

            }
            this.p7.limparCampos();
        }
    }
    
    public void botaoAlterarUsuario(int index, JRadioButton jRadioButton1, JRadioButton jRadioButton2, JRadioButton jRadioButton3) {
        
        if (index < 0) {
            if (lastIndex > 0) {
                index = lastIndex;
            }
        }
        else {
            lastIndex = index;

            if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected() && !jRadioButton3.isSelected()) {
                JOptionPane.showMessageDialog(null, "Selecione algum atributo do usuario para alterar!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
            }
            else {
                if (jRadioButton1.isSelected()) {
                    // pega o input do dado alterado
                    String novoUsuario = JOptionPane.showInputDialog("Digite o novo usuário:");
                    if (novoUsuario != null) {
                        this.usuarios.get(index).setUsuario(novoUsuario);
                    }
                }
                else {
                    if (jRadioButton2.isSelected()) {
                        // pega o input do dado alterado
                        String novoEmail = JOptionPane.showInputDialog("Digite o novo email:");
                        if (novoEmail != null) {
                            if (!novoEmail.contains("@")) {
                                JOptionPane.showMessageDialog(null, "email inválido. Operação cancelada!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                this.usuarios.get(index).setEmail(novoEmail);
                            }
                        }
                    }
                    else {
                        if (jRadioButton3.isSelected()) {
                            // pega o input do dado alterado
                            String novaSenha = JOptionPane.showInputDialog("Digite a nova senha:");
                            if (novaSenha != null) {
                                this.usuarios.get(index).setSenha(novaSenha);
                            }
                        }
                    }
                }

                this.serializarUsuarios();
                carregarUsuarioAlterado(index);
                this.p7.deixarIndexSelecionado(lastIndex);

            }
        }
                
    }
    
    public void botaoVoltarP7() {
        this.p1.deixarTextFieldsPadrao();
        this.mostrarTela(this.p1);
    }
    
    public void clicarJlist(int index) {
        if (index >= 0) {
            this.p7.setTextRadio(usuarios, index);
        }
    }
    
}
