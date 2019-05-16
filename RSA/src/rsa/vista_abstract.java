package rsa;

import javax.swing.*;

public abstract class vista_abstract extends JFrame{
    public static JFrame ventana = new JFrame("Encriptación con RSA");
    public static JPanel panel = new JPanel();
    public static JLabel palabra_label = new JLabel("Digite la palabra a encriptar");
    public static JTextField palabra = new JTextField();
    public static JTextField p = new JTextField();
    public static JTextField q = new JTextField();
    public static JTextField n = new JTextField();
    public static JButton boton = new JButton("Encriptar");
}
