/*
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement;
 * 
 * public class MySQLConnectionCheck {
 * 
 * public static void main(String[] args) { Connection connection = null;
 * Statement statement = null; ResultSet resultSet = null; try { String
 * driverName = "com.mysql.cj.jdbc.Driver"; String url =
 * "jdbc:mysql://localhost:3306/training"; Class.forName(driverName); connection
 * = DriverManager.getConnection(url, "root", "root");
 * System.out.println(connection != null ? "connection established" :
 * "connection failed");
 * 
 * } catch (ClassNotFoundException cnfe) {
 * System.out.println("There is no respective jars : " + cnfe.getMessage()); }
 * catch (SQLException se) {// Catching SQL Exception
 * System.out.println("SQL Exception :" + se.getMessage()); } catch (Exception
 * e) { System.out.println(e); }
 * 
 * finally { try { connection.close(); } catch (SQLException e) {
 * e.printStackTrace(); } } } }
 */