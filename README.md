# Projeto CVC - TESTE	
Esse projeto de teste visa mostrar como utilizar o vrpator de maneira simples para mapear algumas URI's para atender a necessidade e desenhar algumas telas para consultas simples.

#Utilizando as tecnologias VRaptor, Hibernate, Java 8, procurei simplificar e controlar de maneira separada,


Padrões de projetos que me ajudaram a modelar a api para deixar um pouco mais simples, 
Observer já ganhei com o CDI integrado na versão do Vraptor para criar minhas instancias inicias de Conta e Transferencia

Strategy para montar os calculos e deixar a estrutura para calcular evoluir de arcodo com a necessidade, mesmo sendo usado com o longo da implementação as regras do calculo era simples e deixei com a visão de utilizar algo com a mesma estrutura.

ChainOfResponsibility serve bem quando é necessario validarmos algo  e sabemos também qual o próximo cenário que deve ser validado, caso o anterior não satisfaça a condição, podendo montar a cadeia de calculadorCVC


Java 8
Para facilitar as validações em datas, utilizei recurso da nova API do Java LocalDate

VRaptor Controller

Hibernate em memoria 



Subir:
No pacote do projeto rodar:
mvn tomcat7:run

Acessar a URL: http://localhost:8080/testeCvC

Caso queira cadastrar uma conta para ficar mais simples o cadastro da Transferencia, pode navegar para Contas no menu acima e Adicionar nova conta


Agora vamos ao que interessa, o cadastro de Transferencia

Abaixo as contas já pre-cadastradas no start da app
Agencia	Numero		
0001	11111-6,			
0001	44444-6	,		
0001	22222-6	,		
0001	33333-6	,	

Utilizar uma para conta origem e outra para conta destino, 
Se a pergunta que vcs gostariam de fazer é se eu validei se pode uma mesma conta cadastrar para ela mesmo a resposta é não eu não validei nada disso, caso seja teimoso pode tentar.

Procurei focar na separação.


Bem vamos aos testes, sei que tem muito mais o que usar, poderia validar a camada DAO e ate mesmo a de telas usando selenium, porém foquei em criar as regras usando os teste 


Por ultimo achei que a regra D ultima regra "Valores maiores que $2.000 seguem a taxação tipo C" meio que estranha, pelo fato da opção C  ultima regra "acima de 40 dias da data de agendamento 1.7%"
abrangir o restante que não pegava nas regras anteriores, posso ter deixado passar despercebido ou feito confusão na logica, porém ficou bem facil de controlar pois ficou como uma cadeia a ser montada então caso a necessidade de montar novas regras so usar as opções de acordo com que seja necessário validar ou calcular.

