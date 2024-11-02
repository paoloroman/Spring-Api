package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.UserModel;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServicio {

	@Autowired
	UsuarioRepository usuarioRepository;

	public ArrayList<UserModel> obtenerUsuario() {
		return (ArrayList<UserModel>) usuarioRepository.findAll();
	}

	public UserModel guardarUsuario(UserModel usuario) {
		return usuarioRepository.save(usuario);
	}

	// Vamos a buscar al usuario por el id y como debe ser unico usamos el Optional
	// el cual nos devuelve si existe y sino nos devuelve null
	public Optional<UserModel> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	// Buscamos al usuario por la prioridad

	public ArrayList<UserModel> findByPrioridad(int prioridad) {
		return usuarioRepository.findByPrioridad(prioridad);
	}

	// eliminamos al usuario por el id

	public boolean deleteUser(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
}
