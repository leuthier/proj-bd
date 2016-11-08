package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
	
}
