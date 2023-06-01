package lojaapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class Painel3 extends javax.swing.JPanel {
    
    public static DefaultListModel<String> listaProdutosListados = new DefaultListModel<>();
    public static DefaultListModel<String> listaProdutosListadosVazia = new DefaultListModel<>();
    public DefaultListModel<String> listaProdutosListadosTemp = new DefaultListModel<>();
    
    public static DefaultListModel<String> listaProdutosVendidos = new DefaultListModel<>();
    public static DefaultListModel<String> listaProdutosVendidosVazia = new DefaultListModel<>();
    public DefaultListModel<String> listaProdutosVendidosTemp = new DefaultListModel<>();
    
    JPanel paneInteracaoCentral = new JPanel();
    JPanel paneVoltar = new JPanel();
    JLabel botaoVoltar = new JLabel("Voltar");
    JPanel paneExtraviar = new JPanel();
    JLabel botaoExtraviar = new JLabel("Extraviar");
    JPanel paneDevolucao = new JPanel();
    JLabel botaoDevolucao = new JLabel("Devolução");
    JPanel paneVendido = new JPanel();
    JLabel botaoVendido = new JLabel("Vendido");
    JPanel paneFiltros = new JPanel();
    JLabel botaoFiltros = new JLabel("Filtros");
    JPanel paneFiltrar = new JPanel();
    JLabel botaoFiltrar = new JLabel("Filtrar");
    
    String busca;
    static boolean iniciou = false;
    static boolean iniciou2 = false;
    static int i = 0;
    static boolean filtrado = false;
    static JRadioButton buttonTemp;
    static JRadioButton buttonTemp2;
    
    public Painel3() {
        initComponents();
        jList1.setModel(listaProdutosListados);
        jList2.setModel(listaProdutosVendidos);
        jPanel2.setVisible(false);
        adicionarBotoes();
        config();
    }
    
    public void adicionarBotoes() {
        // adiciona as bordas tracejadas
        jPanel2.setBorder(new BordaTracejada(Color.WHITE, 3, 5));
        jPanel5.setBorder(new BordaTracejada(Color.WHITE, 3, 5));
        
        // coberturas
        JPanel horizontal1 = new JPanel();
        horizontal1.setBounds(300, 172, 120, 8);
        horizontal1.setBackground(Color.WHITE);
        jPanel1.add(horizontal1);
        
        JPanel horizontal2 = new JPanel();
        horizontal2.setBounds(300, 206, 120, 14);
        horizontal2.setBackground(Color.WHITE);
        jPanel1.add(horizontal2);
        
        JPanel horizontal3 = new JPanel();
        horizontal3.setBounds(300, 246, 120, 17);
        horizontal3.setBackground(Color.WHITE);
        jPanel1.add(horizontal3);
        
        JPanel horizontal4 = new JPanel();
        horizontal4.setBounds(300, 289, 120, 8);
        horizontal4.setBackground(Color.WHITE);
        jPanel1.add(horizontal4);
        
        JPanel horizontal5 = new JPanel();
        horizontal5.setBounds(300, 432, 120, 8);
        horizontal5.setBackground(Color.WHITE);
        jPanel1.add(horizontal5);
        
        JPanel horizontal6 = new JPanel();
        horizontal6.setBounds(300, 466, 120, 8);
        horizontal6.setBackground(Color.WHITE);
        jPanel1.add(horizontal6);
        
        JPanel horizontal7 = new JPanel();
        horizontal7.setBounds(20, 378, 100, 8);
        horizontal7.setBackground(new Color(217, 50, 128));
        jPanel1.add(horizontal7);
        
        JPanel horizontal8 = new JPanel();
        horizontal8.setBounds(20, 412, 100, 8);
        horizontal8.setBackground(new Color(217, 50, 128));
        jPanel1.add(horizontal8);
        
        JPanel horizontal9 = new JPanel();
        horizontal9.setBounds(310, 378, 100, 8);
        horizontal9.setBackground(Color.WHITE);
        jPanel1.add(horizontal9);
        
        JPanel horizontal10 = new JPanel();
        horizontal10.setBounds(310, 412, 100, 8);
        horizontal10.setBackground(Color.WHITE);
        jPanel1.add(horizontal10);
        
        // botao filtros
        botaoFiltros.setBounds(337, 384, 100, 30);
        botaoFiltros.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoFiltros.setForeground(Color.WHITE);
        jPanel1.add(botaoFiltros);
        
        paneFiltros.setBackground(new Color(217, 50, 128));
        paneFiltros.setBorder(new RoundBorder(Color.WHITE, 50, 11));
        paneFiltros.setBounds(310, 381, 100, 36);
        jPanel1.add(paneFiltros);
        
        // botao filtrar
        botaoFiltrar.setBounds(47, 384, 100, 30);
        botaoFiltrar.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoFiltrar.setForeground(new Color(217, 50, 128));
        jPanel1.add(botaoFiltrar);
        botaoFiltrar.setVisible(false);
        
        paneFiltrar.setBackground(Color.WHITE);
        paneFiltrar.setBorder(new RoundBorder(new Color(217, 50, 128), 50, 11));
        paneFiltrar.setBounds(20, 381, 100, 36);
        jPanel1.add(paneFiltrar);
        paneFiltrar.setVisible(false);
        
        // botao voltar
        botaoVoltar.setBounds(337, 439, 100, 30);
        botaoVoltar.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoVoltar.setForeground(Color.WHITE);
        jPanel1.add(botaoVoltar);
        
        paneVoltar.setBackground(new Color(217, 50, 128));
        paneVoltar.setBorder(new RoundBorder(Color.WHITE, 50, 11));
        paneVoltar.setBounds(310, 435, 100, 36);
        jPanel1.add(paneVoltar);
        
        // botao extraviar
        botaoExtraviar.setBounds(325, 262, 100, 30);
        botaoExtraviar.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoExtraviar.setForeground(Color.WHITE);
        jPanel1.add(botaoExtraviar);
        
        paneExtraviar.setBackground(new Color(217, 50, 138));
        paneExtraviar.setBorder(new RoundBorder(Color.WHITE, 50, 11));
        paneExtraviar.setBounds(302, 258, 117, 36);
        jPanel1.add(paneExtraviar);
        
        // botao devolução
        botaoDevolucao.setBounds(320, 219, 100, 30);
        botaoDevolucao.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoDevolucao.setForeground(Color.WHITE);
        jPanel1.add(botaoDevolucao);
        
        paneDevolucao.setBackground(new Color(217, 50, 138));
        paneDevolucao.setBorder(new RoundBorder(Color.WHITE, 50, 11));
        paneDevolucao.setBounds(302, 215, 117, 36);
        jPanel1.add(paneDevolucao);
        
        // botao vendido
        botaoVendido.setBounds(327, 179, 100, 30);
        botaoVendido.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        botaoVendido.setForeground(Color.WHITE);
        jPanel1.add(botaoVendido);
        
        paneVendido.setBackground(new Color(217, 50, 138));
        paneVendido.setBorder(new RoundBorder(Color.WHITE, 50, 11));
        paneVendido.setBounds(302, 175, 117, 36);
        jPanel1.add(paneVendido);
        
        // adiciona painel central branco de interação (de botoes)
        paneInteracaoCentral.setBounds(300, 50, 120, 550);
        paneInteracaoCentral.setBackground(Color.WHITE);
        jPanel1.add(paneInteracaoCentral);
        
    }
    
    public void adicionarElementoLista(Produto p1) {
        
        String nomeProduto = p1.getNome();
        listaProdutosListados.addElement(nomeProduto);
        jList1.setModel(listaProdutosListados);
        
    }
    
    public static void adicionarItensSerializados() {
        if (Janela.produtosListados != null) {
            for (int i=0;i<Janela.produtosListados.size();i++) {
                listaProdutosListados.addElement(Janela.produtosListados.get(i).getNome());
            }
        }
        
        if (Janela.produtosVendidos != null) {
            for (int i=0;i<Janela.produtosVendidos.size();i++) {
                listaProdutosVendidos.addElement(Janela.produtosVendidos.get(i).getNome());
            }
        }
        else {
            System.out.println("aaaaaa");
        }
    }
    
    public void config() {
        
        paneVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                // passa para o painel de login
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                janela.getContentPane().remove(Janela.p3);
                janela.add(Janela.p2, BorderLayout.CENTER);
                janela.pack();
                
            }
        });
        
        paneExtraviar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                // botão extraviar
                
                if (jList2.getSelectedIndex() >= 0) {
                    JOptionPane.showMessageDialog(null, "Não é possível extraviar itens vendidos!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (jList1.getSelectedIndex() < 0) {
                        JOptionPane.showMessageDialog(null, "Algum produto da listado deve ser selecionado!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        int index = jList1.getSelectedIndex();
                        
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
                            jList1.setModel(listaProdutosListadosVazia);
                            
                            // se tiver dois produtos com o mesmo nome, vai mexer no ultimo
                        }
                        else {
                            
                        }
                        // pega do listaProdutosListados
                        String produto = listaProdutosListados.get(index);

                        // remove o produto de lista com o defaultListModel
                        listaProdutosListados.remove(index);

                        // atualiza os models
                        if (iniciou == false) {
                            jList1.setModel(listaProdutosListados);
                        }
                        jList2.setModel(listaProdutosVendidos);

                        // atualiza o painel detalhamento
                        Janela.p6.produtoExtraviado(Janela.produtosListados.get(index).getPrecoCompra(), Janela.produtosListados.get(index).getPrecoVenda());
                        
                        // atualiza os arrayLists (deixa no mesmo estado que o defaultListModel)
                        Janela.produtosListados.remove(index);
                        
                        // deixa selecionado o primeiro produto da lista
                        jList1.setSelectedIndex(0);

                        // faz a serialização
                        Janela.serializar();
                    }
                }
            }
        });
        
        paneDevolucao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                // botão devolução
                if (jList1.getSelectedIndex() >= 0) {
                    JOptionPane.showMessageDialog(null, "não é possivel devolver itens listados!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                }
                else { 
                    if (jList2.getSelectedIndex() < 0) {
                        JOptionPane.showMessageDialog(null, "Algum produto deve ser selecionado!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        
                        int index = jList2.getSelectedIndex();
                        
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
                            jList2.setModel(listaProdutosVendidosVazia);
                            // se tiver dois produtos com o mesmo nome, vai mexer no ultimo
                        }
                        else {

                        }
                        // pega do listaProdutosVendidos
                        String produto = listaProdutosVendidos.get(index);

                        // muda o produto de lista com o defaultListModel
                        listaProdutosListados.addElement(listaProdutosVendidos.get(index));

                        // remove o produto de lista com o defaultListModel
                        listaProdutosVendidos.remove(index);

                        // atualiza os models
                        if (iniciou2 == false) {
                            jList2.setModel(listaProdutosVendidos);
                        }
                        jList1.setModel(listaProdutosListados);

                        // atualiza os arrayLists (deixa no mesmo estado que o defaultListModel)
                        Produto p1 = Janela.produtosVendidos.get(index);
                        Janela.produtosListados.add(p1);
                        Janela.produtosVendidos.remove(p1);
                        
                        // deixa selecionado o primeiro produto da lista
                        jList2.setSelectedIndex(0);

                        // faz a serialização
                        Janela.serializar();
                        
                    }
                }
                
                iniciou = false;
                
                
                // codigo velho
                /*int index = jList2.getSelectedIndex();

                // adiciona o produto a lista de listados e ao seu model
                Janela.produtosListados.add(Janela.produtosVendidos.get(index));
                listaProdutosListados.addElement(Janela.produtosVendidos.get(index).getNome());

                // remove o produto da lista de vendidos e ao seu model
                listaProdutosVendidos.removeElement(Janela.produtosVendidos.get(index).getNome());
                Janela.produtosVendidos.remove(index);

                // atualiza os models
                jList1.setModel(listaProdutosListados);
                jList2.setModel(listaProdutosVendidos);

                // faz a serialização 
                Janela.serializar();*/
                
            }
        });
        
        paneVendido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                // botão vendido
                // verifica se tem algum item selecionado na lista
                
                if (jList2.getSelectedIndex() >= 0) {
                    JOptionPane.showMessageDialog(null, "Não é possível vender itens vendidos!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                     if (jList1.getSelectedIndex() < 0) {
                         JOptionPane.showMessageDialog(null, "Selecione algum item para vender!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                         return;
                     }
                     else {
                         
                        int index = jList1.getSelectedIndex();
                
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
                            jList1.setModel(listaProdutosListadosVazia);
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
                        Produto p1 = Janela.produtosListados.get(index);
                        Janela.produtosVendidos.add(p1);
                        Janela.produtosListados.remove(p1);
                        
                        // deixa selecionado o primeiro produto da lista
                        jList1.setSelectedIndex(0);
                        
                        // atualiza os valores monetarios da janela
                        Janela.faturamentoReal = Janela.faturamentoReal + p1.getPrecoVenda();
                        Janela.lucroReal = Janela.lucroReal + (p1.getPrecoVenda() - p1.getPrecoCompra());
                        
                        // atualiza o painel de detalhamento (6) e de controle (2)
                        Janela.p6.produtoVendido(p1.getPrecoCompra(), p1.getPrecoVenda());
                        Janela.p2.produtoVendido(p1.getPrecoCompra(), p1.getPrecoVenda());

                        // faz a serialização
                        Janela.serializar();
                         
                     }
                }

                
                
                // CODIGO VELHO
                /*// adiciona o produto a lista de vendidos e ao seu model
                Janela.produtosVendidos.add(Janela.produtosListados.get(index));
                listaProdutosVendidos.addElement(Janela.produtosListados.get(index).getNome());

                // remove o produto da lista de listados e ao seu model
                listaProdutosListados.removeElement(Janela.produtosListados.get(index).getNome());
                Janela.produtosListados.remove(index);

                // atualiza os models
                jList1.setModel(listaProdutosListados);
                jList2.setModel(listaProdutosVendidos);

                // faz a serialização 
                Janela.serializar();*/
                
            }
        });
        
        paneFiltros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                // os filtros serão aplicados as duas listas
                if (i == 0) {
                    buttonGroup1.clearSelection();
                    buttonGroup2.clearSelection();
                    jPanel2.setVisible(true);
                    botaoFiltrar.setVisible(true);
                    paneFiltrar.setVisible(true);
                    paneFiltros.setBackground(Color.red);
                    filtrado = false;
                    i++;
                } else {
                    jPanel2.setVisible(false);
                    botaoFiltrar.setVisible(false);
                    paneFiltrar.setVisible(false);
                    paneFiltros.setBackground(new Color(217,50,128));
                    i--;
                } 
                
            }
        });
        
        paneFiltrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String genero = "";
                String categoria = "";
                
                // deixa a lista temporaria de filtragem vazia
                listaProdutosListadosVazia.removeAllElements();
                listaProdutosVendidosVazia.removeAllElements();
                
                // coloca a lista padrao inicialmente
                jList1.setModel(listaProdutosListados);
                jList2.setModel(listaProdutosVendidos);
                    
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

                // ATUALIZACAONOVA

                if (genero.equals("") && categoria.equals("")) {
                    // se os filtros forem vazios mostra tudo
                    jList1.setModel(listaProdutosListados);
                    jList2.setModel(listaProdutosVendidos);
                    iniciou = false;
                }
                else {
                    if (!genero.equals("") && !categoria.equals("")) {
                        // faz a pesquisa com dois filtros
                        
                        for (int i=0;i<listaProdutosListados.size();i++) {
                            // vai ter que mexer no arrayList, pra pegar os atributos
                            // se os filtros aplicarem certo (pelo array) ele joga na lista vazia (temporaria)
                            if (Janela.produtosListados.get(i).getCategoria().equals(categoria) && Janela.produtosListados.get(i).getGenero().equals(genero)) {
                                listaProdutosListadosVazia.addElement(listaProdutosListados.get(i));
                            }
                        }
                        
                        for (int i=0;i<listaProdutosVendidos.size();i++) {
                            if (Janela.produtosVendidos.get(i).getCategoria().equals(categoria) && Janela.produtosVendidos.get(i).getGenero().equals(genero)) {
                                listaProdutosVendidosVazia.addElement(listaProdutosVendidos.get(i));
                            }
                        }
                        
                    }
                    else {
                        if (genero.equals("")) {
                            // faz busca só pela categoria
                            
                            for (int i=0;i<listaProdutosListados.size();i++) {
                                
                                if (Janela.produtosListados.get(i).getCategoria().equals(categoria)) {
                                    listaProdutosListadosVazia.addElement(listaProdutosListados.get(i));
                                }
                                
                            }
                            
                            for (int i=0;i<listaProdutosVendidos.size();i++) {
                                if (Janela.produtosVendidos.get(i).getCategoria().equals(categoria)) {
                                    listaProdutosVendidosVazia.addElement(listaProdutosVendidos.get(i));
                                }
                            }
                        }
                        else {
                            if (categoria.equals("")) {
                                // faz a busca só pelo genero
                                
                                for (int i=0;i<listaProdutosListados.size();i++) {
                                    
                                    if (Janela.produtosListados.get(i).getGenero().equals(genero)) {
                                        listaProdutosListadosVazia.addElement(listaProdutosListados.get(i));
                                    }
                                    
                                }
                                for (int i=0;i<listaProdutosVendidos.size();i++) {
                                    if (Janela.produtosVendidos.get(i).getGenero().equals(genero)) {
                                        listaProdutosVendidosVazia.addElement(listaProdutosVendidos.get(i));
                                    }
                                }
                            }
                        }
                    }
                    iniciou = true;
                    // atualiza o jlist
                    jList1.setModel(listaProdutosListadosVazia);
                    jList2.setModel(listaProdutosVendidosVazia);
                }


                // CODIGO VELHO
                /*for (int i=0;i<Janela.produtosListados.size();i++) {
                    if (Janela.produtosListados.get(i).getGenero().equals(genero) || Janela.produtosListados.get(i).getCategoria().equals(categoria)) {
                        listaProdutosListadosVazia.addElement(Janela.produtosListados.get(i).getNome());
                    }
                }
                jList1.setModel(listaProdutosListadosVazia);

                filtrado = true;*/
                
                
                
            }
        });
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(217, 50, 128));

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lista de produtos a venda");

        jPanel2.setBackground(new java.awt.Color(217, 50, 128));

        jRadioButton1.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Masculino");

        jRadioButton2.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Feminino");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jRadioButton3.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Calça");

        jRadioButton4.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Camiseta");

        jRadioButton5.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Tênis");

        jRadioButton6.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("Casaco");

        jRadioButton7.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton7.setText("Meia");

        jRadioButton8.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setText("Acessórios");

        jRadioButton9.setBackground(new java.awt.Color(217, 50, 128));
        buttonGroup1.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText("Roupa Intima");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton9)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("Barra de busca");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lista de produtos vendidos");

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jTextField2.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("Barra de busca");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(217, 50, 128));
        jLabel1.setText("Vender Items!");

        jButton1.setText("Ver sincronizacao");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(217, 50, 128));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Preço de compra: ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Preço de venda: ");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Lucro: ");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categoria: ");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("<categoria>");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("$$$");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("$$$");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("$$$");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Genero: ");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("<genero>");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(280, 280, 280)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(227, 227, 227)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(143, 143, 143)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        
        String selecionado = jList1.getSelectedValue();
        
        // acha onde esta o item selecionado
        for (int i=0;i<Janela.produtosListados.size();i++) {
            if (selecionado.equals(Janela.produtosListados.get(i).getNome())) {
                jLabel13.setText("Feminino");
                jLabel8.setText(Janela.produtosListados.get(i).getCategoria());
                jLabel9.setText(String.valueOf(Janela.produtosListados.get(i).getPrecoCompra()));
                jLabel10.setText(String.valueOf(Janela.produtosListados.get(i).getPrecoVenda()));
                jLabel11.setText(String.valueOf(Janela.produtosListados.get(i).getLucro()));
            }
        }
        
        jList2.clearSelection();
    }//GEN-LAST:event_jList1MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // botao de busca da lista de produtos listados
        
        jTextField1.setText("");
        
        // troca o model da lista por um model vazio
        jList1.setModel(listaProdutosListados);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // barra de busca - key release - LISTADOS
        jTextField1.setForeground(Color.BLACK);
        busca = jTextField1.getText();
        System.out.println("busca: "+busca);
        System.out.println("length" +busca.length());
        
        if (busca.equals("")) {
            jList1.setModel(listaProdutosListados);
            listaProdutosListadosVazia.removeAllElements();
            listaProdutosListadosTemp.removeAllElements();
            System.out.println("limpou");
            iniciou = false;
        }
        else {
            if (iniciou == true) {
                // executa pra somente um caracter
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    System.out.println("tamanho do listaProdutosTemp: "+listaProdutosListadosTemp.size());
                    for (int i=0;i<listaProdutosListadosTemp.size();i++) {
                        
                        if (String.valueOf(listaProdutosListadosTemp.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                            listaProdutosListadosVazia.addElement(listaProdutosListadosTemp.get(i));
                            listaProdutosListadosTemp.remove(i);
                            jList1.setModel(listaProdutosListadosVazia);
                            i--;
                        }
                    }
                }
                else {
                    
                    int tamanhoLista = listaProdutosListadosVazia.size();
                    for (int i = tamanhoLista - 1; i >= 0; i--) {
                        System.out.println("comparando: "+listaProdutosListadosVazia.get(i).charAt(busca.length()-1)+" -- "+busca.charAt(busca.length()-1));
                        if (!String.valueOf(listaProdutosListadosVazia.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                            
                            listaProdutosListadosTemp.addElement(listaProdutosListadosVazia.get(i));
                            System.out.println("deletado: "+listaProdutosListadosVazia.remove(i));
                            //listaProdutosVazia.remove(i);
                           
                            System.out.println("listaTemp");
                        }
                        else {
                            System.out.println("ELSEZADA");
                        }
                        
                        
                    }
                    
                    for (int i=0;i<listaProdutosListadosTemp.size();i++) {
                        String item = listaProdutosListadosTemp.get(i);
                        listaProdutosListadosVazia.removeElement(item);
                    }
                    jList1.setModel(listaProdutosListadosVazia);
                    
                }
                
            }
            else {
                for (int i=0;i<listaProdutosListados.size();i++) {
                    if (String.valueOf(listaProdutosListados.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                        listaProdutosListadosVazia.addElement(listaProdutosListados.get(i));
                        iniciou = true;
                        jList1.setModel(listaProdutosListadosVazia);
                        System.out.println("listaPadrao");
                    }
                }
            }
        }
        
        
        
        
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // barra de busca itens listados - focus LOST
        jTextField1.setForeground(new Color(153, 153, 153));
        
        jTextField1.setText("Barra de busca");
    }//GEN-LAST:event_jTextField1FocusLost

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // LISTA DE VENDIDOS
        String selecionado = jList2.getSelectedValue();
        
        // acha onde esta o item selecionado
        for (int i=0;i<Janela.produtosVendidos.size();i++) {
            if (selecionado.equals(Janela.produtosVendidos.get(i).getNome())) {
                jLabel13.setText(Janela.produtosVendidos.get(i).getGenero());
                jLabel8.setText(Janela.produtosVendidos.get(i).getCategoria());
                jLabel9.setText(String.valueOf(Janela.produtosVendidos.get(i).getPrecoCompra()));
                jLabel10.setText(String.valueOf(Janela.produtosVendidos.get(i).getPrecoVenda()));
                jLabel11.setText(String.valueOf(Janela.produtosVendidos.get(i).getLucro()));
            }
        }
        
        jList1.clearSelection();
        
    }//GEN-LAST:event_jList2MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // botao de busca da lista de produtos vendidos
        jTextField2.setText("");
        
        // troca o model da lista por um model vazio
        jList2.setModel(listaProdutosVendidos);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // barra de busca - key release - VENDIDOS
        jTextField2.setForeground(Color.BLACK);
        busca = jTextField2.getText();
        System.out.println("busca: "+busca);
        System.out.println("length" +busca.length());
        
        if (busca.equals("")) {
            jList2.setModel(listaProdutosVendidos);
            listaProdutosVendidosVazia.removeAllElements();
            listaProdutosVendidosTemp.removeAllElements();
            System.out.println("limpou");
            iniciou2 = false;
        }
        else {
            if (iniciou2 == true) {
                // executa pra somente um caracter
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    System.out.println("tamanho do listaProdutosTemp: "+listaProdutosListadosTemp.size());
                    for (int i=0;i<listaProdutosVendidosTemp.size();i++) {
                        
                        if (String.valueOf(listaProdutosVendidosTemp.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                            listaProdutosVendidosVazia.addElement(listaProdutosVendidosTemp.get(i));
                            listaProdutosVendidosTemp.remove(i);
                            jList2.setModel(listaProdutosVendidosVazia);
                            i--;
                        }
                    }
                }
                else {
                    
                    int tamanhoLista = listaProdutosVendidosVazia.size();
                    for (int i = tamanhoLista - 1; i >= 0; i--) {
                        System.out.println("comparando: "+listaProdutosVendidosVazia.get(i).charAt(busca.length()-1)+" -- "+busca.charAt(busca.length()-1));
                        if (!String.valueOf(listaProdutosVendidosVazia.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                            
                            listaProdutosVendidosTemp.addElement(listaProdutosVendidosVazia.get(i));
                            System.out.println("deletado: "+listaProdutosVendidosVazia.remove(i));
                            //listaProdutosVazia.remove(i);
                           
                            System.out.println("listaTemp");
                        }
                        else {
                            System.out.println("ELSEZADA");
                        }
                        
                        
                    }
                    
                    for (int i=0;i<listaProdutosVendidosTemp.size();i++) {
                        String item = listaProdutosVendidosTemp.get(i);
                        listaProdutosVendidosVazia.removeElement(item);
                    }
                    jList2.setModel(listaProdutosVendidosVazia);
                    
                }
                
            }
            else {
                for (int i=0;i<listaProdutosVendidos.size();i++) {
                    if (String.valueOf(listaProdutosVendidos.get(i).toLowerCase().charAt(busca.length()-1)).equals(String.valueOf(busca.charAt(busca.length()-1)).toLowerCase())) {
                        listaProdutosVendidosVazia.addElement(listaProdutosVendidos.get(i));
                        iniciou2 = true;
                        jList2.setModel(listaProdutosVendidosVazia);
                        System.out.println("listaPadrao");
                    }
                }
            }
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        jTextField2.setForeground(new Color(153, 153, 153));
        
        jTextField2.setText("Barra de busca");
    }//GEN-LAST:event_jTextField2FocusLost

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        System.out.println("\tArrayList produtosListados");
        for (int i=0;i<Janela.produtosListados.size();i++) {
            System.out.println(i+"o: "+Janela.produtosListados.get(i).getNome());
        }
        
        System.out.println("");
        System.out.println("\tDefaultListModel listaProdutosListados");
        for (int i=0;i<listaProdutosListados.size();i++) {
            System.out.println(i+"o: "+listaProdutosListados.get(i));
        }
        
        System.out.println("");
        System.out.println("\tArrayList produtosVendidos");
        for (int i=0;i<Janela.produtosVendidos.size();i++) {
            System.out.println(i+"o: "+Janela.produtosVendidos.get(i).getNome());
        }
        
        System.out.println("");
        System.out.println("\tDefaultListModel listaProdutosListados");
        for (int i=0;i<listaProdutosVendidos.size();i++) {
            System.out.println(i+"o: "+listaProdutosVendidos.get(i));
        }
        
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
