package br.edu.unidesc.univocacional.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.edu.unidesc.univocacional.model.Pessoa;

public class PessoaDao {
	
	@PersistenceContext(unitName="vocacionalPU")
	private EntityManager entityManager;
	
	public Pessoa save(Pessoa pessoa) {
		entityManager.persist(pessoa);
		return pessoa;
	}
	
	public void update(Pessoa pessoa) {
		pessoa p = entityManager.merge(pessoa);
		entityManager.persist(p);
	}
	
	public void delete(Pessoa pessoa) {
		Pessoa p = entityManager.merge(p);
		entityManager.remove(p);
	}
	
	public List<Pessoa> getAll(){
		Query query = entityManager.createNamedQuery("getPeople");
		return query.getResultList();
	}

}


