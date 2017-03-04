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
			stmt = connection.prepareStatement("INSERT INTO smartphone (codCelular, numSerie, modelo, marca, cor, cpf)VALUES(?,?,?,?,?,?)");
			stmt.setString(1, smartphone.getCodCelular());
			stmt.setString(2, smartphone.getNumSerie());
			stmt.setString(3, smartphone.getModelo());
			stmt.setString(4, smartphone.getMarca());
			stmt.setString(5, smartphone.getCor());
			stmt.setString(6, smartphone.getCpf());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Smartphone salvo com sucesso");
			
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
				smartphone.setModelo(resultSet.getString("modelo"));
				smartphone.setMarca(resultSet.getString("marca"));
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
								
				stmt = connection.prepareStatement("UPDATE smartphone SET codCelular = ?, numSerie = ?, modelo = ?, marca = ?, cor = ?, cpf = ?  WHERE codCelular = ?");
				stmt.setString(1, smartphone.getCodCelular());
				stmt.setString(2, smartphone.getNumSerie());
				stmt.setString(3, smartphone.getModelo());
				stmt.setString(4, smartphone.getMarca());
				stmt.setString(5, smartphone.getCor());
				stmt.setString(6, smartphone.getCpf());
				stmt.setString(7, smartphone.getCodCelular());
										
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
	
	public Smartphone pesquisarPorCodigo(String codCelular){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		String consulta = "SELECT * FROM celular.smartphone WHERE smartphone.codCelular = ";
		String consultaCompleta = consulta.concat(codCelular);
		
		try{	
			stmt = connection.prepareStatement(consultaCompleta);
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()){
				
				Smartphone smartphone = new Smartphone();
				smartphone.setCodCelular(resultSet.getString("codCelular"));
				smartphone.setNumSerie(resultSet.getString("numSerie"));
				smartphone.setModelo(resultSet.getString("modelo"));
				smartphone.setMarca(resultSet.getString("marca"));
				smartphone.setCor(resultSet.getString("cor"));
				smartphone.setCpf(resultSet.getString("cpf"));
				
				return smartphone;
				
			 }
			
		}catch (SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar celular pelo código - "+ ex);
		}
		finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		return null;
	}


	public Smartphone pesquisarPorNumSerie(String numSerie){
			
			Connection connection = ConnectionFactory.getConnection();
			java.sql.PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			String consulta = "SELECT * FROM celular.smartphone WHERE smartphone.numSerie = ";
			
			try{	
				stmt = connection.prepareStatement(consulta+numSerie);
				//stmt.setString(1, numSerie);
				resultSet = stmt.executeQuery();
				
				while (resultSet.next()){
					
					Smartphone smartphone = new Smartphone();
					smartphone.setCodCelular(resultSet.getString("codCelular"));
					smartphone.setNumSerie(resultSet.getString("numSerie"));
					smartphone.setModelo(resultSet.getString("modelo"));
					smartphone.setMarca(resultSet.getString("marca"));
					smartphone.setCor(resultSet.getString("cor"));
					smartphone.setCpf(resultSet.getString("cpf"));
					
					return smartphone;
					
				 }
				
			}catch (SQLException ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao buscar celular pelo numero de serie - "+ ex);
			}
			finally{
				ConnectionFactory.closeConnection(connection, stmt, resultSet);
			}
			return null;
		}
	
}
