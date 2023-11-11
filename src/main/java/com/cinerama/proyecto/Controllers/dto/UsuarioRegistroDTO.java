package com.cinerama.proyecto.Controllers.dto;

public class UsuarioRegistroDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private String telefono;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRegistroDTO(Long id, String nombre, String apellido, String email, String dni, String telefono, String password) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.password = password;
    }

    public UsuarioRegistroDTO(String nombre, String apellido, String email, String dni, String telefono, String password) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.password = password;
    }

    public UsuarioRegistroDTO(String email) {
        super();
        this.email = email;
    }

    public UsuarioRegistroDTO() {
    }
}
