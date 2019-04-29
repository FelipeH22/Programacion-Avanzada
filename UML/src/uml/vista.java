package uml;

import javax.swing.*;
import javax.swing.JFrame;

public class vista extends JFrame{
    JPanel panel = new JPanel();
    JLabel titulo = new JLabel();
    JLabel subtitulo = new JLabel();
    JTextField cajas[];
    JButton boton_anadir = new JButton();
    JButton enviar_datos = new JButton();
    JButton crea_herencia = new JButton();
    JLabel num = new JLabel();
    JTextField num_clases = new JTextField();
    
    public vista(){
        this.setSize(500,500);
        this.setTitle("UML");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
    }    
    
    public void componentes(){
        this.setVisible(true);
        //Panel
        this.getContentPane().add(panel);
        panel.setLayout(null);
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
        enviar_datos.setBounds(150, 50, 120, 20);
        enviar_datos.setText("Enviar datos");
        panel.add(enviar_datos);
        crea_herencia.setBounds(280,50,120,20);
        crea_herencia.setText("Crear herencia");
        panel.add(crea_herencia);
        cajas_texto(1);
    }
    
    public void cajas_texto(int n){
        int i;
        int j;
        int y=120;
        int inicio=0;
        int fin=2;
        int cont=0;
        cajas = new JTextField[n*2];
        for(i=0;i<n*2;i++)
        {
            cajas[i] = new JTextField();
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
    }
    
    public void oyentes(controlador c){
         enviar_datos.addActionListener(c);
    }
    
    
    
}
