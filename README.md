# Programacion-Avanzada

Modelo vista controlador

Deben existir tres clases principales, donde vista se encargue de la interfaz de usuario, controlador de la conexión con el teclado y ActionListeners en general y el modelo se encargue de llevar todas las operaciones y demás elementos necesarios para el programa

Principios S.O.L.I.D

Cada clase se construye con una finalidad concreta.
Según la sustitución de Liskov las clases derivadas se comportan como la clase base, es decir que se acepta una asignacion de la clase base a las derivadas

	Creacion de una interfaz

	Una interfaz se crea así:

		"interface i {
			int x=8;
			void F();
		}"

	Se impleenta así:

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

	Pueden existir métodos abstractos, métodos normales, etc.