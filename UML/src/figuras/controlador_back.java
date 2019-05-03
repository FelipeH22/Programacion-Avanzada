package figuras;

import uml.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador_back implements ActionListener{
    ventana ventana = new ventana();
    vista v = new vista();
    
    public controlador_back(ventana ventana){
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.frame.setVisible(false);
        v.setVisible(true);
        v.panel.removeAll();
        v.componentes();
    }
}
