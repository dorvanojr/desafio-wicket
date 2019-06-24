/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa.crud;


import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.PropertyModel;

import br.com.pessoa.entity.Pessoa;
import br.com.pessoa.service.CadastroService;




/**
 *
 * @author sihaya
 */
public class ConsultaFiltroPanel extends Panel
{

	private static final long serialVersionUID = 1L;
    

	 Pessoa pessoa = new Pessoa();
	
	 private List<Pessoa> lista = new ArrayList<Pessoa>();

	public ConsultaFiltroPanel(String id, final CadastroService service)
    {
        super(id);
        
        
        final Form<Pessoa> form = new Form<Pessoa>("form1");
  
        final Label mensagem = new Label("mensagem1", "") ;
     
    	 lista = service.consultarCliente();
          
        if(lista.size() == 0) {
             String  msg  = "Nenhum Registro encontrado!!!";
			 Label newMessage= new Label(mensagem.getId(), msg);
			 newMessage.setOutputMarkupId(true);
			 mensagem.replaceWith(newMessage);
			 form.add(newMessage);
       
       }
        form.add(mensagem);
        

       
        

        
        
		DataView<Pessoa>  dataView1 = new DataView<Pessoa>("rows", new ListDataProvider<Pessoa>(lista)) {

			private static final long serialVersionUID = 1L;
		
			
			protected void populateItem(final Item<Pessoa> item) {

				item.add(new Label("nome", item.getModelObject().getNome()));
				item.add(new Label("cpf", item.getModelObject().getCpf()));
			    item.add(new Label("data", item.getModelObject().getDataNascimento()));
			    item.add(new Label("curriculo", item.getModelObject().getCurriculo()));
				AjaxSubmitLink addDelete = new AjaxSubmitLink("btnExcluir", form) {
					private static final long serialVersionUID = 1L;
					
				   public void onSubmit(AjaxRequestTarget target, Form form) {
				
					  deleteAcompanhantes(service, target, form, item);
				
				   }
			
				 };
				item.add(addDelete);
				form.add(mensagem); 
		}
			
	};
	  dataView1.setVisible(true);
	 
	
	form.add(dataView1);
        

    
	add(form);

}
	
	public void deleteAcompanhantes(CadastroService service, AjaxRequestTarget target, Form<?> form, Item<Pessoa> item) {
		service.remove(item.getModelObject());
	}

    
}
