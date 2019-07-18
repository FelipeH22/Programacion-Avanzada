package grafico;

import java.net.*;

import java.io.*;

public class conexion {

    final String HOST = "localhost";
    final int PUERTO=5000;
    public Socket sc;
    public DataOutputStream mensaje;
    public DataInputStream entrada;

    //Cliente

    public void initClient()

    {
        try
        {
            sc = new Socket( HOST , PUERTO );
            mensaje = new DataOutputStream(sc.getOutputStream());
            sc.close();

        }catch(Exception e )

        {

            System.out.println("Error: "+e.getMessage());

        }

    }
}