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
    ArrayList <Integer> line2[];
    
    public void transforma_ecuaciones(int j, int n){
        Integer s_matriz[][] = new Integer[j][j];
        //Iguala z a 0 
        for(i=0;i<z_temp.size();i++)
            z.add(z_temp.get(i)*-1);        
        //Añade variables s 
        for(i=0;i<j;i++)
        {
            for(i1=0;i1<j;i1++)
            {
                if(i==i1)
                    s_matriz[i][i1]=1;
                else
                    s_matriz[i][i1]=0;
            }
        }
        for(i=0;i<j;i++)
        {
            for(i1=0;i1<j;i1++)
            {
                s.add(s_matriz[i][i1]);
            }
        }
            
    }
    public void crea_tabla(int j, int n){
        int h=0;
        int temp=j;
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
            h=h+j;
            temp=temp+j;
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
    public void nueva_tabla(int j, int n){
        int menor=100;
        int pivote,h,temporal;
        h=0;
        temporal=j;
        double temp[] = new double [j*n];
        int posicion = 0;
        //Determina el menor de z
        for(i=0;i<z.size();i++)
        {
            if (z.get(i)<menor){
                menor = z.get(i);
                posicion = i;
            }

        }
        //Determina el pivote
        for(i=0;i<resultados.size();i++)
        {
            temp[i]=resultados.get(i)/line[i].get(z.indexOf(menor)+1);
        }
        int div_menor = 1000;
        for(i=0;i<resultados.size();i++)
        {
            if (temp[i]<div_menor){
                div_menor = (int) temp[i];
                posicion = i;
            }
        }
        pivote=line[posicion].get(z.lastIndexOf(menor));
        //Empieza a crear la nueva tabla
        line2 = new ArrayList[n+s.size()+2];
        for(i=0;i<n+s.size()+2;i++)
            line2[i] = new ArrayList();
        ////////////////////////////////////
        for(i=0;i<line[posicion].size();i++)
        {
            line2[posicion].add(line[posicion].get(i)/pivote);            
        }
        ////////////////////////////////////
        for(i=0;i<j;i++)
        {
            line2[i].add(line[i].get(i));          
        }
        
    }
    public void calcula(int j, int n){
        transforma_ecuaciones(j,n);
        crea_tabla(j,n);
        nueva_tabla(j,n);
    }
}
