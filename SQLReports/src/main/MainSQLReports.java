package main;

import javax.swing.JFrame;

import views.SQLReport;

public class MainSQLReports extends JFrame{
	private static final long serialVersionUID = 1L;

	//Constructor Main Class
	public MainSQLReports() {}
	
	public static void main(String[] args) {
		SQLReport sr = new SQLReport();
		sr.setVisible(true); //View is Visible
	}

}
