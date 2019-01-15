package at.fh.swengb.tripolt.homeexercise2

import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.note.view.*


class Adapter: RecyclerView.Adapter<NoteViewHolder>() {
    private var noteList = mutableListOf<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val noteItemView = inflater.inflate(R.layout.note, parent, false)
        return NoteViewHolder(noteItemView)
    }

    override fun getItemCount(): Int {
        return noteList.count()
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        viewHolder.bindItem(note)
    }

    fun updateList(newList: List<Notes>) {
        noteList.clear()
        noteList.addAll(newList.toList())
        notifyDataSetChanged()
    }
}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindItem(note: Notes) {
        itemView.note_title.text = note.title
        itemView.content_item.text = note.content
    }
}