package uml;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador_back implements ActionListener{
    cuadros c = new cuadros();
    vista v = new vista();
    
    public controlador_back(cuadros c){
        this.c=c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c.frame.setVisible(false);
        v.setVisible(true);
        v.componentes();  
    }
}
