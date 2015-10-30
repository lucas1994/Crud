<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.ArrayList" %>
      <%@ page import="entity.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Cliente</title>
</head>
<%
Cliente clienteEpecifico = new Cliente();
clienteEpecifico.setCpf("");
clienteEpecifico.setNome("");
clienteEpecifico.setEmail("");
if(request.getAttribute("cliente")!=null){
	clienteEpecifico = (Cliente)request.getAttribute("cliente");
}
%>
<body>
    <center>

    <p><h1>Cadastro Cliente</h1></p><br/>
 <%try{ String msg =String.valueOf( request.getAttribute("msg")); if(msg.equalsIgnoreCase("null")){msg="";} %>   
    <form  action="./CtrlCliente" method="post">
    <h2><%= msg %></h2>
    
    <%}catch (Exception e){} %>
    <table>
	    <tr>
     
	    <td>CPF:</td><td><input  pattern="[0-9]{11}" name="txtCpf" placeholder="08214568871" value="<%=clienteEpecifico.getCpf() %>"/></td>
	    </tr>
	     <tr>
	    <td>Nome:</td><td><input type="text" name="txtNome" placeholder="Nome Sobrenome" value="<%=clienteEpecifico.getNome() %>"/></td>
	    </tr>
	     <tr>
	    <td>Email:</td><td><input type="email" name="txtEmail" placeholder="email.algo@mail.com" value="<%=clienteEpecifico.getEmail() %>"/></td>
		</tr>
		  </table>
		  <table>
		<tr>
		<td><input type="submit" name=cmd value="Gravar "/></td>
		<td><input type="submit" name=cmd value="Alterar"/></td>
		</tr>
		<tr>
		<td><input type="submit" name=cmd value="Remover"/></td>
		<td><input type="submit" name=cmd value="Listar "/></td>
		</tr>
		</table>
  
    </form>
       <table border="0px">
           <tr> 
           <%if (request.getAttribute("listar")!=null){
           ArrayList<Cliente> listar = (ArrayList) request.getAttribute("listar");  %>
           <td>CPF</td><td>Nome</td><td>Email</td>
    	</tr>
    <%

   	 for(Cliente cliente:listar){
   	    %>
		<td><%=cliente.getCpf() %></td><td><%=cliente.getNome() %></td><td><%=cliente.getEmail()%></td>

</tr>
    <%}} %>
</table>
    </center>
    </body>

</body>
</html>