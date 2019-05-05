package uml;

public class modelo implements modelo_interface{

    int i;
    
    @Override
    public void determina_privacidad() {
        String temp;
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
        String temp2;
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
        String temp3;
        for(i=0;i<controladores.controlador_fin.clases.size();i++)
        {
            if(controladores.controlador_fin.clases.get(i).contains("new"))
            {
                temp3=controladores.controlador_fin.clases.get(i);
                controladores.controlador_fin.intermedio.add(temp3);
                controladores.controlador_fin.clases.remove(i);
            }                    
        }
    }
    
}
