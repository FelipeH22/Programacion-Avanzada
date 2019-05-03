package figuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class cuadros extends JPanel{
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;	
        g2d.drawRect(100, 100, 50, 50);
    }
	
	
		
	
}
