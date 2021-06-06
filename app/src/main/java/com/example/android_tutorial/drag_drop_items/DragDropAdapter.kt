package com.example.android_tutorial.drag_drop_items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_tutorial.R
import com.example.android_tutorial.model.ViewType

class DragDropAdapter(val lists: List<ViewType>) :
    RecyclerView.Adapter<DragDropAdapter.ViewHolderCustom>() {
    class ViewHolderCustom(v: View) : RecyclerView.ViewHolder(v) {
        private var mTxtTitle = itemView.findViewById<TextView>(R.id.mTxtTitle)
        private var mTxtDescription = itemView.findViewById<TextView>(R.id.mTxtDescription)

        fun bindTo(list: ViewType) {
            mTxtTitle.text = list.title
            mTxtDescription.text = list.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCustom {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_type_1, parent, false)
        return ViewHolderCustom(v)
    }

    override fun onBindViewHolder(holder: ViewHolderCustom, position: Int) {
        holder.bindTo(lists[position])
    }

    override fun getItemCount() = lists.size
}