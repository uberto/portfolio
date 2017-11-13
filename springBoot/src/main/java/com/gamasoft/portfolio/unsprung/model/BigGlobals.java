
package com.gamasoft.portfolio.unsprung.model;

public class BigGlobals {
    static private Context instance;

    static public Context get() {
        return instance;
    }

    static public void init(Context newInstance) {
        instance = newInstance;
    }
}
