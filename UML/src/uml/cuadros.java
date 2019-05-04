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
    int y=70;
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
        Graphics2D g2d = (Graphics2D) g;	
        //for(i=1;i<=3;i++)
        //{
            g2d.drawRect(10, y, 100, 20);
            g2d.drawString(controlador_fin.clase.get(0), 15,y+12);
            g2d.drawString(controlador_fin.atributos.get(0),15,y+35);
            g2d.drawRect(10, y+20, 100, 80);
            //y=y+90;
        //}
            
    }
    
	
}
