package db;

public class estudiantes {
    int id;
    String nombre;
    float nota1;
    float nota2;
    float nota3;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setNota1(float Nota1) {
        this.nota1 = Nota1;
    }

    public void setNota2(float Nota2) {
        this.nota2 = Nota2;
    }

    public void setNota3(float Nota3) {
        this.nota3 = Nota3;
    }
}
