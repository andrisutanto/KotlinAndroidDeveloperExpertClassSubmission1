package com.appgue.arraykotlin

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.intentFor

/**
 * Created by Andri on 4/3/2018.
 */

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
        holder.itemView.setOnClickListener {
            //Toast.makeText(this@MainActivity, "Ini diklik bro!", Toast.LENGTH_SHORT).show()
            //Toast.makeText(context, "Position " + position, Toast.LENGTH_SHORT).show()
            val intent = Intent(this.context, DetailClubActivity::class.java).apply {
                putExtra("id", position.toString())
            }
            this.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindItem(items: Item) {
            itemView.name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)
        }
    }
}

