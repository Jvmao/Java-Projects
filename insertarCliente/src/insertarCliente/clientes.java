package insertarCliente;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.Color;

public class clientes extends JFrame {

	//Variables Frame//
	private JPanel contentPane;
	private JLabel JLabelNombre,JLabelApellidos,JLabelDir,JLabelLocalidad,JLabelTel;
	private JTextField JTextNombre,JTextApellidos,JTextDir,JTextLocalidad,JTextTel;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAgregarCliente,btnSalir,btnEliminar,btnNuevoCliente,btnGuardar;
	private JLabel JLabelPic1;
	private Component verticalStrut_1;
	
	//Variables para autoincrementar el código//
	private static int code = 1000;
	private static int cliente = ++code;
		
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientes frame = new clientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(clientes.class.getResource("/imagenes/data.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
		setTitle("REGISTRO CLIENTE");
		setBounds(100, 100, 666, 477);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 78, 0, 83, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
	
		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridheight = 7;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 0;
		contentPane.add(verticalStrut_1, gbc_verticalStrut_1);
		
		//Etiqueta Imagen//
		JLabelPic1 = new JLabel(new ImageIcon(clientes.class.getResource("/imagenes/clientes1.png")));
		GridBagConstraints gbc_JLabelPic1 = new GridBagConstraints();
		gbc_JLabelPic1.fill = GridBagConstraints.BOTH;
		gbc_JLabelPic1.gridheight = 6;
		gbc_JLabelPic1.insets = new Insets(1, 1, 5, 5);
		gbc_JLabelPic1.gridx = 6;
		gbc_JLabelPic1.gridy = 0;
		contentPane.add(JLabelPic1, gbc_JLabelPic1);
		
		//Etiqueta Nombre//
		JLabelNombre = new JLabel("NOMBRE");
		JLabelNombre.setForeground(new Color(0, 51, 255));
		JLabelNombre.setFont(new Font("Stencil", Font.PLAIN, 12));
		GridBagConstraints gbc_JLabelNombre = new GridBagConstraints();
		gbc_JLabelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_JLabelNombre.gridx = 0;
		gbc_JLabelNombre.gridy = 1;
		contentPane.add(JLabelNombre, gbc_JLabelNombre);
		//Campo Nombre//
		JTextNombre = new JTextField();
		JTextNombre.setFont(new Font("Rockwell", Font.BOLD, 12));
		GridBagConstraints gbc_JTextNombre = new GridBagConstraints();
		gbc_JTextNombre.insets = new Insets(0, 0, 5, 5);
		gbc_JTextNombre.fill = GridBagConstraints.BOTH;
		gbc_JTextNombre.gridx = 1;
		gbc_JTextNombre.gridy = 1;
		contentPane.add(JTextNombre, gbc_JTextNombre);
		JTextNombre.setColumns(1);
		JTextNombre.addKeyListener(new innerKL());//Añadimos el KeyListener//
		JTextNombre.addActionListener(new innerAL());
		
		//Etiqueta Apellidos//
		JLabelApellidos = new JLabel("APELLIDOS");
		JLabelApellidos.setForeground(new Color(51, 51, 255));
		JLabelApellidos.setFont(new Font("Stencil", Font.PLAIN, 12));
		GridBagConstraints gbc_JLabelApellidos = new GridBagConstraints();
		gbc_JLabelApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_JLabelApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelApellidos.gridx = 0;
		gbc_JLabelApellidos.gridy = 2;
		contentPane.add(JLabelApellidos, gbc_JLabelApellidos);
		//Campo Apellidos//
		JTextApellidos = new JTextField();
		JTextApellidos.setFont(new Font("Rockwell", Font.BOLD, 12));
		GridBagConstraints gbc_JTextApellidos = new GridBagConstraints();
		gbc_JTextApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_JTextApellidos.fill = GridBagConstraints.BOTH;
		gbc_JTextApellidos.gridx = 1;
		gbc_JTextApellidos.gridy = 2;
		contentPane.add(JTextApellidos, gbc_JTextApellidos);
		JTextApellidos.setColumns(10);
		JTextApellidos.addKeyListener(new innerKL());//Añadimos el KeyListener//
		JTextApellidos.addActionListener(new innerAL());
		
		//Etiqueta Dirección//
		JLabelDir = new JLabel("DIRECCI\u00D3N");
		JLabelDir.setForeground(new Color(51, 51, 255));
		JLabelDir.setFont(new Font("Stencil", Font.PLAIN, 12));
		GridBagConstraints gbc_JLabelDir = new GridBagConstraints();
		gbc_JLabelDir.fill = GridBagConstraints.BOTH;
		gbc_JLabelDir.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelDir.gridx = 0;
		gbc_JLabelDir.gridy = 3;
		contentPane.add(JLabelDir, gbc_JLabelDir);
		//Campo Dirección//
		JTextDir = new JTextField();
		JTextDir.setFont(new Font("Rockwell", Font.BOLD, 12));
		GridBagConstraints gbc_JTextDir = new GridBagConstraints();
		gbc_JTextDir.insets = new Insets(0, 0, 5, 5);
		gbc_JTextDir.fill = GridBagConstraints.BOTH;
		gbc_JTextDir.gridx = 1;
		gbc_JTextDir.gridy = 3;
		contentPane.add(JTextDir, gbc_JTextDir);
		JTextDir.setColumns(10);
		JTextDir.addKeyListener(new innerKL());//Añadimos el KeyListener//
		JTextDir.addActionListener(new innerAL());//Añadimos el ActionListener//
		
		//Etiqueta Localidad//
		JLabelLocalidad = new JLabel("LOCALIDAD");
		JLabelLocalidad.setForeground(new Color(51, 51, 255));
		JLabelLocalidad.setFont(new Font("Stencil", Font.PLAIN, 12));
		GridBagConstraints gbc_JLabelLocalidad = new GridBagConstraints();
		gbc_JLabelLocalidad.fill = GridBagConstraints.BOTH;
		gbc_JLabelLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelLocalidad.gridx = 0;
		gbc_JLabelLocalidad.gridy = 4;
		contentPane.add(JLabelLocalidad, gbc_JLabelLocalidad);
		//Campo Localidad//
		JTextLocalidad = new JTextField();
		JTextLocalidad.setFont(new Font("Rockwell", Font.BOLD, 12));
		GridBagConstraints gbc_JTextLocalidad = new GridBagConstraints();
		gbc_JTextLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_JTextLocalidad.fill = GridBagConstraints.BOTH;
		gbc_JTextLocalidad.gridx = 1;
		gbc_JTextLocalidad.gridy = 4;
		contentPane.add(JTextLocalidad, gbc_JTextLocalidad);
		JTextLocalidad.setColumns(10);
		JTextLocalidad.addKeyListener(new innerKL());//Añadimos el KeyListener//
		JTextLocalidad.addActionListener(new innerAL());//Añadimos el ActionListener//
		
		//Etiqueta Teléfono//
		JLabelTel = new JLabel("TEL\u00C9FONO");
		JLabelTel.setForeground(new Color(51, 51, 255));
		JLabelTel.setFont(new Font("Stencil", Font.PLAIN, 12));
		GridBagConstraints gbc_JLabelTel = new GridBagConstraints();
		gbc_JLabelTel.fill = GridBagConstraints.BOTH;
		gbc_JLabelTel.insets = new Insets(0, 0, 5, 5);
		gbc_JLabelTel.gridx = 0;
		gbc_JLabelTel.gridy = 5;
		contentPane.add(JLabelTel, gbc_JLabelTel);
		//Campo Teléfono//
		JTextTel = new JTextField();
		JTextTel.setFont(new Font("Rockwell", Font.BOLD, 12));
		GridBagConstraints gbc_JTextTel = new GridBagConstraints();
		gbc_JTextTel.insets = new Insets(0, 0, 5, 5);
		gbc_JTextTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_JTextTel.gridx = 1;
		gbc_JTextTel.gridy = 5;
		contentPane.add(JTextTel, gbc_JTextTel);
		JTextTel.setColumns(10);
		JTextTel.addKeyListener(new innerKL());//Añadimos el KeyListener//
		
		
		//Botón Agregar Cliente//
		btnAgregarCliente = new JButton("AGREGAR CLIENTE");
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //ActionListener para Agregar Cliente//
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				//Generamos un Array para rellenar las Filas//
				Object [] fila=new Object[6];
						//Declaramos los componentes del Array//
						fila[0] = cliente++;//Se Autoincrementa el Código cada vez que agregamos un Nuevo Cliente//
				        fila[1]=JTextNombre.getText();
				        fila[2]=JTextApellidos.getText();
				        fila[3]=JTextDir.getText();
				        fila[4]=JTextLocalidad.getText();
				        fila[5]=JTextTel.getText().toString();
				        
				        //Añadimos el Array a la Tabla//
				        modelo.addRow(fila);
				        //Asignamos el Modelo a la Tabla//
				        table.setModel(modelo);
				        
				        //Cuando Registramos un Cliente Deshabilitamos los campos de datos y el boton agreagar cliente//
				        //Habilitamos el Botón para eliminar Clientes//
				        JTextNombre.setEditable(false);
				        JTextApellidos.setEditable(false);
				        JTextDir.setEditable(false);
				        JTextLocalidad.setEditable(false);
				        JTextTel.setEditable(false);
				        btnAgregarCliente.setEnabled(false);
				        btnNuevoCliente.setEnabled(true);
				        btnGuardar.setEnabled(true);
				        btnEliminar.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnAgregarCliente = new GridBagConstraints();
		gbc_btnAgregarCliente.fill = GridBagConstraints.BOTH;
		gbc_btnAgregarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregarCliente.gridx = 1;
		gbc_btnAgregarCliente.gridy = 6;
		contentPane.add(btnAgregarCliente, gbc_btnAgregarCliente);
		
		//Botón para Agregar un Nuevo Cliente//
		btnNuevoCliente = new JButton("NUEVO CLIENTE");
		btnNuevoCliente.setEnabled(false);
		GridBagConstraints gbc_btnNuevoCliente = new GridBagConstraints();
		gbc_btnNuevoCliente.fill = GridBagConstraints.BOTH;
		gbc_btnNuevoCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoCliente.gridx = 6;
		gbc_btnNuevoCliente.gridy = 6;
		contentPane.add(btnNuevoCliente, gbc_btnNuevoCliente);
		btnNuevoCliente.addActionListener(new innerAL());
		
		//Scroll//
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		//Tabla para Agregar los Datos del Cliente//
		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRE", "APELLIDOS", "DIRECCI\u00D3N", "LOCALIDAD", "TEL\u00C9FONO"
			}
		));
		scrollPane.setViewportView(table);
		
		//Botón para Eliminar Registros//
		btnEliminar = new JButton("ELIMINAR CLIENTE");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//Action Listener para Eliminar Cliente//
				DefaultTableModel model = (DefaultTableModel) table.getModel(); 
				int a = table.getSelectedRow(); 
				int confirmar=JOptionPane.showConfirmDialog(null, "¿Deseas Eliminar el Registro Seleccionado?");
				if(JOptionPane.OK_OPTION==confirmar){
				model.removeRow(a); //Eliminación de Toda la Fila//
				cliente--;//Se Resta el Autoincremento generado anteriormente//
				}
			}
		});
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 14;
		contentPane.add(btnEliminar, gbc_btnEliminar);
		
		//Botón Salir//
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Botón para Salir de la Aplicación//
				System.exit(0);
			}
		});
		
		//Botón para Guardar Datos//
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarDatos();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 14;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.BOTH;
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 6;
		gbc_btnSalir.gridy = 15;
		contentPane.add(btnSalir, gbc_btnSalir);
	
	}
	
	//Método para Guardar los Datos de la Tabla en un documento//
	public void guardarDatos(){
		try {
            String datosTabla = "C:/Users/JoseVicente/Documents/DAM/Programación/Proyectos/DatosCliente.txt";
            BufferedWriter bfw = new BufferedWriter(new FileWriter(datosTabla));
            for (int i = 0 ; i < table.getRowCount(); i++) //Analiza todas las Filas//
            {
                for(int j = 0 ; j < table.getColumnCount();j++) //Analiza todas las Columnas//
                {
                    bfw.write((table.getValueAt(i,j).toString()));
                    if (j < table.getColumnCount() -1) { 
                        bfw.write("    ");//Añadimos un separador "," si no es el ultimo elemento de la fila//
                    }
                }
                bfw.newLine(); //Inserta una Nueva Fila//
            }
            bfw.close(); //Cierra el Archivo//
            System.out.println("El Archivo ha sido Guardado correctamente");
        } catch (IOException e) {
            System.out.println("Error.El Archivo no ha podido ser Guardado" + e.getMessage());
        }
	}
	
	public class innerKL implements KeyListener{
		public void keyPressed(KeyEvent arg0) {	
		}
		public void keyReleased(KeyEvent arg0) {
		}

		public void keyTyped(KeyEvent e) {
			JTextField j =(JTextField)e.getSource(); //Definimos la acción a realizar por los JTextFields//
			if(j == JTextNombre){
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA,ACENTOS Y LA TECLA SPACE PERO NO NÚMEROS//
				char n = e.getKeyChar();
				if((n < 'A' || n > 'Z') && (n < 'a' || n > 'z') && (n < '´') && (n !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(JTextNombre.getText().length()==15) e.consume();
			}else if (j == JTextApellidos){
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA,ACENTOS Y LA TECLA SPACE PERO NO NÚMEROS//
				char n = e.getKeyChar();
				if((n < 'A' || n > 'Z') && (n < 'a' || n > 'z') && (n < '´') && (n !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 30 CARÁCTERES//
				if(JTextApellidos.getText().length()==30) e.consume();
			}else if ((j == JTextDir)){
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA,SIMBOLOS,LA TECLA SPACE Y NÚMEROS//
				char n = e.getKeyChar();
				if((n < 'A' || n > 'Z') && (n < 'a' || n > 'z') && (n < '´') &&
						(n < '-') && (n <'/') && (n !=KeyEvent.VK_SPACE) && (n<'0' || n>'9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 30 CARÁCTERES//
				if(JTextDir.getText().length()==30) e.consume();
			}else if (j == JTextLocalidad){
				//SOLO ADMITE LETRAS EN MAYÚSCULA,MINÚSCULA,ACENTOS Y LA TECLA SPACE//
				char n = e.getKeyChar();
				if((n < 'A' || n > 'Z') && (n < 'a' || n > 'z') && (n < '´') && (n !=KeyEvent.VK_SPACE)) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 20 CARÁCTERES//
				if(JTextLocalidad.getText().length()==20) e.consume();
			}else if (j == JTextTel){
				//SOLO ADMITE NÚMEROS//
				char n = e.getKeyChar();
				if((n<'0' || n>'9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 9 CARÁCTERES//
				if(JTextTel.getText().length()==9) e.consume();
			}
		}
		
	}
	
	//ActionListener para los Campos de Texto//
	public class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//JTextField j =(JTextField)e.getSource();
			if(e.getSource() == JTextNombre){
			//Presionar ENTER y pasar al siguiente texto//
			e.setSource((char)KeyEvent.VK_ENTER);
			JTextApellidos.requestFocus(); 
			}else if(e.getSource() == JTextApellidos){
			//Presionar ENTER y pasar al siguiente texto//
			e.setSource((char)KeyEvent.VK_ENTER);
			JTextDir.requestFocus();
			}else if(e.getSource() == JTextDir){
			//Presionar ENTER y pasar al siguiente texto//
			e.setSource((char)KeyEvent.VK_ENTER);
			JTextLocalidad.requestFocus();	
			}else if(e.getSource() == JTextLocalidad){
			//Presionar ENTER y pasar al siguiente texto//
			e.setSource((char)KeyEvent.VK_ENTER);
			JTextTel.requestFocus();	
			}
			
			else if(e.getSource() == btnNuevoCliente){
				JTextNombre.setEditable(true);
				JTextNombre.setText("");
				JTextApellidos.setEditable(true);
				JTextApellidos.setText("");
				JTextDir.setEditable(true);
				JTextDir.setText("");
				JTextLocalidad.setEditable(true);
				JTextLocalidad.setText("");
				JTextTel.setEditable(true);
				JTextTel.setText("");
				btnAgregarCliente.setEnabled(true);
				btnNuevoCliente.setEnabled(false);
			}
		}
	}
	

}
