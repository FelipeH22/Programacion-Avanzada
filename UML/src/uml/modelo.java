package uml;

import controladores.controlador_fin;

public class modelo extends modelo_abstract implements modelo_interface{
    
    @Override
    public void llena_arrays(){
        for(i=0;i<controlador_fin.num_clases;i++)
        {
            for(j=0;j<controlador_fin.clases[i].size();j++)
            {
                if(!controlador_fin.clases[i].get(j).contains("new")&& !controlador_fin.clases[i].get(j).contains("class") && !controlador_fin.clases[i].get(j).contains("interface"))
                {
                    controlador_fin.atributos[i].add(controlador_fin.clases[i].get(j));
                }
                if(controlador_fin.clases[i].get(j).contains("new"))
                {
                    controlador_fin.instancias[i].add(controlador_fin.clases[i].get(j));
                }
                
            }
        }
    }
   
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
                    temp3 = controlador_fin.clases[i].get(j);
                    temp3 = temp3.replace("new", "class");
                    temp3 = temp3.replace("+","");
                    temp3 = temp3.replace("-","");
                    temp3 = temp3.replace("#","");
                    temp3 = temp3.trim();
                    controlador_fin.agrega.get(i).put(controlador_fin.clases[i].get(0), temp3);
                    uml.cuadros.clase1_agrega=i;
                    agregacion[contador]=true;
                    composicion[contador]=false;
                    contador++;
                }
                if(controlador_fin.clases[i].get(j).contains("new")&& !controlador_fin.clases[i].get(j).contains("[]"))
                {
                    temp1 = controlador_fin.clases[i].get(j);
                    temp1 = temp1.replace("new", "class");
                    temp1 = temp1.replace("+","");
                    temp1 = temp1.replace("-","");
                    temp1 = temp1.replace("#","");
                    temp1 = temp1.trim();
                    controlador_fin.compos.get(i).put(controlador_fin.clases[i].get(0), temp1);
                    uml.cuadros.clase1_compo=i;
                    agregacion[contador]=false;
                    composicion[contador]=true;
                    contador++;
                }
            }
        }
        for(h=0;h<controlador_fin.num_clases;h++)
        {
            if(controlador_fin.clases[h].get(0).equals(temp1))
            {
                uml.cuadros.clase2_compo=h;
            }
        }
        for(h=0;h<controlador_fin.num_clases;h++)
        {
            if(controlador_fin.clases[h].get(0).equals(temp3))
            {
                uml.cuadros.clase2_agrega=h;
            }
        }        
        cuadros.agregacion=this.agregacion;
        cuadros.composicion=this.composicion;
    }

    @Override
    public void evalua_herencias(){
        String[] arrOfStr = null;
        for(i=0;i<controlador_fin.herencias.size();i++)
        {
            //for(j=0;j<controlador_fin.clases[i].size();j++)
            //{
                if(controlador_fin.herencias.get(i).contains("implements"))
                {
                    temp2 = controlador_fin.herencias.get(i);
                    temp2 = temp2.replace("implements", " , ");
                    temp2 = temp2.trim();
                    arrOfStr=temp2.split(",");
                    arrOfStr[1]=arrOfStr[1].replaceAll(arrOfStr[1], "interface"+arrOfStr[1]);
                    temp2=arrOfStr[0];
                    controlador_fin.implementss.get(i).put(temp2, arrOfStr[1]);
                    for(j=0;j<controlador_fin.num_clases;j++)
                    {
                        if(controlador_fin.clases[j].get(0).equals(arrOfStr[0]))
                            uml.cuadros.clase1_implements=j;
                    }
                    i_mplements[contador2]=true;
                    e_xtends[contador2]=false;
                    contador2++;
                }
                if(controlador_fin.herencias.get(i).contains("extends"))
                {
                    temp4 = controlador_fin.herencias.get(i);
                    temp4 = temp4.replace("extends", " , ");
                    temp4 = temp4.trim();
                    arrOfStr=temp4.split(",");
                    arrOfStr[1]=arrOfStr[1].replaceAll(arrOfStr[1], "class"+arrOfStr[1]);
                    temp4=arrOfStr[0];
                    controlador_fin.implementss.get(i).put(temp4, arrOfStr[1]);
                    for(j=0;j<controlador_fin.num_clases;j++)
                    {
                        if(controlador_fin.clases[j].get(0).equals(arrOfStr[0]))
                            uml.cuadros.clase1_extends=j;                                
                    }
                    i_mplements[contador2]=false;
                    e_xtends[contador2]=true;
                    contador2++;
                }
            //}
        }
        for(h=0;h<controlador_fin.num_clases;h++)
        {
            if(controlador_fin.clases[h].get(0).equals(arrOfStr[1]))
            {
                uml.cuadros.clase2_implements=h;
            }
        }
        for(h=0;h<controlador_fin.num_clases;h++)
        {
            if(controlador_fin.clases[h].get(0).equals(arrOfStr[1]))
            {
                uml.cuadros.clase2_extends=h;
            }
        }        
        cuadros.i_mplements=this.i_mplements;
        cuadros.e_xtends=this.e_xtends;
    }
}
