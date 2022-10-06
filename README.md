# Gerenciamento Estoque - Trabalho de Banco de Dados II 
* **Author**: Eduardo Mendonça 
* **University**: UDESC
* Gerenciamento de Estoque para o trabalho de BAN II, onde será realizada a entrada e saída de **produtos/pedidos**.

- **Para a compilação:** Primeiramente clonar o projeto e adicionar a uma IDE de sua escolhar.
Após isso, acessar a pasta _/Banco_ e pegar o dump do Banco de Dados e subir em um banco Postgres.
Feito isso, alterar o arquivo application.properties como nome do banco de dados em que o dump foi subido, assim como a senha e o user para acesso ao banco de dados. 
Realizado os passos anteriores, basta iniciar a aplicação que será buildado normalmente o projeto.

- **Para Execução:** Para a execução  do projeto acessar o https://www.postman.com/ e realizar o cadastro caso não estiver uma conta ou realizar o login.
Feito isso deverá ser criado uma collections, adicionando uma requisição a mesma. 
Realizado isso passar os comando REST desejado juntamente com o caminhos que deseja. 
* Ex: http://localhost:8082/request -> Para acessar a tabela Pedido
* /request -> Pedido
* /requestStatus -> Status do pedido
* /sender -> Remetente
* /recipient -> Destinatario
* /address -> Endereco
* /product -> Produto
