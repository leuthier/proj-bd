package model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
	
}
