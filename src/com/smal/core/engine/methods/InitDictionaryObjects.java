package com.smal.core.engine.methods;

import com.smal.core.engine.exeptions.InitDObjectIsNotFoundException;

public interface InitDictionaryObjects {
    String readObjects() throws InitDObjectIsNotFoundException;
}
