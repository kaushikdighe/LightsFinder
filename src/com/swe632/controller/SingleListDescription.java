package com.swe632.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swe632.services.GetDataService;

/**
 * Servlet implementation class SingleListDescription
 */
//@WebServlet(asyncSupported = true, urlPatterns = { "/SingleListDescription" })
public class SingleListDescription extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	String connectionString = "jdbc:mysql://swe632db.cvpz4fxb3biq.us-west-2.rds.amazonaws.com:3306/SWE632DB";
	String userName = "SWE632Project";
	String password = "SWE632Project";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleListDescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		GetDataService getdataservice = new GetDataService();
		HashMap<String, String> hmap = new HashMap<>();
		RequestDispatcher request_Dispatcher;
		System.out.println("------------ Inside SingleListDescription doGet -----------------");
		
		String address = "singlelisting.jsp";
		String id = request.getParameter("id");
		System.out.println("id is--------->"+id);
		
		hmap = getdataservice.getSingleListing(connectionString, userName, password, id);
		System.out.println("hmap in doGet----->"+hmap.toString());
		request.setAttribute("singlelist", hmap);
		
		request_Dispatcher = request.getRequestDispatcher(address);
		request_Dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
