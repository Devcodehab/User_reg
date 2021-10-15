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
import com.user_app_demo_1.models.User;

@WebServlet("/userRegistrationController")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userRegistration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("emailid") != null) {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String emailid = request.getParameter("emailid");
			String city = request.getParameter("City");
			String country = request.getParameter("country");
			DatabaseConnection db = new DatabaseConnection();
			Connection con = db.establishConnection();
			User user = new User();
			user.addRegistration(firstname, lastname, emailid, city, country, con);
			request.setAttribute("msg", "Data saved");

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userRegistration.jsp");
			rd.include(request, response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
