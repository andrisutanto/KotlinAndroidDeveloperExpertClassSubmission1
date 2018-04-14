package com.appgue.arraykotlin

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.appgue.arraykotlin.R.array.club_image
import com.appgue.arraykotlin.R.array.club_name
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Andri on 4/3/2018.
 */

//class RecyclerViewAdapter(private val context: Context, private val items: List<Item>)
//    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindItem(items[position])
//        holder.itemView.setOnClickListener {
//            context.startActivity<DetailClubActivity>("id" to position.toString())
//        }
//    }
//
//    override fun getItemCount(): Int = items.size
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        fun bindItem(items: Item) {
//            itemView.name.text = items.name
//            Glide.with(itemView.context).load(items.image).into(itemView.image)
//        }
//    }
//}

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<ClubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindItem(items[position])
        holder.itemView.setOnClickListener {
            context.startActivity<DetailClubActivity>("id" to position.toString())
        }
    }

    override fun getItemCount(): Int = items.size

}

class ClubUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.image
                }.lparams{
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = R.id.name
                    textSize = 16f
                }.lparams{
                    margin = dip(15)
                }

            }
        }
    }

}

class ClubViewHolder(view: View) : RecyclerView.ViewHolder(view){
    fun bindItem(items: Item) {
        itemView.name.text = items.name
        Glide.with(itemView.context).load(items.image).into(itemView.image)
    }
}
