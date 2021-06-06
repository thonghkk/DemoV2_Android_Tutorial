package com.example.android_tutorial.multiple_view_type

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_tutorial.R
import com.example.android_tutorial.common.KeyView.Companion.TYPE_CUSTOM
import com.example.android_tutorial.common.KeyView.Companion.TYPE_DEFAULT
import com.example.android_tutorial.model.ViewType

class ViewTypeAdapter(private val viewType: List<ViewType>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val checkStatus = viewType[position]
        return if (checkStatus.isTypeOne) (TYPE_DEFAULT) else (TYPE_CUSTOM)
    }

    class ViewHolderType(view: View) : RecyclerView.ViewHolder(view) {
        private val mTxtTitle = itemView.findViewById<TextView>(R.id.mTxtTitle)
        private val mTxtDescription = itemView.findViewById<TextView>(R.id.mTxtDescription)
        fun bindTo(viewType: ViewType) {
            mTxtTitle.text = viewType.title
            mTxtDescription.text = viewType.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_DEFAULT) {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_type_1, parent, false)
            ViewHolderType(v)
        } else {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_type_2, parent, false)
            ViewHolderType(v)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolderType
        if (TYPE_DEFAULT == holder.itemViewType) {
            viewHolder.bindTo(viewType[position])
        } else {
            viewHolder.bindTo(viewType[position])
        }
    }

    override fun getItemCount() = viewType.size
}