package lojaapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Painel1 extends javax.swing.JPanel {
    
    public static String senha = "";
    public static String usuario;
    public static int tamanhoSenha = 0;
    public static boolean mostrarSenha = false;

    public Painel1() {
        initComponents();
        colocarImagens();
    }
    
    public void colocarImagens() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\alunolages\\Documents\\LojaApp\\LojaRoupaApp\\src\\lojaapp\\imagens\\essa.png");
        
        // Redimensionar a imagem para o tamanho da JLabel
        Image image = imageIcon.getImage().getScaledInstance(214, 214, Image.SCALE_SMOOTH);
        
        // Definir a imagem redimensionada na JLabel
        jLabel1.setIcon(new ImageIcon(image));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        jPanel1.setBackground(new java.awt.Color(51, 0, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 214, 214));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 327, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 365, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 327, 186, -1));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 365, 181, -1));

        jButton1.setText("Logar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 435, -1, -1));

        jButton3.setText("-");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 49, -1, -1));

        jToggleButton1.setText("[]");
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 49, -1, -1));

        jButton2.setText("X");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 50, 43, 43));

        jCheckBox1.setText("Mostrar Senha");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 403, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        // valida os dados 
        // tira os asteriscos da senha
        senha = senha.replaceAll("\\*", "");
        usuario = jTextField1.getText();
        
        if (usuario.equals("admin") || senha.equals("admin")) {
            Janela.p5 = new Painel5();
            JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().remove(Janela.p1);
            janela.add(Janela.p5, BorderLayout.CENTER);
            janela.pack();
        }
        else {
            for (int i=0;i<Janela.usuarios.size();i++) {
                if (usuario.equals(Janela.usuarios.get(i).getUsuario()) || senha.equals(Janela.usuarios.get(i).getSenha())) {
                    // passa para o proximo painel
                    Janela.p2 = new Painel2();
                    JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
                    janela.getContentPane().remove(Janela.p1);
                    janela.add(Janela.p2, BorderLayout.CENTER);
                    janela.pack();
                }
                else {
                    
                }
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // botao X 
        
        jButton2.setBackground(Color.red);
        jButton2.setForeground(Color.white);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // botao X
        
        jButton2.setBackground(UIManager.getColor("Button.background"));
        jButton2.setForeground(UIManager.getColor("Button.foreground"));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // botao X
        
        // pega o tempo de fim de sessão
        Janela.pegarTempoFimSessao();
        
        // serializa os dados para não ser perdido
        
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        
        String asterisco = "";
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            senha = senha.replaceAll("\\*", "");
            senha = senha.substring(0, senha.length()-1);
            asterisco = asterisco.substring(0, asterisco.length() - 1);
        }
        else {
            senha = senha.concat(jTextField2.getText());
            tamanhoSenha++;
            for (int i=0;i<tamanhoSenha;i++) {
                asterisco = asterisco.concat("*");
            }
            jTextField2.setText(asterisco);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        
        if (mostrarSenha == false) {
            // tira os asteriscos da senha
            senha = senha.replaceAll("\\*", "");
            jTextField2.setText(senha);
        }
        else {
            String asterisco = "";
            senha = senha.replaceAll("\\*", "");
            int tam = senha.length();
            for (int i=0;i<tam;i++) {
                asterisco = asterisco.concat("*");
            }
            jTextField2.setText(asterisco);
        }
        
        mostrarSenha = !mostrarSenha;
        
    }//GEN-LAST:event_jCheckBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
