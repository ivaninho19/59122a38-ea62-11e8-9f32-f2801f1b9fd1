package first.boappok.com.boappok.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import first.boappok.com.boappok.Chapters.Chapter1
import first.boappok.com.boappok.R
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bt : Button = findViewById(R.id.BGoScene)

        bt.setOnClickListener {

                try{
                    var intent = Intent(this,SceneBoardActivity::class.java)

                    startActivity(intent)
                }catch (ex:Exception)
                {
                    Log.i("",ex.message);
                }



        }


        var bt2 : Button = findViewById(R.id.BGoCreator)

        bt2.setOnClickListener {

            try{
                var intent = Intent(this,CreatorActivity::class.java)

                startActivity(intent)
            }catch (ex:Exception)
            {
                Log.i("",ex.message)
            }



        }





    }
}
