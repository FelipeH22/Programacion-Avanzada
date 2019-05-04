package figuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.*;

public class cuadros extends JPanel{
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
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;	
        g2d.drawRect(100, 100, 50, 50);
    }
	
	
		
	
}
