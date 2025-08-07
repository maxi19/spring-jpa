package com.spring.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
@Table(name = "docentes")
public class Docente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombres;

	@Column
	private String apellidos;
	
	@Column
	private String matricula;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "docente")
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Materia> materias;


	
	public Docente(String nombres, String apellidos, String matricula, List<Materia> materias) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.matricula = matricula;
		this.materias = materias;
	}

	public Docente(String nombres, String apellidos, String matricula) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.matricula = matricula;
		this.materias = new ArrayList<Materia>();
	}

	public Docente() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public List<Materia> getMaterias() {
		return materias;
	}



	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,nombres,apellidos);
	}


	@Override
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Materia person = (Materia) obj;
        return  Objects.equals(id, person.getId());
	}
}
