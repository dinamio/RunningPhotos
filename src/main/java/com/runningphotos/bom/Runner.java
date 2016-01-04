package com.runningphotos.bom;

import java.util.List;


public class Runner extends EntityWithName{

  private String surname;

  private Sex sex;

  private User user;

  private List<Result> results;


  public String getSurname() {
    return surname;
  }


  public void setSurname(String surname) {
    this.surname = surname;
  }


  public User getUser() {
    return user;
  }


  public void setUser(User user) {
    this.user = user;
  }


  public List<Result> getResults() {
    return results;
  }


  public void setResults(List<Result> results) {
    this.results = results;
  }


  public Sex getSex() { return sex; }


  public void setSex(Sex sex) { this.sex = sex; }

}
