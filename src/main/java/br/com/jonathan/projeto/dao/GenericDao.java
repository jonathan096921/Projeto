package br.com.jonathan.projeto.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.jonathan.projeto.util.HibernateUtil;

public class GenericDao<Entidade> {
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")

	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.save(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();

			}

			throw erro;

		} finally {
			sessao.close();
		}

	}

	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.merge(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();

			}

			throw erro;

		} finally {
			sessao.close();
		}

	}

	public void editar(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();

			}

			throw erro;

		}

		finally {

			sessao.close();

		}
	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();

			}

			throw erro;

		}

		finally {

			sessao.close();

		}

	}

	public List<Entidade> listar() {

		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();

		try {

			// Create CriteriaBuilder
			CriteriaBuilder builder = sessao.getCriteriaBuilder();

			// Create CriteriaQuery
			CriteriaQuery<Entidade> consulta = builder.createQuery(classe);

			// Specify criteria root
			consulta.from(classe);

			// Execute query
			List<Entidade> resultado = sessao.createQuery(consulta).getResultList();

			return resultado;
		} catch (RuntimeException erro) {

			throw erro;

		}

		finally {

			sessao.close();
		}

	}

	public List<Entidade> listar(String campoOrdenacao) {

		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();

		try {

			// Create CriteriaBuilder
			CriteriaBuilder builder = sessao.getCriteriaBuilder();

			// Create CriteriaQuery
			CriteriaQuery<Entidade> consulta = builder.createQuery(classe);

			// Specify criteria root
			Root<Entidade> enti = consulta.from(classe);
			consulta.orderBy(builder.asc(enti.get(campoOrdenacao)));

			// Execute query
			List<Entidade> resultado = sessao.createQuery(consulta).getResultList();

			return resultado;
		} catch (RuntimeException erro) {

			throw erro;

		}

		finally {

			sessao.close();
		}

	}
	
	

	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();
		Entidade resultado = null;

		try {

			resultado = sessao.find(classe, codigo);
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		}

		finally {
			sessao.close();
		}

	}

}