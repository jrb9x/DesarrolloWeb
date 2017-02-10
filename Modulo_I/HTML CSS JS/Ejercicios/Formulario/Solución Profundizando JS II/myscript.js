
/*Variables globales*/
var usuario; //variable global que almacenará el futuro objeto usuario
	var usuariosRegistrados= new Array(); //array global que almacenará en cada elemento cada objeto usuario validado
	var errores =new Array();	//array que almacena los mensajes de errores devuelto por la validación de los campos
	var modifico=0;	//controlar si el formulario está en modo de edición para mostrar botón Guardar cambios (será 1 cuando se modifique)
	var numRegistro=0; //variable que apuntará al registro actual a eliminar o modificar
	var indexArray; //variable que almacena el indice del array a modificar
--------------------------------------------------------------------------------------------*/
function persona(nom, apellidos, fNac, nick, email, pass) //constructor para el objeto usuario
		{
			this.nombre=nom;
			this.apellidos=apellidos;
			this.fNac=fNac;
			this.nick=nick;
			this.email=email;
			this.pass=pass;
		}
	
			
function validarForm(){
	var nUser=validarNombre();	//llama a la función validarNombre para comprobar que es válido y retornarlo en la variable nUser
	var apeUser=validarApellidos();//llama a la función validarApellidos para comprobar que es válido y retornarlo en la variable nApellidos
	var fNac=validarfNac(); 	//comprueba que la edad es igual o superior a 18 años, y retornar la fecha en a variable fNac
	var nick=validarNick();		//comprueba que no el nick no esté repetido localizándolo en el array de ususarios registrados
	var email=validarMail();	//comprueba que no email tenga un formato correcto, retornandolo en la variable email  
	validarPass();	 			//comprueba que la password tenga al menos 6 caracteres
	var pass=validarPass2(); //comprueba que las dos passwords sean iguales y retornará el valor en la variable pass
	mostrarErrores(); 	//Visualiza el array donde se van guardando cada uno de los errores validados
	if(errores.length==0){	//comprueba que no hay errores
		usuario=new persona(nUser,apeUser,fNac,nick,email,pass); //guarda los campos del formulario en la variable objeto
		if(modifico==0){
			registrarUsuario(); // si no hay errores llama a la función registrarUrsuario para guardar los valores en el objeto usuario
		}
		else{
			return true;	//retorna true a la llamada de la función modificar
		}
	}	
}	
//--------------------------------------------------------------------------------------------
/*Las siguientes funciones validan cada uno de los campos, según los requisitos de cada uno de ellos. 
	Si no cumplen el requisito, almacena un mensaje de error en el array Errores.
	En caso correcto, devuelve a la función de llamada el campo del formulario correcto*/
function validarNombre()
{
	var nUser = document.getElementById("nombreForm").value.trim();
	if(nUser.length <3){
		errores.push("* El nombre debe ser mayor de 2 caracteres");
	}
	else return nUser;
}

function validarApellidos()
{
	var apeUser = document.getElementById("apellidosForm").value.trim();
	if(apeUser.length <3){
		errores.push("* Los apellidos debe ser mayor de 2 caracteres");
	}
	else return apeUser;	
}

function validarfNac(){
	var fNac = new Date(document.getElementById("fNacForm").value);
	edad=calcularAnnyos(fNac);
	if(edad< 18){
		errores.push("* No puedes registrarte si tienes menos de 18 años");
	}
	else if(isNaN(edad)){
		errores.push("* No has introducido la fecha de nacimiento");
		}
		else return fNac;
}
function calcularAnnyos(fNac){ //recibe una fecha (tipo Date) y devuelve los años)
	var hoy = new Date();
	var annyos;
	annyos=(hoy-fNac)/1000/3600/24/365.25;
	annyos=Math.floor(annyos);
	return annyos;
}	
function validarNick(){
	var nick = document.getElementById("nickForm").value.trim();
	for (i=0;i<usuariosRegistrados.length && modifico==0;i++){	//recorre el array de usuarios registrados a excepción de si se trata de una modificación
		if(usuariosRegistrados[i].nick===nick){	//comprueba si existe el nick
			errores.push("* Ya exite otro usuario registrado con ese nick");
			break;
		}
	}
	return nick;
}

function validarMail(){ 	//función que comprueba que la dirección del correo electrónico sea el adecuado
	var email = document.getElementById("emailForm").value.trim();
	expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; //expresión regular para validar el formato del email
    if (!expr.test(email) )
        errores.push("* La dirección de correo " + email + " es incorrecta.");
	else return email;
}
	
function validarPass(){	//función que comprueba que la contraseña tenga un mínimo de 6 caracteres
	var pass = document.getElementById("passForm").value.trim();
	if(pass.length <6){
		errores.push("* La contraseña debe tener un mínimo de 6 caracteres");
	}
}

function validarPass2(){	//función que comprueba que la repetición de la contraseña sea igual a la anterior
	var pass = document.getElementById("passForm").value.trim();
	var pass2 = document.getElementById("pass2Form").value.trim();
	if(pass !=pass2){
		errores.push("* Las contraseñas introducidas no son iguales");
	}
	else return pass2;	
}

function mostrarErrores(){
	var text="";
	for(var i=0; i<errores.length;i++){
		text+=errores[i]+"<br>";
	}
	document.getElementById("error").innerHTML=text;
	errores=[];
}

//-------------------------------------------------------------------------------

function registrarUsuario(){ 	//Registra los datos del formulario validado
	usuariosRegistrados.push(usuario);	//Añade el objeto usuario al último elemento del array de usuarios registrados
	mostrarUsuarios();
}
function mostrarUsuarios(){
	if(usuariosRegistrados.length >0){	//si hay usuarios registrados
		document.getElementById("tregistrados").style.visibility='visible';	//activa la tabla de los usuarios registrados
		document.getElementById("vacia").innerHTML="";
	}	
	document.getElementById("tregistrados").innerHTML="<caption><h3>Listado de usuarios registrados</h3></caption><tr><th>Nombre de usuario</th><th>Nombre</th><th>Edad</th>"+
					"<th>Correo electrónico</th>"+"<th>Eliminar</th>"+"<th>Modificar</th>"+"</tr>";
	for(i in usuariosRegistrados){
	document.getElementById("tregistrados").innerHTML+= "<tr>" 
											+"<td>" + usuariosRegistrados[i].nick + "</td>"
											+ "<td>" + usuariosRegistrados[i].nombre + "</td>"
											+ "<td>" + calcularAnnyos(usuariosRegistrados[i].fNac)+ "</td>" 
											+ "<td>" + usuariosRegistrados[i].email + "</td>"
											+ "<td>" + "<button onclick='eliminarUsuario("+i+")'>Eliminar</button>" + "</td>"
											+ "<td>" + "<button onclick='modificarUsuario("+i+")'>Modificar</button>" + "</td>"
											+ "</tr>";
	}
	
	resetFormulario();	//Borra los datos del formulario del usuario registrado*/
	
	console.log(usuariosRegistrados);
	botonBorrarForm.style.visibility="hidden"; //Oculta el botón Cancelar formulario
}


function eliminarUsuario(posicion){		//Elimima el usuario del array pasado en el argumento el objeto fila a eliminar
		usuariosRegistrados.splice(posicion,1);	//el primer parámetro indica en qué lugar se eliminará el elemento, el segundo, cuántos elementos se van a eliminar	*/
		mostrarUsuarios();
	if(usuariosRegistrados.length ==0){
		document.getElementById("tregistrados").style.visibility='hidden';	//si no quedan usuarios, oculta la tabla de los usuarios registrados
		document.getElementById("vacia").innerHTML="No hay usuarios registrados";
	}
}	

function modificarUsuario(posicion){	//edita el registro para su modificación
	indexArray=posicion;
	document.getElementById("msgestado").innerHTML="Modificación de registro";	//Mensaje de cabecera a visualizar en modo de edición
	
	//las siguientes instrucciones recuperan del índice del array localizado los datos y los coloca en el formulario para su edición
	document.getElementById("nombreForm").value=usuariosRegistrados[indexArray].nombre; 
	document.getElementById("apellidosForm").value=usuariosRegistrados[indexArray].apellidos;
	document.getElementById("fNacForm").value=usuariosRegistrados[indexArray].fNac.getFullYear() 
										+ "-" + ("0".concat(usuariosRegistrados[indexArray].fNac.getMonth()+1)).slice(-2)
										+ "-" + ("0".concat(usuariosRegistrados[indexArray].fNac.getDate())).slice(-2);
	document.getElementById("nickForm").value=usuariosRegistrados[indexArray].nick;
	document.getElementById("emailForm").value=usuariosRegistrados[indexArray].email;
	document.getElementById("passForm").value=usuariosRegistrados[indexArray].pass;
	document.getElementById("pass2Form").value=usuariosRegistrados[indexArray].pass;
	
	//Ahora se oculta el botón Registrar y se visualiza el botón Guardar cambios
	var boton=document.getElementById("botonRegistrar");
	boton.style.display='none'; //Oculta el botón Registrar
	var boton2=document.getElementById("botonModificar");
	boton2.style.display='';  //Visualiza el botón Guardar cambios
	botonCancelar();
	
	
}
function guardarCambios(){	//función llamada por el botón Guardar cambios para almacenar los datos del formulario
	modifico=1;	//Se indica que se está en modo de edición 
	control=validarForm(); //se envían los nuevos a la función validar y esta retornará true controlando que es una modificación	
	
	if(control==true){	//En el caso de que la variable de control sea true, datos validados, se procede a guardar los cambios
		usuariosRegistrados[indexArray]=usuario;	//guarda los cambios del formulario en el índice del array editado almacenado en la variable global indexArray
		mostrarUsuarios();		
		//Revertimos la visualización de los botones: visible para Registrar, y oculto para Guardar cambios						
		var boton=document.getElementById("botonRegistrar");
		boton.style.display=''; //Visualiza el botón Registrar
		var boton2=document.getElementById("botonModificar");
		boton2.style.display='none';  //Muestra el botón Modificar
		botonBorrarForm.style.visibility="hidden";
		modifico=0;	//se indica que la tabla ya no está en modo de edición
		document.getElementById("msgestado").innerHTML="Por favor, introduzca los siguientes datos:";//Mensaje de cabecera al registrar nuevo usuario
		resetFormulario();
		}
}
function cancelarCambios(){ //Cancela los cambios del formulario editado
	var boton=document.getElementById("botonRegistrar");
		boton.style.display=''; //Visualiza el botón Registrar
		var boton2=document.getElementById("botonModificar");
		boton2.style.display='none';  //Muestra el botón Modificar
		
		modifico=0;	//se indica que la tabla ya no está en modo de edición
		document.getElementById("msgestado").innerHTML="Por favor, introduzca los siguientes datos:";//Mensaje de cabecera al registrar nuevo usuario
		resetFormulario();
}

function botonCancelar(){	//hacer visible en cuanto se cambien los campos del formulario
		botonBorrarForm.style.visibility="visible";
	
}
function resetFormulario(){
	var form=document.getElementById("formulario"); //almacena el identificador del formulario para resetear el formulario
	form.reset(); //resetea el formulario 
}
