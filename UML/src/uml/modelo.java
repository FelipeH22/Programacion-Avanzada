package uml;

import controladores.controlador_fin;
import java.util.ArrayList;

public class modelo extends modelo_abstract implements modelo_interface{
   
    @Override
    public void determina_privacidad(){
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controlador_fin.clases[i].size();j++)
            {
                if(controladores.controlador_fin.clases[i].get(j).contains("public"))
                {
                    temp = controladores.controlador_fin.clases[i].get(j);
                    temp = temp.replace("public","+ ");
                    temp = temp.trim();
                    controladores.controlador_fin.clases[i].set(j, temp);
                }
                if(controladores.controlador_fin.clases[i].get(j).contains("private"))
                {
                    temp = controladores.controlador_fin.clases[i].get(j);
                    temp = temp.replace("private","- ");
                    temp = temp.trim();
                    controladores.controlador_fin.clases[i].set(j, temp);
                }
                if(controladores.controlador_fin.clases[i].get(j).contains("protected"))
                {
                    temp = controladores.controlador_fin.clases[i].get(j);
                    temp = temp.replace("protected","# ");
                    temp = temp.trim();
                    controladores.controlador_fin.clases[i].set(j, temp);
                }                
            }
        }
        
    }

    @Override
    public void evalua_herencia() {
        
    }

    @Override
    public void evalua_instancias() {
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controladores.controlador_fin.clases[i].size();j++)
            {                
                if(controladores.controlador_fin.clases[i].get(j).contains("new"))
                {
                    temp3 = controladores.controlador_fin.clases[i].get(j);
                    temp3 = temp3.trim();
                    controladores.controlador_fin.clases[i].remove(j);
                    controladores.controlador_fin.clases[i].add(j,temp3);                   
                }                    
            }
        }
        
    }
    
    @Override
    public void evalua_composicion(){
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controlador_fin.clases[i].size();j++)
            {
                if(controlador_fin.clases[i].get(j).contains("[]")&&controlador_fin.clases[i].get(j).contains("new"))
                {
                    agregacion=true;
                    composicion=false;
                }
                if(controlador_fin.clases[i].get(j).contains("new")&& !controlador_fin.clases[i].get(j).contains("[]"))
                {
                    temp1 = controlador_fin.clases[i].get(j);
                    temp1 = temp1.replace("new", "class");
                    temp1 = temp1.replace("+","");
                    temp1 = temp1.trim();
                    controlador_fin.compo.add(temp1);
                    agregacion=false;
                    composicion=true;
                }
            }
        }
        
        cuadros.agregacion=this.agregacion;
        cuadros.composicion=this.composicion;
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controlador_fin.clases[i].size();j++)
            {
                System.out.println(controlador_fin.clases[i].get(j));
            }
        }
    }    
}
