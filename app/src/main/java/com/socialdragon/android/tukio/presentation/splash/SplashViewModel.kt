package com.socialdragon.android.tukio.presentation.splash

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.socialdragon.android.tukio.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    fun setupApp(view: View?) {
        viewModelScope.launch {
            delay(3000L)
            view?.findNavController()?.navigate(R.id.onboardingFragment)
        }
    }
}
