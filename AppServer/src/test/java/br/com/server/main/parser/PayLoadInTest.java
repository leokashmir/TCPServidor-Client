package br.com.server.main.parser;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PayLoadInTest  {

    static PayLoadIn payLoadIn;

    @BeforeAll
    public static void beforeAllTests() {
         payLoadIn = new PayLoadIn();
    }


    @Test
    public void CheckPayLoadTestErroString(){

        assertFalse(payLoadIn.checkPayLoad("Teste"));
    }

    @Test
    public void payloadToSenteceOKTest(){
        String requestPayLoad = "12:Star Trek: O Filme";
        assertEquals("Star Trek: O Filme", payLoadIn.payloadToSentece(requestPayLoad));
    }

    @Test
    public void checkPayLoadOKTest(){
        String requestPayLoad = "18:Star Trek: O Filme";
        assertTrue(payLoadIn.checkPayLoad(requestPayLoad));
    }
}