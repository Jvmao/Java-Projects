import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Plantilla extends JFrame {
	//VARIABLES//
	private JPanel contentPane;
	private JTextField nombre , apellidos , edad , correo , datos ;
	private JLabel etiqueta1 , etiqueta2, etiqueta3 , etiqueta4 ;
	private JButton boton1;
		


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plantilla frame = new Plantilla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Plantilla() {
		setTitle("DATOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Cambiamos el Color del Frame//
		contentPane.setBackground(Color.ORANGE);
		
		//ETIQUETA NOMBRE//
				etiqueta1 = new JLabel("NOMBRE");
				etiqueta1.setBounds(10, 11, 90, 14);
				contentPane.add(etiqueta1);
				//ETIQUETA APELLIDOS//
				etiqueta2 = new JLabel("APELLIDOS");
				etiqueta2.setBounds(10, 51, 90, 14);
				contentPane.add(etiqueta2);
				//ETIQUETA EDAD//
				etiqueta3 = new JLabel("EDAD");
				etiqueta3.setBounds(10, 91, 90, 14);
				contentPane.add(etiqueta3);
				//ETIQUETA CORREO//
				etiqueta4 = new JLabel("CORREO");
				etiqueta4.setBounds(10, 133, 90, 14);
				contentPane.add(etiqueta4);
				//CAMPO PARA NOMBRE//
				nombre = new JTextField();
				nombre.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						//SOLO ADMITE LETRAS EN MAYÚSCULA Y MINÚSCULA PERO NO NÚMEROS//
						char c = e.getKeyChar();
						if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) e.consume();
					}
				});
				nombre.setBounds(110, 8, 252, 20);
				contentPane.add(nombre);
				nombre.setColumns(10);
				
				//CAMPO PARA APELLIDOS//
				apellidos = new JTextField();
				apellidos.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						//SOLO ADMITE LETRAS EN MAYÚSCULA Y MINÚSCULA PERO NO NÚMEROS//
						char c = e.getKeyChar();
						if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c !=KeyEvent.VK_SPACE)) e.consume();
					}
				});
				apellidos.setBounds(110, 48, 252, 20);
				contentPane.add(apellidos);
				apellidos.setColumns(10);
				
				//CAMPO PARA EDAD//
				edad = new JTextField();
				edad.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(c<'0' || c>'9') e.consume();
					}
				});
				edad.setBounds(110, 88, 252, 20);
				contentPane.add(edad);
				edad.setColumns(10);
				//CAMPO PARA CORREO//
				correo = new JTextField();
				correo.setBounds(110, 130, 252, 20);
				contentPane.add(correo);
				correo.setColumns(10);
				
				//Código del BOTON//
				boton1 = new JButton("ACEPTAR");
				boton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					//AÑADIMOS LA ACCIÓN A REALIZAR PARA QUE EL CAMPO DE DATOS CONSIGA LOS DEMAS DATOS AL PRESIONAR EL BOTON//
					datos.setText("Datos: " +nombre.getText()+ " " +apellidos.getText()+ " "+edad.getText()+ " "+correo.getText());
					}
				});
				boton1.setBounds(186, 161, 89, 23);
				contentPane.add(boton1);
				
				//CAMPO PARA DATOS//
				datos = new JTextField();
				datos.setBounds(10, 197, 414, 20);
				contentPane.add(datos);
				datos.setColumns(10);
	}

}
