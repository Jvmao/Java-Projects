import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;

public class nomina extends JFrame {
	//Variables JFrame//
	private JPanel contentPane;
	private JLabel JLabelTitulo,JLabelSalario,JLabelComp,JLabelHoras,
	JLabelOComp,JLabelPagas,JLabelCotizaciones,JLabelContigencias,
	JLabelDesempleo,JLabelFP,JLabelHorasExt,JLabelIRPF,JLabelCotizIRPF,JLabelDevengos,
	JLabelDeducciones,JLabelTotal;
	private JTextField JTextSalario,JTextComp,JTextHoras,
	JTextBCC,JTextOComp,JTextContingencias,JTextDesempleo,JTextFP,
	JTextHorasExt,JTextIRPF,JTextDeduccionesSS,JTextBCP,JTextDevengos,
	JTextDeducciones,JTextTotal;
	private JButton JButtonBCC,JButtonBCP,JButtonCotizacionSS,JButtonIRPF,
	JButtonTotal;
	private JSeparator separador1,separador2,separador3,separador4,separador5;
	private JComboBox JComboPagas,JComboIRPF;
	
	private int i;
	private int j;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nomina frame = new nomina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public nomina() {
		setTitle("MiNomina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 671);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Etiqueta Título//
		JLabelTitulo = new JLabel("N\u00D3MINA TRABAJADOR");
		JLabelTitulo.setBounds(5, 5, 523, 16);
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
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(JTextSalario.getText().length()==15) e.consume();
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
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(JTextSalario.getText().length()==10) e.consume();
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
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(JTextSalario.getText().length()==5) e.consume();
			}
		});
		JTextHoras.setBounds(171, 89, 86, 20);
		JTextHoras.setColumns(10);
		contentPane.add(JTextHoras);
		
		//Botón para Calcular Devengo//
		JButtonBCC = new JButton("BCC");
		JButtonBCC.setBounds(171, 129, 185, 21);
		JButtonBCC.addActionListener(new innerAL()); //Añadimos el ActionListener desde la InnerClass//
		contentPane.add(JButtonBCC);
		
		//Campo de Texto Devengo//
		JTextBCC = new JTextField();
		JTextBCC.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		JTextBCC.setHorizontalAlignment(SwingConstants.CENTER);
		JTextBCC.setBounds(374, 129, 144, 20);
		JTextBCC.setBackground(new Color(153, 255, 255));
		JTextBCC.setColumns(10);
		contentPane.add(JTextBCC);
		
		//Separador 1//
		separador1 = new JSeparator();
		separador1.setBounds(15, 115, 503, 8);
		contentPane.add(separador1);
		
		//Etiqueta Deducciones//
		JLabelCotizaciones = new JLabel("COTIZACIONES SS");
		JLabelCotizaciones.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		JComboPagas = new JComboBox();
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
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(JTextSalario.getText().length()==5) e.consume();
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
		JButtonBCP.setBounds(171, 156, 185, 23);
		contentPane.add(JButtonBCP);
		JButtonBCP.addActionListener(new innerAL());
		//Campo de Texto BCP//
		JTextBCP = new JTextField();
		JTextBCP.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		JTextBCP.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				//LIMITAMOS EL TAMAÑO DEL TEXTO A 15 CARÁCTERES//
				if(JTextSalario.getText().length()==8) e.consume();
			}
		});
		JTextBCP.setHorizontalAlignment(SwingConstants.CENTER);
		JTextBCP.setBackground(new Color(153, 255, 255));
		JTextBCP.setBounds(374, 157, 144, 20);
		contentPane.add(JTextBCP);
		JTextBCP.setColumns(10);
		
		//Botón Deducciones//
		JButtonCotizacionSS = new JButton("COTIZACIONES SS");
		JButtonCotizacionSS.setBounds(171, 297, 185, 23);
		contentPane.add(JButtonCotizacionSS);
		JButtonCotizacionSS.addActionListener(new innerAL2());
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
		JLabelCotizIRPF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelCotizIRPF.setBounds(15, 370, 152, 14);
		contentPane.add(JLabelCotizIRPF);
		
		//Etiqueta IRPF//
		JLabelIRPF = new JLabel("IRPF");
		JLabelIRPF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JLabelIRPF.setBounds(25, 398, 128, 14);
		contentPane.add(JLabelIRPF);
		
		//Combo porcentajes IRPF//
		JComboIRPF = new JComboBox();
		JComboIRPF.setBounds(171, 394, 185, 20);
		contentPane.add(JComboIRPF);
		for(j=0;j<31;j++){
			JComboIRPF.addItem(j);
		}
		
		//Botón IRPF//
		JButtonIRPF = new JButton("COTIZACIONES IRPF");
		JButtonIRPF.setBounds(171, 432, 185, 23);
		contentPane.add(JButtonIRPF);
		JButtonIRPF.addActionListener(new innerAL2());
		
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
		JLabelTotal.setFont(new Font("Postino Std", Font.PLAIN, 15));
		JLabelTotal.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelTotal.setBounds(10, 562, 518, 21);
		contentPane.add(JLabelTotal);
		
		//JButton Total//
		JButtonTotal = new JButton("TOTAL");
		JButtonTotal.setFont(new Font("Rockwell", Font.BOLD, 18));
		JButtonTotal.setBounds(15, 584, 152, 37);
		contentPane.add(JButtonTotal);
		JButtonTotal.addActionListener(new innerAL2());
		//Campo de Texto Total//
		JTextTotal = new JTextField();
		JTextTotal.setHorizontalAlignment(SwingConstants.CENTER);
		JTextTotal.setFont(new Font("Myriad Pro Light SemiCond", Font.BOLD, 18));
		JTextTotal.setEditable(false);
		JTextTotal.setBounds(384, 584, 134, 37);
		contentPane.add(JTextTotal);
		JTextTotal.setColumns(10);
		
	}
	
	private class innerAL implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == JButtonBCC){
				//Definimos las Variables de las Operaciones dentro del ActionListener//
				DecimalFormat decimal = new DecimalFormat("0.00");
				double sb = Double.parseDouble(JTextSalario.getText());
				double comp = Double.parseDouble(JTextComp.getText()) ;
				double Ocomp = Double.parseDouble(JTextOComp.getText());
				double pagas = ((Double.parseDouble(JComboPagas.getSelectedItem().toString())+sb)/12);
				String BCC = decimal.format(sb+comp+Ocomp+pagas);
				String valorBCC = ((BCC));
				
				//Realiza la operación y saca el resultado en el campo de texto//
				JTextBCC.setText(valorBCC);
				
			}else if(e.getSource() == JButtonBCP){
				DecimalFormat decimal = new DecimalFormat("0.00");
				double sb = Double.parseDouble(JTextSalario.getText());
				double comp = Double.parseDouble(JTextComp.getText()) ;
				double Ocomp = Double.parseDouble(JTextOComp.getText());
				double pagas = ((Double.parseDouble(JComboPagas.getSelectedItem().toString())+sb)/12);
				double BCC = sb+comp+Ocomp+pagas;
				double horas = Double.parseDouble(JTextHoras.getText());
				double BCP = BCC + horas;
				String valorBCP = Double.toString(BCP);
				
				JTextBCP.setText(valorBCP);
			}
			
		}
		
	}
	
	private class innerAL2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==JButtonCotizacionSS){
				
				//Variables Nómina//
				double sb = Double.parseDouble(JTextSalario.getText());
				double comp = Double.parseDouble(JTextComp.getText()) ;
				double Ocomp = Double.parseDouble(JTextOComp.getText());
				double pagas = ((Double.parseDouble(JComboPagas.getSelectedItem().toString())+sb)/12);
				double BCC = sb+comp+Ocomp+pagas;
				double horas = Double.parseDouble(JTextHoras.getText());
				double BCP = BCC + horas;
				String valorBCC = Double.toString(BCC);
				String valorBCP = Double.toString(BCP);
				
				//Operaciones SS//
				double contingencias = (BCC*0.047);
				double desempleo = BCP*0.015;
				double formacion = BCP*0.001;
				double horaext = horas*0.047;
				double cotizSS = contingencias+desempleo+formacion+horaext;
				
				JTextContingencias.setText(Double.valueOf(contingencias).toString());
				JTextDesempleo.setText(Double.valueOf(desempleo).toString());
				JTextFP.setText(Double.valueOf(formacion).toString());
				JTextHorasExt.setText(Double.valueOf(horaext).toString());
				JTextDeduccionesSS.setText(Double.valueOf(cotizSS).toString());		
				
			}else if(e.getSource()==JButtonIRPF){
				
				//Variables Nómina//
				double sb = Double.parseDouble(JTextSalario.getText());
				double comp = Double.parseDouble(JTextComp.getText()) ;
				double Ocomp = Double.parseDouble(JTextOComp.getText());
				double pagas = ((Double.parseDouble(JComboPagas.getSelectedItem().toString())+sb)/12);
				double BCC = sb+comp+Ocomp+pagas;
				double horas = Double.parseDouble(JTextHoras.getText());
				double BCP = BCC + horas;
				String valorBCC = Double.toString(BCC);
				String valorBCP = Double.toString(BCP);
				
				//Operaciones SS//
				double contingencias = (BCC*0.047);
				double desempleo = BCP*0.015;
				double formacion = BCP*0.001;
				double horaext = horas*0.047;
				double cotizSS = contingencias+desempleo+formacion+horaext;
				
				JTextContingencias.setText(Double.valueOf(contingencias).toString());
				JTextDesempleo.setText(Double.valueOf(desempleo).toString());
				JTextFP.setText(Double.valueOf(formacion).toString());
				JTextHorasExt.setText(Double.valueOf(horaext).toString());
				JTextDeduccionesSS.setText(Double.valueOf(cotizSS).toString());		
				//Operaciones IRPF//
				double totalIRPF = sb + comp + Ocomp + horas;
				double cotizIrpf = ((Double.parseDouble(JComboIRPF.getSelectedItem().toString())/100)*totalIRPF);
				JTextIRPF.setText(Double.valueOf(cotizIrpf).toString());
				
				
			}else if(e.getSource()==JButtonTotal){
				//Variables Nómina//
				double sb = Double.parseDouble(JTextSalario.getText());
				double comp = Double.parseDouble(JTextComp.getText()) ;
				double Ocomp = Double.parseDouble(JTextOComp.getText());
				double pagas = ((Double.parseDouble(JComboPagas.getSelectedItem().toString())+sb)/12);
				double BCC = sb+comp+Ocomp+pagas;
				double horas = Double.parseDouble(JTextHoras.getText());
				double BCP = BCC + horas;
				String valorBCC = Double.toString(BCC);
				String valorBCP = Double.toString(BCP);
				
				//Operaciones SS//
				double contingencias = (BCC*0.047);
				double desempleo = BCP*0.015;
				double formacion = BCP*0.001;
				double horaext = horas*0.047;
				double cotizSS = contingencias+desempleo+formacion+horaext;
				
				JTextContingencias.setText(Double.valueOf(contingencias).toString());
				JTextDesempleo.setText(Double.valueOf(desempleo).toString());
				JTextFP.setText(Double.valueOf(formacion).toString());
				JTextHorasExt.setText(Double.valueOf(horaext).toString());
				JTextDeduccionesSS.setText(Double.valueOf(cotizSS).toString());		
				
				//Operaciones IRPF//
				double totalIRPF = sb + comp + Ocomp + horas;
				double cotizIrpf = ((Double.parseDouble(JComboIRPF.getSelectedItem().toString())/100)*totalIRPF);
				JTextIRPF.setText(Double.valueOf(cotizIrpf).toString());
				
				//Operaciones Devengos//
				double deducciones = cotizSS + cotizIrpf;
				JTextDevengos.setText(Double.valueOf(totalIRPF).toString());
				JTextDeducciones.setText(Double.valueOf(deducciones).toString());
				
				//Operación Final//
				double total = totalIRPF - deducciones;
				JTextTotal.setText(Double.valueOf(total).toString());
			}
		}
	}
	

}
