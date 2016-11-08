package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.bean.Material;
import connection.ConnectionFactory;


public class MaterialDAO {

	public void create(Material material){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Material (codMat, descricao)VALUES(?,?)");
			stmt.setInt(1, material.getCodMat());
			stmt.setString(2, material.getDescricao());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Material salvo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
}
