package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
@WebService
public class LivrariaWS {
	
	@Inject 
	LivroDao dao;
	
	@WebResult(name="autores")
	public List<Livro> getLivrosPorNome(@WebParam(name="titulo") String nome){
		return this.dao.getLivroPorNome(nome);
	}
	
}
