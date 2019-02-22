package com.smal.core.engine.attributes;

import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class BooleanAttribute implements GeneralAttribute {
    private String type;
    private Boolean value;

    BooleanAttribute(Object obj) throws MismatchingAttributeTypeException {
        if (obj != null && obj.getClass().getSimpleName().equalsIgnoreCase("Boolean"))
        {
            this.type = "Boolean";
            this.value = (Boolean)obj;
        }
        else {
            if (obj != null) {
                throw new MismatchingAttributeTypeException("ERROR by create Boolean attribute: " + obj.getClass().getSimpleName() + " ");
            } else
            {
                throw new MismatchingAttributeTypeException("ERROR by create Boolean attribute: NULL parameter ");
            }
        }
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object obj) throws MismatchingAttributeTypeException {
        if (obj.getClass().getSimpleName().equalsIgnoreCase("Boolean"))
        {
            this.value = (Boolean) obj;
        }
        else throw new MismatchingAttributeTypeException("ERROR by set attribute: ");
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String toStringValue() {
        return this.value.toString();
    }
}
