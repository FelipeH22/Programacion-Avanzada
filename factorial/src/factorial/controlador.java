package factorial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador implements ActionListener{
    vista v = new vista();
    modelo t = new modelo();
    
    public controlador(vista v, modelo t){
        this.v=v;
        this.t=t;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {      
        double numero, result;
        numero = Double.parseDouble(v.text.getText());
        result = t.resultado(numero);
        v.label.setText("El factorial es: " + result);
    }
    
}
