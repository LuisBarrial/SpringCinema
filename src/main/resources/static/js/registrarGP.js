$(document).ready(function() {
    //onready
});

async function registrarGenero(){
    let datos = {};
    datos.nombre = document.getElementById('txtNombreGenero').value;

    const request = await fetch('api/generos', {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    alert("El genero fue registrado con exito!");
}