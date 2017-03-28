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

- [ ] Testes Unitários. Sugestão:
	- JUnit/Arquillian
- [ ] Persistência em Base de Dados (Está armazenando atualmente os valores em memória). Sugestões:
	- JPA + Hibernate
	- Ibatis
- [ ] Autenticação de Usuário (Está utilizando usuário fake "Administrador").
- [ ] Implementação de Perfis de Usuário.
- [ ] Persistênia da senha do usuário com segurança (hash + salt).
- [ ] Internacionalização e properties para strings.
- [ ] Tratamento de Erros.
- [ ] Tratamento de Regras de Negócio.Exemplo:
	- Exclusão de Restaurantes que estão sendo utilizados em Votações.
	- Exclusão de Votações que possuem Votos.
	- Alteração da data de uma Votação que já possui Votos.
	- etc...
- [ ] Organização do CSS.

**Screenshots:**

*Votações*
![Votacoes](https://github.com/dposs/Faminto.com/blob/development/assets/votacoes.png)

*Restaurantes*
![Restaurantes](https://github.com/dposs/Faminto.com/blob/development/assets/restaurantes.png)

*Usuários*
![Usuarios](https://github.com/dposs/Faminto.com/blob/development/assets/usuarios.png)