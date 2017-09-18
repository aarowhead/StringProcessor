package com.server;

import com.google.gson.Gson;
import com.server.handlers.CommandHandler;
import com.shared.StringPasser;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;


/**
 * Created by Aaron on 9/17/2017.
 */

public class Utils {

    private static Utils myUtils;

    private Utils(){
    }

    public static Utils getInstance(){
        if(myUtils == null){
            myUtils = new Utils();
        }
        return myUtils;
    }

    public <T> void writeOut (T responseBody, HttpExchange exchange) throws IOException{

        Gson gson = new Gson();

        Writer myWrite = new OutputStreamWriter(exchange.getResponseBody());
        String jsonStr = gson.toJson(responseBody);
        myWrite.write(jsonStr);
        myWrite.flush();
        myWrite.close();
    }

    public StringPasser readInStringPasser(HttpExchange exchange){
        Gson gson = new Gson();

        Reader myReader = new InputStreamReader(exchange.getRequestBody());

        return gson.fromJson(myReader, StringPasser.class);
    }

    public CommandExec readInCommand(HttpExchange exchange){
        Gson gson = new Gson();

        Reader myReader = new InputStreamReader(exchange.getRequestBody());

        return gson.fromJson(myReader, CommandExec.class);
    }

}
