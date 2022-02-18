package com.MVCAct1.T22Act1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.MVCAct1.T22Act1.controller.ClientController;
import com.MVCAct1.T22Act1.model.dto.Client;

public class RegisterView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ClientController clientController; // objeto personaController que permite la relacion entre esta clase y la
												// clase PersonaController
	private JLabel lblTitle;
	private JTextField textId, textName, textSurname, textAddress, textDni, textDate;
	private JLabel lblId, lblName, lblSurname, lblAddress, lblDni, lblDate;
	private JButton btnSave, btnCancel;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de registro
	 */
	public RegisterView() {

		btnSave = new JButton();
		btnSave.setBounds(109, 242, 120, 25);
		btnSave.setText("Register");

		btnCancel = new JButton();
		btnCancel.setBounds(250, 242, 120, 25);
		btnCancel.setText("Cancel");

		lblTitle = new JLabel();
		lblTitle.setText("REGISTER CLIENTS");
		lblTitle.setBounds(120, 20, 380, 30);
		lblTitle.setFont(new java.awt.Font("Verdana", 1, 18));

		lblId = new JLabel();
		lblId.setText("Id");
		lblId.setBounds(20, 80, 80, 25);
		getContentPane().add(lblId);

		lblName = new JLabel();
		lblName.setText("Name");
		lblName.setBounds(20, 120, 80, 25);
		getContentPane().add(lblName);

		lblAddress = new JLabel();
		lblAddress.setText("Address");
		lblAddress.setBounds(290, 160, 80, 25);
		getContentPane().add(lblAddress);

		lblSurname = new JLabel();
		lblSurname.setText("Surname");
		lblSurname.setBounds(290, 120, 80, 25);
		getContentPane().add(lblSurname);

		lblDni = new JLabel();
		lblDni.setText("Dni");
		lblDni.setBounds(20, 160, 80, 25);
		getContentPane().add(lblDni);
		
		lblDate = new JLabel();
		lblDate.setText("Date");
		lblDate.setBounds(290, 80, 80, 25);
		getContentPane().add(lblDate);

		textId = new JTextField();
		textId.setBounds(80, 80, 190, 25);
		getContentPane().add(textId);

		textName = new JTextField();
		textName.setBounds(80, 120, 190, 25);
		getContentPane().add(textName);

		textAddress = new JTextField();
		textAddress.setBounds(340, 160, 80, 25);
		getContentPane().add(textAddress);

		textSurname = new JTextField();
		textSurname.setBounds(340, 120, 80, 25);
		getContentPane().add(textSurname);

		textDni = new JTextField();
		textDni.setBounds(80, 160, 190, 25);
		getContentPane().add(textDni);
		
		textDate = new JTextField();
		textDate.setBounds(340, 80, 80, 25);
		getContentPane().add(textDate);

		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);
		getContentPane().add(btnSave);
		getContentPane().add(lblTitle);
		limpiar();
		setSize(480, 325);
		setTitle("Patron Design/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	private void limpiar() {
		textId.setText("");
		textName.setText("");
		textSurname.setText("");
		textAddress.setText("");
		textDni.setText("");
	}

	public void setCoordinator(ClientController clientController) {
		this.clientController = clientController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			try {
				Client myClient = new Client();
				myClient.setId(Integer.parseInt(textId.getText()));
				myClient.setName(textName.getText());
				myClient.setSurname(textAddress.getText());
				myClient.setAddress(textSurname.getText());
				myClient.setDni(textDni.getText());
				myClient.setDate(textDate.getText());

				clientController.addClient(myClient);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Insert data Error", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource() == btnCancel) {
			this.dispose();
		}
	}

}
