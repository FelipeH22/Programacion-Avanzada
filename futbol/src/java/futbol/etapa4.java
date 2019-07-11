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
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            request.getRequestDispatcher("etapa4.jsp")
                    .forward(request, response);
        }
        finally {
            out.close();
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
        request.setAttribute("equipo1", equipo1);
        this.processRequest(request, response);
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
                
            }
        }
    }
}
