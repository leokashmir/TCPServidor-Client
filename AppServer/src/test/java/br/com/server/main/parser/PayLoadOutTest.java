package br.com.server.main.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayLoadOutTest {


    @Test
    public void mountPayLoadOutTest(){
        PayLoadOut payLoadOut = new PayLoadOut();
        assertEquals("0:", payLoadOut.mountPayLoadOut(""));
    }

}