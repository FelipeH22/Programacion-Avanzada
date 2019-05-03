package uml;

import figuras.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador_fin implements ActionListener{
    vista v = new vista();
    modelo m = new modelo();
    ventana ventana = new ventana();
    cuadros cua = new cuadros();
    controlador_back cb = new controlador_back(ventana);
    
    public controlador_fin(vista v, modelo m){
        this.v=v;
        this.m=m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        v.setVisible(false);
        ventana.componentes();      
        ventana.oyentes(cb);
    }   
}
