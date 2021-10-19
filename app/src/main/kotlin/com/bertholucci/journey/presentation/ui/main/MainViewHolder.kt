package com.bertholucci.journey.presentation.ui.main

import android.graphics.drawable.GradientDrawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.journey.R
import com.bertholucci.journey.common.helpers.NumbersToWords.convertNumberToWord
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
        (binding.tvNumber.background as GradientDrawable).setColor(
            ContextCompat.getColor(itemView.context, R.color.circle)
        )

        val dayConverted = itemView.resources.getString(
            R.string.day, item.day.convertNumberToWord()
        )
        binding.tvDay.text = dayConverted

        itemView.setOnClickListener { onClick?.invoke(item) }
    }
}