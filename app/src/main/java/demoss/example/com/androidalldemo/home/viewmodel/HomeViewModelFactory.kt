package demoss.example.com.androidalldemo.home.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class HomeViewModelFactory (private val listner : HomeCallbacks) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel (listner) as T
    }
}