package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Direccion;
import com.app.web.entidad.Usuario;
import com.app.web.repositorio.DireccionRepositorio;
import com.app.web.repositorio.UsuarioRepositorio;

@SpringBootApplication
public class CrudSpringBootPruebaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringBootPruebaApplication.class, args);
    }

    @Autowired
    private UsuarioRepositorio repositorio;

    @Autowired
    private DireccionRepositorio repositorioDireccion; 

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario1 = new Usuario("Braulio Antonio", "Díaz Gajardo");
        repositorio.save(usuario1);

        Usuario usuario2 = new Usuario("Maxito perrito", "Gallegos");
        repositorio.save(usuario2);
        
        Direccion direccion1 = new Direccion("Calle falsa", "132", usuario1);
        repositorioDireccion.save(direccion1);
        
        Direccion direccion2 = new Direccion("Chiloe", "11", usuario2);
        repositorioDireccion.save(direccion2);
    }
}

