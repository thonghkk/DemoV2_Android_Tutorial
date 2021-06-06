package com.example.android_tutorial.drag_drop_items

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_tutorial.R
import com.example.android_tutorial.model.ViewType
import java.util.*

class MainDragDrop : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mDragDropAdapter: DragDropAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_drag_drop)

        initView()
        // custom drag and drop for items in recycle view
        customDragDrop()
    }

    private fun initView() {
        //init recycle view
        mRecyclerView = findViewById(R.id.mRecycleViewDragDrop)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        //init adapter
        mDragDropAdapter = DragDropAdapter(listItem())
        //assign data with adapter
        mRecyclerView.adapter = mDragDropAdapter

    }

    private fun customDragDrop() {
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        mRecyclerView.addItemDecoration(divider)

        val helper = ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.RIGHT,
                ItemTouchHelper.LEFT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                //get position of locate currently  items
                val positionDragged = viewHolder.adapterPosition
                //get position of locate moved items
                val positionTarget = target.adapterPosition

                Collections.swap(listItem(), positionDragged, positionTarget)
                mDragDropAdapter.notifyItemMoved(positionDragged, positionTarget)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                listItem().removeAt(position)
                mDragDropAdapter.notifyDataSetChanged()
            }

        })
        helper.attachToRecyclerView(mRecyclerView)
    }

    private fun listItem(): MutableList<ViewType> {
        val list = mutableListOf<ViewType>()
        for (i in 1 until 20) {
            list.add(ViewType("Demo $i", "Description $i", false))
        }
        return list
    }
}