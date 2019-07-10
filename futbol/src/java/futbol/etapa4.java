package futbol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "etapa4", urlPatterns = {"/etapa4"})
public class etapa4 extends HttpServlet {

    ArrayList<Integer> resultado = new ArrayList<>();
    String equipo1="";
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
        response.sendRedirect("etapa4.html");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    
    public void evalua_ganador(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter sale = response.getWriter();
        resultado.add(Integer.valueOf(request.getParameter("v1")));
        resultado.add(Integer.valueOf(request.getParameter("v2")));   
        
        //PARTIDO 1
        if(resultado.get(0)>resultado.get(1))
        {
            equipo1=etapa3.equipo1;
        }
        else
        {
            if(resultado.get(0)<resultado.get(1))
            {
                equipo1=etapa3.equipo2;
            }
            
            if(resultado.get(0)==resultado.get(1))
            {
                String cambio = "<!DOCTYPE html>\n" +
        "\n" +
        "<html>\n" +
        "    <head>\n" +
        "        <title>Copa América</title>\n" +
        "        <meta charset=\"UTF-8\">\n" +
        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "        <style>\n" +
        "            body{\n" +
        "                font-family: \"courier\";\n" +
        "            }\n" +
        "            input{\n" +
        "                border-color: red;\n" +
        "            }\n"
                + "h2{"
                + "color: red;"
                + "}" +
        "            #boton{\n" +
        "                margin-top: 13px;            \n" +
        "            }\n" +
        "            \n" +
        "        </style>\n" +
        "    </head>\n" +
        "    <body>\n" +
        "        <script src=\"etapa4.js\">"+"</script>" +    
        "    </body>\n" +
        "</html>\n" +
        "";
                sale.println(cambio);
            }
        }
    }
}
