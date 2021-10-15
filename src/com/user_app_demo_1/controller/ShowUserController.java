package com.user_app_demo_1.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user_app_demo_1.models.DatabaseConnection;
import com.user_app_demo_1.models.User;

@WebServlet("/showReg")
public class ShowUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("emailid") != null) {
			try {
				DatabaseConnection db = new DatabaseConnection();

				Connection con = db.establishConnection();
				User user = new User();
				ResultSet results = user.showRegistration(con);
				request.setAttribute("results", results);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showReg.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
