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

	public void criar(Smartphone smartphone){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO smartphone (codCelular, numSerie, marca, cor, modelo, cpf)VALUES(?,?,?,?,?,?)");
			stmt.setString(1, smartphone.getCodCelular());
			stmt.setString(2, smartphone.getNumSerie());
			stmt.setString(3, smartphone.getMarca());
			stmt.setString(4, smartphone.getModelo());
			stmt.setString(5, smartphone.getCor());
			stmt.setString(6, smartphone.getCpf());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Smatphone salvo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	public List<Smartphone> listar(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Smartphone> smartphones = new ArrayList<Smartphone>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM smartphone");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Smartphone smartphone = new Smartphone();
				smartphone.setCodCelular(resultSet.getString("codCelular"));
				smartphone.setNumSerie(resultSet.getString("numSerie"));
				smartphone.setMarca(resultSet.getString("marca"));
				smartphone.setModelo(resultSet.getString("modelo"));
				smartphone.setCor(resultSet.getString("cor"));
				smartphone.setCpf(resultSet.getString("cpf"));
				
				smartphones.add(smartphone);
			 }
			
		}catch (SQLException ex){
			Logger.getLogger(SmartphoneDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return smartphones;
		
	}
	
	
	public void atualizar(Smartphone smartphone){
			
			Connection connection = ConnectionFactory.getConnection();
			java.sql.PreparedStatement stmt = null;
			
			try{
				stmt = connection.prepareStatement("UPDATE smartphone SET codCelular = ?, numSerie = ?, marca = ?, modelo = ?, cor = ?, cpf=?  WHERE id = ?");
				stmt.setString(1, smartphone.getCodCelular());
				stmt.setString(2, smartphone.getNumSerie());
				stmt.setString(3, smartphone.getMarca());
				stmt.setString(4, smartphone.getModelo());
				stmt.setString(5, smartphone.getCor());
				stmt.setString(6, smartphone.getCpf());
										
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Smartphone atualizado com sucesso");
				
			}catch (SQLException ex){
				JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
				
			}finally{
				ConnectionFactory.closeConnection(connection, stmt);
			}
			
	}


	public void excluir(Smartphone smartphone){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM smartphone WHERE codCelular = ?");
			stmt.setString(1, smartphone.getCodCelular());
						
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Smartphone deletado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}


}
