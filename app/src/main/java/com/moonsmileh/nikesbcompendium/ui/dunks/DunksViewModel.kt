package com.moonsmileh.nikesbcompendium.ui.dunks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonsmileh.nikesbcompendium.domain.usecase.GetDunksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DunksViewModel @Inject constructor(private val getDunksUseCase: GetDunksUseCase) :
    ViewModel() {

    private val _dunksState = MutableStateFlow(DunksState())
    val dunksState: StateFlow<DunksState> = _dunksState

    init {
        viewModelScope.launch {
            _dunksState.value = DunksState.Loading(true)
            val result = withContext(Dispatchers.IO) {
                getDunksUseCase
            }
            val dunks = result.invoke()
            if (dunks != null) {
                if (dunks.isNotEmpty()) {
                    _dunksState.value = DunksState.Success(dunks)
                } else {
                    _dunksState.value = DunksState.Error(Error())
                }
            }
            _dunksState.value = DunksState.Loading(false)
        }
    }
}