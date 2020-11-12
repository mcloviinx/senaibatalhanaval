package batalhanaval;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botao extends JButton{
    boolean navio = false;
    boolean clicado = false;
    Color shipColor = null;
    jogadorPanel jogador;
    private final ImageIcon miraIcon = new ImageIcon(Class.class.getResource("/png/mira25.png"));
    private final ImageIcon erroIcon = new ImageIcon(Class.class.getResource("/png/erro25.png"));
    private final ImageIcon stopIcon = new ImageIcon(Class.class.getResource("/png/stop25.png"));
    
    public Botao(jogadorPanel jogador){
        initButton(); 
        this.jogador = jogador;
    }   
    private void initButton() {
        this.setPreferredSize(new Dimension(45, 45));
        this.setFont(new Font("Calibri", 1, 25));
        this.setFocusPainted(false);
        this.setBackground(new Color(0, 105, 148));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter(){
            @Override            
            public void mousePressed(MouseEvent e){
                if (jogador.enabled){
                    clicado = true;
                    if (navio){
                        setBackground(shipColor);
                        setIcon(null);
                    } else {
                        jogador.updateOpc();
                        setIcon(erroIcon);
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                if (!clicado){
                    if (jogador.enabled){
                        setIcon(miraIcon);
                    } else {
                        setIcon(stopIcon);
                    }
                }
            }
            @Override
            public void mouseExited(MouseEvent e){
                if (!clicado){
                    setIcon(null);
                }
            }
        });
    }
    public void isShip(){
        navio = true;
    }
    public void setShipColor(Color shipColor){
        this.shipColor = shipColor;
    }
}