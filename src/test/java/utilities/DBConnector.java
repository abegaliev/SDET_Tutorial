package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConnector {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;

	/**
	 * Connects to Database, Uses information in configuration.properties file to
	 * get database url, username, password and database type
	 * 
	 * @return Connection instance
	 */
	public static Connection establishConnection() throws SQLException {

		try {
			switch (Configuration.getProperty("database.type")) {
				case "oracle":
					String oracleDbURL = Configuration.getProperty("oracledb.url");
					String oracleDbUsername = Configuration.getProperty("oracledb.username");
					String oracleDbPassword = Configuration.getProperty("oracledb.password");

					connection = DriverManager.getConnection(oracleDbURL, oracleDbUsername, oracleDbPassword);
					statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

					break;
				case "mysql":

				default:
					connection = null;
			}
		} catch (SQLException e) {
			System.out.println("Error accured during SQL connection, Check properties file");
			e.printStackTrace();
		}

		return connection;
	}

	/**
	 * Returns count of displayed rows of data
	 * 
	 * @param sqlQuery
	 * @return rows
	 */
	public static int getRowCount(String sqlQuery) {
		try {
			resultSet = statement.executeQuery(sqlQuery);
			resultSet.last();
			return resultSet.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Accepts SQL Query and Returns data from database in List<Map> format Where
	 * each row is a element of Maps in List
	 * 
	 * @param sqlQuery
	 * @return
	 */
	public static List<Map<String, Object>> runSQLQuery(String sqlQuery) {
		try {
			resultSet = statement.executeQuery(sqlQuery);
			ResultSetMetaData rsMetaData = resultSet.getMetaData();

			List<Map<String, Object>> queryDataList = new ArrayList<>();
			int columnCount = rsMetaData.getColumnCount();

			while (resultSet.next()) {
				Map<String, Object> row = new HashMap<>();

				for (int column = 1; column <= columnCount; column++) {
					row.put(rsMetaData.getColumnName(column), resultSet.getObject(column));
				}
				queryDataList.add(row);
			}

			resultSet.close();
			return queryDataList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Closes the connection to database
	 */
	public static void closeConnections() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
