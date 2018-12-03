package first.boappok.com.boappok.Model

import android.databinding.ObservableBoolean

class ActionCreator {

    lateinit var actionDescription : ActionDescription


    var doubleClick : ObservableBoolean?=  null


    constructor()
    {
        this.doubleClick = ObservableBoolean(false)
    }

    constructor(actionDescription: ActionDescription?)
    {

        this.actionDescription = ActionDescription(actionDescription as ActionDescription)
        this.doubleClick = ObservableBoolean(false)

    }



}