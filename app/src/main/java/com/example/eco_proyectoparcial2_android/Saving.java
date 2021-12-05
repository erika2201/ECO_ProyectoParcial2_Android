package com.example.eco_proyectoparcial2_android;

import androidx.annotation.NonNull;

public class Saving {
    private String name;
    private String cant;
    private String date;
    private String freq;

    public Saving() {}

    public Saving(String name, String cant, String date, String freq) {
        this.name = name;
        this.cant = cant;
        this.date = date;
        this.freq = freq;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    @Override
    public String toString() {
        return name+ " " +cant+ "\n" +date+ "\n" +freq;
    }
}
