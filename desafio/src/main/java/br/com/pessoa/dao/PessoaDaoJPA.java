package br.com.pessoa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import org.springframework.stereotype.Repository;

import br.com.pessoa.entity.Pessoa;






@Repository
public class PessoaDaoJPA implements PessoaDao<Pessoa> {

	

	@PersistenceContext
	private EntityManager em;


	public void saveCliente(Pessoa pessoa) {
		
		em.persist(pessoa);
	
	

	}

	
	public List<Pessoa> list() {
		List<Pessoa> resultado = null;

		try {
			Query consulta = em.createNamedQuery("Pessoa.findAll");

			

			resultado = consulta.getResultList();
            
			
			
		} catch (Exception e) {
			System.out.println("n�o deu hehehe: " + e.getMessage());
		}

		return resultado;

	}

	
	public List<Pessoa> listClienteParam(String nome) {
		List<Pessoa> resultado = null;

		try {
			
			String sql = "SELECT p FROM Pessoa p where p.nome  = :nome ";
			
			
			Query consulta = em.createQuery(sql).setParameter("nome", nome);

			

			resultado = consulta.getResultList();
            
			
			
		} catch (Exception e) {
			System.out.println("n�o deu hehehe: " + e.getMessage());
		}

		return resultado;

	}
	
	
	public void update(Pessoa pessoa) {
	
		em.merge(pessoa);
		

	}
	

	public void remove(Pessoa pessoa) {
		    
	        Pessoa p = em.getReference(Pessoa.class, pessoa.getId());
	        em.remove(p);
	       
	       
	 }
	
}
