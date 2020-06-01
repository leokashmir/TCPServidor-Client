package br.com.server.main.config;

import br.com.server.main.service.ImdbService;
import com.google.inject.AbstractModule;

public class ImdbServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind( ImdbService.class)
                .toInstance(new  ImdbService());
    }
}
