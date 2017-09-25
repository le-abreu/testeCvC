<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="alura" %>

<c:import url="/WEB-INF/jsp/header.jsp"/>
	<h1>Conta</h1>
	<p>Agencia:${conta.agencia}</p>
	<p>Numero:${conta.numero}</p>
	<p>Nome:${conta.nome}</p>
							
<c:import url="/WEB-INF/jsp/footer.jsp"/>	