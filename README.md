# docker-compose-templates
Um repositório para templates de aplicações web em docker-compose, para facilitar o desenvolvimento.

A idéia é clonar um desses templates e desenvolver qualquer aplicação a partir deles, sem ter que se preocupar, até certo ponto com as configurações do docker.

Para rodar qualquer um dos templates instalados aqui, é necessário ter o docker instalado, clonar o repositório, e após acessar o template desejado:

```bash
  docker(-)compose up --build -d
```

Para excluir os containers, rode:

```
  docker(-)compose down
```


## Docker-test-1

Uma aplicação super simples em node que se conecta a um banco de dados mysql, ambos em containers diferentes.
É o primeiro e mais simples template deste repositório, usando apenas o driver do mysql para fazer a conexão.

## Docker-test-2

Uma evolução da primeira aplicação, aqui, faço a integração com o sequelize-cli para uma melhor gestão do schema do banco de dados
contudo, a conexão da aplicação em si com o banco de dados ainda é feita via driver, algo que será removido em breve

## Docker-test-3

Agora incluímos o sequelize no código interno da aplicação

## Docker-test-4

Agora incluímos um front-end feito em react(vite) que consome a API, e um proxy reverso para permitir o frontend consumir essa api sem problemas.

