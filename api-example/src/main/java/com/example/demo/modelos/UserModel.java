package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity // Decimos que es un modelo real y sea gestionado por Spring
@Table(name = "usuarios") // Vamos a crear una Tabla con nombre Usuarios
public class UserModel {
	// atributos
	@Id // para decir que sea este atributo la PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Se genera automaticamente y sea autoincrementa
	@Column(unique = true, nullable = false) // Que sea unico y que no pueda ser null ya que es una PK
	private long id;

	private String nombre;
	private String email;
	private int prioridad;

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	

}
