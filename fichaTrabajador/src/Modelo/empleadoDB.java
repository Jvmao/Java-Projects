package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import fichaTrabajador.trabajador;

public class empleadoDB {
	//Nuevo Jugador//
	private trabajador t1;
	private empleadoDB edb;
	
	//Variables Jugadores//
	private String nombre;
	private String apellido;
	private String dni;
	private int edad;
	private int telefono;
	private String localidad;
	private String direccion;
	private int cp;
	private String email;
	private String codigo;
	private int id;
	
	//Conexión a la BBDD//
	private  static Connection conexion = null;
	//Objeto para Ejecutar la orden//
	private  Statement orden = null;
	
	//Para Recibir la Conexión//
	public  empleadoDB(Connection c){
		this.conexion=c; 
	}
	
	//Método que Permite insertar un nuevo jugador en la BBDD//
	//La BBDD se llama miempresa y la tabla correspondiente nuevo_empleado//
	public void insertarEmpleado(String nombre,String apellido,String dni,int edad,
			int telefono,String localidad,String direccion,int cp,String email,String codigo){
		int id=0; //inicializamos el id del jugador//
		try{
		orden = (Statement) conexion.createStatement();
		//Creamos la Tabla SQL para introducir los Datos del Trabjador en la BBDD//
		String sql = "INSERT INTO nuevo_empleado (Nombre,Apellido,DNI,"
				+ "Edad,Telefono,Localidad,Direccion,CP,E_mail,Codigo)" +
		"VALUES ('"+nombre+"','"+apellido+"','"+dni+"','"+edad+"','"+telefono+"','"+localidad+
		"','"+direccion+"','"+cp+"','"+email+"','"+codigo+"')";
		
		orden.executeUpdate(sql);//Se ejecuta la consulta//
		System.out.println("Usuario Registrado en BBDD");
		
	    //conexion.close();//Cerramos la conexión//
		//System.out.println("Conexión Cerrada");
		}catch (SQLException se){
			se.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//Método para Buscar los Datos del Trabajador//
	public void buscarTrabajador(String buscarNombre, JComboBox jc){
		//Variable para almacenar el resultado del a consulta SQL
		ResultSet rs;
		
		try{
			orden = (Statement) conexion.createStatement();
			String comandoSQL = "SELECT id, Nombre, Apellido, DNI, Edad, Telefono, "
					+ "Localidad, Direccion, CP, E_Mail, Codigo FROM nuevo_empleado WHERE Nombre='"+buscarNombre+"'";
			
			rs = orden.executeQuery(comandoSQL);
			
			//Recorremos los Resultados//
			while(rs.next()){
				//Añadimos las filas obtenidas en Objetos//
				trabajador t1 = new trabajador();
				t1.setId(rs.getInt("id"));
				t1.setNombre(rs.getString("nombre"));
				t1.setApellido(rs.getString("apellido"));
				t1.setDni(rs.getString("dni"));
				t1.setEdad(rs.getInt("edad"));
				t1.setTelefono(rs.getInt("telefono"));
				t1.setLocalidad(rs.getString("localidad"));
				t1.setDireccion(rs.getString("direccion"));
				t1.setCp(rs.getInt("cp"));
				t1.setEmail(rs.getString("E_Mail"));
				t1.setCodigo(rs.getString("codigo"));
				
				
				jc.addItem(t1);
			}
			rs.close(); //Cerramos la Conexión
		}catch (SQLException e){
			e.printStackTrace();
		}catch (Exception evt){
			evt.printStackTrace();
		}
	}
	
	//Método para Actualizar Datos//
			public void actualizarTrabajador(Connection c,trabajador t1){
				try{
					orden = (Statement) conexion.createStatement();
					//Insertamos los Campos a Actualizar//
					String sql = "UPDATE nuevo_empleado "+
								"SET nombre = ?"+
								",apellido = ?"+
								",dni = ?"+
								",edad = ?"+
								",telefono = ?"+
								",localidad = ?"+
								",direccion = ?"+
								",cp = ?"+
								",e_mail =?"+
								" WHERE id = "+t1.getId();
					
					PreparedStatement preparedStmt = conexion.prepareStatement(sql);
					preparedStmt.setString(1, t1.getNombre());
					preparedStmt.setString(2, t1.getApellido());
					preparedStmt.setString(3, t1.getDni());
					preparedStmt.setInt(4, t1.getEdad());
					preparedStmt.setInt(5, t1.getTelefono());
					preparedStmt.setString(6, t1.getLocalidad());
					preparedStmt.setString(7, t1.getDireccion());
					preparedStmt.setInt(8, t1.getCp());
					preparedStmt.setString(9, t1.getEmail());
					
					//Ejecución de la Consulta
					preparedStmt.executeUpdate();
					System.out.println(sql);
								
				}catch(Exception se){
					//Error con la consulta
					se.printStackTrace();
				}
			}
}
