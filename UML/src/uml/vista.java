package uml;

import controladores.controlador_fin;
import controladores.controlador2;
import controladores.controlador;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.JFrame;

public class vista extends JFrame{
    int inicio=0;
    int fin=2;
    int i;
    int j;
    int y=140;
    public JScrollPane scroll = new JScrollPane();
    public JPanel panel = new JPanel();
    JLabel titulo = new JLabel();
    JLabel subtitulo = new JLabel();
    public JTextArea cajas[];
    JLabel indicativo_cajas[];
    public JTextArea herencias = new JTextArea();
    JLabel indicativo_herencias = new JLabel();
    JButton boton_anadir = new JButton();
    JButton crea_text = new JButton();
    JButton enviar_datos = new JButton();
    public JButton crea_herencia = new JButton();
    JLabel num = new JLabel();
    public JTextField num_clases = new JTextField();
    modelo m = new modelo();
    
    public vista(){
        this.setSize(600,600);
        this.setTitle("UML");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }    
    
    public void componentes(){
        this.setVisible(true);
        //Panel
        this.add(scroll);
        scroll.setBounds(0,0,600,600);
        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panel);
        scroll.getViewport().setView(panel);
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(600,100));
        //Label titulo
        titulo.setBounds(190,0,200,50);
        titulo.setText("Diagramas UML");
        panel.add(titulo);
        //Botones
        num.setBounds(10,50,60,20);
        num.setText("# clases");
        panel.add(num);
        num_clases.setBounds(70,50 ,60 ,20 );
        panel.add(num_clases);
        crea_text.setBounds(140, 50, 130, 20);
        crea_text.setText("Crear clases");
        panel.add(crea_text);
        crea_herencia.setBounds(280,50,130,20);
        crea_herencia.setText("Nueva herencia");
        panel.add(crea_herencia);
        enviar_datos.setBounds(420,50,130,20);
        enviar_datos.setText("Enviar datos");
        panel.add(enviar_datos);
        oyentes(new controlador(this,m), new controlador_fin(this,m), new controlador2(this,m));
    }
    
    public void cajas_texto(int n){
        inicio=0;
        fin=2;
        i=inicio;
        j=fin;
        int cont=0;
        cajas = new JTextArea[n*2];
        indicativo_cajas = new JLabel[n*2];
        for(i=0;i<n*2;i++)
        {
            cajas[i] = new JTextArea();
            indicativo_cajas[i] = new JLabel();
            indicativo_cajas[i].setText("Nueva clase o interface");
        }
        for(j=0;j<n;j++)
        {           
            for(i=inicio;i<fin;i++)
            {
                if(i%2==0)
                {
                    cajas[i].setText("class ");
                }
                indicativo_cajas[i].setBounds(10,y-40,150,30);
                panel.add(indicativo_cajas[i]);
                cajas[i].setBounds(10+(cont*130),y,120,70);
                panel.add(cajas[i]);
                cont++;
            }
            cont =0;
            inicio=inicio+2;
            fin=fin+2;
            y=y+120;
        }
        panel.setPreferredSize(new Dimension(500,500+(cajas[i-1].getY()-380)));
    }
    public void herencias(){
        indicativo_herencias.setText("Digite todas las herencias");
        panel.add(indicativo_herencias);
        indicativo_herencias.setBounds(10,y-30,170,30);
        herencias.setBounds(10,y,150,70);
        panel.add(herencias);
        y=y+120;
        panel.setPreferredSize(new Dimension(500,500+(herencias.getY()-380)));
    }
    
    public void oyentes(controlador c, controlador_fin cf, controlador2 c2){
         crea_text.addActionListener(c);
         enviar_datos.addActionListener(cf);
         crea_herencia.addActionListener(c2);
    }
    
    
    
}
