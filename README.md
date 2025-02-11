# Módulo 32 - Gerenciamento de Produtos com JPA e Hibernate

Este projeto demonstra operações básicas de CRUD (Create, Read, Update, Delete) utilizando JPA com Hibernate para gerenciamento de produtos em um banco de dados.

## Tecnologias Utilizadas
- Java
- JPA (Java Persistence API)
- Hibernate
- JUnit para testes

## Funcionalidades
- **Cadastrar Produto**: Persiste um novo produto no banco de dados.
- **Consultar Produto**: Busca um produto pelo código.
- **Atualizar Produto**: Modifica os dados de um produto existente.
- **Excluir Produto**: Remove um produto do banco de dados.

## Estrutura do Código
- `Produto.java` - Entidade mapeada para a tabela `PRODUTO`.
- `ProdutoDao.java` - Implementa as operações de persistência utilizando `EntityManager`.
- `ProdutoTest.java` - Testes unitários para validar o funcionamento do CRUD.

## Como Executar
1. Configure um banco de dados compatível.
2. Ajuste a configuração de persistência (`persistence.xml`).
3. Execute os testes JUnit para validar a aplicação.
