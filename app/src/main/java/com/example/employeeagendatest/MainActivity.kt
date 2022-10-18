package com.example.employeeagendatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeeagendatest.adapter.EmployeeAdapter
import com.example.employeeagendatest.databinding.ActivityMainBinding
import com.example.employeeagendatest.model.Employee
import com.example.employeeagendatest.viewmodel.EmployeeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

   lateinit var employeeInitViewModel: EmployeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadData()
    }

    fun loadData(){
        employeeInitViewModel = ViewModelProvider(this)[EmployeeViewModel::class.java]
        employeeInitViewModel.getApiEmployeeData()
        employeeInitViewModel.employeeDataList.observe(this, Observer {
            initAdapter(it)
        })
    }

    fun initAdapter(data: List<Employee>){
        binding.rvEmployees.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        val adapter = EmployeeAdapter(data)
        // Setting the Adapter with the recyclerview
        binding.rvEmployees.adapter = adapter
    }
}