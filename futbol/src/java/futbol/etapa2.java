package futbol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "etapa2", urlPatterns = {"/etapa2"})
public class etapa2 extends HttpServlet {

    ArrayList<Integer> resultado = new ArrayList<>();
    String equipo1="";
    String equipo2="";
    String equipo3="";
    String equipo4="";
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet etapa2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet etapa2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            
            
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.evalua_ganador(request, response);
        PrintWriter sale = response.getWriter();
        String cambio = "<!DOCTYPE html>\n" +
        "\n" +
        "<html>\n" +
        "    <head>\n" +
        "        <title>Determinante</title>\n" +
        "        <meta charset=\"UTF-8\">\n" +
        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "        <style>\n" +
        "            body{\n" +
        "                font-family: \"courier\";\n" +
        "            }\n" +
        "            table{\n" +
        "                border-color: blue;\n" +
        "            }\n" +
        "            td{\n" +
        "                border-color: white;\n" +
        "            }\n" +
        "            input{\n" +
        "                border-color: red;\n" +
        "            }\n" +
        "            #boton{\n" +
        "                margin-top: 13px;            \n" +
        "            }\n" +
        "            \n" +
        "        </style>\n" +
        "    </head>\n" +
        "    <body>\n" +
        "        <h2>Copa América</h2>\n" +
        "        <div>\n"
                        + "<form action=\"etapa2\" method=\"post\"> \n" +
        "                           <table border=\"1\"> \n" +
        "                                <tbody> \n" +
        "                                    <tr> \n" +
        "                                        <td>"+equipo1+"</td> \n" +
        "                                        <td><input type=\"number\" name=\"v1\"></td> \n" +
        "                                    </tr> \n" +
        "                                    <tr> \n" +
        "                                        <td>"+equipo2+"</td> \n" +
        "                                        <td><input type=\"number\" name=\"v2\"></td> \n" +
        "                                    </tr> \n" +
        "                                </tbody> \n" +
        "                            </table>\n" +
        "                           <table border=\"1\"> \n" +
        "                                <tbody> \n" +
        "                                    <tr> \n" +
        "                                        <td>"+equipo3+"</td> \n" +
        "                                        <td><input type=\"number\" name=\"v3\"></td> \n" +
        "                                    </tr> \n" +
        "                                    <tr> \n" +
        "                                        <td>"+equipo4+"</td> \n" +
        "                                        <td><input type=\"number\" name=\"v4\"></td> \n" +
        "                                    </tr> \n" +
        "                                </tbody> \n" +
        "                               <input id=\"boton\"type=\"submit\" value=\"Confirmar\"></td>\n" +
        "                \n" +
        "                        </form>" +

        "        </div>\n" +
        "    </body>\n" +
        "</html>\n" +
        "";
        sale.println(cambio);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    
    public void evalua_ganador(HttpServletRequest request, HttpServletResponse response){
        
        resultado.add(Integer.valueOf(request.getParameter("v1")));
        resultado.add(Integer.valueOf(request.getParameter("v2")));
        resultado.add(Integer.valueOf(request.getParameter("v3")));
        resultado.add(Integer.valueOf(request.getParameter("v4")));
        resultado.add(Integer.valueOf(request.getParameter("v5")));
        resultado.add(Integer.valueOf(request.getParameter("v6")));
        resultado.add(Integer.valueOf(request.getParameter("v7")));
        resultado.add(Integer.valueOf(request.getParameter("v8")));
        
        
        
        //PARTIDO 1
        if(resultado.get(0)>resultado.get(1))
        {
            equipo1="Colombia";
        }
        else
        {
            if(resultado.get(0)<resultado.get(1))
            {
                equipo1="Brasil";
            }
            
            if(resultado.get(0)==resultado.get(1))
            {
                
            }
        }
        
        //PARTIDO 2
        if(resultado.get(2)>resultado.get(3))
        {
            equipo2="Argentina";
        }
        else
        {
            if(resultado.get(2)<resultado.get(3))
            {
                equipo2="Urugay";
            }
            
            if(resultado.get(2)==resultado.get(3))
            {
                
            }
        }
        
        //PARTIDO 3
        if(resultado.get(4)>resultado.get(5))
        {
            equipo3="Paraguay";
        }
        else
        {
            if(resultado.get(4)<resultado.get(5))
            {
                equipo3="Chile";
            }
            
            if(resultado.get(4)==resultado.get(5))
            {
                
            }
        }
        
        //PARTIDO 4
        if(resultado.get(6)>resultado.get(7))
        {
            equipo4="Bolivia";
        }
        else
        {
            if(resultado.get(6)<resultado.get(7))
            {
                equipo4="Venezuela";
            }
            
            if(resultado.get(6)==resultado.get(7))
            {
                
            }
        }
    }
}
