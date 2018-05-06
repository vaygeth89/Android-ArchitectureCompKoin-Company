package archilyph.com.company.repository

import android.arch.lifecycle.LiveData
import archilyph.com.company.database.CompanyRoomInstance
import archilyph.com.company.model.Employee

class EmployeeRepository(private val databaseRepository: CompanyRoomInstance) {

    fun insertEmployee(employee: Employee) =
            databaseRepository.companyRoomDatabase.employeeDao().insertEmployee(employee)

    fun getAllEmployees(): LiveData<List<Employee>> =
            databaseRepository.companyRoomDatabase.employeeDao().getAllEmployees()

    fun deleteAllEmployees() =
        databaseRepository.companyRoomDatabase.employeeDao().deleteAllEmployees()

    //Not being used currently in this example project
    fun deleteEmployee(employee: Employee) =
            databaseRepository.companyRoomDatabase.employeeDao().deleteEmployee(employee)
}