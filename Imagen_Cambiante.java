import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Imagen_Cambiante extends JFrame {

	private JPanel contentPane;
	private JLabel Imagen1 , Imagen2 , Imagen3;
	private JButton Resetear;
	
	//Array de ImageIcon para dados con valores de 1 a 3
	ImageIcon[] dados3=new ImageIcon[3];
	//Objeto Random//
	private Random dado=new Random();
	//Array para números Almacenados//
	private int[] numerosAlmacenadosDados3=new int[3];
	    
	//Creamos la Variable para el DadoGris//
	 ImageIcon dadogris = new ImageIcon(getClass().getResource("/imagenes/dadogris.png"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imagen_Cambiante frame = new Imagen_Cambiante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Imagen_Cambiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//IMAGEN 1//
		Imagen1 = new JLabel("");
		//MouseListener Imagen1//
		Imagen1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Imagen1.setIcon(dadogris);//Carga una Imágen Gris cuando se toca la Imagen1//
			}
		});
		Imagen1.setBounds(10, 11, 143, 132);
		contentPane.add(Imagen1);
		//Cargar Imagen desde Array//
		this.inicioJuego(dados3, numerosAlmacenadosDados3); //Utilizar comando this para cargar las imágenes desde Array//
		Imagen1.setIcon(dados3[numerosAlmacenadosDados3[0]]);
		Imagen1.setName("1");
		
		//IMAGEN 2//
		Imagen2 = new JLabel("");
		//MouseListener Imagen2//
		Imagen2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Imagen2.setIcon(dadogris);//Carga una Imágen Gris cuando se toca la Imagen1//
			}
		});
		Imagen2.setBounds(222, 11, 143, 132);
		contentPane.add(Imagen2);
		//Cargar Imagen desde Array//
		Imagen2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
		Imagen2.setName("2");
		
		//IMAGEN 3//
		Imagen3 = new JLabel("");
		//MouseListener Imagen3//
		Imagen3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Imagen3.setIcon(dadogris);//Carga una Imágen Gris cuando se toca la Imagen1//
			}
		});
		Imagen3.setBounds(104, 154, 150, 136);
		contentPane.add(Imagen3);
		//Cargar Imagen desde Array//
		Imagen3.setIcon(dados3[numerosAlmacenadosDados3[2]]);
		Imagen3.setName("3");
		
		
		//BOTON RESETEAR//
		Resetear = new JButton("Reset");
		//ActionListener para el boton Reset//
		Resetear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Carga nuevas imagenes al presionar el boton RESET//
				Imagen1.setIcon(dados3[dado.nextInt(3)]);
				Imagen2.setIcon(dados3[dado.nextInt(3)]);
				Imagen3.setIcon(dados3[dado.nextInt(3)]);
			}
		});
		Resetear.setBounds(335, 267, 89, 23);
		contentPane.add(Resetear);
		
		try{
			inicioJuego(dados3 , numerosAlmacenadosDados3);
			}catch (Exception e){
				e.getMessage();
			}
	}
	
	//-----------------------------------Método para los Arrays----------------------------------------------//
		private void  inicioJuego (ImageIcon[] dados3 , int[]numerosAlmacenadosDados3){
			
			//Inicializar Array para la variable dados de 3 caras//
			for(int i=0;i<dados3.length;i++){
				dados3[i]=new ImageIcon(getClass().getResource("/imagenes/dado"+String.valueOf(i+1)+"_3.png"));
			}
		
			//Inicializar Array para almacenar los Dados de 3 caras//
			for(int i=0;i<numerosAlmacenadosDados3.length;i++){
			//Número aleatorio entre 0 y 2//
			numerosAlmacenadosDados3[i]=dado.nextInt(3);
			
			}
		}

	//------------------------------------------------------------------------------------------------------//
}
