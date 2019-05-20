package rsa;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.security.krb5.Confounder.bytes;

public class modelo extends modelo_abstract implements modelo_interface{
    
    @Override
    public void calcula(){
        leer_variables();       
        calcula_s_z();
        recorre_array();
        for(i=0;i<palabra.length();i++)
        {
            bits();
            ASCII();
            encriptado();    
        }
        desencriptado();
    }
    
    @Override
    public void recorre_array(){
        letras = palabra.toCharArray();
    }
    
    @Override 
    public void calcula_s_z(){
        fi=(p-1)*(q-1);
        z = p * q;
        while((n * s) % fi != 1){
            s=s+1;
        }
        clavePrivada=s;
    }
    
    @Override
    public void ASCII(){
        for (int x=0;x<palabra.length();x++){
            arregloASCII[x] = palabra.codePointAt(x);
            arregloletras[x]= palabra.charAt(x);
            //System.out.println(palabra.charAt(x) + " = " + palabra.codePointAt(x));;   
        }       
    }
    
    @Override
    public void bits(){
        //System.out.println(Integer.toBinaryString(n));
        while(n > 0) {
        if(n % 2 != 0) {
            arreglo[k] = 1;
        }else{
            arreglo[k] = 0;
        }
        k++; // para acceder el arreglo a[]
        n = n >> 1; // para acceder al próximo bit
        }
    }
    
    @Override
    public void encriptado(){
        double []arreglo2 = new double[k];
        arreglo2[0]=arregloASCII[ascii];
        for(int j=1; j<k; j++){
            arreglo2[j]=((( arreglo2[j-1]) % z)*((arreglo2[j-1]) % z)) % z;
        }
        int j=0;
        while(j<k)
        {
            if(arreglo[j] == 1){
                if(j == 0)
          
                {
                    numencriptado = arreglo2[j];
                }
                else{
                    numencriptado = (numencriptado * arreglo2[j])%z;
                }
            }else{
                
            }
            j++;
        }
        System.out.println(arregloletras[ascii] + " = "+numencriptado);
        ascii++;
    }
    
    @Override
    public void desencriptado(){
        /*for(i=0;i<this.arreglo.length;i++)
        {
            arreglo[i]=0;
        }
        for(i=0;i<this.arreglo2.length;i++)
        {
            arreglo2[i]=0;
        }
        for(i=0;i<this.arregloASCII.length;i++)
        {
            arregloASCII[i]=0;
        }
        System.out.println("Desencriptando.....");
        z=s;
        this.ASCII();
        this.bits();
        this.encriptado();*/
        int asciii = palabra.toCharArray()[0];
        System.out.println("resultado = "+asciii);
        
        
    }
    
    @Override
    public void bitsS(){
        
    }
    @Override
    public void leer_variables(){
        p=controlador.p;
        q=controlador.q;
        n=controlador.n;
        palabra=controlador.palabra;
    }
    
}
