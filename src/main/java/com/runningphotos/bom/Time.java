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

  public Time() {}

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


  public String getTimeToString(){
    String hour="0";
    String minute="0";
    String second="0";
    String timeresult;
    if((hours/10)==0)
      hour+=hours;
    else hour= String.valueOf(hours);
    if((minutes/10)==0)
      minute+=minutes;
    else minute= String.valueOf(minutes);
    if((seconds/10)==0)
      second+=seconds;
    else second= String.valueOf(seconds);
    timeresult=hour+":"+minute+":"+second;
    return timeresult;
  //return hours+":"+minutes+":"+seconds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Time time = (Time) o;

    if (hours != null ? !hours.equals(time.hours) : time.hours != null) return false;
    if (minutes != null ? !minutes.equals(time.minutes) : time.minutes != null) return false;
    return !(seconds != null ? !seconds.equals(time.seconds) : time.seconds != null);

  }

  @Override
  public int hashCode() {
    int result = hours != null ? hours.hashCode() : 0;
    result = 31 * result + (minutes != null ? minutes.hashCode() : 0);
    result = 31 * result + (seconds != null ? seconds.hashCode() : 0);
    return result;
  }
}
