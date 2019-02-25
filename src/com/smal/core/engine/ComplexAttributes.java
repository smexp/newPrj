package com.smal.core.engine;

import com.smal.core.engine.exeptions.AttributeIsNotFoundException;
import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

import java.util.HashMap;
import java.util.Map;

public class ComplexAttributes {
    private Map<Integer, AttributeOrAlias> indexHashMap;
    private Map<String, AttributeOrAlias> nameHashMap;
    private int lastIndex;

    Map<Integer, AttributeOrAlias> getIndexHashMap() { return indexHashMap;}
    Map<String, AttributeOrAlias> getNameHashMap() {
        return nameHashMap;
    }

    int getLastIndex() {
        return lastIndex;
    }
    void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    //constructor
    ComplexAttributes() {
        this.indexHashMap = new HashMap<>();
        this.nameHashMap = new HashMap<>();
    }

    Object getAttributeValueByName(String inName) {return this.getNameHashMap().get(inName).getValue();}
    String getAttributeTypeByName(String inName)  {return this.getNameHashMap().get(inName).getType();}

    boolean addAttributeValue (String name, Object attributeValue, int parentIndex, int typeNumber) throws MismatchingAttributeTypeException {
        //check duplicates
        if (this.getNameHashMap().get(name)==null)
        {
            int tmpIndex = lastIndex+1;
            AttributeOrAlias tmpAttribute = new AttributeOrAlias(true, parentIndex, tmpIndex, attributeValue, typeNumber);
            indexHashMap.put(tmpIndex, tmpAttribute);
            nameHashMap.put(name,tmpAttribute);
            lastIndex++;
            return true;
        }
        return false;
    }

    boolean updateAttributeValue (String name, Object attributeValue) throws AttributeIsNotFoundException, MismatchingAttributeTypeException {
        AttributeOrAlias updAttribute = this.nameHashMap.get(name);
        if (updAttribute != null)
        {
            if ( attributeValue!=null && attributeValue.getClass().getSimpleName().equalsIgnoreCase(updAttribute.getType()))
            {

                return updAttribute.getAttributeObject().setValue(attributeValue); //boolean type
            }
            else
            {
                throw new MismatchingAttributeTypeException("by update");
            }

        }
        else {
            throw new AttributeIsNotFoundException("by update");
        }
    }


}
