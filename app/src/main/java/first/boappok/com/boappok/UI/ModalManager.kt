package first.boappok.com.boappok.UI

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.view.Gravity
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import first.boappok.com.boappok.R


class ModalManager{

    lateinit var activity:Activity
    lateinit var ctx:Context

    constructor(activity: Activity,ctx:Context)
    {
        this.activity = activity
        this.ctx = ctx
    }

    fun showPopUp() {

        val popuWindow : PopupWindow = PopupWindow(ctx)



        val builder = AlertDialog.Builder(ctx)
        val layoutInflater = activity.layoutInflater

        //this is custom dialog
        //custom_popup_dialog contains textview only
        val customView = layoutInflater.inflate(R.layout.text_modal, null)
        // reference the textview of custom_popup_dialog

        popuWindow.contentView = customView

        popuWindow.showAtLocation(activity.findViewById(R.id.CLPrincipal),Gravity.CENTER,0,0)

    }

}