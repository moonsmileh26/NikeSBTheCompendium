package com.moonsmileh.nikesbcompendium.ui.dunkdetail

import com.moonsmileh.nikesbcompendium.domain.model.DunkDetail

open class DunkDetailState {
    data class Loading(val isLoading: Boolean) : DunkDetailState()
    data class Error(val error: kotlin.Error) : DunkDetailState()
    data class Success(val dunk: DunkDetail) : DunkDetailState()
}
