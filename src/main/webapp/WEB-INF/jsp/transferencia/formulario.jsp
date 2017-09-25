<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>
		  <h1>Transferencia</h1>
		<c:if test="${not empty errors}">
		  <div class="alert alert-danger">
		    <c:forEach var="error" items="${errors}">
		        ${error.category} - ${error.message}<br />
		    </c:forEach>
		  </div>
		</c:if>
	  
	  			
	  <form action="<c:url value='/transferencia'/>" method="post">
	    <input type="hidden" name="transferencia.id" value="${conta.id}"/>
	    <div class="form-group">
	    	Dados da Conta Origem <br />
		    <label for="transferencia.contaOrigem.agencia">Agencia:</label>
		    <input class="form-control" type="text" name="transferencia.contaOrigem.agencia"
		    	placeholder="0000" value="${transferencia.contaOrigem.agencia}"/>
		    <label for="transferencia.contaOrigem.numero">numero:</label>
		    <input class="form-control" type="text" name="transferencia.contaOrigem.numero"
		      placeholder="00000-6" value="${transferencia.contaOrigem.numero}"/>
		</div>
		</hr />
	    <div class="form-group">
		    Dados da Conta Destino <br />
		    <label for="transferencia.contaDestino.agencia">Agencia:</label>
		    <input class="form-control" type="text" name="transferencia.contaDestino.agencia"
		    	placeholder="0000" value="${transferencia.contaDestino.agencia}"/>
		    <label for="transferencia.contaDestino.numero">numero:</label>
		    <input class="form-control" type="text" name="transferencia.contaDestino.numero"
		      placeholder="00000-6" value="${transferencia.contaDestino.numero}"/>
		</div>
		</hr />
		 <div class="form-group">
			<label for="transferencia.valor">Valor:</label>
		    <div class="input-group">
				<div class="input-group-addon">$</div>
				<input class="form-control" type="text" name="transferencia.valor"
		      		placeholder="0,00" value="${transferencia.valor}"/>
		    </div>
	    	<label for="transferencia.data">Data:</label>
		    <input type="text" name="transferencia.data" id="data" class="form-control"
		    	placeholder="01/01/2010" value="${transferencia.data}"/>
		</div>
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
		
<c:import url="/WEB-INF/jsp/footer.jsp"/>