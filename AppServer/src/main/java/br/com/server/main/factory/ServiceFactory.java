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

    private static ServiceFactory INSTANCE;


    public static ServiceFactory getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ServiceFactory();
        }
        return INSTANCE;
    }


    Injector injectorServidor = Guice.createInjector(new ServidorModule());
    Servidor servidor = injectorServidor.getInstance(Servidor.class);

    Injector injectorPayLoadIn = Guice.createInjector(new PayLoadInModule());
    PayLoadIn loadIn = injectorPayLoadIn.getInstance(PayLoadIn.class);

    Injector injectorPayLoadOut = Guice.createInjector(new PayLoadOutModule());
    PayLoadOut loadOut = injectorPayLoadOut.getInstance(PayLoadOut.class);

    Injector injectorImdbService = Guice.createInjector(new ImdbServiceModule());
    ImdbService imdbService = injectorImdbService.getInstance(ImdbService.class);


    public PayLoadIn getLoadIn() {
        return loadIn;
    }

    public PayLoadOut getLoadOut() {
        return loadOut;
    }

    public Servidor getServidor() { return servidor; }

    public ImdbService getImdbService() { return imdbService; }
}
