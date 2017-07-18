package com.swe632.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.swe632.services.GetDataService;

/**
 * Servlet implementation class ChristmasLighting
 *
 *
 */
//@WebServlet("/index.jsp")
public class ChristmasLighting extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	/*---------------Oracle Connection------------------------------
	 * String connectionString = "jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g";
	String userName = "kdighe";
	String password = "oorsij";*/
	String connectionString = "jdbc:mysql://swe632db.cvpz4fxb3biq.us-west-2.rds.amazonaws.com:3306/SWE632DB";
	String userName = "SWE632Project";
	String password = "SWE632Project";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChristmasLighting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		GetDataService getdataservices = new GetDataService();
		RequestDispatcher request_Dispatcher;
		ResultSet rs = null;
		List<HashMap<String, String>> list = new ArrayList<>();
		String address = "index.jsp";
		
		System.out.println("---------------In doGet----------------------");
		
		list = getdataservices.getListings(connectionString, userName, password);
		request.setAttribute("showListings", list);
		System.out.println("-----list in doGet is-----"+list);
		request_Dispatcher = request.getRequestDispatcher(address);
		request_Dispatcher.forward(request, response);
		
		/*HashMap<String, String> hmp = getDataService.getCity(connectionString, userName, password);
		System.out.println("HashMap in doGet-----"+hmp.toString());
		
		HttpSession session = request.getSession();
		session.setAttribute("HashMap", hmp);
		Set<String> cityName =hmp.keySet();
		String options="";
		for (Iterator iterator = cityName.iterator(); iterator.hasNext();) 
		{	
			String key = (String) iterator.next();
			String cityID = hmp.get(key);
			options+="<option value=\""+cityID+"\">"+ cityID+" ";
			System.out.println("CityID---"+cityID);
		}
		request.setAttribute("options",options);
		request.getRequestDispatcher("/index.jsp").forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
