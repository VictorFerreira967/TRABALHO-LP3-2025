# 🎬 Sistema de Gestão de Cinema — LP3

Documentação oficial do projeto desenvolvido para a disciplina **Linguagem de Programação 3 (LP3)**, com foco em **JPA, MVC e Padrões de Projeto**.

---

## 📌 1. Descrição do Projeto

O **Sistema de Gestão de Cinema** tem como objetivo administrar os principais elementos de um cinema, tais como:

- **Filmes**
- **Sessões**
- **Salas**
- **Assentos**
- **Clientes**
- **Cartões Fidelidade**
- **Ingressos**

A aplicação utiliza **MVC** como arquitetura principal, **JPA** para persistência de dados (ORM) e um banco **MySQL**. Os **Padrões de Projeto** foram aplicados para garantir organização, manutenção e escalabilidade.

---

## 🧱 2. Arquitetura e Tecnologias Utilizadas

| Componente | Tecnologia / Conceito | Descrição |
|-----------|------------------------|-----------|
| **Arquitetura** | MVC | Separação entre Model, View e Controller. |
| **ORM** | JPA (EclipseLink) | Mapeamento Objeto-Relacional. |
| **Banco de Dados** | MySQL | Armazenamento relacional. |
| **Gerenciamento** | Maven | Dependências e automação de build. |
| **IDE** | NetBeans | Desenvolvimento da aplicação. |
| **Versionamento** | Git & GitHub | Controle de versão e hospedagem. |

### Estrutura MVC

- **Model:** Entidades JPA + DAOs.  
- **Controller:** Lida com regras de negócio e DTOs.  
- **View:** Simulada pela classe `Main` (interface futura).

---

## 🧩 3. Padrões de Projeto Aplicados

| Padrão | Classe / Camada | Função |
|-------|------------------|--------|
| **Singleton** | `EntityManagerFactorySingleton` | Cria uma única instância da `EntityManagerFactory`. |
| **Object Factory** | `EntityManagerObjectFactory` | Centraliza a criação de `EntityManager`. |
| **DAO** | `GenericDAO`, `FilmeDAO`, `ClienteDAO` | Implementa operações CRUD. |
| **Adapter** | Classes `*Map` | Convertem Entidades ↔ DTOs. |
| **DTO** | `*RequestDTO`, `*ResponseDTO` | Transferência segura de dados entre camadas. |

---

## 🗄️ 4. Modelagem e Relacionamentos JPA

| Entidade | Relacionamento | Destino | Exemplo JPA |
|----------|----------------|---------|-------------|
| `Filme` | 1:N | `Sessao` | `@OneToMany(mappedBy = "filme")` |
| `Cliente` | 1:1 | `CartaoFidelidade` | `@OneToOne @JoinColumn` |
| `Ingresso` | N:1 | `Sessao` | `@ManyToOne @JoinColumn` |
| `Sala` | 1:N | `Assento` | `@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)` |

---

## 🗂️ 5. Versionamento e Organização

- Estrutura padrão Maven (`src/main/java`).  
- Commits com mensagens claras e organizadas.  
- Repositório seguindo boas práticas de documentação e organização.

---

## 🖥️ 6. Interface (View)

A classe `Main` simula a camada View, acionando os Controllers.  
O projeto está preparado para receber uma interface gráfica real futuramente.

---

## 📘 7. Aprendizados

- Aplicação real de JPA e ORM.  
- Uso prático de padrões de projeto (DAO, DTO, Singleton, Factory).  
- Importância do baixo acoplamento e estruturação MVC.

---

## ⚠️ 8. Desafios

- Gerenciamento do contexto de persistência.  
- Ordem correta de inserção das entidades com relacionamentos complexos.  
- Ajuste preciso de `CascadeType` e relacionamentos.

---

## 📅 Informações Finais

- **Data:** 08/12/2025  
- **Status:** ✔️ Concluído  
- **Documentação gerada por:** Manus AI  
