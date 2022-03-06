package br.com.fiap.enterprise_connection_fase1.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    val URL: String = "https://viacep.com.br/ws/"
    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitService(): RetrofitService {
        return retrofitFactory.create(RetrofitService::class.java)
    }
}