
package batalhanaval;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

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
        jogador1 = new jogadorPanel(this);
        jogador2 = new jogadorPanel(this);
        jogador1.setPanelEnabled(vezjogador);
        jogador2.setPanelEnabled(!vezjogador);
        painel.add(jogador1, BorderLayout.WEST);
        painel.add(jogador2, BorderLayout.EAST);
        Infor infor = new Infor();
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
