package com.cinerama.proyecto.service;

import com.cinerama.proyecto.Controllers.dto.UsuarioRegistroDTO;
import com.cinerama.proyecto.models.entitys.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService{
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    public Usuario guardarUsuarioAdmin(UsuarioRegistroDTO registroDTO);
    public List<Usuario> listarUsuarios();
    public void deleteById(Long id);
}
