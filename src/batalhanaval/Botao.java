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
    private final ImageIcon miraIcon = new ImageIcon(Class.class.getResource("/png/mira25.png"));
    private final ImageIcon erroIcon = new ImageIcon(Class.class.getResource("/png/erro25.png"));
    
    public Botao(){
        initButton();        
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
                clicado = true;
                if (navio){
                    
                } else {
                    //setBackground();
                    setIcon(erroIcon);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                if (!clicado){
                    setIcon(miraIcon);
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
}