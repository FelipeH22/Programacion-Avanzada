package simplex;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.*;

public class vista extends JFrame{
        lib_simplex lib = new lib_simplex();
	JFrame ventana = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel var[];
	JTextField num_variables = new JTextField();
        JTextField num_ecuaciones = new JTextField();
        JButton boton =  new JButton();
        JButton calcular =  new JButton();
	JTextField variables[];
        JTextField inecuaciones[][];
        JTextField resultados[];
        ButtonGroup bg[];
        JRadioButton radio[];
	public vista() {
		this.setSize(700,500);
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
                label2.setText("Valor variables Z");
                panel.add(label2);
                label3.setBounds(10,180,150,20);
                label3.setText("Número inecuaciones");
                panel.add(label3);
                num_ecuaciones.setBounds(180,180,50,20);
		panel.add(num_ecuaciones);
                calcular.setBounds(10,420,100,20);
                calcular.setText("Calcular");
                panel.add(calcular);
		
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
               variables[i].setBounds(115+(i*50),120,30,20);
            }
	}
        public void inecuaciones(int j, int n) {
            etiquetas(j,n);
            int i,t,t1,x,y,h;
            i=0;
            t=0;
            y=315;
            h=1;
            inecuaciones = new JTextField[j][n];
            for(t=0;t<j;t++)
            {
                x=10;
                for(t1=0;t1<n;t1++)
                {
                    inecuaciones[t][t1] = new JTextField();
                    inecuaciones[t][t1].setBounds(x,y,30,20);
                    panel.add(inecuaciones[t][t1]);
                    x=x+50;
                }          
                y=y+20;
            }
            resultados(j,n);
        }
        
        public void resultados(int j, int n){
            int i;
            int y=315;
            JLabel res = new JLabel();
            resultados = new JTextField[j];
            res.setBounds(inecuaciones[0][n-1].getX()+50,290,50,20);
            res.setText("Result.");
            panel.add(res);
            for(i=0;i<j;i++)
            {
                resultados[i]=new JTextField();
            }
            for(i=0;i<j;i++)
            {
               panel.add(resultados[i]);
               resultados[i].setBounds(inecuaciones[0][n-1].getX()+50,y,30,20);
               y=y+20;
            }
        }
	
        public void etiquetas(int j, int n){
            int i;
            var = new JLabel[n];
            for(i=0;i<n;i++)
            {
                var[i]=new JLabel();
            }
             for(i=0;i<n;i++)
            {
               panel.add(var[i]);
               var[i].setText("X"+(i+1));
               var[i].setBounds(10+(i*50),290,30,20);
            }
            // radiobutton(j,n);
        }
        public void radiobutton(int j, int n){ 
            int i,t,h;
            h=0;
            radio = new JRadioButton[n*j];
            bg = new ButtonGroup[j];      
            for(t=0;t<j;t++)
            {
                bg[t]= new ButtonGroup();
            }
            for(t=0;t<n*j;t++)
            {
                radio[t]=new JRadioButton();
            }
            for(i=0;i<j;i++)
            {
                for(t=0;t<4;t++)
                {
                    radio[t].setFocusable(false);
                    radio[t].setBounds(variables[n-1].getX()+(t*50),310+(i*20),50,20);
                    if(t==0)
                        radio[t].setText("<");
                    if(t==1)
                        radio[t].setText("<=");
                    if(t==2)
                        radio[t].setText(">=");
                    if(t==3)
                        radio[t].setText(">");
                    
                    bg[i].add(radio[t]);
                    panel.add(radio[t]);
                }             
            }
        }
        
        public void asigna_oyentes(controlador cont, controlador2 cont2){
            boton.addActionListener(cont);
            calcular.addActionListener(cont2);
        }
        
	
}
