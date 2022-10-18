package com.example.employeeagendatest.network



import com.example.employeeagendatest.model.EmployeeModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("sq-mobile-interview/employees.json")
    fun getDataFromApiEmployee(): Call<EmployeeModel>

    @GET("sq-mobile-interview/employees_malformed.json")
    fun getDataMalformed(): Call<EmployeeModel>

    @GET("sq-mobile-interview/employees_empty.json")
    fun getDataEmpty(): Call<EmployeeModel>

}