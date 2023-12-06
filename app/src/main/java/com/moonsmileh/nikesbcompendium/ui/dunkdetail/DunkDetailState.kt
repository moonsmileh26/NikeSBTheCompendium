package com.moonsmileh.nikesbcompendium.ui.dunkdetail

import com.moonsmileh.nikesbcompendium.domain.model.DunkDetail

sealed class DunkDetailState {
    data object Loading : DunkDetailState()
    data class Error(val error: kotlin.Error) : DunkDetailState()
    data class Success(val dunk: DunkDetail) : DunkDetailState()
}
