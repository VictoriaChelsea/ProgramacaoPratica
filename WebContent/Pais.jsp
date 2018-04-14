<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Pais" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Pais</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		
		</head>
	<body>
		<% Pais pais =(Pais)request.getAttribute("pais"); %>
	  <div id="main" class="container">
            <h3 class="page-header">Visualizar Pais #<%=pais.getId() %></h3>
            <div class="row">
                <div class="col-md-12">
					<p><strong>Nome</strong>
                    </p>
                    <p>
                        <%=pais.getNome() %>
                    </p>
                </div>
            </div>
             <div class="row">
                <div class="col-md-12">
					<p><strong>População:</strong>
                    </p>
                    <p>
                        <%=pais.getPopulacao() %>
                    </p>
                </div>
            </div>
			<div class="row">
                <div class="col-md-12">
					<p><strong>Area:</strong>
                    </p>
                    <p>
                        <%=pais.getArea() %>
                    </p>
                </div>
            </div>
             <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.html" class="btn btn-default">Voltar</a>
                </div>
            </div>
		</div>
	  <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
	</body>
</html>