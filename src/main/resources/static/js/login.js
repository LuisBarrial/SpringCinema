// Call the dataTables jQuery plugin
$(document).ready(function() {
    //onready
});

async function iniciarSesion(){
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    const request = await fetch('api/login', {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    
    const respuesta = await request.text();
    if(respuesta != 'FAIL'){
        if (condition) {
            
        } else {
            
        }
        localStorage.token = respuesta;
        localStorage.email = datos.email;
        window.location.href = 'index'
    } else{
        alert("Los datos ingresados son incorrectos. Por favor intente nuevamente");
    }
}