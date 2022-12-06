package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dichvu;
import model.Khachhang;

public class DichvuDAO {
	   private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "";

	    private static final String SELECT_ALL_Dichvu = "select * from tbldichvu";
	    private static final String SELECT_dichvu_BY_ID = "select * from tbldichvu where ma =?";

	    public DichvuDAO() {}

	    protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    public List < Dichvu > getdichvu() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Dichvu > dichvus = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Dichvu);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int ma = rs.getInt("ma");
	                String ten = rs.getString("ten");
	                Integer gia = rs.getInt("gia");
	                Integer thoigiandukien = rs.getInt("thoigiandukien");
	                dichvus.add(new Dichvu(ma, ten, gia, thoigiandukien));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return dichvus;
	    }
	    
	    public Dichvu chonDichvu(int ma) {
	    	Dichvu dichvu = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_dichvu_BY_ID);) {
	            preparedStatement.setInt(1, ma);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	//int ma = rs.getInt("ma");
	                String ten = rs.getString("ten");
	                int gia = rs.getInt("gia");
	                int thoigiandukien = rs.getInt("thoigiandukien");
	                dichvu =new Dichvu(ma, ten, gia, thoigiandukien);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return dichvu;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
}
