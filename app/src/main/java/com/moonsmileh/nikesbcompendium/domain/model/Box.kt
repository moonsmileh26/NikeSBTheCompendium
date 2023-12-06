package com.moonsmileh.nikesbcompendium.domain.model

import com.moonsmileh.nikesbcompendium.R

enum class Box(val color: Int, val image: Int) {
    SAIL(R.string.box_sail, R.drawable.sail_box),
    STRIPED(R.string.box_striped, R.drawable.striped_box),
    TEAL(R.string.box_teal, R.drawable.teal_box),
    TAPED(R.string.box_taped, R.drawable.taped_box),
    BLUE(R.string.box_blue, R.drawable.blue_box),
    GOLD(R.string.box_gold, R.drawable.gold_box),
    BLACK(R.string.box_black, R.drawable.black_box),
    PINK(R.string.box_pink, R.drawable.pink_box),
    SILVER(R.string.box_silver, R.drawable.silver_box),
    ORANGE(R.string.box_orange, R.drawable.orange_box)
}