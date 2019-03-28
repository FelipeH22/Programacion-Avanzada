package ley_demeter;

import javax.swing.JFrame;
import javax.swing.*;

public class vista extends JFrame{
    
    JPanel panel = new JPanel();
    JLabel titulo = new JLabel();
    JLabel subtitulo = new JLabel();
    JButton boton = new JButton();
    JTextField a = new JTextField();
    JTextField b = new JTextField();
    JTextField c = new JTextField();
    JTextField d = new JTextField();
    JLabel resultado = new JLabel();
    
    public vista(){
        this.setSize(500,500);
        this.setTitle("Ley de Demeter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
    }    
    
    public void componentes(){
        this.setVisible(true);
        //Panel
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setSize(500,500);
        //Label titulo y subtitulo
        titulo.setBounds(170,0,200,50);
        titulo.setText("Raíces Polinómicas Grado 3");
        panel.add(titulo);
        subtitulo.setBounds(185,50,200,50);
        subtitulo.setText("Usando ley de Demeter");
        panel.add(subtitulo);
        //Cajas de Texto
        a.setBounds(60,200,80,30);
        panel.add(a);
        b.setBounds(60,250,80,30);
        panel.add(b);
        c.setBounds(60,300,80,30);
        panel.add(c);
        d.setBounds(60,350,80,30);
        panel.add(d);
        //Botón
        boton.setBounds(250,200,100,30);
        boton.setText("Raíces");
        panel.add(boton);
        //Label Resultado
        resultado.setBounds(250,250,150,50);
        resultado.setText("Resultado: ");
        panel.add(resultado);    
        letras();
    }
    
    public void letras(){
        JLabel a1 = new JLabel();
        JLabel b1 = new JLabel();
        JLabel c1 = new JLabel();
        JLabel d1 = new JLabel();        
        a1.setBounds(10,205,10,10);
        a1.setText("a");
        panel.add(a1);
        b1.setBounds(10,255,10,10);
        b1.setText("b");
        panel.add(b1);
        c1.setBounds(10,305,10,10);
        c1.setText("c");
        panel.add(c1);
        d1.setBounds(10,355,10,10);
        d1.setText("d");
        panel.add(d1);
    }
    
    public void asigna_oyentes(controlador cont){
        boton.addActionListener(cont);
    }
    
}
