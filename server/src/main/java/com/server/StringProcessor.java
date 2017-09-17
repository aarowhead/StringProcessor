package com.server;

/**
 * Created by Aaron on 9/16/2017.
 */

//Singleton
public class StringProcessor {

    private static StringProcessor myProc;

    private StringProcessor(){
    }

    public static StringProcessor getInstance(){
        if(myProc == null){
            myProc = new StringProcessor();
        }
        return myProc;
    }

    public String toLowerCase(String input){
        return input.toLowerCase();
    }

    public String trim(String input){
        return input.trim();
    }

    public Integer parseInteger(String input) throws NumberFormatException{
        return Integer.parseInt(input);
    }
}
