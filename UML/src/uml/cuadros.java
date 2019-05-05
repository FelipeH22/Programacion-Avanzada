package uml;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;

public class cuadros extends JPanel{
    public int num_cuadros;
    int i;
    int j;
    public ArrayList <String> clases = new ArrayList<>();
    public ArrayList <String> atributos = new ArrayList<>();
    String clase_actual;

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
        this.setBounds(0,0,600,600);
        frame.add(new cuadros());
        
    }
    
    public void oyentes(controlador_back cb){
        back.addActionListener(cb);
    }
    @Override
    public void paint(Graphics g) {
        int x=10;
        int y=70;
        Graphics2D g2d = (Graphics2D) g;	
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            g2d.drawRect(x, y, 100, 20);
            g2d.drawString(controlador_fin.clase.get(i), x+5,y+12);
            g2d.drawString(controlador_fin.atributos.get(i),x+5,y+35);
            g2d.drawRect(x, y+20, 100, 80);
            x=x+110;
        }
            
    }
    
	
}
