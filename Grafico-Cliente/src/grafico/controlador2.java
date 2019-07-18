package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class controlador2 implements ActionListener{

    vista v = new vista();
    conexion t = new conexion();
    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();
    ArrayList<String> inecuacion = new ArrayList<>();
    ArrayList<Integer> numero = new ArrayList<>();
    int i;
    
    controlador2(vista v, conexion t) {
            this.v=v;
            this.t=t;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(i=0;i<Integer.valueOf(v.num_ecuaciones.getText());i++)
        {
            x.add(Integer.valueOf(v.ecuaciones_x[i].getText()));
            y.add(Integer.valueOf(v.ecuaciones_y[i].getText()));
            inecuacion.add(v.menor[i].getText());
            numero.add(Integer.valueOf(v.numero[i].getText()));
        }
        t.initClient();
        /*try {
            t.mensaje.writeUTF("HOLA");
        } catch (IOException ex) {
            Logger.getLogger(controlador2.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
