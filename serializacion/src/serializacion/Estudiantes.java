package serializacion;

import java.sql.*;

public class Estudiantes {
    Conexion cn;
    String BD;
    String Tabla;

    public Estudiantes() {
        cn = new Conexion();
    }

    public estudiante[] getContactos(){
        int registros = 0;
        try{
            BD = "estudiantes";
            Tabla = "estudiantes";
            PreparedStatement pstm2 = cn.getConexion().prepareStatement("use "+BD);
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont FROM "+Tabla);
            ResultSet res2 = pstm2.executeQuery();
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
            estudiante[] data = new estudiante[registros];
        try{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id_estudiantes, Nombre, Nota1, Nota2, Nota3 FROM "+Tabla);

        ResultSet res = pstm.executeQuery();
        int i = 0;
        while(res.next()){
            data[i] = new estudiante();
            data[i].setId(res.getInt("id_estudiantes"));
            data[i].setNombre(res.getString("Nombre"));
            data[i].setNota1(res.getFloat("Nota1"));
            data[i].setNota2(res.getFloat("Nota2"));
            data[i].setNota3(res.getFloat("Nota3"));
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
                PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont FROM "+Tabla+" where Nombre = ? ");
                pstm.setString(1, c.getNombre());
                ResultSet res = pstm.executeQuery();
                res.next();
                cont_usuario = res.getInt("cont");
                res.close();
                if(cont_usuario==0){
                    pstm = cn.getConexion().prepareStatement("INSERT INTO "+Tabla+" (Nombre, Nota1, Nota2, Nota3) values (?,?,?,?) ");
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
        PreparedStatement pstm = cn.getConexion().prepareStatement("UPDATE "+ Tabla +" set Nombre = ?, Nota1 = ?, Nota2 = ?, Nota3 = ? where id_estudiantes = ?");
        pstm.setString(1, c.getNombre());
        pstm.setString(2, Float.toString(c.getNota1()));
        pstm.setString(3, Float.toString(c.getNota2()));
        pstm.setString(4, Float.toString(c.getNota3()));
        pstm.setInt(5, c.getId());
        resultado = pstm.executeUpdate();
    }catch(SQLException e){
        System.out.println(e);
    }
        return resultado;
    }

    public int borrarContacto(estudiante c){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("DELETE FROM "+Tabla+" WHERE id_estudiantes = ?");
            pstm.setInt(1, c.getId());
            resultado = pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
            return resultado;
        }
}
