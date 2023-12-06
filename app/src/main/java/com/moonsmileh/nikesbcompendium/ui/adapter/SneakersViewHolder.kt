package com.moonsmileh.nikesbcompendium.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.moonsmileh.nikesbcompendium.databinding.ItemSneakerBinding
import com.moonsmileh.nikesbcompendium.domain.model.Box

class SneakersViewHolder(view: View) : ViewHolder(view) {

    private val binding = ItemSneakerBinding.bind(view)

    fun render(box: Box, onItemSelected: (Box) -> Unit) {
        binding.imageViewSneaker.setImageResource(box.image)
        binding.layoutParent.setOnClickListener { onItemSelected(box) }
    }

}