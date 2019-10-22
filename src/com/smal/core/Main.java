package com.smal.core;

import com.smal.core.engine.CObject;
import com.smal.core.engine.exeptions.InitDObjectIsNotFoundException;
import com.smal.core.engine.exeptions.MismatchingAttributeTypeException;
import com.smal.core.engine.methods.InitObjectsFromFileDirectory;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //-------------------------------
        //---- first steps --------------
        /*
        try {
            AttributeOrAlias a = new AttributeOrAlias(true, 0, 1,5,1);
            System.out.println(a.toStringAttributeOrAlias());

        } catch (MismatchingAttributeTypeException e) {
            System.out.println(e.getLocalizedMessage());
        }
        */

                /*
        AttributeTypes obj = new AttributeTypes(new Integer(10));
        System.out.println(obj.getType() +" "+obj.getValue());
        AttributeOrAlias attOrAl = new AttributeOrAlias(true, 0, 1, obj);
        System.out.println(obj);
        System.out.println(attOrAl.getAttributeObject());

        System.out.println(attOrAl.getType() +" "+attOrAl.getValue());

        AttributeOrAlias attOrAl2 = new AttributeOrAlias(false, 0,2,null);
        System.out.println("Attributes: "+attOrAl2.getType() +" "+attOrAl2.getValue());
        */
        //-----------------------
        // замер исполнения кода
        /*
        long time = timer(() -> {

            for (int i = 0; i < 500; i++) {
         */
        //---------------------------------------------
        CObject objFirst = new CObject();
        objFirst.setClass_name("first");

        try{
        // System.out.println("sysmodcount="+objFirst.getSysmodcount());
        objFirst.addAttributeValue("new", "table", 0);

        objFirst.addAttributeValue("name", "testttt", 0);
        objFirst.addAttributeValue("number", 1, 0);
        objFirst.addAttributeValue("test.atr", new Object(), 0);
        objFirst.addAttributeValue("date", new Date(), 0);
        objFirst.addAttributeValue("isObj", true, 0);

        objFirst.updateAttributeValueByName("name", "first");
        objFirst.updateAttributeValueByName("name", "first2");



        System.out.println(objFirst.toString());
        System.out.print("isObj = ");
        if (objFirst.getAttributeValueByName("isObj") != null)
            System.out.println(objFirst.getAttributeValueByName("isObj").toString());
        else System.out.println("null");
        //System.out.println("sysmodcount="+objFirst.getSysmodcount());

        //---------------------------------------------
        /*
        }
        }, TimeUnit.NANOSECONDS);

        System.out.println("Time to check: "+time+" ns");
        */
        //test file folder
            InitObjectsFromFileDirectory objF= new InitObjectsFromFileDirectory("C:\\\\WORKS\\\\TEMP\\\\test");

            try {
                if (objF.readObjects().equalsIgnoreCase("success")){System.out.println("All objects were successfully loaded");} else {System.out.println("By loading was error occurred");}
            }
            catch (InitDObjectIsNotFoundException e){System.out.println(e.getLocalizedMessage());}


    }
        catch (MismatchingAttributeTypeException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
/*
        private static long timer(Runnable method, TimeUnit timeUnit) {
            long time = System.nanoTime();
            method.run();
            time = System.nanoTime() - time;
            return TimeUnit.NANOSECONDS.convert(time, timeUnit);
        }
*/
}}
