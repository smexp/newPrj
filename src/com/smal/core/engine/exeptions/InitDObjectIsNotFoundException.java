package com.smal.core.engine.exeptions;

public class InitDObjectIsNotFoundException extends Exception {
    public InitDObjectIsNotFoundException(String message) {
        super("ERROR Object to initialisation is not found in "+message);
    }
}
