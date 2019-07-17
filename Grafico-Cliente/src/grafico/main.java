package grafico;

public class main {
    public static void main(String args[]){
        vista v = new vista();
        conexion t = new conexion();
        controlador1 c = new controlador1(v,t);
        controlador2 c2 = new controlador2(v,t);
        v.componentes();
        v.asigna_oyentes(c,c2);        
    }
}
