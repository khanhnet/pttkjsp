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
import model.Slot;

public class SlotDAO {
	   private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "";

	    private static final String SELECT_Slot_Null = "SELECT * FROM tblslot WHERE ma NOT IN (SELECT maslot FROM tbllichdat WHERE thoigianbatdau < ? and thoigianketthuc > ? )";

	    private static final String SELECT_Slot_BY_Ten = "select * from tblslot where ten=?";
	    
	    public SlotDAO() {}

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
	    
	    public List < Slot > timSlotTrong(String time) {
	    	// using try-with-resources to avoid closing resources (boiler plate code)
	        List < Slot > khachhangs = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Slot_Null);) {
	        	preparedStatement.setString(1, time);
	        	preparedStatement.setString(2, time);
	        	//preparedStatement.setString(1, ten);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int ma = rs.getInt("ma");
	                String ten = rs.getString("ten");
	                khachhangs.add(new Slot(ma, ten));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return khachhangs;
	    }
	    
	    public Slot chonSlot(String ten) {
	    	Slot slot = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Slot_BY_Ten);) {
	            preparedStatement.setString(1, ten);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int ma = rs.getInt("ma");
	                slot =new Slot(ma, ten);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return slot;
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
