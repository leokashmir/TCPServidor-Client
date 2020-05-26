package br.com.appclient.main.parser;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PayLoadIn {

    private static final Logger log = Logger.getLogger(PayLoadIn.class.getName());

    public boolean checkPayLoadImdb( String requestPayLoad ){
        try{
            if(checkValidPayLoad( requestPayLoad )){

                int payloadLength = Integer.parseInt(requestPayLoad.split(":")[0]);
                return payloadLength == ( (requestPayLoad.length() - requestPayLoad.split(":")[0].length()) - 1);
            }
        }catch( Exception ex){
            log.log(Level.parse("=== ERROR === "), ex.getMessage());

        }
        return false;
    }

    private boolean checkValidPayLoad( String requestPayLoad ){
        return (requestPayLoad != null) && (!requestPayLoad.equals("")) && (requestPayLoad.contains(":"));
    }

    public String formatListView(String requestPayLoad){

        String payLoadLength = requestPayLoad.split(":")[0];

        requestPayLoad = requestPayLoad.substring(payLoadLength.length() + 1, requestPayLoad.length() );
        requestPayLoad = requestPayLoad.replace("¶","\n");

        return  requestPayLoad;
    }
}
