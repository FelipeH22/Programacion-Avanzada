/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoMemoria;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author juane
 */
public class Vista extends JFrame{
    
    JPanel panel = new JPanel();
    JButton botoninicial = new JButton();
    public JTextField cajatexto = new JTextField();
    
    
    public Vista(){
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Control de memoria");
        this.setLocationRelativeTo(null);
    }
    public void iniciarComponentes(){
        this.setVisible(true);
        Panel();
        Botones(); 
        labels();
        CajasdeTexto();
        cuadroinicial();
        cuadro2();
    }
    public void Panel(){
        this.getContentPane().add(panel);
        panel.setLayout(null);
    }
    
    public void labels(){
        JLabel insertar = new JLabel("Insertar");
        insertar.setBounds(200, 20, 80, 20);
        insertar.setFont(new Font("arial",1,15));
        //insertar.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        panel.add(insertar);
    }
    
    public void Botones(){
        JRadioButton boton1 = new JRadioButton("First Fit", true);
        boton1.setBounds(50, 20, 100, 20);
        panel.add(boton1);
        
        JRadioButton boton2 = new JRadioButton("Next Fit", false);
        boton2.setBounds(50, 50, 100, 20);
        panel.add(boton2);
        
        JRadioButton boton3 = new JRadioButton("Best Fit", false);
        boton3.setBounds(50, 80, 100, 20);
        panel.add(boton3);
        
        JRadioButton boton4 = new JRadioButton("Worst Fit", false);
        boton4.setBounds(50, 110, 100, 20);
        panel.add(boton4);
        
        ButtonGroup grupobotones = new ButtonGroup();
        grupobotones.add(boton1);
        grupobotones.add(boton2);
        grupobotones.add(boton3);
        grupobotones.add(boton4);
        
        botoninicial.setText("Ingresar");
        botoninicial.setBounds(520, 20, 120, 20);
        panel.add(botoninicial);
    }
    
    public void CajasdeTexto(){
        cajatexto.setBounds(300, 20, 200, 20);
        panel.add(cajatexto);
    }
    
    public void cuadroinicial(){
        
        JLabel cuadro1 = new JLabel();
        cuadro1.setText("OS 8m");
        cuadro1.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro1.setOpaque(true);
        cuadro1.setBounds(200, 100, 100, 80);
        cuadro1.setForeground(Color.BLACK);
        cuadro1.setBackground(Color.WHITE);
        cuadro1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro1.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro1);
        
        JLabel cuadro2 = new JLabel();
        cuadro2.setText("p1 8m");
        cuadro2.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro2.setOpaque(true);
        cuadro2.setBounds(200, 179, 100, 80);
        cuadro2.setForeground(Color.BLACK);
        cuadro2.setBackground(Color.WHITE);
        cuadro2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro2.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro2);
        
        JLabel cuadro3 = new JLabel();
        cuadro3.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro3.setOpaque(true);
        cuadro3.setBounds(200, 258, 100, 80);
        cuadro3.setForeground(Color.BLACK);
        cuadro3.setBackground(Color.WHITE);
        cuadro3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro3.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro3);
        
        JLabel cuadro4 = new JLabel();
        cuadro4.setText("p3 2m");
        cuadro4.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro4.setOpaque(true);
        cuadro4.setBounds(200, 337, 100, 20);
        cuadro4.setForeground(Color.BLACK);
        cuadro4.setBackground(Color.WHITE);
        cuadro4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro4.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro4);
        
        JLabel cuadro5 = new JLabel();
        cuadro5.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro5.setOpaque(true);
        cuadro5.setBounds(200, 356, 100, 100);
        cuadro5.setForeground(Color.BLACK);
        cuadro5.setBackground(Color.WHITE);
        cuadro5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro5.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro5);
        
        JLabel cuadro6 = new JLabel();
        cuadro6.setText("p5 8m");
        cuadro6.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro6.setOpaque(true);
        cuadro6.setBounds(200, 455, 100, 80);
        cuadro6.setForeground(Color.BLACK);
        cuadro6.setBackground(Color.WHITE);
        cuadro6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro6.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro6);
        
        JLabel cuadro7 = new JLabel();
        cuadro7.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro7.setOpaque(true);
        cuadro7.setBounds(200, 534, 100, 40);
        cuadro7.setForeground(Color.BLACK);
        cuadro7.setBackground(Color.WHITE);
        cuadro7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro7.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro7);
    }
    
    public void cuadro2(){
        int x = 400;
        JLabel cuadro8 = new JLabel();
        cuadro8.setText("OS 8m");
        cuadro8.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro8.setOpaque(true);
        cuadro8.setBounds(x, 100, 100, 80);
        cuadro8.setForeground(Color.BLACK);
        cuadro8.setBackground(Color.WHITE);
        cuadro8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro8.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro8);
        
        JLabel cuadro9 = new JLabel();
        cuadro9.setText("p1 8m");
        cuadro9.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro9.setOpaque(true);
        cuadro9.setBounds(x, 179, 100, 80);
        cuadro9.setForeground(Color.BLACK);
        cuadro9.setBackground(Color.WHITE);
        cuadro9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro9.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro9);
        
        JLabel cuadro10 = new JLabel();
        cuadro10.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro10.setOpaque(true);
        cuadro10.setBounds(x, 258, 100, 80);
        cuadro10.setForeground(Color.BLACK);
        cuadro10.setBackground(Color.WHITE);
        cuadro10.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro10.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro10);
        
        JLabel cuadro11 = new JLabel();
        cuadro11.setText("p3 2m");
        cuadro11.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro11.setOpaque(true);
        cuadro11.setBounds(x, 337, 100, 20);
        cuadro11.setForeground(Color.BLACK);
        cuadro11.setBackground(Color.WHITE);
        cuadro11.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro11.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro11);
        
        JLabel cuadro12 = new JLabel();
        cuadro12.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro12.setOpaque(true);
        cuadro12.setBounds(x, 356, 100, 100);
        cuadro12.setForeground(Color.BLACK);
        cuadro12.setBackground(Color.WHITE);
        cuadro12.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro12.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro12);
        
        JLabel cuadro13 = new JLabel();
        cuadro13.setText("p5 8m");
        cuadro13.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro13.setOpaque(true);
        cuadro13.setBounds(x, 455, 100, 80);
        cuadro13.setForeground(Color.BLACK);
        cuadro13.setBackground(Color.WHITE);
        cuadro13.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro13.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro13);
        
        JLabel cuadro14 = new JLabel();
        cuadro14.setHorizontalAlignment(SwingConstants.CENTER);
        cuadro14.setOpaque(true);
        cuadro14.setBounds(x, 534, 100, 40);
        cuadro14.setForeground(Color.BLACK);
        cuadro14.setBackground(Color.WHITE);
        cuadro14.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cuadro14.setFont(new Font("arial",Font.PLAIN,20));
        panel.add(cuadro14);
    }
    
    public void oyentes(Controlador cont){
        botoninicial.addActionListener(cont);
        this.repaint();
    }
}
