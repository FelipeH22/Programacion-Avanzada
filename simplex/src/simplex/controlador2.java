package simplex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class controlador2 implements ActionListener{
    vista v = new vista();
    lib_simplex t = new lib_simplex();
    int i,i1;
    double resultado;
    int maximo;
    int contador = 0;

    controlador2(vista v, lib_simplex t) {
        this.v=v;
        this.t=t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(contador>0)
        {
            t.z_temp.clear();
            t.z.clear();
            t.resultados.clear(); 
            t.ecuaciones.clear();  
            for(i=0;i<controlador.n;i++)
            {
                t.ecuacion[i].clear();
            }
        }
           
        guarda_datos();
        t.transforma_ecuaciones(controlador.j, controlador.n);
        t.crea_tabla(controlador.j, controlador.n);
        t.calcula(controlador.j, controlador.n);
        maximo=t.obtener_max();
        resultado=t.obtener_result();
        
        v.resultado.setText("Se necesitan "+ resultado + " para un máximo de "+maximo);
        
        contador++;
        
    }
    public void guarda_datos(){
        //Guarda los valores de z
        for(i=0;i<controlador.n;i++)
        {            
            t.z_temp.add(Integer.parseInt(v.variables[i].getText()));
        }
        //Guarda los valores de los resultados
        for(i=0;i<controlador.j;i++)
        {            
            t.resultados.add(Integer.parseInt(v.resultados[i].getText()));
        }   
        //Guarda los coeficientes de las inecuaciones
        for(i=0;i<controlador.j;i++)
        {            
            for(i1=0;i1<controlador.n;i1++)
            {            
                t.ecuaciones.add(Integer.parseInt(v.inecuaciones[i][i1].getText()));
            }
        }
        //Divide los coeficientes en los arrays de sus ecuaciones respectivas
        t.ecuacion = new ArrayList[10];
        for(i=0;i<10;i++)
            t.ecuacion[i] = new ArrayList(); 
        
        for(i=0;i<t.ecuaciones.size();i++)
        {
            if(i<controlador.n)
                t.ecuacion[0].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n && i< controlador.n*2)
                t.ecuacion[1].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n*2 && i< controlador.n*3)
                t.ecuacion[2].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n*3 && i< controlador.n*4)
                t.ecuacion[3].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n*4 && i< controlador.n*5)
                t.ecuacion[4].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n*5 && i< controlador.n*6)
                t.ecuacion[5].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n*6 && i< controlador.n*7)
                t.ecuacion[6].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n*7 && i< controlador.n*8)
                t.ecuacion[7].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n*9 && i< controlador.n*10)
                t.ecuacion[8].add(Double.valueOf(t.ecuaciones.get(i)));
            if(i>=controlador.n*11 && i< controlador.n*12)
                t.ecuacion[9].add(Double.valueOf(t.ecuaciones.get(i)));
        }

        
    }
    

           
}
