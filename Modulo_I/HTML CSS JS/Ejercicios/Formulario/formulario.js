function persona(nom, ape, edad, user, correo, passw)
{
	this.nombre=nom;
	this.apellido=ape;
	this.edad=edad;
	this.usuario=user;
	this.correo=correo;
	this.passw=passw; 
}
var usuario;
var usuariosRegistrados= new Array();
var txt = "";
	
function validarUsuario(){

	var nombre = document.getElementById("nombre").value.trim();
	var nombreOk = validarNombre(nombre);
	var apellidos = document.getElementById("apellidos").value.trim();
	var apellidosOk = validarApellidos(apellidos);//validar nombre y apellidos
	var fNac = document.getElementById("fechaNac").value;
	edad = fEdad(fNac);//calcular edad y vaidar
	var user = document.getElementById("nombreUsuario").value;
	var userOk = validarUser(user);//validar nombre de usuario
	var correo = document.getElementById("correo").value;
	var correoOk = validarEmail(correo);//validar correo electronico
	/*if(correoOk == true && userOk == true){
		var noExiste= buscarUser(user);}*/
	var passw = document.getElementById("passw").value;
	var passwV = document.getElementById("passwV").value;
	var passwOk = validarPasswd(passw, passwV);//validar contraseña
	if(nombreOk == true && correoOk == true && userOk == true && apellidosOk == true && passwOk ==true/* && noExiste == true*/){
		usuario = new persona(nombre,apellidos,edad,user,correo,passw); 
		usuariosRegistrados.push(usuario);
		mostrarUsuario();
		var form = document.getElementById("formulario"); //almacena el identificador del formulario para resetear el formulario
		form.reset();
		document.getElementById("demo").innerHTML = "";
		
	}
	else{
		document.getElementById("demo").innerHTML = txt;
		txt = "";
	
	}
}

function validarEmail(mail){
	var correOk = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(mail);
    if(correOk == true)
		return true;
	else{
		txt += "*Correo mal escrito<br>";
		return false;
	}
}

function validarNombre(nombre){
	if(nombre.length > 2){
		return true;
	}
	else{
		txt += "*Nombre incorrecto (más de 2 caracteres)<br>";
		return false;
	}
}	
function validarApellidos(apellidos){
	if(apellidos.length > 2){
		return true;
	}
	else{
		txt += "*Apellidos incorrectos (más de 2 caracteres)<br>";
		return false;
	}
}
function fEdad(fNac){
	var fNac = new Date(fNac);
	var hoy=new Date();
	var anios=(hoy.getTime()-fNac.getTime())/1000/3600/24/365.25; 
	anios=Math.floor(anios);
	var aniosOk = validarAnio(anios);
	if(aniosOk == true){
		return anios;
	}
	else{
		txt += "*No eres mayor de edad<br>";
	}
}
function validarAnio(anios){

	if(anios >= 18){
		return true;
	}
	else{
		return false;
	}	
}

function validarUser(user){
	
	if(user === ""){
		txt += "*Escribe usuario<br>";
		return false;
	}
	else{
		return true;
	}
}
/*Comprobacion
function buscarUser(user){
	var leng = usuariosRegistrados.length;
	var userExist = 0;
	if(length > 1){
		var x;
		for (x in usuariosRegistrados){
			var buscar = usuariosRegistrados[x].usuario;
			if(buscar === user){
				txt += "*Este usuario ya existe<br>";
				userExist += 1;
				console.log(userExist);
			}
			else{
				userExist += 0;}
		}
		if(userExist > 0){
			return false;
		}
		else{
			return true;
		}
			
	}
	else{
		return true;}
}
*/
function validarPasswd(passw, passwV){
	var passwOk = leng(passw);
	if(passw === passwV && passwOk == true){
		return true;
	}
	else{
		txt += "*Las contraseñas no coinciden";
		return false;
	}
}
function leng(passw){
	if(passw.length > 5){
		return true;
	}
	else{
		txt += "*Introducir contraseña de mas de 6 caracteres<br>";
		return false;
	}
}

function mostrarUsuario(){
	
	var reg = "";
	reg += "<tr> <th>Nombre de Usuario</th> <th>Nombre</th> <th>Edad</th> <th>Correo Electrónico</th> <th> </th> <th> </th></tr>";
	var leng = usuariosRegistrados.length;
	for (var i = 0; i < leng; i++) {
		console.log(i);
		reg += "<tr><td>"+usuariosRegistrados[i].usuario+"</td> <td>"+usuariosRegistrados[i].nombre+"</td> <td>"+usuariosRegistrados[i].edad+"</td> <td>"+usuariosRegistrados[i].correo+"</td><td>"+
		"<button id=\" "+i+" \" onclick=modificarUsuario()>Modificar</button></td> <td><button id=\" "+i+" \" onclick=eliminarUsuario()>Eliminar</button></td></tr>"; 
		
	}
	document.getElementById("generarTabla").innerHTML = reg;
}

function modificarUsuario(){
	var i = document.getElementById("id");
	document.getElementById("nombre").innerHTML = usuariosRegistrados[i].nombre;
	document.getElementById("apellidos").innerHTML = usuariosRegistrados[i].apellido;
	document.getElementById("fechaNac").innerHTML = usuariosRegistrados[i].edad;
	document.getElementById("nombreUsuario").innerHTML = usuariosRegistrados[i].usuario;
	document.getElementById("correo").innerHTML = usuariosRegistrados[i].correo;
	document.getElementById("passw").innerHTML = usuariosRegistrados[i].passw;
	//validarUsuario();
	//mostrarUsuario();
}

function eliminarUsuario(){
	var i = document.getElementById("id");
	console.log(i);
	usuariosRegistrados.splice(i, 1);
	console.log(i);
	mostrarUsuario();
}