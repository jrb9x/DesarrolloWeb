function persona(nom, ape1, ape2, nac, carnet, estudios) //constructor para el objeto usuario
		{
			this.nombre=nom;
			this.apellido1=ape1;
			this.apellido2=ape2;
			this.fNac=nac;
			this.fCarnet=carnet;
			this.fEstudios=estudios;
		}
		var usuario; //variable global que almacenará el futuro objeto usuario
		var usuariosRegistrados= new Array(); //array global que almacenará en cada elemento cada objeto usuario validado
		
		function registrarForm() { /*Función que se ejecuta al hacer clic en el botón RegistrarUsuarios del formulario. 
									Recoge datos del formulario, los asigna en el objeto usuario y lo añade al array de usuarios*/
			var numcampos=0; //variable control para comprobar que todos los campos se han introducido
			var nombre=document.getElementById("nombre").value.trim(); //Lee el nombre usuario del formulario y elimina los posibles espacios en blanco al ppio y al final
			var apellidos=document.getElementById("apellidos").value.trim(); //Apellidos usuario sin espacios en blanco al ppio y al final
			apellidos=apellidos.concat(" "); //añade un espacio en blanco al final de los apellidos. (prevenir error undifined si no hay 2do apellido)
	
			/* La siguiente separación de los apellidos tendría un fallo en el caso de que la persona 
				solo introdujera un apellido, este sería devuelto como 2do apellido, quedando el 1º vacío
				var apellido1=apellidos.substring(0,apellidos.indexOf(" ")); //almacena primer apellido1
				var apellido2=apellidos.substring(apellidos.indexOf(" ")+1,apellidos.length);//almacena el 2º en apellido2
			*/
			var arrayapellidos=apellidos.split(" "); //Separa en un array los apellidos por espacios en blanco 
			var apellido1=arrayapellidos[0]; //almacena en la variable apellido1 el primer elemento del array			
			var apellido2=arrayapellidos[1]; //almacena en la variable apellido2 el segundo elemento del array	
			
			var fNac=document.getElementById("fechaNac").value; //recupera la fecha de nacimiento del formulario
			var objetofNac=new Date(fNac); //convierte la fecha recogida del formulario de tipo String a tipo Date
			var fCarnet=document.getElementById("fechaCarnet").value; //recupera la fecha del carnet del formulario
			var objetofCarnet=new Date(fCarnet); 
			var fEstudios=document.getElementById("fechaEstudios").value; //recupera la fecha de fin estudios del formulario
			var objetofEstudios=new Date(fEstudios);
			
			//asigna a la variable usuario un nuevo objeto utilizando el constructor persona, pasándole como argumentos las variables que contienen los datos del formulario
			usuario=new persona(nombre,apellido1,apellido2,objetofNac,objetofCarnet,objetofEstudios); 
			usuariosRegistrados.push(usuario); //guarda los datos introducidos en el primer elemento vacio del array
			mostrarDatosUsuario(); //llama a la función para mostrar en la sección 2 los datos que se acaban de registrar
			mostrarPrimer_UltimoRegistrado(); //llamada a la función para mostrar el primer y último usuario registrado
			var form = document.getElementById("formulario"); //almacena el identificador del formulario para resetear el formulario
			form.reset(); //resetea el formulario 
			
		}
		
		function mostrarDatosUsuario(){ /* función que visualiza en la seccción 2: datos del usuario introducido 
										usando la variable objeto usuario. Llama función para calcular los años*/
			document.getElementById("nombreActual").innerHTML=usuario.nombre;
			document.getElementById("apellido1Actual").innerHTML=usuario.apellido1;
			document.getElementById("apellido2Actual").innerHTML=usuario.apellido2;
			formatoFechaYMD(); //llama a la función para mostrar las tres fechas en formato YYYY-MM-DD
			//A continuación llama función para calcular los años (edad)
			document.getElementById("edadActual").innerHTML=calculaAnnyo(usuario.fNac); 
			document.getElementById("anCarnetActual").innerHTML=calculaAnnyo(usuario.fCarnet); //Llama a función para calcular los años
			document.getElementById("anTituloActual").innerHTML=calculaAnnyo(usuario.fEstudios);//Llama a función para calcular los años
		}
		
		function mostrarPrimer_UltimoRegistrado()	{
			//visualizar el primer y último usuario
			var longitud=usuariosRegistrados.length; //calcula los elementos del array de usuarios registrados
			//Muestra los datos del primer usuario registrado (posición [0] del array:)
			document.getElementById("first_nombre").innerHTML=usuariosRegistrados[0]["nombre"] + " " 
															 + usuariosRegistrados[0]["apellido1"] + " " + usuariosRegistrados[0]["apellido2"] + ", "
															 + calculaAnnyo(usuariosRegistrados[0]["fNac"]);
			//Muestra los datos del último usuario registrado (posición [longitud-1] del array:)
			document.getElementById("last_nombre").innerHTML=usuariosRegistrados[longitud-1]["nombre"] + " " 
															 + usuariosRegistrados[longitud-1]["apellido1"] + " " + usuariosRegistrados[longitud-1]["apellido2"] + ", "
															 + calculaAnnyo(usuariosRegistrados[longitud-1]["fNac"]);
			}
		
		function eliminarUltimo(){ //elimina el último usuario registrado
			usuariosRegistrados.pop(); //método pop elimina el último elemento del array
			document.getElementById("first_nombre").innerHTML="No hay usuarios registrados"; //este mensaje se verá cuando ya no quede ningún usuario 
			document.getElementById("last_nombre").innerHTML=" "; // si no queda ningún usuario se mostrará en blanco 
			mostrarPrimer_UltimoRegistrado();			//llama a la función para refrescar el primer y último usuario
			limpiaDatos(); //llama a la función para borrar los datos del último usuario en pantalla
		}
		
		function limpiaDatos(){ //Borra los datos del último usuario en pantalla
			document.getElementById("nombreActual").innerHTML=" ";
			document.getElementById("apellido1Actual").innerHTML=" ";
			document.getElementById("apellido2Actual").innerHTML=" ";
			document.getElementById("edadActual").innerHTML=" "; 
			document.getElementById("nacActual").innerHTML=" ";
			document.getElementById("fcarnetActual").innerHTML=" ";
			document.getElementById("ftituloActual").innerHTML=" ";
			document.getElementById("anCarnetActual").innerHTML=" ";
			document.getElementById("anTituloActual").innerHTML=" "
		}
		
		function calculaAnnyo(fechaDate){ //*Funcion para calcular los años según la fecha de su argumento
			var hoy=new Date(); //fecha actual almacenada en la variable hoy
			var annyos=(hoy.getTime()-fechaDate.getTime())/1000/3600/24/365.25; /*la resta son los milisegundos entre las dos fechas. Se divide para convertir a años.
																				 Dividir entre 365.25 es para aproximarnos a los años bisiestos: 0,25 (1/4 día) cada año */
			annyos=Math.floor(annyos); //parte entera de los años
			return annyos + " años";	
		}
		
		function mostrarAnnyios(){ //*Función para mostrar los años de las tres fechas, llamando a la función calculaAnnyo
			document.getElementById("edadActual").innerHTML=calculaAnnyo(usuario.fNac);
			document.getElementById("anCarnetActual").innerHTML=calculaAnnyo(usuario.fCarnet);
			document.getElementById("anTituloActual").innerHTML=calculaAnnyo(usuario.fEstudios);
		}
		
		function calculaMeses(fechaDate){ //*Funcion para calcular los meses según la fecha de su argumento
			var hoy=new Date();
			var dias=(hoy.getTime()-fechaDate.getTime())/1000/3600/24; //obtenemos el nº en milisegundos y lo convertimos en dias
			var meses=dias%365.25/30.42; // el operador % da el resto de dividir los dias entre 365.25, y esta cifra se divide por 30 dias para convertir a meses  
			meses=Math.floor(meses); //parte entera de los meses
			// Lo siguiente llama a la función calculaAnnyo para obtener años y retorna los años y los meses 
			return calculaAnnyo(fechaDate) + " , " + meses + " meses"; 
		}
		
		function mostrarMeses(){ //Función para mostrar los meses de las tres fechas, llamando a la función calculaMeses
			document.getElementById("edadActual").innerHTML=calculaMeses(usuario.fNac);
			document.getElementById("anCarnetActual").innerHTML=calculaMeses(usuario.fCarnet);
			document.getElementById("anTituloActual").innerHTML=calculaMeses(usuario.fEstudios);
		}
		
		function calculaDias(fechaDate){ //*Funcion para calcular los dias según la fecha de su argumento
			var hoy=new Date();
			var dias=(hoy.getTime()-fechaDate.getTime())/1000/3600/24; //obtenemos el nº en milisegundos y lo convertimos en dias
			var dias=(dias%365.25)%30.42;		//   
			dias=dias.toFixed(0); //parte entera de los meses
			// Lo siguiente llama a la función calculaMeses para obtener años y meses, y retorna los años, meses y días calculados
			return calculaMeses(fechaDate) + " y " + dias + " dias";
		}
		
		function mostrarDias(){ //Función para mostrar los dias de las tres fechas, llamando a la función calculaDias
			document.getElementById("edadActual").innerHTML=calculaDias(usuario.fNac);
			document.getElementById("anCarnetActual").innerHTML=calculaDias(usuario.fCarnet);
			document.getElementById("anTituloActual").innerHTML=calculaDias(usuario.fEstudios);
		}
		
		
		function formatoFechaYMD(){ //Muestra la fecha en formato YYYY-MM-DD llamando a la funcion invertir
			
			document.getElementById("nacActual").innerHTML=invertirYMD(usuario.fNac);
			document.getElementById("fcarnetActual").innerHTML=invertirYMD(usuario.fCarnet);
			document.getElementById("ftituloActual").innerHTML=invertirYMD(usuario.fEstudios);
		}
				
		function invertirYMD(fecha){ //Devuelve la fecha en formato YYYY-MM-DD 
			var fecha=fecha.getFullYear()+"-"+("0".concat(fecha.getMonth()+1)).slice(-2)+"-"+("0".concat(fecha.getDate())).slice(-2); // obtiene cada parte de la fecha:
				/* método getFullYear() devuelve el año, 
					método getMonth() devuelve el mes, al que le sumo 1 ya que devuelve cero para enero. 
					método getDate() devuelve el día de la fecha 
					método concat(), añade un cero delante de los días y meses
					y con el método slice nos quedamos con los dos últimos digitos de días y meses */
			return fecha; //Devuelve la fecha a la llamada de la función
		}
				
		function formatoFechaDMY(){ //Muestra la fecha en formato YYYY-MM-DD llamando a la funcion invertir
			document.getElementById("nacActual").innerHTML=invertirDMY(usuario.fNac);
			document.getElementById("fcarnetActual").innerHTML=invertirDMY(usuario.fCarnet);
			document.getElementById("ftituloActual").innerHTML=invertirDMY(usuario.fEstudios);
		}
		
		function invertirDMY(fecha){//Devuelve la fecha en formato DD-MM-YYYY 
			var fecha =("0".concat(fecha.getDate())).slice(-2)+"/"+("0".concat(fecha.getMonth()+1)).slice(-2)+"/"+fecha.getFullYear(); //sumo 1 al mes
			return fecha;
		}
			
		