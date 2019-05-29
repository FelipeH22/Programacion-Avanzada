package db;

import db.Contacto;
import java.sql.*;
import db.DBConexion;

public class DBContactos {
    DBConexion cn;

    public DBContactos() {
        cn = new DBConexion();
    }

    public Contacto[] getContactos(){
        int registros = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont" +
            " FROM estudiantes ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("id");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        Contacto[] data = new Contacto[registros];
        try{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, " +
                                                                    " Nombre, " +
                                                                    " Nota1, " +
                                                                    " Nota2, " +
                                                                    " Nota3");
            
        ResultSet res = pstm.executeQuery();
        int i = 0;
        while(res.next()){
            System.out.println(res.getString("Nombre"));
            data[i] = new Contacto();
            data[i].setId(res.getInt("id"));
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
        public int insertarContacto(Contacto c){
            /*int cont_usuario = -1;
            int resultado = 0;//no hubo errores de validacion
            try{
                PreparedStatement pstm = cn.getConexion().prepareStatement("select count(1) as cont " +
                " from estudiantes " +
                " where con_correo = ? ");
                pstm.setString(1, c.getCorreo());
                ResultSet res = pstm.executeQuery();
                res.next();
                cont_usuario = res.getInt("cont");
                res.close();
                if(cont_usuario==0){
                    pstm = cn.getConexion().prepareStatement("insert into estudiantes (con_nombre, " +
                                                                " con_apellido," +
                                                                " con_telefono_domicilio," +
                                                                " con_telefono_oficina," +
                                                                " con_celular," +
                                                                " con_correo," +
                                                                " con_direccion_residencia," +
                                                                " con_direccion_trabajo) " +
                                                                " values(?,?,?,?,?,?,?,?)");
                    pstm.setString(1, c.getNombre());
                    pstm.setString(2, c.getApellido());
                    pstm.setString(3, c.getTelefonoDomicilio());
                    pstm.setString(4, c.getTelefonoOficina());
                    pstm.setString(5, c.getCelular());
                    pstm.setString(6, c.getCorreo());
                    pstm.setString(7, c.getDireccionResidencia());
                    pstm.setString(8, c.getDireccionTrabajo());

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
                    return resultado;*/
                    return 0;
                }

    public int actualizarContacto(Contacto c){
    /*int resultado = 0;
    try{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update contactos " + " set con_nombre = ?, " +
                                                                    " con_apellido = ?," +
                                                                    " con_telefono_domicilio = ?," +
                                                                    " con_telefono_oficina = ?," +
                                                                    " con_celular = ?," +
                                                                    " con_correo = ?," +
                                                                    " con_direccion_residencia = ?," +
                                                                    " con_direccion_trabajo = ? " +
                                                                    " where con_id = ?");
        pstm.setString(1, c.getNombre());
        pstm.setString(2, c.getApellido());
        pstm.setString(3, c.getTelefonoDomicilio());
        pstm.setString(4, c.getTelefonoOficina());
        pstm.setString(5, c.getCelular());
        pstm.setString(6, c.getCorreo());
        pstm.setString(7, c.getDireccionResidencia());
        pstm.setString(8, c.getDireccionTrabajo());
        pstm.setInt(9, c.getId());
        resultado = pstm.executeUpdate();
    }catch(SQLException e){
        System.out.println(e);
    }
        return resultado;*/
        return 0;
    }

    public int borrarContacto(Contacto c){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from estuduiantes " +
            " where id = ?");
            pstm.setInt(1, c.getId());
            resultado = pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
            return resultado;
        }
}
