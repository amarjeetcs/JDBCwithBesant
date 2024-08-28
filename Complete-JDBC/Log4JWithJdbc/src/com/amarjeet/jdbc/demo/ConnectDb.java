package com.amarjeet.jdbc.demo;

import java.beans.Statement;
import java.io.*;
import java.sql.*;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

class ConnectDb {
	private static Logger logger = Logger.getLogger(ConnectDb.class);
	static {
//		//created layout object
//		//SimpleLayout layout=new SimpleLayout();
//		
//		//html appender object
//		HTMLLayout layout=new HTMLLayout();
//		
//		FileAppender appender = null;
//		try {
//			//passing html layout object to file appender 
//			//here true means it will not override the data it will append next to the data so it is true
//			appender = new FileAppender(layout,"log.html",true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//created appender object having layout object
//		//ConsoleAppender appender=new ConsoleAppender(layout);
//		
//		//add appender object to logger object
//		logger.addAppender(appender);
//		
//		//logger level to retrive log message
//		logger.setLevel(Level.DEBUG);//default would be debug

		try {

			PropertyConfigurator.configure("src/com/amarjeet/jdbc/commons/log4j.properties");
			logger.info("com.amarjeet.jdbc.demo::log4j setup is ready");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("com.amarjeet.jdbc.demo::proble while setting up log4j");
		}

	}

	public static void main(String[] args) {
		try {
			logger.debug("com.amarjeet.jdbc.demo::starting of main method");

			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.debug("com.amarjeet.jdbc.demo::jdbc driver class loaded");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			logger.debug("com.amarjeet.jdbc.demo::connection created..");
			

			java.sql.Statement st = con.createStatement();
			//int table=st.executeUpdate("create table employee(id int , name varchar(30),city varchar(30),company varchar(35))");
			//logger.debug("com.amarjeet.jdbc.demo::table created in database with empty: "+table);
			
			int insert=st.executeUpdate("insert into employee values(1,'Hira','Bihar','Aimdek')");
			logger.debug("com.amarjeet.jdbc.demo::one record got inserted into employee table "+ insert);
			
			
			
			ResultSet rs = st.executeQuery("select *from student");
			logger.debug("com.amarjeet.jdbc.demo::selecting student data");
			while (rs.next()) {
				System.out.println(
						rs.getInt("id")+" - "+rs.getString("name")+" - "+rs.getString("city") +" - "+rs.getString("company"));

			}
			logger.debug("com.amarjeet.jdbc.demo::student data featched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("com.amarjeet.jdbc.demo::could not connect");
		}

	}
}
