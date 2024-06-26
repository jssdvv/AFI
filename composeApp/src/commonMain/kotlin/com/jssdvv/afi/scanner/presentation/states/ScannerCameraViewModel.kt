package com.jssdvv.afi.scanner.presentation.states

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScannerCameraViewModel : ViewModel() {

    private val _text = MutableStateFlow(String())
    private val _isTorchEnabled = MutableStateFlow(false)
    private val _isEditModeEnabled = MutableStateFlow(false)
    private val _isCameraFlipped = MutableStateFlow(false)

    val text = _text.asStateFlow()
    val isTorchEnabled = _isTorchEnabled.asStateFlow()
    val isEditModeEnabled = _isEditModeEnabled.asStateFlow()
    val isCameraFlipped = _isCameraFlipped.asStateFlow()

    fun onTextChange(text: String) {
        _text.value = text
    }

    fun toggleTorch() {
        _isTorchEnabled.value = !_isTorchEnabled.value
    }

    fun toggleEditMode() {
        _isEditModeEnabled.value = !_isEditModeEnabled.value
    }

    fun toggleCamera() {
        _isCameraFlipped.value = !_isCameraFlipped.value
    }
}