# Livro de Receitas Digital

Aplicativo Android desenvolvido em Kotlin utilizando SQLite para armazenamento local de dados.

O projeto consiste em um CRUD completo de receitas culinárias, permitindo cadastrar, visualizar, editar e remover receitas diretamente no aplicativo.

---

# Funcionalidades

• Adicionar receitas  
• Listar receitas  
• Editar receitas  
• Deletar receitas  
• Armazenamento local com SQLite  
• RecyclerView para exibição dinâmica  
• Receitas pré-cadastradas no banco  

---

# Tecnologias Utilizadas

- Kotlin
- Android Studio
- SQLite
- RecyclerView
- XML Layouts

---

# Estrutura do Projeto

```bash
app/
├── java/com/example/receitas
│   ├── activity
│   │   └── AddEditRecipeActivity.kt
│   ├── adapter
│   │   └── RecipeAdapter.kt
│   ├── database
│   │   └── DatabaseHelper.kt
│   ├── model
│   │   └── Recipe.kt
│   └── MainActivity.kt
│
└── res/layout
    ├── activity_main.xml
    ├── activity_add_edit_recipe.xml
    └── item_recipe.xml
```

---

# Banco de Dados

O aplicativo utiliza SQLite localmente através da classe:

```kotlin
DatabaseHelper.kt
```

Tabela criada:

```sql
CREATE TABLE recipes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT,
    ingredientes TEXT,
    modo_preparo TEXT
)
```

---

# Operações CRUD

## CREATE
Cadastrar novas receitas.

## READ
Listar todas as receitas cadastradas.

## UPDATE
Editar receitas existentes.

## DELETE
Remover receitas do banco de dados.

---

# Telas do Aplicativo

## Tela Principal
- Lista de receitas + Ingredientes
- Botão para adicionar nova receita

## Tela de Cadastro/Edição
- Nome da receita
- Ingredientes
- Modo de preparo

---

# Receitas Pré-Cadastradas

O banco já inicia com algumas receitas inseridas automaticamente:

- Bolo de Cenoura
- Macarrão ao Alho
- Panqueca

---

# Aprendizados

Este projeto foi desenvolvido para praticar:

- CRUD em Android
- SQLite
- RecyclerView
- Navegação entre Activities
- Organização de projeto Android
- Kotlin

---

# Telas de execução:

1. Tela principal: <img width="1080" height="2520" alt="Tela Principal" src="https://github.com/user-attachments/assets/93e490c8-e0ff-4de0-821d-a0e6a9e2afc7" />

2. Tela de cadastro de receita: <img width="1080" height="2520" alt="Cadastro de Receita" src="https://github.com/user-attachments/assets/9f30540c-dc7a-4cd8-a6f8-3c98b8ea4a75" />

3. Exemplo de Cadastro já preenchido, apto a edição: <img width="1080" height="2520" alt="Preenchido e Editável" src="https://github.com/user-attachments/assets/8c9fa70a-c6e6-4755-8eaf-be624979522e" />

---

# Autor

Desenvolvido por Lucas Daniel.
