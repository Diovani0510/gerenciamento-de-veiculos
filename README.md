
# API de gerenciamento de veículos 

Abrange criação, edição, leitura e remoção de veículos.

## Rodando a aplicação 
Antes de executar, você pode executar o comando `docker-compose up -d` para preparar o banco de dados local.

Para rodar a aplicação local basta executar o método main do arquivo `GerenciamentoDeVeiculosApplication.java` com o perfil `develop` passado como parâmetro (`--spring.profiles.active=develop`).

## Documentação
A documentação desta API se encontra no path `/swagger-ui/index.html`, mas também pode ser acessada através do path `/v3/api-docs`, onde também é possível importar o JSON gerado no client de sua preferência (Como POSTMAN ou INSOMNIA)
