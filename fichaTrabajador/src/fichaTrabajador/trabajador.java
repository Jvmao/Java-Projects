package fichaTrabajador;

public class trabajador {
	//Variables Trabajador//
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
	
	//Habilitamos al Trabajador//
	public  trabajador(){
		
	}
	
	//Getters and Setters//
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public String toString() {
		return "Data nombre:" + this.nombre + ", apellido:" + this.apellido +",dni:"+ this.dni +
				", edad:" + this.edad + ", telefono:" + this.telefono+ "localidad:"+ this.localidad+ 
				", direccion:" + this.direccion + ", cp:" + this.cp +"email= "+this.email + ", id:" + this.codigo + "";
	}
	
	
	
	

}
