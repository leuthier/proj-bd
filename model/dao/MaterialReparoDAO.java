package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import com.sun.istack.internal.logging.Logger;

import model.bean.MaterialReparo;
import model.bean.Reparo;
import connection.ConnectionFactory;

//codCelular integer not null references Reparo(codCelular)
//dataExecutada date not null references Reparo(dataExecutada)
//codMat integer Primary key references Material(codMat)
//quantidade integer,

public class MaterialReparoDAO {
	
	public void criar(MaterialReparo mr){
		MaterialReparo mrc = pesquisar(mr.getCodCelular(),mr.getDataExecutada(),mr.getCodMat());
		if(mrc == null){
			inserir(mr);
		}
	
}

	public void inserir(MaterialReparo materialReparo){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Material_Reparo (codCelular, dataExecutada, codMat, quantidade)VALUES(?,?,?,?)");
			stmt.setString(1, materialReparo.getCodCelular());
			stmt.setDate(2, materialReparo.getDataExecutada());
			stmt.setString(3, materialReparo.getCodMat());
			stmt.setInt(4, materialReparo.getQuantidade());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Material adicionado ao reparo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	public List<MaterialReparo> listar(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<MaterialReparo> materiaisReparo = new ArrayList<MaterialReparo>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM material_reparo");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				MaterialReparo materialReparo = new MaterialReparo();
				materialReparo.setCodCelular(resultSet.getString("codCelular"));
				materialReparo.setCodMat(resultSet.getString("codMat"));
				materialReparo.setDataExecutada(resultSet.getDate("dataExecutada"));
				materialReparo.setQuantidade(resultSet.getInt("quantidade"));
				materiaisReparo.add(materialReparo);
			 }
			
		}catch (SQLException ex){
			Logger.getLogger(MaterialReparoDAO.class.getName(), null).log(Level.SEVERE, null, ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return materiaisReparo;
		
	}
	
	
	public void atualizar(MaterialReparo materialReparo){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE material_reparo SET quantidade = ? WHERE codCelular = ? and dataExecutada = ? and codMat = ?");
			stmt.setInt(1, materialReparo.getQuantidade());
			stmt.setString(2, materialReparo.getCodCelular());
			stmt.setDate(3, materialReparo.getDataExecutada());
			stmt.setString(4, materialReparo.getCodMat());
						
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Material de reparo foi atualizado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	public void excluir(MaterialReparo materialReparo){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM material_reparo WHERE codCelular = ? and dataExecutada = ? and codMat = ?");
			stmt.setString(1, materialReparo.getCodCelular());
			stmt.setDate(2, materialReparo.getDataExecutada());
			stmt.setString(3, materialReparo.getCodMat());
						
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Material removido do reparo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public MaterialReparo pesquisar(String codR, Date data, String codM){
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try{	
			stmt = connection.prepareStatement("SELECT * FROM material_reparo WHERE codCelular = ? and dataExecutada = ? and codMat = ?");
			stmt.setString(1, codR);
			stmt.setDate(2, data);
			stmt.setString(3, codM);
			resultSet = stmt.executeQuery();
			
			
			while (resultSet.next()){
				
				MaterialReparo materialR = new MaterialReparo();
				Reparo reparo = new Reparo();
				materialR.setCodCelular(resultSet.getString("codCelular"));
				materialR.setDataExecutada(resultSet.getDate("dataExecutada"));
				materialR.setCodMat(resultSet.getString("codMat"));
				materialR.setQuantidade(resultSet.getInt("quantidade"));
				return materialR;
				
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
