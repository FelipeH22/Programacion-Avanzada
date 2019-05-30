package db;

import db.DBConexion;
import db.estudiante;
import java.sql.*;

public class DBContactos {
    DBConexion cn;

    public DBContactos() {
        cn = new DBConexion();
    }

    public estudiante[] getContactos(){
        int registros = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont FROM estudiantes.estudiantes");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
            estudiante[] data = new estudiante[registros];
        try{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, nombre, nota1, nota2, nota3 FROM estudiantes.estudiantes");

        ResultSet res = pstm.executeQuery();
        int i = 0;
        while(res.next()){
            data[i] = new estudiante();
            data[i].setId(res.getInt("id"));
            data[i].setNombre(res.getString("nombre"));
            data[i].setNota1(res.getFloat("nota1"));
            data[i].setNota2(res.getFloat("nota2"));
            data[i].setNota3(res.getFloat("nota3"));
            i++;
        }
        res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
            return data;
        }
    
    public int insertarContacto(estudiante c){
            int cont_usuario = -1;
            int resultado = 0;//no hubo errores de validacion
            try{
                PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont FROM estudiantes.estudiantes" +
                " where nombre = ? ");
                pstm.setString(1, c.getNombre());
                ResultSet res = pstm.executeQuery();
                res.next();
                cont_usuario = res.getInt("cont");
                res.close();
                if(cont_usuario==0){
                    pstm = cn.getConexion().prepareStatement("INSERT INTO estudiantes.estudiantes nombre,nota1,nota2,nota3, values(?,?,?,?) ");
                    pstm.setString(1, c.getNombre());
                    pstm.setString(2, Float.toString(c.getNota1()));
                    pstm.setString(3, Float.toString(c.getNota2()));
                    pstm.setString(4, Float.toString(c.getNota3()));
                    pstm.executeUpdate();

                    pstm = cn.getConexion().prepareStatement("select last_insert_id()");
                    res = pstm.executeQuery();
                    res.next();
                    resultado = res.getInt(1);
                    res.close();
                }else{
                    resultado = -2;//el login ya existe
                }
                }catch(SQLException e){
                    System.out.println(e);
                }
                    return resultado;
                }

    public int actualizarContacto(estudiante c){
    int resultado = 0;
    try{
        PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE estudiantes.estudiantes set nombre = ?, nota1 = ?, nota2 = ?, nota3 = ?, where id = ?");
        pstm.setString(1, c.getNombre());
        pstm.setString(2, Float.toString(c.getNota1()));
        pstm.setString(3, Float.toString(c.getNota2()));
        pstm.setString(4, Float.toString(c.getNota3()));
        pstm.setInt(9, c.getId());
        resultado = pstm.executeUpdate();
    }catch(SQLException e){
        System.out.println(e);
    }
        return resultado;
    }

    public int borrarContacto(estudiante c){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM estudiantes.estudiantes WHERE id = ?");
            pstm.setInt(1, c.getId());
            resultado = pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
            return resultado;
        }
}
