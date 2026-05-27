package com.example.receitas.model

data class Recipe(
    var id: Int = 0,
    var nome: String,
    var ingredientes: String,
    var modoPreparo: String
)