
# Sistema empréstimo de ferramentas

Projeto de sistema de emprestimo, em JAVA-MVC com Maven.

> :construction: Projeto em construção :construction:

## Descrição
O Sistema de Gerenciamento de Empréstimo de Ferramentas é uma aplicação desenvolvida para auxiliar no controle e organização do empréstimo de ferramentas. O sistema permite registrar informações detalhadas sobre as ferramentas disponíveis, os amigos que as pegaram emprestadas, as datas de empréstimo e devolução, e fornece relatórios úteis para acompanhamento e análise.



# :hammer: Funcionalidades do projeto

- `Funcionalidade 1`: CRUD Ferramentas - controle de cadastro, select, insert, delet e update.
  
  Permite adicionar novas ferramentas ao sistema, incluindo informações como nome, marca, custo de aquisição e status (indicando se a ferramenta está disponível ou emprestada).
  Atualizar informações e apagar ferramenta.
  
- `Funcionalidade 2`: CRUD Amigos - controle de cadastro, select, insert, delet e update.
  
  Permite registrar informações sobre os amigos que estão pegando emprestadas as ferramentas, incluindo nome e contato telefônico.
  Atualizar informações e apagar ferramenta.

- `Funcionalidade 2a`: Locação de Ferramenta
  
  Permite registrar empréstimos de ferramentas para amigos, especificando a ferramenta emprestada, o amigo que a pegou emprestada e as datas de empréstimo e devolução.

- `Funcionalidade 3`: Relatorio  empréstimos
  
  Oferece relatórios detalhados sobre as ferramentas disponíveis, os empréstimos ativos, os empréstimos concluídos e o histórico de empréstimos de cada amigo. Além disso, o sistema também identifica os amigos que mais emprestaram ferramentas e verifica se há algum amigo que ainda não devolveu uma ferramenta emprestada.
# :electric_plug: Rodar o projeto

#### Pré-requisitos

Antes de iniciar, certifique-se de ter os seguintes softwares instalados:

- [Java Development Kit (JDK) 21](https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)

  .Recomendo rodar a aplicação na IDE NetBeans;

#### Configurando o Projeto

1. Clone o repositório para sua máquina local:

   ```bash
   git clone https://github.com/GreyPompom/sistema_emprestimo_A3.git
   cd sistema_emprestimo_A3

2. Crie uma database db_emprestimos
   
   Rode o script do arquivo `banco.sql`

3. Configure suas credenciais de acesso
   ```bash
   db.url=jdbc:mysql://localhost:3306/
   db.username=root
   db.password=Morango358017#
   
4.  Compile e execute a aplicação Java utilizando a sua IDE favorita.








# :bulb: Links
* [Kanban Trello](https://trello.com/invite/b/9HyXyz79/ATTI79889ba8eb5ded6d4e6ea8cbd08a13cd0AFD18C8/sistemaemprestimoa3):  Quadros de atividades do projeto.
* [Protótipo Figma](https://www.figma.com/design/xM5CAd1W6EmJFWAQ8agb7k/Prototipo_?node-id=0%3A1&t=ASLaPJFnZPpIndCx-1): Protótipos de tela do E-Commerce.
* [Documentação](): Requisitos funcionais e não funcionais do projeto.

