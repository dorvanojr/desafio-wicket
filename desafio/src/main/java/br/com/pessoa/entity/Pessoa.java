package br.com.pessoa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pessoa")
@NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p  ")
public class Pessoa implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nome")
	private String nome;
    @Column(name="cpf")
	private String cpf;
	@Column(name="data")
	private String dataNascimento;
	@Column(name="curriculo")
	private String curriculo;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getCurriculo() {
		return curriculo;
	}


	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}



	 
	 
}

