package simplex;

import java.util.ArrayList;

public class lib_simplex {
    int i, i1;
    ArrayList <Integer> z = new ArrayList<>();
    ArrayList <Integer> z_temp = new ArrayList<>();
    ArrayList <Integer> resultados = new ArrayList<>();
    ArrayList <Integer> ecuacion1 = new ArrayList<>();
    ArrayList <Integer> ecuacion2 = new ArrayList<>();
    ArrayList <Integer> ecuacion3 = new ArrayList<>();
    ArrayList <Integer> ecuacion4 = new ArrayList<>();
    ArrayList <Integer> ecuacion5 = new ArrayList<>();
    ArrayList <Integer> ecuacion6 = new ArrayList<>();
    ArrayList <Integer> ecuacion7 = new ArrayList<>();
    ArrayList <Integer> ecuacion8 = new ArrayList<>();
    ArrayList <Integer> ecuacion9 = new ArrayList<>();
    ArrayList <Integer> ecuacion10 = new ArrayList<>();
    ArrayList <Integer> ecuaciones = new ArrayList<>();
    ArrayList <Integer> s = new ArrayList<>();
    
    public void transforma_ecuaciones(int j, int n){
        //Iguala z a 0 
        for(i=0;i<z_temp.size();i++)
            z.add(z_temp.get(i)*-1);        
        //Añade variables s 
        for(i=0;i<j;i++)
            s.add(1);
    }
    public void crea_tabla(){
        
    }
}
