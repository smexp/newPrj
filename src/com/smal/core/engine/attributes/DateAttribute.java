package com.smal.core.engine.attributes;

import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAttribute implements GeneralAttribute {

    private String type;
    private Date value;

    DateAttribute(Object obj) throws MismatchingAttributeTypeException {
        if (obj != null && obj.getClass().getSimpleName().equalsIgnoreCase("Date"))
        {
            this.type = "Date";
            this.value = (Date)obj;
        }
        else {
            if (obj != null) {
                throw new MismatchingAttributeTypeException("ERROR by create Date attribute: " + obj.getClass().getSimpleName() + " ");
            } else
            {
                throw new MismatchingAttributeTypeException("ERROR by create Date attribute: NULL parameter ");
            }
        }
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object obj) throws MismatchingAttributeTypeException {
        if (obj.getClass().getSimpleName().equalsIgnoreCase("Date"))
        {
            this.value = (Date)obj;
        }
        else throw new MismatchingAttributeTypeException("ERROR by set attribute: ");
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String toStringValue() {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "\'"+DATE_FORMAT.format(this.getValue())+"\'";
    }
}
