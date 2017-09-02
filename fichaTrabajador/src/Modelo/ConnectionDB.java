package Modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionDB {
	
	//Datos Conexión//
	static final String CONTROLADOR_MYSQL = "com.mysql.jdbc.Driver";
	
	//Datos BBDD//
	private String host; //host de la BBDD//
	private String bbdd; //nombre de la BBDD//
	private String user; //nombre usuario//
	private String pass; //password de usuario//
	private String url; //proporcionará el método DriverManager//
	
	//Conexión//
	private static Connection conexion = null; //maneja la conexión//
	private static ConnectionDB INSTANCE = null; //Instancia de la Conexión//
	
	//Constructor (le pasamos los datos)
	public boolean ConexionDB (){
		host="localhost";
		bbdd="miempresa";
		user="root";
		pass="Naizuore1x";
		url="jdbc:mysql://"+this.host+"/"+this.bbdd;
		
		//Conexión
		try{
			//Cargar el controlador MYSQL para poder conectar con la BBDD
			Class.forName(CONTROLADOR_MYSQL);
			
			//Conectar a la BBDD
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://"+this.host+"/"
			+this.bbdd, this.user, this.pass);
			if(conexion != null){
				System.out.println("Conexion OK con "+this.user);
			}
			
			}catch( SQLException exSQL ){ 
				exSQL.printStackTrace();
			}catch( ClassNotFoundException error){ 
				error.printStackTrace();
			}
			return false;
		}

		//Devuelve una instancia de la Conexión//
		public static Connection getConexion(){
			if(conexion==null){
				INSTANCE = new ConnectionDB();
			}		
			return conexion;
		}	
}
