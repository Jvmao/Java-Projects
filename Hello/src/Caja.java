import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Caja extends JFrame {

	private JPanel contentPane;
	private JTextField Caja;
	private JLabel lblApellidos;
	private JTextField Caja1;
	private JTextField Caja2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caja frame = new Caja();
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
	public Caja() {
		//Primero definir el String y luego utilizar función setText dentro de Caja//
		String s = new String("234CK");
		String c = new String("550€");
		String d = new String("Valencia");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Pedido");
		lblNewLabel.setBounds(10, 11, 87, 14);
		contentPane.add(lblNewLabel);
		
		Caja = new JTextField();
		Caja.setBounds(10, 28, 182, 20);
		contentPane.add(Caja);
		Caja.setColumns(10);
		
		Caja.setText(s);
		
		lblApellidos = new JLabel("Importe");
		lblApellidos.setBounds(10, 55, 87, 14);
		contentPane.add(lblApellidos);
		
		Caja1 = new JTextField();
		Caja1.setBounds(10, 75, 182, 20);
		contentPane.add(Caja1);
		Caja1.setColumns(10);
		Caja1.setText(c);
		
		JLabel lblCiudad = new JLabel("Destino");
		lblCiudad.setBounds(10, 106, 46, 14);
		contentPane.add(lblCiudad);
		
		Caja2 = new JTextField();
		Caja2.setBounds(10, 124, 86, 20);
		contentPane.add(Caja2);
		Caja2.setColumns(10);
		
		Caja2.setText(d);
		
	}
}
