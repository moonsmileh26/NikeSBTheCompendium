package com.moonsmileh.nikesbcompendium.ui.dunks

sealed class SneakersViewState {
    data object Loading : SneakersViewState()
    data class Error(val error: kotlin.Error) : SneakersViewState()
    data class Success(val data: String) : SneakersViewState()
}