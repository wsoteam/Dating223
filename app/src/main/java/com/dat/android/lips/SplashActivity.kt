package com.dat.android.lips

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    val LEFT_ROTATION = 13f
    val RIGHT_ROTATION = -13f
    val START_ROTATION = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        }, 10000)
    }

    private fun openNextScreen(){
        var intentNewActivity = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intentNewActivity)
        finish()
    }
}