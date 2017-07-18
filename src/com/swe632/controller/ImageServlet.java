package com.swe632.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet 
{
    String connectionString = "jdbc:mysql://swe632db.cvpz4fxb3biq.us-west-2.rds.amazonaws.com:3306/SWE632DB";
	String userName = "SWE632Project";
	String password = "SWE632Project";
	
	
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
	
	
	/* @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String imageID = request.getPathInfo().substring(1); // Returns "foo.png".
        Connection conn = null;
        ResultSet rs = null;
    	String findImageQuery = "SELECT image FROM Listing WHERE listingID = '"+imageID+"'";
        try 
        {
        	conn = createDbConnection(connectionString, userName, password);
        	PreparedStatement statement = conn.prepareStatement(SQL_FIND));
        	//conn = getdataservices.getImages(connectionString, userName, password);
        	PreparedStatement statement = connection.prepareStatement(SQL_FIND)
            statement.setString(1, imageName);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    byte[] content = resultSet.getBytes("content");
                    response.setContentType(getServletContext().getMimeType(imageName));
                    response.setContentLength(content.length);
                    response.getOutputStream().write(content);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Something failed at SQL/DB level.", e);
        }
    }*/

}