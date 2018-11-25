package first.boappok.com.boappok.Activities

import android.databinding.Observable
import android.databinding.ObservableField
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import first.boappok.com.boappok.Model.Action
import first.boappok.com.boappok.R
import first.boappok.com.boappok.Repositories.ActionsRepository
import first.boappok.com.boappok.UI.ComposerItemsAdapter

class CreatorActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    public lateinit var addItemObserver : ObservableField<Action>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creator_layout)

        addItemObserver = ObservableField()

        configureAdapterActions()


        addItemObserver.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(p0: Observable?, p1: Int) {


                AddAction((p0 as ObservableField<Action>).get())

            }
        })


    }

    fun configureAdapterActions()
    {
        viewManager = LinearLayoutManager(this)

        var list = ActionsRepository.getActions(this)

        viewAdapter = ComposerItemsAdapter(list,addItemObserver)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    fun AddAction(action : Action?)
    {
        Log.i("","");
    }

}
