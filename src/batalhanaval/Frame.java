
package batalhanaval;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame() {
        iniciarJanela();
    }
    private void iniciarJanela(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container painel = getContentPane();
        
        painel.setLayout(new BorderLayout());
        jogadorPanel jogador1 = new jogadorPanel();
        jogadorPanel jogador2 = new jogadorPanel();
        painel.add(jogador1, BorderLayout.WEST);
        painel.add(jogador2, BorderLayout.EAST);
        
        pack();
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }
}
