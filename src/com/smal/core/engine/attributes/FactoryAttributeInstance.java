package com.smal.core.engine.attributes;

import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

public class FactoryAttributeInstance {

    public static GeneralAttribute createInstance(int type_number, Object obj) throws MismatchingAttributeTypeException {
        switch (type_number) {
            case 1: return new NumberAttribute(obj);
            case 2: return new StringAttribute(obj);
            case 3:return new DateAttribute(obj);
            case 4:return new BooleanAttribute(obj);
            default: throw new MismatchingAttributeTypeException("ERROR: ");
        }

    }

    public static int getTypeNumber (Object obj){
        if (obj!=null && obj.getClass().getSimpleName().toUpperCase().equals("INTEGER")) {return 1;}
        if (obj!=null && obj.getClass().getSimpleName().toUpperCase().equals("STRING")) {return 2;}
        if (obj!=null && obj.getClass().getSimpleName().toUpperCase().equals("DATE")) {return 3;}
        if (obj!=null && obj.getClass().getSimpleName().toUpperCase().equals("BOOLEAN")) {return 4;}
        return -1;
    }

}
