package com.bertholucci.journey.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.journey.R
import com.bertholucci.journey.presentation.model.Journey

class MainAdapter(
    private val list: List<Journey>,
    private val onClick: ((Journey) -> Unit)? = null
) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_main, parent, false),
            onClick = onClick
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }
}