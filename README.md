fp2-avaliacao-2014-5
====================

fundamentos prog 2 prova 5 extra prof Bogado

definição
====================

Desejamos implementar um ordenador de arquivos texto. O ordenador recebe um arquivo contendo linhas de texto que desejamos ordenar em ordem ascendente, usando o critério de ordem alfabética, e gera um outro arquivo contendo as linhas ordenadas.

Para aumentar a eficiência, desejamos ordenar vários arquivos ao mesmo tempo, de modo a melhor aproveitar os recursos de processamento do hardware.

Para conseguir este resultado, cada orenação deve ser feita em um thread.

A interface de usuário deve solicitar que sejam informados nomes de arquivos até que o usuário informe uma linha em branco. O programa deve aguardar o  final do processamento de todos os arquivos antes de terminar.

Uma interação típica deste programa seria:

 
Ordenar> /tmp/teste/nomes.txt

Ordenar> /var/log/syslog

Ordenar>

Aguardando o processamento de 1 arquivo...


 

Para executar a tarefas a seguir, clone o projeto disponível em

 

https://github.com/whbogado/fp2-avaliacao-2014-1-5.git



Tarefas
=======================

* Implemente a classe Avaliacao5 que conterá o seu programa principal. (valor 0,2)
* Dentro do pacote utfpr.ct.dainf.if62c.avaliacao, crie a classe Ordenador como um Thread. O construtor desta classe deve receber, o caminho do arquivo a ser ordenado. (valor 0,3)
* Na classe Ordenador, implemente o método privado carrega() para ler o arquivo de entrada e armazenar as linhas em uma lista de strings. O método deve assegurar que o arquivo seja fechado após o processamento. (valor 0,4)
* Na classe Ordenador, implemente o método privado grava() para gravar os dados da lista de strings no arquivo de saída. O arquivo de saída deve ter o mesmo nome no arquivo de entrada porém com o sufixo ord, por exemplo, se o arquivo de entrada era entrada.txt, o arquivo de saída deve ser entrada.txt.ord. O método deve assegurar que o arquivo seja fechado após o processamento.  (valor 0,4)
* Na classe Ordenador, implemente o método público ordena(). Este método deve usar o método carrega() para carregar o arquivo, ordenar a lista de strings e usar o método grava() para gerar o arquivo de saída. (valor 0,4)
* No programa principal, leia caminhos de arquivos até que o usuário entre com um nome de arquivo em branco. Para cada nome de arquivo lido, inicie um thread ordenador. Aguarde a conclusão de qualquer ordenação pendente com uma mensagem, conforme o exemplo, antes de efetivamente terminar o programa. (valor 0,3)

