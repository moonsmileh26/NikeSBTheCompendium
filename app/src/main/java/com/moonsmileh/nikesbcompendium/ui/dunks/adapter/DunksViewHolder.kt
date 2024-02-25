package com.moonsmileh.nikesbcompendium.ui.dunks.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.moonsmileh.nikesbcompendium.databinding.ItemListDunkBinding
import com.moonsmileh.nikesbcompendium.domain.model.Box
import com.moonsmileh.nikesbcompendium.domain.model.Dunk
import com.squareup.picasso.Picasso

class DunksViewHolder(view: View) : ViewHolder(view) {

    private val binding = ItemListDunkBinding.bind(view)

    fun render(dunk: Dunk, onItemSelected: (Dunk) -> Unit) {
        Picasso.get().load(dunk.imageUrl).into(binding.imageViewSneaker)
        binding.layoutParent.setOnClickListener { onItemSelected(dunk) }
    }

}