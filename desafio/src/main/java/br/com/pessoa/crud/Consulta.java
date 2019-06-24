/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa.crud;

import java.awt.Label;

import javax.persistence.EntityManager;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.pessoa.DTO.UtilDTO;
import br.com.pessoa.entity.Pessoa;
import br.com.pessoa.service.CadastroService;

/**
 *
 * @author sihaya
 */
public class Consulta extends WebPage
{

	private static final long serialVersionUID = 1L;

	@SpringBean
    private CadastroService service;

	  public Consulta() {
	      
	        add(new ConsultaFiltroPanel("consultaPanel", service));
	  }

	
}
