package com.umar.apps.spring.methodinjection.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;
import java.util.HashMap;
import java.util.Map;

@Component("studentServices")
public class StudentServices {

    private final Map<String, SchoolNotification> notes = new HashMap<>();

    @Autowired
    private Provider<SchoolNotification> schoolNotificationProvider;

    public SchoolNotification getNotification(String name) {
        return schoolNotificationProvider.get();
    }

    public String appendMark(String name, Integer mark) {
        var notification = notes.computeIfAbsent(name, exists -> getNotification(name));
        return notification.addMark(mark);
    }

    public void setSchoolNotificationProvider(Provider<SchoolNotification> schoolNotificationProvider) {
        this.schoolNotificationProvider = schoolNotificationProvider;
    }

    public Provider<SchoolNotification> getSchoolNotificationProvider() {
        return schoolNotificationProvider;
    }
}
