package mensagensgui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FrameMensagens extends JFrame{
    
    private JTextField txtUtilizador;
    private JTextField txtPass;
    
    public FrameMensagens(String titulo) {
        super(titulo);
        setSize(300,200);   // Definição das dimensões iniciais da Janela/Frame
        setMinimumSize(new Dimension(300,200));     // Definição das dimensões mínimas da Janela/Frame
        setLocation(200,200);   // Definição do posicionamento inicial da Janela/Frame
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar;   // Definição de uma barra de menus
        JMenu menu;     // Definição de um menu
        JMenuItem menuItem;     // Definição de um item de menu
        
        Container c = getContentPane();

        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel(new GridLayout(2, 1));
        p1.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel
        
        JPanel p11 = new JPanel();
        label = new JLabel("Nome:        ");
        p11.add(label);
        txtUtilizador = new JTextField(15);
        p11.add(txtUtilizador);
        p1.add(p11);
        
        JPanel p12 = new JPanel();
        p12.add( new JLabel("Password: ") );
        txtPass = new JPasswordField(15);
        p12.add(txtPass);
        p1.add(p12);
        c.add(p1, BorderLayout.NORTH);
        

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        botao = new JButton("Login");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p2.add(botao);
        c.add(p2, BorderLayout.SOUTH);
        
        pack();     //As dimensões da janela são ajustadas automaticamente ao mínimo necessário que permite mostrar todos os seus componentes
        setMinimumSize(new Dimension(getWidth(), getHeight()));     // Definir como dimensões mínimas da Janela/Frame a actual largura e altura
              
        menuBar = new JMenuBar();   // Criação de uma barra de menus
        
        menu = new JMenu("Sistema de Mensagens");    // Criação de um menu
        menu.setMnemonic(KeyEvent.VK_S);    // Definição de uma tecla de atalho para o menu
        menuBar.add(menu);      // Adicionar o menu à barra de menus
        
//        menuItem = new JMenuItem("Login",KeyEvent.VK_L);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
//        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));  //Definição de uma outra tecla de tecla para o item de menu (CTRL + P)
//        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
//            public void actionPerformed(ActionEvent e) {
//               DialogLogin ecraLogin = new DialogLogin(FrameMensagens.this,"Login"); 
//               ecraLogin.showDialog();
//            }
//        });
//        menu.add(menuItem);     // Adicionar o item de menu ao menu
        
        menuItem = new JMenuItem("Criar Conta",KeyEvent.VK_C);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));  //Definição de uma outra tecla de tecla para o item de menu (CTRL + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
                DialogCriaConta ecraCriarConta = new DialogCriaConta(FrameMensagens.this, "Criação de uma nova Conta");
                ecraCriarConta.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo
            }
        });
        menu.add(menuItem);     // Adicionar o item de menu ao menu
        
        menuItem = new JMenuItem("Sair",KeyEvent.VK_S);
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] opSimNao = {"Sim", "Não"}; // Criação de um vector com os botões de opção para a caixa de diálogo
                if (JOptionPane.showOptionDialog( FrameMensagens.this, "Deseja fechar a aplicação?", "Sistema de Mensagens", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1] )  ==  0 ) // Criar uma caixa de diálogo do tipo interrogativa com os botões de opção definidos pelo utilizador, em que o segundo desses botões se encontra pré-seleccionado (corresponde ao indíce um do vector) e verificar se o primeiro desses botões foi o seleccionado (corresponde ao índice zero do vector)
                    dispose();    // Fecha a janela/Frame
            }
        });
        menu.add(menuItem);
        
        setJMenuBar(menuBar); // Acrescentar a barra de menus à Janela/Frame
        
    }
    
    class TrataEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {            
//          if (e.getActionCommand().equals("Login")) {   // Caso o evento tenha ocorrido sobre o botão de comando Criar Conta
//          TODO
//              Se o Login for valido login = login de resgisto entao
//                  FrameEntrada ecraEntrada = new FrameEntrada(FrameMensagens.this, "Caixa de Entrada");
//                  FrameMensagens.this.setVisible(false);
//                  ecraEntrada.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo
//              Senao
//                JOptionPane.showMessageDialog(frame,"Login Incorrecto.\n Introduza Novamente os Dados","Login Incorrecto",JOptionPane.WARNING_MESSAGE);
//
//          }
            FrameEntrada ecraEntrada = new FrameEntrada(FrameMensagens.this, "Caixa de Entrada");
            FrameMensagens.this.setVisible(false);
            ecraEntrada.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo                          
    }

}
    
}
    