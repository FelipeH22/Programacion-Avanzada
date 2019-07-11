package futbol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "etapa3", urlPatterns = {"/etapa3"})
public class etapa3 extends HttpServlet {

    ArrayList<Integer> resultado = new ArrayList<>();
    public static String equipo1="";
    public static String equipo2="";
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            request.getRequestDispatcher("etapa3.jsp")
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
        request.setAttribute("equipo1",equipo1);
        request.setAttribute("equipo2",equipo2);
        this.processRequest(request, response);
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
        
        //PARTIDO 1
        if(resultado.get(0)>resultado.get(1))
        {
            equipo1=etapa2.equipo1;
        }
        else
        {
            if(resultado.get(0)<resultado.get(1))
            {
                equipo1=etapa2.equipo2;
            }
            
            if(resultado.get(0)==resultado.get(1))
            {
                
            }
        }
        
        //PARTIDO 2
        if(resultado.get(2)>resultado.get(3))
        {
            equipo2=etapa2.equipo3;
        }
        else
        {
            if(resultado.get(2)<resultado.get(3))
            {
                equipo2=etapa2.equipo4;
            }
            
            if(resultado.get(2)==resultado.get(3))
            {
                
            }
        }
    }
}
