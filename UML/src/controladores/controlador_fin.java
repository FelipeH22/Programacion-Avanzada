package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import uml.cuadros;
import uml.modelo;
import uml.vista;

public class controlador_fin implements ActionListener{
    int i,j,h;
    int n_atributos,n_clases;
    public static int num_clases; 
    public static ArrayList<Integer> numero_atributos = new ArrayList<>();
    vista v = new vista();
    modelo m = new modelo();
    cuadros c = new cuadros();
    controlador c1 = new controlador(v,m);
    public static ArrayList <String> clases[];
    public static ArrayList <String> compo = new ArrayList<>();
    public static ArrayList <String> agrega = new ArrayList<>();
    public controlador_fin(vista v, modelo m){
        this.v=v;
        this.m=m;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        num_clases= Integer.parseInt(v.num_clases.getText());
        this.clases = new ArrayList[this.num_clases];
        for(i=0;i<num_clases;i++)
        {
            clases[i] = new ArrayList();
        }       
        texto();
        m.determina_privacidad();
        m.evalua_instancias();
        m.evalua_composicion();
        v.setVisible(false);
        c.componentes();
        c.oyentes(new controlador_back(c));  
    }   
    public void texto(){       
        n_clases=0;
        n_atributos=1;
        for(i=0;i<num_clases;i++)
        {
            //CLASE
            String[] arrOfStr2;
            arrOfStr2 = v.cajas[n_clases].getText().split("\n");
            clases[i].addAll(Arrays.asList(arrOfStr2));
            
            //Atributos
            String[] arrOfStr;
            arrOfStr = v.cajas[n_atributos].getText().split("\n");
            clases[i].addAll(Arrays.asList(arrOfStr));
            n_clases=n_clases+2;
            n_atributos=n_atributos+2;
                      
        }        
    }
}
