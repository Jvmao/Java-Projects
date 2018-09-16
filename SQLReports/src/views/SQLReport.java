package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.ClientDB;
import controller.SQLServerConnection;
import model.Client;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.Toolkit;


public class SQLReport extends JFrame {
	//Variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRegister,btnAddProduct,btnDeleteProduct,btnInvoice,btnGenPdf,btnRestart,btnExit;
	private JLabel lbTitle1,lbClientData,lbProductMng,lbInvoice,lbName,lbLastname,lbCountry,lbCity,lbTelephone,lbEmail;
	private JTextField txName,txLastName,txCity,txTel,txMail,txCode,txProduct,txPrice,txAmount,txTotal,txCode2;
	private JComboBox<String> cbCountry,cbProduct;
	private JScrollPane scrollPane;
	private JLabel lbProduct,lbProd,lbPrice,lbAmount,lbVat,lbPer,lbTotal;
	private JTable tableProduct;

	private SQLServerConnection sdb;
	private ClientDB cdb;
	private Connection conn;
	private boolean connected = false;
	private String server = "jdbc:sqlserver://yourservername;databaseName=yourDBname";
	private String user = "user";
    private String pass = "pass";
    
    //Variables to increment code in JTable//
  	private static int code = 1000;
  	private static int client = ++code;
  	
  	private static HttpServletResponse response;
  	private Client c = new Client();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SQLReport frame = new SQLReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	@SuppressWarnings("serial")
	public SQLReport() {
		setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		setTitle("VIRTUAL COMMERCE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SQLReport.class.getResource("/imgs/Android-iconx32.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			//Using Windows Look and Feel
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		//Label Title 1
		lbTitle1 = new JLabel("INVOICE PROJECT");
		lbTitle1.setForeground(new Color(0, 128, 128));
		lbTitle1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lbTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle1.setBounds(10, 11, 684, 20);
		contentPane.add(lbTitle1);
		//Label Client Data
		lbClientData = new JLabel("CLIENT DATA");
		lbClientData.setFont(new Font("Verdana", Font.BOLD, 12));
		lbClientData.setHorizontalAlignment(SwingConstants.CENTER);
		lbClientData.setBounds(10, 36, 145, 14);
		contentPane.add(lbClientData);
		//Label Product Management
		lbProductMng = new JLabel("PRODUCT MANAGEMENT");
		lbProductMng.setForeground(new Color(0, 0, 205));
		lbProductMng.setFont(new Font("Verdana", Font.PLAIN, 12));
		lbProductMng.setHorizontalAlignment(SwingConstants.CENTER);
		lbProductMng.setBounds(176, 36, 354, 14);
		contentPane.add(lbProductMng);
		//Label Invoice
		lbInvoice = new JLabel("INVOICE");
		lbInvoice.setFont(new Font("Verdana", Font.BOLD, 12));
		lbInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lbInvoice.setBounds(553, 36, 141, 14);
		contentPane.add(lbInvoice);
		//Label Name
		lbName = new JLabel("Name");
		lbName.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setBounds(10, 71, 145, 14);
		contentPane.add(lbName);
		//Label Last Name
		lbLastname = new JLabel("Last Name");
		lbLastname.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbLastname.setHorizontalAlignment(SwingConstants.CENTER);
		lbLastname.setBounds(10, 127, 145, 14);
		contentPane.add(lbLastname);
		//Label Country
		lbCountry = new JLabel("Country");
		lbCountry.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbCountry.setHorizontalAlignment(SwingConstants.CENTER);
		lbCountry.setBounds(10, 189, 145, 14);
		contentPane.add(lbCountry);
		//Label City
		lbCity = new JLabel("City");
		lbCity.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbCity.setHorizontalAlignment(SwingConstants.CENTER);
		lbCity.setBounds(10, 245, 145, 14);
		contentPane.add(lbCity);
		//Label Telephone
		lbTelephone = new JLabel("Telephone");
		lbTelephone.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbTelephone.setHorizontalAlignment(SwingConstants.CENTER);
		lbTelephone.setBounds(10, 300, 145, 14);
		contentPane.add(lbTelephone);
		//Label Email
		lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lbEmail.setBounds(10, 351, 145, 14);
		contentPane.add(lbEmail);
		//Text Field Name
		txName = new JTextField();
		txName.setHorizontalAlignment(SwingConstants.CENTER);
		txName.setFont(new Font("Verdana", Font.PLAIN, 11));
		txName.setBounds(10, 96, 145, 20);
		contentPane.add(txName);
		txName.setColumns(10);
		txName.addActionListener(new innerAL());
		//Text Field Last Name
		txLastName = new JTextField();
		txLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txLastName.setFont(new Font("Verdana", Font.PLAIN, 11));
		txLastName.setColumns(10);
		txLastName.setBounds(10, 152, 145, 20);
		contentPane.add(txLastName);
		txLastName.addActionListener(new innerAL());
		//ComboBox Country
		cbCountry = new JComboBox<String>();
		cbCountry.setBackground(Color.WHITE);
		cbCountry.setFont(new Font("Verdana", Font.PLAIN, 11));
		cbCountry.setBounds(10, 214, 145, 20);
		contentPane.add(cbCountry);

		//Text Field City
		txCity = new JTextField();
		txCity.setHorizontalAlignment(SwingConstants.CENTER);
		txCity.setFont(new Font("Verdana", Font.PLAIN, 11));
		txCity.setColumns(10);
		txCity.setBounds(10, 270, 145, 20);
		contentPane.add(txCity);
		txCity.addActionListener(new innerAL());
		//Text Field Telephone
		txTel = new JTextField();
		txTel.setHorizontalAlignment(SwingConstants.CENTER);
		txTel.setFont(new Font("Verdana", Font.PLAIN, 11));
		txTel.setColumns(10);
		txTel.setBounds(10, 325, 145, 20);
		contentPane.add(txTel);
		txTel.addActionListener(new innerAL());
		//Text Field Mail
		txMail = new JTextField();
		txMail.setHorizontalAlignment(SwingConstants.CENTER);
		txMail.setFont(new Font("Verdana", Font.PLAIN, 11));
		txMail.setColumns(10);
		txMail.setBounds(10, 376, 145, 20);
		contentPane.add(txMail);
		txMail.addActionListener(new innerAL());
		
		txCode = new JTextField();
		txCode.setEditable(false);
		txCode.setHorizontalAlignment(SwingConstants.CENTER);
		txCode.setFont(new Font("Verdana", Font.PLAIN, 12));
		txCode.setBounds(10, 407, 145, 20);
		contentPane.add(txCode);
		txCode.setColumns(10);
		//---------------------------------------------------------------------------------------------------------//
		
		//Label Product
		lbProduct = new JLabel("Products List");
		lbProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lbProduct.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbProduct.setBounds(176, 61, 85, 14);
		contentPane.add(lbProduct);
		
		//ComboBox Product
		cbProduct = new JComboBox<String>();
		cbProduct.setEnabled(false);
		cbProduct.setBackground(Color.WHITE);
		cbProduct.setFont(new Font("Verdana", Font.PLAIN, 11));
		cbProduct.setBounds(261, 59, 227, 20);
		contentPane.add(cbProduct);
		cbProduct.addActionListener(new innerAL());
		
		//Label Product
		lbProd = new JLabel("Product");
		lbProd.setHorizontalAlignment(SwingConstants.CENTER);
		lbProd.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbProd.setBounds(176, 94, 85, 14);
		contentPane.add(lbProd);
		
		//Text Field Product
		txProduct = new JTextField();
		txProduct.setEditable(false);
		txProduct.setFont(new Font("Verdana", Font.PLAIN, 12));
		txProduct.setBounds(261, 90, 227, 20);
		contentPane.add(txProduct);
		txProduct.setColumns(10);
		
		//Label Price
		lbPrice = new JLabel("Price");
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrice.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbPrice.setBounds(176, 120, 85, 14);
		contentPane.add(lbPrice);
		
		//Text Field Price
		txPrice = new JTextField();
		txPrice.setEditable(false);
		txPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txPrice.setFont(new Font("Verdana", Font.PLAIN, 11));
		txPrice.setBounds(261, 117, 127, 20);
		contentPane.add(txPrice);
		txPrice.setColumns(10);
		
		//Btn AddProduct to List
		btnAddProduct = new JButton("");
		btnAddProduct.setEnabled(false);
		btnAddProduct.setToolTipText("Add Product to List");
		btnAddProduct.setIcon(new ImageIcon(SQLReport.class.getResource("/imgs/addIcon24.png")));
		btnAddProduct.setBounds(498, 58, 32, 27);
		contentPane.add(btnAddProduct);
		btnAddProduct.addActionListener(new innerAL());
		
		//Button Delete Product to List
		btnDeleteProduct = new JButton("");
		btnDeleteProduct.setEnabled(false);
		btnDeleteProduct.setToolTipText("Delete Product");
		btnDeleteProduct.setIcon(new ImageIcon(SQLReport.class.getResource("/imgs/wrong1x24.png")));
		btnDeleteProduct.setBounds(498, 114, 32, 27);
		contentPane.add(btnDeleteProduct);
		btnDeleteProduct.addActionListener(new innerAL());
		
		//ScrollPane for Table
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 153)));
		scrollPane.setBounds(176, 149, 354, 269);
		contentPane.add(scrollPane);
		
		//Table for Products
		tableProduct = new JTable();
		tableProduct.setModel(new DefaultTableModel(
				new Object[][] {}, new String[] { "ID", "Product", "Price" }) {
		});
		tableProduct.setFont(new Font("Verdana", Font.PLAIN, 12));
		scrollPane.setViewportView(tableProduct);
		
		//--------------------------------------------------------------------------------------------------------------------//
		
		//Label Amount
		lbAmount = new JLabel("Amount");
		lbAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lbAmount.setFont(new Font("Verdana", Font.PLAIN, 12));
		lbAmount.setBounds(553, 71, 141, 14);
		contentPane.add(lbAmount);
		//Text Field Amount
		txAmount = new JTextField();
		txAmount.setEditable(false);
		txAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txAmount.setFont(new Font("Verdana", Font.PLAIN, 12));
		txAmount.setBounds(553, 97, 141, 20);
		contentPane.add(txAmount);
		txAmount.setColumns(10);
		
		//Label VAT
		lbVat = new JLabel("VAT");
		lbVat.setHorizontalAlignment(SwingConstants.CENTER);
		lbVat.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbVat.setBounds(553, 134, 141, 14);
		contentPane.add(lbVat);
		
		lbPer = new JLabel("21%");
		lbPer.setHorizontalAlignment(SwingConstants.CENTER);
		lbPer.setFont(new Font("Verdana", Font.BOLD, 13));
		lbPer.setBounds(553, 156, 141, 19);
		contentPane.add(lbPer);
		//Label Total
		lbTotal = new JLabel("TOTAL");
		lbTotal.setForeground(new Color(255, 0, 51));
		lbTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lbTotal.setFont(new Font("Verdana", Font.BOLD, 12));
		lbTotal.setBounds(553, 218, 141, 14);
		contentPane.add(lbTotal);
		//Text Field Total
		txTotal = new JTextField();
		txTotal.setEditable(false);
		txTotal.setForeground(Color.BLUE);
		txTotal.setFont(new Font("Verdana", Font.BOLD, 12));
		txTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txTotal.setBounds(553, 243, 141, 20);
		contentPane.add(txTotal);
		txTotal.setColumns(10);
		
		txCode2 = new JTextField();
		txCode2.setText("Invoice Code");
		txCode2.setHorizontalAlignment(SwingConstants.CENTER);
		txCode2.setFont(new Font("Verdana", Font.PLAIN, 12));
		txCode2.setEditable(false);
		txCode2.setColumns(10);
		txCode2.setBounds(553, 271, 141, 20);
		contentPane.add(txCode2);
		
		//Button Register User
		btnRegister = new JButton("REGISTER");
		btnRegister.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRegister.setBounds(10, 443, 145, 23);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new innerAL());
		
		//Button Invoice
		btnInvoice = new JButton("INVOICE");
		btnInvoice.setEnabled(false);
		btnInvoice.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnInvoice.setBounds(553, 311, 141, 23);
		contentPane.add(btnInvoice);
		btnInvoice.addActionListener(new innerAL());
		
		//Button Generate PDF
		btnGenPdf = new JButton("GENERATE PDF");
		btnGenPdf.setEnabled(false);
		btnGenPdf.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnGenPdf.setBounds(553, 345, 141, 23);
		contentPane.add(btnGenPdf);
		btnGenPdf.addActionListener(new innerAL());
		
		//Button Restart Application
		btnRestart = new JButton("RESTART");
		btnRestart.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRestart.setBounds(553, 407, 141, 23);
		contentPane.add(btnRestart);
		btnRestart.addActionListener(new innerAL());
		
		//Button Exit 
		btnExit = new JButton("CLOSE");
		btnExit.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnExit.setBounds(553, 443, 141, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new innerAL());
		//--------------------------------------------------------------------------------------------------------------//
		
		listCountries(); //List all countries from database
		listProducts(); //List all products from database
		getCode();
		getConnection(); //Connection to DB
	}
	
	//Method for Connecting
	public void getConnection() {
		sdb = new SQLServerConnection();
		connected = sdb.SQLServerDB();
		conn = SQLServerConnection.getConnection();
		cdb = new ClientDB(conn);
		if (connected == false) {
			System.out.println("Connected to SQL SERVER");
		} else {
			System.out.println("No Connected");
		}
	}
	
	//Method to List Countries in comboBox from DB
	public void listCountries() {
		try {
			conn = DriverManager.getConnection(server, user, pass);
			Statement st = conn.createStatement();
			String query = "SELECT country_name FROM apps_countries ORDER BY country_name ASC";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				cbCountry.addItem(rs.getString("country_name"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Failed to Connect to Database to show Countries","Error Connection", JOptionPane.WARNING_MESSAGE); 
		}
	}
	
	//Method to List Products in comboBox from DB
	public void listProducts() {
		try {
			conn = DriverManager.getConnection(server, user, pass);
			Statement st = conn.createStatement();
			String query = "select name_product from products ORDER BY name_product ASC";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				cbProduct.addItem(rs.getString("name_product"));
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Failed to Connect to Database to show Products","Error Connection", JOptionPane.WARNING_MESSAGE); 
		}
	}
	
	//Method to Show Price from selected item
	public void getPrice() {
		try {
			conn = DriverManager.getConnection(server, user, pass);
			Statement st = conn.createStatement();
			String query = "select price_product from products where name_product='"+txProduct.getText().toString()+"' ";
			ResultSet rs = st.executeQuery(query);
	
			while(rs.next()) {
				String price = rs.getString("price_product");
				txPrice.setText(price);
				System.out.println("Price --> "+query);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Failed to Connect to Database to show Price","Error Connection", JOptionPane.WARNING_MESSAGE); 
		}
	}
	
	//Method to add User Data in DB
	public void getUser() {
		if(conn != null) {
			if(txName.getText().length()<=0 || txLastName.getText().length()<=0 || txCity.getText().length()<=0 
					|| txTel.getText().length()<=0 || txMail.getText().length()<=0 || txCode.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"It seems some field is empty","Error Register", JOptionPane.WARNING_MESSAGE); 
			}else if(txName.getText() !=null && txLastName.getText() != null && txCity.getText() !=null 
					&& txTel.getText() != null && txMail.getText() != null && txCode.getText() != null) {
				
				cdb.insertUser(txName.getText().toString(), txLastName.getText().toString(), cbCountry.getSelectedItem().toString()
						, txCity.getText().toString(), Integer.parseInt(txTel.getText()), 
						txMail.getText().toString(), txCode.getText().toString());
				
				JOptionPane.showMessageDialog(null,"User has been registered","Success", JOptionPane.INFORMATION_MESSAGE);
				
				txName.setEditable(false);
				txLastName.setEditable(false);
				cbCountry.setEnabled(false);
				txCity.setEditable(false);
				txTel.setEditable(false);
				txMail.setEditable(false);
				lbProductMng.setText(txCode.getText()+" "+txName.getText()+" "+txLastName.getText());
				btnRegister.setEnabled(false);	
				txCode2.setText(txCode.getText().toString());
				cbProduct.setEnabled(true);
				btnAddProduct.setEnabled(true);
			}
			
		}else if(conn == null) {
			JOptionPane.showMessageDialog(null,"Failed to Register User","Error Connection", JOptionPane.WARNING_MESSAGE); 
		}
	}
	
	//Method to get Total payment from Table
	public void calculateTotal() {
		int priceAmount = 0;
		for(int i=0;i < tableProduct.getRowCount();i++) {
			int amount = Integer.parseInt(tableProduct.getValueAt(i,2).toString());
			priceAmount = priceAmount + amount;
		}
		txAmount.setText(Integer.toString(priceAmount));
		System.out.println("Amount --> "+priceAmount);
		
		if(Integer.parseInt(txAmount.getText()) != 0) {
			double per = 0.21; //VAT Percentage
			double total = 0;
			
			total = (priceAmount*per)+priceAmount;
			txTotal.setText(Double.toString(total));
			System.out.println("Total Payment --> "+total);
		}
	}
	
	//Method to getInvoice
	public void getInvoice() {
		double per = 0.21; //VAT Percentage
		if(conn != null) {
			cdb.insertInvoice(Integer.parseInt(txAmount.getText().toString()),per, 
					Double.parseDouble(txTotal.getText().toString()),txCode2.getText().toString());
			JOptionPane.showMessageDialog(null,"Invoice has been Generated","Success", JOptionPane.INFORMATION_MESSAGE);
			cbProduct.setEnabled(false);
			btnAddProduct.setEnabled(false);
			btnDeleteProduct.setEnabled(false);
			btnInvoice.setEnabled(false);
			btnGenPdf.setEnabled(true);
		}else {
			JOptionPane.showMessageDialog(null,"Error Connection to Generate Invoice","Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Method to get Code
	public void getCode() {
		String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder str = new StringBuilder();
		Random rnd = new Random();
		while (str.length() < 6) { // length of the random string.
		    int index = (int) (rnd.nextFloat() * ALPHA.length());
		    str.append(ALPHA.charAt(index));
		}
		String codeUser = str.toString();
		txCode.setText(codeUser);
		System.out.println("Code Generated --> "+codeUser);
	}
	
	//Method to Generate Report in PDF format from Application
	public void getPDF() {
		try {
			JasperReport jasperReport;
			String pdfName = "invoice.pdf";
			Connection conn = DriverManager.getConnection(server, user, pass);
			InputStream jasperStream = getClass().getResourceAsStream("/report/invoice.jrxml");
			jasperReport = JasperCompileManager.compileReport(jasperStream);
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("id_code", txCode.getText().toString());
			//params.put("SUBREPORT_DIR", new File("report/subreport.jasper").getAbsolutePath() + File.separator);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
			JasperExportManager.exportReportToPdfFile(jasperPrint, pdfName);
			
			
			if(jasperPrint != null) {
				//Showing the report
				JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
				jasperViewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
				jasperViewer.setTitle("INVOICE REPORT");
				jasperViewer.setZoomRatio((float) 1.25);
				jasperViewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
				jasperViewer.requestFocus();
				jasperViewer.setVisible(true);
				System.out.println("Report Generated Correctly!!");	
			}
			
			}catch (Exception e){
				System.out.println("Error Creating Report --> "+e.getMessage());
				e.printStackTrace();
			}
	}
	
	//Method to Restart Application
	public void restart() {
		txName.setEditable(true);
		txName.setText("");
		txLastName.setEditable(true);
		txLastName.setText("");
		cbCountry.setEnabled(true);
		txCity.setEditable(true);
		txCity.setText("");
		txTel.setEditable(true);
		txTel.setText("");
		txMail.setEditable(true);
		txMail.setText("");
		getCode();
		lbProductMng.setText("PRODUCT MANAGEMENT");
		btnRegister.setEnabled(true);
		
		cbProduct.setEnabled(false);
		btnAddProduct.setEnabled(false);
		btnDeleteProduct.setEnabled(false);
		
		txProduct.setText("");
		txPrice.setText("0");
		txAmount.setText("0");
		txTotal.setText("0");
		txCode2.setText("");
		btnInvoice.setEnabled(false);
		btnGenPdf.setEnabled(false);
		
		//Restart JTable
		DefaultTableModel model = (DefaultTableModel) tableProduct.getModel(); 
		model.setRowCount(0);
	}
	
	private class innerAL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//Listener btnRegister
			if(e.getSource() == btnRegister) {
				getUser(); //Adding method getUser()
			}
			//Listener cbProduct
			if(e.getSource() == cbProduct) {
				if(cbProduct.getSelectedItem() != null) {
					txProduct.setText(cbProduct.getSelectedItem().toString());
					getPrice(); //Method getPrice from DB
				}else {
					txProduct.setText("Nothing to Show");
				}
			}
			//Listener btnAddProduct to JTable
			if(e.getSource() == btnAddProduct) {
				DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();
				//Generate an Array to fill out files//
				Object [] file=new Object[3];
						//Declare components for Array//
						file[0] = client++; //ID is auto increment
				        file[1]=txProduct.getText().toString();
				        file[2]=txPrice.getText().toString();

				        //Adding Array to table//
				        model.addRow(file);
				        tableProduct.setModel(model);
				        
				        calculateTotal(); //Method to calculate total payment from JTable
				        //Call Method to add User Product to DB
				        cdb.insertProduct(txProduct.getText(), Integer.parseInt(txPrice.getText()), txCode.getText());
				        btnDeleteProduct.setEnabled(true);
				        btnInvoice.setEnabled(true);
			}
			//Listener btnDeleteProduct to JTable
			if(e.getSource() == btnDeleteProduct) {
				DefaultTableModel model = (DefaultTableModel) tableProduct.getModel(); 
				int id;
				int a = tableProduct.getSelectedRow(); 
				int confirm=JOptionPane.showConfirmDialog(null, "Do You Want to Delete this Item?");
				if(JOptionPane.OK_OPTION==confirm){
					model.removeRow(a); //Delete the row//
					client--;//Decrement ID from Table
					calculateTotal();
					
					
					try {
						//Create new statement to find idUser from user_product
						conn = DriverManager.getConnection(server, user, pass);
						Statement st = conn.createStatement();
						String queryID = "select idUser_product from user_product";
						ResultSet rs = st.executeQuery(queryID);
				
						while(rs.next()) {
							id = rs.getInt("idUser_product");
							cdb.deleteProduct(id,txProduct.getText(),Integer.parseInt(txPrice.getText()),txCode.getText());
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					//When Amount = 0
					if(Integer.parseInt(txAmount.getText()) == 0) {
						txTotal.setText("0");
						btnDeleteProduct.setEnabled(false);
						btnInvoice.setEnabled(false);
					}
				}
			}
			//Listener btnInvoice
			if(e.getSource() == btnInvoice) {
				getInvoice();
			}
			//Listener btnRestart
			if(e.getSource() == btnRestart) {
				restart(); //Adding method restart()
			}
			//Listener btnGenPdf
			if(e.getSource() == btnGenPdf) {
				getPDF();
			}
			//Listener btnExit
			if(e.getSource() == btnExit) {
				System.exit(0); //Close Application
				System.out.println("See you!!!");
			}
			//Listener for TextFields
			if(e.getSource() == txName) {
				e.setSource((char)KeyEvent.VK_ENTER);
				txLastName.requestFocus();
			}else if(e.getSource() == txLastName) {
				e.setSource((char)KeyEvent.VK_ENTER);
				txCity.requestFocus();
			}else if(e.getSource() == txCity) {
				e.setSource((char)KeyEvent.VK_ENTER);
				txTel.requestFocus();
			}else if(e.getSource() == txTel) {
				e.setSource((char)KeyEvent.VK_ENTER);
				txMail.requestFocus();
			}else if(e.getSource() == txMail) {
				e.setSource((char)KeyEvent.VK_ENTER);
				btnRegister.requestFocus();
			}
		}
	}
}
