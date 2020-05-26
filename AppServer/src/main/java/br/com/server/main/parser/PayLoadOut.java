package br.com.server.main.parser;

import java.util.logging.Logger;

public class PayLoadOut {

    private static final Logger log = Logger.getLogger(PayLoadOut.class.getName());


    public String mountPayLoadOut(String payload){

      StringBuilder payLoadFormatted = new StringBuilder();

      if(payload != null){
            payLoadFormatted.append(payload.length())
                    .append(":")
                    .append(payload);
        }


      return payLoadFormatted.toString();
    }
}
