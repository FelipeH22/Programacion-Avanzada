package simplex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador2 implements ActionListener{
    vista v = new vista();
    lib_simplex t = new lib_simplex();
    int i,i1;

    controlador2(vista v, lib_simplex t) {
        this.v=v;
        this.t=t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        t.z.clear();
        t.resultados.clear();  
        t.ecuaciones.clear();
        t.ecuacion1.clear();
        t.ecuacion2.clear();
        t.ecuacion3.clear();
        t.ecuacion4.clear();
        t.ecuacion5.clear();
        t.ecuacion6.clear();
        t.ecuacion7.clear();
        t.ecuacion8.clear();
        t.ecuacion9.clear();
        t.ecuacion10.clear();       
        guarda_datos();
        t.calcula(controlador.j,controlador.n);
        
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
        for(i=0;i<t.ecuaciones.size();i++)
        {
            if(i<controlador.n)
                t.ecuacion1.add(t.ecuaciones.get(i));
            if(i>=controlador.n && i< controlador.n*2)
                t.ecuacion2.add(t.ecuaciones.get(i));
            if(i>=controlador.n*2 && i< controlador.n*3)
                t.ecuacion3.add(t.ecuaciones.get(i));
            if(i>=controlador.n*3 && i< controlador.n*4)
                t.ecuacion4.add(t.ecuaciones.get(i));
            if(i>=controlador.n*4 && i< controlador.n*5)
                t.ecuacion5.add(t.ecuaciones.get(i));
            if(i>=controlador.n*5 && i< controlador.n*6)
                t.ecuacion6.add(t.ecuaciones.get(i));
            if(i>=controlador.n*6 && i< controlador.n*7)
                t.ecuacion7.add(t.ecuaciones.get(i));
            if(i>=controlador.n*7 && i< controlador.n*8)
                t.ecuacion8.add(t.ecuaciones.get(i));
            if(i>=controlador.n*9 && i< controlador.n*10)
                t.ecuacion9.add(t.ecuaciones.get(i));
            if(i>=controlador.n*11 && i< controlador.n*12)
                t.ecuacion10.add(t.ecuaciones.get(i));
        }
    }
    

           
}
