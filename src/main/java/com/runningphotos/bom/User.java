package com.runningphotos.bom;

import org.hibernate.validator.constraints.Range;

import java.util.Date;


public class User extends EntityWithName {

  private String login;

  private String mail;

  private String surname;

  private String city;

  private Role role;

  private Date birthDate;
@Range(min=6,max=150)
  private String password;


  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }


  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String pasword) {
    this.password = pasword;
  }


  public String getMail() {
    return mail;
  }


  public void setMail(String mail) {
    this.mail = mail;
  }


  public String getSurname() {
    return surname;
  }


  public void setSurname(String surname) {
    this.surname = surname;
  }


  public String getCity() {
    return city;
  }


  public void setCity(String city) {
    this.city = city;
  }


  public Role getRole() {
    return role;
  }


  public void setRole(Role role) {
    this.role = role;
  }


  public Date getBirthDate() {
    return birthDate;
  }


  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String toString(){
    return "User: name = "+getName()+ " surname = "+getSurname();
  }

}
