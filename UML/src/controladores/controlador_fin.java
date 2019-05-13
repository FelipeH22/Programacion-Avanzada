package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import uml.cuadros;
import uml.modelo;
import uml.vista;

public class controlador_fin implements ActionListener{
    int i,j,h;
    public static int n;
    int n_atributos,n_clases;
    public static int num_clases; 
    public static ArrayList<Integer> numero_atributos = new ArrayList<>();
    vista v = new vista();
    modelo m = new modelo();
    cuadros c = new cuadros();
    controlador c1 = new controlador(v,m);
    public static ArrayList <String> clases[];
    public static ArrayList <String> atributos[];
    public static ArrayList <String> instancias[];    
    public static ArrayList <String> herencias = new ArrayList<>();
    public static List<Map<String,String>> compos = new ArrayList<Map<String,String>>();
    public static List<Map<String,String>> agrega = new ArrayList<Map<String,String>>();
    public static List<Map<String,String>> implementss = new ArrayList<Map<String,String>>();
    public static List<Map<String,String>> extendss = new ArrayList<Map<String,String>>();
    public controlador_fin(vista v, modelo m){
        this.v=v;
        this.m=m;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        num_clases= Integer.parseInt(v.num_clases.getText());
        clases = new ArrayList[num_clases];
        atributos = new ArrayList[num_clases];
        instancias = new ArrayList[num_clases];
        for(i=0;i<num_clases;i++)
        {
            clases[i] = new ArrayList();
            atributos[i] = new ArrayList();
            instancias[i] = new ArrayList();
        }       
        texto();
        leer_herencias();
        m.determina_privacidad();
        m.evalua_instancias();
        m.llena_arrays();
        m.evalua_composicion();   
        m.evalua_herencias();
        m.evalua_cardinalidad();
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
    
    public void leer_herencias(){
        String[] arrOfStr3;
        arrOfStr3 = v.herencias.getText().split("\n");
        herencias.addAll(Arrays.asList(arrOfStr3));
        map_size();
    }
    
    public void map_size(){
        for(i=0;i<herencias.size();i++)
        {
            implementss.add(new HashMap<>());
            implementss.add(new HashMap<>());
        }
        for(i=0;i<num_clases;i++)
        {
            compos.add(new HashMap<>());
            agrega.add(new HashMap<>());
        }
    }
}
