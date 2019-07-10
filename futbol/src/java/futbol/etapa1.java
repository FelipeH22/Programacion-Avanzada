package futbol;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/NewServlet"})
public class etapa1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String equipo1 = "COLOMBIA";
        String equipo2 = "BRASIL";
        String equipo3 = "ARGENTINA";
        String equipo4 = "URUGAY";
        String equipo5 = "PARAGUAY";
        String equipo6 = "CHILE";
        String equipo7 = "BOLIVIA";
        String equipo8 = "VENEZUELA";
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
        "                            </table> \n" +
        "                            <table border=\"1\"> \n" +
        "                                <tbody> \n" +
        "                                    <tr> \n" +
        "                                        <td>"+equipo5+"</td> \n" +
        "                                        <td><input type=\"number\" name=\"v5\"></td> \n" +
        "                                    </tr> \n" +
        "                                    <tr> \n" +
        "                                        <td>"+equipo6+"</td> \n" +
        "                                        <td><input type=\"number\" name=\"v6\"></td> \n" +
        "                                    </tr> \n" +
        "                                </tbody> \n" +
        "                            </table> \n" +
        "                            <table border=\"1\"> \n" +
        "                                <tbody> \n" +
        "                                    <tr> \n" +
        "                                        <td>"+equipo7+"</td> \n" +
        "                                        <td><input type=\"number\" name=\"v7\"></td> \n" +
        "                                    </tr> \n" +
        "                                    <tr> \n" +
        "                                        <td>"+equipo8+"</td> \n" +
        "                                        <td><input type=\"number\" name=\"v8\"></td> \n" +
        "                                    </tr> \n" +
        "                                </tbody> \n" +
        "                            </table> \n" +
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
    }// </editor-fold>

}
