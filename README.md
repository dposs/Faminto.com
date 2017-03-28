# Faminto.com
Github: https://github.com/dposs/Faminto.com 

**Tecnologias envolvidas no projeto:**
- Java 1.8.0 revision 121 (JEE 7)
- Primefaces 6.1.RC2
- Apache Maven 3.3.9
- JBoss Wildfly 10.1.0
- Eclipse Neon.2 Release (4.6.2)
- JBoss Tools 4.4.3

**Melhorias a serem desenvolvidas:**

- [ ] Testes Unit�rios. Sugest�o:
	- JUnit/Arquillian
- [ ] Persist�ncia em Base de Dados (Est� armazenando atualmente os valores em mem�ria). Sugest�es:
	- JPA + Hibernate
	- Ibatis
- [ ] Autentica��o de Usu�rio (Est� utilizando usu�rio fake "Administrador").
- [ ] Implementa��o de Perfis de Usu�rio.
- [ ] Persist�nia da senha do usu�rio com seguran�a (hash + salt).
- [ ] Internacionaliza��o e properties para strings.
- [ ] Tratamento de Erros.
- [ ] Tratamento de Regras de Neg�cio.Exemplo:
	- Exclus�o de Restaurantes que est�o sendo utilizados em Vota��es.
	- Exclus�o de Vota��es que possuem Votos.
	- Altera��o da data de uma Vota��o que j� possui Votos.
	- etc...
- [ ] Organiza��o do CSS.

**Screenshots:**

*Vota��es*
![Votacoes](https://github.com/dposs/Faminto.com/blob/development/assets/votacoes.png)

*Restaurantes*
![Restaurantes](https://github.com/dposs/Faminto.com/blob/development/assets/restaurantes.png)

*Usu�rios*
![Usuarios](https://github.com/dposs/Faminto.com/blob/development/assets/usuarios.png)