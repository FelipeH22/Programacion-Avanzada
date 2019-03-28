package ley_demeter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador implements ActionListener{
    vista v = new vista();
    modelo t = new modelo();
    
    public controlador(vista v, modelo t){
        this.v=v;
        this.t=t;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        t.almacena_variables();
        t.calcula_divisores();
        t.muestra_divisores();
    }
    
}
