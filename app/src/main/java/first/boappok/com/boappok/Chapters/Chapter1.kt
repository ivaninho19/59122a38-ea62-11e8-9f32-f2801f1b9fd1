package first.boappok.com.boappok.Chapters

import android.app.Activity
import android.content.Context
import android.databinding.Observable
import android.view.View
import first.boappok.com.boappok.Model.*
import first.boappok.com.boappok.R
import java.util.*

class Chapter1 {

    var sceneList : ArrayList<Scene> = ArrayList<Scene>()
    var sceneCount : Int = 0
    var ctx : Context? = null
    var view : View? = null
    var activity : Activity? = null


    constructor(actions : List<ActionCreator>,view:View,ctx:Context,activity: Activity)
    {
        var FirstScene  = Scene(view,ctx)

        this.activity = activity

        for (item in actions)
        {
            FirstScene.AddAction(item.actionDescription.action as Action)

        }

        sceneList.add(FirstScene)

        nextScene()

    }


    /*constructor(ctx: Context?,view : View?,activity:Activity)
    {
        this.ctx = ctx
        this.view = view
        this.activity = activity;

        generateScenes()

        nextScene()
    }*/


    private fun generateScenes()
    {
        var FirstScene  = Scene(view,ctx)

        //FirstScene.AddAction(Action(ActionEnum.PlayMedia,R.raw.storm))
        //FirstScene.AddAction(Action(ActionEnum.DelayTime,5000L))
        FirstScene.AddAction(Action(ActionEnum.SetDownText,"Este es mi primer mensaje"))
        /*FirstScene.AddAction(Action(ActionEnum.DelayTime,3000L))
        FirstScene.AddAction(Action(ActionEnum.SetBackgroundPrincipal,R.color.material_blue_grey_800))
        FirstScene.AddAction(Action(ActionEnum.DelayTime,3000L))
        FirstScene.AddAction(Action(ActionEnum.SetImageCenter,R.drawable.ic_launcher_background))
        FirstScene.AddAction(Action(ActionEnum.ClickContinue,""))
        FirstScene.AddAction(Action(ActionEnum.SetDownText,"Y este mi segundo"))*/
        FirstScene.AddAction(Action(ActionEnum.SetImageLeft,R.drawable.ic_launcher_background))
        FirstScene.AddAction(Action(ActionEnum.ClickContinue,""))
        FirstScene.AddAction(Action(ActionEnum.ClearImageLeft,R.drawable.ic_launcher_background))
        FirstScene.AddAction(Action(ActionEnum.ClickContinue,""))
        FirstScene.AddAction(Action(ActionEnum.SetCenterImage,R.drawable.ic_launcher_background))
        FirstScene.AddAction(Action(ActionEnum.ClickContinue,""))
        FirstScene.AddAction(Action(ActionEnum.SetCenterImage,R.drawable.ic_launcher_background))
        FirstScene.AddAction(Action(ActionEnum.ClickContinue,""))
        FirstScene.AddAction(Action(ActionEnum.ClearImageCenter,R.drawable.ic_launcher_background))
        FirstScene.AddAction(Action(ActionEnum.ClickContinue,""))
        FirstScene.AddAction(Action(ActionEnum.SetImageRight,R.drawable.ic_launcher_background))
        FirstScene.AddAction(Action(ActionEnum.ClickContinue,""))
        FirstScene.AddAction(Action(ActionEnum.ClearImageRight,R.drawable.ic_launcher_background))



        sceneList.add(FirstScene)

    }


    fun nextScene()
    {

        if(sceneList.size > sceneCount)
        {
            var scene = sceneList.elementAt(sceneCount)

            scene.ExecuteScene(activity)

            scene.SceneCompleted.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(p0: Observable?, p1: Int) {
                    sceneCount++
                    nextScene()
                }
            })

        }

    }




}