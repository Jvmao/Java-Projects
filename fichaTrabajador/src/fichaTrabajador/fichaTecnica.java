package fichaTrabajador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Modelo.ConnectionDB;
import Modelo.empleadoDB;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class fichaTecnica extends JFrame {
	
	//Variables Gráficas//
	private JPanel contentPane;
	private JLabel JLabelTitulo,JLabelNombre,JLabelApellido,JLabelEdad,JLabelTel,
	JLabelDir,JLabelCP,JLabelLocalidad,JLabelEmail,JLabelDNI;
	private JTextField JTextNombre,JTextApellido,JTextEdad,JTextTel,JTextDir,
	JTextCP,JTextID,JTextEmail,JTextDNI;
	private JButton JButtonID,JButtonReset,JButtonRegistro,JButtonBuscar,JButtonSalir;
	private JComboBox<String> cbLocalidad;
	
	//Variables Cálculos ID//
	Random aleatorio = new Random();
	private int valor = aleatorio.nextInt(10000)+1;
	private String code = Integer.toString(valor).toString();//Pasamos el valor del código de int a String//
	private String variable;
	private String codigo; 
	
	//Inicializamos un nuevo trabajador//
	trabajador t1 = new trabajador();
	
	//Variables para la Conexión a la Base de Datos//
	private ConnectionDB db;
	private empleadoDB edb;
	private Connection conexion;
	private boolean connected = false;
	private int numero_items;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fichaTecnica frame = new fichaTecnica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public fichaTecnica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Estudios\\DAM\\Programaci\u00F3n\\Im\u00E1genes Programaci\u00F3n\\robocop.png"));
		setTitle("REGISTRO TRABAJADOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Etiqueta Titulo//
		JLabelTitulo = new JLabel("NUEVO EMPLEADO");
		JLabelTitulo.setIcon(new ImageIcon(fichaTecnica.class.getResource("/imagenes/users.png")));
		JLabelTitulo.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 18));
		JLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Etiqueta Nombre//
		JLabelNombre = new JLabel("NOMBRE");
		JLabelNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Campo de Texto para Nombre//
		JTextNombre = new JTextField();
		JTextNombre.setColumns(10);
		JTextNombre.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner class//
		JTextNombre.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Apellido//
		JLabelApellido = new JLabel("APELLIDO");
		JLabelApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Campo de Texto para Apellido//
		JTextApellido = new JTextField();
		JTextApellido.setColumns(10);
		JTextApellido.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner class//
		JTextApellido.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta DNI//
		JLabelDNI = new JLabel("DNI");
		JLabelDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Campo de Texto DNI//
		JTextDNI = new JTextField();
		JTextDNI.setColumns(10);
		JTextDNI.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner class//
		JTextDNI.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Edad//
		JLabelEdad = new JLabel("EDAD");
		JLabelEdad.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Campo de Texto Edad//
		JTextEdad = new JTextField();
		JTextEdad.setColumns(10);
		JTextEdad.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner class//
		JTextEdad.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Teléfono//
		JLabelTel = new JLabel("TELEFONO");
		JLabelTel.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Campo de Texto Teléfono//
		JTextTel = new JTextField();
		JTextTel.setColumns(10);
		JTextTel.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner class//
		JTextTel.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta Localidad//
		JLabelLocalidad = new JLabel("LOCALIDAD");
		JLabelLocalidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		//ComboBox Localidad//
		cbLocalidad = new JComboBox<String>();
		cbLocalidad.addItem("Albacete");
		cbLocalidad.addItem("Barcelona");
		cbLocalidad.addItem("Bilbao");
		cbLocalidad.addItem("La Coruña");
		cbLocalidad.addItem("Madrid");
		cbLocalidad.addItem("Oviedo");
		cbLocalidad.addItem("Santander");
		cbLocalidad.addItem("Sevilla");
		cbLocalidad.addItem("Valencia");
		cbLocalidad.addItem("Zaragoza");
		
		//Etiqueta Dirección//
		JLabelDir = new JLabel("DIRECCION");
		JLabelDir.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Campo de Texto Dirección//
		JTextDir = new JTextField();
		JTextDir.setColumns(10);
		JTextDir.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner class//
		JTextDir.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta para el Código Postal//
		JLabelCP = new JLabel("CP");
		JLabelCP.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Campo de Texto para el CP//
		JTextCP = new JTextField();
		JTextCP.setColumns(10);
		JTextCP.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner class//
		JTextCP.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Etiqueta E-Mail//
		JLabelEmail = new JLabel("E-MAIL");
		JLabelEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Campo de Texto E-Mail//
		JTextEmail = new JTextField();
		JTextEmail.setColumns(10);
		JTextEmail.addKeyListener(new innerKL());//Añadimos el KeyListener desde la Inner class//
		JTextEmail.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Botón para generar el ID//
		JButtonID = new JButton("ID");
		JButtonID.setFont(new Font("Wide Latin", Font.PLAIN, 13));
		JButtonID.setForeground(new Color(51, 51, 204));
		JButtonID.setIcon(new ImageIcon(fichaTecnica.class.getResource("/imagenes/id-card.png")));
		JButtonID.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		//Campo de Texto ID//
		JTextID = new JTextField();
		JTextID.setFont(new Font("Segoe UI Symbol", Font.BOLD, 17));
		JTextID.setHorizontalAlignment(SwingConstants.CENTER);
		JTextID.setEditable(false);
		JTextID.setColumns(10);
		
		//Botón para Reiniciar Campos//
		JButtonReset = new JButton("REINICIAR");
		JButtonReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		JButtonReset.setIcon(new ImageIcon(fichaTecnica.class.getResource("/imagenes/power-button.png")));
		JButtonReset.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Botón Salir//
		JButtonSalir = new JButton("SALIR");
		JButtonSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		JButtonSalir.setIcon(new ImageIcon(fichaTecnica.class.getResource("/imagenes/signoption.png")));
		JButtonSalir.addActionListener(new innerAL());//Añadimos el ActionListener desde la InnerClass//
		
		//Botón Registro Jugador//
		JButtonRegistro = new JButton("REGISTRO");
		JButtonRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		JButtonRegistro.setIcon(new ImageIcon(fichaTecnica.class.getResource("/imagenes/server-check.png")));
		JButtonRegistro.addActionListener(new innerAL());
		//Agregamos el Método para la Conexión//
		conectar();
		
		JButtonBuscar = new JButton("BUSCAR");
		JButtonBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		JButtonBuscar.setIcon(new ImageIcon(fichaTecnica.class.getResource("/imagenes/smartphone.png")));
		JButtonBuscar.addActionListener(new innerAL());
		
		//Layout//
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(JLabelTitulo, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(JButtonID, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(JTextEdad, 129, 129, Short.MAX_VALUE)
									.addComponent(JTextDir)
									.addComponent(JLabelDir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(JLabelEdad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(JLabelNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(JTextNombre, GroupLayout.DEFAULT_SIZE, 125, GroupLayout.DEFAULT_SIZE)))
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(JTextCP)
										.addComponent(JLabelCP, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(JLabelApellido, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
										.addComponent(JLabelTel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(JTextTel)
										.addComponent(JTextApellido, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(JTextDNI, Alignment.TRAILING, 130, 130, Short.MAX_VALUE)
										.addComponent(JLabelDNI, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(JTextEmail, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
										.addComponent(cbLocalidad, 0, 130, Short.MAX_VALUE)
										.addComponent(JLabelEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(JLabelLocalidad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(JButtonReset, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(JButtonSalir))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(JButtonBuscar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(JTextID, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
									.addComponent(JButtonRegistro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addGap(45))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(JLabelTitulo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(JLabelNombre)
						.addComponent(JLabelApellido)
						.addComponent(JLabelDNI))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(JTextDNI, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(JTextNombre, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addComponent(JTextApellido, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(JLabelEdad)
						.addComponent(JLabelTel)
						.addComponent(JLabelLocalidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(JTextEdad, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(JTextTel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbLocalidad, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(JLabelDir)
						.addComponent(JLabelCP)
						.addComponent(JLabelEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(JTextDir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(JTextCP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(JTextEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(JTextID, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(JButtonRegistro, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(JButtonID, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(JButtonBuscar)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(JButtonSalir)
						.addComponent(JButtonReset, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE))
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//Método para Calcular el ID del Empleado//
	public void setID(){
		//Obtenemos las 3 primeras letras del nombre del empleado//
		variable=JTextNombre.getText().substring(0,3);
		//Le sumamos las letras del nombre a un número aleatorio//
		codigo = variable + code; 
		//Al apretar el botón ID obtenemos el resultado en el campo JTextID//
		JTextID.setText((codigo).toString());
	}
	
	//Método que permite reiniciar los campos//
	public void reinicio(){
		JTextNombre.setText("");
		JTextNombre.setEnabled(true);
		
		JTextApellido.setText("");
		JTextApellido.setEnabled(true);
		
		JTextDNI.setText("");
		JTextDNI.setEnabled(true);
		
		JTextEdad.setText("");
		JTextEdad.setEnabled(true);
		
		JTextTel.setText("");
		JTextTel.setEnabled(true);
		
		cbLocalidad.setSelectedItem("Albacete");
		cbLocalidad.setEnabled(true);
		
		JTextDir.setText("");
		JTextDir.setEnabled(true);
		
		JTextCP.setText("");
		JTextCP.setEnabled(true);
		
		JTextEmail.setText("");
		JTextEmail.setEnabled(true);
		
		JTextID.setText("");
		
		JButtonID.setEnabled(true);
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
	
	//Método para Recoger los Datos Modificados desde la Ventana modificar Trabajador//
	public void setFicha(trabajador t1){
		this.t1=t1;
		JTextNombre.setText(t1.getNombre());
		JTextApellido.setText(t1.getApellido());
		JTextDNI.setText(t1.getDni());
		JTextEdad.setText(Integer.valueOf(t1.getEdad()).toString());
		JTextTel.setText(Integer.valueOf(t1.getTelefono()).toString());
		t1.getLocalidad();
		JTextDir.setText(t1.getDireccion());
		JTextCP.setText(Integer.valueOf(t1.getCp()).toString());
		JTextEmail.setText(t1.getEmail());
		
		JTextID.setText(t1.getCodigo());
	}
	
	public class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==JButtonID){
				setID();//Establecemos el método para el ID anteriormente creado//
				JTextNombre.setEnabled(false);
				JTextApellido.setEnabled(false);
				JTextDNI.setEnabled(false);
				JTextEdad.setEnabled(false);
				JTextTel.setEnabled(false);
				cbLocalidad.setEnabled(false);
				JTextDir.setEnabled(false);
				JTextCP.setEnabled(false);
				JTextEmail.setEnabled(false);
				
				JButtonID.setEnabled(false);
				
			}else if(e.getSource()==JButtonSalir){
				System.exit(0);
			}else if(e.getSource()==JButtonReset){
				reinicio();
			}else if(e.getSource()== JButtonRegistro){
				//Introducimos un condicional para asegurarnos que todos los campos han sido rellenados//
				if((JTextNombre.getText().length()<=0) || (JTextApellido.getText().length()<=0) 
					|| (JTextDNI.getText().length()<=0) || (JTextTel.getText().length()<=0)
					||(JTextDir.getText().length()<=0) || (JTextCP.getText().length()<=0)
					|| (JTextEmail.getText().length()<=0) || (JTextID.getText().length()<=0)){
					JOptionPane.showMessageDialog(null, "Falta Algún Dato por Rellenar");//JOption 	que muestra un mensaje//
					}
				if(conexion != null){
				//Pasamos los Datos del Nuevo Empleado a la Base de Datos//
				edb.insertarEmpleado(JTextNombre.getText(), JTextApellido.getText(),JTextDNI.getText(), 
						Integer.valueOf(JTextEdad.getText()), Integer.valueOf(JTextTel.getText()), 
						cbLocalidad.getSelectedItem().toString(), JTextDir.getText(), 
						Integer.valueOf(JTextCP.getText()),JTextEmail.getText(), JTextID.getText());
				//Mensaje de que el Nuevo Trabajador ha diso Registrado con éxito//
				JOptionPane.showMessageDialog(null, "El Nuevo Trabajador ha sido Registrado con Éxito");
				}else if(conexion==null){
					JOptionPane.showConfirmDialog(null, "Estás Fuera de Conexión, ¿Deseas Continuar?");
				}
			/**else if(e.getSource()==JButtonModificar){
				t1.setCodigo(JTextID.getText());
				t1.setNombre(JTextNombre.getText());
				t1.setApellido(JTextApellido.getText());
				t1.setDni(JTextDNI.getText());
				t1.setEdad(Integer.valueOf(JTextEdad.getText()));
				t1.setTelefono(Integer.valueOf(JTextTel.getText()));
				t1.setLocalidad(cbLocalidad.getSelectedItem().toString());
				t1.setDireccion(JTextDir.getText());
				t1.setCp(Integer.valueOf(JTextCP.getText()));
				t1.setEmail(JTextEmail.getText());
				
				//Habilitamos la Ventana Modificar Trabajador//
				fichaTecnica v1 = new fichaTecnica();
				modificarTrabajador v2 = new modificarTrabajador();
				v2.setVisible(true);//Hacemos visible la Segunda Ventana//
				v2.setTrabajador(t1);//Habilitamos al Trabajador//
				//v1.setVisible(false);//La Ventana deja de ser Visible//
				dispose();**/
			}else if(e.getSource()==JButtonBuscar){
				//Habilitamos la Ventana Buscar Trabajador//
				buscarTrabajador v3 = new buscarTrabajador();
				v3.setVisible(true);
				dispose();
				
			}
			
			
			if(e.getSource()==JTextNombre){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextApellido.requestFocus(); 
			}else if(e.getSource()==JTextApellido){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextDNI.requestFocus(); 
			}else if(e.getSource()==JTextDNI){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextEdad.requestFocus(); 
			}else if(e.getSource()==JTextEdad){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextTel.requestFocus(); 
			}else if(e.getSource()==JTextTel){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextDir.requestFocus(); 
			}else if(e.getSource()==JTextDir){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextCP.requestFocus(); 
			}else if(e.getSource()==JTextCP){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextEmail.requestFocus(); 
			}else if(e.getSource()==JTextEmail){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				//JButtonID.requestFocus(); 
				JTextNombre.requestFocus();
			}
		}
		
	}
	
	public class innerKL implements KeyListener{
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getSource()==JTextNombre){
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA Y ACENTOS PERO NO NÚMEROS//
				char n = e.getKeyChar();
				if((n < 'A' || n > 'Z') && (n < 'a' || n > 'z') && (n < '´')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(JTextNombre.getText().length()==15) e.consume();
			}else if(e.getSource()==JTextApellido){
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA,ACENTOS Y LA TECLA SPACE PERO NO NÚMEROS//
				char n = e.getKeyChar();
				if((n < 'A' || n > 'Z') && (n < 'a' || n > 'z') && (n < '´') && (n !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 20 CARÁCTERES//
				if(JTextApellido.getText().length()==20) e.consume();
			}else if(e.getSource()==JTextDNI){
				//SOLO ADMITE LETRAS EN MAYÚSCULA Y NÚMEROS//
				char n = e.getKeyChar();
				if((n < 'A' || n > 'Z') && (n < '0' || n > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 9 CARÁCTERES//
				if(JTextDNI.getText().length()==9) e.consume();
			}else if(e.getSource()==JTextEdad){
				//SOLO ADMITE NÚMEROS//
				char n = e.getKeyChar();
				if((n < '0' || n > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 2 CARÁCTERES//
				if(JTextEdad.getText().length()==2) e.consume();
			}else if(e.getSource()==JTextTel){
				//SOLO ADMITE NÚMEROS//
				char n = e.getKeyChar();
				if((n < '0' || n > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 9 CARÁCTERES//
				if(JTextTel.getText().length()==9) e.consume();
			}else if(e.getSource()==JTextDir){
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 30 CARÁCTERES//
				if(JTextDir.getText().length()==30) e.consume();
			}else if(e.getSource()==JTextCP){
				//SOLO ADMITE NÚMEROS//
				char n = e.getKeyChar();
				if((n < '0' || n > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 5 CARÁCTERES//
				if(JTextCP.getText().length()==5) e.consume();
			}else if(e.getSource()==JTextEmail){
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 30 CARÁCTERES//
				if(JTextEmail.getText().length()==30) e.consume();
			}
			
		}
		
	}
}
