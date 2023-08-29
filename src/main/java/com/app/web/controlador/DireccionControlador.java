package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Direccion;
import com.app.web.entidad.Usuario;
import com.app.web.servicio.DireccionServicio;

@Controller
public class DireccionControlador {
	
	@Autowired
	private DireccionServicio servicio;
	
	@GetMapping("/usuarios/ver/{id}")
	public String listarDirecciones(@PathVariable Long id, Model model){
		model.addAttribute("direcciones", servicio.listarDireccionesPorUsuario(id));
		
		return "ver_direccion";
	}
	
	@GetMapping("/direcciones/crear")
	public String mostrarFormularioDeRegistrarDireccion (Model model){
		Direccion direccion = new Direccion();
		model.addAttribute("direccion", direccion);
		
		return "crear_direccion";
		
	}
	
	@PostMapping("/direccion_creada")
	public String guardarDirecciones(@ModelAttribute("direccion") Direccion direccion){
		servicio.guardarDireccion(direccion);
		
		return "redirect:/direccion_creada";
	}
	
	@GetMapping("/direcciones/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model model){
		model.addAttribute("direccion", servicio.obtenerDireccionPorId(id));
		
		return "editar_direccion";
	}
	
	@PostMapping("/direcciones/{id}")
	public String actualizarDirecciones(@PathVariable Long id, @ModelAttribute("direccion") Direccion direccion, Model model) {
		Direccion direccionExistente = servicio.obtenerDireccionPorId(id);
		direccionExistente.setId(id);
		
		direccionExistente.setCalle(direccion.getCalle());
		direccionExistente.setNumero(direccion.getNumero());
		servicio.ActualizarDireccion(direccionExistente);
		
		return "redirect:/usuarios";
	}
	
	@GetMapping("/direcciones/eliminar/{id}")
	public String eliminarDireccion(@PathVariable Long id){
		Direccion direccion = servicio.obtenerDireccionPorId(id);
		if (direccion != null) {
			Long usuarioId = direccion.getUsuario().getId();
			servicio.eliminarDireccion(id);
			return "redirect:/usuarios/ver/" + usuarioId;
		}
		return "redirect:/usuarios";
	}

}

