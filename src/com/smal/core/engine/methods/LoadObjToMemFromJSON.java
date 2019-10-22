package com.smal.core.engine.methods;
import jdk.nashorn.internal.parser.JSONParser;
import com.smal.core.engine.CObject;

import java.util.Map;

public class LoadObjToMemFromJSON {

    public static Boolean loadObjectFromJSONString(Map<String, CObject> dictionaryMap, String jsonString){
        //try to convert string to json
        /*
        try {
            JSONObject jsonObject = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
        }catch (JSONException err){
            Log.d("Error", err.toString());
        }
        */

        //JSONParser
        //add json object to dictionaryMap
        return true;
    }
}
