package com.dat.android.lips

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity(R.layout.activity_info) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            ivRestart.setOnClickListener {
                intent = Intent(this@InfoActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
                //finishAffinity()
            }
    }
}