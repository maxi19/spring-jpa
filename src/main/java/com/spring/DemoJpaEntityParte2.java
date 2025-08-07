package com.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.spring.entidad.Alumno;
import com.spring.entidad.Curso;
import com.spring.entidad.Docente;
import com.spring.entidad.Materia;

public class DemoJpaEntityParte2 {

	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	try {
        	em.getTransaction().begin();
    		
        	Curso curso = em.find(Curso.class, 1);
        	curso.eliminarTodasMaterias();
        	em.remove(curso);
        	em.getTransaction().commit();
        	em.close();
        	
        	
		} catch (Exception e) {
			
			System.out.println(e.getStackTrace());
		}finally {
			  if (em != null && em.isOpen()) {
	                em.close();
	            }
	            if (emf != null && emf.isOpen()) {
	                emf.close();
	            }
		
		}
    	
		
		
		

	}

}
