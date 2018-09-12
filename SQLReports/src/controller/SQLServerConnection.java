package controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
	private static Connection conn = null;
	public static SQLServerConnection SQLConn = null;
	private String server = "jdbc:sqlserver://JOSEVICENTE1;databaseName=SQLReport";
	private String user = "sa";
    private String pass = "-a123456";
	
    public boolean SQLServerDB() {
		
		try {
	        conn = DriverManager.getConnection(server, user, pass);
	        System.out.println("Connecting...");
	        if (conn != null) {
	            DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	            System.out.println("Driver name: " + dm.getDriverName());
	            System.out.println("Driver version: " + dm.getDriverVersion());
	            System.out.println("Product name: " + dm.getDatabaseProductName());
	            System.out.println("Product version: " + dm.getDatabaseProductVersion());
	        }
		}catch (SQLException exSQL){
			exSQL.printStackTrace();
		}finally {
			try {
                if (conn != null && !conn.isClosed()) {
                    //conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
		}
		return false;
	}
	
	public static Connection getConnection() {
		if(conn==null) {
			SQLConn = new SQLServerConnection();
		}return conn;
	}


	//public static void main(String[] args) throws SQLException {}	

}
