package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entidad.Alumno;

@Service
public class PersonaServiceImp implements PersonaService , InitializingBean{

	@Autowired
	private List<Alumno> personas;
	
	public PersonaServiceImp() {
		
	}
	
	public PersonaServiceImp(List<Alumno> personas) {
		super();
		this.personas = personas;
	}

	@Override
	public List<Alumno> list() {
		return personas;
	}

	public List<Alumno> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Alumno> personas) {
		this.personas = personas;
	}

    public String mostrar()
    {
        return "Se cargaron las personas";
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("se crearon las personas");
		System.out.println(personas.toString());
		
	}
	
	
}
