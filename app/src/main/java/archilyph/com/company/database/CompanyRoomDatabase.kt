package archilyph.com.company.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import archilyph.com.company.dao.EmployeeDao
import archilyph.com.company.model.Employee

@Database(entities = [Employee::class], version = 2)
abstract class CompanyRoomDatabase : RoomDatabase(){

    abstract fun employeeDao(): EmployeeDao

}