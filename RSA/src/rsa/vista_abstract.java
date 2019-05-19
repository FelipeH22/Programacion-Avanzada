package rsa;

import javax.swing.*;

public abstract class vista_abstract extends JFrame{
    public static JPanel panel = new JPanel();
    public static JLabel titulo = new JLabel();
    public static JLabel palabra_label = new JLabel("Digite la palabra a encriptar");
    public static JLabel p_label = new JLabel();
    public static JLabel q_label = new JLabel();
    public static JLabel n_label = new JLabel();    
    public static JLabel z = new JLabel();
    public static JLabel s = new JLabel();
    public static JLabel num_palabra = new JLabel();
    public static JTextField palabra = new JTextField();
    public static JTextField p = new JTextField();
    public static JTextField q = new JTextField();
    public static JTextField n = new JTextField();
    public static JButton boton = new JButton("Encriptar");
}
