package br.com.pessoa.login;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
/**
 * @author Niranjan Velagapudi
 *
 */
public class LoginPage extends WebPage{
    /**
     * 
     */
    private static final long serialVersionUID = 5946349607750478191L;
    
    public LoginPage(final PageParameters parameters) {
        super(parameters);
        add(new LoginForm("loginForm"));
    }
}