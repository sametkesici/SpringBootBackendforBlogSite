package com.forumsite.forumsite.core.responses;

import java.util.List;

public class SuccessDataResponse<T> extends DataResponse<T> {

  public SuccessDataResponse(T data, boolean success) {
    super(data, true);
  }

  public SuccessDataResponse(T data, boolean success, String message) {
    super(data, true, message);
  }


}
