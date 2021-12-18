package com.umar.apps.spring.factorymethod;

import com.umar.apps.spring.factorymethod.instance.Bar;

public class StaticBarFactory {

    private static volatile Bar INSTANCE;

    public static Bar getInstance(String name) {
        if(null == INSTANCE) {
            synchronized (StaticFooFactory.class) {
                if(null == INSTANCE) {
                    INSTANCE = new Bar(name);
                }
            }
        }
        return INSTANCE;
    }
}
