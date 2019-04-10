package simplex;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class controlador implements ActionListener{
        vista v = new vista();
        lib_simplex t = new lib_simplex();
        public static int n,j;

        controlador(vista v, lib_simplex t) {
            this.v=v;
            this.t=t;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            v.panel.removeAll();
            v.componentes();
            n = Integer.parseInt(v.num_variables.getText());
            j = Integer.parseInt(v.num_ecuaciones.getText());
            v.variables(n);
            v.inecuaciones(j, n);
        }   

            
    }

   
    
    

