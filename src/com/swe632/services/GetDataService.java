package com.swe632.services;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.crypto.provider.RSACipher;
import com.swe632.beans.ListBeans;
//import com.swe642.beans.StudentBean;



public class GetDataService 
{
	/*String connectionString = "jdbc:mysql://swe632db.cvpz4fxb3biq.us-west-2.rds.amazonaws.com:3306/SWE632DB";
	String userName = "SWE632Project";
	String password = "SWE632Project";*/
	
	protected Connection createDbConnection(String connectionString, String userName, String password) 
	{
		Connection con = null;
		System.out.println("---Connection String is -------"+connectionString);
		System.out.println("------Creating RDS MySQL connection-------");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionString, userName, password);
		} 
		catch (Exception e) 
		{
			System.out.println("------Error connecting-------");
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<String> populateCityDropDown(String connectionString, String userName, String password)
	{
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		String getAllCitesQuery = "";
		ArrayList<String>  cityList = new ArrayList<String>();
		System.out.println("-----------------In populateCityDropDown function-------------------");
		
		try
		{
			conn = createDbConnection(connectionString, userName, password);
			statement = conn.createStatement();
			getAllCitesQuery = "SELECT DISTINCT(city) FROM SWE632DB.Listing order by city ASC";
			rs = statement.executeQuery(getAllCitesQuery);
			
			while(rs.next())
			{
				String cityName = rs.getString("city");
				cityList.add(cityName);
			}
			rs.close();
			System.out.println("CityList is------"+cityList);
		}
		catch(Exception e)
		{
			System.out.println("----- Error in populateCityDropDown ------");
		}
		finally 
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cityList;
	}
	
	public List<HashMap<String, String>> getListings(String connectionString, String userName, String password)
	{
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		ResultSetMetaData rset = null; 
		String getAllListQuery = "";
		List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		
		System.out.println("-----------------In getListings function-------------------");
		try
		{
			conn = createDbConnection(connectionString, userName, password);
			statement= conn.createStatement();
			getAllListQuery = "SELECT * FROM Listing";
			rs = statement.executeQuery(getAllListQuery);
			rset = rs.getMetaData();
			String columnName = "";
			String columnValue = "";
			//System.out.println(rset.getColumnCount());
			
			while(rs.next())
			{
				HashMap<String, String> map = new HashMap<String,String>();
				for(int i = 1; i<= rset.getColumnCount(); i++)
				{
					columnName = rset.getColumnName(i);
					//System.out.println("Column Name is---"+columnName.toString());
					columnValue = rs.getString(columnName);
					//System.out.println("Column Value is---"+columnValue.toString());
					map.put(columnName, columnValue);
				}
				//System.out.println("hashmap is---"+map.toString());
				list.add(map);
				System.out.println("List is-----"+list.toString());
			}
		}
		catch(Exception e)
		{
			System.out.println("---Error in getListings----");
			e.printStackTrace();
		}
		finally 
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public List<HashMap<String, String>> getListingsOnSearch(String connectionString, String userName, String password, String selectedValue)
	{
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		ResultSetMetaData rset = null; 
		String getAllListOnSearchQuery = "";
		List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		
		System.out.println("-----------------In getListings function-------------------");
		try
		{
			conn = createDbConnection(connectionString, userName, password);
			statement= conn.createStatement();
			getAllListOnSearchQuery = "SELECT * FROM SWE632DB.Listing where city like '"+selectedValue+"'";
			rs = statement.executeQuery(getAllListOnSearchQuery);
			rset = rs.getMetaData();
			String columnName = "";
			String columnValue = "";
			//System.out.println(rset.getColumnCount());
			
			while(rs.next())
			{
				HashMap<String, String> map = new HashMap<String,String>();
				for(int i = 1; i<= rset.getColumnCount(); i++)
				{
					columnName = rset.getColumnName(i);
					//System.out.println("Column Name is---"+columnName.toString());
					columnValue = rs.getString(columnName);
					//System.out.println("Column Value is---"+columnValue.toString());
					map.put(columnName, columnValue);
				}
				//System.out.println("hashmap is---"+map.toString());
				list.add(map);
				System.out.println("List is-----"+list.toString());
			}
		}
		catch(Exception e)
		{
			System.out.println("---Error in getListings----");
			e.printStackTrace();
		}
		finally 
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public HashMap<String, String> getSingleListing (String connectionString, String userName, String password, String listingID)
	{
		Connection conn = null;
		String getListingQuery = "";
		int listingID1 = Integer.parseInt(listingID) ;
		Statement statement = null;
		ResultSet rs = null;
		ResultSetMetaData rset = null;
		HashMap<String, String> map = null;
		System.out.println("-----------------In getSingleListing function-------------------");
		
		try
		{
			conn = createDbConnection(connectionString, userName, password);
			statement= conn.createStatement();
			getListingQuery = "SELECT * from SWE632DB.Listing WHERE listingID = '"+listingID1+"'";
			System.out.println("Insert Query is-----"+getListingQuery);
			rs = statement.executeQuery(getListingQuery);
			rset = rs.getMetaData();
			String columnName = "";
			String columnValue = "";
			
			while(rs.next())
			{
				map = new HashMap<String,String>();
				for(int i = 1; i<= rset.getColumnCount(); i++)
				{
					columnName = rset.getColumnName(i);
					//System.out.println("Column Name is---"+columnName.toString());
					columnValue = rs.getString(columnName);
					//System.out.println("Column Value is---"+columnValue.toString());
					map.put(columnName, columnValue);
				}
				System.out.println("hashmap is---"+map.toString());
			}
		}
		catch(Exception e)
		{
			System.out.println("----------Error in getSingleListing-------");
			e.printStackTrace();
		}
		finally 
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}
	
	
	//add new Listing screen
	public int InsertListing(String connectionString, String userName, String password, String displayName, 
								String address, String cityName, String state, String description, InputStream inputStream)
	{
		
		Connection conn = null;
		String insertintoListingsQuery = "";
		int row  = 0;
		System.out.println("-----------------In InsertStudentDetails function-------------------");
		try
		{
			conn = createDbConnection(connectionString, userName, password);
			insertintoListingsQuery = "INSERT into SWE632DB.Listing(displayName,address,city,state,description,image)"
					+ "values('"+displayName+"','"+address+"','"+cityName+"','"+state+"',"
										+ "'"+description+"','"+inputStream+"')";
			System.out.println("Insert Query is-----"+insertintoListingsQuery);
			PreparedStatement preparedStatement = conn.prepareStatement(insertintoListingsQuery);
			row = preparedStatement.executeUpdate();
			System.out.println("----value of insert in Listings table---"+row);
		}
		catch(Exception e)
		{
			System.out.println("----------Error in InsertListing-------");
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionString = "jdbc:mysql://swe632db.cvpz4fxb3biq.us-west-2.rds.amazonaws.com:3306/SWE632DB";
		String userName = "SWE632Project";
		String password = "SWE632Project";
		GetDataService gd = new GetDataService();
		//gd.getListings(connectionString, userName, password);
		//gd.getCity();
		//gd.getSingleListing(connectionString, userName, password, "3");
		gd.populateCityDropDown(connectionString, userName, password);
		gd.getListingsOnSearch(connectionString, userName, password, "ARLINGTON");
	}

}
