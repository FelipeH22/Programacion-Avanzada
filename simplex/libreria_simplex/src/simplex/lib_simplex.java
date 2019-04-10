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
        //Iguala z a 0 
        for(i=0;i<z_temp.size();i++)
            z.add(z_temp.get(i)*-1);        
        //Añade variables s 
        for(i=0;i<j;i++)
        {
            s.add(0);
            s.add(i,1);
            s.add(0);
        }
            
    }
    public void crea_tabla(int j, int n){
        line = new ArrayList[n+s.size()+2];
        for(i=0;i<n+s.size()+2;i++)
            line[i] = new ArrayList(); 
        for(i=0;i<j;i++)
        {
            line[i].add(0);
        }
        line[j].add(1);
        for(i=0;i<j;i++)
        {
            line[i].addAll(ecuacion[i]);
            line[i].add(s.get(i));
            line[i].add(resultados.get(i));
        }
        for(i=0;i<line[1].size();i++)
            System.out.println(line[1].get(i));
            
    }
    public void calcula(int j, int n){
        transforma_ecuaciones(j,n);
        crea_tabla(j,n);
    }
}
