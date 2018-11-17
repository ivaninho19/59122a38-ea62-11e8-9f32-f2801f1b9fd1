package first.boappok.com.boappok.Model

import android.content.Context
import android.databinding.ObservableBoolean
import android.view.View
import first.boappok.com.boappok.Composer

open class Scene {

    var SceneCompleted : ObservableBoolean = ObservableBoolean(false)
    var listAction : ArrayList<Action> = ArrayList<Action>()

    var view : View? = null
    var ctx : Context? = null

    constructor (view : View,ctx:Context)
    {
        this.view = view
        this.ctx = ctx

    }

    open fun AddAction (action: Action)
    {
        listAction.add(action)
    }


    open fun ExecuteAction(action:Action)
    {

        val composer  = Composer(ctx,view)

        when(action.actionType)
        {
            ActionEnum.playMedia -> composer.PlayMedia(action.resource as Int)

            ActionEnum.SetDownText -> composer.SetDownText(action.resource as String)
        }

    }





}