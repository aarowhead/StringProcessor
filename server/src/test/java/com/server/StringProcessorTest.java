package com.server;

import org.junit.Test;

/**
 * Created by Aaron on 9/16/2017.
 */

public class StringProcessorTest {

    @Test
    public void testToLowerCase(){
        String inputString = "TESTING";
        String expectedReturn = "testing";
        assert(StringProcessor.getInstance().toLowerCase(inputString).equals(expectedReturn));
    }

    @Test
    public void testTrim(){
        String inputString = "  Testing  ";
        String expectedReturn = "Testing";
        assert(StringProcessor.getInstance().trim(inputString).equals(expectedReturn));
    }

    @Test
    public void testParseInt(){
        String inputString = "12";
        Integer expectedReturn = 12;
        assert(StringProcessor.getInstance().parseInteger(inputString) == expectedReturn);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseIntException(){
        String inputString = "not an int";
        StringProcessor.getInstance().parseInteger(inputString);
    }
}
