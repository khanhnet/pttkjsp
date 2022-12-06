package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dichvu;
import model.Dichvudat;
import model.Hoadonxuat;
import model.Khachhang;
import model.Lichdat;

public class LichdatDAO {
	   private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	    private String jdbcUsername = "root";
	    private String jdbcPassword = "";

	    private static final String INSERT_lichdat_SQL = "INSERT INTO tbllichdat" + "  (maslot, makhachhang,thoigianbatdau,thoigianketthuc, manhanvien) VALUES " +
		        " (?, ?, ?,?,?);";
	    private static final String INSERT_dichvudat_SQL = "INSERT INTO tbldichvudat" + "  (malichdat, madichvu,gia) VALUES " +
		        " (?, ?, ?);";
	    
	    private static final String INSERT_hoadonxuat_SQL = "INSERT INTO tblhoadonxuat" + "  (malichdat, trangthai) VALUES " +
		        " (?, ?);";
	    
	    private static final String SELECT_lichdat = "select * from tbllichdat where maslot =? AND thoigianbatdau=?";

	    public LichdatDAO() {}

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
	    
	    public Lichdat chonLichdat(int maslot,String thoigianbatdau) {
	    	Lichdat lichdat = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_lichdat);) {
	            preparedStatement.setInt(1, maslot);
	            preparedStatement.setString(2, thoigianbatdau);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int ma = rs.getInt("ma");
	            	int makhachhang = rs.getInt("makhachhang");
	            	int manhanvien = rs.getInt("manhanvien");
	            	String thoigianketthuc = rs.getString("thoigianketthuc");
	                lichdat =new Lichdat(ma,makhachhang,manhanvien, maslot, thoigianbatdau, thoigianketthuc);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return lichdat;
	    }

	    public void themlichdat(Lichdat lichdat) throws SQLException {
	        System.out.println(INSERT_lichdat_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_lichdat_SQL)) {
	            preparedStatement.setInt(1, lichdat.getMaslot());
	            preparedStatement.setInt(2, lichdat.getMakhachhang());
	            preparedStatement.setString(3, lichdat.getThoigianbatdau());
	            preparedStatement.setString(4, lichdat.getThoigianketthuc());
	            preparedStatement.setInt(5, lichdat.getManhanvien());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }
	    
	    public void themdichvudat(Dichvudat dichvudat) throws SQLException {
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_dichvudat_SQL)) {
	            preparedStatement.setInt(1, dichvudat.getMadichvu());
	            preparedStatement.setInt(2, dichvudat.getMalichdat());
	            preparedStatement.setInt(3, dichvudat.getGia());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }
	    
	    public void themhoadon(Hoadonxuat hoadonxuat) throws SQLException {
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_hoadonxuat_SQL)) {
	            preparedStatement.setInt(1, hoadonxuat.getMalichdat());
	            preparedStatement.setInt(2, hoadonxuat.getTrangthai());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
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
