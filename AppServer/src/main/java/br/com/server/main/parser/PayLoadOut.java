package br.com.server.main.parser;

public class PayLoadOut {

    public String mountPayLoadOut(String payload){

      final StringBuilder payLoadFormatted = new StringBuilder();

      if(payload != null){
            payLoadFormatted.append(payload.length())
                    .append(':')
                    .append(payload);
        }


      return payLoadFormatted.toString();
    }
}
