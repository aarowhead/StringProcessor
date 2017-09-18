package com.server;

import com.shared.Command;

public class CommandExec extends Command {

    public Object execute(){
        switch (getCommandName()) {
            case "toLowerCase":
                return StringProcessor.getInstance().toLowerCase(getEditString());
            case "trim":
                return StringProcessor.getInstance().trim(getEditString());
            case "parseInt":
                return StringProcessor.getInstance().parseInteger(getEditString());
            default:
                return null;
        }
    }
}
