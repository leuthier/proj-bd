# Projeto de Fundamentos de Banco de Dados (2016.2) (MySQL + Java)
>Bac. Sistemas de Informação - UFRPE <br>

- Feito em conjunto com [bernardojr123](https://github.com/bernardojr123)<br>

#### Tutorial em vídeo: [Assistir](https://drive.google.com/open?id=0Bw_EHUVXd5q5ZTNFN0hQcFRjcFE)

#### Requisitos
###### Driver JDBC: [mysql-connector-java-5.1.40.zip] (http://cdn.mysql.com//Downloads/Connector-J/mysql-connector-java-5.1.40.zip)
###### Jar file JCalendar: [jcalendar-1.4.jar.zip](http://www.java2s.com/Code/JarDownload/jcalendar/jcalendar-1.4.jar.zip)

###### Interface Gráfica: [WindowBuilder] (https://eclipse.org/windowbuilder/)
###### Schema SQL: [Schema Celular] (https://drive.google.com/open?id=0Bw_EHUVXd5q5enVMZnFQbF8tRE0)

Para a utilização do sistema é necessário haver uma conexão com o SGBD MySQL, que é feita através do XAMPP e do JDBC.<br>
O nosso projeto está preparado para inicializar o schema sem a necessidade de "rodar" os scripts no MySQL, mas caso ocorra algo fora da normalidade, siga as instruções abaixo:
- Verifique se o módulo MySQL do XAMPP foi inicializado e esteja rodando
- Verifique o endereço da conexão e a senha, caso haja, no MySQL
- Acesse o pacote "connection" e abra a classe "InicializarBanco.java", observe se as informações da conexão são as mesmas que do MySQL
- Acesse a classe "ConnectionFactory.java" e observe se o "USER" e a senha ("PASS"), além da "URL" da conexão estão de acordo com a conexão criada no MySQL
- Lembre-se de importar para o projeto os dois arquivos .jar necessários para seu funcionamento (mysql-connector e jcalendar)
- Os erros de conexão serão exibidos no console do Eclipse

Após as devidas configurações, execute a "TelaInicial.java" e tenha acesso à todas as funcionalidades.

Dúvidas? victor.leuthier@ufrpe.br<br>
Bugs? Por favor, [envie o bug](https://github.com/leuthier/proj-bd/issues/new)
