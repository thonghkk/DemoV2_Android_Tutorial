package com.example.android_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var mTxt: TextView
    private lateinit var mBtn: Button
    private var selection: Int = 0
        set(value) {
            field = value
            mTxt.text = field.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        mBtn.setOnClickListener {
            selection++
        }
    }

    private fun initView() {
        mTxt = findViewById(R.id.mTxtCount)
        mBtn = findViewById(R.id.mBtnClick)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("select", selection)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        selection = savedInstanceState.getInt("select")
    }
}