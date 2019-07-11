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
            input{ 
                border-color: red; 
            }
         h2{
         color: red;
         } 
            #boton{ 
                margin-top: 13px;             
            } 

        </style> 
    </head> 
    <body> 
        <h2>El primer lugar es: ${equipo1} </h2>     
        <h2>El segundo lugar es: ${equipo2} </h2>
        <h2>El tercer lugar es: ${equipo3} </h2>
    </body> 
</html> 
