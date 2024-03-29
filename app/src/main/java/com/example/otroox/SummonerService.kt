package com.example.otroox

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SummonerService constructor(
    private val webservice: SummonerWebService
){
        fun getInvocateur(pseudo:String, onDone: (Sumoner)->Unit, onError: (Throwable)->Unit ) {
            webservice.getInvocateur(pseudo).enqueue(object : Callback<Sumoner> {
                override fun onResponse(
                    call: Call<Sumoner>,
                    response: Response<Sumoner>
                ) {
                    val sumoner =  response.body()!!

                    onDone(sumoner)
                }
                override fun onFailure(call: Call<Sumoner>, t: Throwable) {
                    onError(t)

            }
        })
    }
}