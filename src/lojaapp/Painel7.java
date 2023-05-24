package lojaapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Painel7 extends javax.swing.JPanel {

    DefaultListModel<String> listaUsuarios = new DefaultListModel<>();
    
    JLabel labelBotaoDeletar = new JLabel("Deletar");
    JPanel panelBotaoDeletar = new JPanel();
    JLabel labelBotaoAlterar = new JLabel("Alterar");
    JPanel panelBotaoAlterar = new JPanel();
    JLabel labelBotaoVoltar = new JLabel("Voltar");
    JPanel panelBotaoVoltar = new JPanel();
    
    int lastIndex = -1;
    
    public Painel7() {
        initComponents();
        adicionarLabels();
        config();
    }
    
    public void carregarUsuariosSerializados(ArrayList<Usuario> usuarios) {
        
        if (usuarios.isEmpty() == false) {
            for (int i=0;i<usuarios.size();i++) {
                listaUsuarios.addElement(usuarios.get(i).getUsuario());
            }

            jList2.setModel(listaUsuarios);

            // deixa um usuario clicado
            jList2.setSelectedIndex(0);
            jRadioButton1.setText(usuarios.get(0).getUsuario());
            jRadioButton2.setText(usuarios.get(0).getEmail());
            jRadioButton3.setText(usuarios.get(0).getSenha());
        }
    }
    
    public void carregarUsuariosAdicionados(String user) {
        listaUsuarios.addElement(user);
        jList2.setModel(listaUsuarios);
    }
    
    public void carregarUsuarioAlterado(int index) {
        listaUsuarios.removeAllElements();
        for (int i=0;i<Janela.usuarios.size();i++) {
            listaUsuarios.addElement(Janela.usuarios.get(i).getUsuario());
        }
        jList2.setModel(listaUsuarios);
        
        System.out.println("index^: "+index);
        if (index >= 0) {
            System.out.println("yyyyyyyyyyyy");
            jRadioButton1.setText(Janela.usuarios.get(index).getUsuario());
            jRadioButton2.setText(Janela.usuarios.get(index).getEmail());
            jRadioButton3.setText(Janela.usuarios.get(index).getSenha());
        } else {
            // Lógica para tratar quando nenhum elemento está selecionado
        }
    }
    
    public void adicionarLabels() {
        // Coberturas
        JPanel vertical1 = new JPanel();
        vertical1.setBounds(22, 255, 13, 119);
        vertical1.setBackground(Color.WHITE);
        jPanel1.add(vertical1);
        
        JPanel vertical2 = new JPanel();
        vertical2.setBounds(225, 255, 13, 119);
        vertical2.setBackground(Color.WHITE);
        jPanel1.add(vertical2);
        
        JPanel horizontal1 = new JPanel();
        horizontal1.setBounds(33, 262, 200, 7);
        horizontal1.setBackground(Color.WHITE);
        jPanel1.add(horizontal1);
        
        JPanel horizontal2 = new JPanel();
        horizontal2.setBounds(34, 311, 200, 13);
        horizontal2.setBackground(Color.WHITE);
        jPanel1.add(horizontal2);
        
        JPanel horizontal3 = new JPanel();
        horizontal3.setBounds(33, 366, 200, 7);
        horizontal3.setBackground(Color.WHITE);
        jPanel1.add(horizontal3);
        
        // Botões
        
        labelBotaoDeletar.setForeground(Color.WHITE);
        labelBotaoDeletar.setBounds(100, 273, 200, 40);
        labelBotaoDeletar.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        jPanel1.add(labelBotaoDeletar);
        
        panelBotaoDeletar.setBackground(new Color(217, 50, 128));
        panelBotaoDeletar.setBorder(new RoundBorder(Color.WHITE, 50, 10));
        panelBotaoDeletar.setBounds(30, 265, 200, 50);
        jPanel1.add(panelBotaoDeletar);
        
        labelBotaoAlterar.setForeground(Color.WHITE);
        labelBotaoAlterar.setBounds(100, 328, 200, 40);
        labelBotaoAlterar.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        jPanel1.add(labelBotaoAlterar);
        
        panelBotaoAlterar.setBackground(new Color(217, 50, 128));
        panelBotaoAlterar.setBorder(new RoundBorder(Color.WHITE, 50, 10));
        panelBotaoAlterar.setBounds(30, 320, 200, 50);
        jPanel1.add(panelBotaoAlterar);
        
        // Cobertura 2
        
        JPanel vertical3 = new JPanel();
        vertical3.setBounds(193, 375, 13, 40);
        vertical3.setBackground(new Color(217, 50, 128));
        jPanel2.add(vertical3);
        
        JPanel vertical4 = new JPanel();
        vertical4.setBounds(314, 375, 13, 40);
        vertical4.setBackground(new Color(217, 50, 128));
        jPanel2.add(vertical4);
        
        // Botões 2
        
        labelBotaoVoltar.setForeground(new Color(217,50,128));
        labelBotaoVoltar.setBounds(239, 380, 120, 30);
        labelBotaoVoltar.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 16));
        jPanel2.add(labelBotaoVoltar);
        
        panelBotaoVoltar.setBackground(Color.WHITE);
        panelBotaoVoltar.setBorder(new RoundBorder(new Color(217,50,128), 50, 11));
        panelBotaoVoltar.setBounds(200, 375, 120, 36);
        jPanel2.add(panelBotaoVoltar);
        
    }
    
    public void config() {
        
        panelBotaoDeletar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                int resposta = JOptionPane.showOptionDialog(null,"Tem certeza que deseja deletar usuario?","Confirmação",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,new Object[] {"Sim", "Não", "Cancelar"},"Sim");
                if (resposta == JOptionPane.YES_OPTION) {
                    
                    int index = jList2.getSelectedIndex();
                    Janela.usuarios.remove(index);
                    Janela.serializar();
                    listaUsuarios.remove(index);
                    jList2.setModel(listaUsuarios);
                    System.out.println("fio");
                    
                }
            }
        });
        
        panelBotaoAlterar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index;
                if (jList2.getSelectedIndex() < 0) {
                    if (lastIndex > 0) {
                        index = lastIndex;
                    }
                }
                else {
                    index = jList2.getSelectedIndex();
                    lastIndex = index;
                    System.out.println("indexaaaaa: "+index);

                    if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected() && !jRadioButton3.isSelected()) {
                        System.out.println("Selecione algum atributo do usuario para alterar!");
                    }
                    else {
                        System.out.println("7979879");
                        if (jRadioButton1.isSelected()) {
                            // pega o input do dado alterado
                            String novoUsuario = JOptionPane.showInputDialog("Digite o novo usuário:");
                            if (novoUsuario != null) {
                                Janela.usuarios.get(index).setUsuario(novoUsuario);
                            } else {

                            }
                        }
                        else {
                            if (jRadioButton2.isSelected()) {
                                // pega o input do dado alterado
                                String novoEmail = JOptionPane.showInputDialog("Digite o novo email:");
                                if (novoEmail != null) {
                                    Janela.usuarios.get(index).setEmail(novoEmail);
                                } else {

                                }
                            }
                            else {
                                if (jRadioButton3.isSelected()) {
                                    // pega o input do dado alterado
                                    String novaSenha = JOptionPane.showInputDialog("Digite a nova senha:");
                                    if (novaSenha != null) {
                                        Janela.usuarios.get(index).setSenha(novaSenha);
                                    } else {

                                    }
                                }
                            }
                        }

                        Janela.serializar();
                        carregarUsuarioAlterado(index);
                        jList2.setSelectedIndex(lastIndex);

                    }
                }
                
                
            }
        });
        
        panelBotaoVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(jPanel1);
                janela.getContentPane().remove(Janela.p7);
                janela.add(Janela.p1, BorderLayout.CENTER);
                janela.pack();
                
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(217, 50, 128));
        jLabel1.setText("Controle de");

        jPanel2.setBackground(new java.awt.Color(217, 50, 128));

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("<usuario>");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("<email>");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("<senha>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addGap(37, 37, 37))
        );

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(217, 50, 128));
        jLabel2.setText("Usuários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // Jlist clicado
        
        int index = jList2.getSelectedIndex();
        
        if (index >= 0) {
            // atualiza os radio buttons
            jRadioButton1.setText(Janela.usuarios.get(index).getUsuario());
            jRadioButton2.setText(Janela.usuarios.get(index).getEmail());
            jRadioButton3.setText(Janela.usuarios.get(index).getSenha());
        }
    }//GEN-LAST:event_jList2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
