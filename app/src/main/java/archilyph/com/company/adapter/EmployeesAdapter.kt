package archilyph.com.company.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import archilyph.com.company.R
import archilyph.com.company.model.Employee
import kotlinx.android.synthetic.main.employee_item.view.*


class EmployeesRecyclerViewAdapter(
        private val mValues: MutableList<Employee>)
    : RecyclerView.Adapter<EmployeesRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Employee
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.employee_item, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.employeeNameTxtView.text = "Name: ${item.name}"
        holder.employeeAgeTxtView.text = "Age: ${item.age}"

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val employeeNameTxtView: TextView = mView.employee_name
        val employeeAgeTxtView: TextView = mView.employee_age


    }
}
