package batalhanaval;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Botao extends JButton{
    public Botao(){
        
        initButton();        
    }   
    
    private void initButton() {
        this.setPreferredSize(new Dimension(25, 25));
        this.setFont(new Font("Calibri", 1, 25));
        this.setFocusPainted(false);        
        this.setBackground(Color.black);        
        this.addMouseListener(new MouseAdapter(){            
            @Override            
            public void mousePressed(MouseEvent e){
                
            }            
        });
    }
}