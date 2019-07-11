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
    String equipo1 = "Colombia";
    String equipo2 = "Brasil";
    String equipo3 = "Argentina";
    String equipo4 = "Uruguay";
    String equipo5 = "Paraguay";
    String equipo6 = "Chile";
    String equipo7 = "Bolivia";
    String equipo8 = "Venezuela";

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            request.getRequestDispatcher("etapa1.jsp")
                    .forward(request, response);
        }
        finally {
            out.close();
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
        request.setAttribute("equipo1", equipo1);
        request.setAttribute("equipo2", equipo2);
        request.setAttribute("equipo3", equipo3);
        request.setAttribute("equipo4", equipo4);
        request.setAttribute("equipo5", equipo5);
        request.setAttribute("equipo6", equipo6);
        request.setAttribute("equipo7", equipo7);
        request.setAttribute("equipo8", equipo8);
        processRequest(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
