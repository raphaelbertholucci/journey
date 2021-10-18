package com.bertholucci.journey.presentation.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.journey.databinding.ItemMainBinding
import com.bertholucci.journey.presentation.model.Journey

class MainViewHolder internal constructor(
    itemView: View,
    val onClick: ((Journey) -> Unit)? = null
) :
    RecyclerView.ViewHolder(itemView) {

    private var binding = ItemMainBinding.bind(itemView)

    fun bind(item: Journey) {
        binding.tvTitle.text = item.title
        binding.tvDescription.text = item.subtitle
        binding.tvNumber.text = item.day.toString()

        itemView.setOnClickListener { onClick?.invoke(item) }
    }
}