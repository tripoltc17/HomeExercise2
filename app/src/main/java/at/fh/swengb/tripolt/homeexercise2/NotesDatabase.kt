package at.fh.swengb.tripolt.homeexercise2

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract val noteDAO: NoteDAO
    companion object {
        fun getDatabase(context: Context): NotesDatabase {
            return Room.databaseBuilder(context, NotesDatabase::class.java, "note-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
