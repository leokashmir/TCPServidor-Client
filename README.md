# Servidor TCP
###### Projeto Basico para um Servidor TCP 
Este projeto tem como objetivo a criação de um Servidor TCP, onde ao inicia-lo é possivel definir a porta a ser utilizado.

O Objetivo deste servidor é esta apto a atender diversos serviços sendo executados em varias portas. 
A principio jã tem um serviço implementado para testes. Este serviço serviço realiza uma busca por Titulos de Filmes no site do IMDB 
(https://www.imdb.com), caso haja alguma alteração no layout do site, possivelmente este serviço não mais será valido.

## Servico "Busca de Titulos de Filmes"
O serviço de busca de filmes utiliza Payloads.</br>

- Para Request:<br>
*\<query length\>:\<query\>*  

- Para Response:<br>
*\<payload length\>:\<payload\>*

OBS: O comprimento da query e payload não deve considerar o ':' separador.

*Exemplo:*<br>
Consulta: Star Trek <br>
-Request =>  10:Star Trek

Resposta: Star Trek O Filme <br>
-Response =>  18:Star Trek O Filme


## Tecnologias

- Java JDK 8   -> https://www.oracle.com/java/technologies/javase-jdk8-downloads.html
- JUnit        -> https://junit.org/junit5/
- Gradle       -> https://docs.gradle.org
- JSoup        -> https://jsoup.org
- Google Guice -> https://github.com/google/guice/wiki/GettingStarted
 

## Testando o Servidor e Serviços

###### Java Instalado?

-Você precisa ter o Java instalado em seu computador. Caso contrario, sera necessario instala-lo.</br> Link para fazer o donwload da instalação https://www.oracle.com/technetwork/java/javase/overview/index.html </br> Selecione o arquivo, conforme seu sistema operacional.
Depois de baixar o arquivo JDK, basta executa-lo e seguir os passo da isntalação.



###### Testando o Serviço 
 
 **Passo 1 Baixando os Arquivos**
 
 1. Passo: Baixar o Servidor e o Client
 2. Vá até o Projeto
 3. Na Raiz do Projeto existe a Pasta **VersaoAtual** Acesse ela.
 4. Dentro da pasta, existem 4 arquivos: ** AppClient-1.0.jar, AppServer-1.0.jar, startClient.bat, startServer.bat **
 5. Faça o Donwload deles.
 
 **Passo 2 Iniciando o Servidor**
 
 1. Com os arquivos já salvos em seu computador, acesse a pasta onde foram salvos.
 2. Clique 2x no arquivo startServer.bat ou AppServer-1.0.jar
 3. Ira abrir uma janela para iniciar o servidor. O Campo Port ja vem preenchido com a porta padrão 5551, você pode altera-lá. 
 4. Clique em **Start Server**
 5. Ao conectar ele apresentara a mensagem "Conected PORT ====> 5551" por exemplo.
 6. Para desconectar o servidor, basta clicar em **Disconnect**
 
 **Passo 3 Testar atraves do Client "AppClient"**
 1. Com o servidor no ar, vamos testa-lo.
 2. Clique 2x no arquivo startClient.bat ou AppClient-1.0.jar
 3. Ira abrir uma janela para pesquisa.
 4. Preencha o campo Host (ele ja vem como padrao o localhost)
 5. Preencha o campo Port, conforme você preencheu ao executar o servidor (ele ja vem preenchido com a porta padrao 5551) 
 6. Para realizar a pesquisa, basta inserir um texto e clicar na lupa
 7. Pronto.
  >Obs: Você pode realizar um teste, com o Titulo "Star Trek" a pesquisa irá retornar uma lista de titulos.
 
 **Passo 3.1 Testar atraves de um cliente customizado**
 
  
