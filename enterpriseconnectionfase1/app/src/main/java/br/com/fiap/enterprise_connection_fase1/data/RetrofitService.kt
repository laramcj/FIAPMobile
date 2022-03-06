package br.com.fiap.enterprise_connection_fase1.data

import br.com.fiap.enterprise_connection_fase1.AddressData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") CEP: String): Call<AddressData>
}