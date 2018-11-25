package first.boappok.com.boappok.UI

import android.content.Context
import android.databinding.ObservableField
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import first.boappok.com.boappok.Model.Action
import first.boappok.com.boappok.Model.ActionDescription
import first.boappok.com.boappok.R

class ComposerItemsAdapter(private val myDataset: ArrayList<ActionDescription>,private val itemAddObserver : ObservableField<Action>) :
    RecyclerView.Adapter<ComposerItemsAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val layout: LinearLayout) : RecyclerView.ViewHolder(layout)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ComposerItemsAdapter.MyViewHolder {
        // create a new view
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.composer_item, parent, false) as LinearLayout
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(layout)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.layout.findViewById<TextView>(R.id.TVDescription).text = myDataset.get(position).actionDescription
        holder.layout.findViewById<TextView>(R.id.TVNameAction).text = myDataset.get(position).actionName

        //Add action
        holder.layout.findViewById<Button>(R.id.BTAddAction).setOnClickListener {
            itemAddObserver.set(myDataset.get(position).action)
        }

        when(myDataset.get(position).actionContentType)
        {
            ActionDescription.ActionContentType.Text -> holder.layout.findViewById<ImageView>(R.id.IVActionContent).setImageResource(R.drawable.ic_text)

            ActionDescription.ActionContentType.Image -> holder.layout.findViewById<ImageView>(R.id.IVActionContent).setImageResource(R.drawable.ic_media)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}