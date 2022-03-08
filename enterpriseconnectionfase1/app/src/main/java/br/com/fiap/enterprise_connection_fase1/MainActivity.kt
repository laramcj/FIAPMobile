package br.com.fiap.enterprise_connection_fase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    var editCEP: EditText? = null
    var buttonSearch: Button? = null
    var viewModel: AddressViewModel = AddressViewModel()
    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editCEP = findViewById(R.id.cep)
        textView = findViewById(R.id.txt_answer)
        buttonSearch = findViewById(R.id.send)
        buttonSearch?.setOnClickListener {
            editCEP?.let {
                viewModel.getAddressByCep(it.text.toString())
            }
        }
        observe()
    }

    fun observe() {
        viewModel.successLiveData.observe(this) {
            Toast.makeText(this, it.localidade, Toast.LENGTH_LONG).show()
            textView?.text =
                "${it.cep} ${it.logradouro} ${it.complemento} ${it.bairro} ${it.localidade} ${it.uf}"
        }
        viewModel.failureLiveData.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

}