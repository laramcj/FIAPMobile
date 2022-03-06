package br.com.fiap.enterprise_connection_fase1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.enterprise_connection_fase1.data.RetrofitFactory

import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class AddressViewModel : ViewModel() {
    var successLiveData = MutableLiveData<AddressData>()
    var failureLiveData = MutableLiveData<String>()

    fun getAddressByCep(cep: String) {

        val call = RetrofitFactory().retrofitService().getCEP(cep)

        call.enqueue(object : Callback<AddressData> {

            override fun onResponse(call: Call<AddressData>, response: Response<AddressData>) {

                response.body()?.let {
                    successLiveData.postValue(it)
                }

            }

            override fun onFailure(call: Call<AddressData>?, t: Throwable?) {
                failureLiveData.postValue(t?.localizedMessage ?: "Error")
            }
        })
    }
}