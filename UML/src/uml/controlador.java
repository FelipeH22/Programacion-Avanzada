package uml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class controlador implements ActionListener{
        vista v = new vista();
        modelo m = new modelo();
        public static int n,j;

        controlador(vista v, modelo m) {
            this.v=v;
            this.m=m;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            v.scroll.updateUI();
            v.panel.removeAll();
            v.componentes();              
            v.cajas_texto(Integer.parseInt(v.num_clases.getText()));
            v.scroll.updateUI();
        }   

            
    }

   
    
    
