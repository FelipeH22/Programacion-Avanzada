package factorial;

public class Factorial {

    public static void main(String[] args) {
        vista v = new vista();
        modelo m = new modelo();
        controlador c = new controlador(v,m);
        v.elementos();
        v.listener(c);
    }
    
}
