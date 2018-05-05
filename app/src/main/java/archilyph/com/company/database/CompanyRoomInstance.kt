package archilyph.com.company.database

import android.arch.persistence.room.Room
import android.content.Context


class CompanyRoomInstance(private val context: Context) {

    val companyRoomDatabase by lazy { Room.databaseBuilder(context, CompanyRoomDatabase::class.java
            , "company").fallbackToDestructiveMigration().allowMainThreadQueries().build() }
}