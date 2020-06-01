package br.com.server.main;

import br.com.server.main.factory.ServiceFactory;
import br.com.server.main.swing.ServerStartPanel;


public class AppPrincipal {

    private static void start(){
        final ServiceFactory factory = ServiceFactory.getInstance();
        new ServerStartPanel(factory);
    }


    public static void main(String[] args)   {
            AppPrincipal.start();
      }
}
