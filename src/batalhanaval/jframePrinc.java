package batalhanaval;

import javax.swing.JFrame;

public class jframePrinc extends JFrame {
    
    public jframePrinc(){
        initFrame();
    }
    private void initFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
