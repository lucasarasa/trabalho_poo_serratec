# EASY ADULT LIFE - Projeto de E-commerce (Grupo 5 - JavaL)

Este repositório foi criado pelo Grupo 5 JavaL - Para organizar e documentar o trabalho em grupo sobre Programação Orientada a Objetos (POO). 
Aqui você encontrará todos os materiais, códigos e documentação desenvolvidos ao longo da disciplina, com foco na aplicação prática dos 
conceitos de POO utilizando a linguagem Java.

# Projeto 📜
O projeto do grupo se concentra em uma empresa fictícia chamada "EASY ADULT LIFE", criada com o intuito de auxiliar jovens e recém-casados 
a aprenderem habilidades práticas essenciais da vida adulta. A empresa oferece cursos online que abordam culinária, cuidados com pets, 
finanças domésticas e manutenção do lar, tornando desafios cotidianos mais simples e acessíveis.

# Funcionalidades ✨
- **🔑 Login de Usuário: O sistema identifica o tipo de usuário (cliente ou administrador) durante o processo de login, exibindo menus e 
funcionalidades correspondentes.**
- **🛒 Carrinho de Compras: O cliente pode adicionar produtos ao carrinho e finalizar a compra.**
- **📊 Relatórios: Geração de relatórios com opções para exibição em tela ou exportação em arquivo .txt.**
- **📂 Simulação de Banco de Dados: Armazenamento de dados dos usuários e produtos em arquivos .txt.**
- **✍️ Cadastro de Novos Usuários e Produtos: Possibilidade de cadastrar novos usuários e produtos, com persistência de dados em arquivos.**
- **Estrutura de Classes**

# Estrutura de Classes 🛠️
 O projeto é implementado utilizando os principais conceitos de POO
- **👤 Cliente: Representa os usuários da plataforma.**
- **🏷️ Superclasse (Abstrata): Define atributos e métodos comuns a diferentes tipos de usuários.**
- **🔄 Interface: Implementada para garantir que certas classes possuam métodos específicos.**
- **🔑 Sistema Interno (Main): Controla o fluxo principal da aplicação.**
- **📜 Enum: Define categorias de produtos disponíveis na plataforma.**
- **📋 Menus: Dois menus separados, para clientes e administradores.**
- **📄 Método de Leitura e Relatórios (i/o): Métodos para ler e escrever dados em arquivos e gerar relatórios.**
- **🛍️ Produto e Categoria: Representa os produtos disponíveis e suas respectivas categorias.**
- **🛒 Carrinho de Compras: Gerencia os produtos adicionados pelos clientes.**
- **📊 Relatórios.**

# Tecnologias Utilizadas 🖥️
- **☕  Java (JDK 17).**
- **🛠️ Eclipse: IDE utilizada por alguns membros do grupo para desenvolvimento em Java.**
- **🐙 Git: Sistema de controle de versão para rastrear mudanças no código.**
- **📦 GitHub: Repositório remoto utilizado para armazenar e colaborar no código.**
- **🗂️ Trello: Ferramenta de gerenciamento de tarefas para organizar o progresso do projeto e designar responsabilidades.**
- **📊 Draw.io: Ferramenta online utilizada para criar diagramas.**

# Fluxo do Diagrama UML Classe 💡

## 1. Classe Usuario (abstrata)

## Atributos:
- **protected int id: Identificador único do usuário.**
- **protected String nome: Nome do usuário.**
- **protected String email: Email do usuário.**
- **protected String senha: Senha para autenticação.**
- **protected String telefone: Telefone do usuário.**
## Métodos:
- **Métodos públicos get e set para acessar e modificar os atributos, como getNome() e setNome().**
 
## Modificadores de acesso:
- **protected: Os atributos são acessíveis pelas classes que herdam de Usuario (como Cliente e Administrador).**
- **public: Os métodos de acesso são públicos para permitir a interação externa.**
## Fluxo:
- **As classes Cliente e Administrador herdam de Usuario, o que significa que ambas têm acesso aos mesmos
  atributos e métodos, utilizando o nome, email e senha de maneira padronizada.**
## 2. Classe Cliente (subclasse de Usuario)

## Atributos:
- **private String cpf: CPF do cliente para identificação.**
## Métodos:
- **public String getCpf(): Retorna o CPF.**
- **public void setCpf(String cpf): Define e valida o CPF.**
- **public static boolean login(String email, String senha): Realiza o login.**
## Modificadores de acesso:
- **private: O atributo cpf é acessível somente dentro da classe Cliente.**
- **public: Métodos de acesso como getCpf() e setCpf() são públicos, permitindo que outras classes interajam.**
## Fluxo:
- **O cliente pode fazer login e acessar seus dados pessoais (CPF, telefone) utilizando os métodos de sua
  classe e da superclasse Usuario.**
## 3. Classe Administrador (subclasse de Usuario)
## Atributos:
- **private boolean isAdmin: Indica se o usuário tem privilégios de administrador.**
## Métodos:
- **public boolean getIsAdmin(): Retorna se o usuário é administrador.**
- **public static boolean login(String email, String senha): Realiza o login do administrador.**
## Modificadores de acesso:
- **private: O atributo isAdmin é acessível apenas dentro da classe Administrador.**
- **public: O método getIsAdmin() é público para que outras classes possam verificar o status do usuário.**
## Fluxo:
- **O administrador faz login da mesma forma que um cliente, mas tem acesso a funcionalidades extras como
  gerenciamento de produtos e visualização de relatórios.**
## 4. Classe Produto

## Atributos:
- **private int id: Identificador único do produto.**
- **private String nome: Nome do produto.**
- **private String descricaoProd: Descrição do produto.**
- **private double preco: Preço do produto.**
- **private String autor: Criador ou autor do produto.**
- **private int duracao: Duração do curso.**
## Métodos:
- **public get/set: Métodos públicos para acessar e modificar os atributos, como getNome() e setNome().**
## Modificadores de acesso:
- **private: Os atributos são privados para promover encapsulamento e controle.**
- **public: Os métodos get e set são públicos, permitindo o acesso controlado às informações dos produtos.**
## Fluxo:
- **O cliente pode visualizar os produtos disponíveis e administradores podem modificar suas propriedades
 através dos métodos de acesso controlado.**
## 5. Classe Carrinho

## Atributos:
- **private int id: Identificador único do carrinho.**
- **private int fkCliente: Chave estrangeira associada ao cliente dono do carrinho.**
## Métodos:
- **public void adicionarProduto(Produto produto): Adiciona um produto ao carrinho.**
- **public void removerProduto(Produto produto): Remove um produto do carrinho.**
- **public boolean isCarrinhoVazio(): Verifica se o carrinho está vazio.**
## Modificadores de acesso:
- **private: Os atributos são privados para manter a integridade do carrinho.**
- **public: Os métodos de gerenciamento do carrinho são públicos.**
## Fluxo:
- **O cliente adiciona e remove produtos no carrinho, que está associado a ele através do fkCliente.**
## 6. Classe Pagamento (abstrata)

## Atributos:
- **private int id: Identificador do pagamento.**
- **private int fkCliente: Chave estrangeira do cliente que realizou o pagamento.**
- **private double valor: Valor total do pagamento.**
## Métodos:
- **public double getValor(): Retorna o valor do pagamento.**
## Modificadores de acesso:
- **private: Os atributos são privados para proteger as informações financeiras.**
- **public: Os métodos getValor() são públicos para permitir o acesso seguro às informações do pagamento.**
## Fluxo:
- **A classe Pagamento é herdada pelas subclasses específicas de pagamento (Pix, Boleto, Credito, Debito),
  que implementam os detalhes de cada método de pagamento.**
## 7. Subclasses de Pagamento (Pix, Boleto, Credito, Debito)

## Atributos:
- **Pix: private long chavePix**
- **Boleto: private long numBoleto**
- **Credito: private int numCartaoCredito**
- **Debito: private int numCartaoDebito**
## Métodos:
- **Cada subclasse possui métodos para acessar e modificar seus atributos específicos, como getChavePix() e setNumBoleto().**
## Modificadores de acesso:
- **private: Atributos específicos de cada forma de pagamento são privados.**
- **public: Métodos públicos permitem o acesso seguro às informações de pagamento.**
## Fluxo:
- **Os métodos de pagamento específicos são implementados em suas respectivas subclasses.**
## 8. Classe Suporte

## Atributos:
- **private int id: Identificador único do suporte.**
- **private int fkCliente: Chave estrangeira associada ao cliente.**
- **private String mensagem: Mensagem enviada pelo cliente.**
## Métodos:
- **public String getMensagem(): Retorna a mensagem do suporte.**
## Modificadores de acesso:
- **private: Atributos protegidos para garantir a privacidade das interações de suporte.**
- **public: Métodos públicos permitem o acesso controlado às interações de suporte.**
## Fluxo:
- **O cliente pode enviar solicitações de suporte e essas mensagens são registradas e gerenciadas pela equipe de suporte.**

## Diagrama 📊
![Easy adult life draw](https://github.com/user-attachments/assets/32470b98-7204-4132-9585-6857938cb0e8)

## Autores 🖋️
- **Letícia Peixoto** - [leticiapzs](https://github.com/leticiapzs)
- **Lorrayne Morais** - [LorrayneMorais](https://github.com/LorrayneMorais)
- **Luan Souza** - [LuanSouza7](https://github.com/LuanSouza7)
- **Lucas Cardinot** - [UserCardinot](https://github.com/UserCardinot)
- **Lucas Sarasa** - [lucasarasa](https://github.com/lucasarasa)
- **Lucas Schumacker** - [schumacker1](https://github.com/schumacker1)
- **Luiz Vinicius** - [ViniciusCassiano2105](https://github.com/ViniciusCassiano2105)


