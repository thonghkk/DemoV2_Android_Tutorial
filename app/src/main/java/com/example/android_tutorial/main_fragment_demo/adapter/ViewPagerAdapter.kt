package com.example.android_tutorial.main_fragment_demo.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.android_tutorial.R
import com.example.android_tutorial.main_fragment_demo.fragment.FirstFragment
import com.example.android_tutorial.main_fragment_demo.fragment.SecondFragment
import com.example.android_tutorial.main_fragment_demo.fragment.ThirdFragment

class ViewPagerAdapter(private val fragmentManager: FragmentManager, val behavior: Int) :
    FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> FirstFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title = ""
        title = when (position) {
            0 -> "abc"
            1 -> "abc"
            2 -> "abc"
            else -> "acb"
        }

        return title
    }
}