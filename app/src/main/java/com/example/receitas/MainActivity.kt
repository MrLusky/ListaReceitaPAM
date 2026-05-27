package com.example.receitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.receitas.activity.AddEditRecipeActivity
import com.example.receitas.adapter.RecipeAdapter
import com.example.receitas.database.DatabaseHelper

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DatabaseHelper(this)

        recyclerView = findViewById(R.id.recyclerRecipes)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {

            startActivity(
                Intent(this, AddEditRecipeActivity::class.java)
            )
        }
    }

    override fun onResume() {

        super.onResume()

        val recipes = db.getAllRecipes()

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = RecipeAdapter(
            recipes,
            onDelete = {

                db.deleteRecipe(it.id)

                onResume()
            },
            onEdit = {

                val intent = Intent(this, AddEditRecipeActivity::class.java)

                intent.putExtra("id", it.id)
                intent.putExtra("nome", it.nome)
                intent.putExtra("ingredientes", it.ingredientes)
                intent.putExtra("modo", it.modoPreparo)

                startActivity(intent)
            }
        )
    }
}