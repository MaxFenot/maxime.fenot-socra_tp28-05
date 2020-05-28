package com.epita.socra.app;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epita.socra.app.tools.IOAdapter;

import java.security.InvalidParameterException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */

    @Test
    public void IntToMorse_999() {
        MorseDecoder decoder = new MorseDecoder();
        String res = decoder.IntToMorse("999");
        assertEquals(res, "____.____.____.");
    }

   @Test
    public void IntToMorse_InvalidInput_abc() {
       MorseDecoder decoder = new MorseDecoder();
       boolean thrown = false;
       try{
           decoder.IntToMorse("abc");
       } catch (InvalidParameterException e) {thrown = true;}
       assertTrue(thrown);
    }

    @Test
    public void IntToMorse_InvalidInput_neg1() {
        MorseDecoder decoder = new MorseDecoder();
        boolean thrown = false;
        try{
            decoder.IntToMorse("-1");
        } catch (InvalidParameterException e) {thrown = true;}
        assertTrue(thrown);
    }

    @Test
    public void MorseToInt_999() {
        MorseDecoder decoder = new MorseDecoder();
        String res = decoder.MorseToInt("____.____.____.");
        assertEquals(res, "999");
    }

    @Test
    public void MorseToInt_InvalidInput_abc() {
        MorseDecoder decoder = new MorseDecoder();
        boolean thrown = false;
        try{
            decoder.MorseToInt("abc");
        } catch (InvalidParameterException e) {thrown = true;}
        assertTrue(thrown);
    }

    @Test
    public void MorseToInt_InvalidInput_Too_long() {
        MorseDecoder decoder = new MorseDecoder();
        boolean thrown = false;
        try{
            decoder.MorseToInt("........");
        } catch (InvalidParameterException e) {thrown = true;}
        assertTrue(thrown);
    }

    @Test
    public void MorseToInt_InvalidInput_Exotic() {
        MorseDecoder decoder = new MorseDecoder();
        boolean thrown = false;
        try{
            decoder.MorseToInt("._._.");
        } catch (InvalidParameterException e) {thrown = true;}
        assertTrue(thrown);
    }
}
