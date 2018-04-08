package com.appgue.arraykotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.appgue.arraykotlin.R.array.club_image
import com.appgue.arraykotlin.R.array.club_name
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.appcompat.v7.listMenuItemView
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val btnIntent = findViewById<Button>(R.id.btnIntent)

//        btnIntent.setOnClickListener {
//            startActivity(intentFor<DetailClubActivity>("id" to "dicoding"))
//        }

        initData()
        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items)
    }

    fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i, 0)))
        }
        //Recycle the typed array
        image.recycle()
    }


}


