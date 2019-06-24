/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa.configuration;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import br.com.pessoa.login.LoginPage;


/**
 *
 * @author sihaya
 */
public class WicketCrudApplication extends WebApplication
{
    @Override
    public Class<? extends Page> getHomePage()
    {
        return LoginPage.class;
    }

    @Override
    protected void init()
    {
        super.init();
        
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));        
    }
}
