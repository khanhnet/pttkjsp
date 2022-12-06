package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Khachhang;

public class KhachhangDAO {
	   private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "";

	    private static final String INSERT_Khachhang_SQL = "INSERT INTO tblkhachhang" + "  (ten, email, sdt,diachi) VALUES " +
	        " (?, ?, ?,?);";
	    private static final String SELECT_khachhang_BY_ID = "select * from tblkhachhang where ma =?";
	    private static final String SELECT_Khachhang_BY_Ten = "select * from tblkhachhang where ten=?";
	    private static final String SELECT_ALL_Khachhang = "select * from tblkhachhang";

	    public KhachhangDAO() {}

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

	    public void themkhachhang(Khachhang kh) throws SQLException {
	        System.out.println(INSERT_Khachhang_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Khachhang_SQL)) {
	            preparedStatement.setString(1, kh.getTen());
	            preparedStatement.setString(2, kh.getEmail());
	            preparedStatement.setString(3, kh.getSdt());
	            preparedStatement.setString(4, kh.getDiachi());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }

	    public List < Khachhang > timkhachhang(String ten) {
	    	// using try-with-resources to avoid closing resources (boiler plate code)
	        List < Khachhang > khachhangs = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Khachhang_BY_Ten);) {
	        	preparedStatement.setString(1, ten);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int ma = rs.getInt("ma");
	                //String ten = rs.getString("ten");
	                String email = rs.getString("email");
	                String sdt = rs.getString("sdt");
	                String diachi = rs.getString("diachi");
	                khachhangs.add(new Khachhang(ma, ten, email, sdt,diachi));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return khachhangs;
	    }
	    
	    public Khachhang chonKhachhang(int ma) {
	    	Khachhang khachhang = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_khachhang_BY_ID);) {
	            preparedStatement.setInt(1, ma);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	//int ma = rs.getInt("ma");
	                String ten = rs.getString("ten");
	                String email = rs.getString("email");
	                String sdt = rs.getString("sdt");
	                String diachi = rs.getString("diachi");
	                khachhang =new Khachhang(ma, ten, email, sdt,diachi);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return khachhang;
	    }

	    public List < Khachhang > getkhachhang() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Khachhang > khachhangs = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Khachhang);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) { 
	                int ma = rs.getInt("ma");
	                String ten = rs.getString("ten");
	                String email = rs.getString("email");
	                String sdt = rs.getString("sdt");
	                String diachi = rs.getString("diachi");
	                khachhangs.add(new Khachhang(ma, ten, email, sdt,diachi));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return khachhangs;
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
