package com.example.android_tutorial.main_fragment_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.android_tutorial.R
import com.example.android_tutorial.main_fragment_demo.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

/**
 * Description of manager fragment
 *
 * init tabLayout
 *
 * */

class MainActivityForFragment : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPage: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_for_fragment)
        initView()
        handlingAdapter()
    }

    private fun initView() {
        tabLayout = findViewById(R.id.mTabLayout)
        viewPage = findViewById(R.id.mViewPage)
    }

    private fun handlingAdapter() {
        val viewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        viewPage.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPage)
    }

}