package com.moonsmileh.nikesbcompendium.ui.dunkdetail

import androidx.lifecycle.ViewModel
import com.moonsmileh.nikesbcompendium.data.provider.BoxProvider
import com.moonsmileh.nikesbcompendium.domain.model.Box
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DunksViewModel @Inject constructor(provider: BoxProvider) : ViewModel() {
    private var _boxes = MutableStateFlow<List<Box>>(emptyList())
    val boxes: StateFlow<List<Box>> = _boxes

    init {
        _boxes.value = provider.getBoxes()
    }
}