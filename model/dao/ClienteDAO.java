package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;

import javax.swing.JOptionPane;
//import com.sun.istack.internal.logging.Logger;

import model.bean.Cliente;
import connection.ConnectionFactory;


public class ClienteDAO {

	public void criar(Cliente cliente){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO Cliente (cpf, telefone, nomeCli, email)VALUES(?,?,?,?)");
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getTelefone());
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
	
	
	public List<Cliente> listar(){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Cliente");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Cliente cliente = new Cliente();
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNomeCli(resultSet.getString("nomeCli"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				
				clientes.add(cliente);
			 }
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return clientes;
		
	}
	
	public void atualizar(Cliente cliente){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE cliente SET telefone = ?, nomeCli = ?, email = ? WHERE cpf = ?");
			stmt.setString(1, cliente.getTelefone());
			stmt.setString(2, cliente.getNomeCli());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getCpf());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
	public void excluir(Cliente cliente){
		
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
			stmt.setString(1, cliente.getCpf());
						
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}

	public Cliente pesquisarPorCpf(String cpf){
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String consulta = "SELECT * FROM celular.cliente WHERE cliente.cpf = ";
		//String consultaCompleta = consulta.concat(cpf);
		try{	
			stmt = connection.prepareStatement(consulta+cpf);
			resultSet = stmt.executeQuery();
			
			
			while (resultSet.next()){
				
				Cliente cliente = new Cliente();
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNomeCli(resultSet.getString("nomeCli"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				
				return cliente;
				
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
