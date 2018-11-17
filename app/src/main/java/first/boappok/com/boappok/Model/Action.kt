package first.boappok.com.boappok.Model

import java.util.*

class Action {

    var actionType : ActionEnum? = null


    var  resource : Any? = null



    constructor(actionType : ActionEnum, resource: Any  )
    {
        this.actionType = actionType

        this.resource = resource
    }


}