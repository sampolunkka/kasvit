package com.ohj4.kasvit;

import android.app.Notification;

import java.util.ArrayList;

public class Plant {

    private String name = "Name here";
    private String description = "Description here";
    private boolean notificationIsSet = false;
    private ArrayList<Notification> notifications = new ArrayList<>();

    public Plant() {
    }

    public Plant(String name) {
        this.name = name;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public void removeNotification(int id) {
        this.notifications.remove(id);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotificationIsSet(boolean notificationIsSet) {
        this.notificationIsSet = notificationIsSet;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getName() {
        return name;
    }
}
