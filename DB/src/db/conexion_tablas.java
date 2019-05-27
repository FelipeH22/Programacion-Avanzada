package db;

import java.sql.*;

public class conexion_tablas {
    conexion cn;

    public conexion_tablas() {
        cn = new conexion();
    }

    public estudiantes[] getContactos(){
        System.out.println("Leyendo tablas");
        int registros = 0;
        /*try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont" +
            " FROM estudiantes ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }*/
            estudiantes[] data = new estudiantes[registros];
        try{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id_estudiantes, " +
                                                                    " Nombre, " +
                                                                    " Nota1, " +
                                                                    " Nota2, " +
                                                                    " Nota3," +
                                                                    " FROM estudiantes ");

        ResultSet res = pstm.executeQuery();
        int i = 0;
        while(res.next()){
            data[i] = new estudiantes();
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
}