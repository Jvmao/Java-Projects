package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDB {	
	//Connection DB//
	private static Connection conn = null;
	//Object
	private  Statement order,order2,order3,order4 = null;
	private int id;
	private String queryAddUser,queryAddProduct,queryAddInvoice,queryDeleteProduct;
	
	//Get Connection//
	public  ClientDB(Connection c){
		this.conn=c; 
	}
	
	//Method to Insert User in DB
	public void insertUser(String name,String lastname,String country,String city,int tel,String mail,String idCode) {
		try {
			id = 0;
			order = conn.createStatement();
			queryAddUser = "INSERT INTO client (name_client,lastname_client,country_client,city_client,tel_client,email_client,id_code)"
					+ " VALUES('" + name + "','" + lastname + "','" + country + "','" + city + "','" + tel + "','"
					+ mail + "','"+idCode+"')";
			//order.executeQuery(queryAddUser);
			PreparedStatement pstm = conn.prepareStatement(queryAddUser);
			pstm.executeUpdate();
			System.out.println("User Registered --> "+queryAddUser);
		} catch (Exception e) {
			System.out.println("Fail to Register User --> "+queryAddUser);
			e.printStackTrace();
		}
	}
	
	//Method to Insert Selected Product to DB
	public void insertProduct(String productName,int productPrice,String idCode) {
		try {
			order2 = conn.createStatement();
			queryAddProduct = "INSERT INTO user_product (nameUser_product,priceUser_product,id_code) "
					+ "VALUES ('"+productName+"','"+productPrice+"','"+idCode+"')"; 
			PreparedStatement pst = conn.prepareStatement(queryAddProduct);
			pst.executeUpdate();
			System.out.println("User Product Registered --> "+queryAddProduct);
		} catch (SQLException e) {
			System.out.println("Fail to Register User Product --> "+queryAddProduct);
			e.printStackTrace();
		}
		
	}
	
	//Method to DELETE Selected Product in DB
	public void deleteProduct(int id,String name,int price,String idCode) {
		try {
			order3 = conn.createStatement();
			queryDeleteProduct = "DELETE FROM user_product WHERE idUser_product = '"+id+"' AND nameUser_product = '"+name+"' "
					+ "AND priceUser_product = '"+price+"' AND id_code = '"+idCode+"'";
			PreparedStatement ps = conn.prepareStatement(queryDeleteProduct);
			//We can use this below to add the statements outside of that query and replace them for ?
			//ps.setInt(1, id);
			//ps.setString(2, name);
			//ps.setInt(3, price);
			//ps.setString(4, idCode);
			ps.executeUpdate();
			System.out.println("Deleted Item Correctly!!!"+" ID: "+id+" NAME: "+name+" PRICE: "+price+" CODE: "+idCode);
		} catch (SQLException e) {
			System.out.println("ERROR DELETING ROW FROM SQL");
			e.printStackTrace();
		}
	}
	
	
	//Method to Insert Invoice in DB
	public void insertInvoice(int amount,double vat,double total,String idCode) {
		try {
			id=0;
			queryAddInvoice = "INSERT INTO invoice(amount,vat,total,id_code) VALUES('"+amount+"','"+vat+"','"+total+"','"+idCode+"')";
			order4 = conn.createStatement();
			PreparedStatement pstm = conn.prepareStatement(queryAddInvoice);
			pstm.executeUpdate();
			if(pstm != null) {
				System.out.println("INVOICE --> "+queryAddInvoice);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Creating INVOICE");
		}
	}

}
