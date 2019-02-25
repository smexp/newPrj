package com.smal.core.engine.attributes;

import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

public interface GeneralAttribute {

    Object getValue();
    String getType();
    boolean setValue(Object obj) throws MismatchingAttributeTypeException;
    String toStringValue();
}
