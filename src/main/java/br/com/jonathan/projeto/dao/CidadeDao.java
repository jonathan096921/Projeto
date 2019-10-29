package br.com.jonathan.projeto.dao;


import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;


import br.com.jonathan.projeto.domain.Cidade;
import br.com.jonathan.projeto.util.HibernateUtil;

public class CidadeDao extends GenericDao<Cidade> {

	public List<Cidade> buscaPorEstado(Long estadoCodigo) {

		Session sessao = HibernateUtil.getFabricadeSessoes().openSession();

		try {

			// Create CriteriaBuilder
			CriteriaBuilder builder = sessao.getCriteriaBuilder();

			// Create CriteriaQuery
			CriteriaQuery<Cidade> consulta = builder.createQuery(Cidade.class);
			

			// Specify criteria root
			Root<Cidade> enti = consulta.from(Cidade.class);
			consulta.select(enti);
			
			consulta.orderBy(builder.asc(enti.get("nome")));
		
					
			// Execute query
			List<Cidade> resultado = sessao.createQuery(consulta).getResultList();

			return resultado;
		} catch (RuntimeException erro) {

			throw erro;

		}

		finally {

			sessao.close();
		}

	}

}
