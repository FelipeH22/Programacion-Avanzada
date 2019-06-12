package ManejoMemoria;

import ManejoMemoria.Modelo;
import ManejoMemoria.Vista;

public class ManejoMemoria {

    public static void main(String[] args) {
        Vista  v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(v,m);
        v.iniciarComponentes();
        v.oyentes(c);        
    }
    
}
