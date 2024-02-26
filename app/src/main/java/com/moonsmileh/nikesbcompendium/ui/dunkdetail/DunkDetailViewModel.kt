package com.moonsmileh.nikesbcompendium.ui.dunkdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonsmileh.nikesbcompendium.domain.model.Dunk
import com.moonsmileh.nikesbcompendium.domain.usecase.GetDunkByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DunkDetailViewModel @Inject constructor(private val getDunkByIdUseCase: GetDunkByIdUseCase) :
    ViewModel() {
    private var _dunkDetailState = MutableStateFlow(DunkDetailState())
    val dunkDetailState: StateFlow<DunkDetailState> = _dunkDetailState

    fun getDunkById(id: String) {
        viewModelScope.launch {
            _dunkDetailState.value = DunkDetailState.Loading(true)
            val result = withContext(Dispatchers.IO) {
                getDunkByIdUseCase(id)
            }
            if (result != null) {
                _dunkDetailState.value = DunkDetailState.Success(result)
            } else {
                _dunkDetailState.value = DunkDetailState.Error(Error())
            }
            _dunkDetailState.value = DunkDetailState.Loading(false)
        }
    }
}