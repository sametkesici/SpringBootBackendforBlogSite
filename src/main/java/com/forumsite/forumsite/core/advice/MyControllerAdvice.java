package com.forumsite.forumsite.core.advice;

import com.forumsite.forumsite.core.responses.DataResponse;
import com.forumsite.forumsite.core.responses.ErrorDataResponse;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice  {


  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public DataResponse<Object> handleException(HttpServletRequest req, MethodArgumentNotValidException ex)  {
    Map<String,String> validationErrors = new HashMap<String,String>();
    for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
      validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
    }

    return new ErrorDataResponse<>(validationErrors, false, "validation errors");
  }





}
