package ley_demeter;

public class Ley_demeter {

    public static void main(String[] args) {
        
        vista v = new vista();
        modelo m = new modelo();
        controlador u = new controlador(v,m);
        v.asigna_oyentes(u);
        v.componentes();
    }
    
}
