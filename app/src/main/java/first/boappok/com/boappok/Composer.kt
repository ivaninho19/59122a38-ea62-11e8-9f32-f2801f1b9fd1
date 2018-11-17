package first.boappok.com.boappok

import android.content.Context
import android.media.MediaPlayer
import android.view.View
import android.widget.TextView


open class Composer {



    private var ctx : Context? = null
    private var view : View? = null


    constructor(ctx : Context?,view : View?)
    {
        //Constructor

        this.ctx = ctx
        this.view = view
    }


    fun PlayMedia (obj : Any?)
    {

        var resource : Int = obj as Int

        var mediaPlayer: MediaPlayer? = MediaPlayer.create(ctx, resource)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start() // no need to call prepare(); create() does that for you
    }

    fun SetDownText(content:String)
    {
        var tv : TextView = view?.findViewById(R.id.TVDown) as TextView

        tv.setText(content)

    }


}