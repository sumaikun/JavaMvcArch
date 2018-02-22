/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvcarch.controller;

import com.mvcarch.model.User;
import com.mvcarch.service.LoginService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String userName=request.getParameter("userName");
String password=request.getParameter("password");

LoginService loginService=new LoginService();
if(loginService.isValidUser(userName, password)){
User user=loginService.getUser();
request.setAttribute("user", user);
RequestDispatcher requestDispatcher = request.getRequestDispatcher("login_success.jsp");
requestDispatcher.forward(request, response);
}else{
//response.sendRedirect("index.jsp");
RequestDispatcher requestDispatcher = request.getRequestDispatcher("login_fail.jsp");
requestDispatcher.forward(request, response);
}
}
}