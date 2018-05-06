package archilyph.com.company.database

import android.arch.persistence.room.Room
import android.content.Context


class CompanyRoomInstance(private val context: Context) {

    val companyRoomDatabase by lazy {
        Room.databaseBuilder(context, CompanyRoomDatabase::class.java
                , "company").fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    /*
    Purpose of this separation from RoomDatabase is to decouple it from it's main class
    providing a flexible way to employ several different databases in-case you need several ones

    Similar to
    val otherRoomDatabase by lazy { Room.databaseBuilder(context, OtherRoomDatabase::class.java
          , "other-database").fallbackToDestructiveMigration().allowMainThreadQueries().build() }
    */
}