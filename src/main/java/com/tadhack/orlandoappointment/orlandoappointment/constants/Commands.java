package com.tadhack.orlandoappointment.orlandoappointment.constants;

public enum Commands {
    Hello("Hello"),
    HOSPITAL("Hospital"),
    DENTAL("Dental"),
    DMV("Dmv"),
    RESTAURENT("Restaurent"),
    NAME("NAME");

    private  String commandValue;

    private Commands(String s) {
        commandValue = s;
    }

    public boolean equalsName(String name) {
        return this.commandValue.equals(name);
    }

    public String toString() {
        return this.commandValue;
    }

    public Commands getValueOf(String name) {
        if(name.equals(commandValue)) {
            return Commands.valueOf(commandValue);
        }
        return null;
    }
}
