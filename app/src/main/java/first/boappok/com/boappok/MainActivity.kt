package first.boappok.com.boappok

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import first.boappok.com.boappok.Chapters.Chapter1
import first.boappok.com.boappok.Model.Chapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Chapter1(this, window.decorView.findViewById(android.R.id.content))



    }
}
