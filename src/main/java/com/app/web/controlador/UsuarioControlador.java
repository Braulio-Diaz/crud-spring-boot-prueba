package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.servicio.UsuarioServicio;
import com.app.web.entidad.Usuario;

@Controller
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping({"/usuarios"})
	public String listarUsuarios(Model model){
		model.addAttribute("usuarios", servicio.listarTodosLosUsuarios());
		return "usuarios";
	}
	
	@GetMapping("/usuarios/crear")
	public String mostrarFormularioDeRegistrarEstudiante(Model model){
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "crear_usuario";
		
	}
	
	@PostMapping("/usuarios")
	public String guardarUsuarios(@ModelAttribute("usuario") Usuario usuario){
		servicio.guardarUsuario(usuario);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model model){
		model.addAttribute("usuario", servicio.obtenerUsuarioPorId(id));
		
		return "editar_usuario";
	}
	
	@PostMapping("/usuarios/{id}")
	public String actualizarUsuarios(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario, Model model) {
		Usuario usuarioExistente = servicio.obtenerUsuarioPorId(id);
		usuarioExistente.setId(id);
		usuarioExistente.setNombres(usuario.getNombres());
		usuarioExistente.setApellidos(usuario.getApellidos());
		servicio.ActualizarUsuario(usuarioExistente);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/usuarios/{id}")
	public String eliminarUsuario(@PathVariable Long id){
		servicio.eliminarUsuario(id);
		
		return "redirect:/usuarios";
	}
}
