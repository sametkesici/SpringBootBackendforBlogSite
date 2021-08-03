package com.forumsite.forumsite.business.abstracts;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

  Map<String, String> refreshToken(HttpServletRequest request, HttpServletResponse response);



}
