package com.ohj4.kasvit;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

public class Alarm implements Serializable {
    private String description  = "Lorem ipsum";
    private Time time = new Time(9,9,9);
    private static final ArrayList<String> repeat = new ArrayList<String>(Arrays.asList("Päivittäin", "Viikottain", "Kuukausittain", "Vuosittain"));


    public Alarm() {
    }

    public Alarm (Time time, String description) {
        this.time = time;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
