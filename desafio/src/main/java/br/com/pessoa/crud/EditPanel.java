/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa.crud;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import br.com.pessoa.DTO.UtilDTO;
import br.com.pessoa.entity.Pessoa;
import br.com.pessoa.service.CadastroService;

/**
 *
 * @author sihaya
 */
public class EditPanel<T> extends Panel
{
	 
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditPanel(String id, final CadastroService service)
    {
        super(id);
        
     
        
        final Pessoa pessoa = new Pessoa();
        
        final Form<Pessoa> form = new Form<Pessoa>("form");
        
        final Model<Pessoa> listModel = new Model<Pessoa>();
		ChoiceRenderer<Pessoa> personRender = new ChoiceRenderer<Pessoa>(){
			
			private static final long serialVersionUID = 1L;

			@Override
			public Object getDisplayValue(Pessoa person) {
				
				return person.getId() + " " + person.getNome();
			}
		};
		
		
		
		 DropDownChoice<Pessoa> personsList = new DropDownChoice<Pessoa>("pessoa", listModel,service.consultarCliente(),personRender){
            
			private static final long serialVersionUID = 1L;
 
			@Override
			public boolean wantOnSelectionChangedNotifications() {
				
				return true;
			}
			
		
		};
		final Label titulo = new Label("titulo", UtilDTO.perfil);
		final Label mensagem = new Label("mensagem", "") ;
        final TextField<String> nome = new TextField<String>("nome", new PropertyModel<String>(pessoa, "nome"));
        final TextField<String> cpf = new TextField<String>("cpf", new PropertyModel<String>(pessoa, "cpf"));
        final TextField<String> data = new TextField<String>("data", new PropertyModel<String>(pessoa, "dataNascimento"));
        final TextArea<String> curriculo = new TextArea<String>("curriculo", new PropertyModel<String>(pessoa, "curriculo"));
        form.add(new Button("save")
        {
			private static final long serialVersionUID = 1L;
			@Override
            public void onSubmit()
            {
				if(!"".equals(nome) && !"".equals(cpf) && !"".equals(data) && !"".equals(curriculo)){ 
				 service.cadastrar(pessoa);
				 String  msg  = "Cadastro salvo com Sucesso!!!";
				 Label newMessage= new Label(mensagem.getId(), msg);
				 newMessage.setOutputMarkupId(true);
				 mensagem.replaceWith(newMessage);
				 form.add(newMessage);
				}
            }
        });
        
      
        add(personsList);	
      //  form = new Form<Pessoa>("form", new CompoundPropertyModel<Pessoa>(listModel));		
        form.add(nome);
        form.add(cpf);
        form.add(data);
        form.add(curriculo);
        form.add(mensagem); 
        add(titulo);
        add(form);
        
        
    }
    

}


