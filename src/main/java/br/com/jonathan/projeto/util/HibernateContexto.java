package br.com.jonathan.projeto.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	public void contextDestroyed(ServletContext evento) {

		HibernateUtil.getFabricadeSessoes().close();

	}

	public void contextInitialized(ServletContext evento) {

		HibernateUtil.getFabricadeSessoes();

	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
