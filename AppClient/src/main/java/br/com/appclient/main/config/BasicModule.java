package br.com.appclient.main.config;

import br.com.appclient.main.connection.ConnectionService;
import com.google.inject.AbstractModule;

public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ConnectionService.class)
                .toInstance(new ConnectionService());
    }




}
