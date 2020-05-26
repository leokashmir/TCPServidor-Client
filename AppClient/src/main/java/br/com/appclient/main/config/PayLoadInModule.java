package br.com.appclient.main.config;


import br.com.appclient.main.parser.PayLoadIn;
import com.google.inject.AbstractModule;

public class PayLoadInModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PayLoadIn.class)
                .toInstance(new PayLoadIn());
    }

}
