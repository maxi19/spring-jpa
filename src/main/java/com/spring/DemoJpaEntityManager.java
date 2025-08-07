package com.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.spring.entidad.Alumno;
import com.spring.entidad.Curso;
import com.spring.entidad.Docente;
import com.spring.entidad.Materia;

public class DemoJpaEntityManager {

	public static void main(String[] args) {
		
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    	
    	EntityManager em = emf.createEntityManager();
    	
    	try {
        	em.getTransaction().begin();
    		
        	Curso a = new Curso( "1A");
    		Curso b = new Curso( "1B");
        	
    		Docente maxi = new Docente("jose maximiliano","guzman","aaa120");
    		Docente andres = new Docente("andres","sinapellido","aaa101");
    		Docente mariano = new Docente("mariano","eito","aawfsf2");
    		Docente sebastian = new Docente("sebastian","munos","aawf3242");
    		
    		Materia analisis = new Materia("analisis", 10,a,maxi);
    		Materia prgramacion = new Materia("programacion", 20,a, maxi);
    		Materia basedatos = new Materia("base de datos", 5,b,mariano);
    		Materia proyecto = new Materia("proyecto", 10,b, sebastian);
        	    		
    		em.persist(a);
        	em.persist(b);
        	em.persist(mariano);
        	em.persist(sebastian);
        	em.persist(maxi);
        	em.persist(andres);
        	em.persist(analisis);
        	em.persist(basedatos);
        	em.persist(basedatos);
        	em.persist(prgramacion);
        	em.persist(proyecto);
        	
        	
        	Curso curso =  em.find(Curso.class, 1);
        	Alumno alumno = new Alumno("fabian", "brenan", 17);
        	alumno.setCurso(curso);
        	
        	em.persist(alumno);
        	        	
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
