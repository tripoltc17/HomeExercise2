package at.fh.swengb.tripolt.homeexercise2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private lateinit var db: NotesDatabase
    private lateinit var adapter: Adapter

    private val noteAdapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("Name", null)
        val savedInt = sharedPreferences.getInt("Age", -1)

        notes_for.text = ("Notes for ${savedString}, ${savedInt}")

        db = NotesDatabase.getDatabase(applicationContext)

        adapter = Adapter()

        recycle_view.layoutManager = LinearLayoutManager(this)
        recycle_view.adapter = adapter

        adapter.updateList(db.noteDAO.findAll())
    }

    fun openAddNoteActivity(v: View) {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }
}

