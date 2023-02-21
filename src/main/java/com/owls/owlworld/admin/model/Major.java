package com.owls.owlworld.admin.model;

public class Major {

    String name;
    String period;
    String type;
    String maximumNumber;
    String competitive;

    public Major(String name, String period, String type, String maximumNumber, String competitive) {
        this.name = name;
        this.period = period;
        this.type = type;
        this.maximumNumber = maximumNumber;
        this.competitive = competitive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaximumNumber() {
        return maximumNumber;
    }

    public void setMaximumNumber(String maximumNumber) {
        this.maximumNumber = maximumNumber;
    }

    public String getCompetitive() {
        return competitive;
    }

    public void setCompetitive(String competitive) {
        this.competitive = competitive;
    }
}
