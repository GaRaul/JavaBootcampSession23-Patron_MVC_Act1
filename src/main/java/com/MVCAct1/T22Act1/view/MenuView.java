package com.MVCAct1.T22Act1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.MVCAct1.T22Act1.controller.ClientController;

import javax.swing.JLabel;
import javax.swing.JButton;

public class MenuView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ClientController clientController; // objeto PersonaController que permite la relacion entre esta clase y
												// la clase PersonaController
	private JTextArea areaIntroduction;
	private JLabel lblTitle, lblSelection;
	private JButton btnRegister, btnSearch;

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana principal
	 */
	public MenuView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btnRegister = new JButton();
		btnRegister.setBounds(100, 280, 120, 25);
		btnRegister.setText("Register");

		btnSearch = new JButton();
		btnSearch.setBounds(240, 280, 120, 25);
		btnSearch.setText("Search");

		lblTitle = new JLabel();
		lblTitle.setText("MVC PATRON");
		lblTitle.setBounds(60, 40, 380, 30);
		lblTitle.setFont(new java.awt.Font("Verdana", 1, 15));

		lblSelection = new JLabel();
		lblSelection.setText("What option do you want to do?");
		lblSelection.setBounds(75, 240, 250, 25);

		textoIntroduccion = "This application shows a practical example of design MVC.\n\n"
				+ "The application allows to register, update, search and delete registers from a Client table.";

		areaIntroduction = new JTextArea();
		areaIntroduction.setBounds(50, 90, 380, 140);
		areaIntroduction.setEditable(false);
		areaIntroduction.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduction.setLineWrap(true);
		areaIntroduction.setText(textoIntroduccion);
		areaIntroduction.setWrapStyleWord(true);
		areaIntroduction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
				null, null, null, new java.awt.Color(0, 0, 0)));

		btnRegister.addActionListener(this);
		btnSearch.addActionListener(this);
		add(btnSearch);
		add(btnRegister);
		add(lblSelection);
		add(lblTitle);
		add(areaIntroduction);

		setSize(480, 350);
		setTitle("Patron Disgn/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
	}

	public void setCoordinator(ClientController clientController) {
		this.clientController = clientController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegister) {
			clientController.showRegisterView();
		}
		if (e.getSource() == btnSearch) {
			clientController.showSearchView();
			;
		}
	}
}
