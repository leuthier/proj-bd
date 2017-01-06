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
import connection.ConnectionFactory;


public class ClienteDAO {

	public void create(Cliente cliente){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Cliente (cpf, telefone, nomeCli, email)VALUES(?,?,?,?)");
			stmt.setInt(1, cliente.getCpf());
			stmt.setInt(2, cliente.getTelefone());
			stmt.setString(3, cliente.getNomeCli());
			stmt.setString(4, cliente.getEmail());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	
	public List<Cliente> listarClientes(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Cliente");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Cliente cliente = new Cliente();
				cliente.setCpf(resultSet.getInt("cpf"));
				cliente.setNomeCli(resultSet.getString("nomeCli"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getInt("telefone"));
				
				clientes.add(cliente);
			 }
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return clientes;
		
	}
	
	public void update(Cliente cliente){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE cliente SET cpf = ?, telefone = ?, nomeCli = ?, email = ? WHERE id = ?");
			stmt.setInt(1, cliente.getCpf());
			stmt.setInt(2, cliente.getTelefone());
			stmt.setString(3, cliente.getNomeCli());
			stmt.setString(4, cliente.getEmail());
			stmt.setInt(5, cliente.getId());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
}
