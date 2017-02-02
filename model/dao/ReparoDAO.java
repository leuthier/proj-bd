package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import com.sun.istack.internal.logging.Logger;

import model.bean.Reparo;
import connection.ConnectionFactory;


public class ReparoDAO {

	public void create(Reparo reparo){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Reparo (codCelular, dataExecutada, dataUltimoConserto)VALUES(?,?,?)");
			stmt.setInt(1, reparo.getCodCelular());
			stmt.setDate(2, reparo.getDataExecutada());
			stmt.setDate(3, reparo.getDataUltimoConserto());
						
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Reparo cadastrado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	public List<Reparo> listarReparos(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Reparo> reparos = new ArrayList<Reparo>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Reparo");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Reparo reparo = new Reparo();
				reparo.setCodCelular(resultSet.getInt("codCelular"));
				reparo.setDataUltimoConserto(resultSet.getDate("dataUltimoConserto"));
				reparo.setDataExecutada(resultSet.getDate("dataExecutada"));
				reparos.add(reparo);
			 }
			
		}catch (SQLException ex){
			Logger.getLogger(ReparoDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return reparos;
		
	}
	
	
	public void update (Reparo reparo){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE Reparo SET codCelular = ?, dataExecutada = ?, dataUltimoConserto = ? WHERE id = ?");
			stmt.setInt(1, reparo.getCodCelular());
			stmt.setDate(2, reparo.getDataExecutada());
			stmt.setDate(3, reparo.getDataUltimoConserto());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "O reparo foi atualizado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	
}
