package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uml.modelo;
import uml.vista;

public class controlador2 implements ActionListener{
    vista v = new vista();
    modelo m = new modelo();
    public static int contador=0;
    
    public controlador2(vista v, modelo m){
        this.v=v;
        this.m=m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {       
        v.herencias();
        v.crea_herencia.setEnabled(false);
        v.scroll.updateUI();
        contador++;
    }   
}
