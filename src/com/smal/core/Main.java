package com.smal.core;

import com.smal.core.engine.AttributeOrAlias;
import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            AttributeOrAlias a = new AttributeOrAlias(true, 0, 1,5,1);
            System.out.println(a.toStringAttributeOrAlias());

        } catch (MismatchingAttributeTypeException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
