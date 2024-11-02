package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.UserModel;
import com.example.demo.servicios.UsuarioServicio;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServicio usuarioServicio;

	@GetMapping() // Para indicar si se usa un metodo get ejecute este metodo
	public ArrayList<UserModel> obtenerUsuarios() {
		return usuarioServicio.obtenerUsuario();
	}

	@PostMapping() // Para hacer un uso de post
	public UserModel guardarUsuario(@RequestBody UserModel usuario) { // RequestBody para poder enviar informacion
																		// dentro del cuerpo de la solicitud http
		return this.usuarioServicio.guardarUsuario(usuario);
	}

	@GetMapping(path = "/{id}") // Decimos que en el path /usuario/id(el que pasamos por el cuerpo ) y nos
								// mostrara el usuario o no dependiendo si tiene id
	public Optional<UserModel> findUserById(@PathVariable("id") Long id) {// El @PathVariable es para indicar que cogemos del cuerpo de la solicitud http y	 lo llamamos con el metodo de findById del usuarioServicio
																			
		return this.usuarioServicio.findById(id);
	}

	@GetMapping("/query") // Creamos un nuevo servicio para poder buscar al usuario por prioridad
							// Para usarlo hay que hacerlo de esta manera => /usuario/query?prioridad=1
	public ArrayList<UserModel> findUserByPrioridad(@RequestParam("prioridad") int prioridad) {
		return this.usuarioServicio.findByPrioridad(prioridad);
	}

	// Para poder eliminar de la base de datos se usa la anotacion @DeleteMapping
	@DeleteMapping(path = "/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		boolean ok = this.usuarioServicio.deleteUser(id);
		if (ok) {
			return "Se elimino el usuario con id: " + id;
		} else {
			return "No se pudo eliminar el usuario con id: " + id;
		}
	}

}
