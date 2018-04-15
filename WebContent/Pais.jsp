<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Pais" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<title>Pais</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"  content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		
		</head>
	<body>
		<c:import url="menu.jsp"/>
	  <div id="main" class="container">
            <h3 class="page-header">Visualizar Pais #${cliente.id }</h3>
            <div class="row">
                <div class="col-md-12">
					<p><strong>Nome</strong>
                    </p>
                    <p>
                        ${pais.nome}
                    </p>
                </div>
            </div>
             <div class="row">
                <div class="col-md-12">
					<p><strong>População:</strong>
                    </p>
                    <p>
                        ${pais.populacao}
                    </p>
                </div>
            </div>
			<div class="row">
                <div class="col-md-12">
					<p><strong>Area:</strong>
                    </p>
                    <p>
                       ${pais.area}
                    </p>
                </div>
            </div>
             <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
		</div>
	  <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
	</body>
</html>