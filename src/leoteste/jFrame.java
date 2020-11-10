
package leoteste;

import batalhanaval.*;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class jFrame extends JFrame{
    
    public jFrame(){
        iniciarFrame();
    }
    private void iniciarFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container painel = getContentPane();
        painel.setLayout(new BorderLayout()); //definindo layout de borda
        
        // criando 2 paineis do mesmo objeto
        jogadorPanel jogador1 = new jogadorPanel(); //botoes do jogador1
        jogadorPanel jogador2 = new jogadorPanel(); //botoes do jogador2
        
        painel.add(jogador1, BorderLayout.EAST); //adicionando o painel do jogador1 no lest(direita) 
        painel.add(jogador2, BorderLayout.WEST); //adicionando o painel do jogador1 no oeste(esquerda)
        
        pack(); //esse metodo organiza automaticamente os espaços de cada elemento do jframe;
        setLocationRelativeTo(null); //exibe a janela no meio da tela
        setVisible(true); //exibe o jframe para o usuario;
    }
}