<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../base.css">
</head>
<body>

    </header>
    <nav>
        <ul class="nav nav-tabs">
            <li><a href="<c:url value='/conta/lista' />">Contas</a></li>
            <li><a href="<c:url value='/transferencia/lista' />">Transferencias</a></li>
		</ul>
   </nav>
   <div class="container">
       <main class="col-sm-8">
