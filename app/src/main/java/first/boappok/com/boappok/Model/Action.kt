package first.boappok.com.boappok.Model

import android.databinding.ObservableBoolean
import java.util.*

 class Action {

    var actionType : ActionEnum? = null
    var actionCompleted : ObservableBoolean = ObservableBoolean(false)
    var countClick : Int = 0

    var  resource : Any? = null


    constructor()

    constructor(actionType : ActionEnum, resource: Any  )
    {
        this.actionType = actionType

        this.resource = resource

        this.countClick = 0
    }


}