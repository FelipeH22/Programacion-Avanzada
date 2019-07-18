package grafico;

import java.net.*;

import java.io.*;

public class conexion {

    final String HOST = "localhost";
    final int PUERTO=5000;
    public Socket sc;
    public ObjectOutputStream mensaje;
    public ObjectInputStream entrada;

    public void initClient()

    {
        try
        {
            sc = new Socket( HOST , PUERTO );
            mensaje = new ObjectOutputStream(sc.getOutputStream());
            mensaje.writeObject(controlador2.x);
            mensaje.writeObject(controlador2.y);
            mensaje.writeObject(controlador2.inecuacion);
            mensaje.writeObject(controlador2.numero);
            sc.close();

        }catch(Exception e )

        {
            System.out.println("Error: "+e.getMessage());
        }

    }
}