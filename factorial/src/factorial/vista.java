package factorial;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.*;

public class vista extends JFrame{
    
    JButton boton = new JButton();
    JLabel label = new JLabel();
    JTextArea text = new JTextArea();
    JPanel panel = new JPanel();
    
    public vista(){
        this.setSize(300,300);
        this.setTitle("Factorial");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.elementos();
    }
    public void elementos(){
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);    
        panel.setSize(500,500);
        text.setBounds(0,0,100,40);
        panel.add(text);
        boton.setBounds(0,100,30,30);
        panel.add(boton);
        label.setBounds(0,200,100,50);
        label.setForeground(Color.WHITE);
        panel.add(label);
    }
}
