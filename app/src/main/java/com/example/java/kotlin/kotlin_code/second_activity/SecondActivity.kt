package com.example.java.kotlin.kotlin_code.second_activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.java.kotlin.R

class SecondActivity : AppCompatActivity() {

    private lateinit var etUserText: EditText
    private lateinit var btnGrabUserText: Button
    private lateinit var btnSwitchLL: Button
    private lateinit var tvUserText: TextView
    private lateinit var llTextViews: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        btnGrabUserText.setOnClickListener {
            tvUserText.text = etUserText.text
        }
        btnSwitchLL.setOnClickListener {
            val currentOrientation = llTextViews.orientation
            llTextViews.orientation = if (currentOrientation == HORIZONTAL) VERTICAL else HORIZONTAL
        }
    }

    private fun initViews() {
        etUserText = findViewById(R.id.etUserText)
        btnGrabUserText = findViewById(R.id.btnGrabText)
        tvUserText = findViewById(R.id.tvUserText)
        btnSwitchLL = findViewById(R.id.btnSwitchLL)
        llTextViews = findViewById(R.id.llTextViews)
    }
}