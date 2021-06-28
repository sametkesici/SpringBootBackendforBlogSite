package com.forumsite.forumsite.core.responses;

public class DataResponse<T> extends Response {

  public T data;

  public DataResponse(T data ,boolean success) {
    super(success);
    this.data = data;
  }

  public DataResponse(T data,boolean success, String message) {
    super(success, message);
    this.data = data;
  }

  public T getData(){
    return this.data;
  }

}
