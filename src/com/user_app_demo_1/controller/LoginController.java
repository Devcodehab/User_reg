package com.user_app_demo_1.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user_app_demo_1.models.DatabaseConnection;
import com.user_app_demo_1.models.Login;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		Login login = new Login();
		DatabaseConnection dbconnection = new DatabaseConnection();
		Connection con = dbconnection.establishConnection();
		boolean result = login.verifyLogin(emailid, password, con);
		HttpSession session = request.getSession(true);
		if (result == true) {
			session.setAttribute("emailid", emailid);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userRegistration.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("errormsg", "Invalid Username/Password");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);

		}

	}

}
