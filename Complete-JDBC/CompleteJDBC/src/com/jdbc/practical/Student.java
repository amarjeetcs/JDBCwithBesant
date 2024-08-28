package com.jdbc.practical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {
	void crateTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/completejdbc";
			String username = "root";
			String password = "root";

			// String createTable="create table student(id int, name varchar(30),age int,
			// city varchar(30), college varchar(30))";
			// String query="create database CompleteJdbc"; //writing query and passing it
			// to execute()

			// To create connection use below code
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("connection created");

			// To create statement object use below code
			Statement st = con.createStatement();

			// To create database use below code
			// boolean db=st.execute(query); //creating database
			// System.out.println("Database created: "+db);
			// System.out.println("Connection created: "+con);

			// To create table use below code
			// boolean table=st.execute(createTable);
			// System.out.println("table created"+table);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void insertSingleRecordInTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/completejdbc";
			String username = "root";
			String password = "root";
			
			String insertData="insert into student values(103,'Rajesh',26,'Bangalore','Ies college Bhopal')";
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			int data=st.executeUpdate(insertData);
			System.out.println("Data inserted successfully: "+data);
			//System.out.println("Connection created: " + con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updataSingleRecordInTable() {
		try {
			String url="jdbc:mysql://localhost:3306/completejdbc";
			String username="root";
			String password="root";
			
			String updateRecord1="update student set name='Amarjeet Singh' where id=102";
			String updateRecord2="update student set name='Amarjeet Singh' where id=103";
			
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			int update1=st.executeUpdate(updateRecord1);
			int update2=st.executeUpdate(updateRecord2);
			System.out.println("Record updated "+update1);
			System.out.println("Record updated "+update2);

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSingleRecordInTable() {
		try {
			String url="jdbc:mysql://localhost:3306/completejdbc";
			String username="root";
			String password="root";
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			int delete=st.executeUpdate("delete from student where id=101");
			System.out.println("One table got deleted "+delete);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void FetchRecordFromTable() {
		try {
			String url="jdbc:mysql://localhost:3306/completejdbc";
			String username="root";
			String password="root";
			
			
			Connection con = DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select *from student");
			while(rs.next())
			{
				System.out.println("Id: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Age: "+rs.getInt(3));
				System.out.println("City: "+rs.getString(4));
				System.out.println("College: "+rs.getString(5));
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	}
		
	
	

