/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asigancion_memoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Modelo {
    Map<Integer,Integer> espacio = new HashMap<>();
    ArrayList <Integer> numero_bits = new ArrayList<>();
    String parts[];
    int contador=0;
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
            Vista.g[contador].setText(parts[i]);
            bits = parts[i].split(" ");            
            for(j=0;j<bits.length;j++)
            {
                if(j%2==0)
                    removeIndex(bits,j);
            }

            bits[h]=bits[h].replace("m", "");          
            numero_bits.add(Integer.valueOf(bits[h]));
            contador++;
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
        int contador1=8;
        int contador2=10;
        int contador3=4;
        int y0=258;
        int y1=356;
        int y2=534;
        for(i=0;i<numero_bits.size();i++)
        {
            for(j=0;j<espacio.size();j++)
            {
                if(numero_bits.get(i)<=espacio.get(j))
                {
                    espacio.replace(j, espacio.get(j)-numero_bits.get(i));
                    if(j==0){
                        if(espacio.get(j)<contador1){
                            contador1=contador1-espacio.get(j);
                            Vista.g[i].setBounds(400, y0, 100,contador1*10);
                            y0=y0+contador1*10;
                            contador1=espacio.get(j);
                        }
                    }
                    if(j==1){
                            if(espacio.get(j)<contador2){
                            contador2=contador2-espacio.get(j);
                            Vista.g[i].setBounds(400, y1, 100,contador2*10);
                            y1=y1+contador2*10;
                            contador2=espacio.get(j);
                        }
                    }
                    if(j==2){
                            if(espacio.get(j)<contador3){
                            contador3=contador3-espacio.get(j);
                            Vista.g[i].setBounds(400, y2, 100,contador3*10);
                            y2=y2+contador3*10;
                            contador3=espacio.get(j);
                            }
                    }
                        
                    break;
                }
                else{
                    JOptionPane.showMessageDialog(null, "No hay memoria disponible");
                    break;
                }
        }       
    }}
    
    public void tipo_2(){
        int uso=0;
        int contador1=8;
        int contador2=10;
        int contador3=4;
        int y0=258;
        int y1=356;
        int y2=534;
        for(i=0;i<numero_bits.size();i++)
        {
            if(numero_bits.get(i)<=espacio.get(uso))
            {
                espacio.replace(uso, espacio.get(uso)-numero_bits.get(i));
                if(uso==0){
                    if(espacio.get(uso)<contador1){
                        contador1=contador1-espacio.get(uso);
                        Vista.g[i].setBounds(400, y0, 100,contador1*10);
                        y0=y0+contador1*10;
                        contador1=espacio.get(uso);
                        }
                }
                if(uso==1){
                    if(espacio.get(uso)<contador2){
                        contador2=contador2-espacio.get(uso);
                        Vista.g[i].setBounds(400, y1, 100,contador2*10);
                        y1=y1+contador2*10;
                        contador2=espacio.get(uso);
                        }
                }
                if(uso==2){
                    if(espacio.get(uso)<contador3){
                        contador3=contador3-espacio.get(uso);
                        Vista.g[i].setBounds(400, y2, 100,contador3*10);
                        y2=y2+contador3*10;
                        contador3=espacio.get(uso);
                        }
                }
                uso++; 
                            
                
            }
            else
            {
                if(uso>2)
                {
                    JOptionPane.showMessageDialog(null, "No hay memoria disponible");
                    break;
                }
                else
                    uso++;
            }
        }
        
    }
    
    public void tipo_3(){
        int contador1=8;
        int contador2=10;
        int contador3=4;
        int y0=258;
        int y1=356;
        int y2=534;
        for(i=0;i<numero_bits.size();i++)
        {
            int a = 0,b = 0,c = 0;
            a=espacio.get(0)-numero_bits.get(i);
            b=espacio.get(1)-numero_bits.get(i);
            c=espacio.get(2)-numero_bits.get(i);
            if(a<0&&b<0&&c<0)
            {
                JOptionPane.showMessageDialog(null, "No hay memoria disponible");
                break;
            }
            else
            {
               if(a<0)
                a=100000000;
            if(b<0)
            {
                b=10000000;
            }
                
            if(c<0)
            {
                c=10000000;
            }
                
            if(a>b && b<c)
            {
                espacio.replace(1, espacio.get(1)-numero_bits.get(i));
                if(1==1){
                    if(espacio.get(1)<contador2){
                        contador2=contador2-espacio.get(1);
                        Vista.g[i].setBounds(400, y1, 100,contador2*10);
                        y1=y1+contador2*10;
                        contador2=espacio.get(1);
                        }
                }
            }
            if(a<b && a<c)
            {
                espacio.replace(0, espacio.get(0)-numero_bits.get(i));
                if(0==0){
                    if(espacio.get(0)<contador1){
                        contador1=contador1-espacio.get(0);
                        Vista.g[i].setBounds(400, y0, 100,contador1*10);
                        y0=y0+contador1*10;
                        contador1=espacio.get(0);
                        }
                }
            }
            if(c<b && c<a)
            {
                espacio.replace(2, espacio.get(2)-numero_bits.get(i));
                if(2==2){
                    if(espacio.get(2)<contador3){
                        contador3=contador3-espacio.get(2);
                        Vista.g[i].setBounds(400, y2, 100,contador3*10);
                        y2=y2+contador3*10;
                        contador3=espacio.get(2);
                    }
                }
            } 
            }
            
        }
    }
    
    public void tipo_4(){
        int contador1=8;
        int contador2=10;
        int contador3=4;
        int y0=258;
        int y1=356;
        int y2=534;
        int a = 0,b = 0,c = 0;
        for(i=0;i<numero_bits.size();i++)
        {
            a=numero_bits.get(i)-espacio.get(0);
            b=numero_bits.get(i)-espacio.get(1);
            c=numero_bits.get(i)-espacio.get(2);
            if(numero_bits.get(i)>espacio.get(0)&&numero_bits.get(i)>espacio.get(1)&&numero_bits.get(i)>espacio.get(2))
                JOptionPane.showMessageDialog(null, "No hay memoria disponible");
            else
            {
                if(a>b && b<c)
            {
                espacio.replace(1, espacio.get(1)-numero_bits.get(i));
                if(1==1){
                    if(espacio.get(1)<contador2){
                        contador2=contador2-espacio.get(1);
                        Vista.g[i].setBounds(400, y1, 100,contador2*10);
                        y1=y1+contador2*10;
                        contador2=espacio.get(1);
                        }
                }
            }
            if(a<b && a<c)
            {
                espacio.replace(0, espacio.get(0)-numero_bits.get(i));
                if(0==0){
                    if(espacio.get(0)<contador1){
                        contador1=contador1-espacio.get(0);
                        Vista.g[i].setBounds(400, y0, 100,contador1*10);
                        y0=y0+contador1*10;
                        contador1=espacio.get(0);
                        }
                }
            }
            if(c<b && c<a)
            {
                espacio.replace(2, espacio.get(2)-numero_bits.get(i));
                if(2==2){
                   if(espacio.get(2)<contador3){
                       contador3=contador3-espacio.get(2);
                       Vista.g[i].setBounds(400, y2, 100,contador3*10);
                       y2=y2+contador3*10;
                       contador3=espacio.get(2);
                   }
               }
            }
            }
            
        }
    }
    
}
