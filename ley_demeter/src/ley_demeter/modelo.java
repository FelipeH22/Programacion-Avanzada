package ley_demeter;

import java.util.ArrayList;

public class modelo {
    vista v = new vista();
    int raiz = 0;
    ArrayList<Integer> cocientes = new ArrayList<>();
    ArrayList<Integer> divisores = new ArrayList<>();
    ArrayList<Integer> l1 = new ArrayList<>();
    ArrayList<Integer> l2 = new ArrayList<>();
    
    public void evalua(int a, int b, int c, int d){
        if(controlador.contador<1)
            llena_arrays(a,b,c,d);
        else
        {
            divisores.clear();
            llena_arrays(a,b,c,d);
        }
        ruffini();
    }

    public void llena_arrays(int a, int b, int c, int d){
        //Llena Divisores
        for (int i = 1 ; i <= d ; i++)
        {
            if (d % i == 0)
            {
                divisores.add(i);
                divisores.add(i*-1);
            }
        }
        //Llena Cocientes
        cocientes.add(a);
        cocientes.add(b);
        cocientes.add(c);
        cocientes.add(d);       
    }
    public void ruffini(){
        int i,temp=1;
        int div = 0;
        
        while(temp!=0)
        {
            l1.add(0);
            l2.add(cocientes.get(0));
            for(i=0;i<3;i++)
            {
                l1.add(divisores.get(div)*l2.get(i));
                l2.add(l1.get(i+1)+cocientes.get(i+1));
                
            } 
            raiz=divisores.get(div);
            temp=l2.get(3);
            div++;
            l1.clear();
            l2.clear();
        }    
        /*for(i=0;i<l2.size();i++)
        {
            System.out.println(l2.get(i));
        }*/
    }
    
    public void formula(){
        
    }
}
