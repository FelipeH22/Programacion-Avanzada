package uml;

public class main {

    public static void main(String[] args) {
       vista v = new vista();
       modelo m = new modelo();
       controlador c = new controlador(v,m);
       v.componentes();
       v.oyentes(c);
    }
    
}
