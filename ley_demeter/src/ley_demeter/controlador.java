package ley_demeter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador implements ActionListener{
    vista v = new vista();
    modelo t = new modelo();
    public static int contador = 0;
    
    public controlador(vista v, modelo t){
        this.v=v;
        this.t=t;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(v.a.getText()); 
        int b = Integer.parseInt(v.b.getText());
        int c = Integer.parseInt(v.c.getText());
        int d = Integer.parseInt(v.d.getText());
        t.evalua(a,b,c,d);
        t.llena_arrays(a, b, c, d);
        contador++;
        v.resultado.setText("La raíz por ruffini = "+t.raiz);
    }
    
}
