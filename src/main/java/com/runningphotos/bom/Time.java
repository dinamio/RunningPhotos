package com.runningphotos.bom;


public class Time {

  private Integer hours;

  private Integer minutes;

  private Integer seconds;

  public Time(Integer hours, Integer minutes, Integer seconds) {
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }


  public Integer getHours() {
    return hours;
  }


  public void setHours(Integer hours) {
    this.hours = hours;
  }


  public Integer getMinutes() {
    return minutes;
  }


  public void setMinutes(Integer minutes) {
    this.minutes = minutes;
  }


  public Integer getSeconds() {
    return seconds;
  }


  public void setSeconds(Integer seconds) {
    this.seconds = seconds;
  }

}
