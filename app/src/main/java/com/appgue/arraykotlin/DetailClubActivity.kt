package com.appgue.arraykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_detail_club.*
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailClubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //cara lama set content view
        //setContentView(R.layout.activity_detail_club)
        //menggunakan anko layout
        DetailClubActivityUI().setContentView(this)

        //dapatkan data dari intent
        val data = intent.extras.getString("id")

        //dapatkan array club logo, name dan description
        val clubdesc = resources.getStringArray(R.array.club_desc)
        val clubname = resources.getStringArray(R.array.club_name)
        val logo = resources.obtainTypedArray(R.array.club_image)

        //masukkan nilai item yang diklik ke dalam textview dan image
        descDetail.text = clubdesc[data.toInt()].toString()
        clubName.text = clubname[data.toInt()].toString()
        Glide.with(this).load(logo.getResourceId(data.toInt(),0)).into(logoDetail)
    }
}

class DetailClubActivityUI : AnkoComponent<DetailClubActivity> {
    override fun createView(ui: AnkoContext<DetailClubActivity>) = with(ui) {
        verticalLayout{
            imageView{
                padding = dip(4)
                id = R.id.logoDetail
                }.lparams(
                    width = matchParent,
                    height = dip(80)
            )
            textView{
                textSize = sp(10).toFloat()
                id = R.id.clubName
                this.gravity = Gravity.CENTER
                }.lparams(
                    width = matchParent,
                    height = wrapContent
            )
            textView{
                textSize = sp(8).toFloat()
                id = R.id.descDetail
                padding = dip(6)
            }
        }
    }
}
