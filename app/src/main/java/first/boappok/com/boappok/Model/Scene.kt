package first.boappok.com.boappok.Model

import android.app.Activity
import android.app.Application
import android.content.Context
import android.databinding.Observable
import android.databinding.ObservableBoolean
import android.view.View
import first.boappok.com.boappok.Composer



open class Scene {

    var SceneCompleted : ObservableBoolean = ObservableBoolean(false)
    var listAction : ArrayList<Action> = ArrayList<Action>()
    var countAction = 0
    var view : View? = null
    var ctx : Context? = null

    constructor (view : View?,ctx:Context?)
    {
        this.view = view
        this.ctx = ctx

    }

    open fun AddAction (action: Action)
    {
        listAction.add(action)
    }


    open fun ExecuteScene(activity : Activity?)
    {


        var action_ = listAction.elementAt(countAction);

        action_.actionCompleted.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(p0: Observable?, p1: Int) {

                countAction++

                if(countAction == listAction.size)
                {
                    SceneCompleted.set(true)
                    return
                }


                    ExecuteScene(activity)



            }
        })

        activity?.runOnUiThread {

            ExecuteAction(action_)
        }

    }


    fun ExecuteAction(action:Action)
    {

        val composer  = Composer(ctx,view)

        when(action.actionType)
        {
            ActionEnum.PlayMedia -> composer.PlayMedia(action)

            ActionEnum.SetDownText -> composer.SetDownText(action)

            ActionEnum.DelayTime -> composer.SetDelay(action)

            ActionEnum.SetBackgroundPrincipal -> composer.SetBackgroundColorPrincipalCL(action)

            ActionEnum.SetImageCenter -> composer.SetImageCenter(action)

            ActionEnum.ClickContinue -> composer.ClickContinue(action)

            ActionEnum.SetImageLeft -> composer.SetLeftImage(action)

            ActionEnum.SetImageRight -> composer.SetRightImage(action)

            ActionEnum.SetTextCenter -> composer.SetCenterText(action)

            ActionEnum.ClearBackgroundPrincipal -> composer.ClearBackgroundColorPrincipalCL(action)

            ActionEnum.ClearImageCenter -> composer.ClearImageCenter(action)

            ActionEnum.ClearImageLeft -> composer.ClearImageLeft(action)

            ActionEnum.ClearImageRight -> composer.ClearImageRight(action)

            ActionEnum.SetCenterImage -> composer.SetImageCenter(action)

            ActionEnum.ClearImageTop -> composer.ClearImageTop(action)

            ActionEnum.SetImageTop -> composer.SetImageTop(action)

        }
    }





}