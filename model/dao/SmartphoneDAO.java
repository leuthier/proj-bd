package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.bean.Smartphone;
import connection.ConnectionFactory;


public class SmartphoneDAO {

	public void create(Smartphone smartphone){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Smartphone (codCelular, numSerie, marca, cor, cpf)VALUES(?,?,?,?,?)");
			stmt.setInt(1, smartphone.getCodCelular());
			stmt.setInt(2, smartphone.getNumSerie());
			stmt.setString(3, smartphone.getModelo());
			stmt.setString(4, smartphone.getMarca());
			stmt.setInt(5, smartphone.getCpf());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Smatphone salvo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
}
