package demoss.example.com.androidalldemo.home.viewmodel

import android.arch.lifecycle.ViewModel
import android.view.View

class HomeViewModel(private val listner : HomeCallbacks) : ViewModel() {

    //setup onclick for open retrofit demo
    fun openRetrofitDemo(view : View)
    {
        listner.retrofitDemoOpen()
    }
}