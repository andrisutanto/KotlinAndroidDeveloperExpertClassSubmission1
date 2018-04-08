package com.appgue.arraykotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail_club.*
import com.appgue.arraykotlin.R.array.club_desc
import com.appgue.arraykotlin.R.id.image
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.image


class DetailClubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_club)

        val logoDetail = findViewById<ImageView>(R.id.logoDetail)

        //dapatkan data dari intent
        val data = intent.extras.getString("id")

        //dapatkan array club logo dan description
        val clubdesc = resources.getStringArray(R.array.club_desc)
        val logo = resources.obtainTypedArray(R.array.club_image)

        //masukkan nilai item yang diklik ke dalam textview dan image
        descDetail.text = clubdesc[data.toInt()].toString()
        //Glide.with(this).load(R.drawable.img_acm).into(logoDetail)
        Glide.with(this).load(logo.getResourceId(data.toInt(),0)).into(logoDetail)

    }
}
