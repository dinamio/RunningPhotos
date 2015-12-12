package bom;

import java.util.Date;


public class Race extends EntityWithName {

    private Date raceDate;

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
