package futbol;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/NewServlet"})
public class main extends HttpServlet {

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
        request.setAttribute("equipo1", "COLOMBia");
        PrintWriter sale = response.getWriter();
        String cambio ="<form action=\"NewServlet\" method=\"post\">\n" +
"                           <label>"+equipo1+"</label><br>\n" +
                            "<label>"+equipo2+"</label>\n"+
"                           <input id=\"boton\" value=\"enviar\" type=\"submit\">\n" +
"                        </form>";
        sale.println(cambio);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
