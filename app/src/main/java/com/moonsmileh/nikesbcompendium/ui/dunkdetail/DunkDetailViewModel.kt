package com.moonsmileh.nikesbcompendium.ui.dunkdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonsmileh.nikesbcompendium.domain.usecase.GetDunkByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DunkDetailViewModel @Inject constructor(private val getDunkByIdUseCase: GetDunkByIdUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<DunkDetailState>(DunkDetailState.Loading)
    val state: StateFlow<DunkDetailState> = _state

    fun getDunkById(id: String) {
        viewModelScope.launch {
            _state.value = DunkDetailState.Loading
            val result = withContext(Dispatchers.IO) {
                getDunkByIdUseCase(id)
            }

        }

    }

}