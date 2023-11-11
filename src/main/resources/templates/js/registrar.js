function registrarUsuario() {
    let datos = {};
    datos.password = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if (repetirPassword != datos.password) {
        alert('Las contraseñas son diferentes.');
        return;
    } else {
        alert("La cuenta fue creada con exito!");
        window.location.href = 'login.html'
    }


}


