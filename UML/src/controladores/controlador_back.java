package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uml.cuadros;
import uml.vista;

public class controlador_back implements ActionListener{
    cuadros c = new cuadros();
    vista v = new vista();
    
    public controlador_back(cuadros c){
        this.c=c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i;
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            controlador_fin.agrega.clear();
            controlador_fin.atributos[i].clear();
            controlador_fin.clases[i].clear();
            controlador_fin.compos.clear();
            controlador_fin.instancias[i].clear();
            controlador_fin.num_clases=0;
            controlador_fin.numero_atributos.clear();
            controlador_fin.herencias.clear();
        }
        c.frame.setVisible(false);
        v.setVisible(true);
        v.componentes();  
    }
}
