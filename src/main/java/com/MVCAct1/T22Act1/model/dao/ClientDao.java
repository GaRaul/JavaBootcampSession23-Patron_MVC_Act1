package com.MVCAct1.T22Act1.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.MVCAct1.T22Act1.model.connection.MysqlConnection;
import com.MVCAct1.T22Act1.model.dto.Client;

public class ClientDao {
	
	public void registerClient(Client myClient)
	{
		MysqlConnection conex= new MysqlConnection();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Client VALUES ('" + myClient.getId() + "', '"
					+ myClient.getName() + "', '" + myClient.getSurname() + "', '"
					+ myClient.getAddress() + "', '" + myClient.getDni() + "','"
					+ myClient.getDate() + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Client added","Information",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed insertion");
		}
	}

	public Client searchClient(int id) 
	{
		MysqlConnection conex= new MysqlConnection();		
		Client client= new Client();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM persona where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, id);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				client.setId(Integer.parseInt(res.getString("Id")));
				client.setName(res.getString("Name"));
				client.setSurname(res.getString("Surname"));
				client.setAddress(res.getString("Address"));
				client.setDni(res.getString("Dni"));
				client.setDate(res.getString("Date"));				
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Connection Error");
					System.out.println(e);
			}
		
			if (existe) {
				return client;
			}
			else return null;				
	}

	public void modifyClient(Client myClient) {
		
		MysqlConnection conex= new MysqlConnection();
		try{
			String consulta="UPDATE persona SET Id= ? ,Name = ? , Surname = ? , Address = ? , Dni = ? , Date = ?, WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, myClient.getId());
            estatuto.setString(2, myClient.getName());
            estatuto.setString(3, myClient.getSurname());
            estatuto.setString(4, myClient.getAddress());
            estatuto.setString(5,myClient.getDni());
            estatuto.setString(6, myClient.getDate());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Modification Done","Confirmation",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);         

        }catch(SQLException e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Modification Error","Error",JOptionPane.ERROR_MESSAGE);
        }
	}

	public void deleteClient(String id)
	{
		MysqlConnection conex= new MysqlConnection();
		try {
			String sql= "DELETE FROM Client WHERE id='" + id + "'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Delete Done","Information",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Delete Error");
		}
	}
}