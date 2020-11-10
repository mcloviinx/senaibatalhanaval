
package leoteste;

import batalhanaval.Botao;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class jFrame extends JFrame{
    int numColunas = 5;
    int numLinhas = 5;
    Botao[][] botao = new Botao[numLinhas][numColunas];
    
    public jFrame(){
        iniciarBotoes();
        iniciarFrame();
    }
    private void iniciarFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container painel = getContentPane();
        painel.setLayout(new GridLayout(numLinhas, numColunas));
        for (int y = 0; y < numColunas; y++){
            for (int x = 0; x < numLinhas; x++){
                painel.add(botao[x][y]);
            }
        }
        pack();
        setVisible(true);
    }
    private void iniciarBotoes(){
        for (int y = 0; y < numColunas; y++){
            for (int x = 0; x < numLinhas; x++){
                botao[x][y] = new Botao();
            }
        }
    }
}