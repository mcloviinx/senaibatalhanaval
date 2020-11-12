
package batalhanaval;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
    boolean vezjogador = true;
    jogadorPanel jogador1, jogador2;
    public Frame() {
        iniciarJanela();
    }
    private void iniciarJanela(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container painel = getContentPane();
        painel.setLayout(new BorderLayout());
        Infor infor = new Infor();
        jogador1 = new jogadorPanel(this, infor.getLabel2());
        jogador2 = new jogadorPanel(this, infor.getLabel1());
        jogador1.setPanelEnabled(vezjogador);
        jogador2.setPanelEnabled(!vezjogador);
        JPanel top = new JPanel();
        top.setBackground(Color.gray);
        JButton teste = new JButton();
        teste.setBorder(null);
        teste.setBackground(null);
        teste.setContentAreaFilled(false);
        ImageIcon logo = new ImageIcon(Class.class.getResource("/png/logo2.png"));
        teste.setIcon(logo);
        top.add(teste);
        painel.add(top, BorderLayout.NORTH);
        painel.add(jogador1, BorderLayout.WEST);
        painel.add(jogador2, BorderLayout.EAST);
        
        painel.add(infor, BorderLayout.CENTER);
        pack();
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void updateVezJogador(){
        vezjogador = !vezjogador;
        jogador1.setPanelEnabled(vezjogador);
        jogador2.setPanelEnabled(!vezjogador);
    }
}
