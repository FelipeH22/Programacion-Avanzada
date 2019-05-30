package db;


import db.FormAgenda;
import db.DBContactos;
import db.DBCitas;
import db.estudiante;
import db.Citas;

public class main {
    
    
    public static void main(String[] args) {
        FormAgenda f = new FormAgenda();
        DBContactos dbcontactos = new DBContactos();
        estudiante[] contactos = dbcontactos.getContactos();
        
        
        System.out.println("\n****** Estudiantes ******\n");
        
        for (estudiante contacto : contactos){
            System.out.println("Nombre: " + contacto.getNombre() + " " + contacto.getNota1());
        }
         
        System.out.println("\n\n");
    }
}

