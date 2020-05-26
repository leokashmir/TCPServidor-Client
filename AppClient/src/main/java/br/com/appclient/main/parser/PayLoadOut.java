package br.com.appclient.main.parser;

public class PayLoadOut {

    public String mountPayLoadOutImdb(String payload){

        StringBuilder payLoadFormatted = new StringBuilder();

        if(payload != null){
            payLoadFormatted.append(payload.length())
                    .append(":")
                    .append(payload);
        }


        return payLoadFormatted.toString();
    }
}
