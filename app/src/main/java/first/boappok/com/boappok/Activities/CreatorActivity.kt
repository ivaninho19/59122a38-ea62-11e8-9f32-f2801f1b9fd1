package first.boappok.com.boappok.Activities

import android.content.Intent
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import first.boappok.com.boappok.Model.Action
import first.boappok.com.boappok.Model.ActionCreator
import first.boappok.com.boappok.Model.ActionDescription
import first.boappok.com.boappok.R
import first.boappok.com.boappok.Repositories.ActionsRepository
import first.boappok.com.boappok.UI.ComposerItemsAdapter
import first.boappok.com.boappok.UI.ModalManager
import first.boappok.com.boappok.UI.SceneItemsAdapter

class CreatorActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var recyclerViewScene: RecyclerView
    private lateinit var viewAdapterScene: RecyclerView.Adapter<*>
    private lateinit var viewManagerScene: RecyclerView.LayoutManager

    companion object {
        var selectedPosition: Int = -1
    }


    lateinit var listActions : ArrayList<ActionCreator>

    lateinit var addItemObserver : ObservableField<ActionDescription>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creator_layout)

        addItemObserver = ObservableField()

        listActions = ArrayList()

        configureAdapterActions()

        configureAdapterScenes()


        addItemObserver.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(p0: Observable?, p1: Int) {

                if( (p0 as ObservableField<ActionDescription>).get() != null)
                {

                    var actioncreator = ActionCreator()

                    actioncreator.actionDescription = p0.get() as ActionDescription

                    AddAction(actioncreator)
                }

                addItemObserver.set(null)

            }
        })

        findViewById<Button>(R.id.BPlayScene).setOnClickListener {

            SceneBoardActivity.ActionList = listActions

            var intent:Intent = Intent(this@CreatorActivity,SceneBoardActivity::class.java)

            startActivity(intent)

        }


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
            layoutManager = LinearLayoutManager(applicationContext)

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    fun configureAdapterScenes()
    {
        viewManagerScene = LinearLayoutManager(this)

        viewAdapterScene = SceneItemsAdapter(listActions)

        recyclerViewScene = findViewById<RecyclerView>(R.id.recyclerviewscenes).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)

            // specify an viewAdapter (see also next example)
            adapter = viewAdapterScene

        }
    }

    fun AddAction(action : ActionCreator?)
    {

        var actionCreatorInsert = ActionCreator(action?.actionDescription)

        listActions.add(actionCreatorInsert)

        viewAdapterScene.notifyDataSetChanged()

        actionCreatorInsert?.doubleClick?.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(p0: Observable?, p1: Int) {

                if((p0 as ObservableBoolean).get())
                {

                    editActionMode()

                    /*var modalManager:ModalManager = ModalManager(this@CreatorActivity,this@CreatorActivity.applicationContext)

                    modalManager.showPopUp()*/

                    (p0 as ObservableBoolean).set(false)
                }

            }
        })


    }


    fun editActionMode()
    {

        findViewById<ConstraintLayout>(R.id.CLEditSceneContainer).visibility = View.VISIBLE


        var actionSelected = listActions.get(selectedPosition)


        when(actionSelected.actionDescription?.actionContentType)
        {
            ActionDescription.ActionContentType.Image -> EditImage(actionSelected)

            ActionDescription.ActionContentType.Text -> EditText(actionSelected)

            ActionDescription.ActionContentType.PlayMusic -> EditSound(actionSelected)
        }



        findViewById<Button>(R.id.BAccept).setOnClickListener {


            when(actionSelected.actionDescription?.actionContentType)
            {
                ActionDescription.ActionContentType.Image -> EditImage(actionSelected)

                ActionDescription.ActionContentType.Text -> SaveEditText()

                ActionDescription.ActionContentType.PlayMusic -> EditSound(actionSelected)
            }

            cancelEditMode()

        }

        findViewById<Button>(R.id.BTCancel).setOnClickListener {

            cancelEditMode()

        }



    }

    fun EditImage(action:ActionCreator)
    {

    }

    fun EditText (action: ActionCreator)
    {
        var editText = getEditText()

        editText.setText( "" + action.actionDescription?.action?.resource)
    }

    fun SaveEditText()
    {

        var editText = getEditText()
        listActions.get(selectedPosition).actionDescription?.action?.resource = "" + editText.text


    }

    fun EditSound(action: ActionCreator)
    {

    }


    fun cancelEditMode()
    {
        findViewById<ConstraintLayout>(R.id.CLEditSceneContainer).visibility = View.GONE
    }


    fun getEditText() : EditText
    {
        var editText = findViewById<EditText>(R.id.ETText)
        return editText
    }


}
