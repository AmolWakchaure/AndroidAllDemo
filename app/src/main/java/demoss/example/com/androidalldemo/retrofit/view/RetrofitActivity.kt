package demoss.example.com.androidalldemo.retrofit.view

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.RemoteCallbackList
import android.support.v7.widget.LinearLayoutManager
import demoss.example.com.androidalldemo.R
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import demoss.example.com.androidalldemo.retrofit.adapters.CustomAdapter
import android.widget.Toast
import demoss.example.com.androidalldemo.home.MyApplication
import demoss.example.com.androidalldemo.home.view.MainActivity
import demoss.example.com.androidalldemo.retrofit.model.RetroPhoto
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class RetrofitActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        var progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java)
        val call = service.getAllPhotos()
        call.enqueue(object : Callback<List<RetroPhoto>> {
            override fun onResponse(call: Call<List<RetroPhoto>>, response: Response<List<RetroPhoto>>) {
                progressDialog.dismiss()
                generateDataList(response.body())
            }

            override fun onFailure(call: Call<List<RetroPhoto>>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(MyApplication.context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun generateDataList(body: List<RetroPhoto>?) {


        dataHistory.layoutManager = LinearLayoutManager(MyApplication.context, LinearLayout.VERTICAL, false)
        val adapter = CustomAdapter(body!!);
        dataHistory.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
