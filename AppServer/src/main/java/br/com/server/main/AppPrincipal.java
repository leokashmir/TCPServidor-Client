package br.com.server.main;

import br.com.server.main.factory.ServiceFactory;
import br.com.server.main.swing.ServerStartPanel;


public class AppPrincipal {

    public static void main(String[] args)  throws Exception {

        ServiceFactory factory = ServiceFactory.getInstance();
        ServerStartPanel startApp = new ServerStartPanel(factory);


    }
}
