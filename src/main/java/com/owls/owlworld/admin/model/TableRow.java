package com.owls.owlworld.admin.model;

public class TableRow {
    String univName;
    String period;
    String major;
    String type;
    String maximumNumber;
    String competitive;

    public TableRow(String univName, String period, String major, String type, String maximumNumber, String competitive) {
        this.univName = univName;
        this.period = period;
        this.major = major;
        this.type = type;
        this.maximumNumber = maximumNumber;
        this.competitive = competitive;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    @Override
    public String toString() {
        return "TableRow{" +
            "univName='" + univName + '\'' +
            ", period='" + period + '\'' +
            ", major='" + major + '\'' +
            ", type='" + type + '\'' +
            ", maximumNumber='" + maximumNumber + '\'' +
            ", competitive='" + competitive + '\'' +
            '}';
    }
}
