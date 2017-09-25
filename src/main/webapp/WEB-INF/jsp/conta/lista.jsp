<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>		
		<h1>Contas</h1>	
		<c:if test="${not empty mensagem}">
		    <div class="alert alert-success">${mensagem}</div>
		</c:if>	
		<div class="table-responsive">
			<table class="table table-stripped table-hover table-bordered">
	        	<thead>
					<tr>
						<th>Agencia</th>				
						<th>Numero</th>				
						<th>Nome</th>					
						<th>Saldo</th>				
						<th>#</th>				
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${contaList}" var="conta">
						<tr id="conta-${conta.id}">
							<td>${conta.agencia}</td>				
							<td>${conta.numero}</td>				
							<td>${conta.nome}</td>					
							<td>${conta.saldo}</td>				
							<td>
								<div>
									<a href="<c:url value='/conta/editar?conta.id=${conta.id}'/>">
										<button type="button" class="btn btn-default">
		    							    <span class="glyphicon glyphicon-pencil"></span>
								    	</button>
									</a>
									<a href="<c:url value='/conta?conta.id=${conta.id}'/>">
										<button type="button" class="btn btn-default">
		    							    <span class="glyphicon glyphicon-search"></span>
								    	</button>
									</a>
									<form action="<c:url value='/conta'/>" method="post">
										<input type="hidden" name="conta.id" value="${conta.id}">
									    <button type="submit" name="_method" value="DELETE" 
									    	class="btn btn-default">
		    							    <span class="glyphicon glyphicon-trash"></span>
								    	</button>
									</form>
								</div>
							</td>						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	    <a href="<c:url value='/conta/formulario'/>">
		    Adicionar mais contas!
		</a>
		<hr />
		<a href="<c:url value='/conta/listaXML'/>" target="_blank">
		    Acesse essa lista em XML!
		</a>
		ou 
		<a href="<c:url value='/conta/listaJson'/>" target="_blank">
		    Acesse essa lista em JSON! 
		</a>


<c:import url="/WEB-INF/jsp/footer.jsp"/>	