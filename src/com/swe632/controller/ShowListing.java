package com.swe632.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.swe632.beans.ListBeans;
import com.swe632.services.GetDataService;

/**
 * Servlet implementation class ShowListing
 */
//@WebServlet("/ShowListing")
public class ShowListing extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	String connectionString = "jdbc:mysql://swe632db.cvpz4fxb3biq.us-west-2.rds.amazonaws.com:3306/SWE632DB";
	String userName = "SWE632Project";
	String password = "SWE632Project";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowListing() {
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
		
		
		GetDataService getdataservices = new GetDataService();
		RequestDispatcher request_Dispatcher;
		ResultSet rs = null;
		List<HashMap<String, String>> list = new ArrayList<>();
		List<HashMap<String, String>> searchList = new ArrayList<>();
		
		String hiddenValue = request.getParameter("selectvalue");
		System.out.println("------Hidden Value is------"+hiddenValue);
		String address = "showlistings.jsp";
		
		System.out.println("----------Inside getListings doGet---------------");
		
		if(hiddenValue == null || hiddenValue == "")
		{
			list = getdataservices.getListings(connectionString, userName, password);
			request.setAttribute("showListings", list);
			System.out.println("-----list in doGet is-----"+list);
			
			ArrayList<String> cityList = getdataservices.populateCityDropDown(connectionString, userName, password);
			System.out.println("-----CityList in doGet is-----"+cityList);
			request.setAttribute("cityList", cityList);
		}
		else
		{
			ArrayList<String> cityList = getdataservices.populateCityDropDown(connectionString, userName, password);
			System.out.println("-----CityList in doGet is-----"+cityList);
			list = getdataservices.getListingsOnSearch(connectionString, userName, password, hiddenValue);
			request.setAttribute("cityList", cityList);
			request.setAttribute("showListings", list);
			request.setAttribute("hiddenvalue", hiddenValue);
		}
		
		
		request_Dispatcher = request.getRequestDispatcher(address);
		request_Dispatcher.forward(request, response);

		/*String id = request.getParameter("slisting1");
		System.out.println("-----id is-----"+id);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("----------Inside getListings doPost---------------");
		
	}

}
