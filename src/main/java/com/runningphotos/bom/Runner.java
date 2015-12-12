package com.runningphotos.bom;

import java.util.List;


public class Runner extends EntityWithName{

  private String surname;

  private User user;

  private List<RunnerResult> results;

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


  public List<RunnerResult> getResults() {
    return results;
  }


  public void setResults(List<RunnerResult> results) {
    this.results = results;
  }

}
