package com.pluralsight;

import java.util.Locale;

public class CodeWars {
    public String think;
    public String apply;

    public CodeWars(String apply, String think) {
        this.apply = apply;
        this.think = think;
    }

    public String getThink() {
        return think;
    }

    public void setThink(String think) {
        this.think = think;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    @Override
    public String toString() {
        return "CodeWars{" +
                "think='" + think + '\'' +
                ", apply='" + apply + '\'' +
                '}';
    }
}
