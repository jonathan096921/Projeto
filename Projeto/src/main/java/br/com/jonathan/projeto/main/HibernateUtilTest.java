package br.com.jonathan.projeto.main;

import org.hibernate.Session;

import br.com.jonathan.projeto.util.HibernateUtil;

public class HibernateUtilTest {

public static void main(String[] args) {

	
	Session sessao = HibernateUtil.getFabricadeSessoes().openSession();
	sessao.close();
	HibernateUtil.getFabricadeSessoes().close();
}
	
	
	
}
