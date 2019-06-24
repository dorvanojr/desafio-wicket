package br.com.pessoa.login;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import br.com.pessoa.DTO.UtilDTO;
import br.com.pessoa.crud.Home;
/**
 * @author Niranjan
 *
 */
public class LoginForm extends Form {
    /**
     * 
     */
    private static final long serialVersionUID = 157873863293813131L;
    
    private String username;
    private String password;
    private String loginStatus;
    
    
    public LoginForm(String id) {        
        super(id);
        setDefaultModel(new CompoundPropertyModel(this));
        add(new TextField("username"));
        add(new PasswordTextField("password"));
        add(new Label("loginStatus"));
    }
    public void  onSubmit() {    
    	 if ("admin".equals(username) && "123".equals(password)){
    		 setResponsePage(Home.class);
    		 UtilDTO.perfil =  "Administrador";
         }if ("rel".equals(username) && "123".equals(password)){
    		 setResponsePage(Home.class);
    		 UtilDTO.perfil =  "Relator";
         }
    	 else{
             loginStatus = "Usuario ou senha invalido";
         }
    }
    
    
    public Class<? extends Page> getHomePage()
    {
        return Home.class;
    }
}
