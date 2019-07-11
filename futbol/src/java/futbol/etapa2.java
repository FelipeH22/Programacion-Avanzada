package futbol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "etapa2", urlPatterns = {"/etapa2"})
public class etapa2 extends HttpServlet {

    public boolean empate=true;
    ArrayList<Integer> resultado = new ArrayList<>();
    public static String equipo1="";
    public static String equipo2="";
    public static String equipo3="";
    public static String equipo4="";
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            request.getRequestDispatcher("etapa2.jsp")
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
        request.setAttribute("equipo2", equipo2);
        request.setAttribute("equipo3", equipo3);
        request.setAttribute("equipo4", equipo4);
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
            
            if(Objects.equals(resultado.get(0), resultado.get(1)))
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
                empate=true;
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
                empate=true;
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
                empate=true;
            }
        }
    }
}
