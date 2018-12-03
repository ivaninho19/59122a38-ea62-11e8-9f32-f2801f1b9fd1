package first.boappok.com.boappok.UI

import android.annotation.SuppressLint
import android.databinding.ObservableField
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.pedromassango.doubleclick.DoubleClickListener
import first.boappok.com.boappok.Activities.CreatorActivity
import first.boappok.com.boappok.Model.Action
import first.boappok.com.boappok.Model.ActionCreator
import first.boappok.com.boappok.Model.ActionDescription
import first.boappok.com.boappok.R

class SceneItemsAdapter (private val myDataset: ArrayList<ActionCreator>) :
    RecyclerView.Adapter<SceneItemsAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val layout: LinearLayout) : RecyclerView.ViewHolder(layout)

    var row_index : Int = -1


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): SceneItemsAdapter.MyViewHolder {
        // create a new view
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.composer_scene_item, parent, false) as LinearLayout
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(layout)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.layout.findViewById<TextView>(R.id.TVActionName).text = myDataset.get(position).actionDescription?.action?.actionType.toString()


        holder.layout.findViewById<LinearLayout>(R.id.LLRoot).setOnClickListener{
            row_index = position
            notifyDataSetChanged()


            if(CreatorActivity.selectedPosition == position)
            {
                Log.i("","")
                //Double click

                myDataset.get(position).doubleClick?.set(true)
            }else{
                //Click
                Log.i("","")


            }


            CreatorActivity.selectedPosition = position

        }


        if(row_index==position){
            holder.layout.findViewById<LinearLayout>(R.id.LLRoot).setBackgroundColor(Color.parseColor("#567845"));

        }
        else
        {
            holder.layout.findViewById<LinearLayout>(R.id.LLRoot).setBackgroundColor(Color.parseColor("#f5f5f5"));

        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}