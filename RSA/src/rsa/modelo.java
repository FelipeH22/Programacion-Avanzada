package rsa;

public class modelo extends modelo_abstract implements modelo_interface{
    
    @Override
    public void calcula(){
        leer_variables();
    }
    
    @Override
    public void leer_variables(){
        p=controlador.p;
        q=controlador.q;
        n=controlador.n;
        palabra=controlador.palabra;
        
    }
}
