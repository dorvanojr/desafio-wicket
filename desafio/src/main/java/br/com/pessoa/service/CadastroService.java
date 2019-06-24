package br.com.pessoa.service;

import java.util.List;

import br.com.pessoa.entity.Pessoa;



public interface CadastroService {
   
	
	public void cadastrar(Pessoa pessoa);
	public List<Pessoa> consultarCliente();
	public List<Pessoa> consultarClienteFilter(String nome);
	void update(Pessoa pessoa);
	void remove(Pessoa pessoa);
}