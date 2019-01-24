package org.pursuit.unit_03_assessment.model;

public class PlanetImage {
    private String name;
    private String number;

    public PlanetImage(String name, String number){
        this.name = name;
        this.number = number;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }
}
