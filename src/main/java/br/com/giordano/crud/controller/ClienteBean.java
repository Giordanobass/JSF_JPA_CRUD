package br.com.giordano.crud.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.giordano.crud.dao.ClienteDAO;
import br.com.giordano.crud.model.Cliente;

@ManagedBean
@RequestScoped
public class ClienteBean {
	
	public List<Cliente> obterClientes(){
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obterClientes();
	}
	
	public String novo() {
		Cliente cliente = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", cliente);
		return "/faces/novo.xhtml";
	}
	
	public String incluir(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.incluir(cliente);
		return "/faces/index.xhtml";
	}
		
	public String alterar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente = clienteDAO.buscar(id);
		System.out.println("*********************************************");
		System.out.println(cliente);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente",cliente);
		return "/faces/alterar.xhtml";
	}	
	
	public String atualizar(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.alterar(cliente);
		return "/faces/index.xhtml";
	}
	
	public String remover(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.remover(id);
		System.out.println("Cliente removido");
		return"/faces/index.xhtml";
	}
}
