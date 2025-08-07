package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import com.spring.service.PersonaService;


@WebServlet("/personas")
public class PersonaController extends HttpServlet implements InitializingBean, DisposableBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private  PersonaService personaService;
	
	
	public PersonaController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}
	

	public PersonaController() {
		
		
	}

	@Override
	public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.personaService = (PersonaService) ctx.getBean("service");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");

	        try {
	            Gson gson = new Gson();

	            PrintWriter out = resp.getWriter();
	            resp.setContentType("application/json");
	            resp.setCharacterEncoding("utf-8");

	            out.print(gson.toJson(personaService.list()).toString());
	            out.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("en el controller");
		System.out.println(personaService.list());
	}


	
	
	
}
