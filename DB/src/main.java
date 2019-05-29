public class main {
    
    
    public static void main(String[] args) {
        FormAgenda f = new FormAgenda();
        DBContactos dbcontactos = new DBContactos();
        Contacto[] contactos = dbcontactos.getContactos();
        
        DBCitas dbcitas = new DBCitas();
        
        Citas[] citas = dbcitas.getCitas();
        
        System.out.println("\n****** CONTACTOS ******\n");
        
        for (Contacto contacto : contactos){
            System.out.println("Nombre: " + contacto.getNombre() + " " + contacto.getNota1());
        }
        
        System.out.println("\n******** CITAS ********\n");
        
        for (Citas cita : citas){
            System.out.println("Cita "+cita.getId()+": ");
            System.out.println("Persona: " + cita.getNombre()+ "\tLugar: " + cita.getLugar()+ "\tFecha: " + cita.getFecha()+ "\tHora: " + cita.getHora()+ "\tDescripcion: " + cita.getDescripcion());
        }   
        System.out.println("\n\n");
    }
}

