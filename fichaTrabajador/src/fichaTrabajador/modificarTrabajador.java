package fichaTrabajador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Modelo.ConnectionDB;
import Modelo.empleadoDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class modificarTrabajador extends JFrame {
	
	//Variables JFrame//
	private JPanel contentPane;
	private JLabel JLabelTitulo;
	private JTextField JTextNombre,JTextApellido,JTextDNI, JTextEdad,
	JTextTel,JTextLocalidad,JTextDir,JTextCP,JTextEmail;
	private JButton JButtonVolver,JButtonMod,JButtonSalir;
	
	//Variable Trabajador//
	private trabajador t1;
	
	//Variables para la Conexión a la Base de Datos//
	private ConnectionDB db;
	private empleadoDB edb;
	private Connection conexion;
	private boolean connected = false;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarTrabajador frame = new modificarTrabajador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public modificarTrabajador() {
		setTitle("MODIFICACI\u00D3N DATOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Estudios\\DAM\\Programaci\u00F3n\\Im\u00E1genes Programaci\u00F3n\\robocop.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Etiqueta Título//
		JLabelTitulo = new JLabel("MODIFICAR DATOS NUEVO EMPLEADO");
		JLabelTitulo.setIcon(new ImageIcon(modificarTrabajador.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
		JLabelTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelTitulo.setBounds(10, 11, 414, 30);
		contentPane.add(JLabelTitulo);
		//Campo de Texto para Nombre//
		JTextNombre = new JTextField();
		JTextNombre.setBackground(new Color(204, 204, 255));
		JTextNombre.setBounds(10, 62, 122, 25);
		contentPane.add(JTextNombre);
		JTextNombre.setColumns(10);
		//Campo de Texto para Apellido//
		JTextApellido = new JTextField();
		JTextApellido.setBackground(new Color(204, 204, 255));
		JTextApellido.setColumns(10);
		JTextApellido.setBounds(157, 62, 122, 25);
		contentPane.add(JTextApellido);
		//Campo de Texto para DNI//
		JTextDNI = new JTextField();
		JTextDNI.setBackground(new Color(204, 204, 255));
		JTextDNI.setColumns(10);
		JTextDNI.setBounds(302, 62, 122, 25);
		contentPane.add(JTextDNI);
		//Campo de Texto para Edad//
		JTextEdad = new JTextField();
		JTextEdad.setBackground(new Color(204, 204, 255));
		JTextEdad.setColumns(10);
		JTextEdad.setBounds(10, 115, 122, 25);
		contentPane.add(JTextEdad);
		//Campo de Texto para Teléfono//
		JTextTel = new JTextField();
		JTextTel.setBackground(new Color(204, 204, 255));
		JTextTel.setColumns(10);
		JTextTel.setBounds(157, 115, 122, 25);
		contentPane.add(JTextTel);
		//Campo de Texto para Localidad//
		JTextLocalidad = new JTextField();
		JTextLocalidad.setBackground(new Color(204, 204, 255));
		JTextLocalidad.setColumns(10);
		JTextLocalidad.setBounds(302, 115, 122, 25);
		contentPane.add(JTextLocalidad);
		//Campo de Texto para Dirección//
		JTextDir = new JTextField();
		JTextDir.setBackground(new Color(204, 204, 255));
		JTextDir.setColumns(10);
		JTextDir.setBounds(10, 173, 122, 25);
		contentPane.add(JTextDir);
		//Campo de Texto para CP//
		JTextCP = new JTextField();
		JTextCP.setBackground(new Color(204, 204, 255));
		JTextCP.setColumns(10);
		JTextCP.setBounds(157, 173, 122, 25);
		contentPane.add(JTextCP);
		//Campo de Texto para Email//
		JTextEmail = new JTextField();
		JTextEmail.setBackground(new Color(204, 204, 255));
		JTextEmail.setColumns(10);
		JTextEmail.setBounds(302, 173, 122, 25);
		contentPane.add(JTextEmail);
		//Botón para Volver a la Pantalla Anterior//
		JButtonVolver = new JButton("VOLVER");
		JButtonVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		JButtonVolver.setIcon(new ImageIcon(modificarTrabajador.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		JButtonVolver.setBounds(10, 227, 122, 23);
		JButtonVolver.addActionListener(new innerAction());//Añadimos el Action Listener//
		contentPane.add(JButtonVolver);
		//Botón para Modificar los Datos en la BBDD//
		JButtonMod = new JButton("MODIFICAR");
		JButtonMod.setFont(new Font("Tahoma", Font.BOLD, 11));
		JButtonMod.setIcon(new ImageIcon(modificarTrabajador.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		JButtonMod.setBounds(157, 227, 122, 23);
		JButtonMod.addActionListener(new innerAction());//Añadimos el Action Listener//
		contentPane.add(JButtonMod);
		//Botón para Salir de la Aplicación//
		JButtonSalir = new JButton("SALIR");
		JButtonSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		JButtonSalir.setIcon(new ImageIcon(modificarTrabajador.class.getResource("/imagenes/signoption.png")));
		JButtonSalir.setBounds(302, 227, 122, 23);
		JButtonSalir.addActionListener(new innerAction());
		contentPane.add(JButtonSalir);
		
		//Método para Conectar con la BBDD//
		conectar();
		
	}
	
	//Método para Recoger los Datos del Trabajador de la Ventana de la Ficha Técnica//
	public void setTrabajador(trabajador t1){
		this.t1=t1;
		JTextNombre.setText(t1.getNombre());
		JTextApellido.setText(t1.getApellido());
		JTextDNI.setText(t1.getDni());
		JTextEdad.setText(Integer.valueOf(t1.getEdad()).toString());
		JTextTel.setText(Integer.valueOf(t1.getTelefono()).toString());
		JTextLocalidad.setText(t1.getLocalidad());
		JTextDir.setText(t1.getDireccion());
		JTextCP.setText(Integer.valueOf(t1.getCp()).toString());
		JTextEmail.setText(t1.getEmail());
		
		//Recogemos el ID de la Ventana de la Ficha del Trabajador//
		JLabelTitulo.setText("MODIFICAR DATOS NUEVO EMPLEADO: " +t1.getCodigo());
	}
	
	//Método para la Conexión//
		public void conectar(){
			//Datos Necesarios para la Conexión a la BBDD//
			db = new ConnectionDB();
			//Establecemos la Conexión//
			connected=db.ConexionDB();
			//Asignamos con el getter la conexión establecida//
			conexion=db.getConexion();
			//Pasamos la Conexión a un Nuevo Jugador//
			edb=new empleadoDB(conexion);
			//Comprobamos que la Conexión ha tenido Éxito//
			if(connected==false){
				System.out.println("Conectado a MySQL");
			}else{ 
				System.out.println("No estás Conectado");
			}
		}
	
	
	//Método para activar los Action Listener//
	public class innerAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==JButtonVolver){
				try{
				//Variables de las Ventanas//
				fichaTecnica v1 = new fichaTecnica();
				modificarTrabajador v2 = new modificarTrabajador();
				buscarTrabajador v3 = new buscarTrabajador();
				 //Abrimos la ventana de fichaTecnica//
				//v1.setFicha(t1);
				//v1.setVisible(true);
				v3.setVisible(true);
				v2.setVisible(false);
				dispose(); //Cerramos esta Ventana//
			
				}catch (Exception error){
					error.getMessage();
				}
				
			}else if(e.getSource()==JButtonSalir){
				System.exit(0);
			}else if (e.getSource()==JButtonMod){
				//Introducimos un condicional para asegurarnos que todos los campos han sido rellenados//
				if((JTextNombre.getText().length()<=0) || (JTextApellido.getText().length()<=0) 
					|| (JTextDNI.getText().length()<=0)|| (JTextEdad.getText().length()<=0) 
					|| (JTextTel.getText().length()<=0)|| (JTextLocalidad.getText().length()<=0)
					||(JTextDir.getText().length()<=0) || (JTextCP.getText().length()<=0) 
					|| (JTextEmail.getText().length()<=0)){
					JOptionPane.showMessageDialog(null, "Falta Algún Dato por Rellenar");//JOption 	que muestra un mensaje//
					}
				
				if(conexion != null){
				//Pasamos los Datos Modificados del Empleado a la Base de Datos//
					t1.setNombre(JTextNombre.getText());
					t1.setApellido(JTextApellido.getText());
					t1.setDni(JTextDNI.getText());
					t1.setEdad(Integer.valueOf(JTextEdad.getText().toString()));
					t1.setTelefono(Integer.valueOf(JTextTel.getText().toString()));
					t1.setLocalidad(JTextLocalidad.getText());
					t1.setDireccion(JTextDir.getText());
					t1.setCp(Integer.valueOf(JTextCP.getText()));
					t1.setEmail(JTextEmail.getText());
					
					edb.actualizarTrabajador(conexion, t1);
					
					JOptionPane.showMessageDialog(null, "Actualización Correcta");
				}else{
					JOptionPane.showMessageDialog(null, "No se ha Podido Actualizar revisa la Conexión");
					System.out.println("Estás fuera de Conexión");
				}
			}
			
		}
		
	}
}
