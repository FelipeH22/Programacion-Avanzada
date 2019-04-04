package simplex;

import javax.swing.JFrame;
import javax.swing.*;

public class vista extends JFrame{
	JFrame ventana = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JTextField num_variables = new JTextField();
	JTextField variable1 = new JTextField();
	JTextField variable2 = new JTextField();
	JTextField variable3 = new JTextField();
	JTextField variable4 = new JTextField();
	
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
		num_variables.setBounds(250,50,50,20);
		panel.add(num_variables);
		variables();
		
	}
	public void variables() {
		variable1.setBounds(10,80,50,50);
		variable1.setVisible(false);
		panel.add(variable1);
		variable2.setBounds(10,160,50,50);
		variable2.setVisible(false);
		panel.add(variable2);
	}
	
}
