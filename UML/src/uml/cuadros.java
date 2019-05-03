package uml;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.*;

public class cuadros extends JPanel{
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    public void componentes(){
        
        frame.add(new cuadros());
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);   
        /*panel.setBounds(0, 0, 600, 600);
        panel.add(new cuadros());*/
        
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;	
        g2d.drawRect(50, 0, 30, 30);
    }
	
	
		
	
}
