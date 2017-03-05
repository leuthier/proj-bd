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

	public void criar(Material material){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Material (codMat, descricao)VALUES(?,?)");
			stmt.setString(1, material.getCodMat());
			stmt.setString(2, material.getDescricao());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Material salvo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	public List<Material> listar(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Material> materiais = new ArrayList<Material>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Material");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Material material = new Material();
				material.setCodMat(resultSet.getString("codMat"));
				material.setDescricao(resultSet.getString("descricao"));
				
				materiais.add(material);
			 }
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return materiais;
		
	}

	
	public void atualizar(Material material){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		if(pesquisarPorCod(material.getCodMat()) != null){
			try{
				stmt = connection.prepareStatement("UPDATE material SET descricao = ? WHERE codMat = ?");
				stmt.setString(1, material.getDescricao());
				stmt.setString(2, material.getCodMat());
				
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Material atualizado com sucesso");
				
			}catch (SQLException ex){
				JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
				
			}
		}else{
			JOptionPane.showMessageDialog(null, "Material não existente.");
		}
		ConnectionFactory.closeConnection(connection, stmt);
	}
	

	
public void excluir(Material material){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM material WHERE codMat = ?");
			stmt.setString(1, material.getCodMat());
						
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Material deletado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}

	public Material pesquisarPorCod(String cod){
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
				
		try{	
			stmt = connection.prepareStatement("SELECT * FROM celular.material WHERE material.codMat = ?");
			stmt.setString(1, cod);
			resultSet = stmt.executeQuery();
			
			while (resultSet.next()){
				Material material = new Material();
				material.setCodMat(resultSet.getString("codMat"));
				material.setDescricao(resultSet.getString("descricao"));
				return material;
			 }
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao buscar material pelo código - "+ ex);
			return null;
		}
		finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		return null;
	}
	
	
}
