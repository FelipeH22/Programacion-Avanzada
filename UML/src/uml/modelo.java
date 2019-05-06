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
                temp=temp.trim();
                controladores.controlador_fin.atributos.set(i, temp);
            }
            if(controladores.controlador_fin.atributos.get(i).contains("private"))
            {
                temp=controladores.controlador_fin.atributos.get(i);
                temp = temp.replace("private","- ");
                temp=temp.trim();
                controladores.controlador_fin.atributos.set(i, temp);
            }
            if(controladores.controlador_fin.atributos.get(i).contains("protected"))
            {
                temp=controladores.controlador_fin.atributos.get(i);
                temp = temp.replace("protected","# ");
                temp=temp.trim();
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
                temp=temp.trim();
                controladores.controlador_fin.clases.set(i, temp);
            }
            if(controladores.controlador_fin.clases.get(i).contains("private"))
            {
                temp=controladores.controlador_fin.clases.get(i);
                temp = temp.replace("private","- ");
                temp=temp.trim();
                controladores.controlador_fin.clases.set(i, temp);
            }
            if(controladores.controlador_fin.clases.get(i).contains("protected"))
            {
                temp=controladores.controlador_fin.clases.get(i);
                temp = temp.replace("protected","# ");
                temp=temp.trim();
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
                temp3=temp3.trim();
                controladores.controlador_fin.intermedio.add(i,temp3);
                controladores.controlador_fin.clases.remove(i);
            }                    
        }
    }
    
    @Override
    public void evalua_composicion(){
        for(i=0;i<controlador_fin.intermedio.size();i++)
        {
            if(controlador_fin.intermedio.get(i).contains("[]")&&controlador_fin.intermedio.get(i).contains("new"))
            {
                /*temp1=controlador_fin.intermedio.get(i);
                temp1=temp1.replace("new", "class");*/
                agregacion=true;
                composicion=false;
            }
            if(controlador_fin.intermedio.get(i).contains("new")&& !controlador_fin.intermedio.get(i).contains("[]"))
            {
                temp1=controlador_fin.intermedio.get(i);
                temp1=temp1.replace("new", "class");
                temp1=temp1.replace("+","");
                temp1=temp1.trim();
                controlador_fin.compo.add(temp1);
                agregacion=false;
                composicion=true;
            }
        }
        cuadros.agregacion=this.agregacion;
        cuadros.composicion=this.composicion;
    }    
}
