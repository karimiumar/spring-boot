package com.umar.apps.spring.methodinjection.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("studentBean")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Student {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Injects a prototype bean SchoolNotification into Singleton Student
     * @param name
     * @return
     */
    @Lookup
    public SchoolNotification getNotification(String name) {
        //Spring overrides and returns a SchoolNotification instance
        return null;
    }
}
