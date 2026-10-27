# 🏋️ Central de Gestão de Alunos - FitFlow Gym Management

## 🎯 Escopo do Sistema

O sistema simula uma plataforma corporativa para administração de matrículas, faturamento de mensalidades e auditoria de contratos para academias e centros fitness (FitFlow). A aplicação implementa conceitos avançados de Orientação a Objetos mapeados em uma **coleção elástica de dados em memória RAM**, permitindo gerenciar alunos associados dinamicamente a contratos customizados. Através de barramentos de busca linear por ID exclusivo, o operador consegue **matricular clientes, aplicar descontos percentuais cumulativos**, realizar a **migração/atualização de planos contratuais em tempo real** e extrair o manifesto completo de alunos ativos.

### 🔄 Fluxo de Eventos Operacionais
```text
[ Entrada via Console ] ➔ [ Instanciação por Composição ] ➔ [ Registro na List ] ➔ [ Varredura por ID ] ➔ [ Mutação de Estado do Contrato ]
```

---

## 🎨 Arquitetura do Software (Relacionamento entre Camadas)

O design deste ecossistema adota o desacoplamento de responsabilidades através do conceito de **Composição (um Aluno possui um Plano)**, integrando as entidades de domínio à interface iterativa através da API de coleções.

```text
========================================================================
  CAMADA DE INTERFACE E CONTROLE (Main.java)
========================================================================
     [ Scanner ] ── input ──► [ Loop do Menu (while) ]
                                      │
                          Roteamento via switch-case
                                      │
       ┌───────────────────┬──────────┴───────────┬───────────────────┐
       ▼                   ▼                      ▼                   ▼
   [Case 1]            [Case 2]               [Case 3]            [Case 4]
 Matricular Aluno     Listar Frota           Aplicar Desconto    Alterar Plano
  & Instanciar        de Clientes Ativos     de Mensalidade      Contratual
       │                   │                      │                   │
  academia.add()       for (Aluno c)              ├─────────┬─────────┘
       │                   │                      ▼         ▼
===========================╪================== [ Match de ID: c.getId() ]
  CAMADA DE DOMÍNIO        │                    Isola o objeto correspondente
===========================╪================================╪==============
                           ▼                                ▼
                  [ Aluno 1, 2... N ] ◄────────────── [ Objeto Alvo ]
                   (Possui 1 Plano)                 Altera atributos internos
```

### 📋 Inventário de Componentes Técnicos

| Componente | Tipo | Atuação e Responsabilidade no Sistema |
| :--- | :--- | :--- |
| 🚀 `Main.java` | Controlador | Gerencia a interface gráfica via console, controla a persistência temporária e orquestra as regras de transição dos menus. |
| 👥 `Aluno.java` | Classe Entidade | Modela o cliente da academia, encapsulando o identificador (ID), nome e a referência do contrato associado. |
| 🏷️ `Plano.java` | Classe Entidade | Modela o contrato (Smart/Black), armazenando precificação, nome do pacote e restrição de acesso à área VIP. |
| 📦 `List<Aluno> academia` | Coleção Dinâmica | Instanciada via `ArrayList`, atua como o banco de dados em memória que agrupa e indexa todas as referências de matrículas ativas. |

---

## 🧠 Conceitos Avançados Praticados

* **Composição de Classes (Has-A Relationship):** Acoplamento estruturado de objetos onde a classe `Aluno` possui um atributo do tipo `Plano`, demonstrando como entidades complexas se associam no mundo real.
* **Encapsulamento e Passagem de Referência:** Blindagem de atributos via modificadores `private`, permitindo que o estado do plano de um aluno seja alterado dinamicamente no terminal através do método passador `setPlano(Plano plano)`.
* **Algoritmo Iterativo de Mutação de Valores:** Implementação de funções matemáticas dentro da entidade (`aplicarDesconto`) que atualizam o estado da precificação e retornam o feedback financeiro formatado para a camada de visualização.

---

## 💻 Demonstração de Uso (Console)

Veja o comportamento do sistema durante um fluxo contínuo de matrícula, consulta e aplicação de desconto:

```text
======== Menu ==========
1 - Matricular Aluno 
2 - Listar Alunos Matriculados 
3 - Descontos de Matrícula 
4 - Alterar Plano 
5 - Sair
Escolha uma opção: 1

======== Cadastro de Alunos ==========
Insira o ID de cadastro: 55
Insira o nome do aluno: Carlos Silva
Insira qual plano do aluno: (Smart / Black)
Black
Insira o preço do plano: 140.00
Aluno será VIP?: (S/N)
S

======== Menu ==========
1 - Matricular Aluno 
2 - Listar Alunos Matriculados 
3 - Descontos de Matrícula 
4 - Alterar Plano 
5 - Sair
Escolha uma opção: 2

======== Lista de Alunos ==========
ID: 55 || Nome: Carlos Silva || Plano: Black || Valor: 140.0 || Vip: true

======== Menu ==========
1 - Matricular Aluno 
2 - Listar Alunos Matriculados 
3 - Descontos de Matrícula 
4 - Alterar Plano 
5 - Sair
Escolha uma opção: 3

======== Desconto de Matrículas ==========
Qual ID do aluno? 
55
Quanto será o desconto da matricula do aluno: (em porcentagem)
10
Matricula com o valor descontado será de: 126.0\$ Reais

