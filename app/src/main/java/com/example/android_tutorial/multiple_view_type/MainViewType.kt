package com.example.android_tutorial.multiple_view_type

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_tutorial.R
import com.example.android_tutorial.model.ViewType

class MainViewType : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mViewTypeAdapter: ViewTypeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_type)

        initView()
    }

    private fun initView() {
        mRecyclerView = findViewById(R.id.mRecycleViewType)

        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mViewTypeAdapter = ViewTypeAdapter(importListView())
        mRecyclerView.adapter = mViewTypeAdapter
    }

    private fun importListView(): List<ViewType> {
        val listViewType = mutableListOf<ViewType>()
        listViewType.add(ViewType("Title m", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", true))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        listViewType.add(ViewType("Title", "Description", false))
        return listViewType
    }
}