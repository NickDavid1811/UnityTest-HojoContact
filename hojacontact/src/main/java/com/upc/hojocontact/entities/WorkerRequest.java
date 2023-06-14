package com.upc.hojocontact.entities;

public class WorkerRequest {

  private int idRequest;
  private String username;
  private int remarks;
  private String review;
  private int price;
  private String job;

  public WorkerRequest() {
  }

  public WorkerRequest(int idRequest, String username, int remarks, String review, int price, String job) {
    super();
    this.idRequest = idRequest;
    this.username = username;
    this.remarks = remarks;
    this.review = review;
    this.price = price;
    this.job = job;
  }

  public int getIdRequest() {
    return idRequest;
  }

  public String getUsername() {
    return username;
  }

  public int getRemarks() {
    return remarks;
  }

  public String getReview() {
    return review;
  }

  public int getPrice() {
    return price;
  }

  public String getJob() {
    return job;
  }

  public void setIdRequest(int idRequest) {
    this.idRequest = idRequest;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setRemarks(int remarks) {
    this.remarks = remarks;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setJob(String job) {
    this.job = job;
  }

  @Override
  public String toString() {
    return String.valueOf(idRequest) + "-" + username + "-" + String.valueOf(remarks) + "-" + review + "-"
        + String.valueOf(price)
        + "-" + job;
  }
}
