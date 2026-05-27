package com.example.receitas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.receitas.R
import com.example.receitas.model.Recipe

class RecipeAdapter(
    private val recipes: ArrayList<Recipe>,
    private val onDelete: (Recipe) -> Unit,
    private val onEdit: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtIngredientes: TextView = view.findViewById(R.id.txtIngredientes)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val recipe = recipes[position]

        holder.txtNome.text = recipe.nome
        holder.txtIngredientes.text = recipe.ingredientes

        holder.btnDelete.setOnClickListener {
            onDelete(recipe)
        }

        holder.itemView.setOnClickListener {
            onEdit(recipe)
        }
    }
}