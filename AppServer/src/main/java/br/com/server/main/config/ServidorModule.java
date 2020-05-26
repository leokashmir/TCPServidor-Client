package br.com.server.main.config;

import br.com.server.main.servidor.Servidor;
import com.google.inject.AbstractModule;

public class ServidorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Servidor.class)
                .toInstance(new Servidor());
    }
}