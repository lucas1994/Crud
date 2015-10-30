package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Cliente;

public class ClienteDao {
	
	public ClienteDao()
	{
		Cliente cli = new Cliente();
		cli.setCpf("37714720789");
		cli.setNome("Luan Santos");
		cli.setEmail("luan.email@hotmail.com");
		
		//System.out.println(gravar(cli));
	}

	public boolean gravar(Cliente cliente)
	{
		
		String sql = "insert into Cliente(cpf,nome,email) values (?,?,?)";
		try {
			PreparedStatement ps = new GenericCon().getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getCpf());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getEmail());
			ps.execute();
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	
	}
	
	public ArrayList<Cliente> listarClientes()
	{
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		String sql = "select CPF as cpf,nome as NOME, email as EMAIL from Cliente";
		try {
			PreparedStatement ps = new GenericCon().getConnection().prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			Cliente cli = new Cliente();
			while(resultSet.next())
			{
			
				cli.setCpf(resultSet.getString("CPF"));
				cli.setNome(resultSet.getString("NOME"));
				cli.setEmail(resultSet.getString("EMAIL"));
				listaClientes.add(cli);
				cli = new Cliente();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaClientes;
	}
	
	public Cliente listarClientesEspecifico(Cliente cliente)
	{
		String sql = "select CPF as cpf,nome as NOME, email as EMAIL from Cliente where cpf like (?)";
		Cliente cli = new Cliente();
		try {
			PreparedStatement ps = new GenericCon().getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getCpf());
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next())
			{
			
				cli.setCpf(resultSet.getString("CPF"));
				cli.setNome(resultSet.getString("NOME"));
				cli.setEmail(resultSet.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}
	
	public boolean remover(Cliente cliente)
	{
		String sql = "delete from Cliente where CPF like (?)";
			
		try {
			PreparedStatement ps = new GenericCon().getConnection().prepareStatement(sql);
			ps.setString(1, cliente.getCpf());
			ps.execute();
			return true;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public boolean alterar(Cliente cliente)
	{
		String sql = "Update  Cliente SET nome=(?),email=(?) where cpf like (?)";
			PreparedStatement ps;
			try {
				ps = new GenericCon().getConnection().prepareStatement(sql);
			
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getEmail());
				ps.setString(3, cliente.getCpf());
				ps.execute();
				
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
	}
	
	
	
}
