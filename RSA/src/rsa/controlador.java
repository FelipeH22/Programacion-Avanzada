package rsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador implements ActionListener{
    vista v = new vista();
    modelo m = new modelo();
    public static int p,q,n;
    public static String palabra;
    
    public controlador(vista v, modelo m){
        this.v=v;
        this.m=m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p=Integer.parseInt(v.p.getText());
        q=Integer.parseInt(v.q.getText());
        n=Integer.parseInt(v.n.getText());
        palabra=v.palabra.getText();
        m.calcula();
        v.z.setText("z = "+Integer.toString(m.z));
        v.s.setText("s = "+Integer.toString(m.s));
        v.num_palabra.setText(palabra+" = "+Integer.toString(m.numencriptado));
    }
}
