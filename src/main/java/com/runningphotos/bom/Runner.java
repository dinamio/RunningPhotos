package com.runningphotos.bom;

import java.util.List;


public class Runner extends EntityWithName{

  private String surname;

  private Sex sex;

  private List<Result> results;


  public String getSurname() {
    return surname;
  }


  public void setSurname(String surname) {
    this.surname = surname;
  }

  public List<Result> getResults() {
    return results;
  }


  public void setResults(List<Result> results) {
    this.results = results;
  }


  public Sex getSex() { return sex; }


  public void setSex(Sex sex) { this.sex = sex; }

  public String toString(){
    return getName()+" "+getSurname();
  }
}
