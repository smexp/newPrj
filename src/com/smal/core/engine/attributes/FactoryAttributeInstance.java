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


}
