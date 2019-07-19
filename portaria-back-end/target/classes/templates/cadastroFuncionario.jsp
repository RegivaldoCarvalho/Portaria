<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Condominio</title>
    <link rel="stylesheet" href="../static/bootstrap/css/bootstrap.min.css"
          href="../static/bootstrap/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Alegreya">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arapey">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" type="text/css" href="../static/css/styles.min.css">
</head>

<body>
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark navbar-custom">
    <div class="container"><a class="navbar-brand" href="index.html">Condominio</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarResponsive"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="/index"
                                                            style="color: #ffffff;">SAIR</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" data-aos="fade-left" style="width: 350px;margin-top: 174px;">
    <form:form action="add" method="post" modelAttribute="funcionario">
        <label class="d-md-flex justify-content-md-center" style="width: 292px;"><b>CADASTRO FUNCIONÁRIO</b></label>
        <form:input type="text" id="nome" name="nome" placeholder="Nome" path="nome"
               style="width: 292px;margin-top: 18px;"
               class="form-control"/>
        <form:input type="number" id="cpf" name="cpf" placeholder="CPF" path="cpf"
               style="width: 292px;margin-top: 18px;" class="form-control"/>
        <select style="margin-top: 14px;width: 292px;height: 30px;">
            <option value="">Porteiro</option>
            <option value="">Sindico</option>
        </select>
        <form:input class="form-control" type="password" path="senha"
               name="senhaFuncionario" id="senha"
               placeholder="Senha"/>
        <form:button class="btn btn-info" type="submit"
                style="width: 292px;margin-bottom: 6px;background-color: #4988e8;margin-top: 18px;">SALVAR CADASTRO
        </form:button>
    </form:form>
</div>
<script src="../static/js/jquery.min.js"></script>
<script src="../static/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
<script src="../static/js/script.min.js"></script>
</body>

</html>