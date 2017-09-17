package com.server;

public class Main {
    public static final String DEFAULT_PORT = "8080";

    public static void main(String args[]){
        String portNumber = DEFAULT_PORT;
        if(args.length != 0){
            portNumber = args[0];
        }
        ServerCommunicator.getInstance().run(portNumber);
    }
}
