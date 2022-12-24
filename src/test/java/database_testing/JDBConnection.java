package database_testing;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import utilities.DBConnector;

public class JDBConnection {

	String oracleDbUrl = "jdbc:oracle:thin:@ec2-52-70-143-199.compute-1.amazonaws.com:1521:xe";
	String oracleDbUsername = "hr";
	String oracleDbPassword = "hr";

	@Test(enabled = false)
	public void oracleJDBC() throws SQLException {
		Connection connection = DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);
		// Statement statement=connection.createStatement();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery("select * from countries");

//	  while(resultSet.next()) {
//		  System.out.println(resultSet.getString(1)+"-"+resultSet.getString("country_name")+"-"+resultSet.getInt("region_id"));	  	
//	  }
		// find out how many records in the resultset
		resultSet.last();
		int rowsCount = resultSet.getRow();
		System.out.println("Number of rows:" + rowsCount);

		resultSet.first();
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "-" + resultSet.getString("country_name") + "-" + resultSet.getInt("region_id"));
		}

		resultSet.close();
		statement.close();
		connection.close();
	}

	@Test(enabled = false)
	public void jdbcMetadata() throws Exception {
		Connection connection = DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);
		// Statement statement=connection.createStatement();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		String sql = "select employee_id,last_name,job_id, salary from employees";

		// String sql = "select * from employees";
		ResultSet resultSet = statement.executeQuery(sql);

		// Database metadata
		DatabaseMetaData dbMetadata = connection.getMetaData();
		System.out.println("User:" + dbMetadata.getUserName());
		System.out.println("Database type:" + dbMetadata.getDatabaseProductName());

		// resultSet metadata
		ResultSetMetaData rsMedata = resultSet.getMetaData();
		System.out.println("Columns count:" + rsMedata.getColumnCount());
		System.out.println(rsMedata.getColumnName(1));

		// print all column names using a loop
		for (int i = 1; i <= rsMedata.getColumnCount(); i++) {
			System.out.println(i + " -> " + rsMedata.getColumnName(i));
		}

		// Throw resultset into a List of Maps
		// Create a List of Maps
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ResultSetMetaData rsMdata = resultSet.getMetaData();

		int colCount = rsMdata.getColumnCount();

		while (resultSet.next()) {
			Map<String, Object> rowMap = new HashMap<String, Object>();

			for (int col = 1; col <= colCount; col++) {
				rowMap.put(rsMdata.getColumnName(col), resultSet.getObject(col));
			}

			list.add(rowMap);
		}

		// print all emloyee ids from a list of maps

		for (Map<String, Object> emp : list) {
			System.out.println(emp.get("EMPLOYEE_ID"));
		}

		resultSet.close();
		statement.close();
		connection.close();
	}


	@Test(enabled = true)
	public void jdbConnection() throws Exception {

		Connection connection = DBConnector.establishConnection();
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery("select * from usr_info");

		// Database metadata
		DatabaseMetaData dbMetadata = connection.getMetaData();
		System.out.println("User: " + dbMetadata.getUserName());
		System.out.println("Database type: " + dbMetadata.getDatabaseProductName());

		// resultSet metadata
		ResultSetMetaData rsMetData = resultSet.getMetaData();

		System.out.println("Columns count: " + rsMetData.getColumnCount());
		System.out.println("Column name: " + rsMetData.getColumnName(4));
		System.out.println("Row count: " + DBConnector.getRowCount("Select * from usr_info"));

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		int colCount = rsMetData.getColumnCount();

		while (resultSet.next()) {
			Map<String, Object> rowMap = new HashMap<String, Object>();

			for (int col = 1; col <= colCount; col++) {
				rowMap.put(rsMetData.getColumnName(col), resultSet.getObject(col));
			}

			list.add(rowMap);
		}

		// print all emloyee ids from a list of maps

		for (Map<String, Object> emp : list) {
			System.out.println(emp.get("last_name"));
		}

		System.out.println(list.get(2).get("last_name"));

		resultSet.close();
		statement.close();
		connection.close();
	}

}