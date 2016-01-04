package com.runningphotos.bom;


public class Result extends Entity {

  private String number;

  private Distance distance;

  private Time time;

  private Runner runner;

  private Race race;



  public String getNumber() {
    return number;
  }


  public void setNumber(String number) {
    this.number = number;
  }


  public Distance getDistance() {
    return distance;
  }


  public void setDistance(Distance distance) {
    this.distance = distance;
  }


  public Time getTime() {
    return time;
  }


  public void setTime(Time time) {
    this.time = time;
  }


  public Race getRace() {
    return race;
  }


  public void setRace(Race race) {
    this.race = race;
  }


  public Runner getRunner() { return runner; }


  public void setRunner(Runner runner) { this.runner = runner; }

}
