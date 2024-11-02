package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.UserModel;
@Repository
public interface UsuarioRepository extends CrudRepository<UserModel, Long> {

	public abstract ArrayList<UserModel> findByPrioridad(int prioridad);
	
}
