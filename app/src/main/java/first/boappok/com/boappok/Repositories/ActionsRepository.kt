package first.boappok.com.boappok.Repositories

import android.content.Context
import first.boappok.com.boappok.Model.Action
import first.boappok.com.boappok.Model.ActionDescription
import first.boappok.com.boappok.Model.ActionEnum
import first.boappok.com.boappok.R

class ActionsRepository {

    companion object {
        fun getActions(ctx:Context) : ArrayList<ActionDescription>
        {
            var result :ArrayList<ActionDescription> = ArrayList()

            result.add(ActionDescription(ctx.resources.getString(R.string.action_textdown_Name),
                                          ctx.resources.getString(R.string.action_textdown_Description),
                                        Action(ActionEnum.SetDownText,""),ActionDescription.ActionContentType.Text))

            result.add(ActionDescription(ctx.resources.getString(R.string.action_textcenter_Name),
                ctx.resources.getString(R.string.action_textcenter_Description),
                Action(ActionEnum.SetTextCenter,""),ActionDescription.ActionContentType.Text))

            result.add(ActionDescription(ctx.resources.getString(R.string.action_imagecenter_Name),
                ctx.resources.getString(R.string.action_imagecenter_Description),
                Action(ActionEnum.SetImageCenter,""),ActionDescription.ActionContentType.Image))

            result.add(ActionDescription(ctx.resources.getString(R.string.action_imagecenterclear_Name),
                ctx.resources.getString(R.string.action_imagecenterclear_Description),
                Action(ActionEnum.ClearImageCenter,""),ActionDescription.ActionContentType.Image))



            return result

        }
    }


}