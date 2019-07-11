function evalua()
{
    v1=document.getElementsByName("v1")[0].value;
    v2=document.getElementsByName("v2")[0].value;
    v3=document.getElementsByName("v3")[0].value;
    v4=document.getElementsByName("v4")[0].value;
    v5=document.getElementsByName("v5")[0].value;
    v6=document.getElementsByName("v6")[0].value;
    v7=document.getElementsByName("v7")[0].value;
    v8=document.getElementsByName("v8")[0].value;
    
    equipo1=document.getElementsByName("equipo1")[0].innerText;
    equipo2=document.getElementsByName("equipo2")[0].innerText;
    equipo3=document.getElementsByName("equipo3")[0].innerText;
    equipo4=document.getElementsByName("equipo4")[0].innerText;
    equipo5=document.getElementsByName("equipo5")[0].innerText;
    equipo6=document.getElementsByName("equipo6")[0].innerText;
    equipo7=document.getElementsByName("equipo7")[0].innerText;
    equipo8=document.getElementsByName("equipo8")[0].innerText;
    
    if(v1===v2)
    {
        alert("Hay empate entre "+equipo1+" y "+equipo2);
        v1=prompt("Digite el valor en prórroga de: "+equipo1);
        v2=prompt("Digite el valor en prórroga de: "+equipo2);
        if(v1===v2)
        {
            alert("Hay empate entre "+equipo1+" y "+equipo2);
            v1=prompt("Digite el valor en penaltis de: "+equipo1);
            v2=prompt("Digite el valor en penaltis de: "+equipo2);
        }
    }
    if(v3===v4)
    {
        alert("Hay empate entre "+equipo3+" y "+equipo4);
        v3=prompt("Digite el valor en prórroga de: "+equipo3);
        v4=prompt("Digite el valor en prórroga de: "+equipo4);
        if(v3===v4)
        {
            alert("Hay empate entre "+equipo3+" y "+equipo4);
            v3=prompt("Digite el valor en penaltis de: "+equipo3);
            v4=prompt("Digite el valor en penaltis de: "+equipo4);
        }
    }
    if(v5===v6)
    {
        alert("Hay empate entre "+equipo5+" y "+equipo6);
        v5=prompt("Digite el valor en prórroga de: "+equipo5);
        v6=prompt("Digite el valor en prórroga de: "+equipo6);
        if(v5===v6)
        {
            alert("Hay empate entre "+equipo5+" y "+equipo6);
            v5=prompt("Digite el valor en penaltis de: "+equipo5);
            v6=prompt("Digite el valor en penaltis de: "+equipo6);
        }
    }
    if(v7===v8)
    {
        alert("Hay empate entre "+equipo7+" y "+equipo8);
        v7=prompt("Digite el valor en prórroga de: "+equipo7);
        v8=prompt("Digite el valor en prórroga de: "+equipo8);
        if(v7===v8)
        {
            alert("Hay empate entre "+equipo7+" y "+equipo8);
            v7=prompt("Digite el valor en penaltis de: "+equipo7);
            v8=prompt("Digite el valor en penaltis de: "+equipo8);
        }
    }     
    document.getElementsByName("v1")[0].value=v1;
    document.getElementsByName("v2")[0].value=v2;
    document.getElementsByName("v3")[0].value=v3;
    document.getElementsByName("v4")[0].value=v4;
    document.getElementsByName("v5")[0].value=v5;
    document.getElementsByName("v6")[0].value=v6;
    document.getElementsByName("v7")[0].value=v7;
    document.getElementsByName("v8")[0].value=v8;  
}



