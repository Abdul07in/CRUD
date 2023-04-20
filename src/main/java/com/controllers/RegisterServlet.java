package com.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;
import com.pojo.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private String userAddress;
	private Long userPhoneNumber;
	private String userEmail;
	private String userPassword;

	List<User> ulist = null;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String process = request.getParameter("process");
		HttpSession session = request.getSession();

		if (process.equals("showUser")) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager
						.getConnection("jdbc:mysql://148.72.215.41/testuser_abdul?user=testuser&password=testuser");
				String query = "SELECT `userId`, `userName`, `userAddress`, `userPhoneNumber`, `userEmail`, `userPassword` FROM `crud` WHERE 1";
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				ulist = new ArrayList<>();
				while (rs.next()) {
					ulist.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
							rs.getString(6)));
				}
				session.setAttribute("ulist", ulist);
				response.sendRedirect("operations.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if(process.equals("updateUser")) {
			Integer userId = Integer.parseInt(request.getParameter("userId"));
			User user = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager
						.getConnection("jdbc:mysql://148.72.215.41/testuser_abdul?user=testuser&password=testuser");
				String query = "SELECT `userId`, `userName`, `userAddress`, `userPhoneNumber`, `userEmail`, `userPassword` FROM `crud` WHERE `userId` = ?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, userId);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
							rs.getString(6));
				}
				session.setAttribute("user", user);
				response.sendRedirect("updatePage.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(process.equals("deleteUser")) {
			Integer userId = Integer.parseInt(request.getParameter("userId"));
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager
						.getConnection("jdbc:mysql://148.72.215.41/testuser_abdul?user=testuser&password=testuser");
				String query = "DELETE FROM `crud` WHERE `userId` = ?;";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, userId);
				
				if(pst.executeUpdate() > 0) {
					response.sendRedirect("index.jsp?message=User Deleted Successfully");
				}else {
					response.sendRedirect("index.jsp?message=Error While Deleting User.");
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String process = request.getParameter("process");
		
		if(process.equals("registerForm")) {
			userName = request.getParameter("userName");
			userAddress = request.getParameter("userAddress");
			userPhoneNumber = Long.parseLong(request.getParameter("userPhoneNumber"));
			userEmail = request.getParameter("userEmail");
			userPassword = request.getParameter("userPassword");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection( "jdbc:mysql://148.72.215.41/testuser_abdul?user=testuser&password=testuser");
				String query = "INSERT INTO `crud`(`userName`, `userAddress`, `userPhoneNumber`, `userEmail`, `userPassword`) VALUES (?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, userName);
				pst.setString(2, userAddress);
				pst.setLong(3, userPhoneNumber);
				pst.setString(4, userEmail);
				pst.setString(5, userPassword);
				
				if(pst.executeUpdate() > 0) {
					response.sendRedirect("index.jsp?message=User Added Successfully");
				}else {
					response.sendRedirect("index.jsp?message=Error While Adding User.");
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}else if(process.equals("updateForm")){
			userId = Integer.parseInt(request.getParameter("userId"));
			userName = request.getParameter("userName");
			userAddress = request.getParameter("userAddress");
			userPhoneNumber = Long.parseLong(request.getParameter("userPhoneNumber"));
			userEmail = request.getParameter("userEmail");
			userPassword = request.getParameter("userPassword");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection( "jdbc:mysql://148.72.215.41/testuser_abdul?user=testuser&password=testuser");
				String query = "UPDATE `crud` SET `userName`=?,`userAddress`=?,`userPhoneNumber`=?,`userEmail`=?,`userPassword`=? WHERE `userId` = ?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, userName);
				pst.setString(2, userAddress);
				pst.setLong(3, userPhoneNumber);
				pst.setString(4, userEmail);
				pst.setString(5, userPassword);
				pst.setInt(6, userId);
				
				if(pst.executeUpdate() > 0) {
					response.sendRedirect("index.jsp?message=User Updated Successfully");
				}else {
					response.sendRedirect("index.jsp?message=Error While Updating User.");
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	
		
	}

}
