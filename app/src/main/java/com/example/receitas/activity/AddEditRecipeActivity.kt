package com.example.receitas.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.receitas.R
import com.example.receitas.database.DatabaseHelper
import com.example.receitas.model.Recipe

class AddEditRecipeActivity : AppCompatActivity() {

    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_recipe)

        db = DatabaseHelper(this)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtIngredientes = findViewById<EditText>(R.id.edtIngredientes)
        val edtModo = findViewById<EditText>(R.id.edtModo)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        val id = intent.getIntExtra("id", 0)

        if (id != 0) {

            edtNome.setText(intent.getStringExtra("nome"))
            edtIngredientes.setText(intent.getStringExtra("ingredientes"))
            edtModo.setText(intent.getStringExtra("modo"))
        }

        btnSalvar.setOnClickListener {

            val recipe = Recipe(
                id,
                edtNome.text.toString(),
                edtIngredientes.text.toString(),
                edtModo.text.toString()
            )

            if (id == 0) {

                db.insertRecipe(recipe)

            } else {

                db.updateRecipe(recipe)
            }

            finish()
        }
    }
}