package br.com.jonathan.projeto.util;

import org.hibernate.SessionFactory;


import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory fabricadeSessoes = criarFabricaDeSessoes() ;

	public static SessionFactory getFabricadeSessoes() {
		return fabricadeSessoes;
	}

	@SuppressWarnings("unused")
	private static SessionFactory criarFabricaDeSessoes() {

		try {

			Configuration configuracao = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();
			
			SessionFactory fabrica = configuracao.buildSessionFactory();
			
			return fabrica;
			

		} catch (Throwable ex) {

			System.err.println("Falha de Conexão." + ex);
			throw new ExceptionInInitializerError(ex);

		}
		

	}

}
