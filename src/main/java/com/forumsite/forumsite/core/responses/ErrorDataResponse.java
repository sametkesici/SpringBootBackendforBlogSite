package com.forumsite.forumsite.core.responses;

public class ErrorDataResponse<T> extends DataResponse<T>{

  public ErrorDataResponse(T data, boolean success) {
    super(data, false);
  }

  public ErrorDataResponse(T data, boolean success , String message){
    super(data,false,message);

  }

}
