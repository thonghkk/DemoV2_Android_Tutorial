package com.example.android_tutorial.main_fragment_demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.android_tutorial.R
import com.example.android_tutorial.main_fragment_demo.adapter.ViewPagerAdapter
import com.example.android_tutorial.main_fragment_demo.adapter.ViewPagerAdapterFragment
import com.example.android_tutorial.main_fragment_demo.widget.CustomViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView


class FirstFragment : Fragment() {
    private lateinit var mViewPageBottom: CustomViewPager
    private lateinit var mBottomNavigation: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_first, container, false)
        mViewPageBottom = v.findViewById(R.id.mViewPageBottom)
        mBottomNavigation = v.findViewById(R.id.mBottomNavigation)

        val adapter = ViewPagerAdapterFragment(
            childFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        mViewPageBottom.adapter = adapter
        mViewPageBottom.setPagingEnable(false)


        //handling when user swipe and change bottom
        mViewPageBottom.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> mBottomNavigation.menu.findItem(R.id.menu_first).isChecked = true
                    1 -> mBottomNavigation.menu.findItem(R.id.menu_second).isChecked = true
                    2 -> mBottomNavigation.menu.findItem(R.id.menu_third).isChecked = true
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        //handling bottom when use click and change viewpager
        mBottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_first -> mViewPageBottom.currentItem = 0
                R.id.menu_second -> mViewPageBottom.currentItem = 1
                R.id.menu_third -> mViewPageBottom.currentItem = 2
                else -> mViewPageBottom.currentItem = 0
            }
            true
        }
        return v
    }
}