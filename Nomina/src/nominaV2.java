import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;


public class nominaV2 extends JFrame {

	private JPanel contentPane;

	//Variables JFrame//
	private JLabel JLabelTitulo,JLabelSalario,JLabelComp,JLabelHoras,
	JLabelOComp,JLabelPagas,JLabelCotizaciones,JLabelContigencias,
	JLabelDesempleo,JLabelFP,JLabelHorasExt,JLabelIRPF,JLabelCotizIRPF,JLabelDevengos,
	JLabelDeducciones,JLabelTotal;
	private JTextField JTextSalario,JTextComp,JTextHoras,
	JTextBCC,JTextOComp,JTextContingencias,JTextDesempleo,JTextFP,
	JTextHorasExt,JTextIRPF,JTextDeduccionesSS,JTextBCP,JTextDevengos,
	JTextDeducciones,JTextTotal;
	private JButton JButtonBCC,JButtonBCP,JButtonCotizacionSS,JButtonIRPF,
	JButtonTotal,JButtonReiniciar,JButtonSalir;
	private JSeparator separador1,separador2,separador3,separador4,separador5;
	private JComboBox<Integer> JComboPagas,JComboIRPF;
	
	//Variables JComboBox//
	private int i;
	private int j;
	
	//Variables Nómina//
	private DecimalFormat decimal = new DecimalFormat("0.00");
	private double sb;
	private double comp;
	private double Ocomp;
	private double pagas;
	private double BCC;
	private String valorBCC;
	private double horas;
	private double BCP;
	private String valorBCP;
	
	//Operaciones SS//
	private double contingencias;
	private double desempleo;
	private double formacion;
	private double horaext;
	private double cotizSS;
	
	//Operaciones IRPF//
	private double totalDevengos;
	private double cotizIrpf;
	
	//Operaciones Devengos, Deducciones y Total//
	double deducciones;
	double total;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nominaV2 frame = new nominaV2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public nominaV2() {
		setFont(new Font("Lucida Console", Font.BOLD, 13));
		setForeground(Color.DARK_GRAY);
		setTitle("PAYROLL 3.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage(nominaV2.class.getResource("/imagenes/id-card.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 712);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Etiqueta Título//
		JLabelTitulo = new JLabel("N\u00D3MINA TRABAJADOR");
		JLabelTitulo.setBounds(10, 0, 523, 16);
		JLabelTitulo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		JLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(JLabelTitulo);
				
		//Etiqueta Salario//
		JLabelSalario = new JLabel("SALARIO BASE");
		JLabelSalario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelSalario.setBounds(15, 30, 152, 14);
		JLabelSalario.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(JLabelSalario);
		//Campo Texto Salario//
		JTextSalario = new JTextField();
		JTextSalario.setFont(new Font("Tahoma", Font.BOLD, 11));
		JTextSalario.setBackground(new Color(204, 204, 255));
		JTextSalario.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				//SOLO ADMITE NÚMEROS Y PUNTOS PARA LOS DECIMALES//
				char c = e.getKeyChar();
				if((c < '0' || c > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 10 CARÁCTERES//
				if(JTextSalario.getText().length()==10) e.consume();
					}
				});
		JTextSalario.setBounds(171, 27, 86, 20);
		JTextSalario.setColumns(10);
		contentPane.add(JTextSalario);
				
		//Etiqueta Complementos//
		JLabelComp = new JLabel("COMPLEMENTO SALARIALES");
		JLabelComp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelComp.setBounds(15, 61, 152, 14);
		contentPane.add(JLabelComp);
		//Campo de Texto Complementos//
		JTextComp = new JTextField();
		JTextComp.setFont(new Font("Tahoma", Font.BOLD, 11));
		JTextComp.setBackground(new Color(204, 204, 255));
		JTextComp.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				//SOLO ADMITE NÚMEROS Y PUNTOS PARA LOS DECIMALES//
				char c = e.getKeyChar();
				if((c < '0' || c > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 5 CARÁCTERES//
				if(JTextComp.getText().length()==5) e.consume();
					}
				});
		JTextComp.setBounds(171, 58, 86, 20);
		JTextComp.setColumns(10);
		contentPane.add(JTextComp);

				
		//Etiqueta Horas//
		JLabelHoras = new JLabel("HORAS EXTRAS");
		JLabelHoras.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelHoras.setBounds(15, 92, 152, 14);
		contentPane.add(JLabelHoras);
		//Campo de Texto Horas//
		JTextHoras = new JTextField();
		JTextHoras.setFont(new Font("Tahoma", Font.BOLD, 11));
		JTextHoras.setBackground(new Color(204, 204, 255));
		JTextHoras.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				//SOLO ADMITE NÚMEROS Y PUNTOS PARA LOS DECIMALES//
				char c = e.getKeyChar();
				if((c < '0' || c > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 5 CARÁCTERES//
				if(JTextHoras.getText().length()==5) e.consume();
					}
				});
		JTextHoras.setBounds(171, 89, 86, 20);
		JTextHoras.setColumns(10);
		contentPane.add(JTextHoras);
				
		//Botón para Calcular Devengo//
		JButtonBCC = new JButton("BCC");
		JButtonBCC.setBounds(171, 129, 185, 25);
		contentPane.add(JButtonBCC);
		JButtonBCC.addActionListener(new innerAL());
				
		//Campo de Texto Devengo//
		JTextBCC = new JTextField();
		JTextBCC.setEditable(false);
		JTextBCC.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		JTextBCC.setHorizontalAlignment(SwingConstants.CENTER);
		JTextBCC.setBounds(374, 129, 144, 25);
		JTextBCC.setBackground(new Color(153, 255, 255));
		JTextBCC.setColumns(10);
		contentPane.add(JTextBCC);
				
		//Separador 1//
		separador1 = new JSeparator();
		separador1.setBounds(15, 115, 503, 8);
		contentPane.add(separador1);
				
		//Etiqueta Deducciones//
		JLabelCotizaciones = new JLabel("COTIZACIONES SS");
		JLabelCotizaciones.setFont(new Font("Tahoma", Font.BOLD, 10));
		JLabelCotizaciones.setBounds(15, 197, 152, 14);
		contentPane.add(JLabelCotizaciones);
				
		//Etiquetas Contigencias//
		JLabelContigencias = new JLabel("Contigencias Comunes");
		JLabelContigencias.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelContigencias.setBounds(25, 222, 131, 14);
		contentPane.add(JLabelContigencias);
		//Campo de Texto Contingencias//
		JTextContingencias = new JTextField();
		JTextContingencias.setEditable(false);
		JTextContingencias.setBounds(171, 219, 86, 20);
		JTextContingencias.setColumns(10);
		contentPane.add(JTextContingencias);
				
		//Etiqueta Label//
		JLabelPagas = new JLabel("PAGAS EXTRAS");
		JLabelPagas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelPagas.setBounds(267, 61, 155, 14);
		contentPane.add(JLabelPagas);
				
		//Etiqueta Desplegable Pagas Extras//
		JComboPagas = new JComboBox<Integer>();
		JComboPagas.setBounds(432, 58, 86, 20);
		contentPane.add(JComboPagas);
			for(i=0;i<13;i++){
				JComboPagas.addItem(i);
			}
				
		//Etiqueta Otros Componentes//
		JLabelOComp = new JLabel("OTROS COMPLEMENTOS");
		JLabelOComp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelOComp.setBounds(267, 30, 155, 14);
		contentPane.add(JLabelOComp);
		//Campo de Texto Otros Componentes//
		JTextOComp = new JTextField();
		JTextOComp.setFont(new Font("Tahoma", Font.BOLD, 11));
		JTextOComp.setBackground(new Color(204, 204, 255));
		JTextOComp.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				//SOLO ADMITE NÚMEROS Y PUNTOS PARA LOS DECIMALES//
				char c = e.getKeyChar();
				if((c < '0' || c > '9')) e.consume();
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 5 CARÁCTERES//
				if(JTextOComp.getText().length()==5) e.consume();
					}
				});
		JTextOComp.setBounds(432, 27, 86, 20);
		JTextOComp.setColumns(10);
				contentPane.add(JTextOComp);
				
		//Etiqueta Desempleo//
		JLabelDesempleo = new JLabel("Desempleo");
		JLabelDesempleo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelDesempleo.setBounds(25, 253, 131, 14);
		contentPane.add(JLabelDesempleo);
		//Campo de Texto Desempleo//
		JTextDesempleo = new JTextField();
		JTextDesempleo.setEditable(false);
		JTextDesempleo.setBounds(171, 250, 86, 20);
		contentPane.add(JTextDesempleo);
		JTextDesempleo.setColumns(10);
				
		//Etiqueta FP//
		JLabelFP = new JLabel("Formaci\u00F3n Profesional");
		JLabelFP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelFP.setBounds(294, 222, 128, 14);
		contentPane.add(JLabelFP);
		//Campo de Texto FP//
		JTextFP = new JTextField();
		JTextFP.setEditable(false);
		JTextFP.setBounds(432, 219, 86, 20);
		contentPane.add(JTextFP);
		JTextFP.setColumns(10);
				
		//Etiqueta Cotización Horas Extras//
		JLabelHorasExt = new JLabel("Horas Extras");
		JLabelHorasExt.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelHorasExt.setBounds(294, 253, 128, 14);
		contentPane.add(JLabelHorasExt);
		//Campo de Texto Cotización Horas Extras//
		JTextHorasExt = new JTextField();
		JTextHorasExt.setEditable(false);
		JTextHorasExt.setBounds(432, 250, 86, 20);
		contentPane.add(JTextHorasExt);
		JTextHorasExt.setColumns(10);
				
		//Separador 2//
		separador2 = new JSeparator();
		separador2.setBounds(15, 278, 503, 8);
		contentPane.add(separador2);
				
				
		//Botón BCP//
		JButtonBCP = new JButton("BCP");
		JButtonBCP.setEnabled(false);
		JButtonBCP.setBounds(171, 163, 185, 25);
		contentPane.add(JButtonBCP);
		JButtonBCP.addActionListener(new innerAL());
		//Campo de Texto BCP//
		JTextBCP = new JTextField();
		JTextBCP.setEditable(false);
		JTextBCP.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		JTextBCP.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
					//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
					if(JTextSalario.getText().length()==8) e.consume();
				}
			});
		JTextBCP.setHorizontalAlignment(SwingConstants.CENTER);
		JTextBCP.setBackground(new Color(153, 255, 255));
		JTextBCP.setBounds(374, 163, 144, 25);
		contentPane.add(JTextBCP);
		JTextBCP.setColumns(10);
				
		//Botón Deducciones//
		JButtonCotizacionSS = new JButton("COTIZACIONES SS");
		JButtonCotizacionSS.setEnabled(false);
		JButtonCotizacionSS.setBounds(171, 297, 185, 23);
		contentPane.add(JButtonCotizacionSS);
		JButtonCotizacionSS.addActionListener(new innerAL());

		//Campo de Texto Deducciones//
		JTextDeduccionesSS = new JTextField();
		JTextDeduccionesSS.setHorizontalAlignment(SwingConstants.CENTER);
		JTextDeduccionesSS.setEditable(false);
		JTextDeduccionesSS.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		JTextDeduccionesSS.setBackground(new Color(255, 255, 102));
		JTextDeduccionesSS.setBounds(384, 297, 134, 21);
		contentPane.add(JTextDeduccionesSS);
		JTextDeduccionesSS.setColumns(10);
				
		//Separador 3//
		separador3 = new JSeparator();
		separador3.setBounds(15, 417, 513, 16);
		contentPane.add(separador3);
		//Etiqueta cotizaciones IRPF//
		JLabelCotizIRPF = new JLabel("COTIZACIONES IRPF");
		JLabelCotizIRPF.setFont(new Font("Tahoma", Font.BOLD, 10));
		JLabelCotizIRPF.setBounds(15, 370, 152, 14);
		contentPane.add(JLabelCotizIRPF);
				
		//Etiqueta IRPF//
		JLabelIRPF = new JLabel("IRPF");
		JLabelIRPF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelIRPF.setBounds(25, 398, 128, 14);
		contentPane.add(JLabelIRPF);
				
		//Combo porcentajes IRPF//
		JComboIRPF = new JComboBox<Integer>();
		JComboIRPF.setBounds(171, 394, 185, 20);
		contentPane.add(JComboIRPF);
			for(j=0;j<31;j++){
				JComboIRPF.addItem(j);
			}
				
		//Botón IRPF//
		JButtonIRPF = new JButton("COTIZACIONES IRPF");
		JButtonIRPF.setEnabled(false);
		JButtonIRPF.setBounds(171, 432, 185, 23);
		contentPane.add(JButtonIRPF);
		JButtonIRPF.addActionListener(new innerAL());
				
		//Campo de Texto IRPF//
		JTextIRPF = new JTextField();
		JTextIRPF.setBackground(new Color(255, 255, 102));
		JTextIRPF.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		JTextIRPF.setEditable(false);
		JTextIRPF.setHorizontalAlignment(SwingConstants.CENTER);
		JTextIRPF.setBounds(384, 433, 134, 20);
		contentPane.add(JTextIRPF);
		JTextIRPF.setColumns(10);
				
		//Separador 4//
		separador4 = new JSeparator();
		separador4.setBounds(15, 463, 513, 8);
		contentPane.add(separador4);
				
		//Etiqueta Devengos//
		JLabelDevengos = new JLabel("DEVENGOS");
		JLabelDevengos.setFont(new Font("Tahoma", Font.BOLD, 11));
		JLabelDevengos.setBounds(15, 482, 152, 21);
		contentPane.add(JLabelDevengos);
		//Campo de Texto Devengos//
		JTextDevengos = new JTextField();
		JTextDevengos.setBackground(new Color(255, 204, 255));
		JTextDevengos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		JTextDevengos.setHorizontalAlignment(SwingConstants.CENTER);
		JTextDevengos.setEditable(false);
		JTextDevengos.setBounds(171, 482, 185, 20);
		contentPane.add(JTextDevengos);
		JTextDevengos.setColumns(10);
				
		//Etiqueta Deducciones//
		JLabelDeducciones = new JLabel("DEDUCCIONES");
		JLabelDeducciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		JLabelDeducciones.setBounds(15, 514, 138, 25);
		contentPane.add(JLabelDeducciones);
		//Campo de Texto Deducciones//
		JTextDeducciones = new JTextField();
		JTextDeducciones.setBackground(new Color(255, 204, 255));
		JTextDeducciones.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		JTextDeducciones.setHorizontalAlignment(SwingConstants.CENTER);
		JTextDeducciones.setEditable(false);
		JTextDeducciones.setBounds(171, 516, 185, 20);
		contentPane.add(JTextDeducciones);
		JTextDeducciones.setColumns(10);
				
		//Separador 5//
		separador5 = new JSeparator();
		separador5.setBounds(15, 550, 513, 14);
		contentPane.add(separador5);
				
		//Etiqueta Total//
		JLabelTotal = new JLabel("TOTAL A PERCIBIR");
		JLabelTotal.setForeground(new Color(0, 0, 139));
		JLabelTotal.setFont(new Font("Postino Std", Font.PLAIN, 15));
		JLabelTotal.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelTotal.setBounds(10, 562, 518, 21);
		contentPane.add(JLabelTotal);
				
		//JButton Total//
		JButtonTotal = new JButton("TOTAL");
		JButtonTotal.setToolTipText("TOTAL");
		JButtonTotal.setEnabled(false);
		JButtonTotal.setFont(new Font("Rockwell", Font.BOLD, 18));
		JButtonTotal.setBounds(10, 594, 157, 37);
		contentPane.add(JButtonTotal);
		JButtonTotal.addActionListener(new innerAL());
				
		//Campo de Texto Total//
		JTextTotal = new JTextField();
		JTextTotal.setBackground(new Color(255, 102, 51));
		JTextTotal.setHorizontalAlignment(SwingConstants.CENTER);
		JTextTotal.setFont(new Font("Myriad Pro Light SemiCond", Font.BOLD, 20));
		JTextTotal.setEditable(false);
		JTextTotal.setBounds(384, 594, 134, 37);
		contentPane.add(JTextTotal);
		JTextTotal.setColumns(10);
		
		//Botón para reiniciar la Aplicación//
		JButtonReiniciar = new JButton("");
		JButtonReiniciar.setIcon(new ImageIcon(nominaV2.class.getResource("/imagenes/signoption.png")));
		JButtonReiniciar.setToolTipText("REINICIAR");
		JButtonReiniciar.setBounds(10, 642, 66, 31);
		contentPane.add(JButtonReiniciar);
		JButtonReiniciar.addActionListener(new innerAL());
		
		//Botón para Salir de la Aplicación//
		JButtonSalir = new JButton("");
		JButtonSalir.setIcon(new ImageIcon(nominaV2.class.getResource("/imagenes/power-button24.png")));
		JButtonSalir.setBounds(452, 642, 66, 31);
		contentPane.add(JButtonSalir);
		JButtonSalir.addActionListener(new innerAL());
		JButtonSalir.setToolTipText("SALIR");
	}
	
	//Método para Calcular BCC//
	public void bcc(){
		sb = Double.parseDouble(JTextSalario.getText());
		comp = Double.parseDouble(JTextComp.getText()) ;
		Ocomp = Double.parseDouble(JTextOComp.getText());
		pagas = ((Double.parseDouble(JComboPagas.getSelectedItem().toString())*sb)/12);
		BCC = sb+comp+Ocomp+pagas;
		valorBCC = Double.toString(BCC);
	}
	
	//Método para Calcular BCP//
	public void bcp(){
		horas = Double.parseDouble(JTextHoras.getText());
		BCP = (BCC + horas);
		valorBCP = Double.toString(BCP);
	}
	
	//Método para Calcular Deducciones Seguridad Social//
	public void cotizSS(){
		contingencias = BCC*0.047;
		desempleo = BCP*0.015;
		formacion = BCP*0.001;
		horaext = horas*0.047;
		cotizSS = contingencias+desempleo+formacion+horaext;
	}
	
	//Método para Calcular las Deducciones de IRPF//
	public void cotizIRPF(){
		totalDevengos = sb + comp + Ocomp + horas;
		cotizIrpf = ((Double.parseDouble(JComboIRPF.getSelectedItem().toString())/100)*totalDevengos);
	}
	
	//Método para Calcular el total de los Devengos y Deducciones y el Total a Percibir//
	public void total(){
		totalDevengos = sb + comp + Ocomp + horas;
		deducciones = cotizSS + cotizIrpf;
		total = totalDevengos - deducciones;
	}
	
	//Método para Reiniciar todos los Campos//
	public void reiniciar(){
		JTextSalario.setText("");
		JTextComp.setText("");
		JTextHoras.setText("");
		JTextBCC.setText("");
		JTextOComp.setText("");
		JTextContingencias.setText("");
		JTextDesempleo.setText("");
		JTextFP.setText("");
		JTextHorasExt.setText("");
		JTextIRPF.setText("");
		JTextDeduccionesSS.setText("");
		JTextBCP.setText("");
		JTextDevengos.setText("");
		JTextDeducciones.setText("");
		JTextTotal.setText("");
		JButtonBCP.setEnabled(false);
		JButtonCotizacionSS.setEnabled(false);
		JButtonIRPF.setEnabled(false);
		JButtonTotal.setEnabled(false);
	}
	
	//Definimos el Action Listener desde la Inner Class//
	private class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==JButtonBCC){
				bcc();
				JTextBCC.setText(valorBCC);
				System.out.println("Valor BCC: "+valorBCC);
				JButtonBCP.setEnabled(true);
			}else if(e.getSource()== JButtonBCP){
				bcp();
				JTextBCP.setText(valorBCP);
				System.out.println("Valor BCP: "+valorBCP);
				JButtonCotizacionSS.setEnabled(true);
			}else if(e.getSource()== JButtonCotizacionSS){
				cotizSS();
				JTextContingencias.setText(Double.valueOf(contingencias).toString());
				System.out.println("Contingencias: "+contingencias);
				JTextDesempleo.setText(Double.valueOf(desempleo).toString());
				System.out.println("Desempleo: "+desempleo);
				JTextFP.setText(Double.valueOf(formacion).toString());
				System.out.println("FP: "+formacion);
				JTextHorasExt.setText(Double.valueOf(horaext).toString());
				System.out.println("Horas Extras: "+horaext);
				JTextDeduccionesSS.setText(Double.valueOf(cotizSS).toString());
				System.out.println("Total Cotizaciones SS: "+cotizSS);
				JButtonIRPF.setEnabled(true);
			}else if(e.getSource()==JButtonIRPF){
				cotizIRPF();
				JTextIRPF.setText(Double.valueOf(cotizIrpf).toString());
				System.out.println("Total Cotizaciones IRPF: "+cotizIrpf);
				JButtonTotal.setEnabled(true);
			}else if(e.getSource()==JButtonTotal){
				total();
				JTextDevengos.setText(Double.valueOf(totalDevengos).toString());
				JTextDeducciones.setText(Double.valueOf(deducciones).toString());
				JTextTotal.setText(Double.valueOf(total).toString());
				System.out.println("Total Devengos: "+totalDevengos);
				System.out.println("Total Deducciones: "+deducciones);
				System.out.println("TOTAL A PERCIBIR: "+total);
			}else if(e.getSource()==JButtonReiniciar){
				reiniciar();
			}else if(e.getSource()==JButtonSalir){
				System.exit(0);
			}
		}
		
	}
}
