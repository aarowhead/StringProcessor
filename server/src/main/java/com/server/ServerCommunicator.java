package com.server;

import com.server.handlers.LowerCaseHandler;
import com.server.handlers.ParseIntHandler;
import com.server.handlers.TrimHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Aaron on 9/16/2017.
 */

//Singleton
public class ServerCommunicator{

    private static final int MAX_WAITING_CONNECTIONS = 12;

    private static HttpServer server;

    private static ServerCommunicator serverCom;

    private ServerCommunicator(){
    }

    public static ServerCommunicator getInstance(){
        if(serverCom == null){
            serverCom = new ServerCommunicator();
        }
        return serverCom;
    }

    private void createContexts(){
        System.out.println("Creating Contexts");

        server.createContext("/lowercase", new LowerCaseHandler());
        server.createContext("/parseInt", new ParseIntHandler());
        server.createContext("/trim", new TrimHandler());

        System.out.println("Contexts Created!");
    }

    public void run(String portNumber){
        System.out.println("Starting Server...");

        try {
            server = HttpServer.create(new InetSocketAddress(Integer.parseInt(portNumber)),
                    MAX_WAITING_CONNECTIONS);
        } catch(IOException e){
            System.out.println("Server Failed to start: " + e);
            e.printStackTrace();
            return;
        }

        server.setExecutor(null);

        createContexts();

        server.start();
        System.out.println("Server Started!");
    }
}
