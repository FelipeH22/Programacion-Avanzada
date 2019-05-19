package rsa;

public class modelo extends modelo_abstract implements modelo_interface{
    
    @Override
    public void calcula(){
        leer_variables();       
        calcula_s_z();
        recorre_array();
        //for(i=0;i<palabra.length();i++)
        //{
            bits();
            ASCII();
            encriptado();
            desencriptado();
        //}
        
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
    }
    
    @Override
    public void ASCII(){
        for (int x=0;x<palabra.length();x++){
            arregloASCII[x] = palabra.codePointAt(x);
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
        int []arreglo2 = new int[k];
        arreglo2[0]=arregloASCII[0];
        for(int j=1; j<k; j++){
            arreglo2[j]=((( arreglo2[j-1]) % z)*((arreglo2[j-1]) % z)) % z;
        }
        k=k-1;
        int j=0;
        while(j<=k)
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
        System.out.println(palabra + " = "+numencriptado);
    
    }
    @Override
    public void desencriptado(){
        
    }
    @Override
    public void leer_variables(){
        p=controlador.p;
        q=controlador.q;
        n=controlador.n;
        palabra=controlador.palabra;
    }
    
}
