package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import com.sun.istack.internal.logging.Logger;

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
	
	public List<Smartphone> listarSmartphones(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Smartphone> smartphones = new ArrayList<Smartphone>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Smartphone");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Smartphone smartphone = new Smartphone();
				smartphone.setCodCelular(resultSet.getInt("codCelular"));
				smartphone.setNumSerie(resultSet.getInt("numSerie"));
				smartphone.setModelo(resultSet.getString("modelo"));
				smartphone.setMarca(resultSet.getString("marca"));
				smartphone.setCor(resultSet.getString("cor"));
				smartphone.setCpf(resultSet.getInt("cpf"));
				
				smartphones.add(smartphone);
			 }
			
		}catch (SQLException ex){
			Logger.getLogger(SmartphoneDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return smartphones;
		
	}
	
	
public void update(Smartphone smartphone){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE Smartphone SET codCelular = ?, numSerie = ?, modelo = ?, marca = ?, cor = ?, cpf=?  WHERE id = ?");
			stmt.setInt(1, smartphone.getCodCelular());
			stmt.setInt(2, smartphone.getNumSerie());
			stmt.setString(3, smartphone.getModelo());
			stmt.setString(4, smartphone.getMarca());
			stmt.setString(5, smartphone.getCor());
			stmt.setInt(6, smartphone.getCpf());
									
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Smartphone atualizado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
}
