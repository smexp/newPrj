package com.smal.core.engine.exeptions;

public class AttributeIsNotFoundException extends Exception {
    public AttributeIsNotFoundException(String message) {
        super("is not found "+message);
    }
}
