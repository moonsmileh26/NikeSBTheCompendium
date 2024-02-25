package com.moonsmileh.nikesbcompendium.ui.dunks

import com.moonsmileh.nikesbcompendium.domain.model.Dunk

open class DunksState {
    data class Loading(val isLoading: Boolean) : DunksState()

    data class Error(val error: kotlin.Error) : DunksState()

    data class Success(val dunks: List<Dunk>) : DunksState()
}