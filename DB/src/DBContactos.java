import java.sql.*;

public class DBContactos {
    DBConexion cn;

    public DBContactos() {
        cn = new DBConexion();
    }

    public Contacto[] getContactos(){
        int registros = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT count(1) as cont" +
            " FROM estudiantest ");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("cont");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
            Contacto[] data = new Contacto[registros];
        try{
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, " +
                                                                    " nombre, " +
                                                                    " nota1, " +
                                                                    " nota2, " +
                                                                    " nota3," +
                                                                    " FROM estudiantest ");

        ResultSet res = pstm.executeQuery();
        int i = 0;
        while(res.next()){
            data[i] = new Contacto();
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
    
    public int insertarContacto(Contacto c){
            int cont_usuario = -1;
            int resultado = 0;//no hubo errores de validacion
            try{
                PreparedStatement pstm = cn.getConexion().prepareStatement("select count(1) as cont " +
                " from estudiantest " +
                " where nombre = ? ");
                pstm.setString(1, c.getNombre());
                ResultSet res = pstm.executeQuery();
                res.next();
                cont_usuario = res.getInt("cont");
                res.close();
                if(cont_usuario==0){
                    pstm = cn.getConexion().prepareStatement("insert into estudiantest (nombre, " +
                                                                " nota1," +
                                                                " nota2," +
                                                                " nota3," +
                                                                " values(?,?,?,?)");
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

    public int actualizarContacto(Contacto c){
    int resultado = 0;
    try{
        PreparedStatement pstm = cn.getConexion().prepareStatement("update estudiantest " + " set nombre = ?, " +
                                                                    " nota1 = ?," +
                                                                    " nota2 = ?," +
                                                                    " nota3 = ?," +
                                                                    " where id = ?");
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

    public int borrarContacto(Contacto c){
        int resultado = 0;
        try{
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from estudiantest " +
            " where id = ?");
            pstm.setInt(1, c.getId());
            resultado = pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
            return resultado;
        }
}
