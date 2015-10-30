package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import entity.Cliente;

@WebServlet ("/CtrlCliente")
public class CtrlCliente extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{

		
		String cmd = (String) req.getParameter("cmd");
		
		if(cmd.contains("Gravar"))
		{
			boolean valida = new ClienteDao().gravar(getCliente(req));
			RequestDispatcher reqDisp=req.getRequestDispatcher("\\index.jsp");
			try {
				if(valida)
				{
					req.setAttribute("msg", "Gravado com sucesso");
				}
				else
				{
					req.setAttribute("msg", "Ocorreu um problema na gravação");
				}
				
				reqDisp.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(cmd.contains("Remover"))
		{
			boolean valida = new ClienteDao().remover(getCliente(req));
			RequestDispatcher reqDisp=req.getRequestDispatcher("\\index.jsp");
			try {
				if(valida)
				{
					req.setAttribute("msg", "Removido com sucesso");
				}
				else
				{
					req.setAttribute("msg", "Ocorreu um problema na remoção");
				}
				
				reqDisp.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(cmd.contains("Alterar"))
			
		{
			boolean valida = new ClienteDao().alterar(getCliente(req));
			RequestDispatcher reqDisp=req.getRequestDispatcher("\\index.jsp");
			try {
				if(valida)
				{
					req.setAttribute("msg", "Alterado com sucesso");
				}
				else
				{
					req.setAttribute("msg", "Ocorreu um problema na Alteração");
				}
				
				reqDisp.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(cmd.contains("Listar"))
		{
			try{
			ArrayList<Cliente>listar = 	new ClienteDao().listarClientes();
			RequestDispatcher reqDisp=req.getRequestDispatcher("\\Listar.jsp");
			req.setAttribute("listar", listar);
			reqDisp.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		Cliente cliente = new Cliente();
		cliente.setCpf((String) req.getParameter("cpf"));
		cliente = new ClienteDao().listarClientesEspecifico(cliente);
		try{
		RequestDispatcher reqDisp=req.getRequestDispatcher("\\index.jsp");
		req.setAttribute("cliente", cliente);
		reqDisp.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Cliente getCliente(HttpServletRequest req)
	{
		Cliente cliente = new Cliente();
		
		cliente.setCpf(String.valueOf(req.getParameter("txtCpf")));
		cliente.setEmail(String.valueOf(req.getParameter("txtEmail")));
		cliente.setNome(String.valueOf(req.getParameter("txtNome")));
		
		return cliente;
		
	}
}
