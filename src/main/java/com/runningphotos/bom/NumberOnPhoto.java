package com.runningphotos.bom;

/**
 * Created by Oleg on 20.03.2016.
 */
public class NumberOnPhoto extends Entity {

    String number;

    RacePhoto racePhoto;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public RacePhoto getRacePhoto() {
        return racePhoto;
    }

    public void setRacePhoto(RacePhoto racePhoto) {
        this.racePhoto = racePhoto;
    }

    @Override
    public String toString() {
        return "NumberOnPhoto{" +
                "number='" + number + '\'' +
                ", racePhoto=" + racePhoto +
                '}';
    }
}
