package br.com.server.main.parser;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PayLoadManagerTest {

    static PayloadManager payLoad;

    @BeforeAll
    public static void beforeAllTests() {
         payLoad = new PayloadManager();
    }


    @Test
    public void CheckPayLoadTestErroString(){

        assertFalse(payLoad.checkPayLoad("Teste"));
    }

    @Test
    public void payloadToSenteceOKTest(){
        String requestPayLoad = "12:Star Trek: O Filme";
        assertEquals("Star Trek: O Filme", payLoad.payloadToSentece(requestPayLoad));
    }

    @Test
    public void checkPayLoadOKTest(){
        String requestPayLoad = "18:Star Trek: O Filme";
        assertTrue(payLoad.checkPayLoad(requestPayLoad));
    }


    @Test
    public void mountPayLoadOutTest(){
        assertEquals("0:", payLoad.mountPayLoadOut(""));
    }
}