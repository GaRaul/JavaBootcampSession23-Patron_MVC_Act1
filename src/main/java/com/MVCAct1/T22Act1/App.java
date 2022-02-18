package com.MVCAct1.T22Act1;

import com.MVCAct1.T22Act1.controller.ClientController;
import com.MVCAct1.T22Act1.model.service.ClientServ;
import com.MVCAct1.T22Act1.view.*;

/**
 * Hello world!
 *
 */
public class App 
{
	ClientServ myClientServ;
	MenuView myMenuView;
	SearchView mySearchView;
	RegisterView myRegisterView;
	ClientController clientController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App miPrincipal=new App();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		myMenuView=new MenuView();
		myRegisterView=new RegisterView();
		mySearchView= new SearchView();
		myClientServ=new ClientServ();
		clientController= new ClientController();
		
		/*Se establecen las relaciones entre clases*/
		myMenuView.setCoordinator(clientController);
		myRegisterView.setCoordinator(clientController);
		mySearchView.setCoordinador(clientController);
		myClientServ.setClientController(clientController);
		
		/*Se establecen relaciones con la clase coordinador*/
		clientController.setMyMenuView(myMenuView);
		clientController.setMyRegisterView(myRegisterView);
		clientController.setMySearchView(mySearchView);
		clientController.setClientServ(myClientServ);
				
		myMenuView.setVisible(true);
	}

}
