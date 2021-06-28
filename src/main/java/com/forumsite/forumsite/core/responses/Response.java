package com.forumsite.forumsite.core.responses;

public class Response {

  private boolean success;
  private String message;

  public Response(boolean success){
    this.success = success;
  }

  public Response(boolean success , String message){
    this(success);
    this.message = message;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public String getMessage(){
    return this.message;
  }

}
