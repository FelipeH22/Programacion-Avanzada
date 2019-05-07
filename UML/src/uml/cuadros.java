package uml;

import controladores.controlador_back;
import controladores.controlador_fin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;

public class cuadros extends JPanel{
    int x=10;
    int y=70;
    int y_texto;
    int x_texto;
    int i,j,h;
    public static int clase1_compo;
    public static int clase2_compo; 
    public static int clase1_agrega;
    public static int clase2_agrega; 
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
        x=10;
        this.add(back);
        Graphics2D g2d = (Graphics2D) g;
        paint_clases(g2d);
        paint_composicion(g2d);
        paint_agregacion(g2d);
        this.updateUI();
        this.setPreferredSize(new Dimension(x+controlador_fin.num_clases*110,y+300));
        super.paintComponents(g2d);       
    }

    public void paint_clases(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            x_texto=x+4;
            y=70;
            g2d.drawRect(x, y=y+20, 100, 20);
            y_texto=y+12;
            g2d.drawString(controlador_fin.clases[i].get(0), x_texto, y_texto);
            g2d.drawRect(x, y=y+20, 100, controlador_fin.instancias[i].size()*15+10);   
            y_texto=y+12;
            for(j=0;j<controlador_fin.instancias[i].size();j++)
            {
                g2d.drawString(controlador_fin.instancias[i].get(j), x_texto, y_texto);
                y_texto=y_texto+15;
            }
            g2d.drawRect(x, y=y+controlador_fin.instancias[i].size()*15+10 , 100,controlador_fin.atributos[i].size()*15+10);
            y_texto=y+12;
            for(j=0;j<controlador_fin.atributos[i].size();j++)
            {
                g2d.drawString(controlador_fin.atributos[i].get(j), x_texto, y_texto);
                y_texto=y_texto+15;
            }
            x=x+110;
            
        }
    }
    
    public void paint_composicion(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage img = null;
        try {

                img = ImageIO.read(new File("composicion.png")); // Aquí la ruta del fichero
                } catch (IOException e) {
                System.out.println("Problemas leyendo la imagen n");
                System.out.println("Motivo: " + e.getLocalizedMessage());
            } 
        x=10;
        y=y+20;
        if(composicion==true){
            g2d.setColor(Color.red);
            g2d.drawRect(x, y=y+controlador_fin.atributos[0].size()*15+100, 300, 300+controlador_fin.atributos[clase2_compo].size()*15+80);
            g2d.drawString("Composición", x+100, y+15);
            g2d.setColor(Color.BLACK);
            y=y+10;
            x=x+10;
            for(i=0;i<2;i++)
            {
                if(i==0)
                {
                    x_texto=x+4;
                    g2d.drawRect(x, y=y+20, 100, 20);
                    y_texto=y+12;
                    g2d.drawString(controlador_fin.clases[clase1_compo].get(0), x_texto, y_texto);
                    g2d.drawRect(x, y=y+20, 100, controlador_fin.instancias[clase1_compo].size()*15+10);   
                    y_texto=y+12;
                    for(j=0;j<controlador_fin.instancias[clase1_compo].size();j++)
                    {
                        g2d.drawString(controlador_fin.instancias[clase1_compo].get(j), x_texto, y_texto);
                        y_texto=y_texto+15;
                    }
                    g2d.drawRect(x, y=y+controlador_fin.instancias[clase1_compo].size()*15+10 , 100,controlador_fin.atributos[clase1_compo].size()*15+10);
                    y_texto=y+15;
                    for(j=0;j<controlador_fin.atributos[clase1_compo].size();j++)
                    {
                        g2d.drawString(controlador_fin.atributos[clase1_compo].get(j), x_texto, y_texto);
                        y_texto=y_texto+15;
                    }
                    g2d.drawImage(img, x+23, y+50,35,70, this); 
                    g2d.drawLine(x+40,y+80,x+40,y+150);
                }
                else
                {
                    x_texto=x+4;
                    g2d.drawRect(x, y=y+controlador_fin.atributos[clase2_compo].size()*15+80, 100, 20);
                    y_texto=y+12;
                    g2d.drawString(controlador_fin.clases[clase2_compo].get(0), x_texto, y_texto);
                    g2d.drawRect(x, y=y+20, 100, controlador_fin.instancias[clase2_compo].size()*15+10);   
                    y_texto=y+12;
                    for(j=0;j<controlador_fin.instancias[clase2_compo].size();j++)
                    {
                        g2d.drawString(controlador_fin.instancias[clase2_compo].get(j), x_texto, y_texto);
                        y_texto=y_texto+15;
                    }
                    g2d.drawRect(x, y=y+controlador_fin.instancias[clase2_compo].size()*15+10 , 100,controlador_fin.atributos[clase2_compo].size()*15+10);
                    y_texto=y+12;
                    for(j=0;j<controlador_fin.atributos[clase2_compo].size();j++)
                    {
                        g2d.drawString(controlador_fin.atributos[clase2_compo].get(j), x_texto, y_texto);
                        y_texto=y_texto+15;
                    }
                }
                
                y=y+120;  
            }
        }
    }
    
    public void paint_agregacion(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage img = null;
        try {

                img = ImageIO.read(new File("agregacion.png")); // Aquí la ruta del fichero
                } catch (IOException e) {
                System.out.println("Problemas leyendo la imagen n");
                System.out.println("Motivo: " + e.getLocalizedMessage());
            } 
        x=10;
        y=y+20;
        if(agregacion==true){
            g2d.setColor(Color.red);
            g2d.drawRect(x, y=y+controlador_fin.atributos[0].size()*15+100, 300, 300+controlador_fin.atributos[clase2_agrega].size()*15+80);
            g2d.drawString("Agregación", x+100, y+15);
            g2d.setColor(Color.BLACK);
            y=y+10;
            x=x+10;
            for(i=0;i<2;i++)
            {
                if(i==0)
                {
                    x_texto=x+4;
                    g2d.drawRect(x, y=y+20, 100, 20);
                    y_texto=y+12;
                    g2d.drawString(controlador_fin.clases[clase1_agrega].get(0), x_texto, y_texto);
                    g2d.drawRect(x, y=y+20, 100, controlador_fin.instancias[clase1_agrega].size()*15+10);   
                    y_texto=y+12;
                    for(j=0;j<controlador_fin.instancias[clase1_agrega].size();j++)
                    {
                        g2d.drawString(controlador_fin.instancias[clase1_agrega].get(j), x_texto, y_texto);
                        y_texto=y_texto+15;
                    }
                    g2d.drawRect(x, y=y+controlador_fin.instancias[clase1_agrega].size()*15+10 , 100,controlador_fin.atributos[clase1_agrega].size()*15+10);
                    y_texto=y+12;
                    for(j=0;j<controlador_fin.atributos[clase1_agrega].size();j++)
                    {
                        g2d.drawString(controlador_fin.atributos[clase1_agrega].get(j), x_texto, y_texto);
                        y_texto=y_texto+15;
                    }
                    g2d.drawImage(img, x+23, y+50,70,70, this); 
                    g2d.drawLine(x+58,y+120,x+58,y+170);
                }
                else
                {
                    x_texto=x+4;
                    g2d.drawRect(x, y=y+controlador_fin.atributos[clase2_agrega].size()*15+80, 100, 20);
                    y_texto=y+12;
                    g2d.drawString(controlador_fin.clases[clase2_agrega].get(0), x_texto, y_texto);
                    g2d.drawRect(x, y=y+20, 100, controlador_fin.instancias[clase2_agrega].size()*15+10);   
                    y_texto=y+12;
                    for(j=0;j<controlador_fin.instancias[clase2_agrega].size();j++)
                    {
                        g2d.drawString(controlador_fin.instancias[clase2_agrega].get(j), x_texto, y_texto);
                        y_texto=y_texto+10;
                    }
                    g2d.drawRect(x, y=y+controlador_fin.instancias[clase2_agrega].size()*15+10 , 100,controlador_fin.atributos[clase2_agrega].size()*15+10);
                    y_texto=y+12;
                    for(j=0;j<controlador_fin.atributos[clase2_agrega].size();j++)
                    {
                        g2d.drawString(controlador_fin.atributos[clase2_agrega].get(j), x_texto, y_texto);
                        y_texto=y_texto+10;
                    }
                }
                
                y=y+120;  
            }
        }
    }	
}
