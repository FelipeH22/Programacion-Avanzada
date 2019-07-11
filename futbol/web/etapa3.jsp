<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
         
<html> 
    <head> 
        <title>Copa América</title> 
        <meta charset=UTF-8> 
        <style> 
            body{ 
                font-family: courier; 
            } 
            table{ 
                margin-top: 13px;
                border-color: blue; 
            } 
            td{ 
                border-color: white; 
            } 
            input{ 
                border-color: red; 
            } 
            #boton{ 
                margin-top: 13px;             
            } 

        </style> 
    </head> 
    <body> 
        <h2>Final Copa América</h2> 
        <div>
                 <form action="etapa4" method="post">  
                           <table border=1>  
                                <tbody>  
                                    <tr>  
                                        <td name="equipo1">${equipo1}</td>  
                                        <td><input type="number" name="v1"></td>  
                                    </tr>  
                                    <tr>  
                                        <td name="equipo2">${equipo2}</td>  
                                        <td><input type="number" name="v2"></td>  
                                    </tr>  
                                </tbody>  
                            </table> 
                                        <h1>Partido tercer lugar</h1>
                            <table border=1>  
                                <tbody>  
                                    <tr>  
                                        <td name="equipo3">${equipo3}</td>  
                                        <td><input type="number" name="v3"></td>  
                                    </tr>  
                                    <tr>  
                                        <td name="equipo4">${equipo4}</td>  
                                        <td><input type="number" name="v4"></td>  
                                    </tr>  
                                </tbody>  
                            </table> 
                              <input id="boton" type="submit" value="Confirmar" onclick="evalua()"></td> 
                              <script src="JS/etapa3.js"></script>                        
                </form> 

        </div> 
    </body> 
</html> 
