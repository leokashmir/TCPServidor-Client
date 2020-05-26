package br.com.appclient.main;

import br.com.appclient.main.config.BasicModule;
import br.com.appclient.main.connection.ConnectionService;
import br.com.appclient.main.factory.ServiceFactory;
import br.com.appclient.main.swing.FrameConnection;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class AppClient {

    public static void main(String argv[]) {

        ServiceFactory factory = ServiceFactory.getInstance();

        new FrameConnection(factory);
    }
}
