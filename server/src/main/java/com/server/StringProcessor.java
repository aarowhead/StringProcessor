package com.server;

import com.shared.IStringProcessor;

//Singleton
public class StringProcessor implements IStringProcessor{

    private static IStringProcessor myProc;

    private StringProcessor(){
    }

    public static IStringProcessor getInstance(){
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
