package com.example.employeeagendatest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.employeeagendatest.model.Employee
import com.example.employeeagendatest.model.EmployeeModel
import com.example.employeeagendatest.network.RetrofitInstance
import com.example.employeeagendatest.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EmployeeViewModel: ViewModel() {

    var employeeDataList = MutableLiveData<List<Employee>>()

    fun getApiEmployeeData(){

        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitInstance.getDataFromApiEmployee().enqueue(object : Callback<EmployeeModel> {
            override fun onResponse(
                call: Call<EmployeeModel>,
                response: Response<EmployeeModel>
            ) {
                employeeDataList.value = response.body()?.employees
            }

            override fun onFailure(call: Call<EmployeeModel>, t: Throwable) {

            }

        })

    }
}