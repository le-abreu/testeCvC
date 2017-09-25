<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>		
	  <h1>Cadastrar Conta</h1>
		<c:if test="${not empty errors}">
		  <div class="alert alert-danger">
		    <c:forEach var="error" items="${errors}">
		        ${error.category} - ${error.message}<br />
		    </c:forEach>
		  </div>
		</c:if>
	  
	  			
	  <form action="<c:url value='/conta'/>" method="post">
	    <input type="hidden" name="conta.id" value="${conta.id}"/>
	    <label for="conta.agencia">Agencia:</label>
	    <input class="form-control" type="text" name="conta.agencia"
	    	placeholder="0000" value="${conta.agencia}"/>
	    <label for="conta.numero">Numero:</label>
	    <input class="form-control" type="text" name="conta.numero"
	      placeholder="00000-6" value="${conta.numero}"/>
	    <label for="conta.nome">Nome:</label>
	    <input class="form-control" type="text" name="conta.nome" value="${conta.nome}"
	     placeholder="Seu nome"/>
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
		

<c:import url="/WEB-INF/jsp/footer.jsp"/>	