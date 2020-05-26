package br.com.appclient.main.factory;

import br.com.appclient.main.config.BasicModule;
import br.com.appclient.main.config.PayLoadInModule;
import br.com.appclient.main.config.PayLoadOutModule;
import br.com.appclient.main.connection.ConnectionService;
import br.com.appclient.main.parser.PayLoadIn;
import br.com.appclient.main.parser.PayLoadOut;
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


    Injector injectorConnection = Guice.createInjector(new BasicModule());
    ConnectionService conService = injectorConnection.getInstance(ConnectionService.class);

    Injector injectorPayLoadIn = Guice.createInjector(new PayLoadInModule());
    PayLoadIn loadIn = injectorPayLoadIn.getInstance(PayLoadIn.class);

    Injector injectorPayLoadOut = Guice.createInjector(new PayLoadOutModule());
    PayLoadOut loadOut = injectorPayLoadOut.getInstance(PayLoadOut.class);

    public ConnectionService getConService() {
        return conService;
    }

    public PayLoadIn getLoadIn() {
        return loadIn;
    }

    public PayLoadOut getLoadOut() {
        return loadOut;
    }
}
