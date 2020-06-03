package br.com.server.main.servidor;


import br.com.server.main.factory.ServiceFactory;
import com.google.inject.Inject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;


public class Servidor {

    private static final Logger LOG = Logger.getLogger(Servidor.class.getName());

    private int port;


    @Inject
    public Servidor(){}


    public void port( int port){
        this.port = port;
    }

    public void start(ServiceFactory factory) throws IOException {
        String clientSentence ="";

        final ServerSocket welcomeSocket = new ServerSocket(port);

        while (true) {
            final Socket connectionSocket = welcomeSocket.accept();
            LOG.info("Conexao aceita….");

            final BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            final DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());


            try {
                String sentece = inFromClient.readLine();
                if (factory.getPayloadManager().checkPayLoad(sentece)){

                    sentece = factory.getPayloadManager().payloadToSentece(sentece);
                    String listTitlesFilms =  factory.getImdbService().listFilms(sentece);

                    clientSentence = factory.getPayloadManager().mountPayLoadOut(listTitlesFilms);

                    outToClient.writeBytes(clientSentence);

                }

            } catch (Exception e) {

                LOG.info("Erro ao Conectar no Servidor");

            }
            inFromClient.close();
            outToClient.close();
            welcomeSocket.close();
            connectionSocket.close();
            LOG.info("Conexao fechada");
       }
    }
}
