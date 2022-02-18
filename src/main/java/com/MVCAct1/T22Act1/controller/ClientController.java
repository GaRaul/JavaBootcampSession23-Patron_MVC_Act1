package com.MVCAct1.T22Act1.controller;

import com.MVCAct1.T22Act1.model.dto.Client;
import com.MVCAct1.T22Act1.model.service.ClientServ;
import com.MVCAct1.T22Act1.view.*;

public class ClientController {
	
	private ClientServ clientServ;
	private MenuView myMenuView;
	private RegisterView myRegisterView;
	private SearchView mySearchView;
	
	//Metodos getter Setters de vistas
	public ClientServ getClientServ() {
		return clientServ;
	}

	public void setClientServ(ClientServ clientServ) {
		this.clientServ = clientServ;
	}

	public MenuView getMyMenuView() {
		return myMenuView;
	}

	public void setMyMenuView(MenuView myMenuView) {
		this.myMenuView = myMenuView;
	}

	public RegisterView getMyRegisterView() {
		return myRegisterView;
	}

	public void setMyRegisterView(RegisterView myRegisterView) {
		this.myRegisterView = myRegisterView;
	}

	public SearchView getMySearchView() {
		return mySearchView;
	}

	public void setMySearchView(SearchView mySearchView) {
		this.mySearchView = mySearchView;
	}
	
	//Hace visible las vistas de Registro y Consulta
    public void showRegisterView() {
        myRegisterView.setVisible(true);
    }
    public void showSearchView() {
        mySearchView.setVisible(true);
    }
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
    public void addClient(Client myClient) {
        clientServ.validateRegister(myClient);
    }    
    
    public Client searchClient(String idClient) {
		return clientServ.validateQuery(idClient);
	}
	
	public void modifyClient(Client myClient) {
		clientServ.validateModification(myClient);
	}
	
	public void deleteClient(String idClient) {
		clientServ.validateDelete(idClient);
	}
	
	
}
