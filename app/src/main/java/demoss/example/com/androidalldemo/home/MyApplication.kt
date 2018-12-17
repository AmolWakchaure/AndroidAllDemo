package demoss.example.com.androidalldemo.home

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    companion object {

        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()

        //initialize context
        context = applicationContext

    }
}