package factorial;

public class modelo {
    
    double resultado;
    vista v = new vista();
    public double resultado(double num){
        resultado=1;
        for(int i=1;i<=num;i++)
        {
            resultado = resultado*i;
        }
        return resultado;
    }
    
}
