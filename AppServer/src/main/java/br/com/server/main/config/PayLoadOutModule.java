package br.com.server.main.config;


import br.com.server.main.parser.PayLoadOut;
import com.google.inject.AbstractModule;

public class PayLoadOutModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(PayLoadOut.class)
                .toInstance(new PayLoadOut());
    }

}
