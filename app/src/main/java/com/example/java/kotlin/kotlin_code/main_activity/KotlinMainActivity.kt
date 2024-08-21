package com.example.java.kotlin.kotlin_code.main_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.java.kotlin.R
import com.example.java.kotlin.kotlin_code.main_activity.title.TitleManager
import com.example.java.kotlin.kotlin_code.second_activity.SecondActivity

/**
 * Main Activity
 */
class KotlinMainActivity: AppCompatActivity() {

    /**
     * lateinit TitleManager in charge of switching the current title and store it
     * Using lateinit is a promise with kotlin than the variable will be initialized
     * when it is called
     */
    private lateinit var titleManager: TitleManager

    /**
     * Views
     */
    private lateinit var btnUpdateTitle: Button
    private lateinit var tvTitle: TextView
    private lateinit var sbTitleOpacity: SeekBar
    private lateinit var btnLaunchSecondActivity: Button

    /**
     * Nullable btnSayHello
     * https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-nullable-types
     */
    private var btnSayHello: Button? = null

    /**
     * First function called when an activity is launched
     * Here we call the mandatory functions to make our activity works as expected
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTitleManager()
        initViews()
        initListeners()
    }

    /**
     * Init TitleManager
     */
    private fun initTitleManager() {
        titleManager = TitleManager()
    }

    /**
     * Init views listeners
     */
    private fun initListeners() {
        btnLaunchSecondActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        btnUpdateTitle.setOnClickListener {
            titleManager.updateTitle()
            tvTitle.text = "Hello World! ${titleManager.currentTitle.title}"
        }
        /**
         * Using ?. when calling btnSayHello ensures that we are accessing the var only if it not null
         * https://kotlinlang.org/docs/null-safety.html#safe-calls
         */
        btnSayHello?.setOnClickListener {
            Toast.makeText(this, "Hello World! ${titleManager.currentTitle.title}", Toast.LENGTH_SHORT).show()
        }
        sbTitleOpacity.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tvTitle.alpha = (p1/10f)
            }

            /**
             * Since onStartTrackingTouch and onStopTrackingTouch are void functions we don't need
             * to open brackets for them, the equivalent of void in Kotlin is Unit so we can make the function
             * be equal to Unit or leave empty brackets in a single line
             */
            override fun onStartTrackingTouch(p0: SeekBar?) = Unit

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }

    private fun initViews() {
        btnUpdateTitle = findViewById(R.id.btnUpdateTitle)
        btnSayHello = findViewById(R.id.btnSayHello)
        tvTitle = findViewById(R.id.tvTitle)
        sbTitleOpacity = findViewById(R.id.sb_title_opacity)
        btnLaunchSecondActivity = findViewById(R.id.btnLaunchSecondActivity)
    }

}