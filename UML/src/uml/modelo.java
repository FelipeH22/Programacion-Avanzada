package uml;

import controladores.controlador_fin;

public class modelo extends modelo_abstract implements modelo_interface{

    
    @Override
    public void determina_privacidad() {
        for(i=0;i<controladores.controlador_fin.atributos.size();i++)
        {
            if(controladores.controlador_fin.atributos.get(i).contains("public"))
            {
                temp=controladores.controlador_fin.atributos.get(i);
                temp = temp.replace("public","+ ");
                controladores.controlador_fin.atributos.set(i, temp);
            }
            if(controladores.controlador_fin.atributos.get(i).contains("private"))
            {
                temp=controladores.controlador_fin.atributos.get(i);
                temp = temp.replace("private","- ");
                controladores.controlador_fin.atributos.set(i, temp);
            }
            if(controladores.controlador_fin.atributos.get(i).contains("protected"))
            {
                temp=controladores.controlador_fin.atributos.get(i);
                temp = temp.replace("protected","# ");
                controladores.controlador_fin.atributos.set(i, temp);
            }                
        }
        /////Con las Clases
        for(i=0;i<controladores.controlador_fin.clases.size();i++)
        {
            if(controladores.controlador_fin.clases.get(i).contains("public"))
            {
                temp=controladores.controlador_fin.clases.get(i);
                temp = temp.replace("public","+ ");
                controladores.controlador_fin.clases.set(i, temp);
            }
            if(controladores.controlador_fin.clases.get(i).contains("private"))
            {
                temp=controladores.controlador_fin.clases.get(i);
                temp = temp.replace("private","- ");
                controladores.controlador_fin.clases.set(i, temp);
            }
            if(controladores.controlador_fin.clases.get(i).contains("protected"))
            {
                temp=controladores.controlador_fin.clases.get(i);
                temp = temp.replace("protected","# ");
                controladores.controlador_fin.clases.set(i, temp);
            }                
        }
    }

    @Override
    public void evalua_herencia() {
        
    }

    @Override
    public void evalua_instancias() {
        for(i=0;i<controladores.controlador_fin.clases.size();i++)
        {
            for(j=0;j<controlador_fin.num_clases;j++)
                controlador_fin.intermedio.add(i, "");
            if(controladores.controlador_fin.clases.get(i).contains("new"))
            {
                temp3=controladores.controlador_fin.clases.get(i);
                controladores.controlador_fin.intermedio.add(i,temp3);
                controladores.controlador_fin.clases.remove(i);
            }                    
        }
    }
    
    @Override
    public void evalua_composicion(){
        for(i=0;i<controlador_fin.intermedio.size();i++)
        {
            if(controlador_fin.intermedio.get(i).contains("[]"))
            {
                agregacion=true;
                composicion=false;
            }
            else
            {
                agregacion=false;
                composicion=true;
            }
        }
        for(i=0;i<controlador_fin.intermedio.size();i++)
        {
            System.out.println(controlador_fin.intermedio.get(i));
        }
        
    }
    
}
