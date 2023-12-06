package com.moonsmileh.nikesbcompendium.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moonsmileh.nikesbcompendium.R
import com.moonsmileh.nikesbcompendium.domain.model.Box

class SneakersAdapter(
    private var boxes: List<Box> = emptyList(),
    private val onItemSelected: (Box) -> Unit
) :
    RecyclerView.Adapter<SneakersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SneakersViewHolder {
        return SneakersViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_dunk, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SneakersViewHolder, position: Int) {
        holder.render(boxes[position], onItemSelected)
    }

    override fun getItemCount() = boxes.size

    fun updateList(list: List<Box>) {
        boxes = list
        notifyDataSetChanged()
    }
}