package com.smal.core.engine.methods;

import com.smal.core.engine.exeptions.InitDObjectIsNotFoundException;
import java.io.File;

public class InitObjectsFromFileDirectory implements InitDictionaryObjects {

    private String folderPath;

    public InitObjectsFromFileDirectory(String folderPathVar) {
        this.folderPath=folderPathVar;
    }

    //read names from directory
    public String readObjects() throws InitDObjectIsNotFoundException {
        final File folder = new File(this.folderPath);
        String msg = "success";
        try {

            for (final File fileEntry : folder.listFiles()) {
                System.out.println(fileEntry.getName());
            }
            //System.out.println("fileEntry="+folder.listFiles().length);
            if (folder.listFiles().length==0){throw new InitDObjectIsNotFoundException(this.folderPath);}

            /*
            https://code.google.com/archive/p/json-simple/
            {
                "name":"test",
                "fields":{"name":{"alias":false,"type":1},"field2":{"alias":false,"type":1}}
             }
             */

        } catch (NullPointerException e){System.out.println(e.getLocalizedMessage());}

        return msg;
    }
    //create object from files

    //get file name
    //get file content
        //name,type,value,parentIndx
        //'name',2,'test',0
        //'data',3,'',0
        //'counter',1,'1',0
        //'boolean',4,'true',0

    // check content
    // create object
}
