# Programacion-Avanzada

Modelo vista controlador

Deben existir tres clases principales, donde vista se encargue de la interfaz de usuario, controlador de la conexi�n con el teclado y ActionListeners en general y el modelo se encargue de llevar todas las operaciones y dem�s elementos necesarios para el programa

Principios S.O.L.I.D

Cada clase se construye con una finalidad concreta.
Seg�n la sustituci�n de Liskov las clases derivadas se comportan como la clase base, es decir que se acepta una asignacion de la clase base a las derivadas

	Creacion de una interfaz

	Una interfaz se crea as�:

		"interface i {
			int x=8;
			void F();
		}"

	Se impleenta as�:

		class A implements i{
			int f()
			{
				return x*x;
			}
		
		
		}
		
		class B implements i{
			
			int f()
			{
				return x*x*x;
			}
		
		}
	Y en el main 
	
		main....{
			A o1 = new A();
			B o2 = new B();
			System.out.println(o1.f());
			System.out.println(o2.f());
		}
	
	Clases abstractas 

	Pueden existir m�todos abstractos, m�todos normales, etc.