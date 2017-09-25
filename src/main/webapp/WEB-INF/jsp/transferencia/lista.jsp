<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>
		<h1>Transferencias</h1>	
		<c:if test="${not empty mensagem}">
		    <div class="alert alert-success">${mensagem}</div>
		</c:if>	
		<div class="table-responsive">
			<table class="table table-stripped table-hover table-bordered">
	        	<thead>
					<tr>
						<th>ID</th>		
						<th>Valor</th>				
						<th>Taxa</th>				
						<th>Data</th>				
						<th>Data Agendamento</th>				
						<th>Conta Origem</th>					
						<th>Conta Destino</th>				
						<th>#</th>				
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${transferenciaList}" var="transferencia">
						<tr id="transferencia-${transferencia.id}">
							<td>${transferencia.id}</td>	
							<td>${transferencia.valor}</td>		
							<td>${transferencia.taxa}</td>				
							<td>${transferencia.data.time}</td>			
							<td>${transferencia.dataAgendamento.time}</td>				
							<td>${transferencia.contaOrigem.agencia} - ${transferencia.contaOrigem.numero}</td>
							<td>${transferencia.contaDestino.agencia} - ${transferencia.contaDestino.numero}</td>				
							<td>
								<div>
									<form action="<c:url value='/transferencia'/>" method="post">
										<input type="hidden" name="transferencia.id" value="${transferencia.id}">
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
	    <a href="<c:url value='/transferencia/formulario'/>">
		    Adicionar mais transferencias!
		</a>
		<hr />
		<a href="<c:url value='/transferencia/listaXML'/>" target="_blank">
		    Acesse essa lista em XML!
		</a>
		ou 
		<a href="<c:url value='/transferencia/listaJson'/>" target="_blank">
		    Acesse essa lista em JSON! 
		</a>

<c:import url="/WEB-INF/jsp/footer.jsp"/>