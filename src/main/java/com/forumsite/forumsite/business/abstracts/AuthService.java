package com.forumsite.forumsite.business.abstracts;

import com.forumsite.forumsite.core.responses.DataResponse;
import com.forumsite.forumsite.entities.concretes.User;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {

  Map<String, String> refreshToken(HttpServletRequest request, HttpServletResponse response);

}
