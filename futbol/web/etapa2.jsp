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
        <h2>Cuartos Copa América</h2> 
        <div>
                 <form action="etapa3" method="post">  
                           <table border=1>  
                                <tbody>  
                                    <tr>  
                                        <td id="equipo1">${equipo1}</td>  
                                        <td><input type="number" name="v1"></td>  
                                    </tr>  
                                    <tr>  
                                        <td id="equipo2">${equipo2}</td>  
                                        <td><input type="number" name="v2"></td>  
                                    </tr>  
                                </tbody>  
                            </table> 
                           <table border=1>  
                                <tbody>  
                                    <tr>  
                                        <td id="equipo3">${equipo3}</td>  
                                        <td><input type="number" name="v3"></td>  
                                    </tr>  
                                    <tr>  
                                        <td id="equipo4">${equipo4}</td>  
                                        <td><input type="number" name="v4"></td>  
                                    </tr>  
                                </tbody>  
                               <input id="boton" type="submit" value="Confirmar"></td> 

                        </form> 

        </div> 
    </body> 
</html> 
