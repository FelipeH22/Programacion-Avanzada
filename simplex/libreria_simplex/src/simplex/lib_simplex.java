package simplex;

import java.util.ArrayList;

public class lib_simplex {
    int i, i1;
    ArrayList <Integer> z = new ArrayList<>();
    ArrayList <Integer> z_temp = new ArrayList<>();
    ArrayList <Integer> resultados = new ArrayList<>();
    ArrayList <Integer> ecuacion[];
    ArrayList <Integer> ecuaciones = new ArrayList<>();
    ArrayList <Integer> s = new ArrayList<>();
    ArrayList <Integer> line[];
    
    public void transforma_ecuaciones(int j, int n){
        Integer s_matriz[][] = new Integer[j][n];
        //Iguala z a 0 
        for(i=0;i<z_temp.size();i++)
            z.add(z_temp.get(i)*-1);        
        //Añade variables s 
        for(i=0;i<j;i++)
        {
            for(i1=0;i1<n;i1++)
            {
                if(i==i1)
                    s_matriz[i][i1]=1;
                else
                    s_matriz[i][i1]=0;
            }
        }
        for(i=0;i<j;i++)
        {
            for(i1=0;i1<n;i1++)
            {
                s.add(s_matriz[i][i1]);
            }
        }
            
    }
    public void crea_tabla(int j, int n){
        int h=0;
        int temp=n;
        line = new ArrayList[n+s.size()+2];
        for(i=0;i<n+s.size()+2;i++)
            line[i] = new ArrayList(); 
        for(i=0;i<j;i++)
        {
            line[i].add(0);
        }
        line[j].add(0,1);
        for(i=0;i<j;i++)
        {
            line[i].addAll(ecuacion[i]);
            for(i1=h;i1<temp;i1++)
                line[i].add(s.get(i1));        
            line[i].add(resultados.get(i));
            h=h+3;
            temp=temp+3;
        }
        for(i=0;i<z.size();i++)
        {
            line[j].add(z.get(i));
        }
        for(i=0;i<=n;i++)
        {
            line[j].add(0);
        }
        
        for(i=0;i<=j;i++)
        {
            for(i1=0;i1<line[i].size();i1++)
            {
                System.out.print(line[i].get(i1)+" ");
            }
            System.out.print("\n");
        }
            
    }
    public void calcula(int j, int n){
        transforma_ecuaciones(j,n);
        crea_tabla(j,n);
    }
}
