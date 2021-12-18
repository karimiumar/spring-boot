package com.umar.apps.spring.factorymethod;

import com.umar.apps.spring.factorymethod.instance.Foo;

public class StaticFooFactory {

    private static final Foo INSTANCE = new Foo();

    public static Foo getInstance() {
        return INSTANCE;
    }
}
