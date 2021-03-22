package com.dat.android.lips

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onPostResume() {
        super.onPostResume()
        Handler().postDelayed({
            TimeUnit.SECONDS.sleep(6)
            openNextScreen()
        }, 4000)
    }

    private fun openNextScreen(){
        var intentNewActivity = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intentNewActivity)
        finish()
    }
}