package com.spring.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String identificador;
	
	//@OneToMany(orphanRemoval = true,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@OneToMany(orphanRemoval = true,cascade = CascadeType.REMOVE , fetch = FetchType.LAZY, mappedBy = "curso")
	private List<Materia> materias;
	
	public Curso(String identificador) {
		super();
		this.identificador = identificador;
		this.materias = new ArrayList<Materia>();
	}

	public Curso() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	

	
	public void agregar(Materia materia) {
		this.materias.add(materia);
		materia.setCurso(this);
	}
	public void eliminarTodasMaterias () {
		this.materias.stream().forEach(x->{
			x.setCurso(null);
		});
			this.materias.clear();
			

	}
	public void eliminar (Materia materia) {
		this.materias.stream().forEach(x->{
			if ( materia.equals(x)) {
				materias.remove(x);
				materia.setCurso(null);
			}
		});
	}
	
	
	
}
