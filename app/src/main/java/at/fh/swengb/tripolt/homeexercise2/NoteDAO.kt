package at.fh.swengb.tripolt.homeexercise2

import android.arch.persistence.room.*


@Dao
interface NoteDAO {
    @Insert
    fun insert(note: Notes)

    @Query("SELECT * FROM Notes")
    fun findAll(): List<Notes>

    @Query("SELECT title FROM Notes")
    fun findTitle(): List<String>

    @Update
    fun update(note: Notes)
}