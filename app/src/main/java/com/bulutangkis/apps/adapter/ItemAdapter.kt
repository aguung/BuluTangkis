package com.bulutangkis.apps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bulutangkis.apps.R

class ItemAdapter(private val data: List<String>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private lateinit var onItemClick: OnItemClick

    fun itemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var tvItem: TextView = itemView.findViewById(R.id.tvItem)
        fun bind(item: String) {
            tvItem.text = item
            itemView.setOnClickListener { onItemClick.onItemClicked(item, adapterPosition) }
        }

    }

    interface OnItemClick {
        fun onItemClicked(item: String, posisi: Int)
    }

}
