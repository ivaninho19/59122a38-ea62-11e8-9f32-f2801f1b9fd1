package first.boappok.com.boappok.Chapters

import android.content.Context
import android.databinding.Observable
import android.view.View
import first.boappok.com.boappok.Model.Action
import first.boappok.com.boappok.Model.ActionEnum
import first.boappok.com.boappok.Model.Chapter
import first.boappok.com.boappok.Model.Scene
import first.boappok.com.boappok.R
import java.util.*

class Chapter1 {

    var sceneList : ArrayList<Scene> = ArrayList<Scene>()

    var sceneCount : Int = 0


    constructor(ctx: Context,view : View)
    {

        var scene  = Scene(view,ctx)
        scene.ExecuteAction(Action(ActionEnum.playMedia, R.raw.storm))

        scene.SceneCompleted.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(p0: Observable?, p1: Int) {

            }
        })

    }





}