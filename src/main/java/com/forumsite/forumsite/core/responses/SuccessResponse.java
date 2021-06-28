package com.forumsite.forumsite.core.responses;

public class SuccessResponse extends Response{

  public SuccessResponse(boolean success) {
    super(true);
  }

  public SuccessResponse(boolean success, String message) {
    super(true, message);
  }
}
