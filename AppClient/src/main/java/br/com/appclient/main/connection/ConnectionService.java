package br.com.appclient.main.connection;

import com.google.inject.Inject;
import javafx.scene.chart.ScatterChart;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionService {

  private String host;
  private int port;

  @Inject
  public ConnectionService(){}

  public void hostAndPort(String host, int port){
      this.host = host;
      this.port = port;
  }

  public String connect( String sentence){

      StringBuilder returnText = new StringBuilder();

      try{
          Socket clientSocket = new Socket(this.host, this.port);

          DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
          BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

          outToServer.writeBytes(sentence + '\n');

          returnText.append(inFromServer.readLine());

      }catch( IOException e ){

          returnText.append("ERRO: ").append(e.getMessage());
          returnText.append("\nMSG: Nao foi possivel estabelecer conexao com o servidor.");

      }
        return returnText.toString();
  }




}
