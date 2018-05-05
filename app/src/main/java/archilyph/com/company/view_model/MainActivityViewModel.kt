package archilyph.com.company.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import archilyph.com.company.model.Employee
import archilyph.com.company.repository.EmployeeRepository

class MainActivityViewModel(private val employeeRepository: EmployeeRepository)
    : ViewModel(){

    private val TAQ = "MainActivityViewModel"
    lateinit var employees : LiveData<List<Employee>>


    fun insertEmployee(employee: Employee) = employeeRepository.insertEmployee(employee)


    fun deleteAllEmployees() = employeeRepository.deleteAllEmployees()

    fun setUpEmployees() : LiveData<List<Employee>>{
        employees = employeeRepository.getAllEmployees()
        Log.d(TAQ, employees.value?.size.toString())
        //Notice that I tend to avoid null check in this project
        if (employees.value?.size == 0){
            /*
            In case there's no records found on database
            Let it returns empty list so app handles it gracefully
            and avoids null checks on the views like recycleview
            when getting the size
            */
            val emptyList = MutableLiveData<List<Employee>>()
            emptyList.value = emptyList()
        }
        return employees
    }

}