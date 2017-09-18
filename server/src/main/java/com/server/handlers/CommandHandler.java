package com.server.handlers;

import com.server.CommandExec;
import com.server.StringProcessor;
import com.server.Utils;
import com.shared.StringPasser;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.xml.ws.handler.Handler;

/**
 * Created by Aaron on 9/18/2017.
 */

public class CommandHandler implements HttpHandler{

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        System.out.println("CommandHandler Called");

        Object result = null;
        try {
            CommandExec command = Utils.getInstance().readInCommand(exchange);

            result = command.execute();

            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        }catch (NumberFormatException e){
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_NOT_ACCEPTABLE, 0);
        }

        Utils.getInstance().writeOut(result, exchange);
    }
}
