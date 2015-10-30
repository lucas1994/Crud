<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.ArrayList" %>
      <%@ page import="entity.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar</title>
</head>


<body>
<center>
<h1>Lista de Clientes</h1><br>
       <table border="1px">
           <tr> 
           <%if (request.getAttribute("listar")!=null){
           ArrayList<Cliente> listar = (ArrayList<Cliente>) request.getAttribute("listar");  %>
           <td>CPF</td><td>Nome</td><td>Email</td>
    	</tr>
    	<tr>
    <%

   	 for(Cliente cliente:listar){
   	    %>
		<td><a href="./CtrlCliente?cpf=<%=cliente.getCpf()%>"><%=cliente.getCpf() %></a></td><td><%=cliente.getNome() %></td><td><%=cliente.getEmail()%></td>

</tr>
    <%} %>
    
</table>
<%}else{ %>
<h2> Nenhum dado encontrado</h2>
    <%} %>
    <br>
    <a href="./index.jsp"> Voltar</a>
    </center>
    </body>

</body>
</html>