package uml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class controlador implements ActionListener{
        public int num_clases;
        vista v = new vista();
        modelo m = new modelo();
        public static int n,j;

        controlador(vista v, modelo m) {
            this.v=v;
            this.m=m;
        }

        @Override
        public void actionPerformed(ActionEvent e) {    
            num_clases=Integer.parseInt(v.num_clases.getText());
            v.cajas_texto(num_clases);
            v.scroll.updateUI();
        }   

            
    }

   
    
    
