package first.boappok.com.boappok.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import first.boappok.com.boappok.Chapters.Chapter1
import first.boappok.com.boappok.R

class SceneBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scene_board)



        Chapter1(this, window.decorView.findViewById(android.R.id.content), this)


    }
}