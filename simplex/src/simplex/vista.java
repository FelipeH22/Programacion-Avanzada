package simplex;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class vista extends JFrame{
        lib_simplex lib = new lib_simplex();
	JFrame ventana = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
	JTextField num_variables = new JTextField();
        JTextField num_ecuaciones = new JTextField();
        JButton boton =  new JButton();
	JTextField variables[];
        JTextField inecuaciones[];
	public vista() {
		this.setSize(500,500);
		this.setTitle("Método Simplex");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(panel);
	}
	
	public void componentes() {
		this.setVisible(true);
		panel.setLayout(null);
		panel.setSize(500,500);
		label.setBounds(10,50,250,20);
		label.setText("Cantidad de variables");
		panel.add(label);
		num_variables.setBounds(180,50,50,20);
		panel.add(num_variables);
                boton.setText("Generar");
                boton.setBounds(10,250,100,20);
                panel.add(boton);
                label2.setBounds(10,120,100,20);
                label2.setText("Valor variables");
                panel.add(label2);
                label3.setBounds(10,180,150,20);
                label3.setText("Número inecuaciones");
                panel.add(label3);
                num_ecuaciones.setBounds(180,180,50,20);
		panel.add(num_ecuaciones);
		
	}
	public void variables(int n) {
            int i;
            variables = new JTextField[n];
            for(i=0;i<n;i++)
            {
                variables[i]=new JTextField();
            }
             for(i=0;i<n;i++)
            {
               panel.add(variables[i]);
               variables[i].setBounds(105+(i*50),120,30,20);
            }
	}
        public void inecuaciones(int j, int n) {
            int i,t,h;
            i=0;
            t=0;
            h=0;
            while(i<j)
            {
                variables = new JTextField[n];
                for(t=0;t<n;t++)
                {
                    variables[t]=new JTextField();
                }
                 for(t=0;t<n;t++)
                {
                   panel.add(variables[t]);
                   variables[t].setBounds(105+(t*50),290+(h*20),30,20);
                }   
                h++; 
                i++;
            }
	}
        
        public void asigna_oyentes(controlador cont){
            boton.addActionListener(cont);
        }
	
}
