package com.moonsmileh.nikesbcompendium.ui.dunkdetail

import androidx.lifecycle.ViewModel
import com.moonsmileh.nikesbcompendium.domain.model.Dunk
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DunkDetailViewModel @Inject constructor() : ViewModel() {
    private var _dunks = MutableStateFlow<List<Dunk>>(emptyList())
    val dunks: StateFlow<List<Dunk>> = _dunks

    init {
    }
}