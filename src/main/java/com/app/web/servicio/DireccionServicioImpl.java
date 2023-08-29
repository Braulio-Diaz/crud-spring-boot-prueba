package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Direccion;
import com.app.web.repositorio.DireccionRepositorio;

@Service
public class DireccionServicioImpl implements DireccionServicio {
	
	@Autowired
	private DireccionRepositorio repositorio;

	@Override
	public List<Direccion> listarTodasLasDirecciones() {
		
		return repositorio.findAll();
	}

	@Override
	public Direccion guardarDireccion(Direccion direccion) {
		
		return repositorio.save(direccion);
	}

	@Override
	public Direccion obtenerDireccionPorId(Long id) {
		
		return repositorio.findById(id).get();
	}

	@Override
	public Direccion ActualizarDireccion(Direccion direccion) {
		
		return repositorio.save(direccion);
	}

	@Override
	public void eliminarDireccion(Long id) {
		
		repositorio.deleteById(id);
		
	}

	@Override
	public Object listarDireccionesPorUsuario(Long id) {
		
		return repositorio.findAll();
	}

}
