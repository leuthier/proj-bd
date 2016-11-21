package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import com.sun.istack.internal.logging.Logger;

import model.bean.Cliente;
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
	
	public List<Material> listarMateriais(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Material> materiais = new ArrayList<Material>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Cliente");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Material material = new Material();
				material.setCodMat(resultSet.getInt("codMat"));
				material.setDescricao(resultSet.getString("descricao"));
				
				materiais.add(material);
			 }
			
		}catch (SQLException ex){
			Logger.getLogger(ClienteDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return materiais;
		
	}
	
}
