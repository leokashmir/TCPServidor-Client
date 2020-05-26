package br.com.server.main.servidor;


import br.com.server.main.factory.ServiceFactory;
import com.google.inject.Inject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {



    private int port;


    @Inject
    public Servidor(){}


    public void port( int port){
        this.port = port;
    }

    public void start(ServiceFactory factory) throws IOException {
        String clientSentence ="";

        ServerSocket welcomeSocket = new ServerSocket(port);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Conexao aceita….");

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());


            try {
                String sentece = inFromClient.readLine();
                if (factory.getLoadIn().checkPayLoad(sentece)){

                    sentece = factory.getLoadIn().payloadToSentece(sentece);
                    String listTitlesFilms =  factory.getImdbService().listFilms(sentece);

                    clientSentence = factory.getLoadOut().mountPayLoadOut(listTitlesFilms);

                    outToClient.writeBytes(clientSentence+ '\n');

                }

            } catch (Exception e) {
                System.out.println("Erro ao Conectar no Servidor");
                e.printStackTrace();
            }

            connectionSocket.close();
            System.out.println("Conexao fechada");
       }
    }
}
