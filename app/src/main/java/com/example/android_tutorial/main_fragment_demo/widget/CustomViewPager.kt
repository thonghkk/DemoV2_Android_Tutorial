package com.example.android_tutorial.main_fragment_demo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * Custom event lock viewpager makes user don't swipe
 *
 * */

class CustomViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (this.isEnabled) {
            return super.onTouchEvent(ev)
        }
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (this.isEnabled) {
            return super.onInterceptTouchEvent(ev)
        }
        return false
    }

    fun setPagingEnable(enable: Boolean) {
        this.isEnabled = enable
    }
}
