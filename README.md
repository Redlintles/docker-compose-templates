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

