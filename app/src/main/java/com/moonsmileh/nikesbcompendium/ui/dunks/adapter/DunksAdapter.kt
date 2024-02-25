package com.moonsmileh.nikesbcompendium.ui.dunks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moonsmileh.nikesbcompendium.R
import com.moonsmileh.nikesbcompendium.domain.model.Box
import com.moonsmileh.nikesbcompendium.domain.model.Dunk

class DunksAdapter(
    private var dunks: List<Dunk> = emptyList(),
    private val onItemSelected: (Dunk) -> Unit
) :
    RecyclerView.Adapter<DunksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DunksViewHolder {
        return DunksViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_dunk, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DunksViewHolder, position: Int) {
        holder.render(dunks[position], onItemSelected)
    }

    override fun getItemCount() = dunks.size

    fun updateList(list: List<Dunk>) {
        dunks = list
        notifyDataSetChanged()
    }
}