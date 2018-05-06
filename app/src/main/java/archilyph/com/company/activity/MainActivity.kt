package archilyph.com.company.activity

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import archilyph.com.company.R
import archilyph.com.company.adapter.EmployeesRecyclerViewAdapter
import archilyph.com.company.model.Employee
import archilyph.com.company.view_model.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {


    private val mainActivityViewModel: MainActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employee_list.layoutManager = LinearLayoutManager(this)
        mainActivityViewModel.setUpEmployees().observe(this, Observer { employees ->
            employee_list.adapter = EmployeesRecyclerViewAdapter(employees as MutableList<Employee>)

        })

        add_employees.setOnClickListener {
            addOneEmployees()
        }

        delete_employee.setOnClickListener {
            deleteAllEmployee()
        }

    }

    private fun deleteAllEmployee() {
        try {
            mainActivityViewModel.deleteAllEmployees()
        } catch (e: Exception) {
            throw e
        }
    }

    private fun addOneEmployees()=
        mainActivityViewModel.insertEmployee(
                Employee(null, name = "Employee", age = Random().nextInt((100-16)-16) ))


}
