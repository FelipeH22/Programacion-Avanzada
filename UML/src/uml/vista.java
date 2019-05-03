package uml;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.JFrame;

public class vista extends JFrame{
    JScrollPane scroll = new JScrollPane();
    JPanel panel = new JPanel();
    JLabel titulo = new JLabel();
    JLabel subtitulo = new JLabel();
    JTextArea cajas[];
    JButton boton_anadir = new JButton();
    JButton crea_text = new JButton();
    JButton enviar_datos = new JButton();
    JButton crea_herencia = new JButton();
    JLabel num = new JLabel();
    JTextField num_clases = new JTextField();
    
    public vista(){
        this.setSize(600,600);
        this.setTitle("UML");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
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
    }
    
    public void cajas_texto(int n){
        int i;
        int j;
        int y=120;
        int inicio=0;
        int fin=2;
        int cont=0;
        cajas = new JTextArea[n*2];
        for(i=0;i<n*2;i++)
        {
            cajas[i] = new JTextArea();
        }
        for(j=0;j<n;j++)
        {           
            for(i=inicio;i<fin;i++)
            {
                panel.add(cajas[i]);
                cajas[i].setBounds(10+(cont*130),y,120,70);
                cont++;
            }
            cont =0;
            inicio=inicio+2;
            fin=fin+2;
            y=y+90;
        }
        panel.setPreferredSize(new Dimension(500,500+(cajas[i-1].getY()-400)));
    }
    
    public void oyentes(controlador c, controlador_fin cf, controlador2 c2){
         crea_text.addActionListener(c);
         enviar_datos.addActionListener(cf);
         crea_herencia.addActionListener(c2);
    }
    
    
    
}
