package com.jdbc.practical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		Student s = new Student();
		s.crateTable();
		// s.insertSingleRecordInTable();
		// s.updataSingleRecordInTable();
		// s.deleteSingleRecordInTable();
		// s.FetchRecordFromTable();

	}
}