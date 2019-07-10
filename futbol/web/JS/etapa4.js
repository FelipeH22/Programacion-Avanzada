equipo1=document.getElementsByName("equipo1");
equipo2=document.getElementsByName("equipo2");
equipo2="Urugay";
alert("Hay un empate entre "+equipo1+" y "+equipo2);
v1 = prompt("Digite el valor en prorroga de "+equipo1);
v2 = prompt("Digite el valor en prorroga de "+equipo2);

if(v1>v2){
	ganador=equipo1;
}
else
{
	if(v1<v2){
		ganador=equipo2;
	}
	if(v1==v2){
		alert("Hay un empate entre "+equipo1+" y "+equipo2);
		v1 = prompt("Digite el valor en penaltis de "+equipo1);
		v2 = prompt("Digite el valor en penaltis de "+equipo2);
	}
}
alert(ganador);
document.getElementsByName("v1").value(v1);
document.getElementsByName("v2").value(v2);