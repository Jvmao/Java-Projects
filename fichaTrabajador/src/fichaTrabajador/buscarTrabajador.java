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

import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class buscarTrabajador extends JFrame {

	//Variables Gráficas//
	private JPanel contentPane;
	private JTextField JTextNombre;
	private JLabel JLabelInfo;
	private JComboBox comboBuscar;
	private JButton JButtonBuscar,JButtonModificar,JButtonSalir;
	private JTextArea JTextDatos;
	private JLabel JLabelPic1;
	
	//Activamos el nuevo trabjador//
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
					buscarTrabajador frame = new buscarTrabajador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public buscarTrabajador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		comboBuscar = new JComboBox();
		comboBuscar.setBounds(10, 69, 459, 20);
		contentPane.add(comboBuscar);
		comboBuscar.addActionListener(new innerAction());
		
		JLabelInfo = new JLabel("Introduce Nombre del Trabajador");
		JLabelInfo.setFont(new Font("Sitka Text", Font.ITALIC, 12));
		JLabelInfo.setBounds(10, 23, 203, 20);
		contentPane.add(JLabelInfo);
		
		JTextNombre = new JTextField();
		JTextNombre.setBounds(223, 23, 117, 20);
		contentPane.add(JTextNombre);
		JTextNombre.setColumns(10);
		
		JButtonBuscar = new JButton("");
		JButtonBuscar.setIcon(new ImageIcon(buscarTrabajador.class.getResource("/imagenes/monitor24.png")));
		JButtonBuscar.setBounds(404, 23, 54, 35);
		contentPane.add(JButtonBuscar);
		JButtonBuscar.addActionListener(new innerAction()); //Añadimos el Action Listener//
		JButtonBuscar.setToolTipText("Buscar Trabajador");
		
		JTextDatos = new JTextArea();
		JTextDatos.setBackground(new Color(204, 255, 204));
		JTextDatos.setFont(new Font("Mongolian Baiti", Font.ITALIC, 15));
		JTextDatos.setLineWrap(true);
		JTextDatos.setEditable(false);
		JTextDatos.setBounds(10, 117, 211, 224);
		contentPane.add(JTextDatos);
		
		JButtonSalir = new JButton("");
		JButtonSalir.setIcon(new ImageIcon(buscarTrabajador.class.getResource("/imagenes/power-button24.png")));
		JButtonSalir.setBounds(415, 308, 43, 33);
		contentPane.add(JButtonSalir);
		JButtonSalir.addActionListener(new innerAction());//Añadimos el Action Listener//
		JButtonSalir.setToolTipText("Salir");//Añadimos Etiqueta sobre el Botón Salir
		
		JLabelPic1 = new JLabel("");
		JLabelPic1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPic1.setIcon(new ImageIcon(buscarTrabajador.class.getResource("/imagenes/database128.png")));
		JLabelPic1.setBounds(249, 122, 220, 165);
		contentPane.add(JLabelPic1);
		
		JButtonModificar = new JButton("");
		JButtonModificar.setIcon(new ImageIcon(buscarTrabajador.class.getResource("/imagenes/shuffle.png")));
		JButtonModificar.setBounds(249, 308, 77, 33);
		contentPane.add(JButtonModificar);
		JButtonModificar.addActionListener(new innerAction());//Añadimos el Action Listener
		JButtonModificar.setToolTipText("Modificar Trabajador");//Añadimos Etiqueta sobre el Botón Modificar
		
		//Método para Conectarse a la BBDD//
		conectar();
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
	
	//Método para Activar los Action Listener//
	public class innerAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == JButtonBuscar){
				comboBuscar.removeAllItems();
				//Buscamos al Trabajador por el Nombre//
				edb.buscarTrabajador(JTextNombre.getText(), comboBuscar);
				numero_items=comboBuscar.getItemCount();
				JTextDatos.setText("Empleado Encontrado: \n"+t1.getId()+"\n" +t1.getNombre()+"\n" +t1.getApellido()+"\n"
						+t1.getEdad()+"\n"+t1.getTelefono()+"\n"+t1.getLocalidad()+"\n"+t1.getDireccion()+"\n"
						+t1.getCp()+"\n"+t1.getEmail()+"\n"+t1.getCodigo());
			}else if(e.getSource()==comboBuscar){
				t1=(trabajador) comboBuscar.getSelectedItem();
				if(t1 !=null){
					JTextDatos.setText("Empleado Encontrado: \n"+t1.getId()+"\n" +t1.getNombre()+"\n" +t1.getApellido()+"\n"
							+t1.getEdad()+"\n"+t1.getTelefono()+"\n"+t1.getLocalidad()+"\n"+t1.getDireccion()+"\n"
									+t1.getCp()+"\n"+t1.getEmail()+"\n"+t1.getCodigo());
					
				}else{
					JTextDatos.setText("Empleado No Encontrado");
				}
			}else if(e.getSource()==JButtonModificar){
				modificarTrabajador v2 = new modificarTrabajador();
				v2.setVisible(true);
				v2.setTrabajador(t1);
				dispose();
			}else if(e.getSource()==JButtonSalir){
				System.exit(0);//Salimos de la Aplicación
			}
			
		}
		
	}
}
