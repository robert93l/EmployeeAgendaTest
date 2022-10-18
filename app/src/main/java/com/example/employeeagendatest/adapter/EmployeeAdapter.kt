package com.example.employeeagendatest.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.employeeagendatest.R
import com.example.employeeagendatest.model.Employee

class EmployeeAdapter(private val mList: List<Employee>): RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_item, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.tvName.text = itemsViewModel.full_name
        holder.tvTeam.text = itemsViewModel.team
        holder.tvEmail.text = itemsViewModel.email_address
        holder.tvNumber.text = itemsViewModel.phone_number
        holder.tvSummary.text = itemsViewModel.biography

        Glide
            .with(holder.ivEmployee.context)
            .load(itemsViewModel.photo_url_small)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.ivEmployee)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val ivEmployee: ImageView = itemView.findViewById(R.id.ivEmployee)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvTeam: TextView = itemView.findViewById(R.id.tvTeam)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val tvNumber: TextView = itemView.findViewById(R.id.tvNumber)
        val tvSummary: TextView = itemView.findViewById(R.id.tvSummary)
    }


}