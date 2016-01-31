package com.runningphotos.bom;

import java.util.Date;

public class Race extends EntityWithName {

    private Date raceDate;

    private String city;

    private String photo;

    public Date getRaceDate() {
      return raceDate;
    }


    public void setRaceDate(Date raceDate) {
      this.raceDate = raceDate;
    }


    public String getCity() {
      return city;
    }


    public void setCity(String city) {
      this.city = city;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
