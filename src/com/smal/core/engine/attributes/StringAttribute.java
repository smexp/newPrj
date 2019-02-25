package com.smal.core.engine.attributes;

import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

public class StringAttribute implements GeneralAttribute {

    private String type;
    private String value;

    StringAttribute(Object obj) throws MismatchingAttributeTypeException {
        if (obj != null && obj.getClass().getSimpleName().equalsIgnoreCase("String"))
        {
            this.type = "String";
            this.value = obj.toString();
        }
        else {
            if (obj != null) {
                throw new MismatchingAttributeTypeException("ERROR by create String attribute: " + obj.getClass().getSimpleName() + " ");
            } else
            {
                throw new MismatchingAttributeTypeException("ERROR by create String attribute: NULL parameter ");
            }
        }
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public boolean setValue(Object obj) throws MismatchingAttributeTypeException {
        if (obj.getClass().getSimpleName().equalsIgnoreCase("String"))
        {
            this.value = obj.toString();
            return true;
        }
        else throw new MismatchingAttributeTypeException("ERROR by set attribute: ");
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String toStringValue() {
        return this.value;
    }
}
