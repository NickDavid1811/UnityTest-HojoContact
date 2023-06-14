package com.upc.hojocontact.entities;

public class ClientRequest {
  private int idRequest;
  private String username;
  private String requestDescription;
  private String location;
  private String phoneNumber;

  public ClientRequest(int i) {
  }

  public ClientRequest(int idRequest, String username, String requestDescription, String location,
      String phoneNumber) {
    super();
    this.idRequest = idRequest;
    this.username = username;
    this.requestDescription = requestDescription;
    this.location = location;
    this.phoneNumber = phoneNumber;
  }

  public int getIdRequest() {
    return idRequest;
  }

  public String getUsername() {
    return username;
  }

  public String getRequestDescription() {
    return requestDescription;
  }

  public String getLocation() {
    return location;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setIdRequest(Integer idRequest) {
    this.idRequest = idRequest;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setRequestDescription(String requestDescription) {
    this.requestDescription = requestDescription;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return String.valueOf(idRequest) + "-" + username + "-" + requestDescription + "-" + location + "-" + phoneNumber;
  }

}
