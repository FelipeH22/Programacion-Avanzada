package ManejoMemoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Modelo {
    Map<Integer,Integer> espacio = new HashMap<>();
    ArrayList <Integer> numero_bits = new ArrayList<>();
    String parts[];
    int i,j,h;
    
    public void llena_mapas(){
        espacio.put(0,8);
        espacio.put(1,10);
        espacio.put(2,4);
    }
    
    public void separa_datos(){
        parts = Controlador.txt.split(",");
        
        for(i=0;i<parts.length;i++)
        {
            String bits[];
            bits = parts[i].split(" ");            
            for(j=0;j<bits.length;j++)
            {
                if(j%2==0)
                    removeIndex(bits,j);
            }

            bits[h]=bits[h].replace("m", "");
            System.out.println(bits[h]);           
            numero_bits.add(Integer.valueOf(bits[h]));

        }
        
    }
    
    public void determina_espacio(){
        separa_datos();
        for(i=0;i<numero_bits.size();i++)
        {
            for(j=0;j<espacio.size();j++)
            {
                if(numero_bits.get(i)<=espacio.get(j))
                {
                    System.out.println("El valor es menor que "+espacio.get(j));
                    espacio.replace(j, espacio.get(j)-numero_bits.get(i));
                    break;
                    
                }
                else
                    System.out.println("No es menor que "+espacio.get(j));
            }
        }
        
        for(i=0;i<espacio.size();i++)
        {
            System.out.println(espacio.get(i));
        }
    }
    
    private static void removeIndex(String[] array, int index) {
        int i = index;
        for (; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = null;
    }
}
