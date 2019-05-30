package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Rapter
 */
public class Citas {
    int id;
    int persona;
    String nombre;
    String lugar;
    Date fecha;
    Time hora;
    String descripcion;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }    
    
    public int getPersona() {
        return persona;
    }

    public String getLugar() {
        return lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
