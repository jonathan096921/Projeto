package br.com.jonathan.projeto.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateTesteUtil {

	@Test
	public void conectar(){
		
		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricadeSessoes().close();
		
	}
	
}





