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

OBS: 1. O comprimento da query e payload não deve considerar o ':' separador.
     2. A lista possue o carcter "¶" no final de cada titulo, parque que você possa manipular os intens.
     
*Exemplo:*<br>
Consulta: Star Trek <br>
-Request =>  9:Star Trek

Resposta: Star Trek O Filme <br>
-Response =>  17:Star Trek O Filme


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
 Pronto, conectado. Para desconectar o servidor, basta clicar em **Disconnect**
 
 **Passo 3 Testar atraves do Client "AppClient"**
 1. Com o servidor no ar, vamos testa-lo.
 2. Clique 2x no arquivo startClient.bat ou AppClient-1.0.jar
 3. Ira abrir uma janela para pesquisa.
 4. Preencha o campo Host (ele ja vem como padrao o localhost)
 5. Preencha o campo Port, conforme você preencheu ao executar o servidor (ele ja vem preenchido com a porta padrao 5551) 
 6. Para realizar a pesquisa, basta inserir um texto e clicar na lupa
 7. Pronto.
  >Obs: Você pode realizar um teste, com o Titulo "Star Trek" a pesquisa irá retornar uma lista de titulos.
 
 **Passo 3.1 Testar atraves de outro client**<br>
 Você poder realizar teste de diversos clients, desde que consiga enviar o request conforme o *paylod* *\<query length\>:\<query\>*.
 Um exemplo com Telnet no Windows. Por padrão, o Telnet vem desabilitado nas versões mais novas do windows, aqui um passo a passo para habilita-lo:
 
 1. Em seu Windows 10, clique na Lupa e digite "Painel de Controle".
 2. Em seguida clique sobre a ferramenta "Painel de Controle"
 3. Assim que abrir a janela de Painel de Controle, dentre as categorias, clique em Programas.
 4. Dentre todas as opções que surgirem, clique em Ativar ou desativar recursos do Windows. (Você precisa ter privilégios de     administrador em sua máquina para poder alterar estas configurações.)
 5. Surgirá uma nova tela que centraliza todos os recursos de podem ser ativados/desativados.
 6. O recurso Telnet costuma ser a quarta opção. Basta marcar a caixa de seleção ao seu lado e clicar em OK.
 7. Assim que clicado em OK, uma nova janela com status da habilitação do recurso aparecerá.
 
 Agora com o Telnet Habilitado, vamos ao teste.
 1. Inicie o servidor ( Siga as instruções do Passo 2)
 2. Em seu Windows 10, clique na Lupa e digite "cmd".
 3. Em seguida clique sobre a "Prompt de Comando"
 4. Na tela do prompt digite "telnet localhost 5551" e der um "Enter" (Lembrando que a porta, é que foi configurada no servidor)
 5. Se a conexão for estabelecida, a tela ficara apenas com uma barra piscando no alto a esquerda
 6. copie esse payload =>  9:Star Trek 
 7. clique no icone da janela, um menu aparecera
 8. Clique em editar -> colar
 9. A tela permanecera sem texto
 10. Aperte o "Enter" e aguarde o retorno.
 
 - O retorno sera este => *6098:┬ÂJornada nas Estrelas┬Â┬ÂStar Trek┬Â┬ÂJornada nas Estrelas: O Filme┬Â┬ÂJornada nas Estrelas: A Nova GeraþÒo┬Â┬ÂStar Trek: Discovery┬Â┬ÂStar Trek: Picard┬Â┬ÂJornada nas Estrelas: Deep Space Nine┬Â┬ÂJornada nas Estrelas: Voyager┬Â┬ÂJornada nas Estrelas: Enterprise┬Â┬ÂStar Trek: Short Treks ...*
 
 
  ## Suporte
  
| Componente  |  Versão  |
| ------------| ---------|
|  AppClient  |  1.0     |
|  AppServer  |  1.0     |
  
  
  **Contatos**
* leonardobarrosbhz@gmail.com 
  
