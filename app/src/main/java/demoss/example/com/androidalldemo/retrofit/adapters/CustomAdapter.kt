package demoss.example.com.androidalldemo.retrofit.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import demoss.example.com.androidalldemo.R
import demoss.example.com.androidalldemo.retrofit.model.RetroPhoto
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import demoss.example.com.androidalldemo.home.MyApplication


class CustomAdapter (val userList: List<RetroPhoto>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>()
{
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.data_row, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int
    {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        fun bindItems(user: RetroPhoto)
        {
            val txtTitle = itemView.findViewById(R.id.txtTitle) as TextView
            val imageFile = itemView.findViewById(R.id.imageFile) as ImageView

            txtTitle.text = user.getTitle()

            val builder = Picasso.Builder(MyApplication.context)
            builder.downloader(OkHttp3Downloader(MyApplication.context))
            builder.build().load(user.getThumbnailUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageFile)



        }


    }
}