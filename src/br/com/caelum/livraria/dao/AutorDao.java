package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({LogInterceptador.class})
public class AutorDao {
	
	@PersistenceContext
	EntityManager manager;
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
		
		manager.persist(autor);
		
	}

	public List<Autor> todosAutores() {
		List<Autor> resultList = manager.createQuery("SELECT A FROM Autor A", Autor.class).getResultList();
		return resultList;
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = manager.find(Autor.class, autorId);
		return autor;
	}

}
