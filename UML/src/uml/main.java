package uml;

public class main {

    public static void main(String[] args) {
        vista v = new vista();
        modelo m = new modelo();
        controlador c = new controlador(v,m);
        controlador_fin cf = new controlador_fin(v,m);
        controlador2 c2 = new controlador2(v,m);
        v.componentes();
    }
    
}
