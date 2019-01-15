package at.fh.swengb.tripolt.homeexercise2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PatternMatcher
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openNoteListActivityWithValues(v: View) {

        for (i in name.text){
            if (! i.isLetter())
                name.setText("")
                name.setHint("Wrong Name!")
        }

        if(name.text.replace("\\s+".toRegex(),"").isEmpty()){
            name.setText("")
            name.setHint("Wrong Name!")
        }
        else if(age.text.isEmpty()){
            age.setHint("Wrong Age!")
        }
        else{
            getSharedPreferences(packageName, Context.MODE_PRIVATE)

            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

            sharedPreferences.edit().putString("Name", name.text.toString()).apply()
            sharedPreferences.edit().putInt("Age", age.text.toString().toInt()).apply()

            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }
    }
}