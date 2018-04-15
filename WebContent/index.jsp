<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Cadastro de Paises</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		</head>
	<body>
	<c:import url="menu.jsp"/>
		  <div id="main" class="container">
           <form action="ManterPais.do" method="post">
         
        
	           <h3>Cadastro de Paises</h3>
	             <div class="row">
	                <div class="form-group col-md-12">
	                    <label for="nome">Nome:</label>
	                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" />
	                </div>
	             </div>
	             <div class="row">
	                <div class="form-group col-md-6">
	                    <label for="nome">População:</label>
	                    <input type="text" class="form-control" name="populacao" id="populacao" required maxlength="100">
	                </div>
	                <div class="form-group col-md-6">
	                    <label for="nome">Area:</label>
	                    <input type="text" class="form-control" name="area" id="area" required maxlength="100">
	                </div>
	            </div>
	            <div id="actions" class="row">
	                <div class="col-md-12">
	                    <button class="btn btn-default">Cadastrar</button>
	                </div>
	            </div>
          
         </form>
        </div>
		
	  <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
	</body>
</html>