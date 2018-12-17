package demoss.example.com.androidalldemo.home.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import demoss.example.com.androidalldemo.R
import demoss.example.com.androidalldemo.databinding.ActivityMainBinding
import demoss.example.com.androidalldemo.home.viewmodel.HomeCallbacks
import demoss.example.com.androidalldemo.home.viewmodel.HomeViewModel
import demoss.example.com.androidalldemo.home.viewmodel.HomeViewModelFactory
import demoss.example.com.androidalldemo.retrofit.view.RetrofitActivity

class MainActivity : AppCompatActivity(),HomeCallbacks {

    override fun retrofitDemoOpen() {

        var retrofitIntent = Intent(this,RetrofitActivity::class.java)
        startActivity(retrofitIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        mainBinding.homeViewModel = ViewModelProviders.of(this,HomeViewModelFactory(this)).get(HomeViewModel::class.java)




    }
}
