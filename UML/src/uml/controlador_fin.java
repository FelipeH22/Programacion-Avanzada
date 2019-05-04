package uml;

import figuras.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador_fin implements ActionListener{
    vista v = new vista();
    modelo m = new modelo();
    cuadros c = new cuadros();
    
    public controlador_fin(vista v, modelo m){
        this.v=v;
        this.m=m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        v.setVisible(false);
        c.componentes();
        c.oyentes(new controlador_back(c));
        /*v.panel.setVisible(false);
        v.add(c.panel);*/
        
    }   
}
