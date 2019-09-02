function soloNumeros(e) {
	var keynum = window.event ? window.event.keyCode : e.which;
	if ((keynum == 8) || (keynum == 46))
		return true;

	return /\d/.test(String.fromCharCode(keynum));
}

function letrasNumeros(e) {
	key = e.keyCode || e.which;
	tecla = String.fromCharCode(key).toLowerCase();
	letras = " 0123456789abcdefghijklmn�opqrstuvwxyz_";
	especiales = [ 8, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 37, 39, 46 ];

	tecla_especial = false;
	for ( var i in especiales) {
		if (key == especiales[i]) {
			tecla_especial = true;
			break;
		}
	}

	if (letras.indexOf(tecla) == -1 && !tecla_especial)
		return false;
}

function limpia() {
	var val = document.getElementById("miInput").value;
	var tam = val.length;
	for (i == 0; i < tam; i++) {
		if (!isNaN(val[i]))
			document.getElementById("miInput").value = '';
	}
}

function limpiaCampoNumero(numero, idComponente) {
	if (!/^([0-9])*$/.test(numero)) {
		document.getElementById(idComponente.id).value = '0';
	}
}

function limpiaCampoNumeroTamanio(numero, idComponente) {
	if (!/^([0-9])*$/.test(numero)) {
		document.getElementById(idComponente.id).value = '';
	}
}
// function limpiaCampoLetras(componente){
// // if(!/^([a-zA-Z0-9 _])*$/.test(cadena)){
// // document.getElementById(componente).value = '';
// // }
// alert('Hola'+componente.getValue());
// }

document.onkeydown = desabilitar; // Teclas Precionada
document.onselectstart = selecionar; // Anular la Selecion de Texto
document.oncontextmenu = selecionar; // Anular el Boton Der del Mouse

function selecionar() {
	return false;
}

function desabilitar() {
	// Combinacion de Teclas con el Control
	if (event.ctrlKey) {
		switch (window.event.keyCode) {
		case 67: // Ctrl-C -- Copiar ---
		case 86:// Ctrl-V -- Pegar ---
		case 85:
			event.keyCode = 0;
			return false;

			// aqui puede poner todas las tecla de combinacion que tiene
			// programado el ie, para anularlo.

		default:
			break;
		}
	}
}
