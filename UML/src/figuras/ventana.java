package figuras;

import javax.swing.*;
import javax.swing.JFrame;

public class ventana extends JFrame{
    JFrame frame = new JFrame();
    JButton back = new JButton();
    
    public void componentes(){       
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);   
        back.setText("Volver");
        back.setBounds(10,10,100,20);
        back.setFocusable(false);
        frame.add(back);
        frame.add(new cuadros());        
    }
    
    public void oyentes(controlador_back cb){
        back.addActionListener(cb);
    }
}
