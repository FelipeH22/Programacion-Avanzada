package simplex;

import java.awt.event.KeyEvent;

public class controlador {
	vista v = new vista();
	lib_simplex lib = new lib_simplex();
	
	public void keyPressed(KeyEvent e) {
	 
		 int key = e.getKeyCode();
		 
		 if (key == KeyEvent.VK_ENTER) {		 
			 //lib.num_variables=Integer.parseInt(v.num_variables.getText());
			 //Crear array de variables textField para pasar parametros
			 v.variable1.setVisible(true);
			 v.variable2.setVisible(true);
			 //v.variable3.setVisible(true);
			 
			 
		 }
	}
}
