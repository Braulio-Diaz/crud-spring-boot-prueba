package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Direccion;

public interface DireccionServicio {
	
	public List<Direccion> listarTodasLasDirecciones();
	
	public Direccion guardarDireccion(Direccion direccion);
	
	public Direccion obtenerDireccionPorId(Long id);
	
	public Direccion ActualizarDireccion(Direccion direccion);
	
	public void eliminarDireccion(Long id);

	public Object listarDireccionesPorUsuario(Long id);

}
