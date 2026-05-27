package com.example.receitas.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.receitas.model.Recipe

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "receitas.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_RECIPES = "recipes"

        private const val ID = "id"
        private const val NAME = "nome"
        private const val INGREDIENTS = "ingredientes"
        private const val PREPARO = "modo_preparo"
    }

    override fun onCreate(db: SQLiteDatabase) {

        val createTable = """
        CREATE TABLE $TABLE_RECIPES (
            $ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $NAME TEXT,
            $INGREDIENTS TEXT,
            $PREPARO TEXT
        )
    """

        db.execSQL(createTable)

        // RECEITA #1
        db.execSQL("""
        INSERT INTO $TABLE_RECIPES
        ($NAME, $INGREDIENTS, $PREPARO)
        VALUES (
            'Bolo de Cenoura (aperte aqui para ver o modo de preparo e editar!)',
            'Massa:

1/2 xícara (chá) de óleo
3 cenouras médias raladas
4 ovos
2 xícaras (chá) de açúcar
2 e 1/2 xícaras (chá) de farinha de trigo
1 colher (sopa) de fermento em pó

Cobertura:

1 colher (sopa) de manteiga
3 colheres (sopa) de chocolate em pó
1 xícara (chá) de açúcar
1 xícara (chá) de leite',
            'PASSO 1 (massa): Em um liquidificador, adicione a cenoura, os ovos e o óleo, depois misture.

PASSO 2: Acrescente o açúcar e bata novamente por 5 minutos.

PASSO 3: Em uma tigela ou na batedeira, adicione a farinha de trigo e depois misture novamente.

PASSO 4: Acrescente o fermento e misture lentamente com uma colher.

PASSO 5: Asse em um forno preaquecido a 180° C por aproximadamente 40 minutos.

PASSO 6 (cobertura): Despeje em uma tigela a manteiga, o chocolate em pó, o açúcar e o leite, depois misture.

PASSO 7: Leve a mistura ao fogo e continue misturando até obter uma consistência cremosa, depois despeje a calda por cima do bolo.'
        )
    """)

        // RECEITA #2
        db.execSQL("""
        INSERT INTO $TABLE_RECIPES
        ($NAME, $INGREDIENTS, $PREPARO)
        VALUES (
            'Macarrão ao Alho',
            'Macarrão, alho, azeite, sal',
            'Cozinhe o macarrão e refogue no alho 

Nota: a ausência de detalhes nesta receita, bem como na terceira, tem a seguinte justificativa: o excesso de detalhes na receita do bolo de cenoura foi para testar a formatação e ver se ficava visualmente agradável'
        )
    """)

        // RECEITA #3 - Se você estiver lendo o código, saiba que a escassez de dados nesta receita segue a mesma lógica da Receita #2 (que você pode ler direto no app)
        db.execSQL("""
        INSERT INTO $TABLE_RECIPES
        ($NAME, $INGREDIENTS, $PREPARO)
        VALUES (
            'Panqueca',
            'Farinha, leite, ovos',
            'Misture os ingredientes e frite'
        )
    """)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS $TABLE_RECIPES")
        onCreate(db)
    }

    // CREATE
    fun insertRecipe(recipe: Recipe): Long {

        val db = writableDatabase

        val values = ContentValues().apply {
            put(NAME, recipe.nome)
            put(INGREDIENTS, recipe.ingredientes)
            put(PREPARO, recipe.modoPreparo)
        }

        return db.insert(TABLE_RECIPES, null, values)
    }

    // READ
    fun getAllRecipes(): ArrayList<Recipe> {

        val recipeList = ArrayList<Recipe>()

        val db = readableDatabase

        val cursor = db.rawQuery("SELECT * FROM $TABLE_RECIPES", null)

        if (cursor.moveToFirst()) {

            do {

                val recipe = Recipe(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
                )

                recipeList.add(recipe)

            } while (cursor.moveToNext())
        }

        cursor.close()

        return recipeList
    }

    // UPDATE
    fun updateRecipe(recipe: Recipe): Int {

        val db = writableDatabase

        val values = ContentValues().apply {
            put(NAME, recipe.nome)
            put(INGREDIENTS, recipe.ingredientes)
            put(PREPARO, recipe.modoPreparo)
        }

        return db.update(
            TABLE_RECIPES,
            values,
            "$ID=?",
            arrayOf(recipe.id.toString())
        )
    }

    // DELETE
    fun deleteRecipe(id: Int): Int {

        val db = writableDatabase

        return db.delete(
            TABLE_RECIPES,
            "$ID=?",
            arrayOf(id.toString())
        )
    }
}