function evalua()
{
    v1=document.getElementsByName("v1")[0].value;
    v2=document.getElementsByName("v2")[0].value;
    v3=document.getElementsByName("v3")[0].value;
    v4=document.getElementsByName("v4")[0].value;
    
    equipo1=document.getElementsByName("equipo1")[0].innerText;
    equipo2=document.getElementsByName("equipo2")[0].innerText;
    equipo3=document.getElementsByName("equipo3")[0].innerText;
    equipo4=document.getElementsByName("equipo4")[0].innerText;
    
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
    document.getElementsByName("v1")[0].value=v1;
    document.getElementsByName("v2")[0].value=v2;
    document.getElementsByName("v3")[0].value=v3;
    document.getElementsByName("v4")[0].value=v4; 
}