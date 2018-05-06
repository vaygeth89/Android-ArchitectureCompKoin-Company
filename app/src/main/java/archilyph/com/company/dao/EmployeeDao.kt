package archilyph.com.company.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import archilyph.com.company.model.Employee

@Dao
interface EmployeeDao {

    @Insert
    fun insertEmployee(employee: Employee)

    @Query("SELECT * FROM employees")
    fun getAllEmployees(): LiveData<List<Employee>>

    @Query("DELETE FROM employees")
    fun deleteAllEmployees()

}