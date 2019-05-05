package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import uml.cuadros;
import uml.modelo;
import uml.vista;

public class controlador_fin implements ActionListener{
    public static int num_clases; 
    public static ArrayList<Integer> numero_atributos = new ArrayList<>();
    vista v = new vista();
    modelo m = new modelo();
    cuadros c = new cuadros();
    controlador c1 = new controlador(v,m);
    public static ArrayList <String> clases = new ArrayList<>();
    public static ArrayList <String> atributos = new ArrayList<>();
    public controlador_fin(vista v, modelo m){
        this.v=v;
        this.m=m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {   
        clases.clear();
        atributos.clear();
        num_clases= Integer.parseInt(v.num_clases.getText());
        texto();
        m.determina_privacidad();
        v.setVisible(false);
        c.componentes();
        c.oyentes(new controlador_back(c));  
    }   
    public void texto(){
        int i;
        
        
        for(i=0;i<num_clases*2;i++)
        {
            if(i%2==0)
                clases.add(v.cajas[i].getText());
            else
            {
                String[] arrOfStr;
                arrOfStr = v.cajas[i].getText().split("\n");
                numero_atributos.add(arrOfStr.length);
                atributos.addAll(Arrays.asList(arrOfStr));
                //System.out.println(atributos.get(1));
                
            }
                
        }
    }
}
