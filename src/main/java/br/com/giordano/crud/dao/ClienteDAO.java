package br.com.giordano.crud.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.giordano.crud.model.Cliente;
import br.com.giordano.crud.model.JPAUtil;

public class ClienteDAO {
	
	EntityManager entityManager = JPAUtil.geEntityManagerFactory().createEntityManager();
	
	public void incluir(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public void alterar(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	
	public Cliente buscar(Long id) {
		Cliente cliente = new Cliente();
		cliente = entityManager.find(Cliente.class, id);
		//JPAUtil.shutdown();
		return cliente;
	}
	
	public List<Cliente> obterClientes(){
		List<Cliente> listaCliente = new ArrayList<>();
		Query query = entityManager.createQuery("SELECT c FROM Cliente c");
		listaCliente = query.getResultList();
		return listaCliente;
	}
	
	public void remover(Long id) {
		Cliente cliente = new Cliente();
		cliente = entityManager.find(Cliente.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		
	}
}
