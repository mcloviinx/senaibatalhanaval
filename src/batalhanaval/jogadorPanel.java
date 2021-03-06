
package batalhanaval;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class jogadorPanel extends JPanel{
    int linhas = 10; //numero de linhas
    int colunas = 10; //numero de colunas
    Frame frame;
    boolean enabled;
    Botao[][] botao = new Botao[linhas][colunas]; //criando o array em matrix que irá receber todos os botões do painel
    ArrayList<Botao> allShips = new ArrayList<>();
    JLabel label;
    public jogadorPanel(Frame frame, JLabel label){
        iniciarPanel(); //chamando metodo que configura o panel
        gerarNavios();
        this.frame = frame;
        this.label = label;
    }
    private void iniciarPanel(){
        setBackground(Color.gray);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        for (int x = 0; x < linhas; x++){
            for (int y = 0; y < colunas; y++){
                // criando todos os objetos botao no array;
                botao[x][y] = new Botao(this);
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
            JLabel text = new JLabel(String.valueOf(i));
            text.setForeground(new Color(255, 255, 255));
            add(text, gbc);
        }
        char a = 'A';
        for (int i = 1; i <= colunas; i++){ //laço para colocar a guia de letras
            gbc.gridx = 0;
            gbc.gridy = i;
            JLabel text = new JLabel(String.valueOf(a));
            text.setForeground(new Color(255, 255, 255));
            add(text, gbc);
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
        genTipoNavio(5, 3, new Color(0,0,139)); // porta-aviões
        genTipoNavio(4, 3, new Color(255,0,0)); 
        genTipoNavio(2, 4, new Color(255,140,0));
        genTipoNavio(1, 6, new Color(0,128,0));
    }
    private void genTipoNavio(int shipSize, int shipMax, Color cor){
        int shipCount = 0;
        Random random = new Random();
        while (shipCount < shipMax){
            int ix = random.nextInt(linhas);
            int iy = random.nextInt(colunas);            
            int orientOpc = random.nextInt(4);            
            switch (orientOpc){
                default:
                    if (ix >= shipSize - 1){
                        boolean colide = false;
                        for (int i = ix; i > ix - shipSize; i--){
                            if (botao[i][iy].navio) {
                                colide = true;
                                break; //break para o for não para o switch (possivel problema)!
                            }                        
                        }
                        if (!colide){
                            for (int i = ix; i > ix - shipSize; i--){
                                botao[i][iy].isShip();
                                botao[i][iy].setShipColor(cor);
                                allShips.add(botao[i][iy]);
                            }
                            shipCount++;
                        }
                    }
                break;
                case 1:
                    if (iy + shipSize <= linhas){
                        boolean colide = false;
                        for (int i = iy; i < iy + shipSize; i++){
                            if (botao[ix][i].navio) {
                                colide = true;
                                break; //break para o for não para o switch (possivel problema)!
                            }                        
                        }
                        if (!colide){
                            for (int i = iy; i < iy + shipSize; i++){
                                botao[ix][i].isShip();
                                botao[ix][i].setShipColor(cor);
                                allShips.add(botao[ix][i]);
                            }
                            shipCount++;
                        }
                    }
                break;
                case 2:
                    if (ix + shipSize <= colunas){
                        boolean colide = false;
                        for (int i = ix; i < ix + shipSize; i++){
                            if (botao[i][iy].navio) {
                                colide = true;
                                break; //break para o for não para o switch (possivel problema)!
                            }                        
                        }
                        if (!colide){
                            for (int i = ix; i < ix + shipSize; i++){
                                botao[i][iy].isShip();
                                botao[i][iy].setShipColor(cor);
                                allShips.add(botao[i][iy]);
                            }
                            shipCount++;
                        }
                    }
                break;
                case 3:
                    if (iy >= shipSize - 1){
                        boolean colide = false;
                        for (int i = iy; i > iy - shipSize; i--){
                            if (botao[ix][i].navio) {
                                colide = true;
                                break; //break para o for não para o switch (possivel problema)!
                            }                        
                        }
                        if (!colide){
                            for (int i = iy; i > iy - shipSize; i--){
                                botao[ix][i].isShip();
                                botao[ix][i].setShipColor(cor);
                                allShips.add(botao[ix][i]);
                            }
                            shipCount++;
                        }
                    }
                break;
            }
        }
    }
    public void desaBotoes(boolean opc){
        for (int x = 0; x < linhas; x++){ 
            for (int y = 0; y < colunas; y++){
                botao[x][y].setEnabled(opc);
            }
        }
    }
    public String porcDestruicao(){
        int clickedCount = 0;
        int all = allShips.size();
        for (int i = 0; i < all; i++){
            if (allShips.get(i).clicado) clickedCount++;
        }
        Float num = Float.valueOf(clickedCount) / Float.valueOf(all) * 100;
        DecimalFormat df = new DecimalFormat("###.#");
        return df.format(num) + "%";
    }
    
    public void updateOpc(){
        frame.updateVezJogador();
    }
    public boolean getOpc(){
        return frame.vezjogador;
    }
    public void setPanelEnabled(boolean b){
        enabled = b;
        if (enabled) {
            setBackground(new Color(55, 111, 140));
        } else {
            setBackground(Color.gray);
        }
    }
    public void updateDest(){
        label.setText(porcDestruicao());
    }
}
