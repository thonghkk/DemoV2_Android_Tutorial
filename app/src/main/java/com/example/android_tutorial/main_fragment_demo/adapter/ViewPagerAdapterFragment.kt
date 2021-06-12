package com.example.android_tutorial.main_fragment_demo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_tutorial.main_fragment_demo.fragment.FirstFragment
import com.example.android_tutorial.main_fragment_demo.fragment.SecondFragment
import com.example.android_tutorial.main_fragment_demo.fragment.ThirdFragment

class ViewPagerAdapterFragment(private val fragmentManager: FragmentManager, val behavior: Int) :
    FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount() = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ThirdFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> FirstFragment()
        }
    }

}