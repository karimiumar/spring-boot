package com.umar.apps.spring.methodinjection.provider;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Provider;

public class Student {

    private String id;

    @Autowired
    private Provider<SchoolNotification> schoolNotificationProvider;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public SchoolNotification getNotification(String name) {
        return schoolNotificationProvider.get();
    }

    public void setSchoolNotificationProvider(Provider<SchoolNotification> schoolNotificationProvider) {
        this.schoolNotificationProvider = schoolNotificationProvider;
    }

    public Provider<SchoolNotification> getSchoolNotificationProvider() {
        return schoolNotificationProvider;
    }
}
