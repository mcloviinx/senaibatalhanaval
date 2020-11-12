
package batalhanaval;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class jogadorPanel extends JPanel{
    int linhas = 10; //numero de linhas
    int colunas = 10; //numero de colunas
    Botao[][] botao = new Botao[linhas][colunas]; //criando o array em matrix que irá receber todos os botões do painel
    
    public jogadorPanel(){
        iniciarPanel(); //chamando metodo que configura o panel
        gerarNavios();
    }
    private void iniciarPanel(){
        setBackground(Color.gray);
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
        gbc.insets = new Insets(5, 5, 5, 5);
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
        gbc.insets = new Insets(0, 0, 0, 0);
        for (int x = 0; x < linhas; x++){ // laço para colocar todos os botões no painel
            for (int y = 0; y < colunas; y++){
                gbc.gridx = x + 1;
                gbc.gridy = y + 1;
                add(botao[x][y], gbc);
            }
        }
    }
    private void gerarNavios(){
        Random random = new Random();
        
        int ix = random.nextInt(linhas);
        int iy = random.nextInt(colunas);
        //botao[ix][iy].setBackground(Color.red);
        int orientOpc = 0; //random.nextInt(4);
        int shipSize = 4;
        
        switch (orientOpc){
            default:
                if (ix >= shipSize - 1){
                    boolean colide = false;
                    int[] indexs = new int[shipSize];
                    int count = 0;
                    for (int i = ix; i > ix - shipSize; i--){
                        if (botao[i][iy].navio) {
                            colide = true;
                            break;
                        } else {
                            indexs[count] = i;
                        }
                        count++;
                    }
                    if (!colide){
                        for (int i = 0; i < indexs.length; i++){
                            botao[indexs[i]][iy].isShip();
                            botao[indexs[i]][iy].setBackground(Color.green);
                            
                        }
                    }
                }
            break;
            case 1:
                
            break;
            case 2:
                
            break;
            case 3:
                
            break;
        }
    }
}
