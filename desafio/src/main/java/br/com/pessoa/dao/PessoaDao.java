package br.com.pessoa.dao;



import java.util.List;

import br.com.pessoa.entity.Pessoa;





public interface PessoaDao<T>  {

	
    public void saveCliente(T entity);
    public List<Pessoa> list();
    public List<Pessoa> listClienteParam(String Nome);
    public void update(Pessoa pessoa);
    public void remove(Pessoa pessoa);

	
}
