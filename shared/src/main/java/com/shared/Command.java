package com.shared;

public class Command {

    private String commandName;
    private String editString;

    public Command(){}

    public Command(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getEditString() {
        return editString;
    }

    public void setEditString(String editString) {
        this.editString = editString;
    }
}
