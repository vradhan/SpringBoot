package com.primefaces.bean;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

@ManagedBean
@Component
public class HelloWorld {

  private String firstName ;
  private String lastName ;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String showGreeting() {
    return "Hello " + firstName + " " + lastName + "!";
  }
}