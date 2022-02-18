package com.MVCAct1.T22Act1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.MVCAct1.T22Act1.controller.ClientController;
import com.MVCAct1.T22Act1.model.dto.Client;
import com.MVCAct1.T22Act1.model.service.ClientServ;

public class SearchView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ClientController clientController; // objeto personaController que permite la relacion entre esta clase y la
												// clase personaController
	private JLabel lblTitle;
	private JTextField textId, textName, textSurname, textAddress, textDni, textDate;
	private JLabel lblId, lblName, lblSurname, lblAddress, lblDni, lblDate;
	private JButton btnSave, btnCancel, btnSearch, btnModify, btnDelete;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de busqueda
	 */
	public SearchView() {

		btnSave = new JButton();
		btnSave.setBounds(32, 220, 120, 25);
		btnSave.setText("Save");

		btnCancel = new JButton();
		btnCancel.setBounds(170, 245, 120, 25);
		btnCancel.setText("Cancel");

		btnSearch = new JButton();
		btnSearch.setBounds(170, 80, 70, 25);
		btnSearch.setText("Search");

		btnDelete = new JButton();
		btnDelete.setBounds(300, 220, 120, 25);
		btnDelete.setText("Delete");

		btnModify = new JButton();
		btnModify.setBounds(170, 220, 120, 25);
		btnModify.setText("Modify");

		lblTitle = new JLabel();
		lblTitle.setText("MANAGE CLIENTS");
		lblTitle.setBounds(137, 27, 380, 30);
		lblTitle.setFont(new java.awt.Font("Verdana", 1, 18));

		lblId = new JLabel();
		lblId.setText("Id");
		lblId.setBounds(20, 80, 80, 25);
		getContentPane().add(lblId);

		lblName = new JLabel();
		lblName.setText("Name");
		lblName.setBounds(20, 120, 80, 25);
		getContentPane().add(lblName);

		lblSurname = new JLabel();
		lblSurname.setText("Surname");
		lblSurname.setBounds(290, 160, 80, 25);
		getContentPane().add(lblSurname);

		lblAddress = new JLabel();
		lblAddress.setText("Address");
		lblAddress.setBounds(20, 160, 80, 25);
		getContentPane().add(lblAddress);

		lblDni = new JLabel();
		lblDni.setText("Dni");
		lblDni.setBounds(290, 120, 80, 25);
		getContentPane().add(lblDni);

		lblDate = new JLabel();
		lblDate.setText("Date");
		lblDate.setBounds(290, 80, 80, 25);
		getContentPane().add(lblDate);

		textId = new JTextField();
		textId.setBounds(80, 80, 80, 25);
		getContentPane().add(textId);

		textName = new JTextField();
		textName.setBounds(80, 120, 190, 25);
		getContentPane().add(textName);

		textSurname = new JTextField();
		textSurname.setBounds(340, 160, 80, 25);
		getContentPane().add(textSurname);

		textAddress = new JTextField();
		textAddress.setBounds(80, 160, 190, 25);
		getContentPane().add(textAddress);

		textDni = new JTextField();
		textDni.setBounds(340, 120, 80, 25);
		getContentPane().add(textDni);

		textDate = new JTextField();
		textDate.setBounds(340, 80, 80, 25);
		getContentPane().add(textDate);

		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);

		getContentPane().add(btnCancel);
		getContentPane().add(btnSearch);
		getContentPane().add(btnModify);
		getContentPane().add(btnDelete);
		getContentPane().add(btnSave);
		getContentPane().add(lblTitle);
		limpiar();

		setSize(480, 320);
		setTitle("Search Client");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	public void setCoordinador(ClientController clientController) {
		this.clientController = clientController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			try {
				Client myClient = new Client();
				myClient.setId(Integer.parseInt(textId.getText()));
				myClient.setName(textName.getText());
				myClient.setSurname(textSurname.getText());
				myClient.setAddress(textAddress.getText());
				myClient.setDni(textDni.getText());
				myClient.setDate(textDate.getText());

				clientController.modifyClient(myClient);

				if (ClientServ.modifyClient == true) {
					habilita(true, true, false, false, false, false, false, false, true, true);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Data insert Error", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getSource() == btnSearch) {
			Client myClient = clientController.searchClient(textId.getText());
			if (myClient != null) {
				showClient(myClient);
			} else if (ClientServ.consultClient == true) {
				JOptionPane.showMessageDialog(null, "Client doesn't exist", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == btnModify) {
			habilita(true, true, false, false, false, false, false, false, true, true);

		}

		if (e.getSource() == btnDelete) {
			if (!textId.getText().equals("")) {
				int respuesta = JOptionPane.showConfirmDialog(this, "Are you sure to delete a client?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION) {
					clientController.deleteClient(textId.getText());
					limpiar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Insert document number", "Information",
						JOptionPane.WARNING_MESSAGE);
			}

		}
		if (e.getSource() == btnCancel) {
			this.dispose();
		}

	}

	/**
	 * permite cargar los datos de la persona consultada
	 * 
	 * @param myClient
	 */
	private void showClient(Client myClient) {
		textName.setText(myClient.getName());
		textSurname.setText(myClient.getSurname() + "");
		textAddress.setText(myClient.getAddress() + "");
		textDni.setText(myClient.getDni() + "");
		textDate.setText(myClient.getDate());
		habilita(true, true, false, false, false, false, false, false, true, true);
	}

	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar() {
		textId.setText("");
		textName.setText("");
		textSurname.setText("");
		textAddress.setText("");
		textDni.setText("");
		textDate.setText("");
		habilita(true, true, false, false, false, false, false, false, true, true);
	}

	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * 
	 * @param id
	 * @param name
	 * @param surname
	 * @param address
	 * @param dni
	 * @param date
	 * @param bSearch
	 * @param bSave
	 * @param bModify
	 * @param bDelete
	 */
	public void habilita(boolean id, boolean bSearch, boolean name, boolean surname, boolean address, boolean dni, boolean date, 
			boolean bSave, boolean bModify, boolean bDelete) {
		textId.setEditable(id);
		textName.setEditable(name);
		textSurname.setEditable(surname);
		textAddress.setEditable(address);
		textDni.setEditable(dni);
		btnSearch.setEnabled(bSearch);
		btnSave.setEnabled(bSave);
		btnModify.setEnabled(bModify);
		btnDelete.setEnabled(bDelete);
	}

}
