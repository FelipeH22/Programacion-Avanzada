package serializacion;

import java.io.*;

public class serializa implements Serializable{
    FileOutputStream fos = null;
    ObjectOutputStream salida = null;
    DBConexion cn = new DBConexion();
    DBEstudiantes dbc = new DBEstudiantes();
    estudiante[] contactos;
    
    
    public void crea_todo() throws IOException{
            fos = new FileOutputStream("estudiantes.dat");
            salida = new ObjectOutputStream(fos);
            contactos = dbc.getContactos();
            
            try {
            
            fos = new FileOutputStream("estudiantes.dat");
            salida = new ObjectOutputStream(fos);
            Object[][] data = new Object[contactos.length][5];
            for (int c=0;c<contactos.length;c++){
                data[c][0]=contactos[c].getId();
                data[c][1]=contactos[c].getNombre();
                data[c][2]=contactos[c].getNota1();
                data[c][3]=contactos[c].getNota2();
                data[c][4]=contactos[c].getNota3();           
            }
            salida.writeObject(data);
            System.out.println("Serializado");
           
            } catch (FileNotFoundException e) {
                System.out.println("1"+e.getMessage());
            } catch (IOException e) {
                System.out.println("2"+e.getMessage());
            } finally {
                try {
                    if(fos!=null) fos.close();
                    if(salida!=null) salida.close();
                } catch (IOException e) {
                    System.out.println("3"+e.getMessage());
                }
            }
                  
    }
}
