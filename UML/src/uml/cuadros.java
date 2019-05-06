package uml;

import controladores.controlador_back;
import controladores.controlador_fin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;

public class cuadros extends JPanel{
    int x,y;
    public static boolean composicion = false;
    public static boolean agregacion = false;

    public JFrame frame = new JFrame();
    public JScrollPane scroll = new JScrollPane();
    public JButton back = new JButton();
    public void componentes(){
        
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        frame.add(scroll);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(600,100));
        scroll.setBounds(0,0,600,600);
        scroll.setViewportView(new cuadros());
        scroll.getViewport().setView(this);
        back.setText("Volver");
        back.setBounds(10,20,100,20);
        back.setFocusable(false);
        back.setVisible(true);
        
    }
    
    public void oyentes(controlador_back cb){
        back.addActionListener(cb);
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //paint_composicion(g2d);
        this.updateUI();
        this.setPreferredSize(new Dimension(x,y));
        super.paintComponents(g2d);       
    }    
	
}
