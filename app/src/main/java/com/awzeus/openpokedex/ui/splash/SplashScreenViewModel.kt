package com.awzeus.openpokedex.ui.splash

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception

class SplashScreenViewModel: ViewModel() {
    private val _shouldStartMainScreen = MutableLiveData(false)
    val shouldStartMainScreen: LiveData<Boolean> = _shouldStartMainScreen

    init {
        Handler().postDelayed({
            _shouldStartMainScreen.value = true
        }, 2000)
    }

    class SplashScreenFactory: ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SplashScreenViewModel::class.java)) {
                return SplashScreenViewModel() as T
            }
            throw Exception("Class type not supported")
        }

    }
}