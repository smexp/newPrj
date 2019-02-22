package com.smal.core.engine;

import com.smal.core.engine.attributes.FactoryAttributeInstance;
import com.smal.core.engine.attributes.GeneralAttribute;
import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

public class AttributeOrAlias {

    private boolean isField;
    private int parentIndexInStructure;
    private int indexInStructure;
    private GeneralAttribute attributeObject;

    //constructor
    public AttributeOrAlias    (
            boolean isFieldParam,
            int parentIndexInStructureParam,
            int indexInStructureParam,
            Object parameterValueParam,
            int typeNumber
    ) throws MismatchingAttributeTypeException {
        isField = isFieldParam;
        parentIndexInStructure = parentIndexInStructureParam;
        indexInStructure = indexInStructureParam;
        attributeObject = FactoryAttributeInstance.createInstance(typeNumber, parameterValueParam);
    }

    GeneralAttribute getAttributeObject() {
        return attributeObject;
    }

    Object getValue()
    {
        if (attributeObject != null)
            return attributeObject.getValue();
        return null;
    }

    String getType()
    {
        if (attributeObject != null)
            return attributeObject.getType();
        return null;
    }

    public String toStringAttributeOrAlias() {
        if (attributeObject != null)
            return attributeObject.toStringValue();
        return null;
    }

    int getIndexInStructure() {
        return indexInStructure;
    }

    public boolean isField() {
        return isField;
    }

}
