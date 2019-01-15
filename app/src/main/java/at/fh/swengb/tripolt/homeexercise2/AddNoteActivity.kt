package at.fh.swengb.tripolt.homeexercise2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*


class AddNoteActivity : AppCompatActivity() {

    annotation class ColumnInfo(val name: String)
    annotation class PrimaryKey
    annotation class Entity(val title: String)

    private lateinit var noteList: List<String>

    lateinit var db: NotesDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = NotesDatabase.getDatabase(this)

        noteList = db.noteDAO.findTitle()
    }

    fun saveNote(v: View) {

        val note = Notes(title_id.text.toString(),content.text.toString())

        if(note.title in noteList){
            db.noteDAO.update(note)
            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }

        else{
            db.noteDAO.insert(note)
            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }
    }
}
