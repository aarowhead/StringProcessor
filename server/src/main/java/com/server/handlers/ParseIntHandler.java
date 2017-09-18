package com.server.handlers;

import com.server.StringProcessor;
import com.server.Utils;
import com.shared.IntPasser;
import com.shared.StringPasser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

public class ParseIntHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException{

        System.out.println("ParseIntHandler Called");

        StringPasser stringRequest = Utils.getInstance().readInStringPasser(exchange);

        IntPasser intResult = new IntPasser();
        try {
            Integer myResult = StringProcessor.getInstance().parseInteger(stringRequest.getChangeString());

            intResult.setParsedInt(myResult);

            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);

        }catch (NumberFormatException e){
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_NOT_ACCEPTABLE, 0);
        }

        Utils.getInstance().writeOut(intResult, exchange);

    }
}
