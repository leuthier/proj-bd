package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import com.sun.istack.internal.logging.Logger;

import model.bean.MaterialReparo;
import connection.ConnectionFactory;

//codCelular integer not null references Reparo(codCelular)
//dataExecutada date not null references Reparo(dataExecutada)
//codMat integer Primary key references Material(codMat)
//quantidade integer,

public class MaterialReparoDAO {

	public void create(MaterialReparo materialReparo){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Material_Reparo (codCelular, dataExecutada, codMat, quantidade)VALUES(?,?,?,?)");
			stmt.setInt(1, materialReparo.getCodCelular());
			stmt.setDate(2, materialReparo.getDataExecutada());
			stmt.setInt(3, materialReparo.getCodMat());
			stmt.setInt(4, materialReparo.getQuantidade());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "MaterialReparo salvo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	public List<MaterialReparo> listarMateriaisReparo(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<MaterialReparo> materiaisReparo = new ArrayList<MaterialReparo>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Material_Reparo");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				MaterialReparo materialReparo = new MaterialReparo();
				materialReparo.setCodCelular(resultSet.getInt("codCelular"));
				materialReparo.setCodMat(resultSet.getInt("codMat"));
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
	
	
	public void update(MaterialReparo materialReparo){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE Material SET codCelular = ?, dataExecutada = ?, codMat = ?, quantidade = ? WHERE id = ?");
			stmt.setInt(1, materialReparo.getCodCelular());
			stmt.setDate(2, materialReparo.getDataExecutada());
			stmt.setInt(3, materialReparo.getCodMat());
			stmt.setInt(4, materialReparo.getQuantidade());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Material de reparo foi atualizado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	
}
