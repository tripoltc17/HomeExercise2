package at.fh.swengb.tripolt.homeexercise2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Notes(@PrimaryKey val title: String, val content: String) {
}
