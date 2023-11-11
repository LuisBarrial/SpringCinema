// Call the dataTables jQuery plugin
var myData = "";
let k = 0;
$(document).ready(

function () {
  //on ready
  document.getElementById("txtdesciptionpay").textContent = localStorage.cantidad;
  document.getElementById("txtpay").textContent = "S/" + localStorage.precio;

  myData = JSON.parse(localStorage.data);

  var nombres = [];
  var acum = "";
  while (k < myData.length) {

    acum = acum + " " + myData[k].nombre.trim();
    document.getElementById("txtasientos").innerHTML = acum;
    k++


  }
});

async function registrarUsuarios() {
 this.event.preventDefault();
  var usuario = document.getElementById('cardNumber').value;
  if(usuario.length == 0) {
    alert('No has escrito nada en el numero de targeta');
    return;
  }

  let acumulador = "";
  for (iterator = 0; iterator < myData.length; iterator++) {
    let datos = {};
    datos.costo = localStorage.precio;
    datos.asiento = myData[iterator].nombre.trim()
    acumulador = acumulador + " " + myData[iterator].nombre.trim();

    const request = await fetch('api/guardarInfo', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },

      body: JSON.stringify(datos)
    });
  }

  let info = {};
  info.asiento = acumulador;
  info.costo = localStorage.precio;

  const request = await fetch('api/crearboleto', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

    body: JSON.stringify(info)
  });

}
