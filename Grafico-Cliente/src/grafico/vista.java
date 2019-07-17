package grafico;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class vista{    
    JFrame ventana = new JFrame("Cliente");
    JPanel panel = new JPanel();
    JTextField num_ecuaciones = new JTextField();
    JTextField ecuaciones_x[];
    JTextField ecuaciones_y[];
    JTextField numero[];
    JTextField menor[];
    JButton boton = new JButton("Confirmar");
    JButton confirmar = new JButton("Enviar");
    JLabel l1 = new JLabel();
    JLabel titulo = new JLabel();
    JLabel fo1 = new JLabel();
    JLabel fo2 = new JLabel();
    JTextField x_ = new JTextField();
    JTextField y_ = new JTextField();
    JLabel coef_x = new JLabel("Coef X");
    JLabel coef_y = new JLabel("Coef Y");
    JLabel NUM = new JLabel("Número");
    JLabel MEN = new JLabel("Igualdad");
    int i,j;
    
    public void componentes(){
        ventana.setSize(700,700);
        ventana.setVisible(true);
        ventana.getContentPane().add(panel);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(null);
        titulo.setText("Gráfico Cliente");
        titulo.setBounds(300,10,150,50);
        panel.add(titulo);
        l1.setText("Digite número de ecuaciones");
        l1.setBounds(10,120,200,20);
        num_ecuaciones.setBounds(190,120,30,20);
        boton.setBounds(230,120,110,20);
        boton.setFocusable(false);
        panel.add(l1);
        panel.add(num_ecuaciones);
        panel.add(boton);
        fo1.setText("Coef. X");
        fo1.setBounds(10,60,150,20);
        fo2.setText("Coef. Y");
        fo2.setBounds(10,90,150,20);
        panel.add(fo1);
        panel.add(fo2);
        x_.setBounds(170,60,50,20);
        y_.setBounds(170,90,50,20);
        panel.add(x_);
        panel.add(y_);
        coef_x.setBounds(10,180,120,20);
        coef_y.setBounds(140,180,80,20);
        NUM.setBounds(350,180,120,20);
        MEN.setBounds(250,180,120,20);
        panel.add(coef_x);
        panel.add(coef_y);
        panel.add(NUM);
        panel.add(MEN);
    }
    
    public void ecuaciones_x(){
        int y=210;
        int necuaciones = Integer.valueOf(num_ecuaciones.getText());
        ecuaciones_x = new JTextField[10];
        for(i=0;i<necuaciones;i++)
        {
            ecuaciones_x[i]=new JTextField();
            panel.add(ecuaciones_x[i]);
            ecuaciones_x[i].setBounds(10,y,50,20);            
            y=y+30;
        }
    }
    
    public void ecuaciones_y(){
        int y=210;
        int necuaciones = Integer.valueOf(num_ecuaciones.getText());
        ecuaciones_y = new JTextField[10];
        for(i=0;i<necuaciones;i++)
        {
            ecuaciones_y[i]=new JTextField();
            panel.add(ecuaciones_y[i]);
            ecuaciones_y[i].setBounds(140,y,50,20);            
            y=y+30;
        }
    }
    
    public void numero(){
        int y=210;
        int necuaciones = Integer.valueOf(num_ecuaciones.getText());
        numero = new JTextField[10];
        for(i=0;i<necuaciones;i++)
        {
            numero[i]=new JTextField();
            panel.add(numero[i]);
            numero[i].setBounds(350,y,50,20);            
            y=y+30;
        }
    }
    
     public void menor_igual(){
        int y=210;
        int necuaciones = Integer.valueOf(num_ecuaciones.getText());
        menor = new JTextField[10];
        for(i=0;i<necuaciones;i++)
        {
            menor[i]=new JTextField();
            panel.add(menor[i]);
            menor[i].setBounds(250,y,50,20);            
            y=y+30;
        }
        confirmar.setBounds(10,y+10,100,20);
        confirmar.setFocusable(false);
        panel.add(confirmar);
    }
    
    public void asigna_oyentes(controlador1 cont1, controlador2 cont2)
    {
        boton.addActionListener(cont1);
        confirmar.addActionListener(cont2);
    }
    
}
