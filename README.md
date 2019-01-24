# S1 Challenge - Ordenação de livros

Implementação do desafio para vaga de estágio Full Stack na empresa [SumOne](http://www.sumone.com.br/). Esse desafio consiste basicamente em projetar um serviço de ordenação e classificação de livros para gestão de uma biblioteca.

## Requisitos para execução
+ Java 1.8.0_181

## Instalando o Java
Para instalar o Java basta seguir [este](https://websiteforstudents.com/how-to-install-oracle-java-jdk8-on-ubuntu-16-04-17-10-18-04-desktops/) tutorial.

## Executando o programa
Para a execução do programa, primeiramente é necessário subir ao diretório [src](https://github.com/raulmff/bookshelf-sorting/tree/master/src). Depois, compile o programa da seguinte forma:
```
  javac Main.java
```
Agora, execute o programa conforme abaixo:
```
  java Main
```

## Livros presentes para ordenação
Os livros presentes no código são os passados no documento do desafio. Os livros podem ser modificados na classe [SortingServiceClient.java](https://github.com/raulmff/bookshelf-sorting/blob/master/src/SortingServiceClient.java).

## Configurando o serviço de ordenação
Para configurar o serviço de ordenação basta abrir o arquivo "app.config" e editá-lo. A maneira que as regras para a ordenação devem ser escritas também está presente no próprio arquivo na forma de comentários. As regras devem ser escritas da seguinte forma:
```
  <attribute#1> <direction#1>, ..., <attribute#N> <direction#N>
```
Sendo que os atributos podem assumir os valores de:
+ title
+ author
+ edition

E as direções:
+ asc
+ desc

"asc" representando a direção ascendente e "desc" descendente.

Um exemplo de como devem ser escritas as regras segue abaixo:
```
  rules = edition desc, author desc, title asc
```
A utilização de letras maiúsculas ou minúsculas não interfere no resultado.
