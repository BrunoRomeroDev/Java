package application;

import java.sql.Connection;

import db.db;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = db.getConnection();
		db.closeConnection();

	}

}
