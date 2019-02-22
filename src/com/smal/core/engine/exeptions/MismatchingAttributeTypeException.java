package com.smal.core.engine.exeptions;

public class MismatchingAttributeTypeException extends Exception {
    public MismatchingAttributeTypeException(String message) {
        super(message+"type mismatch");
    }
}
