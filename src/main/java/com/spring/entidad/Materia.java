package com.spring.entidad;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materias")
public class Materia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column
	public String nombre;
	
	@Column
	public int horas;
	
	@ManyToOne
	@JoinColumn(name = "cursos_id")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "docentes_id")
	private Docente docente;
	
	
	public Materia() {
		
	}
	

	public Materia(String nombre, int horas, Curso curso, Docente docente) {
		super();
		this.nombre = nombre;
		this.horas = horas;
		this.curso = curso;
		this.docente = docente;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", horas=" + horas + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id,nombre,horas);
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


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public Docente getDocente() {
		return docente;
	}


	public void setDocente(Docente docente) {
		this.docente = docente;
	}



	
	
}
