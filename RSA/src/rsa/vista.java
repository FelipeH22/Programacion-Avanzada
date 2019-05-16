package rsa;

public class vista extends vista_abstract implements vista_interface{
    
    @Override
    public void componentes(){
        ventana.setSize(500,500);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        crea_labels();
        crea_boton();
        crea_textField();
    }
    
    @Override
    public void panel(){
        panel.setLayout(null);
        panel.setVisible(true);
        ventana.add(panel);
    }

    @Override
    public void crea_labels() {
        palabra_label.setBounds(10, 10, 150, 20);
        panel.add(palabra_label);
    }

    @Override
    public void crea_boton() {
        
    }

    @Override
    public void crea_textField() {
        
    }
    
}
