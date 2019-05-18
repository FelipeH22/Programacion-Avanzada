package rsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador implements ActionListener{
    vista v = new vista();
    modelo m = new modelo();
    public int p,q,n;
    String palabra;
    
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
        System.out.println(palabra);
    }
}
