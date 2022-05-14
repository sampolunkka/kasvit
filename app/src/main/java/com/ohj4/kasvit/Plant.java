package com.ohj4.kasvit;

import android.app.Notification;

import java.io.Serializable;
import java.util.ArrayList;

public class Plant implements Serializable {

    private String name = "Name here";
    private String description = "Description here";
    private boolean alarmIsSet = false;
    private ArrayList<Alarm> alarms = new ArrayList<>();

    public Plant() {
        addAlarm(new Alarm());
    }

    public Plant(String name) {
        this.name = name;
        addAlarm(new Alarm());
    }

    public Plant(String name, String description, boolean alarmIsSet, ArrayList<Alarm> alarms) {
        this.name = name;
        this.description = description;
        this.alarmIsSet = alarmIsSet;
        this.alarms = alarms;
    }

    public void addAlarm(Alarm alarm) {
        this.alarms.add(alarm);
    }

    public ArrayList<Alarm> getAlarms() {
        return this.alarms;
    }

    public void removeAlarm(int id) {
        this.alarms.remove(id);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotificationIsSet(boolean alarmIsSet) {
        this.alarmIsSet = alarmIsSet;
    }

    public void setNotifications(ArrayList<Alarm> alarms) {
        this.alarms = alarms;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
