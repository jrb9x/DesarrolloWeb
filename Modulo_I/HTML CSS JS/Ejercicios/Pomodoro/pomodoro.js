
/*Variables globales*/
var tareas = new Array();
var usuario;
var reg = "";
var boton= "";
var m = 25; 
var s = 0;
var rutaAlarma = "";
var minRegistrado;
var sonido = new Audio();
var cancela = 0;
var pausa = 0;
var time;
var posicion;
var alerta;
//----------------------------------------------------------------------------------------------------
//Registro y validacion de la tarea

function opciones(tarea, pomodoro, tTarea, tDesCor, tDesLar, rutaAlarma)
{
	this.tarea=tarea;
	this.pomodoro=pomodoro;
	this.tTarea=tTarea;
	this.tDesCor=tDesCor;
	this.tDesLar=tDesLar;
	this.rutaAlarma=rutaAlarma;
}

function registrarTarea(){
	
	var tarea = document.getElementById("tarea").value.trim();
	var pomodoro = document.getElementById("pomodoro").value;
	var tTarea = document.getElementById("tTarea").value;
	var tDesCor = document.getElementById("tDesCor").value;
	var tDesLar = document.getElementById("tDesLar").value;
	
	var opcion = document.getElementById("mySelect").value;
	switch(opcion){
		case "1":
			rutaAlarma = "http://upload.wikimedia.org/wikipedia/commons/c/ce/Sound-of-dog.ogg";
			break;
		case "2":
			rutaAlarma = "https://upload.wikimedia.org/wikipedia/commons/3/3e/Indian_Peafowl.ogg";
			break;
		case "3":
			rutaAlarma = "https://upload.wikimedia.org/wikipedia/commons/2/2c/On_hold_tone.ogg";
			break;
		case "4":
			rutaAlarma = "https://upload.wikimedia.org/wikipedia/commons/e/e9/Explosions-LS100152.ogg";
			break;
	}
	var validar = validarFormulario(tarea, pomodoro, tTarea, tDesCor, tDesLar);
	if(validar == true){
		usuario = new opciones(tarea, pomodoro, tTarea, tDesCor, tDesLar, rutaAlarma); 
		tareas.push(usuario);
		resetFormulario();
		mostrarTarea();
	}
	else
		document.getElementById("errorDatos").innerHTML = "*Rellena todo el formulario";
		
}


function validarFormulario(tarea, pomodoro, tTarea, tDesCor, tDesLar){
	if(tarea.length != 0 && pomodoro != 0 && tTarea != 0 && tDesCor != 0 && tDesLar != 0){
		return true;
	}
	else{
		return false;
	}
}

function resetFormulario(){
	var form=document.getElementById("formulario"); //almacena el identificador del formulario para resetear el formulario
	form.reset(); //resetea el formulario 
	document.getElementById("errorDatos").innerHTML = "";
}
//-------------------------------------------------------------------------------------------------------------------------
//Opciones de tiempo estandar
function tiempoTarea(){
	m = 25; 
	s = 0;
	reloj();
	botonStart();
}

function descansoCorto(){
	m = 5; 
	s = 0;
	reloj();
	botonStart();
}

function descansoLargo(){
	m = 15; 
	s = 0;
	reloj();
	botonStart();
}
//Opciones de tiempo personalizadas por el usuario
function tiempoTareaReg(i){
	minRegistrado = tareas[i].tTarea; 
	s = 0;
	relojRegistro(minRegistrado);
	botonStartRegistro();
}

function descansoCortoReg(i){
	minRegistrado = tareas[i].tDesCor; 
	s = 0;
	relojRegistro(minRegistrado);
	botonStartRegistro();
}

function descansoLargoReg(i){
	minRegistrado = tareas[i].tDesLar; 
	s = 0;
	relojRegistro(minRegistrado);
	botonStartRegistro();
}
//-------------------------------------------------------------------------------------------------------------------
//Funcion de cuenta atras en tareas estandar y en tareas registradas por el usuario

function botonStart(){
	boton = "<button id=\"start\" onclick=\"countDown()\">Start</button>";
	document.getElementById("pausar").innerHTML = boton;
}

function botonStartRegistro(){
	boton = "<button id=\"start\" onclick=\"countDownRegistro()\">Start</button>";
	document.getElementById("pausar").innerHTML = boton;
}

function countDown() {
	
	boton = "<button id=\"pause\" onclick=\"pauseCountDown()\">Pause</button>"
	document.getElementById("pausar").innerHTML = boton;

	if(pausa == 0){
		s = s-1;
		if(s < 0){
			s = 59;
			m = m-1;
		}
		
		if(m < 0){
			s = 0;
			m = 0;
		
		}
		else{
			reloj();
		}
	}
	else{
		reloj();
		boton = "<button id=\"pause\" onclick=\"reanudeCountDown()\">Resume</button>"
		document.getElementById("pausar").innerHTML = boton;
	}
	
    if(cancela == 0){
		time = setTimeout(function(){countDown()},1000);
	}
	else{
		limpiarRegistro();
	}
	
	if(m == 0 && s == 0){
		var txt = "<button id=\"stopSonido\" onclick=\"pararAlerta()\">PARAR ALARMA</button>";
		document.getElementById("booleano").innerHTML = txt;
		if(rutaAlarma == ""){
			rutaAlarma = "http://upload.wikimedia.org/wikipedia/commons/c/ce/Sound-of-dog.ogg";
		}
		sonido.src = rutaAlarma;
		alerta = setInterval(function(){reproducirAlerta()},3000);
	}
	
}

function countDownRegistro(){
	boton = "<button id=\"pause\" onclick=\"pauseCountDown()\">Pause</button>"
	document.getElementById("pausar").innerHTML = boton;

	if(pausa == 0){
		s = s-1;
		if(s <0 ){
			s = 59;
			minRegistrado = minRegistrado - 1;
		}

		if(minRegistrado < 0){
			s = 0;
			minRegistrado = 0;
			}
		else{
			minRegistrado = pad_left(minRegistrado);    
			relojRegistro(minRegistrado);
		}
	}
	else{
		relojRegistro(minRegistrado);
		boton = "<button id=\"pause\" onclick=\"reanudeCountDown()\">Resume</button>"
		document.getElementById("pausar").innerHTML = boton;
	}
	
	
    if(cancela == 0){
		var time = setTimeout(function(){countDownRegistro()},1000);//en tiempo creamos una funcion generica que cada 1000 milisegundos ejecuta la funcion countDownRegistro()
	}
	else{
		limpiarRegistro();
	}
	
	
	if(minRegistrado == 0 && s == 0){
		var txt = "<button id=\"stopSonido\" onclick=\"pararAlerta()\">PARAR ALARMA</button>";
		document.getElementById("booleano").innerHTML = txt;
		sonido.src = rutaAlarma;
		alerta = setInterval(function(){reproducirAlerta()},3000);
	
	}
}

//----------------------------------------------------------------------------------------------------------------------------------------
//Resetear el registro al tiempo estandar
function limpiarRegistro(){

	clearTimeout(time);
	cancela = 0;
	pausa = 0;
	tiempoTarea();
	tareaEstandar();
	
}

//Funciones de reproduccion y parada de la alerta
function reproducirAlerta(){
	sonido.play();
	}
	
function pararAlerta(){
	sonido.pause();
	limpiarRegistro();
}

//Funciones para mostrar el reloj con los minutos deseados y siempre con dos digitos
function reloj(){
	m = pad_left(m);    
	s = pad_left(s);
    document.getElementById('displayReloj').innerHTML = m+":"+s;
	document.getElementById('titulo').innerHTML = m+":"+s+" || POMODORO";
}

function relojRegistro(minRegistrado){
	minRegistrado = pad_left(minRegistrado);    
	s = pad_left(s);
	document.getElementById('displayReloj').innerHTML = minRegistrado+":"+s;
	document.getElementById('titulo').innerHTML = minRegistrado+":"+s+" || POMODORO";
}

function pad_left(number) {
    var s;
    s = number + '';
    while (s.length < 2) {
        s = "0" + s;
    }
    return s;
}

//Funciones para el control de la cuenta atras
function pauseCountDown(){
	pausa = 1;
}

function stopCountDown(){
	cancela = 1;
}

function reanudeCountDown(){
	pausa = 0;
}

//---------------------------------------------------------------------------------------------------------------------
//Cargar y Mostrar las tablas de las tareas
function mostrarTarea(){
	var reg = "<h2>TAREAS REGISTRADAS</h2><table id=\"tablaRegistros\">"
	reg += "<tr> <th>TAREA</th>"
		+ "<th>TIEMPO POMODORO</th>"
		+ "<th>DESCANSO CORTO</th>"
		+ "<th>DESCANSO LARGO</th>"
		+ "<th>TIEMPO ESTIMADO</th>"
		+ "<th> </th></tr>";
	var leng = tareas.length;
	for (var i = 0; i < leng; i++) {
		var pomodoro = tareas[i].pomodoro;
		var tPomodoro = tareas[i].tTarea;
		var tCorto = tareas[i].tDesCor;
		var tLargo = tareas[i].tDesLar;
		
		var estimado = (pomodoro * tPomodoro) + ((pomodoro%1) * tCorto) + ((pomodoro%4) * tLargo);
		
		reg += "<tr><td>"+tareas[i].tarea+"</td>" 
			+ "<td>"+tPomodoro+"</td>"
			+ "<td>"+tareas[i].tDesCor+"</td>" 
			+ "<td>"+tareas[i].tDesLar+"</td>"
			+ "<td>"+ estimado +"</td>"
			+ "<td>"+ "<button onclick=cargarTarea("+i+")>EMPEZAR</button></td></tr>"; 
	}
	reg += "</table>";
	document.getElementById("generarTabla").innerHTML = reg;
}

function detallesTarea(){
	var detalle = "<h2>TAREAS REGISTRADAS</h2><table id=\"tablaRegistros\">"
	detalle += "<tr> <th>TAREAS</th> <th>POMODOROS</th> <th>TIEMPO ESTIMADO</th> <th>DESCANSO CORTO</th> <th>DESCANSO LARGO</th></tr>";
	var leng = tareas.length;
	for (var i = 0; i < leng; i++) {
		console.log(i);
		detalle += "<tr><td>"+tareas[i].tarea+"</td>" 
			+ "<td>"+tareas[i].pomodoro+"</td>"
			+ "<td>"+tareas[i].tTarea+"</td>"
			+ "<td>"+tareas[i].tDesCor+"</td>" 
			+ "<td>"+tareas[i].tDesLar+"</td>"
			+ "<td>"+ "<button onclick=cargarTarea("+i+")>EMPEZAR</button></td></tr>"; 
	}
	detalle += "</table>"
	document.getElementById("detallarTabla").innerHTML = detalle;
}

function cargarTarea(posicion){
	minRegistrado = tareas[posicion].tTarea;
	var tarea = tareas[posicion].tarea;
	relojRegistro(minRegistrado);
	boton = "<button onclick=\"tiempoTareaReg("+posicion+")\">"+tarea+"</button>"
	document.getElementById("tiempoPomodoro").innerHTML = boton;
	boton = "<button onclick=\"descansoCortoReg("+posicion+")\">Descanso Corto</button>"
	document.getElementById("descansoCorto").innerHTML = boton;
	boton = "<button onclick=\"descansoLargoReg("+posicion+")\">Descanso Largo</button>"
	document.getElementById("descansoLargo").innerHTML = boton;
	botonStartRegistro();
}

function tareaEstandar(){
	reloj();
	boton = "<button onclick=\"tiempoTarea()\">Pomodoro</button>"
	document.getElementById("tiempoPomodoro").innerHTML = boton;
	boton = "<button onclick=\"descansoCorto()\">Descanso Corto</button>"
	document.getElementById("descansoCorto").innerHTML = boton;
	boton = "<button onclick=\"descansoLargo()\">Descanso Largo</button>"
	document.getElementById("descansoLargo").innerHTML = boton;
	botonStart();
}

