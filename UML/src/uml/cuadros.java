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
    public int num_cuadros;
    int i=0;
    int j=0;
    int y_fijo;
    int x_fijo;
    int x,y;
    public ArrayList <String> clases = new ArrayList<>();
    public ArrayList <String> atributos = new ArrayList<>();
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
        x_fijo=10;
        y_fijo=70;
        j=0;
        int aux;
        int aux2;
        int temp=0;
        int contador=0;
        Graphics2D g2d = (Graphics2D) g;	
        this.add(back);
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            g2d.drawRect(x_fijo, y_fijo, 100, 20);
            g2d.drawString(controlador_fin.clases.get(i), x_fijo+5,y_fijo+12);
            g2d.drawRect(x_fijo, y_fijo+20, 100, 20);
            aux2=x_fijo-105;
            for(j=j;j<controladores.controlador_fin.intermedio.size();j++)
            {
                g2d.drawString(controlador_fin.intermedio.get(j), aux2,y_fijo+32);
                aux2=aux2+110;
            }
                
            if(controladores.controlador_fin.numero_atributos.get(i)>1)
            {
                aux=55;
                for(j=0;j<controladores.controlador_fin.numero_atributos.get(i);j++)
                {
                    g2d.drawString(controlador_fin.atributos.get(temp),x_fijo+5,y_fijo+aux);
                    aux=aux+20;
                    temp++;
                }             
            }
            else
            {
               g2d.drawString(controlador_fin.atributos.get(temp),x_fijo+5,y_fijo+55); 
               temp++;
            }                 
            g2d.drawRect(x_fijo, y_fijo+40, 100, 80);
            x_fijo=x_fijo+110;
        }
        /////////////////////////////////////////////////////////////////////////////////////////
        //Pintar composición
        x=10;
        y=200;
        temp=0;
        j=0;
        if(composicion==true)
        {
            g2d.setColor(Color.RED);
            g2d.drawRect(x, y, 250, 300);
            x=x+5;
            y=y+20;
            g2d.setColor(Color.BLACK);
            g2d.drawString("COMPOSICIÓN", x,y);   
            for(i=0;i<controlador_fin.compo.size();i++)
            {
                g2d.drawRect(x, y+10, 100, 20);
                g2d.drawString(controlador_fin.clases.get(controlador_fin.clases.lastIndexOf(controlador_fin.compo.get(i))), x+5,y=y+24);
                g2d.drawRect(x, y+6, 100, 20);
                x=x+110;
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //paint_composicion(g2d);
        this.updateUI();
        this.setPreferredSize(new Dimension(x_fijo,y_fijo+y+300));
        super.paintComponents(g2d);       
    }
    
    
    
    public void paint_agregacion(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        if(agregacion==true)
        {
            
        }
    }
    
	
}
