package com.server.handlers;

import com.server.StringProcessor;
import com.server.Utils;
import com.shared.StringPasser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

public class TrimHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException{

        System.out.println("TrimHandler Called");

        StringPasser stringRequest = Utils.getInstance().readInStringPasser(exchange);

        String myResult = StringProcessor.getInstance().trim(stringRequest.getChangeString());

        StringPasser stringResult = new StringPasser();
        stringResult.setChangeString(myResult);

        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);

        Utils.getInstance().writeOut(stringResult, exchange);    }
}
