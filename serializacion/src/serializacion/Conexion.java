package serializacion;



import java.sql.*;
public class Conexion {
    static String bd = "estudiantes";
    static String login = "root";
    static String password = "felipe22";
    static String url = "jdbc:mysql://localhost/"+bd;

    Connection conexion = null;

    public Conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,login,password);
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    public Connection getConexion(){
        return conexion;
    }
    public void desconectar(){
       conexion = null;
    }
}

