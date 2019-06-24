package br.com.pessoa.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pessoa.dao.PessoaDao;
import br.com.pessoa.entity.Pessoa;







@Component
@Service
public class CadastroServiceImpl implements CadastroService, Serializable {
	

	private static final long serialVersionUID = 1L;

	 @Autowired
	 private PessoaDao<Pessoa> userDao;
	 private java.util.List<Pessoa> clientes;

  

	@Transactional
	public void cadastrar(Pessoa pessoa){
		
		getUserDao().saveCliente(pessoa);
	}
   
	
	@Transactional
	public void update(Pessoa pessoa){
		
		getUserDao().update(pessoa);
	}

	
	@Transactional
	public void remove(Pessoa pessoa){
		
		getUserDao().remove(pessoa);
	}

	
	 public java.util.List<Pessoa> consultarCliente(){
		 
		clientes =  getUserDao().list();
		 
		  
		return clientes;
 
	 }
	 
	 public java.util.List<Pessoa> consultarClienteFilter(String nome){
		 
		clientes =  getUserDao().listClienteParam(nome);
		 
		  
		return clientes;
 
	 }

	  public PessoaDao<Pessoa> getUserDao() {
			return userDao;
		}


		public void setUserDao(PessoaDao<Pessoa> userDao) {
			this.userDao = userDao;
		}
	

		public java.util.List<Pessoa> getClientes() {
			return clientes;
		}


		public void setClientes(java.util.List<Pessoa> clientes) {
			this.clientes = clientes;
		}


	
		
		
		
}