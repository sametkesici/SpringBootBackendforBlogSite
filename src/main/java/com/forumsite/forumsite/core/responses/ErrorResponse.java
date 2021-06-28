package com.forumsite.forumsite.core.responses;

public class ErrorResponse extends Response{

  public ErrorResponse(boolean success) {
    super(false);
  }

  public ErrorResponse(boolean success, String message) {
    super(false, message);
  }
}
