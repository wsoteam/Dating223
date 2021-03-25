package com.dat.android.lips

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.dat.android.lips.model.Model
import com.dat.android.lips.net.RetrofitClient
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    val LEFT_ROTATION = 13f
    val RIGHT_ROTATION = -13f
    val START_ROTATION = 0f
    val STATE_BAN = 0
    val STATE_NOTBAN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LOL", "sdfsdf")

        RetrofitClient
            .getInstance() // api
            .getMovieList()
            .enqueue(object : retrofit2.Callback<Model> {
                override fun onFailure(call: Call<Model>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<Model>,
                    response: Response<Model>
                ) {
                    var model = response.body()
                    processResponse(model!!)
                }
            })
    }


    private fun processResponse(model : Model){
        Log.e("LOL", model.toString())

        when(model.resolv) {
            STATE_BAN -> {

            }
            STATE_NOTBAN -> {
                var intentNewActivity = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intentNewActivity)
                finish()
            }
            else ->  {

            }
        }
    }



    private fun startAnim() {
        var leftAnimator = ValueAnimator.ofFloat(START_ROTATION, LEFT_ROTATION)
        leftAnimator.duration = 120L
        leftAnimator.addUpdateListener {
            ivLips.rotation = it.animatedValue.toString().toFloat()
        }

        var rightAnimator = ValueAnimator.ofFloat(LEFT_ROTATION, RIGHT_ROTATION)
        rightAnimator.duration = 240L
        rightAnimator.addUpdateListener {
            ivLips.rotation = it.animatedValue.toString().toFloat()
        }

        var returnAnimator = ValueAnimator.ofFloat(RIGHT_ROTATION, START_ROTATION)
        returnAnimator.duration = 120L
        returnAnimator.addUpdateListener {
            ivLips.rotation = it.animatedValue.toString().toFloat()
        }



        leftAnimator.addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                rightAnimator.start()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })


        rightAnimator.addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                returnAnimator.start()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })

        leftAnimator.start()
    }

    override fun onPostResume() {
        super.onPostResume()

        Handler().postDelayed({
            startAnim()
        }, 500)


        Handler().postDelayed({
            openNextScreen()
        }, 5_000)
    }

    private fun openNextScreen(){
        var intentNewActivity = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intentNewActivity)
        finish()
    }
}