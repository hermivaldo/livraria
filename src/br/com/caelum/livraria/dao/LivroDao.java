package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;


@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		
		return manager.createQuery("SELECT L FROM Livro L", Livro.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> getLivroPorNome(String nome){
		return (List<Livro>) this.manager
                .createQuery("select l from Livro l where l.titulo like :ptitulo")
                .setParameter("ptitulo", "%"+ nome + "%").getResultList();
	}
}
