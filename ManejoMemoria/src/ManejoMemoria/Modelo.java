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
            Vista.g[i].setText(parts[i]);
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
    
    public void determina_espacio(String tipo){
        separa_datos();  
        int tip;
        tip=Integer.valueOf(tipo);
        if(tip==1)
            this.tipo_1();
        if(tip==2)
            this.tipo_2();
        if(tip==3)
            this.tipo_3();
        if(tip==4)
            this.tipo_4();
    }
    
    private static void removeIndex(String[] array, int index) {
        int i = index;
        for (; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = null;
    }
    
    public void tipo_1() {
        for(i=0;i<numero_bits.size();i++)
        {
            for(j=0;j<espacio.size();j++)
            {
                if(numero_bits.get(i)<=espacio.get(j))
                {
                    System.out.println("El valor es menor que "+espacio.get(j));
                    espacio.replace(j, espacio.get(j)-numero_bits.get(i));
                    
                    if(j==0){
                        Vista.g[i].setBounds(200, 258, 100, i*10);
                    }
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
    
    public void tipo_2(){
        int uso=0;
        for(i=0;i<numero_bits.size();i++)
        {
            if(numero_bits.get(i)<=espacio.get(uso))
            {
                System.out.println("El valor es menor que "+espacio.get(uso));
                espacio.replace(uso, espacio.get(uso)-numero_bits.get(i));
                uso++;               
            }
        }
        
        for(i=0;i<espacio.size();i++)
        {
            System.out.println(espacio.get(i));
        }
    }
    
    public void tipo_3(){
        
        for(i=0;i<numero_bits.size();i++)
        {
            int a = 0,b = 0,c = 0;
            a=espacio.get(0)-numero_bits.get(i);
            b=espacio.get(1)-numero_bits.get(i);
            c=espacio.get(2)-numero_bits.get(i);
            if(a<0)
                a=10000000;
            if(b<0)
                b=10000000;
            if(c<0)
                c=10000000;
            if(a>b && b<c)
            {
                System.out.println("El valor escogido es b");
                espacio.replace(1, espacio.get(1)-numero_bits.get(i));
            }
            if(a<b && a<c)
            {
                System.out.println("El valor escogido es a");
                espacio.replace(0, espacio.get(0)-numero_bits.get(i));
            }
            if(c<b && c<a)
            {
                System.out.println("El valor escogido es c");
                espacio.replace(2, espacio.get(2)-numero_bits.get(i));
            }
        }
        
        
        for(i=0;i<espacio.size();i++)
        {
            System.out.println(espacio.get(i));
        }
    }
    
    public void tipo_4(){
        int a = 0,b = 0,c = 0;
        for(i=0;i<numero_bits.size();i++)
        {
            a=numero_bits.get(i)-espacio.get(0);
            b=numero_bits.get(i)-espacio.get(1);
            c=numero_bits.get(i)-espacio.get(2);
            if(a>b && b<c)
            {
                System.out.println("El valor escogido es b");
                espacio.replace(1, espacio.get(1)-numero_bits.get(i));
            }
            if(a<b && a<c)
            {
                System.out.println("El valor escogido es a");
                espacio.replace(0, espacio.get(0)-numero_bits.get(i));
            }
            if(c<b && c<a)
            {
                System.out.println("El valor escogido es c");
                espacio.replace(2, espacio.get(2)-numero_bits.get(i));
            }
        }
        
        
        for(i=0;i<espacio.size();i++)
        {
            System.out.println(espacio.get(i));
        }
    }
    
}
