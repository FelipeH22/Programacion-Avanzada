package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador1 implements ActionListener{

    vista v = new vista();
    conexion t = new conexion();
    public int valor_x;
    public int valor_y;
    
    controlador1(vista v, conexion t) {
            this.v=v;
            this.t=t;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        valor_x = Integer.valueOf(v.x_.getText());
        valor_y = Integer.valueOf(v.y_.getText());        
        v.ecuaciones_x();
        v.ecuaciones_y();
        v.menor_igual();
        v.numero();
        v.ventana.repaint();
    }
    
}
