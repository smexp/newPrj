package com.smal.core.engine;

import com.smal.core.engine.attributes.FactoryAttributeInstance;
import com.smal.core.engine.exeptions.AttributeIsNotFoundException;
import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CObject {
    private String class_name;
    private Date sysmodtime;
    private String sysmoduser;
    private int sysmodcount;

    private Map<String, AttributeOrAlias> attributesMapByNames;
    private Map<Integer, AttributeOrAlias> attributesMapByIndex;
    private ComplexAttributes firstElementOfParentStructure;
    private Map<Integer, ComplexAttributes> parentArrayLevelStructure;

    public CObject() {
        this.attributesMapByNames = new HashMap<String, AttributeOrAlias>();
        this.attributesMapByIndex = new HashMap<Integer, AttributeOrAlias>();
        this.parentArrayLevelStructure = new HashMap<Integer, ComplexAttributes>();
        // Initialization--------------
        this.firstElementOfParentStructure = new ComplexAttributes();
        this.parentArrayLevelStructure.put(0,this.firstElementOfParentStructure);

    }

    public Map<Integer, ComplexAttributes> getParentArrayLevelStructure() {
        return parentArrayLevelStructure;
    }

    public ComplexAttributes getFirstElementOfParentStructure() {
        return firstElementOfParentStructure;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Map<String, AttributeOrAlias> getAttributesMapByNames() {
        return attributesMapByNames;
    }

    public void setAttributesMapByNames(Map<String, AttributeOrAlias> attributesMapByNames) {
        this.attributesMapByNames = attributesMapByNames;
    }

    public Date getSysmodtime() {
        return sysmodtime;
    }

    public void setSysmodtime(Date sysmodtime) {
        this.sysmodtime = sysmodtime;
    }

    public String getSysmoduser() {
        return sysmoduser;
    }

    public void setSysmoduser(String sysmoduser) {
        this.sysmoduser = sysmoduser;
    }

    public int getSysmodcount() {
        return sysmodcount;
    }

    public void setSysmodcount(int sysmodcount) {
        this.sysmodcount = sysmodcount;
    }

    public boolean addAttributeValue (String name, Object obj, int parentIndx) throws MismatchingAttributeTypeException {
        try {
            // get attribute number to check it
            int typeNumber = FactoryAttributeInstance.getTypeNumber(obj);
            firstElementOfParentStructure.addAttributeValue(name, obj, parentIndx, typeNumber);
            return true;
        }
        catch (MismatchingAttributeTypeException e)
        {
            System.out.println("ERROR: Field name = \""+name+"\" "+e.getLocalizedMessage());
        }
        return false;
    }

    public boolean updateAttributeValueByName (String name, Object attributeValue)
    {
        try

        {
            if(firstElementOfParentStructure.updateAttributeValue(name, attributeValue)) {
                //System.out.println("function = "+this.sysmodcount);
                //this.sysmodcount = this.sysmodcount+1; //логика должна работать при обновлении в базе
                return true;//boolean type
            }
        }
        catch (MismatchingAttributeTypeException | AttributeIsNotFoundException e)
        {
            System.out.println("ERROR: Field name = \""+name+"\" "+e.getLocalizedMessage());
        }
        return false;
    }

    // переписать проход по всем элементам и вывод их на печать через BufferString
    @Override
    public String toString() {

        StringBuilder strBuff = new StringBuilder("{");
        // построить последоватьный вывод по индексам, т.к. сейчас индексы не учитываются и порядок произвольный
        strBuff.append("[");
        int lastIndexInStructure = this.firstElementOfParentStructure.getLastIndex();
        for (AttributeOrAlias value : this.firstElementOfParentStructure.getIndexHashMap().values()) {
            // ...
            if (value.isField()) strBuff.append(value.toStringAttributeOrAlias());
            //System.out.println("index in obj ="+value.getIndexInStructure()+" last inx="+lastIndexInStructure);
            if (value.getIndexInStructure() < lastIndexInStructure)strBuff.append(",");
        }
        // ...
        strBuff.append("]");
        strBuff.append("}");
        //System.out.println("indexes = "+ lastIndexInStructure);
        return this.getClass_name()+"="+strBuff.toString();
    }

    public Object getAttributeValueByName(String name)  {
        // поиск по всем аттрибутам первого уровня
        AttributeOrAlias attributObj = this.firstElementOfParentStructure.getNameHashMap().get(name);
        if (attributObj!= null)
        {
            return attributObj.getAttributeObject().getValue();
        }
        else
            return null;
    }
}
