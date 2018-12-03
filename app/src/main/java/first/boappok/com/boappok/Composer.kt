package first.boappok.com.boappok

import `in`.codeshuffle.typewriterview.TypeWriterView
import android.content.Context
import android.media.MediaPlayer
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import first.boappok.com.boappok.Model.Action
import java.lang.Exception
import java.util.*
import kotlin.concurrent.schedule


open class Composer {



    private var ctx : Context? = null
    private var view : View? = null


    constructor(ctx : Context?,view : View?)
    {
        //Constructor

        this.ctx = ctx
        this.view = view
    }


    fun PlayMedia (action: Action)
    {

        var resource : Int = action.resource as Int

        var mediaPlayer: MediaPlayer? = MediaPlayer.create(ctx, resource)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start() // no need to call prepare(); create() does that for you

        action.actionCompleted.set(true)

    }

    fun SetDownText(action: Action)
    {
        var tv : TypeWriterView = view?.findViewById(R.id.TVDown) as TypeWriterView
        tv.setWithMusic(false)
        tv.setDelay(100)
        tv.animateText(action.resource as String)
        //tv.setTextColor(ctx?.resources?.getColor(R.color.white) as Int)


        action.actionCompleted.set(true)

    }

    fun SetCenterText(action: Action)
    {
        var tv : TypeWriterView = view?.findViewById(R.id.TVCenter) as TypeWriterView
        tv.setWithMusic(false)
        tv.setDelay(100)
        tv.animateText(action.resource as String)
        //tv.setTextColor(ctx?.resources?.getColor(R.color.white) as Int)
        
        action.actionCompleted.set(true)

    }


    fun SetDelay(action:Action)
    {
        var delayTime = action.resource as Long

        Timer("SettingUp", false).schedule(delayTime) {
            action.actionCompleted.set(true)
        }

    }

    fun SetBackgroundColorPrincipalCL(action:Action)
    {
        var cl : ConstraintLayout = view?.findViewById(R.id.CLPrincipal) as ConstraintLayout

        cl.setBackgroundColor(action.resource as Int)

        action.actionCompleted.set(true)

    }

    fun SetImageCenter(action:Action)
    {


        var IV : ImageView = view?.findViewById(R.id.IVCenter) as ImageView

        IV.setImageResource(action.resource as Int)

        action.actionCompleted.set(true)



    }

    fun SetImageTop(action:Action)
    {

        var IV : ImageView = view?.findViewById(R.id.IVTop) as ImageView

        IV.setImageResource(action.resource as Int)

        action.actionCompleted.set(true)

    }

    fun ClearImageTop(action:Action)
    {


        var IV : ImageView = view?.findViewById(R.id.IVTop) as ImageView

        IV.setImageResource(android.R.color.transparent)

        action.actionCompleted.set(true)



    }


    fun ClickContinue(action:Action)
    {
        var bt : Button = view?.findViewById(R.id.BContinue) as Button

        bt.setOnClickListener {
            action.actionCompleted.set(true)

        }

    }

    fun SetLeftImage(action:Action)
    {
        var IV : ImageView = view?.findViewById(R.id.IVLeft) as ImageView

        IV.setImageResource(action.resource as Int)

        action.actionCompleted.set(true)
    }

    fun SetRightImage(action:Action)
    {
        var IV : ImageView = view?.findViewById(R.id.IVRight) as ImageView

        IV.setImageResource(action.resource as Int)

        action.actionCompleted.set(true)
    }

    fun ClearImageLeft(action:Action)
    {
        var IV : ImageView = view?.findViewById(R.id.IVLeft) as ImageView

        IV.setImageResource(android.R.color.transparent)

        action.actionCompleted.set(true)
    }

    fun ClearImageRight(action:Action)
    {
        var IV : ImageView = view?.findViewById(R.id.IVRight) as ImageView

        IV.setImageResource(android.R.color.transparent)

        action.actionCompleted.set(true)
    }

    fun ClearImageCenter(action:Action)
    {
        var IV : ImageView = view?.findViewById(R.id.IVCenter) as ImageView

        IV.setImageResource(android.R.color.transparent)

        action.actionCompleted.set(true)
    }

    fun ClearBackgroundColorPrincipalCL(action:Action)
    {
        var cl : ConstraintLayout = view?.findViewById(R.id.CLPrincipal) as ConstraintLayout

        cl.setBackgroundColor(ctx?.resources?.getColor(android.R.color.transparent) as Int)

        action.actionCompleted.set(true)

    }



}