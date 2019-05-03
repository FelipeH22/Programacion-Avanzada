package uml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador2 implements ActionListener{
    vista v = new vista();
    modelo m = new modelo();
    int contador=0;
    
    public controlador2(vista v, modelo m){
        this.v=v;
        this.m=m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        v.scroll.updateUI();
        v.componentes();              
        v.herencias(contador);
        v.scroll.updateUI();
        contador++;
    }   
}
