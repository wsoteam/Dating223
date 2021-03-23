package com.dat.android.lips

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateUI()

        val endElementOnList = 4

        ibLike_button.setOnClickListener {

                vm.counter ++

            if(vm.counter > endElementOnList) {
                intent = Intent(this@MainActivity, InfoActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                updateUI()
            }
        }
        ibDislike_button.setOnClickListener {
            vm.counter ++

            if(vm.counter > endElementOnList) {
                intent = Intent(this@MainActivity, InfoActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                updateUI()
            }
        }


    }

    private fun updateUI() {

        tvName_woman.text = resources.getStringArray(R.array.names)[vm.counter]

        ivScreen.setImageDrawable(getDrawable(resources.obtainTypedArray(R.array.screen_signs).getResourceId(vm.counter, -1)))
    }


}