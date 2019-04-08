package simplex;

//import simplex.*;
public class Simplex {

    public static void main(String[] args) {
        vista v = new vista();
        lib_simplex lib = new lib_simplex();
        controlador u = new controlador(v,lib);
        v.asigna_oyentes(u);
        v.componentes();
    }
    
}
