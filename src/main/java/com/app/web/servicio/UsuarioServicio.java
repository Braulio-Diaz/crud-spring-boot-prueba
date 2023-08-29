package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Usuario;

public interface UsuarioServicio {
	
	public List<Usuario> listarTodosLosUsuarios();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuarioPorId(Long id);
	
	public Usuario ActualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
}
