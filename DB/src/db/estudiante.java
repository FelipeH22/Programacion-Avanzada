package db;




public class estudiante {
    int id;
    String nombre;
    float nota1;
    float nota2;
    float nota3;
    float promedio;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getNota1() {
        return nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public float getNota3() {
        return nota3;
    }
    
    public float getPromedio(){
        return promedio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }
    
    public void setPromedio(float promedio){
        this.promedio = promedio;
    }
}

    

