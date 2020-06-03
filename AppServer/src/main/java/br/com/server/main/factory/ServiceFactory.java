package br.com.server.main.factory;


import br.com.server.main.config.*;

import br.com.server.main.parser.PayloadManager;
import br.com.server.main.service.ImdbService;
import br.com.server.main.servidor.Servidor;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class ServiceFactory {

    private static ServiceFactory instance;


    public static ServiceFactory getInstance() {
        if(instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }


    private Injector injectorServidor = Guice.createInjector(new ServidorModule());
    private Servidor servidor = injectorServidor.getInstance(Servidor.class);

    private Injector injectorPayloadManager = Guice.createInjector(new PayloadManagerModule());
    private PayloadManager payloadManager = injectorPayloadManager.getInstance(PayloadManager.class);

    private Injector injectorImdbService = Guice.createInjector(new ImdbServiceModule());
    private ImdbService imdbService = injectorImdbService.getInstance(ImdbService.class);


    public Servidor getServidor() { return servidor; }

    public ImdbService getImdbService() { return imdbService; }

    public PayloadManager getPayloadManager() {
        return payloadManager;
    }
}
