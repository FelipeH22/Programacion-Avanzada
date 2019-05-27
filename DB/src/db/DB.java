package db;

public class DB {

    public static void main(String[] args) {
        conexion c = new conexion();
        conexion_tablas dbcontactos = new conexion_tablas();        
        estudiantes[] contactos = dbcontactos.getContactos();
        vista v = new vista();
        System.out.println("\n****** CONTACTOS ******\n");
        
        for (estudiantes contacto : contactos){
            System.out.println("Nombre: " + contacto.getNombre() + " " + contacto.getNota1());
        }
    }
    
}
