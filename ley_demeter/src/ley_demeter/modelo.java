package ley_demeter;

import java.util.ArrayList;

public class modelo {
    vista v = new vista();
    int raiz = 0;
    int r2,r3;
    int i;
    ArrayList<Integer> cocientes = new ArrayList<>();
    ArrayList<Integer> divisores = new ArrayList<>();
    ArrayList<Integer> l1 = new ArrayList<>();
    ArrayList<Integer> l2 = new ArrayList<>();
    
    public void limpia(int a, int b, int c, int d){
        divisores.clear();
        cocientes.clear();
        l1.clear();
        l2.clear();
        r2=0;
        r3=0;
        llena_arrays(a,b,c,d);
        raices();
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
    
    public void raices(){
        ruffini();
        formula();
    }
    
    public void ruffini(){
        int temp=1;
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
            if(temp!=0)
            {
                l1.clear();
                l2.clear();
            }
            
        }    
        /*for(i=0;i<l2.size();i++)
        {
            System.out.println(l2.get(i));
        }*/
    }
    
    public void formula(){
        int a,b,c,discriminante;
        a=l2.get(0);
        b=l2.get(1);
        c=l2.get(2);
        discriminante=(b*b-(4*a*c));
        if(discriminante>=0)
        {
            r2=(int)(-b+Math.sqrt(discriminante)/2*a);
            r3=(int)(-b-Math.sqrt(discriminante)/2*a);
        }
        else
            System.out.println("Determinante Negativo");
        
    }
}
