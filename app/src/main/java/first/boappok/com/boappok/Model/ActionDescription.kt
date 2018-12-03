package first.boappok.com.boappok.Model

class ActionDescription
{

    enum class ActionContentType{
        PlayMusic,
        Image,
        Text,
        Continue
    }

    var actionName : String? = null
    var actionDescription : String? = null
    var action : Action? = null
    var actionContentType : ActionContentType? = null


    constructor()

    constructor(actionName : String?,actionDescription: String?,action: Action,actionContentType:ActionContentType)
    {
        this.actionName = actionName
        this.actionDescription = actionDescription
        this.action = action
        this.actionContentType =actionContentType
    }

    constructor(actiondes: ActionDescription)
    {
        this.actionName = actiondes.actionName
        this.actionDescription = actiondes.actionDescription
        this.action = Action(actiondes.action?.actionType as ActionEnum,actiondes.action?.resource as Any)
        this.actionContentType =actiondes.actionContentType
    }

}