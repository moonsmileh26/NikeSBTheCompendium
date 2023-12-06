package com.moonsmileh.nikesbcompendium.data.provider

import com.moonsmileh.nikesbcompendium.domain.model.Box
import javax.inject.Inject

class BoxProvider @Inject constructor() {
    fun getBoxes(): List<Box> =
        listOf(
            Box.SAIL, Box.STRIPED, Box.TEAL, Box.TAPED, Box.BLUE, Box.GOLD, Box.BLACK,
            Box.PINK, Box.SILVER, Box.ORANGE
        )
}