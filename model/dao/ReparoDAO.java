package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import model.bean.Reparo;
import connection.ConnectionFactory;


public class ReparoDAO {
	
	
	
	public void criar(Reparo reparo){
			Reparo reparoCadastrado = pesquisar(reparo.getCodCelular(), reparo.getDataExecutada());
			if(reparoCadastrado == null){
				inserir(reparo);
			}else{
				reparoCadastrado.setDataUltimoConserto(reparoCadastrado.getDataExecutada());
				reparoCadastrado.setDataExecutada(reparo.getDataExecutada());
				inserir(reparoCadastrado);
			}
		
	}
	
	private void inserir(Reparo reparo){
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Reparo (codCelular, dataExecutada, dataUltimoConserto)VALUES(?,?,?)");
			stmt.setString(1, reparo.getCodCelular());
			stmt.setDate(2, reparo.getDataExecutada());
			stmt.setDate(3, reparo.getDataUltimoConserto());
						
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Reparo cadastrado com sucesso");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+e);
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}		
	}
	
	public List<Reparo> listar(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Reparo> reparos = new ArrayList<Reparo>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Reparo");
			resultSet =stmt.executeQuery();
			
			while (resultSet.next()){
				
				Reparo reparo = new Reparo();
				reparo.setCodCelular(resultSet.getString("codCelular"));
				reparo.setDataUltimoConserto(resultSet.getDate("dataUltimoConserto"));
				reparo.setDataExecutada(resultSet.getDate("dataExecutada"));
				reparos.add(reparo);
			 }
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return reparos;
		
	}
	
	public void atualizar(Reparo reparo){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE reparo SET dataUltimoConserto = ? WHERE WHERE codCelular = ? and dataExecutada = ?");
			stmt.setDate(1, reparo.getDataExecutada());
			stmt.setString(2, reparo.getCodCelular());
			stmt.setDate(3, reparo.getDataExecutada());
			
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	public void excluir(Reparo reparo, Date data){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM reparo WHERE codCelular = ? and dataExecutada = ?");
			stmt.setString(1, reparo.getCodCelular());
			stmt.setDate(2, data);
						
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Reparo deletado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	
	public Reparo pesquisar(String cod, Date data){
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try{	
			stmt = connection.prepareStatement("SELECT * FROM celular.reparo WHERE reparo.codCelular = ? and reparo.dataExecutada = ?");
			stmt.setString(1, cod);
			stmt.setDate(2, data);
			resultSet = stmt.executeQuery();
			
			
			while (resultSet.next()){
				
				Reparo reparo = new Reparo();
				reparo.setCodCelular(resultSet.getString("codCelular"));
				reparo.setDataExecutada(resultSet.getDate("dataExecutada"));
				reparo.setDataUltimoConserto(resultSet.getDate("dataUltimoConserto"));
				return reparo;
				
			 }
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente por CPF - "+ ex);
		}
		finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		return null;
	}
}
