package uml;

import controladores.controlador_back;
import controladores.controlador_fin;
import java.awt.Dimension;
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
    String signo;

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
        int x=10;
        int y=70;
        int aux;
        int temp=0;
        int contador=0;
        Graphics2D g2d = (Graphics2D) g;	
        this.add(back);
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            g2d.drawRect(x, y, 100, 20);
            g2d.drawString(controlador_fin.clases.get(i), x+5,y+12);
            g2d.drawRect(x, y+20, 100, 20);
            System.out.println(contador);
            if(controladores.controlador_fin.numero_atributos.get(i)>1)
            {
                aux=55;
                for(j=0;j<controladores.controlador_fin.numero_atributos.get(i);j++)
                {
                    g2d.drawString(controlador_fin.atributos.get(temp),x+5,y+aux);
                    aux=aux+20;
                    temp++;
                }             
            }
            else
            {
               g2d.drawString(controlador_fin.atributos.get(temp),x+5,y+55); 
               temp++;
            }                 
            g2d.drawRect(x, y+40, 100, 80);
            x=x+110;
        }
        this.updateUI();
        this.setPreferredSize(new Dimension(x,y));
        super.paintComponents(g2d);       
    }
    
	
}
