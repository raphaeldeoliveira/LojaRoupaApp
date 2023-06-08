package angelmodas.View;

import static angelmodas.AngelModas.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import angelmodas.Model.RoundBorder;

public class Painel1 extends javax.swing.JPanel {
    
    public static String senha = "";
    public static String asterisco = "";
    public static String usuario;
    public static int tamanhoSenha = 0;
    public static boolean mostrarSenha = false;
    
    // labels e paineis globais
    JLabel labelBotaoLogin = new JLabel("Login");
    JPanel panelBotaoLogin = new JPanel();
    JLabel iconeUser = new JLabel("");
    JPanel panelLoginUser = new JPanel();
    JLabel iconeSenha = new JLabel("");
    JPanel panelLoginSenha = new JPanel();
    JLabel labelCriarConta = new JLabel("Criar conta");
    JLabel jLabelImagemFundo = new JLabel("");
    JLabel labelBemVindo = new JLabel("Bem Vindo!");
    JLabel labelTexto1 = new JLabel("Faça login para acessar a");
    JLabel labelTexto2 = new JLabel("área de manegamento de recursos!");
    
    static JPasswordField passwordField = new JPasswordField();
    static JTextField jTextField1 = new JTextField("Usuario ou Email");
    static JTextField jTextField2 = new JTextField("Senha");
    
    public Painel1() {
        initComponents();
        colocarImagens();
        adicionarLabelsAImagem();
        deixarVerticesArredondados();
        config();
    }
    
    public void deixarTextFieldsPadrao() {
        jTextField2.setVisible(true);
        passwordField.setVisible(false);
        
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Usuario ou Email");
    }
    
    public void deixarVerticesArredondados() {
        
        JPanel botaoLogin = new JPanel();

        Color backgroundColor = new Color(217, 50, 128); // Cor de fundo do painel
        Color borderColor = Color.WHITE; // Cor da borda
        int borderRadius = 75; // Raio do arredondamento
        int borderThickness = 30; // Espessura da borda

        panelBotaoLogin.setBackground(backgroundColor);
        panelBotaoLogin.setBorder(new RoundBorder(borderColor, borderRadius, borderThickness));
        panelBotaoLogin.setBounds(469, 257, 283, 73);

        // Cria uma instância da classe RoundBorder
        RoundBorder roundBorder = new RoundBorder(borderColor, borderRadius, borderThickness);

        labelBotaoLogin.setBounds(590, 267, 100, 50);
        labelBotaoLogin.setForeground(Color.WHITE); // Define a cor do texto como vermelho
        labelBotaoLogin.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));

        jPanel1.add(labelBotaoLogin);
        jPanel1.add(panelBotaoLogin);

        iconeUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/angelmodas/imagens/icon-login.png")));
        iconeUser.setBounds(494, 116, 70, 90);
        jPanel1.add(iconeUser);

        panelLoginUser.setBorder(new RoundBorder(Color.BLACK, 45, 1));
        panelLoginUser.setBackground(new Color(255, 255, 255));
        panelLoginUser.setBounds(479, 142, 260, 40);
        jPanel1.add(panelLoginUser);

        iconeSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/angelmodas/imagens/icon-cadeado.png")));
        iconeSenha.setBounds(492, 166, 70, 90);
        jPanel1.add(iconeSenha);

        panelLoginSenha.setBorder(new RoundBorder(Color.BLACK, 45, 1));
        panelLoginSenha.setBackground(new Color(255, 255, 255));
        panelLoginSenha.setBounds(479, 192, 260, 40);
        jPanel1.add(panelLoginSenha);

        labelCriarConta.setForeground(new Color(217, 50, 128));
        labelCriarConta.setBounds(579, 292, 120, 90);
        labelCriarConta.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 14));
        jPanel1.add(labelCriarConta);

        jTextField1.setBorder(null);
            
    }
    
    public void adicionarLabelsAImagem() {
        jLabelImagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/angelmodas/imagens/background_painel2.jpg")));
        jLabelImagemFundo.setBounds(0, 0, 452, 375);
        jPanel1.add(jLabelImagemFundo);
        
        labelBemVindo.setBounds(110, 100, 300, 100);
        labelBemVindo.setForeground(Color.white);
        labelBemVindo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 38));
        
        jLabelImagemFundo.add(labelBemVindo);
        
        // adiciona o texto auxiliar1
        labelTexto1.setBounds(110, 140, 300, 100);
        labelTexto1.setForeground(Color.white);
        labelTexto1.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
        
        jLabelImagemFundo.add(labelTexto1);
        
        // adiciona o texto auxiliar2
        labelTexto2.setBounds(70, 170, 300, 100);
        labelTexto2.setForeground(Color.white);
        labelTexto2.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
        
        jLabelImagemFundo.add(labelTexto2);
        
        // teste
        jTextField2.setBounds(525, 199, 195, 30);
        jTextField2.setBorder(null);
        jTextField2.setForeground(new Color(204,204,204));
        jTextField2.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
        jPanel1.add(jTextField2);
        
        // TextField da senha
        passwordField.setVisible(false);
        passwordField.setBounds(525, 197, 195, 30);
        passwordField.setEchoChar('*');
        passwordField.setBorder(null);
        jPanel1.add(passwordField);
        
        // TextField do usuario
        jTextField1.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Usuario ou Email");
        jTextField1.setBounds(525, 150, 195, 30);
        jPanel1.add(jTextField1);
        
    }
    
    public void colocarImagens() {
        ImageIcon imageIcon = new ImageIcon("new javax.swing.ImageIcon(getClass().getResource(\"/angelmodas/imagens/essa.png\")");
        
        // Redimensionar a imagem para o tamanho da JLabel
        Image image = imageIcon.getImage().getScaledInstance(214, 214, Image.SCALE_SMOOTH);
        
        // Definir a imagem redimensionada na JLabel
        
    }
    
    public void config() {
        
        // Quando o painel LOGIN é clicado
        panelBotaoLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                // verifica se os dados de login são validos
                
                // pega os inputs
                String user = jTextField1.getText();
                String senha = new String(passwordField.getPassword());
                
                jTextField1.setText("");
                passwordField.setText(String.valueOf(""));
                
                controller.logar(user, senha);
                
                /// valida os inputs
                /*if (user.equals("admin") && senha.equals("admin")) {
                    JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                    janela.getContentPane().remove(Janela.p1);
                    janela.add(Janela.p7, BorderLayout.CENTER);
                    janela.pack();
                }
                else {
                    if (validarDados(user, senha) == false) {
                        JOptionPane.showMessageDialog(null, "Usuário inválido!", "Angel Modas", JOptionPane.ERROR_MESSAGE);
                    }
                    else {

                        // Transição
                        Janela.t1 = new Transicao();
                        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                        janela.getContentPane().remove(Janela.p1);
                        janela.add(Janela.t1, BorderLayout.CENTER);
                        janela.pack();

                        Thread thread = new Thread(Janela.t1);  // Passar a instância de Transicao, não Janela.t1
                        thread.start();

                    }
                }*/
            }
        });
        
        jTextField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTextField2.setVisible(false);
                passwordField.setVisible(true);
                passwordField.requestFocusInWindow();
            }
        });
        
        labelCriarConta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.criarConta();
                /*Janela.p5 = new Painel5();
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                janela.getContentPane().remove(Janela.p1);
                janela.add(Janela.p5, BorderLayout.CENTER);
                janela.pack();*/
            }
        });
        
        jTextField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (jTextField1.getText().contains("Usuario ou Email")) {
                    jTextField1.setText("");
                    jTextField1.setForeground(Color.BLACK);
                }
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 12)); // NOI18N
        jCheckBox1.setText("Mostrar Senha");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 34)); // NOI18N
        jLabel3.setText("Login");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 459, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(563, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // botao mostrar senha

        if (mostrarSenha == false) {
            
            passwordField.setEchoChar((char) 0);

        }
        else {
            passwordField.setEchoChar('*');
        }

        mostrarSenha = !mostrarSenha;

    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
