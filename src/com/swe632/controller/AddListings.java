package com.swe632.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.swe632.services.GetDataService;

/**
 * Servlet implementation class AddListings
 */
//@WebServlet(asyncSupported = true, urlPatterns = { "/AddListings" })
@MultipartConfig(maxFileSize = 16177215)
public class AddListings extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	String connectionString = "jdbc:mysql://swe632db.cvpz4fxb3biq.us-west-2.rds.amazonaws.com:3306/SWE632DB";
	String userName = "SWE632Project";
	String password = "SWE632Project";
	
    public AddListings() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		RequestDispatcher requestDispatcher;
		InputStream inputStream = null;
		GetDataService getdataservices =  new GetDataService();
		String address = "";
		String message = "";
		System.out.println("------------ Inside AddListings Servlet doPost -----------");
		
		try
		{
			String displayName = request.getParameter("displayname");
			String addressField = request.getParameter("address");
			String city = request.getParameter("city");
			city = city.toUpperCase();
			String state = request.getParameter("state");
			state = state.toUpperCase();
			String description = request.getParameter("addcomments");
			Part filePart = request.getPart("photo");
			
			 
			if (filePart != null) 
			{
		            // prints out some information for debugging
				/*System.out.println(filePart.getName());
				System.out.println(filePart.getSubmittedFileName());
		        System.out.println(filePart.getSize());
		        System.out.println(filePart.getContentType());*/
		             
		        // obtains input stream of the upload file
		        inputStream = filePart.getInputStream();
		    }
			int row = getdataservices.InsertListing(connectionString, userName, password, displayName, addressField, city, state, description, inputStream);
			System.out.println("Row in doPost is-----"+row);
			
			if(row > 0)
			{
				message = "Your Listing is Successfully Added";
				address = "successfulinsert.jsp";
			}
		}
		catch(Exception e)
		{
			message = "There has been an issue uploading your Listing, Please try Again";
			address = "failedinsert.jsp";
			System.out.println("-----Error in AddListings doPost-----");
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		requestDispatcher = request.getRequestDispatcher(address);
		requestDispatcher.forward(request, response);
	}

}
