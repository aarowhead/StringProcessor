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

        Integer myResult = StringProcessor.getInstance().parseInteger(stringRequest.getChangeString());

        IntPasser intResult = new IntPasser();
        intResult.setParsedInt(myResult);

        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);

        Utils.getInstance().writeOut(intResult, exchange);
    }
}
