
package batalhanaval;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class jogadorPanel extends JPanel{
    int linhas = 5; //numero de linhas
    int colunas = 5; //numero de colunas
    Botao[][] botao = new Botao[linhas][colunas]; //criando o array em matrix que irá receber todos os botões do painel
    public jogadorPanel(){
        iniciarPanel(); //chamando metodo que configura o panel
    }
    private void iniciarPanel(){
        setBackground(Color.GRAY);
        setLayout(new GridBagLayout());
        
        for (int x = 0; x < linhas; x++){
            for (int y = 0; y < colunas; y++){
                // criando todos os objetos botao no array;
                botao[x][y] = new Botao();
            }
        
        }
        GridBagConstraints gbc = new GridBagConstraints(); /*
        para trabalhar com conjunto de grades (GridBagLayout), 
        preciso desse objeto para definir qual será a posição 
        de cada botão no painel
        */
        for (int i = 1; i <= linhas; i++){ //laço para colocar a guia de numeros
            gbc.gridx = i;
            gbc.gridy = 0;
            add(new JLabel(String.valueOf(i)), gbc);
        }
        char a = 'A';
        for (int i = 1; i <= colunas; i++){ //laço para colocar a guia de letras
            gbc.gridx = 0;
            gbc.gridy = i;
            add(new JLabel(String.valueOf(a)), gbc);
            a++;
        }
        for (int x = 0; x < linhas; x++){ // laço para colocar todos os botões no painel
            for (int y = 0; y < colunas; y++){
                gbc.gridx = x + 1;
                gbc.gridy = y + 1;
                add(botao[x][y], gbc);
            }
        }
    }
}
