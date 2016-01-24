package com.runningphotos.bom;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;


public class Race extends EntityWithName {

    @NotEmpty
    private Date raceDate;

    @NotBlank
    private String city;

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
}
