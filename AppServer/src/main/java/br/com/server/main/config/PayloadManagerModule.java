package br.com.server.main.config;

import br.com.server.main.parser.PayloadManager;
import com.google.inject.AbstractModule;

public class PayloadManagerModule extends AbstractModule {

    @Override
    protected void configure()  {
        bind(PayloadManager.class)
                .toInstance(new PayloadManager());
    }
}
