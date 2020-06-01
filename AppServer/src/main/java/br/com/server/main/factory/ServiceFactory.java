package br.com.server.main.factory;


import br.com.server.main.config.ImdbServiceModule;
import br.com.server.main.config.PayLoadInModule;
import br.com.server.main.config.PayLoadOutModule;

import br.com.server.main.config.ServidorModule;
import br.com.server.main.parser.PayLoadIn;
import br.com.server.main.parser.PayLoadOut;
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

    private Injector injectorPayLoadIn = Guice.createInjector(new PayLoadInModule());
    private PayLoadIn loadIn = injectorPayLoadIn.getInstance(PayLoadIn.class);

    private Injector injectorPayLoadOut = Guice.createInjector(new PayLoadOutModule());
    private PayLoadOut loadOut = injectorPayLoadOut.getInstance(PayLoadOut.class);

    private Injector injectorImdbService = Guice.createInjector(new ImdbServiceModule());
    private ImdbService imdbService = injectorImdbService.getInstance(ImdbService.class);


    public PayLoadIn getLoadIn() {
        return loadIn;
    }

    public PayLoadOut getLoadOut() {
        return loadOut;
    }

    public Servidor getServidor() { return servidor; }

    public ImdbService getImdbService() { return imdbService; }
}
