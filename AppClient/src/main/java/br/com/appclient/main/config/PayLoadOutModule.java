package br.com.appclient.main.config;

import br.com.appclient.main.parser.PayLoadOut;
import com.google.inject.AbstractModule;

public class PayLoadOutModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PayLoadOut.class)
                .toInstance(new PayLoadOut());
    }

}
