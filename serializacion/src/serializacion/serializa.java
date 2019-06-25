package serializacion;

import java.io.*;

public class serializa implements Serializable{
    
    FileOutputStream fos = null;
    ObjectOutputStream salida = null;
    FileInputStream fis = null;
    ObjectInputStream entrada = null;
    Conexion cn = new Conexion();
    Estudiantes dbc = new Estudiantes();
    estudiante[] contactos;    
    Object[][] data;
    
    public void crea_todo() throws IOException{  
            contactos = dbc.getContactos();    
            data = new Object[contactos.length][5];  
            try {
            
            fos = new FileOutputStream("estudiantes.dat");
            salida = new ObjectOutputStream(fos);
            
            for (int c=0;c<contactos.length;c++){
                data[c][0]=contactos[c].getId();
                data[c][1]=contactos[c].getNombre();
                data[c][2]=contactos[c].getNota1();
                data[c][3]=contactos[c].getNota2();
                data[c][4]=contactos[c].getNota3();   
                salida.writeObject(data[c][0]);
                salida.writeObject(data[c][1]);
                salida.writeObject(data[c][2]);
                salida.writeObject(data[c][3]);
                salida.writeObject(data[c][4]);
            }
            
            System.out.println("Serializado");
            salida.close();
           
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
    
    public void mostrar_archivo(){
        try {            
                fis = new FileInputStream("estudiantes.dat");
                entrada = new ObjectInputStream(fis);
                for (int c=0;c<contactos.length;c++){
                    System.out.println((Integer) entrada.readObject());
                    System.out.println((String) entrada.readObject());
                    System.out.println((Float) entrada.readObject());
                    System.out.println((Float) entrada.readObject());
                    System.out.println((Float) entrada.readObject());
                }
                System.out.println("Deserializado");
                entrada.close();           
        } catch (FileNotFoundException e) {
            System.out.println("1"+e.getMessage());
        } catch (IOException e) {
            System.out.println("2"+e.getMessage());
        } catch (ClassNotFoundException ex){
            System.out.println("3"+ex.getMessage());
        }
    }
}
