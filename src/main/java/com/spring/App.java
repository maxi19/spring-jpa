package com.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.spring.entidad.Alumno;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

    	/*
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    
    	Persona persona = (Persona)  applicationContext.getBean("persona1");
    	
        Gson gson = new Gson();
        
    	System.out.println(gson.toJson(persona));
    	*/
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    	
    	
    	EntityManager em = emf.createEntityManager();
    	
    	try {
        	em.getTransaction().begin();
        	em.persist(null);
        	em.getTransaction().commit();
        	em.close();
		} catch (Exception e) {
			
			
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
