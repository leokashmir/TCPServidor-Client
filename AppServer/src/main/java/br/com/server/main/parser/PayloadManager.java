package br.com.server.main.parser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PayloadManager {

    private static final Logger LOG = Logger.getLogger(PayloadManager.class.getName());


    public boolean checkPayLoad( String requestPayLoad ){
        try{
            if(checkValidPayLoad( requestPayLoad )){

                final int payloadLength = Integer.parseInt(requestPayLoad.split(":")[0]);
                return payloadLength == ( (requestPayLoad.length() - requestPayLoad.split(":")[0].length()) - 1);
            }
        }catch( Exception ex){
            LOG.log(Level.parse("ERROR"), ex.getMessage());
        }
        return false;
    }

    private boolean checkValidPayLoad( String requestPayLoad ){
        return requestPayLoad != null && !requestPayLoad.equals("") && requestPayLoad.contains(":");
    }

    public String payloadToSentece(String requestPayLoad ){
        final String payload[] =  requestPayLoad.split(":");
        return payload[1];
    }

    public String mountPayLoadOut(String payload){

        final StringBuilder payLoadFormatted = new StringBuilder();

        if(payload != null){
            payLoadFormatted.append(payload.length())
                    .append(':')
                    .append(payload)
                    .append( '\n');
        }

        return payLoadFormatted.toString();
    }
}
