package ley_demeter;

import java.util.ArrayList;

public class modelo {
    int a,b,c,d;
    String s;
    vista vista = new vista();
    ArrayList<Integer> divisores = new ArrayList<>();
    
    
    public void almacena_variables(){
        //a = parseInt(vista.a.getText());
        //b = parseInt(vista.b.getText());
        //c = parseInt(vista.c.getText());      
        d = Integer.parseInt(vista.d.getText());
    }
    public void calcula_divisores(){
        for(int i=1;i<=d;i++)
        {
            divisores.add(d%i);
        }
    }
    public void muestra_divisores(){
        for(int i=0;i<divisores.size();i++)
        {
            System.out.println(divisores.get(i));
        }
    }
}
