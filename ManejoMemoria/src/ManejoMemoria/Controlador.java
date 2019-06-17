package ManejoMemoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    Vista v = new Vista();
    Modelo t = new Modelo();
    public static String txt;
    public static String tipo;
    
    public Controlador(Vista v, Modelo t){
        this.v=v;
        this.t=t;
    }
        
    @Override
    public void actionPerformed (ActionEvent ae){
        txt = v.cajatexto.getText();
        tipo = v.cajatexto2.getText();
        t.llena_mapas();
        t.determina_espacio(tipo);
    }
    
}
