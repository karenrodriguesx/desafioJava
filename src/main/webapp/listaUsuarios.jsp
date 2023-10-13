<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.karenrodrigues.model.JavaBeans" %><%--
  Created by IntelliJ IDEA.
  User: karen.rodrigues
  Date: 11/10/2023
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<JavaBeans> listaUsuarios = (ArrayList<JavaBeans>) request.getAttribute("usuarios");
%>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
    <script>
        function confirmar(id) {
            let resposta = confirm("Confirma a exclusão?")
            if (resposta === true){
                //alert(id)
                window.location.href="delete?id="+id
            }
        }
    </script>
    <title>Lista de cadastros</title>
</head>
<body>

<div id="div-lista">
    <h1>Lista de Cadastros</h1>
    <table id="lista">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Profissão</th>
            <th>Idade</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%for (int i = 0 ; i< listaUsuarios.size() ; i++) {%>
        <tr>
            <td><%=listaUsuarios.get(i).getNome()%></td>
            <td><%=listaUsuarios.get(i).getProfissao()%></td>
            <td><%=listaUsuarios.get(i).getIdade()%></td>
            <td><a href="javascript: confirmar(<%=listaUsuarios.get(i).getId()%>)"><input type="button" value="Excluir" class="btn-excluir"></a></td>
        </tr>
        <%}%>
        </tbody>
    </table><br>

    <a href="cadastro.jsp"><input type="button" value="Novo cadastro" class="btn-lista"></a></div><br>

</body>
</html>
