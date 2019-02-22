package com.smal.core.engine.attributes;

import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

public class NumberAttribute implements GeneralAttribute {

    private String type;
    private Integer value;

    NumberAttribute(Object obj) throws MismatchingAttributeTypeException {
        if (obj != null && obj.getClass().getSimpleName().equalsIgnoreCase("Integer"))
        {
            this.type = "Number";
            this.value = (Integer)obj;
        }
        else {
            if (obj != null) {
                throw new MismatchingAttributeTypeException("ERROR by create Number attribute: " + obj.getClass().getSimpleName() + " ");
            } else {
                throw new MismatchingAttributeTypeException("ERROR by create Number attribute: NULL parameter ");
            }
        }
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object obj) throws MismatchingAttributeTypeException {
        if (obj.getClass().getSimpleName().equalsIgnoreCase("Integer"))
        {
            this.value = (Integer)obj;
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
