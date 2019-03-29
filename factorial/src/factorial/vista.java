package factorial;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.*;

public class vista extends JFrame{
    
    JButton boton = new JButton();
    JLabel label = new JLabel();
    JLabel num = new JLabel();
    JTextField text = new JTextField();
    JPanel panel = new JPanel();
    
    public vista(){
        this.setSize(300,300);
        this.setTitle("Factorial");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    public void elementos(){
        this.setVisible(true);
        this.getContentPane().add(panel);
        panel.setLayout(null);  
        panel.setSize(500,500);
        text.setBounds(120,10,100,20);
        panel.add(text);
        num.setBounds(0,0,150,40);
        num.setText("Digite el número");
        panel.add(num);
        boton.setBounds(120,100,100,20);
        boton.setText("Factorial");
        panel.add(boton);
        label.setBounds(100,200,200,50);
        panel.add(label);
    }
    public void listener(controlador cont){
        boton.addActionListener(cont);
    }
}
