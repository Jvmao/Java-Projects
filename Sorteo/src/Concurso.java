import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Concurso extends JFrame {

	
	//Variables//
	private JPanel contentPane;
	private JTextField JTextDato1,JTextDato2,JTextDato3,JTextDato4,
	JTextPuntos1,JTextPuntos2,JTextPuntos3,JTextPuntos4,JTextFieldPuntosTotales;
	private JTextField JText1,JText2,JText3,JText4;
	private JButton btn1,btnSalir,btnVolverAJugar;
	private JLabel JLabelPuntos, JLabelResultado1,JLabelResultado2,
	JLabelResultado3,JLabelResultado4,JLabelPicture1,JLabelPicture2,JLabelPicture3,JLabelPicture4,
	JLabelPuntos1,JLabelPuntos2,JLabelPuntos3,JLabelPuntos4;
	
	//Introducimos el Random para calcular los números de Forma Aleatoria//
	Random aleatorio = new Random();
	//Aleatorio Campo 1//
	int i = aleatorio.nextInt(2)+1;
	String valor = Integer.toString(i);
	//Aleatorio Campo 2//
	int c = aleatorio.nextInt(2)+1;
	String valor1 = Integer.toString(c);
	//Aleatorio Campo 3//
	int d = aleatorio.nextInt(2)+1;
	String valor2 = Integer.toString(d);
	//Aleatorio Campor 4//
	int r = aleatorio.nextInt(2)+1;
	String valor3 = Integer.toString(r);
		
	//Cargamos las Imágenes//
	ImageIcon imagenOK = new ImageIcon(this.getClass().getResource("/imagenes/ok.png"));
	ImageIcon imagenError = new ImageIcon(this.getClass().getResource("/imagenes/error.png"));
		
	//Variables para Semáforo//
	private boolean tocaJugar = true;
	private boolean tocaVolverjugar = true;
		
	//Variables Operaciones//
	private int resultado1 = 5;
	private int resultado2 = 0;
	private int resultadoFinal;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Concurso frame = new Concurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Concurso() {
		setTitle("SORTEO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 51));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Texto Primer Número//
		JTextDato1 = new JTextField();
		JTextDato1.setBackground(new Color(255, 153, 0));
		JTextDato1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		JTextDato1.setHorizontalAlignment(SwingConstants.CENTER);
		JTextDato1.setBounds(6, 10, 86, 20);
		JTextDato1.setColumns(10);
		contentPane.add(JTextDato1);
		JTextDato1.addActionListener(new innerAL());//Añadimos los ActionListener desde la INNERCLASS//
		JTextDato1.addKeyListener(new innerKL());//Añadimos los KeyListener desde la InnerClass//
				
		//Texto Segundo Número//
		JTextDato2 = new JTextField();
		JTextDato2.setBackground(new Color(255, 153, 0));
		JTextDato2.setFont(new Font("Rockwell", Font.PLAIN, 16));
		JTextDato2.setHorizontalAlignment(SwingConstants.CENTER);
		JTextDato2.setBounds(113, 10, 87, 20);
		JTextDato2.setColumns(10);
		contentPane.add(JTextDato2);
		JTextDato2.addActionListener(new innerAL());//Añadimos los ActionListener desde la INNERCLASS//
		JTextDato2.addKeyListener(new innerKL());//Añadimos los KeyListener desde la InnerClass//
				
		//Texto Tercer Número//
		JTextDato3 = new JTextField();
		JTextDato3.setBackground(new Color(255, 153, 0));
		JTextDato3.setFont(new Font("Rockwell", Font.PLAIN, 16));
		JTextDato3.setHorizontalAlignment(SwingConstants.CENTER);
		JTextDato3.setBounds(231, 10, 86, 20);
		JTextDato3.setColumns(10);
		contentPane.add(JTextDato3);
		JTextDato3.addActionListener(new innerAL());//Añadimos los ActionListener desde la INNERCLASS//
		JTextDato3.addKeyListener(new innerKL());//Añadimos los KeyListener desde la InnerClass//
				
		//Texto Cuarto Número//
		JTextDato4 = new JTextField();
		JTextDato4.setBackground(new Color(255, 153, 0));
		JTextDato4.setFont(new Font("Rockwell", Font.PLAIN, 16));
		JTextDato4.setHorizontalAlignment(SwingConstants.CENTER);
		JTextDato4.setBounds(341, 10, 85, 20);
		JTextDato4.setColumns(10);
		contentPane.add(JTextDato4);
		JTextDato4.addActionListener(new innerAL());//Añadimos los ActionListener desde la INNERCLASS//
		JTextDato4.addKeyListener(new innerKL());//Añadimos los KeyListener desde la InnerClass//
				
		//Número Aleatorio 1//
		JText1 = new JTextField();
		JText1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		JText1.setHorizontalAlignment(SwingConstants.CENTER);
		JText1.setEditable(false);
		JText1.setBounds(6, 74, 86, 20);
		contentPane.add(JText1);
		JText1.setColumns(10);
		//Número Aleatorio 2//
		JText2 = new JTextField();
		JText2.setFont(new Font("Rockwell", Font.PLAIN, 16));
		JText2.setHorizontalAlignment(SwingConstants.CENTER);
		JText2.setEditable(false);
		JText2.setBounds(113, 74, 87, 20);
		contentPane.add(JText2);
		JText2.setColumns(10);
		//Número Aleatorio 3//
		JText3 = new JTextField();
		JText3.setFont(new Font("Rockwell", Font.PLAIN, 16));
		JText3.setHorizontalAlignment(SwingConstants.CENTER);
		JText3.setEditable(false);
		JText3.setBounds(231, 74, 86, 20);
		contentPane.add(JText3);
		JText3.setColumns(10);
		//Número Aleatorio 4//
		JText4 = new JTextField();
		JText4.setFont(new Font("Rockwell", Font.PLAIN, 16));
		JText4.setHorizontalAlignment(SwingConstants.CENTER);
		JText4.setEditable(false);
		JText4.setBounds(341, 74, 85, 20);
		contentPane.add(JText4);
		JText4.setColumns(10);
				
		btn1 = new JButton("JUGAR");
		btn1.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 14));
		btn1.setBackground(new Color(255, 99, 71));
		btn1.setBounds(113, 41, 204, 23);
		contentPane.add(btn1);
		btn1.addActionListener(new innerAction());//Añadimos el ActionListener desde la InnerClass//
		//btn1.addActionListener(new innerAL());
				
		JLabelPuntos = new JLabel("PUNTOS TOTALES");
		JLabelPuntos.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		JLabelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPuntos.setBounds(6, 318, 87, 20);
		contentPane.add(JLabelPuntos);
				
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(341, 349, 85, 23);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new innerAction());//Añadimos el ActionListener desde la InnerClass//
				
		JLabelResultado1 = new JLabel("");
		JLabelResultado1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelResultado1.setBounds(6, 111, 86, 23);
		contentPane.add(JLabelResultado1);
				
		JLabelResultado2 = new JLabel("");
		JLabelResultado2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelResultado2.setBounds(113, 111, 87, 23);
		contentPane.add(JLabelResultado2);
				
		JLabelResultado3 = new JLabel("");
		JLabelResultado3.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelResultado3.setBounds(231, 111, 86, 23);
		contentPane.add(JLabelResultado3);
				
		JLabelResultado4 = new JLabel("");
		JLabelResultado4.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelResultado4.setBounds(341, 111, 85, 23);
		contentPane.add(JLabelResultado4);
				
		//Botón para Volver a Jugar//
		btnVolverAJugar = new JButton("VOLVER A JUGAR");
		btnVolverAJugar.setBounds(113, 349, 180, 23);
		contentPane.add(btnVolverAJugar);
		btnVolverAJugar.addActionListener(new innerAction());//Añadimos el ActionListener desde la InnerClass//
				
		//Imágenes Resultado//
		JLabelPicture1 = new JLabel("");
		JLabelPicture1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPicture1.setBounds(6, 145, 86, 62);
		contentPane.add(JLabelPicture1);
				
		JLabelPicture2 = new JLabel("");
		JLabelPicture2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPicture2.setBounds(113, 145, 87, 62);
		contentPane.add(JLabelPicture2);
				
		JLabelPicture3 = new JLabel("");
		JLabelPicture3.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPicture3.setBounds(231, 145, 86, 62);
		contentPane.add(JLabelPicture3);
				
		JLabelPicture4 = new JLabel("");
		JLabelPicture4.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPicture4.setBounds(341, 145, 80, 62);
		contentPane.add(JLabelPicture4);
				
		//Campo para Puntos//
		JTextFieldPuntosTotales = new JTextField();
		JTextFieldPuntosTotales.setBackground(new Color(204, 255, 204));
		JTextFieldPuntosTotales.setForeground(Color.BLACK);
		JTextFieldPuntosTotales.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldPuntosTotales.setFont(new Font("Magneto", Font.PLAIN, 22));
		JTextFieldPuntosTotales.setEditable(false);
		JTextFieldPuntosTotales.setBounds(6, 338, 86, 34);
		contentPane.add(JTextFieldPuntosTotales);
		JTextFieldPuntosTotales.setColumns(10);
		JTextFieldPuntosTotales.addActionListener(new innerAction());//Añadimos el ActionListener desde la inner class//
				
		//JLabel para los puntos obtenidos por acierto//
		JLabelPuntos1 = new JLabel("PUNTOS ");
		JLabelPuntos1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPuntos1.setBounds(6, 218, 86, 14);
		contentPane.add(JLabelPuntos1);
				
		JLabelPuntos2 = new JLabel("PUNTOS");
		JLabelPuntos2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPuntos2.setBounds(114, 218, 86, 14);
		contentPane.add(JLabelPuntos2);
				
		JLabelPuntos3 = new JLabel("PUNTOS ");
		JLabelPuntos3.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPuntos3.setBounds(231, 218, 86, 14);
		contentPane.add(JLabelPuntos3);
				
		JLabelPuntos4 = new JLabel("PUNTOS ");
		JLabelPuntos4.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelPuntos4.setBounds(341, 218, 86, 14);
		contentPane.add(JLabelPuntos4);
				
		//TextField para los puntos obtneidos por acierto//
		JTextPuntos1 = new JTextField();
		JTextPuntos1.setEditable(false);
		JTextPuntos1.setHorizontalAlignment(SwingConstants.CENTER);
		JTextPuntos1.setBounds(6, 243, 86, 20);
		contentPane.add(JTextPuntos1);
		JTextPuntos1.setColumns(10);
				
		JTextPuntos2 = new JTextField();
		JTextPuntos2.setEditable(false);
		JTextPuntos2.setHorizontalAlignment(SwingConstants.CENTER);
		JTextPuntos2.setColumns(10);
		JTextPuntos2.setBounds(113, 243, 86, 20);
		contentPane.add(JTextPuntos2);
				
		JTextPuntos3 = new JTextField();
		JTextPuntos3.setEditable(false);
		JTextPuntos3.setHorizontalAlignment(SwingConstants.CENTER);
		JTextPuntos3.setColumns(10);
		JTextPuntos3.setBounds(231, 243, 86, 20);
		contentPane.add(JTextPuntos3);
		
		JTextPuntos4 = new JTextField();
		JTextPuntos4.setHorizontalAlignment(SwingConstants.CENTER);
		JTextPuntos4.setEditable(false);
		JTextPuntos4.setBounds(340, 243, 86, 20);
		contentPane.add(JTextPuntos4);
		JTextPuntos4.setColumns(10);
				
		resetValues();//Introducimos la Clase para resetear los valores//
	}
	
	public void resetValues(){ //Reiniciamos todos los valores//
		JTextDato1.setText(null);
		JTextDato2.setText(null);
		JTextDato3.setText(null);
		JTextDato4.setText(null);
		JText1.setText(" ");
		JText2.setText(" ");
		JText3.setText(" ");
		JText4.setText(" ");
		JLabelResultado1.setText(" ");
		JLabelResultado2.setText(" ");
		JLabelResultado3.setText(" ");
		JLabelResultado4.setText(" ");
		//Aleatorio Campo 1//
		i = aleatorio.nextInt(2)+1;
		valor = Integer.toString(i);
		//Aleatorio Campo 2//
		c = aleatorio.nextInt(2)+1;
		valor1 = Integer.toString(c);
		//Aleatorio Campo 3//
		d = aleatorio.nextInt(2)+1;
		valor2 = Integer.toString(d);
		//Aleatorio Campor 4//
		r = aleatorio.nextInt(2)+1;
		valor3 = Integer.toString(r);
		
		//Reiniciamos los Iconos del Resultado//
		JLabelPicture1.setIcon(null);
		JLabelPicture2.setIcon(null);
		JLabelPicture3.setIcon(null);
		JLabelPicture4.setIcon(null);
		
		//Reiniciamos el Campo de los Puntos//
		JTextPuntos1.setText(null);
		JTextPuntos2.setText(null);
		JTextPuntos3.setText(null);
		JTextPuntos4.setText(null);
		JTextFieldPuntosTotales.setText(null);
		
		btn1.setEnabled(true);
		btnVolverAJugar.setEnabled(false);
	}
	
	
	private class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JTextField x = (JTextField)e.getSource();
			if(JTextDato1 == x){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextDato2.requestFocus();
			}
			if(JTextDato2 == x){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextDato3.requestFocus();
			}
			if(JTextDato3 == x){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextDato4.requestFocus();
			}else if (JTextDato4 == x){
				//Presionar ENTER y pasar al siguiente texto//
				e.setSource((char)KeyEvent.VK_ENTER);
				JTextDato1.requestFocus();
			}
		}	
	}
	
	private class innerAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton w = (JButton) e.getSource();
			if(btn1 == w){//Obtenemos el Valor de los Campos Aleatorios//
				JText1.setText(valor);
			}
			if(btn1==w){
				JText2.setText(valor1);
			}
			if(btn1==w){
				JText3.setText(valor2);
			}
			if(btn1==w){
				JText4.setText(valor3);
			}
			
			//Habilitamos un Semáforo para Activar el Botón VolverAJugar una vez se presione el botón Jugar//
			if(tocaJugar){
				tocaJugar = true;
				btn1.setEnabled(false);
				btnVolverAJugar.setEnabled(true);
			}else{
				tocaJugar = false;
				btn1.setEnabled(true);
				btnVolverAJugar.setEnabled(false);
			}
			
				//Se muestra el Texto y la Imagen en Función de si se Acierta o No//
				if(JTextDato1.getText().equals(JText1.getText())){
					JLabelResultado1.setText("CORRECTO");
					JLabelResultado1.setForeground(Color.BLUE);
					JLabelPicture1.setIcon(imagenOK);
					JTextPuntos1.setText(JTextPuntos1.getText()+resultado1);
				}else {
					JLabelResultado1.setText("Has Fallado");
					JLabelResultado1.setForeground(Color.BLACK);
					JLabelPicture1.setIcon(imagenError);
					JTextPuntos1.setText(JTextPuntos1.getText()+resultado2);
				}
				
				if(JTextDato2.getText().equals(JText2.getText())){
					JLabelResultado2.setText("CORRECTO");
					JLabelResultado2.setForeground(Color.BLUE);
					JLabelPicture2.setIcon(imagenOK);
					JTextPuntos2.setText(JTextPuntos2.getText()+resultado1);
					
				}else{
					JLabelResultado2.setText("Has Fallado");
					JLabelResultado2.setForeground(Color.BLACK);
					JLabelPicture2.setIcon(imagenError);
					JTextPuntos2.setText(JTextPuntos2.getText()+resultado2);
				}
				
				if(JTextDato3.getText().equals(JText3.getText())){
					JLabelResultado3.setText("CORRECTO");
					JLabelResultado3.setForeground(Color.BLUE);
					JLabelPicture3.setIcon(imagenOK);
					JTextPuntos3.setText(JTextPuntos3.getText()+resultado1);
					
				}else{
					JLabelResultado3.setText("Has Fallado");
					JLabelResultado3.setForeground(Color.BLACK);
					JLabelPicture3.setIcon(imagenError);
					JTextPuntos3.setText(JTextPuntos3.getText()+resultado2);
				}
				
				if(JTextDato4.getText().equals(JText4.getText())){
					JLabelResultado4.setText("CORRECTO");
					JLabelResultado4.setForeground(Color.BLUE);
					JLabelPicture4.setIcon(imagenOK);
					JTextPuntos4.setText(JTextPuntos4.getText()+resultado1);
				}else{
					JLabelResultado4.setText("Has Fallado");
					JLabelResultado4.setForeground(Color.BLACK);
					JLabelPicture4.setIcon(imagenError);
					JTextPuntos4.setText(JTextPuntos4.getText()+resultado2);
				}
				
				//Método para  Sumar los Campos de los Puntos y pasarlos al resultado final//
				resultadoFinal =Integer.parseInt(JTextPuntos1.getText())+Integer.parseInt(JTextPuntos2.getText())
				+Integer.parseInt(JTextPuntos3.getText())+Integer.parseInt(JTextPuntos4.getText());
				JTextFieldPuntosTotales.setText(" "+resultadoFinal);
		
				if(resultadoFinal == 5){
					JOptionPane.showMessageDialog(null, "Sigue Intentándolo");
				}else if(resultadoFinal == 10){
					JOptionPane.showMessageDialog(null, "Sigue Intentándolo");
				}else if(resultadoFinal == 15){
					JOptionPane.showMessageDialog(null, "Enhorabuena, has Ganado 100€");
				}else if(resultadoFinal == 20){
					JOptionPane.showMessageDialog(null, "Enhorabuena, has Ganado 1.000€");
				}
				
				
			if(btnVolverAJugar == w){
				resetValues();//Reseteamos todos los Valor//
			}
			
			if(btnSalir == w){
				System.exit(0);//Salimos de la Aplicación//
			}
			
		}
	}
	
	public class innerKL implements KeyListener{
		public void keyPressed(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {
		}
		public void keyTyped(KeyEvent e) {
			JTextField f = (JTextField)e.getSource();
			if(JTextDato1 == f){//Establecemos la condición para que en los campos solo se introduzca un número//
				char c = e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
				if(JTextDato1.getText().length()==1) e.consume();
			}else if(JTextDato2 == f){
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				if(JTextDato2.getText().length()==1) e.consume();
			}else if(JTextDato3 == f){
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				if(JTextDato3.getText().length()==1) e.consume();
			}else if(JTextDato4 == f){
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
				if(JTextDato4.getText().length()==1) e.consume();
			}
		}
	}
}
