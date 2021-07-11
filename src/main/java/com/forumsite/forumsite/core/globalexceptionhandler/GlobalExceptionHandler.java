package com.forumsite.forumsite.core.globalexceptionhandler;

import com.forumsite.forumsite.core.responses.DataResponse;
import com.forumsite.forumsite.core.responses.ErrorDataResponse;
import java.util.HashMap;
import java.util.Map;
import javassist.NotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public DataResponse handleException(HttpServletRequest req, MethodArgumentNotValidException ex)  {
    Map<String,String> validationErrors = new HashMap<String,String>();
    for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
      validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
    }
    validationErrors.put("requestURI" , req.getRequestURI());

    return new ErrorDataResponse<>(validationErrors, false, "validation errors");
  }


  @ExceptionHandler(value = NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public DataResponse notFoundException(HttpServletRequest req, MethodArgumentNotValidException ex){
    Map<String,String> validationErrors = new HashMap<String,String>();
    for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
      validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
    }
    validationErrors.put("requestURI" , req.getRequestURI());

    return new ErrorDataResponse<>(validationErrors, false, "not found error");

  }


  @ExceptionHandler(value = IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public DataResponse passwordException(HttpServletRequest req, MethodArgumentNotValidException ex)  {
    Map<String,String> validationErrors = new HashMap<String,String>();
    for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
      validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
    }
    validationErrors.put("requestURI" , req.getRequestURI());

    return new ErrorDataResponse<>(validationErrors, false, "pw errors");
  }




}
