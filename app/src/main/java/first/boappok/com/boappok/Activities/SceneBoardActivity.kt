package first.boappok.com.boappok.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import first.boappok.com.boappok.Chapters.Chapter1
import first.boappok.com.boappok.Model.ActionCreator
import first.boappok.com.boappok.R

class SceneBoardActivity : AppCompatActivity() {

    companion object {
        lateinit var ActionList:List<ActionCreator>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scene_board)

        Chapter1(ActionList, window.decorView.findViewById(android.R.id.content), this,this@SceneBoardActivity)


    }
}